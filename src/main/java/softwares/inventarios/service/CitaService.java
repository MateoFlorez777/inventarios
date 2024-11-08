package softwares.inventarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import softwares.inventarios.entities.Cita;
import softwares.inventarios.repository.CitaRepository;


@Service
public class CitaService implements Id_CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public Cita buscarCitaPorId(Integer Id_Cita) {
        Cita citas = this.citaRepository.findById(Id_Cita).orElse(null);
        return citas;
    }

    @Override
    public void eliminarCita(Integer Id_Cita) {
        this.citaRepository.deleteById(Id_Cita);
        
    }

    @Override
    public Cita guardarCita(Cita citas) {
        return this.citaRepository.save(citas);
    }

    @Override
    public List<Cita> listarCitas() {
        this.citaRepository.findAll();
        return this.citaRepository.findAll();
        
    }

}
