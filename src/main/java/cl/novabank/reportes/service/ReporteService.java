package cl.novabank.reportes.service;

import cl.novabank.reportes.model.Reporte;
import cl.novabank.reportes.repository.ReporteRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con id: " + id));
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
            throw new RuntimeException("Reporte no encontrado con id: " + id);
        }
        reporteRepository.deleteById(id);
    }
}
