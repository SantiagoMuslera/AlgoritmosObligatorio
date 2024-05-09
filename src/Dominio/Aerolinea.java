/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Objects;

import tads.*;

public class Aerolinea implements Comparable<Aerolinea> {

    private String nombre;
    private String pais;
    private int cantMaxAviones;
    //private Lista<Piloto> pilotos;
    private Lista<Pasaje> pasajesDevueltos;
    private Lista<Vuelo> vuelos;
    private ListaConMaximo<Avion> aviones;

    public ListaConMaximo<Avion> getAviones() {
        return aviones;
    }

    public void setAviones(ListaConMaximo<Avion> aviones) {
        this.aviones = aviones;
    }

    public Aerolinea(String nombre) {
        this.nombre = nombre;
    }

    public Aerolinea(String nombre, String pais, int cantMaxAviones) {
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

    public void EliminarAvion(Avion avion) {
        this.aviones.eliminarElemento(avion);
    }

    public void AgregarAvionAlInicio(Avion avion) {
        this.aviones.agregarInicio(avion);
    }

    public void AgregarAvionAlFinal(Avion avion) {
        this.aviones.agregarFinal(avion);
    }

    public String MostrarListaAviones() {
        return this.aviones.mostrarLista();
    }

    public boolean SePuedeAgregarAvion() {
        return this.aviones.cantidadElementos() < this.cantMaxAviones;
    }

    public int cantidadAviones() {
        return this.aviones.cantidadElementos();
    }

    public int cantidadPasajesVendidoAvion(Avion avion) {
        int totalPasajes = 0;
        Nodo<Vuelo> vueloActual = vuelos.getInicio();
        while (vueloActual != null) {
            if (vueloActual.getDato().getCodAvion() == avion.getCodigo()) {
                totalPasajes += vueloActual.getDato().getTotalPasajesVendidos();
            }
            vueloActual = vueloActual.getSiguiente();
        }
        return totalPasajes;
    }
    
    public boolean hayPasajesVendidosEnAvion(Avion avion){
        boolean hayPasajes = false;
        Nodo<Vuelo> vueloActual = vuelos.getInicio();
        while (vueloActual != null && !hayPasajes) {
            if (vueloActual.getDato().getCodAvion() == avion.getCodigo() && vueloActual.getDato().getTotalPasajesVendidos()>0) {
                hayPasajes = true;
            }
            vueloActual = vueloActual.getSiguiente();
        }
        return hayPasajes;
    }

    @Override
    public String toString() {
        return this.nombre + "-" + this.pais + "-" + this.cantMaxAviones;
    }

    @Override
    public boolean equals(Object a) {
        if (!this.getClass().equals(a.getClass())) {
            return false;
        } else {
            Aerolinea aerolinea = (Aerolinea) a;

            return this.nombre == aerolinea.getNombre();
        }
    }

    @Override
    public int compareTo(Aerolinea o) {
        Aerolinea objetoAerolinea = (Aerolinea) o;
        return this.nombre.compareTo(objetoAerolinea.nombre);
    }
}
