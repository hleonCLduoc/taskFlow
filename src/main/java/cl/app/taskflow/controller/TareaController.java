package cl.app.taskflow.controller;

import cl.app.taskflow.exception.ResourceNotFoundException;
import cl.app.taskflow.model.Tarea;
import cl.app.taskflow.service.TareaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tareas")

public class TareaController {

    @Autowired
    TareaServicio tareaServicio;

    @GetMapping
    public ResponseEntity<List<Tarea>>listar()
    {
        return ResponseEntity.ok(tareaServicio.listar());
    }

    @PostMapping
    public ResponseEntity<Tarea> crear(@Valid @RequestBody Tarea tarea){
        Tarea nuevaTarea = tareaServicio.crear(tarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtener(@PathVariable Long id){
        Tarea tarea = tareaServicio.obtener(id);
        if (tarea== null){
        throw new ResourceNotFoundException("Tarea con Id"+ id + "no Encontrada");
    }
        return ResponseEntity.ok(tarea);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizar(@PathVariable Long id , @Valid @RequestBody Tarea tarea){
        Tarea actualizada = tareaServicio.actualizar(id, tarea);
        if (actualizada == null){
            throw new ResourceNotFoundException("no se pudo actualizar = Tarea con ID "+ id + "no existe");
        }
        return ResponseEntity.ok(actualizada);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        tareaServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/prioridades/{prioridad}")
    public ResponseEntity<List<Tarea>> buscarPorPrioridad(@PathVariable int prioridad) {
        return ResponseEntity.ok(tareaServicio.buscarPorPrioridad(prioridad));
    }




}
