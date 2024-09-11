package Gabri.Dev.com.entities;

import Gabri.Dev.com.models.enums.Ciclo;
import Gabri.Dev.com.models.enums.TipoCargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * entidad dedicada a registrar unicamente un cargo en una fecha determinada
 */
@Entity
@Table(name = "cargo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CargoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * que tipo de cargo es? multa? proveedores? servicio? etc
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_expensa")
    private TipoCargo tipoExpensa;

    /**
     * una descripcion, representacion mas fiel de porque se aplica este cargo
     */
    @Column(name = "detalle")
    private String Detalle;

    /**
     * se indica un precio que es el que se tiene que pagar
     */
    @Column(name = "monto")
    private Float monto;

    /**
     * ciclo en la cual pertenezca y se deba cobrar este cargo
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "ciclo")
    private Ciclo ciclo;

    /**
     * año en el que se deba cobrar este cargo
     */
    @Column(name = "anio")
    private Integer anio;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private PropietarioEntity propietario;
}
