/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistemas;

import Personas.Empleado;
import Personas.puestoEmpleado;
import java.time.LocalDate;
import java.util.ArrayList;

public class AdminEmpleados {
    private ArrayList<Empleado> empleados;

    public AdminEmpleados() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public Empleado buscarEmpleado(String id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
        }
        return null;
    }

  

    public void eliminarEmpleado(String id) {
        Empleado empleado = buscarEmpleado(id);
        if (empleado != null) {
            empleados.remove(empleado);
        }
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }
    
     public boolean actualizarEmpleado(String id, String nuevoNombre, LocalDate nuevaFechaNacimiento, String nuevoTelefono, String nuevoCorreo, puestoEmpleado nuevoPuesto) {
        Empleado empleado = buscarEmpleado(id);
        if (empleado != null) {
            empleado.setNombre(nuevoNombre);
            empleado.setFechaNacimiento(nuevaFechaNacimiento);
            empleado.setTelefono(nuevoTelefono);
            empleado.setCorreo(nuevoCorreo);
            empleado.setPuestoEmpleado(nuevoPuesto);
            return true;
        }
        return false;
    }
}



