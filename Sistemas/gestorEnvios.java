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
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class GestorEnvios {

    private Queue<Envio> envios;
    private int ultimoNumeroEnvio;

    public GestorEnvios() {
        envios = new LinkedList<>();
        ultimoNumeroEnvio = 0;

    }

    public void registrarEnvio(Cliente cli, Paquete cPaquete, RutaEntrega codigoRuta) {
        try {
            Cliente cliente = cli;
            if (cliente == null) {
                throw new IllegalStateException("No se puede registrar el envío sin cliente.");
            }

            Paquete paquete = cPaquete;
            if (paquete == null) {
                throw new IllegalStateException("No se puede registrar el envío sin paquete.");
            }

            RutaEntrega ruta = codigoRuta;

            LocalDate fechaEnvioDate = obtenerFecha("Ingrese la fecha de envío (dd/mm/yyyy):");
            LocalDate fechaEntregaDate = obtenerFecha("Ingrese la fecha de entrega (dd/mm/yyyy):");

            if (fechaEnvioDate == null || fechaEntregaDate == null) {
                throw new IllegalArgumentException("Fechas inválidas. No se puede registrar el envío.");
            }
            Envio envio = new Envio( cliente, paquete, ruta, fechaEnvioDate, fechaEntregaDate, EstadoEnvio.EN_ALMACEN);

            envios.add(envio);
            System.out.println("Envío registrado con éxito.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Error al registrar envío: " + e.getMessage());
        }
    }

    public void buscarEnvioPorCodigo() {
        if (envios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay envíos disponibles.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un array de los códigos de envío disponibles
        String[] codigosEnvio = envios.stream()
                .map(envio -> String.valueOf(envio.getNumeroEnvio()))
                .toArray(String[]::new);

        // Crear JComboBox con los códigos de envío
        JComboBox<String> comboBox = new JComboBox<>(codigosEnvio);

        // Mostrar un JOptionPane con el JComboBox
        int opcion = JOptionPane.showConfirmDialog(null, comboBox, "Seleccione un envío", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (opcion == JOptionPane.OK_OPTION) {
            String codigoSeleccionado = (String) comboBox.getSelectedItem();
            int numeroEnvio = Integer.parseInt(codigoSeleccionado);
            Envio envio = buscarEnvio(numeroEnvio);
            if (envio != null) {
                //mostrarInformacionEnvio(envio);
            } else {
                JOptionPane.showMessageDialog(null, "Envío no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Envio buscarEnvio(int numeroEnvio) {
        for (Envio envio : envios) {
            if (envio.getNumeroEnvio() == numeroEnvio) {
                return envio;
            }
        }
        return null;
    }

    public void despacharEnvio() {
        try {
            String numeroEnvioStr = JOptionPane.showInputDialog(null, "Ingrese el número de envío:", "Despachar Envío", JOptionPane.QUESTION_MESSAGE);
            if (numeroEnvioStr == null) {
                return; // El usuario canceló la operación
            }
            int numeroEnvio = Integer.parseInt(numeroEnvioStr);
            Envio envio = buscarEnvio(numeroEnvio);
            if (envio == null) {
                throw new NoSuchElementException("Envío no encontrado.");
            }
            if (envio.getEstado() != EstadoEnvio.EN_ALMACEN) {
                throw new IllegalStateException("El envío no está en almacén y no puede ser despachado.");
            }
            envio.setEstado(EstadoEnvio.DESPACHADO);
            JOptionPane.showMessageDialog(null, "Envío despachado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Número de envío inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NoSuchElementException | IllegalStateException e) {
            JOptionPane.showMessageDialog(null, "Error al despachar envío: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void entregarEnvio() {
        try {
            String numeroEnvioStr = JOptionPane.showInputDialog(null, "Ingrese el número de envío:", "Entregar Envío", JOptionPane.QUESTION_MESSAGE);
            if (numeroEnvioStr == null) {
                return; // El usuario canceló la operación
            }
            int numeroEnvio = Integer.parseInt(numeroEnvioStr);
            Envio envio = buscarEnvio(numeroEnvio);
            if (envio == null) {
                throw new NoSuchElementException("Envío no encontrado.");
            }
            if (envio.getEstado() != EstadoEnvio.DESPACHADO) {
                throw new IllegalStateException("El envío no está despachado y no puede ser entregado.");
            }
            envio.setEstado(EstadoEnvio.ENTREGADO);
            JOptionPane.showMessageDialog(null, "Envío entregado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Número de envío inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NoSuchElementException | IllegalStateException e) {
            JOptionPane.showMessageDialog(null, "Error al entregar envío: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cancelarEnvio() {
        try {
            String numeroEnvioStr = JOptionPane.showInputDialog(null, "Ingrese el número de envío:", "Cancelar Envío", JOptionPane.QUESTION_MESSAGE);
            if (numeroEnvioStr == null) {
                return; // El usuario canceló la operación
            }
            int numeroEnvio = Integer.parseInt(numeroEnvioStr);
            Envio envio = buscarEnvio(numeroEnvio);
            if (envio == null) {
                throw new NoSuchElementException("Envío no encontrado.");
            }
            // Verificamos que el estado sea EN_ALMACEN antes de cancelar el envío
            if (envio.getEstado() != EstadoEnvio.EN_ALMACEN) {
                throw new IllegalStateException("El envío no está en almacén y no puede ser cancelado.");
            }
            // Cancelamos el envío cambiando su estado
            envio.setEstado(EstadoEnvio.CANCELADO);
            JOptionPane.showMessageDialog(null, "Envío cancelado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Número de envío inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NoSuchElementException | IllegalStateException e) {
            JOptionPane.showMessageDialog(null, "Error al cancelar envío: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ... (otros métodos sin cambios)
    private LocalDate obtenerFecha(String mensaje) {
        String fechaStr = JOptionPane.showInputDialog(null, mensaje, "Ingresar Fecha", JOptionPane.QUESTION_MESSAGE);
        if (fechaStr == null) {
            return null;
        }
        try {
            return validarFecha(fechaStr);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Error: Formato de fecha inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private LocalDate validarFecha(String fechaStr) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fechaStr, formatter);
    }

    public Queue<Envio> getEnvios() {
        return envios;
    }

}
