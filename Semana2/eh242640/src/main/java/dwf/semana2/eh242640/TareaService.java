package dwf.semana2.eh242640;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class TareaService {
    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public List<Tarea> obtenerTodas(String filtro) {
        if (filtro == null || filtro.isEmpty()) {
            return tareas;
        }
        return tareas.stream()
                .filter(t -> t.getDescripcion().toLowerCase().contains(filtro.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Tarea agregarTarea(String descripcion) {
        Tarea tarea = new Tarea(contador.getAndIncrement(), descripcion);
        tareas.add(tarea);
        return tarea;
    }

    public boolean eliminarTarea(Long id) {
        return tareas.removeIf(t -> t.getId().equals(id));
    }

    public boolean marcarComoCompletada(Long id) {
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(t -> { t.setCompletada(true); return true; })
                .orElse(false);
    }

    public boolean editarTarea(Long id, String nuevaDescripcion) {
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(t -> { t.setDescripcion(nuevaDescripcion); return true; })
                .orElse(false);
    }
}
