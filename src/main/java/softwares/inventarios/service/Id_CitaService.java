package softwares.inventarios.service;

import java.util.List;

import softwares.inventarios.entities.Cita;


public interface Id_CitaService {

    public List<Cita> listarCitas();

    public Cita buscarCitaPorId(Integer Id_Cita);

    public Cita guardarCita(Cita Cita);

    public void eliminarCita(Integer Id_Cita);
}
