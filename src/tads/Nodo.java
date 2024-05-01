/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads;

/**
 *
 * @author theic
 */
public class Nodo <T extends Comparable <T>>{
     private T dato;
    private Nodo <T> siguiente;
    
    
     public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    @Override
    public boolean equals(Object obj) {
        T compare = (T)obj;
        return dato.equals(compare); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
 
    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    
    public void setSiguiente(Nodo <T> siguiente) {
        this.siguiente = siguiente;
    }
}
