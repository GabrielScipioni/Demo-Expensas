package Gabri.Dev.com.repositories;

import Gabri.Dev.com.entities.CargoEntity;
import Gabri.Dev.com.models.enums.Ciclo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<CargoEntity, Long> {

    @Query("SELECT c FROM CargoEntity c WHERE c.anio = :anio AND c.ciclo = :ciclo AND c.tipoExpensa <> 'MULTA'")
    List<CargoEntity> findCargosByAnioAndCicloExcludingMultas(@Param("anio") Integer anio, @Param("ciclo") Ciclo ciclo);

    @Query("SELECT c FROM CargoEntity c WHERE c.propietario.id = :propietario AND c.anio = :anio AND c.ciclo = :ciclo AND c.tipoExpensa = 'MULTA'")
    List<CargoEntity> findCargosByPropietarioAndAnioAndCicloWithMulta(@Param("propietario") Long propietario, @Param("anio") Integer anio, @Param("ciclo") Ciclo ciclo);
}
