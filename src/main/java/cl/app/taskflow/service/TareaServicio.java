package cl.app.taskflow.service;

import cl.app.taskflow.exception.ResourceNotFoundException;
import cl.app.taskflow.model.Tarea;
import org.springframework.stereotype.Service;
import java.util.*;
import static java.util.stream.Collectors.toList;

@Service
public class TareaServicio

{

    private List <Tarea> listaTareas = new ArrayList<>();
    private Long proximoId = 1L ;
    public List<Tarea>listar(){
        return listaTareas;
    }

    public Tarea crear(Tarea nuevaTarea){
        nuevaTarea.setId(proximoId);
        proximoId++;
        listaTareas.add(nuevaTarea);
        return nuevaTarea;
    }

    public Tarea obtener(Long id){
        return listaTareas.stream()
                .filter(t-> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("no se encontro la tarea con ID "+id));
    }


    public void eliminar(Long id){
        Tarea tarea = obtener(id);
        listaTareas.remove(tarea);


    }

    public Tarea actualizar(Long id, Tarea tareaActualizada){
            Tarea existente = obtener(id);
            existente.setTitulo(tareaActualizada.getTitulo());
            existente.setDescripcion(tareaActualizada.getDescripcion());
            existente.setEstado(tareaActualizada.getEstado());
            existente.setPrioridad(tareaActualizada.getPrioridad());
            existente.setResponsable(tareaActualizada.getResponsable());
            existente.setFechaLimite(tareaActualizada.getFechaLimite());
            return existente;
    }

    public List<Tarea> buscarPorPrioridad(int prioridad) {
        return listaTareas.stream()
                .filter(t -> t.getPrioridad() == prioridad)
                .toList();
    }
}
