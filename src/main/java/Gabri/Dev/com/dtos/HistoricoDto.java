package Gabri.Dev.com.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HistoricoDto {

    private FacturaDto factura;

    private LocalDate fechaCreacion;

    private LocalDate fechaModificacion;

    private Float montoPagado;
}
