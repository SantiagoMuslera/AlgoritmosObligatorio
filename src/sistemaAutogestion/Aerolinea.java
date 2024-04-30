/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

import java.util.Objects;

import tads.*;

public class Aerolinea implements Comparable <Aerolinea>{
    private String nombre;
    private String pais;
    private int cantMaxAviones;
    private ListaConMaximo<Avion> aviones;

    public ListaConMaximo<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(ListaConMaximo<Avion> aviones) {
        this.aviones = aviones;
    }
    
    public Aerolinea(String nombre){
        this.nombre = nombre;
    }
    
    
    public Aerolinea(String nombre, String pais, int cantMaxAviones){
        this.nombre = nombre;
        this.pais = pais;
        this.cantMaxAviones = cantMaxAviones;
        this.aviones = new ListaConMaximo(cantMaxAviones);
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
    

    @Override
    public int compareTo(Aerolinea o) {
        Aerolinea objetoAerolinea= (Aerolinea) o;
       return this.nombre.compareTo(objetoAerolinea.nombre);
    }
}
