package Gabri.Dev.com.dtos;

import lombok.Data;

@Data
public class DetalleDto {

    private String nombreExpensa;

    private Float totalLineal;

    private FacturaDto factura;
}
