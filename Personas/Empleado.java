/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personas;

/**
 *
 * @author Erick Rodriguez Al
 */
public class Empleado extends Persona {
    private String puesto;
    private double salario;

    
    public void actualizarSalario(double nuevoSalario) {
        this.salario = nuevoSalario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public enum PuestoEmpleado {
    ADMINISTRATIVO,
    REPARTIDOR,
    GERENTE
}

    
}

