package Gabri.Dev.com.controllers;

import Gabri.Dev.com.models.Factura;
import Gabri.Dev.com.models.enums.Ciclo;
import Gabri.Dev.com.services.impl.FacturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaServiceImpl facturaService;

    @PostMapping
    public ResponseEntity<List<Factura>> createFacturas(
            @RequestParam Ciclo ciclo,
            @RequestParam Integer anio) {
        List<Factura> facturas = facturaService.crearFacturas(ciclo, anio);
        return ResponseEntity.ok(facturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> getFacturaById(@PathVariable Long id) {
        Factura factura = facturaService.mostrarFactura(id);
        return ResponseEntity.ok(factura);
    }

}
