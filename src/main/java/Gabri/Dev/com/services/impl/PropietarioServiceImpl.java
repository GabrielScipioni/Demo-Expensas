package Gabri.Dev.com.services.impl;

import Gabri.Dev.com.entities.CargoEntity;
import Gabri.Dev.com.entities.DetalleEntity;
import Gabri.Dev.com.entities.PropietarioEntity;
import Gabri.Dev.com.models.Cargo;
import Gabri.Dev.com.models.Detalle;
import Gabri.Dev.com.models.Propietario;
import Gabri.Dev.com.repositories.PropietarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropietarioServiceImpl {

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PropietarioEntity> findAll(){
        return propietarioRepository.findAll();
    }
    public List<Propietario> findAllprop(){
        return mapToPropietarios(propietarioRepository.findAll());
    }

    private List<Propietario> mapToPropietarios(List<PropietarioEntity> propietarioEntities) {
        List<Propietario> propMappeados = new ArrayList<>();
        for (PropietarioEntity c : propietarioEntities) {
            propMappeados.add(modelMapper.map(c, Propietario.class));
        }
        return propMappeados;
    }
    public Optional<Propietario> findPropietario(Long id){
        return Optional.of(modelMapper.map(propietarioRepository.findById(id),Propietario.class));
    }
}
