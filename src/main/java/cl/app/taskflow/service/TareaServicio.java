package cl.app.taskflow.service;

import cl.app.taskflow.model.Tarea;
import cl.app.taskflow.repository.TareaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServicio

{
    @Autowired
    TareaRepositorio repositorio;

    public List <Tarea> listar(){
        return repositorio.findAll();
    }

    public Tarea crear(Tarea tarea){
        return repositorio.save(tarea);
    }

    public Tarea obtener(Long id){
        return repositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarea no encontrada"));
    }


    public void eliminar(Long id){
        obtener(id);
        repositorio.delete(id);


    }

    public Tarea actualizar(Long id, Tarea tareaActualizada){
            Tarea existente = obtener(id);
            existente.setTitulo(tareaActualizada.getTitulo());
            existente.setDescripcion(tareaActualizada.getDescripcion());
            existente.setEstado(tareaActualizada.getEstado());
            existente.setPrioridad(tareaActualizada.getPrioridad());
            return repositorio.save(existente);
    }

    public List<Tarea> buscarPorPrioridad(String prioridad){
        return repositorio.findAll().stream()
                .filter(t -> t.getPrioridad().equalsIgnoreCase(prioridad))
                .toList();
    }
}
