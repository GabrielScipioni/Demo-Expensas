package Gabri.Dev.com.models;

import lombok.*;

import java.time.LocalDate;

@Data
public class Factura {

    private Long id;

    private Float monto;

    private LocalDate fechaCreacion;

    private Propietario propietario;

    private LocalDate fechaPago;

    private Float montoPagado;
}
