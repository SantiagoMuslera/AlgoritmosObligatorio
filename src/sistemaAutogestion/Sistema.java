package sistemaAutogestion;

import Dominio.*;
import tads.*;

public class Sistema implements IObligatorio {

    private Lista<Aerolinea> listaAerolineas;
    private Lista<Cliente> listaClientes;
    private Lista<Vuelo> listaVuelos;

    public Sistema() {
        this.listaAerolineas = new Lista();
        this.listaClientes = new Lista();
        this.listaVuelos = new Lista();
    }

    //1.1
    @Override
    public Retorno crearSistemaDeGestion() {
        this.listaAerolineas = new Lista<>();
        this.listaClientes = new Lista<>();
        this.listaVuelos = new Lista<>();
        return Retorno.ok();
    }

    //1.2
    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
        Aerolinea aerolinea = new Aerolinea(nombre, pais, cantMaxAviones);
        if (this.listaAerolineas.estaElemento(aerolinea)) {
            return Retorno.error1();
        }
        if (cantMaxAviones <= 0) {
            return Retorno.error2();
        }
        this.listaAerolineas.agregarInicio(aerolinea);
        return Retorno.ok();
    }

    //1.3
    @Override
    public Retorno eliminarAerolinea(String nombre) {
        Aerolinea aerolinea = (Aerolinea) this.listaAerolineas
                .obtenerElemento(new Aerolinea(nombre)).getDato();
        if (!listaAerolineas.estaElemento(aerolinea)) {
            return Retorno.error1();
        }
        int cantAviones = aerolinea.cantidadAviones();
        if (cantAviones > 0) {
            return Retorno.error2();
        }
        listaAerolineas.eliminarElemento(aerolinea);
        return Retorno.ok();
    }

    //1.4
    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        //La capacidad es menor a 9 o no es multiplo de 3
        if (capacidadMax < 9 || capacidadMax % 3 != 0) {
            return Retorno.error2();
        }
        //No existe la aerolinea
        if (!this.listaAerolineas.estaElemento(new Aerolinea(nomAerolinea))) {
            return Retorno.error3();
        }

        Aerolinea aero = (Aerolinea) this.listaAerolineas.obtenerElemento(new Aerolinea(nomAerolinea)).getDato();

        Avion avion = new Avion(codigo, capacidadMax, aero);
        //El codigo ya esta en la aerolinea
        if (aero.getAviones().estaElemento(avion)) {
            return Retorno.error1();
        }
        if (!aero.SePuedeAgregarAvion()) {
            return Retorno.error4();
        }
        //finalmente si no esta en el codigo en la aerolinea se agrega el avion.
        aero.AgregarAvionAlInicio(avion);
        return Retorno.ok();
    }

    //1.5
    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        if (!this.listaAerolineas.estaElemento(new Aerolinea(nomAerolinea))) {
            return Retorno.error1();
        }
        Aerolinea aero = (Aerolinea) this.listaAerolineas
                .obtenerElemento(new Aerolinea(nomAerolinea)).getDato();

        //Si el codigo no esta dentro de la aerolinea
        if (!aero.getAviones().estaElemento(new Avion(codAvion))) {
            return Retorno.error2();
        }
        Avion avionBuscado = (Avion) aero.getAviones()
                .obtenerElemento(new Avion(codAvion)).getDato();

        if (aero.hayPasajesVendidosEnAvion(avionBuscado)) {
            return Retorno.error3();
        }

        aero.EliminarAvion(avionBuscado);
        return Retorno.ok();
    }

    //1.6
    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        Cliente nuevocliente = new Cliente(pasaporte, nombre, edad);
        if (edad < 0) {
            return Retorno.error1();
        }
        if (pasaporte.length() != 7) {
            return Retorno.error2();
        }
        if (listaClientes.estaElemento(nuevocliente)) {
            return Retorno.error3();
        }
        listaClientes.agregarInicio(nuevocliente);
        return Retorno.ok();
    }

    //1.7
    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion,
            String paisDestino, int dia, int mes, int año, int cantPasajesEcon,
            int cantPasajesPClase) {
        if (this.listaVuelos.estaElemento(new Vuelo(codigoVuelo))) {
            return Retorno.error1();
        }
        if (!this.listaAerolineas.estaElemento(new Aerolinea(aerolinea))) {
            return Retorno.error2();
        }
        Aerolinea aero = this.listaAerolineas.obtenerElemento(new Aerolinea(aerolinea)).getDato();
        Avion avion = aero.encontrarAvion(codAvion);
        if (!aero.avionExiste(codAvion)) {
            return Retorno.error3();
        }
        if (aero.existeVueloSegunFechaYAvion(codAvion, dia, mes, año)) {
            return Retorno.error4();
        }
        if (cantPasajesEcon % 3 != 0 || cantPasajesPClase % 3 != 0) {
            return Retorno.error5();
        }
        if (avion.getCapacidadMax() > cantPasajesEcon + cantPasajesPClase) {
            int diff = avion.getCapacidadMax() - (cantPasajesEcon + cantPasajesPClase);
            cantPasajesEcon += diff;
        } else {
            if (cantPasajesEcon + cantPasajesPClase > avion.getCapacidadMax()) {
                return Retorno.error6();
            }
        }

        Vuelo nuevoVuelo = new Vuelo(codigoVuelo, aero, avion, paisDestino, dia, mes, año, cantPasajesEcon, cantPasajesPClase);
        aero.agregarVuelo(nuevoVuelo);
        this.listaVuelos.agregarInicio(nuevoVuelo);
        return Retorno.ok();
    }

    //1.8
    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {
        if (!this.listaClientes.estaElemento(new Cliente(pasaporteCliente))) {
            return Retorno.error1();
        }
        if (!this.listaVuelos.estaElemento(new Vuelo(codigoVuelo))) {
            return Retorno.error2();
        }
        Cliente cliente = this.listaClientes.obtenerElemento(new Cliente(pasaporteCliente)).getDato();
        Vuelo vueloBuscado = this.listaVuelos.obtenerElemento(new Vuelo(codigoVuelo)).getDato();
        Pasaje pasajeNuevo = new Pasaje(cliente, vueloBuscado, categoríaPasaje);
        cliente.AgregarPasajeAlInicio(pasajeNuevo);
        if (categoríaPasaje == 1) {
            if (vueloBuscado.boletosEconomicosLleno()) {
                vueloBuscado.agregarPasajeEconomicoEnEspera(pasajeNuevo);
            } else {
                vueloBuscado.agregarPasajeEconomico(pasajeNuevo);
            }
        } else {
            if (vueloBuscado.boletosPrimeraClaseLleno()) {
                vueloBuscado.agregarPasajePrimeraClaseEnEspera(pasajeNuevo);
            } else {
                vueloBuscado.agregarPasajePrimeraClase(pasajeNuevo);
            }
        }
        return Retorno.ok();
    }

    //1.9
    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        if (!this.listaClientes.estaElemento(new Cliente(pasaporteCliente))) {
            return Retorno.error1();
        }
        if (!this.listaVuelos.estaElemento(new Vuelo(codigoVuelo))) {
            return Retorno.error2();
        }
        Cliente cliente = this.listaClientes.obtenerElemento(new Cliente(pasaporteCliente)).getDato();
        Vuelo vueloBuscado = this.listaVuelos.obtenerElemento(new Vuelo(codigoVuelo)).getDato();
        if (!vueloBuscado.clienteTienePasaje(cliente)) {
            return Retorno.error3();
        }
        Pasaje pasaje = vueloBuscado.obtenerPasaje(cliente);
        vueloBuscado.getAerolinea().agregarPasajeDevuelo(pasaje);
        vueloBuscado.devolverPasaje(cliente);
        //TODO: FALTA AÑADIR A LA LISTA DE DEVUELTOS EN CLIENTE Y QUITARLE EL PASAJE DE LA PILA.
        return Retorno.ok();
    }

    //2.1
    @Override
    public Retorno listarAerolineas() {
        String message = this.listaAerolineas.mostrarLista();
        return Retorno.ok(message);
    }

    //2.2
    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        Aerolinea aero = (Aerolinea) this.listaAerolineas
                .obtenerElemento(new Aerolinea(nombre)).getDato();
        if (!this.listaAerolineas.estaElemento(aero)) {
            return Retorno.error1();
        }
        return Retorno.ok(aero.MostrarListaAviones());
    }

    //2.3
    @Override
    public Retorno listarClientes() {
        return Retorno.ok(this.listaClientes.mostrarListaREC());
    }

    //2.4
    @Override
    public Retorno listarVuelos() {
        StringBuilder sb = new StringBuilder();
        Nodo<Vuelo> actual = this.listaVuelos.getInicio();
        while (actual != null) {
            Vuelo dato = actual.getDato();
            sb.append(dato.getCodigoVuelo()).append("-")
                    .append(dato.getAerolinea().getNombre()).append("-")
                    .append(dato.getAvion().getCodigo()).append("-")
                    .append(dato.getPasajesEconomicos().cantidadElementos()).append("-")
                    .append(dato.getPasajesPrimeraClase().cantidadElementos()).append("-")
                    .append(dato.getCantidadDeAsientosDisponibles()).append("|");
            if (actual.getSiguiente() != null) {
                sb.append("\n");
            }
            actual = actual.getSiguiente();
        }
        return Retorno.ok(sb.toString());
    }

    //2.5
    @Override
    public Retorno vuelosDeCliente(String pasaporte) {
        Cliente cliente = new Cliente(pasaporte);
        if (!this.listaClientes.estaElemento(cliente)) {
            return Retorno.error1();
        }
        return Retorno.ok(this.listaClientes.obtenerElemento(cliente).getDato().mostrarTodosLosPasajes());
    }

    //2.6
    @Override
    public Retorno pasajesDevueltos(String nombreAerolinea) {
        Aerolinea ae = new Aerolinea(nombreAerolinea);
        if (!this.listaAerolineas.estaElemento(ae)) {
            return Retorno.error1();
        }
        String pasajesDevueltos = this.listaAerolineas.obtenerElemento(ae).getDato().mostrarPasajesDevueltos();
        return Retorno.ok(pasajesDevueltos);
    }

    //2.7
    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {
        Vuelo vuelo = buscarVuelo(codigoVuelo);
        Avion avion = vuelo.getAvion();
        int totalAsientos = avion.getCapacidadMax();

        StringBuilder vista = new StringBuilder();

        // Se agrega la seccion de Primera Clase
        vista.append("**********************************\n");
        vista.append("* PRIMERA * \n");
        vista.append("**********************************\n");

        //Se agregan los asientos de primera clase
        Lista<Cliente> pasajerosPrimeraClase = vuelo.obtenerPasajerosPrimeraClase();
        int asientosPrimeraClase = vuelo.getCantidadPasajesPrimeraClase();
        String[][] primeraClase = generarVistaAsientos(pasajerosPrimeraClase, asientosPrimeraClase);
        agregarSeccionVista(vista, primeraClase);

        // Se agrega la seccion de Economica
        vista.append("**********************************\n");
        vista.append("* ECONÓMICA *\n");
        vista.append("**********************************\n");
        
        //Se agregan los asientos de la seccion economica
        Lista<Cliente> pasajerosEconomica = vuelo.obtenerPasajerosEconomica();
        int asientosEconomica = vuelo.getCantidadPasajesEconomica();
        String [][] economica = generarVistaAsientos(pasajerosEconomica, asientosEconomica);
        agregarSeccionVista(vista,economica);
        
        return Retorno.ok(vista.toString());

    }

    // Metodo auxiliar para buscar un buelo segun el codigo de vuelo
    public Vuelo buscarVuelo(String codigoVuelo) {
        Nodo<Vuelo> nodoVuelo = this.listaVuelos.getInicio();
        while (nodoVuelo != null) {
            Vuelo vuelo = nodoVuelo.getDato();
            if (vuelo.getCodigoVuelo().equals(codigoVuelo)) {
                return vuelo;
            }
            nodoVuelo = nodoVuelo.getSiguiente();
        }
        return null;
    }

    // Metodo auxiliar para generar la vista de los asientos
    public String[][] generarVistaAsientos(Lista<Cliente> pasajeros, int totalAsientos) {
        int filas = totalAsientos / 3;
        String[][] asientos = new String[filas][3];

        Nodo<Cliente> nodoCliente = pasajeros.getInicio();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 3; j++) {
                if (nodoCliente != null) {
                    asientos[i][j] = nodoCliente.getDato().getPasaporte();
                    nodoCliente = nodoCliente.getSiguiente();
                } else {
                    asientos[i][j] = "XXXXXX";
                }

            }
        }
        return asientos;
    }

    public void agregarSeccionVista(StringBuilder vista, String[][] asientos) {
        for (String[] fila : asientos) {
            vista.append(" * ");
            for (String asiento : fila) {
                vista.append(asiento).append(" * ");
            }
            vista.append("\n**********************************\n");
        }
    }
}
