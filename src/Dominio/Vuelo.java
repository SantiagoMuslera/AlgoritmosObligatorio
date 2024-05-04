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
public class Vuelo implements Comparable <Vuelo>{
    
    private String codigoVuelo;
    private String aerolinea;
    private String codAvion;
    private String paisDestino;
    private int dia;
    private int mes;
    private int anio;
    private int cantPasajesEcon;
    private int cantPasajesPClase;

   
    
    public Vuelo (String codigoVuelo, String aerolinea,String codAvion, String paisDestino, int dia, int mes,int anio,int cantPasajesEcon, int cantPasajesPClase)
    {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.codAvion = codAvion;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.cantPasajesEcon =cantPasajesEcon;
        this.cantPasajesPClase = cantPasajesPClase;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getCodAvion() {
        return codAvion;
    }

    public void setCodAvion(String codAvion) {
        this.codAvion = codAvion;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getCantPasajesEcon() {
        return cantPasajesEcon;
    }

    public void setCantPasajesEcon(int cantPasajesEcon) {
        this.cantPasajesEcon = cantPasajesEcon;
    }

    public int getCantPasajesPClase() {
        return cantPasajesPClase;
    }

    public void setCantPasajesPClase(int cantPasajesPClase) {
        this.cantPasajesPClase = cantPasajesPClase;
    }

    

    @Override
    public boolean equals(Object vuelo) {
   
        if (!this.getClass().equals(vuelo.getClass())) {
            return false;
        }else{
           Vuelo otroVuelo = (Vuelo) vuelo;
        return this.codigoVuelo == otroVuelo.codigoVuelo; 
        } 
    }
    
     @Override
    public String toString() {
        return "Vuelo{" + "codigoVuelo=" + codigoVuelo + ", aerolinea=" + aerolinea + ", codAvion=" + codAvion + ", paisDestino=" + paisDestino + ", dia=" + dia + ", mes=" + mes + ", anio=" + anio + ", cantPasajesEcon=" + cantPasajesEcon + ", cantPasajesPClase=" + cantPasajesPClase + '}';
    }
    
    public int compareTo(Vuelo vuelo) {
       Vuelo otroVuelo= (Vuelo) vuelo;
       return this.codigoVuelo.compareTo(otroVuelo.codigoVuelo);
    }

}