/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personas;

import java.time.LocalDate;

/**
 *
 * @author Erick Rodriguez Al
 */
public class Empleado extends Persona {
    private String puesto;
    private double salario;
    private puestoEmpleado puestoEmpleado;


    public String getPuesto() {
        return puestoEmpleado.getPuesto();
    }

    public double getSalario() {
        return puestoEmpleado.getSalario();
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
   

    public void setPuestoEmpleado(puestoEmpleado puestoEmpleado) {
        this.puestoEmpleado = puestoEmpleado;
    }
    public Empleado(String identificacion, String nombre, LocalDate fechaNacimiento, String telefono, String correo, puestoEmpleado puestoEmpleado) {
        super(identificacion, nombre, fechaNacimiento, telefono, correo);
        this.puestoEmpleado = puestoEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                super.toString() +
                ", puesto='" + puestoEmpleado.getPuesto() + '\'' +
                ", salario=" + puestoEmpleado.getSalario() +
                '}';
    }
}

