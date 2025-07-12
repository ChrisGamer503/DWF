package dwf.semana2.eh242640;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/datos")

public class MiControlador{
    @Autowired
    private MiServicio miServicio;

    @GetMapping
    public List<String> obtenerDatos(){
        return miServicio.obtenerDatos();
    }

    @PostMapping
    public String agregarDato(@RequestBody String nuevoDato){
        miServicio.agregarDato(nuevoDato);
        return "Dato agregado correctamente: " + nuevoDato;
    }

    @PutMapping("/{indice}")
    public String actualizarDato(@PathVariable int indice, @RequestBody String nuevoDato) {
        try {
            miServicio.actualizarDato(indice, nuevoDato);
            return "Dato actualizado correctamente en el índice " + indice;
        } catch (IndexOutOfBoundsException e) {
            return "Error: " + e.getMessage();
        }
    }

    @DeleteMapping("/{indice}")
    public String eliminarDato(@PathVariable int indice) {
        try {
            miServicio.eliminarDato(indice);
            return "Dato eliminado correctamente en el índice " + indice;
        } catch (IndexOutOfBoundsException e) {
            return "Error: " + e.getMessage();
        }
    }


}
