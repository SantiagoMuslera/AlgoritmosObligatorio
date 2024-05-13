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
    private String pasaporteCliente;
    private String codigoVuelo;
    private int categoriaPasaje;
    
    public Pasaje(String pasaporteCliente, String codigoVuelo){
        this.pasaporteCliente = pasaporteCliente;
        this.codigoVuelo = codigoVuelo;
    }
    
    public Pasaje (String pasaporteCliente, String codigoVuelo, int categoriaPasaje){
        this.pasaporteCliente = pasaporteCliente;
        this.codigoVuelo = codigoVuelo;
        this.categoriaPasaje = categoriaPasaje;
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
        return categoriaPasaje;
    }

    public void setCategoríaPasaje(int categoríaPasaje) {
        this.categoriaPasaje = categoríaPasaje;
    }

    @Override
    public String toString() {
        return "Pasaje{" + "pasaporteCliente=" + pasaporteCliente + ", codigoVuelo=" + codigoVuelo + ", categor\u00edaPasaje=" + categoriaPasaje + '}';
    }

    @Override
    public boolean equals(Object pasaje) {
        if (!this.getClass().equals(pasaje.getClass())) {
            return false;
        }  
        Pasaje otroPasaje = (Pasaje)pasaje;
        return Objects.equals(this.pasaporteCliente, otroPasaje.pasaporteCliente) && this.codigoVuelo.equals(otroPasaje.codigoVuelo);
    }
    
    public int compareTo(Pasaje pasaje) {
       Pasaje otroPasaje= (Pasaje) pasaje;
       return this.codigoVuelo.compareTo(otroPasaje.codigoVuelo);
    }
}
