    package cl.app.taskflow.model;

    import jakarta.validation.constraints.Future;
    import jakarta.validation.constraints.Max;
    import jakarta.validation.constraints.Min;
    import jakarta.validation.constraints.NotBlank;
    import lombok.*;
    import java.time.LocalDate;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class Tarea {

        private Long id;

        @NotBlank(message = "El nombre de la tarea no puede estar vacío")
        private String nombre;

        @NotBlank(message = "La descripción no puede estar vacía")
        private String descripcion;

        @Min(value = 1, message = "La prioridad mínima es 1")
        @Max(value = 5, message = "La prioridad máxima es 5")
        private Integer prioridad;

        @Future(message = "La fecha de vencimiento debe estar en el futuro")
        private LocalDate fechaVencimiento;
    }