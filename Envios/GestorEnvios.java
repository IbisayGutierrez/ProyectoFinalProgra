/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Envios;

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
        Envio envio = new Envio(cliente, paquete, ruta, fechaEnvio, fechaEntrega);
        colaEnvios.add(envio);
        System.out.println("Envío registrado con éxito");
    }

    public void buscarEnvio(int numeroEnvio) {
        for (Envio envio : colaEnvios) {
            if (envio.getNumeroEnvio()== numeroEnvio) {
}
        }
    }
}
