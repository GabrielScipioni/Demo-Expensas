package Gabri.Dev.com.repositories;

import Gabri.Dev.com.entities.DetalleEntity;
import Gabri.Dev.com.entities.FacturaEntity;
import Gabri.Dev.com.models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleRepository extends JpaRepository< DetalleEntity,Long> {
    List<DetalleEntity> findAllByFactura(FacturaEntity factura);
}
