package cl.novabank.reportes.controller;

import cl.novabank.reportes.model.Reporte;
import cl.novabank.reportes.service.ReporteService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    @PostMapping("/generar")
    @ResponseStatus(HttpStatus.CREATED)
    public Reporte generarReporte(@Valid @RequestBody Reporte reporte) {
        return reporteService.generarReporte(reporte);
    }

    @GetMapping({"", "/"})
    public List<Reporte> listarTodos() {
        return reporteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Reporte obtenerPorId(@PathVariable Long id) {
        return reporteService.obtenerPorId(id);
    }

    @GetMapping("/tipo/{tipoReporte}")
    public List<Reporte> listarPorTipo(@PathVariable String tipoReporte) {
        return reporteService.listarPorTipo(tipoReporte);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarReporte(@PathVariable Long id) {
        reporteService.eliminarReporte(id);
    }
}
