package cl.app.taskflow.service;

import cl.app.taskflow.exception.ResourceNotFoundException;
import cl.app.taskflow.model.Tarea;
import cl.app.taskflow.repository.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaServicio {

    @Autowired
    private TareaRepositorio repositorio;

    private Long generadorId = 1L; //

    public List<Tarea> obtenerTodas() {
        return repositorio.findAll();
    }

    public Tarea obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la tarea con ID: " + id));
    }

    public Tarea crearTarea(Tarea tarea) {
        if (tarea.getId() == null) {
            tarea.setId(generadorId++);
        }
        return repositorio.save(tarea);
    }

    public Tarea actualizarTarea(Long id, Tarea tareaActualizada) {
        Tarea existente = obtenerPorId(id);
        existente.setNombre(tareaActualizada.getNombre());
        existente.setDescripcion(tareaActualizada.getDescripcion());
        existente.setPrioridad(tareaActualizada.getPrioridad());
        existente.setFechaVencimiento(tareaActualizada.getFechaVencimiento());
        return existente;
    }

    public void eliminarTarea(Long id) {
        Tarea tareaExistente = obtenerPorId(id);
        repositorio.delete(tareaExistente.getId());
    }

    public List<Tarea> buscarPorPrioridad(int prioridad) {
        return repositorio.findAll().stream()
                .filter(t -> t.getPrioridad() != null && t.getPrioridad() == prioridad)
                .toList();
    }
}