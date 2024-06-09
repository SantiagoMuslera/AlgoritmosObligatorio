/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

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
    private PilaSimple<Pasaje> pasajesDevueltos;

    public Cliente(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public Cliente(String pasaporte, String nombre, int edad) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.edad = edad;
        this.pasajes = new PilaSimple<>();
        this.pasajesDevueltos = new PilaSimple<>();
    }

    //TODO: FALTA QUITAR EL PASAJE DEVUELTO DE LA PILA Y AÑADIRLO A LA LISTA.
    
    public void devolverPasaje(String codigoVuelo){
        PilaSimple<Pasaje> aux = pasajes.ClonarContenido();
        Pasaje actual = aux.getTope();
        boolean encontrado = false;
        while(actual != null && !encontrado){
            if(actual.getCodigoVuelo().equals(codigoVuelo)){
                aux.desApilar();
                pasajesDevueltos.apilar(actual);
                encontrado = true;
            }else{
                aux.desApilar();
                actual = aux.getTope();
            }
        }
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
            pasajeActual = (Pasaje) this.pasajes.getTope();
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

    public String mostrarTodosLosPasajes() {
        return mostrarPasajesNoDevueltos(this.pasajes.ClonarContenido())
                + mostrarPasajesDevueltos(this.pasajesDevueltos.ClonarContenido());
    }

    private String mostrarPasajesNoDevueltos(PilaSimple<Pasaje> pasajes) {
        if (pasajes.getTope() == null) {
            return "";
        } else {
            String retorno = pasajes.getTope().getCodigoVuelo() + "-" + "CPR";
            pasajes.desApilar();
            if (pasajes.getTope() != null) {
                retorno += "|\n";
            } else {
                if (this.pasajesDevueltos.getTope() == null) retorno += "|";
                else retorno += "|\n";
            }
            return retorno + mostrarPasajesNoDevueltos(pasajes);
        }
    }

    private String mostrarPasajesDevueltos(PilaSimple<Pasaje> pasajes) {
        if (pasajes.getTope() == null) {
            return "";
        } else {
            String retorno = pasajes.getTope().getCodigoVuelo() + "-" + "DEV";
            pasajes.desApilar();
            if (pasajes.getTope() != null) {
                retorno += "|\n";
            }else  retorno += "|";

            return retorno + mostrarPasajesNoDevueltos(pasajes);
        }
    }

    @Override
    public boolean equals(Object cliente) {
        if (!this.getClass().equals(cliente.getClass())) {
            return false;
        } else {
            Cliente otroCliente = (Cliente) cliente;
            return this.pasaporte.equals(otroCliente.pasaporte);
        }
    }

    @Override
    public String toString() {
        return pasaporte + "-" + nombre + "-" + edad;
    }

    @Override
    public int compareTo(Cliente cliente) {
        Cliente otroCliente = (Cliente) cliente;
        return this.pasaporte.compareTo(otroCliente.pasaporte);
    }
}
