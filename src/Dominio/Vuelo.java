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
    private Aerolinea aerolinea;
    private Avion avion;
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

    public Vuelo(String codigoVuelo, Aerolinea aerolinea, Avion Avion, String paisDestino, int dia, int mes, int anio, int cantPasajesEcon, int cantPasajesPClase) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.avion = Avion;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.pasajesEconomicos = new ListaConMaximo<>(cantPasajesEcon);
        this.pasajesPrimeraClase = new ListaConMaximo<>(cantPasajesPClase);
        this.pasajesEconomicosEnEspera = new Cola<>();
        this.pasajesPrimeraClaseEnEspera = new Cola<>();

    }

    public Pasaje obtenerPasaje(Cliente cliente) {
        Pasaje aux = new Pasaje(cliente, this);
        if (this.pasajesEconomicos.estaElemento(aux)) {
            return this.pasajesEconomicos.obtenerElemento(aux).getDato();
        } else {
            if (this.pasajesPrimeraClase.estaElemento(aux)) {
                return this.pasajesPrimeraClase.obtenerElemento(aux).getDato();
            } else {
                if (this.pasajesEconomicosEnEspera.estaElemento(aux)) {
                    //return this.pasajesEconomicosEnEspera.obtenerElemento(aux).getDato();
                } else {
                    if (this.pasajesPrimeraClaseEnEspera.estaElemento(aux)) {
                        //return this.pasajesEconomicosEnEspera.obtenerElemento(aux).getDato();
                    }
                }
            }
        }
        return null;
    }

    public void devolverPasaje(Cliente cliente) {
        Pasaje aux = new Pasaje(cliente, this);
        if (this.pasajesEconomicos.estaElemento(aux)) {
            this.pasajesEconomicos.eliminarElemento(aux);
            Nodo<Pasaje> aDesencolar = this.pasajesEconomicosEnEspera.frente();
            if (aDesencolar != null) {
                this.pasajesEconomicos.agregarFinal(aDesencolar.getDato());
                this.pasajesEconomicosEnEspera.desencolar();
            }
        } else {
            if (this.pasajesPrimeraClase.estaElemento(aux)) {
                this.pasajesPrimeraClase.eliminarElemento(aux);
                Nodo<Pasaje> aDesencolar = this.pasajesPrimeraClaseEnEspera.frente();
                if (aDesencolar != null) {
                    this.pasajesPrimeraClase.agregarFinal(aDesencolar.getDato());
                    this.pasajesPrimeraClaseEnEspera.desencolar();
                }
            } else {
                if (this.pasajesEconomicosEnEspera.estaElemento(aux)) {
                    this.pasajesEconomicosEnEspera.eliminarElemento(aux);
                } else {
                    if (this.pasajesPrimeraClaseEnEspera.estaElemento(aux)) {
                        this.pasajesPrimeraClaseEnEspera.eliminarElemento(aux);
                    }
                }
            }
        }
    }

    public boolean clienteTienePasaje(Cliente cliente) {
        return clienteEnEspera(cliente)
                || clienteEnVuelo(cliente);
    }

    private boolean clienteEnEspera(Cliente cliente) {
        return clienteEnEsperaEconomico(cliente)
                || clienteEnEsperaPrimeraClase(cliente);
    }

    private boolean clienteEnEsperaEconomico(Cliente cliente) {
        return this.pasajesEconomicosEnEspera.
                estaElemento(new Pasaje(cliente, this));
    }

    private boolean clienteEnEsperaPrimeraClase(Cliente cliente) {
        return this.pasajesPrimeraClaseEnEspera.
                estaElemento(new Pasaje(cliente, this));
    }

    private boolean clienteEnVuelo(Cliente cliente) {

        return clienteEnVueloTipoEconomico(cliente)
                || clienteEnVueloTipoPrimeraClase(cliente);
    }

    private boolean clienteEnVueloTipoEconomico(Cliente cliente) {
        return this.pasajesEconomicos.estaElemento(new Pasaje(cliente, this));
    }

    private boolean clienteEnVueloTipoPrimeraClase(Cliente cliente) {
        return this.pasajesPrimeraClase.estaElemento(new Pasaje(cliente, this));
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
    
    
    public int getCantidadDeAsientosDisponibles(){
        int capMax = this.avion.getCapacidadMax();
        return capMax - (this.getTotalPasajesVendidos());
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setCodAvion(Avion codAvion) {
        this.avion = codAvion;
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
    
    public Lista<Cliente> obtenerPasajerosPrimeraClase() {
        Lista<Cliente> pasajeros = new Lista<Cliente>();
        Nodo<Pasaje> actual = pasajesPrimeraClase.getInicio();
        while (actual != null) {
            pasajeros.agregarFinal(actual.getDato().getPasaporteCliente());
            actual = actual.getSiguiente();
        }
        return pasajeros;
    }
    
    public Lista<Cliente> obtenerPasajerosEconomica() {
        Lista<Cliente> pasajeros = new Lista<Cliente>();
        Nodo<Pasaje> actual = pasajesEconomicos.getInicio();
        while (actual != null) {
            pasajeros.agregarFinal(actual.getDato().getPasaporteCliente());
            actual = actual.getSiguiente();
        }
        return pasajeros;
    }
    
    public int getCantidadPasajesPrimeraClase(){
        return this.pasajesPrimeraClase.getCantidad();
    }
    public int getCantidadPasajesEconomica(){
        return this.pasajesEconomicos.getCantidad();
    }
    public ListaConMaximo<Pasaje> getPasajesEconomicos() {
        return pasajesEconomicos;
    }

    public ListaConMaximo<Pasaje> getPasajesPrimeraClase() {
        return pasajesPrimeraClase;
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
        return this.codigoVuelo + "-" + this.aerolinea + "-" + this.avion.getCodigo()
                + this.pasajesEconomicos.getCantidad() + "-"
                + this.pasajesPrimeraClase.getCantidad() + "-"
                + (pasajesEconomicos.espacioRestante() + pasajesPrimeraClase.espacioRestante());
    }

    @Override
    public int compareTo(Vuelo vuelo) {
        Vuelo otroVuelo = (Vuelo) vuelo;
        return this.codigoVuelo.compareTo(otroVuelo.codigoVuelo);
    }

}
