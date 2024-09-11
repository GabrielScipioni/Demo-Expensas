package Gabri.Dev.com.dtos;

import Gabri.Dev.com.models.enums.Ciclo;
import Gabri.Dev.com.models.enums.TipoCargo;
import lombok.Data;

@Data
public class CargoDto {

    private TipoCargo tipoExpensa;

    private String Detalle;

    private Float monto;

    private Ciclo ciclo;

    private Integer anio;
}
