/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Objects;

/**
 *
 * @author Santiago
 */
public class Pasaje implements Comparable <Pasaje> {
    private Cliente cliente;
    private Vuelo vuelo;
    private int categoriaPasaje;
    
    public Pasaje(Cliente pasaporteCliente, Vuelo vuelo){
        this.cliente = pasaporteCliente;
        this.vuelo = vuelo;
    }
    
    public Pasaje (Cliente pasaporteCliente, Vuelo vuelo, int categoriaPasaje){
        this.cliente = pasaporteCliente;
        this.vuelo = vuelo;
        this.categoriaPasaje = categoriaPasaje;
    }

    public Cliente getPasaporteCliente() {
        return cliente;
    }

    public void setPasaporteCliente(Cliente pasaporteCliente) {
        this.cliente = pasaporteCliente;
    }

    public String getCodigoVuelo() {
        return vuelo.getCodigoVuelo();
    }

    public void setCodigoVuelo(Vuelo codigoVuelo) {
        this.vuelo = codigoVuelo;
    }

    public int getCategoríaPasaje() {
        return categoriaPasaje;
    }

    public void setCategoríaPasaje(int categoríaPasaje) {
        this.categoriaPasaje = categoríaPasaje;
    }

    @Override
    public String toString() {
        return "Pasaje{" + "pasaporteCliente=" + this.cliente.getPasaporte() + ", codigoVuelo=" + this.vuelo.getCodigoVuelo() + ", categor\u00edaPasaje=" + categoriaPasaje + '}';
    }

    @Override
    public boolean equals(Object pasaje) {
        if (!this.getClass().equals(pasaje.getClass())) {
            return false;
        }  
        Pasaje otroPasaje = (Pasaje)pasaje;
        return Objects.equals(this.cliente.getPasaporte(), otroPasaje.cliente.getPasaporte()) && this.vuelo.getCodigoVuelo().equals(otroPasaje.vuelo.getCodigoVuelo());
    }
    
    public int compareTo(Pasaje pasaje) {
       Pasaje otroPasaje= (Pasaje) pasaje;
       return this.vuelo.getCodigoVuelo().compareTo(otroPasaje.vuelo.getCodigoVuelo());
    }
}
