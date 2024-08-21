/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistemas;



/**
 *
 * @author Dell
 */
public class Sistema {
    private adminClientes adminClientes;
    private adminPaquetes adminPaquetes;
    private gestorEnvios gestorEnvios;

    public Sistema() {
        adminClientes = new adminClientes();
        adminPaquetes = new adminPaquetes();
        gestorEnvios = new gestorEnvios();
    }
}
