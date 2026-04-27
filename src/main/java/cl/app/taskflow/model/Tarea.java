package cl.app.taskflow.model;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Tarea {
    private Long id;
    @NotBlank(message = "el titulo es requerido")
    private String titulo;

    @NotBlank(message = "La descripcion no puede estar vacia.")
    private String descripcion;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    private String prioridad;




}
