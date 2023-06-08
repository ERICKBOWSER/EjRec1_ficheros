/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package cursos;

import java.time.LocalDate;

/**
 *
 * @author guerig
 */
public class Ejrec1_GuerigEri {

    private String centro;
    private String codigo;
    private String titulo;
    private String modalidad;
    private String estado;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String dirigido;

    public Ejrec1_GuerigEri() {
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    public String getDirigido() {
        return dirigido;
    }

    public void setDirigido(String dirigido) {
        this.dirigido = dirigido;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(centro).append(";");
        sb.append(codigo).append(";");
        sb.append(titulo).append(";");
        sb.append(modalidad).append(";");
        sb.append(estado).append(";");
        sb.append(fechaInicio).append(";");
        sb.append(fechaFin).append(";");
        sb.append(dirigido).append(";");
        return sb.toString();
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
            
            
            
            
}
