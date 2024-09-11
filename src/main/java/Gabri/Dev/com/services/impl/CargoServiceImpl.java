package Gabri.Dev.com.services.impl;

import Gabri.Dev.com.entities.CargoEntity;
import Gabri.Dev.com.models.Cargo;
import Gabri.Dev.com.models.enums.Ciclo;
import Gabri.Dev.com.repositories.CargoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargoServiceImpl {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private ModelMapper modelMapper;

    private List<Cargo> mapToCargo(List<CargoEntity> cargosResult) {
        List<Cargo> cargosMappeados = new ArrayList<>();
        for (CargoEntity c : cargosResult) {
            cargosMappeados.add(modelMapper.map(c, Cargo.class));
        }
        return cargosMappeados;
    }

    public List<Cargo> findCargosByAnioAndCicloExcludingMultas(Integer anio, Ciclo ciclo) {
        List<CargoEntity> cargosResult = cargoRepository.findCargosByAnioAndCicloExcludingMultas(anio, ciclo);
        return mapToCargo(cargosResult);
    }

    public List<Cargo> findCargosByPropietarioAndAnioAndCicloWithMulta(Integer anio, Ciclo ciclo, Long prop) {
        List<CargoEntity> cargosResult = cargoRepository.findCargosByPropietarioAndAnioAndCicloWithMulta(prop, anio, ciclo);
        return mapToCargo(cargosResult);
    }
    public void CargarCargos(Cargo cargo){
        cargoRepository.save(modelMapper.map(cargo,CargoEntity.class));
    }
}


