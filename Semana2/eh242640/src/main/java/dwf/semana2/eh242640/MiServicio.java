package dwf.semana2.eh242640;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MiServicio {
    
    private final List<String> datos = new ArrayList<>();

    public MiServicio(){
        datos.add("Elemento 1");
        datos.add("Elemento 2");
    }

    public List<String> obtenerDatos(){
        return datos;
    }

    public void agregarDato(String nuevoDato){
        datos.add(nuevoDato);
    }

    public void actualizarDato(int indice, String nuevoDato) {
    if (indice >= 0 && indice < datos.size()) {
        datos.set(indice, nuevoDato);
    } else {
        throw new IndexOutOfBoundsException("Índice fuera de rango");
    }
    }

    public void eliminarDato(int indice) {
    if (indice >= 0 && indice < datos.size()) {
        datos.remove(indice);
    } else {
        throw new IndexOutOfBoundsException("Índice fuera de rango");
    }
    }


    

}
