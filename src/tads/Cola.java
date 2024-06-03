/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads;

/**
 *
 * @author theic
 * @param <T>
 */
public class Cola<T extends Comparable<T>> implements ICola<T> {

    private Nodo<T> inicio;
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }
    
    public Cola(){
        cantidad = 0;
    }
    
    @Override
    public void encolar(T dato) {
        Nodo<T> nuevonodo = new Nodo(dato);
        Nodo<T> actual = inicio;
        if (inicio == null) {
            inicio = nuevonodo;
        } else {
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevonodo);
        }
        cantidad++;
    }

    @Override
    public void desencolar() {
        if (inicio != null) {
            inicio = inicio.getSiguiente();
            cantidad--;
        }
    }
    
    public void eliminarElemento(T dato){
        Cola<T> aux = new Cola();
        Nodo<T> actual = frente();
        while(actual != null){
            if(!actual.getDato().equals(dato)){
                aux.encolar(actual.getDato());
            }
            desencolar();
            actual = frente();
        }
        this.inicio = aux.frente();
    }
    
    @Override
    public Nodo<T> frente() {
        return inicio;
    }

    @Override
    public boolean esVacia() {
        return inicio == null;
    }
    
    public boolean estaElemento(T dato){
        
        Nodo<T> actual = inicio;
        boolean existeElemento = false;
        while(actual != null && !existeElemento){
            if(actual.getDato().equals(dato)){
                existeElemento = true;
            }
            actual = actual.getSiguiente();
        }
        return existeElemento;
    }

    @Override
    public void eliminarRepetidos(Cola<T> c) {
        Lista<T> aux = new Lista();
        aux.setInicio(c.frente());
        c.desencolar();
        while(!c.esVacia()){
            if(!aux.estaElemento(c.frente().getDato())){
                aux.agregarFinal(c.frente().getDato());
            }
            c.desencolar();
        }
        Nodo<T> actual = aux.getInicio();
        while(actual != null){
            c.encolar(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

}
