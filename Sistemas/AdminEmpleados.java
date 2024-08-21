/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistemas;

import Personas.Empleado;
import Personas.puestoEmpleado;
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

   public void actualizarEmpleado(String id, String nuevoTelefono, String nuevoCorreo, String nuevoPuesto, double nuevoSalario) {
    Empleado empleado = buscarEmpleado(id);
    if (empleado != null) {
        empleado.setTelefono(nuevoTelefono);
        empleado.setCorreo(nuevoCorreo);
        empleado.setPuesto(new puestoEmpleado(puestoEmpleado, puestoEmpleado));
        
        
    }
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
}

