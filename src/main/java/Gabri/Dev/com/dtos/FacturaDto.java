package Gabri.Dev.com.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FacturaDto {


    private Float monto;

    private LocalDate fechaCreacion;

    private PropietarioDto propietario;

    private LocalDate fechaPago;

    private Float montoPagado;
}
