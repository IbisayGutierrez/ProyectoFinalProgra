/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistemas;

import Personas.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class adminClientes {
    public class AdminClientes {
    private ArrayList<Cliente> clientes;

    public AdminClientes() {
        clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void actualizarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getId().equals(cliente.getId())) {
                c.setTelefono(cliente.getTelefono());
                c.setCorreo(cliente.getCorreo());
                break;
            }
        }
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public Cliente buscarCliente(String Id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(Id)) {
                return c;
            }
        }
        return null;
    }
}
}
