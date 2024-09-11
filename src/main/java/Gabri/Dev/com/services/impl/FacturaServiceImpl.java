package Gabri.Dev.com.services.impl;

import Gabri.Dev.com.entities.DetalleEntity;
import Gabri.Dev.com.entities.FacturaEntity;
import Gabri.Dev.com.entities.HistoricoEntity;
import Gabri.Dev.com.entities.PropietarioEntity;
import Gabri.Dev.com.models.Detalle;
import Gabri.Dev.com.models.Factura;
import Gabri.Dev.com.models.enums.Ciclo;
import Gabri.Dev.com.repositories.FacturaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;


@Service
public class FacturaServiceImpl {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private HistoricoServiceImpl historicoService;
    @Autowired
    private DetalleServiceImpl detalleService;

    @Autowired
    private PropietarioServiceImpl propietarioService;

    @Autowired
    private ModelMapper modelMapper;

    private List<Factura> generarFacturas(LocalDate fechaPago) {
        List<PropietarioEntity> todosLosPropietarios = propietarioService.findAll();
        List<Factura> facturas = new ArrayList<>();
        for (PropietarioEntity p : todosLosPropietarios){
            FacturaEntity f = new FacturaEntity();
            f.setFechaCreacion(LocalDate.now());
            f.setPropietario(p);
            f.setFechaPago(fechaPago);
            f.setMontoPagado(0F);
            FacturaEntity facturaCreada = facturaRepository.save(f);
            historicoService.crearHistorico(facturaCreada,0F);
            facturas.add(modelMapper.map(facturaCreada,Factura.class));
        }
        return facturas;
    }

    private void actualizarMonto(FacturaEntity factura, Ciclo ciclo, Integer anio) {
        detalleService.dividirMontosExpensas(factura, ciclo, anio);
        detalleService.asignarDetalleMultas(factura,ciclo,anio);
        factura.setMonto(detalleService.montoByFactura(factura));
    }

    public List<Factura> crearFacturas(Ciclo ciclo, Integer anio){
        LocalDate fecha =generarFechaPago(ciclo, anio);
        List<Factura> facturas = generarFacturas(fecha);
        List<FacturaEntity> facturaEntities = new ArrayList<>();
        for (Factura f : facturas){
            FacturaEntity factura = modelMapper.map(f,FacturaEntity.class);
            actualizarMonto(factura,ciclo,anio);
            facturaEntities.add(factura);
        }
        return mapToFactura(facturaEntities);
    }
    private List<Factura> mapToFactura(List<FacturaEntity> facturaResult) {
        List<Factura> facturasMappeados = new ArrayList<>();
        for (FacturaEntity f : facturaResult) {
            facturasMappeados.add(modelMapper.map(f, Factura.class));
        }
        return facturasMappeados;
    }
    private LocalDate generarFechaPago(Ciclo ciclo, Integer anio) {
        // Obtener el mes del ciclo
        Month mesPago = ciclo.getMonth();
        // Crear el año
        Year anioPago = Year.of(anio);
        // Crear la fecha para el 10 de cada mes o ciclo
        LocalDate fechaPago = LocalDate.of(anioPago.getValue(), mesPago, 10);

        return fechaPago;
    }

/*
    public void pagarFactura(Long facturaId, Float montoPagado) {
        FacturaEntity factura = facturaRepository.findById(facturaId)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));

        // Crear un nuevo historico
        HistoricoEntity historico = new HistoricoEntity();
        historico.setFactura(factura);
        historico.setFechaCreacion(LocalDate.now());
        historico.setFechaModificacion(LocalDate.now());
        historico.setMontoPagado(montoPagado);
        historicoRepository.save(historico);

        // Actualizar monto pagado en la factura
        Float montoTotalPagado = factura.getMontoPagado() != null ? factura.getMontoPagado() + montoPagado : montoPagado;
        factura.setMontoPagado(montoTotalPagado);
        factura.setFechaPago(LocalDate.now());
        facturaRepository.save(factura);
    }*/
    public Factura mostrarFactura(Long id){
        return modelMapper.map(facturaRepository.findById(id),Factura.class);
    }
}
