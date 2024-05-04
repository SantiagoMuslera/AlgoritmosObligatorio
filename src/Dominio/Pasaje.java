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
public class Pasaje {
    private String pasaporteCliente;
    private String codigoVuelo;
    private int categoríaPasaje;
    
    public Pasaje (String pasaporteCliente, String codigoVuelo, int categoriaPasaje){
        this.pasaporteCliente = pasaporteCliente;
        this.codigoVuelo = codigoVuelo;
        this.categoríaPasaje = categoriaPasaje;
    }

    public String getPasaporteCliente() {
        return pasaporteCliente;
    }

    public void setPasaporteCliente(String pasaporteCliente) {
        this.pasaporteCliente = pasaporteCliente;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public int getCategoríaPasaje() {
        return categoríaPasaje;
    }

    public void setCategoríaPasaje(int categoríaPasaje) {
        this.categoríaPasaje = categoríaPasaje;
    }

    @Override
    public String toString() {
        return "Pasaje{" + "pasaporteCliente=" + pasaporteCliente + ", codigoVuelo=" + codigoVuelo + ", categor\u00edaPasaje=" + categoríaPasaje + '}';
    }

    @Override
    public boolean equals(Object pasaje) {
        if (!this.getClass().equals(pasaje.getClass())) {
            return false;
        }  
        Pasaje otroPasaje = (Pasaje)pasaje;
        return Objects.equals(this.codigoVuelo, otroPasaje.codigoVuelo);
    }
}
