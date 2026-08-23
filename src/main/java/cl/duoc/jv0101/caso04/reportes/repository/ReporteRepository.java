package cl.duoc.jv0101.caso04.reportes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.duoc.jv0101.caso04.reportes.model.Reporte;

public interface ReporteRepository extends JpaRepository<Reporte, Long> {
}
