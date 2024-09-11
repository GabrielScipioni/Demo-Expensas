package Gabri.Dev.com.services.impl;

import Gabri.Dev.com.entities.CargoEntity;
import Gabri.Dev.com.entities.DetalleEntity;
import Gabri.Dev.com.entities.FacturaEntity;
import Gabri.Dev.com.models.Cargo;
import Gabri.Dev.com.models.Detalle;
import Gabri.Dev.com.models.Factura;
import Gabri.Dev.com.models.enums.Ciclo;
import Gabri.Dev.com.repositories.DetalleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetalleServiceImpl {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CargoServiceImpl cargoService;
    @Autowired
    private DetalleRepository detalleRepository;
    @Autowired
    private PropietarioServiceImpl propietarioService;


    public void dividirMontosExpensas(FacturaEntity factura, Ciclo ciclo, Integer anio) {
        List<Cargo> cargos = cargoService.findCargosByAnioAndCicloExcludingMultas(anio, ciclo);
        int numeroProp = propietarioService.findAll().size();

        for (Cargo c : cargos){
            DetalleEntity detalle = new DetalleEntity();
            detalle.setNombreExpensa(c.getTipoExpensa().toString()+": "+c.getDetalle());
            float monto = (c.getMonto()/numeroProp);
            detalle.setTotalLineal(monto);
            detalle.setFactura(factura);
            detalleRepository.save(detalle);
        }
    }

    public void asignarDetalleMultas(FacturaEntity factura, Ciclo ciclo, Integer anio) {
        List<Cargo> cargos = cargoService.findCargosByPropietarioAndAnioAndCicloWithMulta(anio, ciclo, factura.getPropietario().getId());
        if (cargos.size() == 0){
            return;
        }

        for (Cargo c : cargos){
            DetalleEntity detalle = new DetalleEntity();
            detalle.setNombreExpensa(c.getTipoExpensa().toString()+": "+c.getDetalle());
            detalle.setTotalLineal(c.getMonto());
            detalle.setFactura(factura);
            detalleRepository.save(detalle);
        }
    }

    @Autowired
    private FacturaServiceImpl factura;

    public List<Detalle> findAllByFactura(Long facturaID){
        FacturaEntity facturaEntity = modelMapper.map(factura.mostrarFactura(facturaID),FacturaEntity.class);
        List<DetalleEntity> detalles = detalleRepository.findAllByFactura(facturaEntity);
        return mapToDetalle(detalles);
    }
    public Float montoByFactura(FacturaEntity factura){
        List<DetalleEntity> detalles = detalleRepository.findAllByFactura(factura);
        float aux = 0;
        for (DetalleEntity d : detalles){
            aux =+ d.getTotalLineal();
        }
        return aux;
    }


    private List<Detalle> mapToDetalle(List<DetalleEntity> detallesResult) {
        List<Detalle> detallesMappeados = new ArrayList<>();
        for (DetalleEntity c : detallesResult) {
            detallesMappeados.add(modelMapper.map(c, Detalle.class));
        }
        return detallesMappeados;
    }
}
