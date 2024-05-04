/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Objects;
import tads.*;

/**
 *
 * @author Santiago
 */
public class Cliente implements Comparable<Cliente> {

    private String pasaporte; //alfanumerico, 7 caracteres
    private String nombre;
    private int edad;
    private PilaSimple<Pasaje> pasajes;

    public Cliente(String pasaporte, String nombre, int edad) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void EliminarUltimoPasaje() {
        this.pasajes.desApilar();
    }

    public void EliminarPasaje(Pasaje pasaje) {
        Pasaje pasajeActual = this.pasajes.getTope();
        PilaSimple<Pasaje> aux = new PilaSimple();
        for (int i = 0; i < this.pasajes.cantidadElementos(); i++) {
            if (pasaje.equals(pasajeActual)) {
                this.pasajes.desApilar();
            } else {
                aux.apilar(pasajeActual);
                this.pasajes.desApilar();
            }
            pasajeActual = (Pasaje)this.pasajes.getTope();
        }
        Pasaje pasajeAuxActual = aux.getTope();
        for (int i = 0; i < aux.cantidadElementos(); i++) {
            this.pasajes.apilar(pasajeAuxActual);
            aux.desApilar();
            pasajeAuxActual = aux.getTope();
        }
    }

    public void AgregarPasajeAlInicio(Pasaje pasaje) {
        this.pasajes.apilar(pasaje);
    }

    public String MostrarListaPasajes() {
        return this.pasajes.MostrarContenido();
    }

    @Override
    public boolean equals(Object cliente) {
        if (!this.getClass().equals(cliente.getClass())) {
            return false;
        } else {
            Cliente otroCliente = (Cliente) cliente;
            return this.pasaporte == otroCliente.pasaporte;
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "pasaporte=" + pasaporte + ", nombre=" + nombre + ", edad=" + edad + '}';
    }

    @Override
    public int compareTo(Cliente cliente) {
        Cliente otroCliente = (Cliente) cliente;
        return this.pasaporte.compareTo(otroCliente.pasaporte);
    }
}
