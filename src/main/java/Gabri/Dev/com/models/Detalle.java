package Gabri.Dev.com.models;

import jakarta.persistence.*;
import lombok.*;

@Data
public class Detalle {
    private Long id;

    private String nombreExpensa;

    private Float totalLineal;

    private Factura factura;
}
