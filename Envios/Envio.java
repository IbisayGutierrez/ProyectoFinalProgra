/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Envios;

import Paquetes.Paquete;
import Personas.Cliente;
import java.time.LocalDate;


/**
 *
 * @author andre
 */
public class Envio {
   private static int contador = 0;
    private int numeroEnvio;
    private Cliente cliente;
    private Paquete paquete;
    private RutaEntrega ruta;
    private LocalDate fechaEnvio;
    private LocalDate fechaEntrega;
    private double precio;
    private EstadoEnvio estado;

    public static int getContador() {
        return contador;
    }

    public int getNumeroEnvio() {
        return numeroEnvio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public RutaEntrega getRuta() {
        return ruta;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public double getPrecio() {
        return precio;
    }

    public EstadoEnvio getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnvio estado) {
        this.estado = estado;
    }
    

    public Envio(int par, Cliente cliente, Paquete paquete, RutaEntrega ruta, LocalDate fechaEnvio, LocalDate fechaEntrega, double precio1, EstadoEnvio EN_ALMACEN) {
        this.numeroEnvio = contador++;
        this.cliente = cliente;
        this.paquete = paquete;
        this.ruta = ruta;
        this.fechaEnvio = fechaEnvio;
        this.fechaEntrega = fechaEntrega;
        this.estado = EstadoEnvio.EN_ALMACEN;
        calcularPrecio();
    }

    public void calcularPrecio() {
        double distanciaRuta = ruta.getDistancia();
        double pesoPaquete = paquete.getPeso();
        double tarifaPrimerKilo = 20100;
        double tarifaKiloAdicional = 1200;
        precio = tarifaPrimerKilo + (pesoPaquete - 1) * tarifaKiloAdicional;
    }

    public void despachar() {
        if (estado == EstadoEnvio.EN_ALMACEN) {
            estado = EstadoEnvio.DESPACHADO;
            System.out.println("Envío despachado");
        } else {
            System.out.println("No se puede despachar el envío en este estado");
        }
    }

    public void entregar() {
        if (estado == EstadoEnvio.DESPACHADO) {
            estado = EstadoEnvio.ENTREGADO;
            System.out.println("Envío entregado");
        } else {
            System.out.println("No se puede entregar el envío en este estado");
        }
    }

    public void cancelar() {
        if (estado == EstadoEnvio.EN_ALMACEN) {
            estado = EstadoEnvio.CANCELADO;
            System.out.println("Envío cancelado");
        } else {
            System.out.println("No se puede cancelar el envío en este estado");
        }
    }


    @Override
    public String toString() {
        return "Envio{" + "numeroEnvio=" + numeroEnvio + ", cliente=" + cliente + ", ruta=" + ruta + ", fechaEnvio=" + fechaEnvio + ", fechaEntrega=" + fechaEntrega + ", precio=" + precio + ", estado=" + estado + '}';
    }
    
    
    
    
    
}
