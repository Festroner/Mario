package alerta;

public class alerta {
    private int id;
    private String nombre;
    private int cantidad;
    private int cantidadDia;
    private int timepoTomas;
    private int duracion;
    private String descripcion;
    private String inicio;
    private String fin;
    private int activo;

    public alerta(int id, String nombre, int cantidad, int cantidadDia, int timepoTomas, int duracion, String descripcion, String inicio, String fin, int activo) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.cantidadDia = cantidadDia;
        this.timepoTomas = timepoTomas;
        this.duracion = duracion;
        this.descripcion = descripcion;
        this.inicio = inicio;
        this.fin = fin;
        this.activo = activo;
    }
    public alerta(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidadDia() {
        return cantidadDia;
    }

    public void setCantidadDia(int cantidadDia) {
        this.cantidadDia = cantidadDia;
    }

    public int getTimepoTomas() {
        return timepoTomas;
    }

    public void setTimepoTomas(int timepoTomas) {
        this.timepoTomas = timepoTomas;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "Alerta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", cantidadDia=" + cantidadDia +
                ", timepoTomas=" + timepoTomas +
                ", duracion=" + duracion +
                ", descripcion='" + descripcion + '\'' +
                ", inicio=" + inicio +
                ", fin=" + fin +
                "}<br>";
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
}
