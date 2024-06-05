/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tads;

public class PilaSimple<T extends Comparable<T>> implements IPila<T> {

    private Nodo<T> tope;

    public T getTope() {
        return tope.getDato();
    }
    
    public PilaSimple(){
        tope = null;
    }

    private int cantidad;

    @Override
    public void apilar(T dato) {
        if (dato != null) {
            Nodo<T> nuevo = new Nodo(dato);
            nuevo.setSiguiente(this.tope);
            this.tope = nuevo;
            this.cantidad++;
        }
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
    
    @Override
    public String MostrarContenido(){
        Nodo<T> actual = this.tope;
        StringBuilder sb = new StringBuilder();
        while(actual != null){
            sb.append(actual).append("|").append("\n");
        }
        return sb.toString();
    }

}
