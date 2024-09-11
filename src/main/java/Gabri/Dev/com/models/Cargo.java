package Gabri.Dev.com.models;

import Gabri.Dev.com.models.enums.Ciclo;
import Gabri.Dev.com.models.enums.TipoCargo;
import jakarta.persistence.*;
import lombok.*;

@Data
public class Cargo {
    private Long id;

    private TipoCargo tipoExpensa;

    private String Detalle;

    private Float monto;

    private Ciclo ciclo;

    private Integer anio;
}
