package Gabri.Dev.com.repositories;


import Gabri.Dev.com.entities.PropietarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropietarioRepository extends JpaRepository< PropietarioEntity, Long> {
}
