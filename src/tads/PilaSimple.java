/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads;

public class PilaSimple<T extends Comparable<T>> implements IPila<T> {

    private Nodo<T> tope;
    private int cantidad;

    @Override
    public void apilar(T dato) {
        Nodo<T> nuevo = new Nodo(dato);
        nuevo.setSiguiente(this.tope);
        this.tope = nuevo;
    }

    @Override
    public void desApilar() {
        if (tope != null) {
            this.tope = this.tope.getSiguiente();
            this.cantidad--;
        }
    }

    @Override
    public Nodo<T> obtenerTope() {
       return this.tope;
    }

    @Override
    public boolean esVacia() {
        return cantidad <= 0;
    }

    @Override
    public int cantidadElementos() {
        return this.cantidad;
    }

}
