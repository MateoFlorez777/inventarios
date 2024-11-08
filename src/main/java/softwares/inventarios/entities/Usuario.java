package softwares.inventarios.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)


    Integer id_Usuario;
    String nombre_Usuario;
    String contraseña_Usuario;

}
