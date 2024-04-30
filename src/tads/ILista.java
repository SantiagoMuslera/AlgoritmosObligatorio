/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tads;

/**
 *
 * @author theic
 */
public interface ILista <T extends Comparable <T>>{

    //pre: averigua si una lista es vacia o no
    //post: retorno true si la lista es vacía y false en caso contrario
    public boolean esVacia();
    
    //pre: partimos de una lista de datos T
    //post: retorno un entero que indida la cantidad de elementos en la lista
    public int cantidadElementos();
    
    //pre: tenemos una lista de datos T
    //post: muestra los datos de la lista    
    public void mostrarLista();
    
    //pre: tenemos una lista lista de datos T
    //post: obtenemos una lista vacía (inicio=null)
    public void vaciar();
    
    //pre: tenemos una lista de datos T
    //post: se agrega un nodo con el dato x en el inicio
    public void agregarInicio(T dato);
    
    //pre: tenemos una lista de datos T
    //post: se agrega un nodo con el dato x en el final
    public void agregarFinal (T x);
    
    //pre: tenemos una lista de datos T
    //post: se elimina de la lista el primer Nodo
    public void eliminarInicio();
    
    //pre: tenemos una lista de datos T
    //post: obtenemos la lista sin el último elemento
    public void eliminarFinal();
    
    //pre: tenemos una lista de datos T
    //post: se retorno un booleado con true si el dato x existe en el la lista y false en caso contrario
    public boolean estaElemento(T x);
    
    //pre: tenemos una lista de datos T
    //post: se obtiene una lista sin el nodo que contiene el elemento x
    public void eliminarElemento(T x);
    
    //pre: ses tiene una lista de datos T ordenada ascendente
    //post: se agrega elemento x en el lista correspondiente manteniendo la lista ordenada
    public void agregarOrdenado(T x);
    
    //pre: tenemos una lista de datos T
    //post: Se retorno el nodo que contiene el dato x y null en caso en que no exista en la lista
    public Nodo obtenerElemento (T x);
    
    @Override
    public boolean equals(Object obj);
    
}
