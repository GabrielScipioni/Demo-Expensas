package Gabri.Dev.com.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detalle")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre_expensa")
    private String nombreExpensa;

    @Column(name = "total_lineal")
    private Float totalLineal;

    @ManyToOne
    @JoinColumn(name = "factura")
    private FacturaEntity factura;
}
