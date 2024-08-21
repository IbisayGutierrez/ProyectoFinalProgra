/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistemas;

import Envios.Envio;
import Envios.EstadoEnvio;
import Envios.RutaEntrega;
import Paquetes.Paquete;
import Personas.Cliente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class gestorEnvios {
   public class GestorEnvios {
    private Queue<Envio> envios;
    private int ultimoNumeroEnvio;
    private Scanner scanner;
    private List<Paquete> paquetes;
    private List<RutaEntrega> rutas;
    private List<Cliente> clientes;

    public GestorEnvios() {
        envios = new LinkedList<>();
        ultimoNumeroEnvio = 0;
        scanner = new Scanner(System.in);
        paquetes = new ArrayList<>();
        rutas = new ArrayList<>();
        clientes = new ArrayList<>();
        
    }
    
    public void registrarEnvio() {
        try {
            Cliente cliente = obtenerCliente();
            if (cliente == null) {
                throw new IllegalStateException("No se puede registrar el envío sin cliente.");
            }

            Paquete paquete = seleccionarPaquete();
            if (paquete == null) {
                throw new IllegalStateException("No se puede registrar el envío sin paquete.");
            }

            RutaEntrega ruta = new RutaEntrega();
            if (ruta == null) {
                throw new IllegalStateException("No se puede registrar el envío sin ruta.");
            }

            LocalDate fechaEnvioDate = obtenerFecha("Ingrese la fecha de envío (dd/mm/yyyy):");
            LocalDate fechaEntregaDate = obtenerFecha("Ingrese la fecha de entrega (dd/mm/yyyy):");

            if (fechaEnvioDate == null || fechaEntregaDate == null) {
                throw new IllegalArgumentException("Fechas inválidas. No se puede registrar el envío.");
            }

            double precio = calcularPrecio(paquete);
            Envio envio = new Envio(++ultimoNumeroEnvio, cliente, paquete, ruta, fechaEnvioDate, fechaEntregaDate, precio, EstadoEnvio.EN_ALMACEN);
            envios.add(envio);
            System.out.println("Envío registrado con éxito.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Error al registrar envío: " + e.getMessage());
        }
    }

    public void buscarEnvio() {
        try {
            System.out.println("Ingrese el número de envío:");
            int numeroEnvio = Integer.parseInt(scanner.nextLine());
            Envio envio = buscarEnvio(numeroEnvio);
            if (envio != null) {
                mostrarInformacionEnvio(envio);
            } else {
                throw new NoSuchElementException("Envío no encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Número de envío inválido.");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void despacharEnvio() {
        try {
            System.out.println("Ingrese el número de envío:");
            int numeroEnvio = Integer.parseInt(scanner.nextLine());
            Envio envio = buscarEnvio(numeroEnvio);
            if (envio == null) {
                throw new NoSuchElementException("Envío no encontrado.");
            }
            if (envio.getEstado() != EstadoEnvio.EN_ALMACEN) {
                throw new IllegalStateException("El envío no está en almacén y no puede ser despachado.");
            }
            envio.setEstado(EstadoEnvio.DESPACHADO);
            System.out.println("Envío despachado con éxito.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Número de envío inválido.");
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error al despachar envío: " + e.getMessage());
        }
    }

    public void entregarEnvio() {
        try {
            System.out.println("Ingrese el número de envío:");
            int numeroEnvio = Integer.parseInt(scanner.nextLine());
            Envio envio = buscarEnvio(numeroEnvio);
            if (envio == null) {
                throw new NoSuchElementException("Envío no encontrado.");
            }
            if (envio.getEstado() != EstadoEnvio.DESPACHADO) {
                throw new IllegalStateException("El envío no está despachado y no puede ser entregado.");
            }
            envio.setEstado(EstadoEnvio.ENTREGADO);
            System.out.println("Envío entregado con éxito.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Número de envío inválido.");
        } catch (NoSuchElementException | IllegalStateException e) {
            System.out.println("Error al entregar envío: " + e.getMessage());
        }
    }

    public void cancelarEnvio() {
     try {
        System.out.println("Ingrese el número de envío:");
        int numeroEnvio = Integer.parseInt(scanner.nextLine());
        
        // Asumiendo que buscarEnvio es un método que retorna un objeto de tipo Envio
       Envio envio = buscarEnvio(numeroEnvio); // Llama al método corregido
        
        if (envio == null)  {
            throw new NoSuchElementException("Envío no encontrado.");
        }
        
        // Verificamos que el estado sea ENCLASIFICACION antes de cancelar el envío
        if (envio.getEstado() != EstadoEnvio.EN_ALMACEN) {
            throw new IllegalStateException("El envío no está en clasificación y no puede ser cancelado.");
        }
        
        // Cancelamos el envío cambiando su estado
        envio.setEstado(EstadoEnvio.CANCELADO);
        System.out.println("Envío cancelado con éxito.");
        
    } catch (NumberFormatException e) {
        System.out.println("Error: Número de envío inválido.");
    } catch (NoSuchElementException | IllegalStateException e) {
        System.out.println("Error al cancelar envío: " + e.getMessage());
    }
}

    // ... (otros métodos sin cambios)

    private LocalDate obtenerFecha(String mensaje) {
        System.out.println(mensaje);
        String fechaStr = scanner.nextLine();
        try {
            return validarFecha(fechaStr);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Formato de fecha inválido.");
            return null;
        }
    }

    private LocalDate validarFecha(String fechaStr) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fechaStr, formatter);
    }
   }
   
}

