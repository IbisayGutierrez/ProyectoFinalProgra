/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquetes;

import static Paquetes.EstadoPaquete.ENCLASIFICACION;

/**
 *
 * @author 9552
 */
public class Paquete {
    private String codigo;
    private String descripcion;
    private double peso;
    private String remitente;
    private String destinatario;
    private EstadoPaquete estado;

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPeso() {
        return peso;
    }

    public String getRemitente() {
        return remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public EstadoPaquete getEstado() {
        return estado;
    }

    public Paquete(String codigo, String descripcion, double peso, String remitente, String destinatario, EstadoPaquete estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.peso = peso;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.estado = estado;
    }

    public Paquete() {
        this("000","",0.1,"","",ENCLASIFICACION);
    }

    @Override
    public String toString() {
        return "Paquete{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", peso=" + peso + ", remitente=" + remitente + ", destinatario=" + destinatario + ", estado=" + estado + '}';
    }
    
    
    
    
}
