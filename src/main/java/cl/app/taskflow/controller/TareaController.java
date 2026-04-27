package cl.app.taskflow.controller;

import cl.app.taskflow.model.Tarea;
import cl.app.taskflow.service.TareaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(tareaServicio.crear(tarea));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtener(@PathVariable Long id){
        return ResponseEntity.ok(tareaServicio.obtener(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizar(@PathVariable Long id , @Valid @RequestBody Tarea tarea){
        return ResponseEntity.ok(tareaServicio.actualizar(id, tarea));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        tareaServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/prioridades/{prioridad}")
    public ResponseEntity<List<Tarea>> buscarPorPrioridad(@PathVariable String prioridad){
        return ResponseEntity.ok(tareaServicio.buscarPorPrioridad(prioridad));
    }




}
