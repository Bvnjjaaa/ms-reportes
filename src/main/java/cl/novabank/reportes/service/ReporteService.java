package cl.novabank.reportes.service;

import cl.novabank.reportes.model.Reporte;
import cl.novabank.reportes.repository.ReporteRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final ReporteRepository reporteRepository;

    @Transactional
    public Reporte generarReporte(Reporte reporte) {
        reporte.setId(null);
        reporte.setFechaGeneracion(LocalDateTime.now());
        reporte.setEstado("GENERADO");
        return reporteRepository.save(reporte);
    }

    @Transactional(readOnly = true)
    public Reporte obtenerPorId(Long id) {
        return reporteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reporte no encontrado: " + id));
    }

    @Transactional
    public Reporte actualizarReporte(Long id, Reporte datos) {
        Reporte reporte = obtenerPorId(id);
        reporte.setTitulo(datos.getTitulo());
        reporte.setTipoReporte(datos.getTipoReporte());
        reporte.setGeneradoPor(datos.getGeneradoPor());
        reporte.setParametros(datos.getParametros());
        return reporte;
    }

    @Transactional(readOnly = true)
    public List<Reporte> listarPorTipo(String tipoReporte) {
        return reporteRepository.findByTipoReporte(tipoReporte);
    }

    @Transactional(readOnly = true)
    public List<Reporte> listarTodos() {
        return reporteRepository.findAll();
    }

    @Transactional
    public void eliminarReporte(Long id) {
        if (!reporteRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reporte no encontrado: " + id);
        }
        reporteRepository.deleteById(id);
    }
}
