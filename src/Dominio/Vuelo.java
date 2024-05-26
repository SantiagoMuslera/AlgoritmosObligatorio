/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Objects;
import tads.*;
import tads.ListaConMaximo;

/**
 *
 * @author Santiago
 */
public class Vuelo implements Comparable<Vuelo> {

    private String codigoVuelo;
    private String aerolinea;
    private String codAvion;
    private String paisDestino;
    private int dia;
    private int mes;
    private int anio;
    private Cola<Pasaje> pasajesPrimeraClaseEnEspera;
    private Cola<Pasaje> pasajesEconomicosEnEspera;
    private ListaConMaximo<Pasaje> pasajesEconomicos;
    private ListaConMaximo<Pasaje> pasajesPrimeraClase;

    public Vuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public Vuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int anio, int cantPasajesEcon, int cantPasajesPClase) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.codAvion = codAvion;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.pasajesEconomicos = new ListaConMaximo<>(cantPasajesEcon);
        this.pasajesPrimeraClase = new ListaConMaximo<>(cantPasajesPClase);
        this.pasajesEconomicosEnEspera = new Cola();
        this.pasajesPrimeraClaseEnEspera = new Cola();

    }

    public Pasaje obtenerPasaje(String pasaporteCliente, String codigoVuelo) {
        Pasaje aux = new Pasaje(pasaporteCliente, codigoVuelo);
        if (this.pasajesEconomicos.estaElemento(aux)) {
            return this.pasajesEconomicos.obtenerElemento(aux).getDato();
        } else {
            if (this.pasajesPrimeraClase.estaElemento(aux)) {
                return this.pasajesPrimeraClase.obtenerElemento(aux).getDato();
            } else {
                if (this.pasajesEconomicosEnEspera.estaElemento(aux)) {
                    //return this.pasajesEconomicosEnEspera.obtenerElemento(aux).getDato();
                }else{
                    if(this.pasajesPrimeraClaseEnEspera.estaElemento(aux)){
                        //return this.pasajesEconomicosEnEspera.obtenerElemento(aux).getDato();
                    }
                }
            }
        }
        return null;
    }

    public void devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        Pasaje aux = new Pasaje(pasaporteCliente, codigoVuelo);
        if (this.pasajesEconomicos.estaElemento(aux)) {
            this.pasajesEconomicos.eliminarElemento(aux);
            this.pasajesEconomicos.agregarFinal(this.pasajesEconomicosEnEspera.frente().getDato());
            this.pasajesEconomicosEnEspera.desencolar();
        } else {
            if (this.pasajesPrimeraClase.estaElemento(aux)) {
                 this.pasajesPrimeraClase.eliminarElemento(aux);
                 this.pasajesPrimeraClase.agregarFinal(this.pasajesPrimeraClaseEnEspera.frente().getDato());
                 this.pasajesPrimeraClaseEnEspera.desencolar();
            } else {
                if (this.pasajesEconomicosEnEspera.estaElemento(aux)) {
                    this.pasajesEconomicosEnEspera.eliminarElemento(aux);
                }else{
                    if(this.pasajesPrimeraClaseEnEspera.estaElemento(aux)){
                        this.pasajesPrimeraClaseEnEspera.eliminarElemento(aux);
                    }
                }
            }
        }
    }

    public boolean clienteTienePasaje(String pasaporteCliente, String codigoVuelo) {
        return clienteEnEspera(pasaporteCliente, codigoVuelo)
                || clienteEnVuelo(pasaporteCliente, codigoVuelo);
    }

    private boolean clienteEnEspera(String pasaporteCliente, String codigoVuelo) {
        return clienteEnEsperaEconomico(pasaporteCliente, codigoVuelo)
                || clienteEnEsperaPrimeraClase(pasaporteCliente, codigoVuelo);
    }

    private boolean clienteEnEsperaEconomico(String pasaporteCliente, String codigoVuelo) {
        return this.pasajesEconomicosEnEspera.
                estaElemento(new Pasaje(pasaporteCliente, codigoVuelo));
    }

    private boolean clienteEnEsperaPrimeraClase(String pasaporteCliente, String codigoVuelo) {
        return this.pasajesPrimeraClaseEnEspera.
                estaElemento(new Pasaje(pasaporteCliente, codigoVuelo));
    }

    private boolean clienteEnVuelo(String pasaporteCliente, String codigoVuelo) {

        return clienteEnVueloTipoEconomico(pasaporteCliente, codigoVuelo)
                || clienteEnVueloTipoPrimeraClase(pasaporteCliente, codigoVuelo);
    }

    private boolean clienteEnVueloTipoEconomico(String pasaporteCliente, String codigoVuelo) {
        return this.pasajesEconomicos.estaElemento(new Pasaje(pasaporteCliente, codigoVuelo));
    }

    private boolean clienteEnVueloTipoPrimeraClase(String pasaporteCliente, String codigoVuelo) {
        return this.pasajesPrimeraClase.estaElemento(new Pasaje(pasaporteCliente, codigoVuelo));
    }

    public boolean boletosPrimeraClaseLleno() {
        return this.pasajesPrimeraClase.estaLlena();
    }

    public boolean boletosEconomicosLleno() {
        return this.pasajesEconomicos.estaLlena();
    }

    public void agregarPasajeEconomicoEnEspera(Pasaje item) {
        pasajesEconomicosEnEspera.encolar(item);
    }

    public void agregarPasajePrimeraClaseEnEspera(Pasaje item) {
        pasajesPrimeraClaseEnEspera.encolar(item);
    }

    public void agregarPasajePrimeraClase(Pasaje item) {
        this.pasajesEconomicos.agregarFinal(item);
    }

    public void agregarPasajeEconomico(Pasaje item) {
        pasajesPrimeraClase.agregarFinal(item);
    }

    public int getTotalPasajesVendidos() {
        return this.pasajesEconomicos.getCantidad()
                + this.pasajesPrimeraClase.getCantidad();
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public void AgregarPasaje(Pasaje pasaje) {
        if (pasaje.getCategoríaPasaje() == 1) {
            this.pasajesEconomicos.agregarInicio(pasaje);
        } else {
            this.pasajesPrimeraClase.agregarInicio(pasaje);
        }
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

    @Override
    public boolean equals(Object vuelo) {

        if (!this.getClass().equals(vuelo.getClass())) {
            return false;
        } else {
            Vuelo otroVuelo = (Vuelo) vuelo;
            return this.codigoVuelo == otroVuelo.codigoVuelo;
        }
    }

    @Override
    public String toString() {
        return this.codigoVuelo+"-"+this.aerolinea+"-"+this.codAvion+
                this.pasajesEconomicos.getCantidad()+"-"
                +this.pasajesPrimeraClase.getCantidad()+"-"+
                (pasajesEconomicos.espacioRestante()+pasajesPrimeraClase.espacioRestante());
    }

    @Override
    public int compareTo(Vuelo vuelo) {
        Vuelo otroVuelo = (Vuelo) vuelo;
        return this.codigoVuelo.compareTo(otroVuelo.codigoVuelo);
    }

}
