/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personas;

/**
 *
 * @author Erick Rodriguez Al
 */
import java.time.LocalDate;
import java.time.Period;

public class Cliente extends Persona {
    private int edad;

    public int getEdad() {
        return edad;
    }
 public void calcularEdad() {
        if (getFechaNacimiento() != null) {
            this.edad = Period.between(getFechaNacimiento(), LocalDate.now()).getYears();
        }
    }

    
}
