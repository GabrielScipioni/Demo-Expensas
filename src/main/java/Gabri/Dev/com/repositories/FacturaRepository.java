package Gabri.Dev.com.repositories;

import Gabri.Dev.com.entities.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository <FacturaEntity,Long > {
}
