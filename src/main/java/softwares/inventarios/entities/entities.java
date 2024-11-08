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

@Table(name = "entities")
public class entities {

    

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    Integer id_Producto;
    String nombre_Producto;
    String descripcion;
    Integer cantidad_Unidad;
    Double precio_Unidad;
    Integer stock;
    String estado_Producto;
    
}
