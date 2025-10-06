package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "eventos")
@Getter @Setter
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idevento;
    @Column(name = "nombre_evento", length = 100, nullable = false)
    private String nombre;
    @Column(name = "fecha_evento", length = 50, nullable = false)
    private String fecha;
    @Column(name = "lugar_evento", length = 100, nullable = false)
    private String lugar;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Evento{");
        sb.append("idevento=").append(idevento);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", fecha='").append(fecha).append('\'');
        sb.append(", lugar='").append(lugar).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
