package cl.duoc.jv0101.caso04.reportes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import cl.duoc.jv0101.caso04.reportes.model.Reporte;
import cl.duoc.jv0101.caso04.reportes.repository.ReporteRepository;

@Service
public class ReporteService {

    private final ReporteRepository repository;

    public ReporteService(ReporteRepository repository) {
        this.repository = repository;
    }

    public List<Reporte> findAll() {
        return repository.findAll();
    }

    public Optional<Reporte> findById(Long id) {
        return repository.findById(id);
    }

    public Reporte create(Reporte recurso) {
        return repository.save(recurso);
    }

    public Optional<Reporte> update(Long id, Reporte datos) {
        return repository.findById(id).map(existente -> {
            existente.setNombre(datos.getNombre());
            existente.setPeriodo(datos.getPeriodo());
            existente.setTipo(datos.getTipo());
            return repository.save(existente);
        });
    }

    public boolean delete(Long id) {
        return repository.findById(id).map(existente -> {
            repository.delete(existente);
            return true;
        }).orElse(false);
    }
}
