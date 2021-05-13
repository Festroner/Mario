package back;

import java.time.LocalDateTime;
import java.util.Date;

public class Pick {

    private Double cantidad;
    private Double toma_dia;
    private String Descripcion;
    private String Medicamento;
    private Double Tiempo;
    private int Duracion;
    private Date fecha;
    private Date fechafin;
    private int activo;
    private int id;

    public Pick(String Descripcion, String Medicamento, int id, Double toma_dia, Double cantidad, Double Tiempo, int Duracion, int activo, Date fecha, Date fechafin) {
        this.Descripcion = Descripcion;
        this.Medicamento= Medicamento;
        this.id = id;
        this.toma_dia = toma_dia;
        this.cantidad = cantidad;
        this.activo = activo;
        this.Tiempo = Tiempo;
        this.Duracion = Duracion;
        this.fecha = fecha;
        this.fechafin = fechafin;
    }

    public boolean comprobar(String t){
        if (t.length() > 140)
            return false;
        else {
            return true;
        }
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.Descripcion = descripcion;
    }

    public String getMedicamento() {
        return Medicamento;
    }

    public void setMedicamento(String tipster) {
        this.Medicamento = tipster;
    }

    public int getId() {
        return id;
    }

    public void setId(String fecha) {
        this.id = id;
    }

    public Double getCantidad() { return cantidad; }

    public void setCantidad(float stake) { this.cantidad = cantidad;}

    public Double gettoma_dia() {
        return toma_dia;
    }

    public void settoma_dia(float cuota) {
        this.toma_dia = toma_dia;
    }

    public Double getTiempo() {
        return Tiempo;
    }

    public void setTiempo(float u) {
        this.Tiempo = Tiempo;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int duración) {
        Duracion = duración;
    }

    public int isActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }
}

