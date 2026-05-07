package cl.app.taskflow.controller;

import cl.app.taskflow.model.Tarea;
import cl.app.taskflow.service.TareaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tareas")
public class TareaController {

    @Autowired
    private TareaServicio servicio;

    @GetMapping
    public ResponseEntity<List<Tarea>> listarTodas() {
        return new ResponseEntity<>(servicio.obtenerTodas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerPorId(@PathVariable Long id) {
        return new ResponseEntity<>(servicio.obtenerPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@Valid @RequestBody Tarea tarea) {
        return new ResponseEntity<>(servicio.crearTarea(tarea), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @Valid @RequestBody Tarea tarea) {
        return new ResponseEntity<>(servicio.actualizarTarea(id, tarea), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        servicio.eliminarTarea(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/prioridades/{prioridad}")
    public ResponseEntity<List<Tarea>> buscarPorPrioridad(@PathVariable int prioridad) {
        return ResponseEntity.ok(servicio.buscarPorPrioridad(prioridad));
    }
}