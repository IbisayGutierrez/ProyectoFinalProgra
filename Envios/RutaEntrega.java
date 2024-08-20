/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Envios;

import java.util.ArrayList;


/**
 *
 * @author andre
 */
public class RutaEntrega {
    private String codigo;
    private String Nombre;
     private String descripcion;
    private double distancia;
    private static ArrayList<RutaEntrega> rutas = new ArrayList<>();
            
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getDistancia() {
        return distancia;
    }

    public RutaEntrega(String codigo, String Nombre, String descripcion, double distancia) {
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.descripcion = descripcion;
        this.distancia = distancia;
    }

    public RutaEntrega() {
        this("","","",0);
    }
    
     public static void agregarRuta(RutaEntrega ruta) {
        rutas.add(ruta);
        System.out.println("Ruta agregada con éxito");
    }

    public static void eliminarRuta(String codigo) {
        for (RutaEntrega ruta : rutas) {
            if (ruta.getCodigo().equals(codigo)) {
                rutas.remove(ruta);
                System.out.println("Ruta eliminada con éxito");
                return;
            }
        }
        System.out.println("Ruta no encontrada");
    }

    @Override
    public String toString() {
        return "RutaEntrega{" + "codigo=" + codigo + ", Nombre=" + Nombre + ", descripcion=" + descripcion + ", distancia=" + distancia + '}';
    }
    

    
    
    
}


