/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

import java.util.Objects;

/**
 *
 * @author Santiago
 */
//Las aerolineas tienen una lista de aviones.

public class Aerolinea {
    private String nombre;
    private String pais;
    private int cantMaxAviones;
    
    public Aerolinea(String nombre, String pais, int cantMaxAviones){
        this.nombre = nombre;
        this.pais = pais;
        this.cantMaxAviones = cantMaxAviones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCantMaxAviones() {
        return cantMaxAviones;
    }

    public void setCantMaxAviones(int cantMaxAviones) {
        this.cantMaxAviones = cantMaxAviones;
    }
    
    @Override
    public String toString() {
        return "Aerolinea{" + "nombre=" + nombre + ", pais=" + pais + ", cantMaxAviones=" + cantMaxAviones + '}';
    }
    
    @Override
    public boolean equals(Object a) {
        if (!this.getClass().equals(a.getClass())) {
            return false;
        } else {
            Aerolinea aerolinea=(Aerolinea) a;
            
        return this.nombre==aerolinea.getNombre();
        }
    }
    
    public int compareTo(Object a) {
       Aerolinea objetoAerolinea= (Aerolinea) a;
       return this.nombre.compareTo(objetoAerolinea.nombre);
    }
}
