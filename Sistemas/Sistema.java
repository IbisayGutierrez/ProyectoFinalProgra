/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistemas;

import Sistemas.adminClientes.AdminClientes;

/**
 *
 * @author Dell
 */
public class Sistema {

    public static AdminClientes adminClientes;
    public static AdminPaquetes adminPaquetes;
    public static GestorEnvios gestorEnvios;
    public static AdminRutas adminRutas;
    public static AdminEmpleados adminEmpleados;

    public Sistema() {
        adminClientes = new AdminClientes();
        adminPaquetes = new AdminPaquetes();
        gestorEnvios = new GestorEnvios();
        adminRutas = new AdminRutas();
        adminEmpleados = new AdminEmpleados();
    }

    public AdminClientes getAdminClientes() {
        return adminClientes;
    }

    public AdminPaquetes getAdminPaquetes() {
        return adminPaquetes;
    }

    public GestorEnvios getGestorEnvios() {
        return gestorEnvios;
    }

    public static AdminEmpleados getAdminEmpleados() {
        return adminEmpleados;
    }

    public static void setAdminEmpleados(AdminEmpleados adminEmpleados) {
        Sistema.adminEmpleados = adminEmpleados;
    }

    public static AdminRutas getAdminRutas() {
        return adminRutas;
    }

    public static void setAdminRutas(AdminRutas adminRutas) {
        Sistema.adminRutas = adminRutas;
    }

}
