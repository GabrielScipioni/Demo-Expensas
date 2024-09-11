package Gabri.Dev.com.services.impl;

import Gabri.Dev.com.entities.FacturaEntity;
import Gabri.Dev.com.entities.HistoricoEntity;
import Gabri.Dev.com.models.Historico;
import Gabri.Dev.com.repositories.HistoricoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HistoricoServiceImpl {

    @Autowired
    private HistoricoRepository historicoRepository;
@Autowired
private FacturaServiceImpl facturaService;
    @Autowired
    private ModelMapper modelMapper;

    public void crearHistorico(FacturaEntity factura,Float montoPagado){
        HistoricoEntity historico = new HistoricoEntity();
        historico.setFactura(factura);
        historico.setFechaCreacion(factura.getFechaCreacion());
        historico.setFechaModificacion(LocalDate.now());
        historico.setMontoPagado(montoPagado);
        historicoRepository.save(historico);
    }
    public List<HistoricoEntity> mostrarTodosHistoricosByFactura(Long id){
        return historicoRepository.findAll();
    }
}
