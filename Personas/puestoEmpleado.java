/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Personas;

/**
 *
 * @author Dell
 */
public enum puestoEmpleado {
   ERENTE("Gerente", 5000.0),
    SUPERVISOR("Supervisor", 3500.0),
    OPERADOR("Operador", 2500.0),
    REPARTIDOR("Repartidor", 2000.0),
    ASISTENTE("Asistente", 1800.0);

    private final String puesto;
    private final double salario;
    

    puestoEmpleado(String puesto, double salario) {
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }
    

    @Override
    public String toString() {
        return puesto + " (Salario: $" + salario + ")";
    }
}

