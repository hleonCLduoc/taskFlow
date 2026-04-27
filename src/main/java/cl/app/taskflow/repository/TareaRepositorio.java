package cl.app.taskflow.repository;


import cl.app.taskflow.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TareaRepositorio {

   private Map<Long, Tarea> datos = new HashMap<>();

   public List<Tarea> findAll() {
       return new ArrayList<>(datos.values());
   }

   public Optional<Tarea> findById(Long id){
       return Optional.ofNullable(datos.get(id));}

   public Tarea save (Tarea tarea){
       datos.put(tarea.getId(),tarea);
       return tarea;
        }
   public void delete(Long id)
   {
       datos.remove(id);
       
       }


}
