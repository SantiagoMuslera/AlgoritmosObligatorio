package Dominio;


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
        this.aviones = new ListaConMaximo<>(cantMaxAviones);
        this.vuelos = new Lista<>();
        this.pasajesDevueltos = new Lista<>();
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
    
    public void agregarVuelo(Vuelo v){
        this.vuelos.agregarInicio(v);
    }
    
    public String mostrarPasajesDevueltos(){
        Nodo<Pasaje> actual = this.pasajesDevueltos.getInicio();
        StringBuilder sb = new StringBuilder();
        while(actual != null){
            sb.append(actual.getDato().getPasaporteCliente().getPasaporte()).append("-")
                    .append(actual.getDato().getCodigoVuelo());
            if(actual.getSiguiente()!=null){
               sb.append("|\n"); 
            }
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
    
    public boolean existeVueloSegunFechaYAvion(String codAvion, int dia,int mes,int año){
        Nodo<Vuelo> nodoActual = this.vuelos.getInicio();
        boolean existeVuelo = false;
        while(nodoActual !=null && !existeVuelo){
            Vuelo datoActual = nodoActual.getDato();
            if(datoActual.getAvion().getCodigo().equals(codAvion) &&
                    datoActual.getDia() == dia && datoActual.getMes() == mes &&
                    datoActual.getAnio() == año){
                existeVuelo = true;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return existeVuelo;
    }
    
    public boolean avionExiste(String codAvion){
        return this.aviones.estaElemento(new Avion(codAvion));
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
            if (vueloActual.getDato().getAvion().getCodigo() == avion.getCodigo()) {
                totalPasajes += vueloActual.getDato().getTotalPasajesVendidos();
            }
            vueloActual = vueloActual.getSiguiente();
        }
        return totalPasajes;
    }
    
    public void agregarPasajeDevuelo(Pasaje item){
        this.pasajesDevueltos.agregarFinal(item);
    }
    
    public Avion encontrarAvion(String codAvion){
        return this.aviones.obtenerElemento(new Avion(codAvion)).getDato();
    }
    
    public boolean hayPasajesVendidosEnAvion(Avion avion){
        boolean hayPasajes = false;
        Nodo<Vuelo> vueloActual = vuelos.getInicio();
        while (vueloActual != null && !hayPasajes) {
            if (vueloActual.getDato().getAvion().equals(avion.getCodigo()) && vueloActual.getDato().getTotalPasajesVendidos()>0) {
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
