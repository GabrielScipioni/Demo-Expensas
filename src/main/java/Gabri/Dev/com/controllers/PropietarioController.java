package Gabri.Dev.com.controllers;

import Gabri.Dev.com.models.Propietario;
import Gabri.Dev.com.services.impl.PropietarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioServiceImpl propietarioService;

    @GetMapping
    public ResponseEntity<List<Propietario>> getAllPropietarios() {
        List<Propietario> propietarios = propietarioService.findAllprop();
        return ResponseEntity.ok(propietarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Propietario> getPropietarioById(@PathVariable Long id) {
        Optional<Propietario> propietario = propietarioService.findPropietario(id);
        return propietario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
