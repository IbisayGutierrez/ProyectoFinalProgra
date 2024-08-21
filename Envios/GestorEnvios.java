/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Envios;

import Paquetes.Paquete;
import Personas.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author andre
 */
public class GestorEnvios {
    private Queue<Envio> colaEnvios;
    private ArrayList<Cliente> clientes;
    private ArrayList<Paquete> paquetes;
    private ArrayList<RutaEntrega> rutas;

    public GestorEnvios() {
        colaEnvios = new LinkedList<>();
        clientes = new ArrayList<>();
        paquetes = new ArrayList<>();
        rutas = new ArrayList<>();
    }

    public void registrarEnvio(Cliente cliente, Paquete paquete, RutaEntrega ruta, LocalDate fechaEnvio, LocalDate fechaEntrega) {
        int ultimoNumeroEnvio = 0;
        double precio = 2100;
        Envio envio = new Envio(++ultimoNumeroEnvio, cliente, paquete, ruta, fechaEnvio, fechaEntrega, precio, EstadoEnvio.EN_ALMACEN);
        colaEnvios.add(envio);
        System.out.println("Envío registrado con éxito");
    }

   public Envio buscarEnvio(int numeroEnvio) {
    for (Envio envio : colaEnvios) {
        if (envio.getNumeroEnvio() == numeroEnvio) {
            return envio; // Devuelve el envío si coincide el número
        }
    }
    return null; // Si no se encuentra el envío, devuelve null
}
}