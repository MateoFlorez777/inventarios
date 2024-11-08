package softwares.inventarios.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import softwares.inventarios.entities.Cita;
import softwares.inventarios.exception.RecursoNoEncontradoExeption;
import softwares.inventarios.service.CitaService;



@RestController
//http://localhost:8081/cita/
@RequestMapping("/cita")
@CrossOrigin(value = "http://localhost:3000")

public class CitaController {


     private static final org.slf4j.Logger logger =
            LoggerFactory.getLogger(CitaController.class);

    @Autowired
    private CitaService citaservice;


    @GetMapping("/citas")
    public List<Cita> obtenerCitas() {
        List<Cita> citas = this.citaservice.listarCitas();
        logger.info("Listando todas las citas");
        citas.forEach((Cita -> logger.info(Cita.toString())));
        return citas;
    }


    @GetMapping("/citas/{Id_Cita}")
    public ResponseEntity<Cita> obtenerCitaPorId(
        @PathVariable Integer Id_Cita){
            Cita citas = 
                this.citaservice.buscarCitaPorId(Id_Cita);
            if(citas != null){
                return ResponseEntity.ok(citas);
                
            }else {
                throw new RecursoNoEncontradoExeption("No se encontró la citas con id" + Id_Cita);
            }
            
    }


    @PostMapping("/citas")
    public Cita agregarCita(@RequestBody Cita citas) {
        logger.info("citas a agregar: " + citas);
        return this.citaservice.guardarCita(citas);
    }



    @PutMapping("/citas/{Id_Cita}")
    public ResponseEntity<Cita> actualizarCitaPorId(
            @PathVariable Integer Id_Cita,
            @RequestBody Cita citaRecibida) {

        Cita citas = this.citaservice.buscarCitaPorId(Id_Cita);
        citas.setFecha_Cita(citaRecibida.getFecha_Cita());
        citas.setHora_Cita(citaRecibida.getHora_Cita());
        citas.setEstado(citaRecibida.getEstado());
        citas.setDescripcion(citaRecibida.getDescripcion());
        this.citaservice.guardarCita(citas);
        return ResponseEntity.ok(citas);

    }


    @DeleteMapping("/citas/{Id_Cita}")
    public ResponseEntity<Map<String, Boolean>> eliminarCita(
    @PathVariable Integer Id_Cita) {
        Cita citas = citaservice.buscarCitaPorId(Id_Cita);
        if(citas == null)
            throw new RecursoNoEncontradoExeption("No se encontró la cita con id" + Id_Cita);
        this.citaservice.eliminarCita(citas.getId_Cita());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
    
        return ResponseEntity.ok(respuesta);
    }
    

}
