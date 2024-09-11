package Gabri.Dev.com.controllers;

import Gabri.Dev.com.dtos.CargoDto;
import Gabri.Dev.com.models.Cargo;
import Gabri.Dev.com.services.impl.CargoServiceImpl;
import Gabri.Dev.com.models.enums.Ciclo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    @Autowired
    private CargoServiceImpl cargoService;
    @Qualifier("modelMapper")
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> createCargo(@RequestBody CargoDto cargo) {
        cargoService.CargarCargos(modelMapper.map(cargo,Cargo.class));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cargo>> getCargos(
            @RequestParam(required = false) Integer anio,
            @RequestParam(required = false) Ciclo ciclo,
            @RequestParam(required = false) Long propietarioId) {

        List<Cargo> cargos;
        if (propietarioId != null) {
            cargos = cargoService.findCargosByPropietarioAndAnioAndCicloWithMulta(anio, ciclo, propietarioId);
        } else {
            cargos = cargoService.findCargosByAnioAndCicloExcludingMultas(anio, ciclo);
        }
        return ResponseEntity.ok(cargos);
    }
}
