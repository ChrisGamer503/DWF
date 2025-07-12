package dwf.semana2.eh242640;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // Obtener todas (con búsqueda opcional)
    @GetMapping
    public List<Tarea> obtenerTareas(@RequestParam(required = false) String buscar) {
        return tareaService.obtenerTodas(buscar);
    }

    // Agregar nueva tarea con JSON: {"descripcion": "..." }
    @PostMapping
    public Tarea agregarTarea(@RequestBody TareaDTO tareaDTO) {
        return tareaService.agregarTarea(tareaDTO.getDescripcion());
    }

    // Marcar como completada
    @PatchMapping("/{id}/completar")
    public String completarTarea(@PathVariable Long id) {
        return tareaService.marcarComoCompletada(id)
                ? "Tarea marcada como completada"
                : "Tarea no encontrada";
    }

    // Editar tarea con JSON: {"descripcion": "..." }
    @PutMapping("/{id}")
    public String editarTarea(@PathVariable Long id, @RequestBody TareaDTO tareaDTO) {
        return tareaService.editarTarea(id, tareaDTO.getDescripcion())
                ? "Tarea actualizada correctamente"
                : "Tarea no encontrada";
    }

    // Eliminar tarea
    @DeleteMapping("/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        return tareaService.eliminarTarea(id)
                ? "Tarea eliminada correctamente"
                : "Tarea no encontrada";
    }
}
