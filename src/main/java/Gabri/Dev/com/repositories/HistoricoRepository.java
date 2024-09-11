package Gabri.Dev.com.repositories;

import Gabri.Dev.com.entities.FacturaEntity;
import Gabri.Dev.com.entities.HistoricoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoRepository extends JpaRepository< HistoricoEntity,Long> {
    List<HistoricoEntity> findAllByFactura(FacturaEntity factura);
}
