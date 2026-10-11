package cl.novabank.reportes.repository;

import cl.novabank.reportes.model.Reporte;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Long> {

    List<Reporte> findByTipoReporte(String tipoReporte);

    List<Reporte> findByGeneradoPor(String generadoPor);

    List<Reporte> findByEstado(String estado);
}
