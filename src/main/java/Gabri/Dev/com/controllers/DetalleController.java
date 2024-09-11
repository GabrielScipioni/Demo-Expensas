package Gabri.Dev.com.controllers;

import Gabri.Dev.com.models.Detalle;
import Gabri.Dev.com.services.impl.DetalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles")
public class DetalleController {

    @Autowired
    private DetalleServiceImpl detalleService;

    @GetMapping
    public ResponseEntity<List<Detalle>> getDetallesByFactura(@RequestParam Long facturaId) {
        List<Detalle> detalles = detalleService.findAllByFactura(facturaId);
        return ResponseEntity.ok(detalles);
    }
}
