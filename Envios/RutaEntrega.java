package Envios;

import java.util.HashSet;

/**
 *
 * @author andre
 */
public class RutaEntrega {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double distancia;
    private static HashSet<String> destinos = new HashSet<>();
            
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static void setDestinos(HashSet<String> destinos) {
        RutaEntrega.destinos = destinos;
    }

    public double getDistancia() {
        return distancia;
    }

    public RutaEntrega(String codigo, String nombre, String descripcion, double distancia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.distancia = distancia;
    }

    public RutaEntrega() {
        this("","","",0);
    }
    
    public static void agregarRuta(String ruta) {
        if (destinos.add(ruta)) {
            System.out.println("Ruta agregada con éxito");
        } else {
            System.out.println("La ruta ya existe y no se puede agregar");
        }
    }

    public static void eliminarRuta(String codigo) {
        String rutaAEliminar = null;
        for (String ruta : destinos) {
            if (ruta.equals(codigo)) {
                rutaAEliminar = ruta;
                break;
            }
        }
        if (rutaAEliminar != null) {
            destinos.remove(rutaAEliminar);
            System.out.println("Ruta eliminada con éxito");
        } else {
            System.out.println("Ruta no encontrada");
        }
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    

    @Override
    public String toString() {
        return "RutaEntrega{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", distancia=" + distancia + '}';
    }
}
