package dwf.semana2.eh242640;

public class TareaDTO {
    private String descripcion;

    public TareaDTO() {}

    public TareaDTO(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
