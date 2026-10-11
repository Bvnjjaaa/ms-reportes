package cl.novabank.reportes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reportes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El titulo es obligatorio")
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "El tipo de reporte es obligatorio")
    @Column(name = "tipo_reporte", nullable = false)
    private String tipoReporte;

    @NotBlank(message = "El campo generadoPor es obligatorio")
    @Column(name = "generado_por", nullable = false)
    private String generadoPor;

    @Column(name = "fecha_generacion")
    private LocalDateTime fechaGeneracion;

    @Column(length = 1000)
    private String parametros;

    @Column(nullable = false)
    private String estado;
}
