package cl.app.taskflow.model;


import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Tarea {
    private Long id;

    @NotBlank(message = "el titulo es requerido")
    private String titulo;

    @NotBlank(message = "La descripcion no puede estar vacia.")
    private String descripcion;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    @Min(value= 1, message= "la prioridad minima es 1.")
    @Max(value = 5, message ="la prioridad maxima es 5.")
    private String prioridad;

    @NotBlank(message = "El responsables es obligatorio.")
    private String responsable;

    @Future(message= "La fecha limite debe ser una fecha futura.")
    private String fechaLimite;




}
