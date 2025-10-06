package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estudiantes")
@Getter
@Setter
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_estudiante", length = 100, nullable = false)
    private String nombre;
    @Column(name = "apellido_estudiante", length = 100, nullable = false)
    private String apellido;
    @Column(name = "cif_estudiante", length = 8, nullable = false)
    private String CIF;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Estudiante{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", CIF='").append(CIF).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
