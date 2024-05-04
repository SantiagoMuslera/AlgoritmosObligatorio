/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tads;

public interface IPila <T extends Comparable <T>>{
    
    public void apilar(T dato);
    
    public void desApilar();
    
    public Nodo<T> obtenerTope();
    
    public boolean esVacia();
    
    public int cantidadElementos();
    
    public String MostrarContenido();
    
}
