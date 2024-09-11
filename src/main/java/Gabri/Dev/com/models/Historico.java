package Gabri.Dev.com.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
public class Historico {
    private Long id;

    private Factura factura;

    private LocalDate fechaCreacion;

    private LocalDate fechaModificacion;

    private Float montoPagado;
}
