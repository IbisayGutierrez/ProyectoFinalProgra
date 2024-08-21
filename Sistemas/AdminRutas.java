/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sistemas;

import Envios.RutaEntrega;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 9552
 */
public class AdminRutas {
    private Set<RutaEntrega> rutas;

    public AdminRutas() {
        this.rutas = new HashSet<>();
    }

    public void agregarRuta(RutaEntrega ruta) {
        rutas.add(ruta);
    }

    public RutaEntrega buscarRuta(String codigo) {
        for (RutaEntrega ruta : rutas) {
            if (ruta.getCodigo().equals(codigo)) {
                return ruta;
            }
        }
        return null;
    }

    public void actualizarRuta(String codigo, String nuevaDescripcion, Set<String> nuevosDestinos) {
        RutaEntrega ruta = buscarRuta(codigo);
        if (ruta != null) {
            ruta.setDescripcion(nuevaDescripcion);
            
        }
    }

    public void eliminarRuta(String codigo) {
        RutaEntrega ruta = buscarRuta(codigo);
        if (ruta != null) {
            rutas.remove(ruta);
        }
    }

    // Getters y setters para rutas
    public Set<RutaEntrega> getRutas() {
        return rutas;
    }

    public void setRutas(Set<RutaEntrega> rutas) {
        this.rutas = rutas;
    }
}


