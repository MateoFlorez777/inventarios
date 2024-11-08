package softwares.inventarios.entities;


import java.time.LocalTime;
import java.util.Date;

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

@Table(name = "Cita")
public class Cita {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    Integer Id_Cita;
    Date Fecha_Cita;
    LocalTime Hora_Cita;
    String Estado;
    String Descripcion;



}
