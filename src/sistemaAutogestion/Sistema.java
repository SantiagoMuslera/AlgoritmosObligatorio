package sistemaAutogestion;

import java.util.*;

public class Sistema implements IObligatorio {

    //1.1
    @Override
    public Retorno crearSistemaDeGestion() {
        return Retorno.noImplementada();
    }

    //1.2
    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
        int a = 5;
        return Retorno.noImplementada();
    }

    //1.3
    @Override
    public Retorno eliminarAerolinea(String nombre) {
        return Retorno.noImplementada();
    }

    //1.4
    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        //simulacion de la lista de aerolineas(luego se elimina )
        ArrayList<Aerolinea> aerolineas = new ArrayList<Aerolinea>();
        //La capacidad es menor a 9 o no es multiplo de 3
        if (capacidadMax < 9 || capacidadMax % 3 != 0) {
            return Retorno.error2();
        }
        //No existe la aerolinea
        if (!aerolineas.contains(nomAerolinea)) {
            return Retorno.error3();
        }
        Aerolinea aero;
        boolean found = false;
        int i = 0;
        while (!found && i<aerolineas.size()) {
            if (aerolineas.get(i).getNombre() == nomAerolinea) {
                aero = aerolineas.get(i);
                found = true;
            }
            i++;
        }
        //El codigo ya esta en la aerolinea
        if(true/*Se busca dentro de la lista de aerolinea dentro de sus avione si tiene el avion*/){
            return Retorno.error1();
        }
        //finalmente si no esta en el codigo en la aerolinea se agrega el avion.
        //aero.AddAvion(new Avion(codigo,capacidadMax));
        return Retorno.noImplementada();
    }

    //1.5
    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        return Retorno.noImplementada();
    }

    //1.6
    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        return Retorno.noImplementada();
    }

    //1.7
    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        return Retorno.noImplementada();
    }

    //1.8
    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {
        return Retorno.noImplementada();
    }

    //1.9
    @Override
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {
        return Retorno.noImplementada();
    }

    //2.1
    @Override
    public Retorno listarAerolineas() {
        return Retorno.noImplementada();
    }

    //2.2
    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        return Retorno.noImplementada();
    }

    //2.3
    @Override
    public Retorno listarClientes() {
        return Retorno.noImplementada();
    }

    //2.4
    @Override
    public Retorno listarVuelos() {
        return Retorno.noImplementada();
    }

    //2.5
    @Override
    public Retorno vuelosDeCliente(String pasaporte) {
        return Retorno.noImplementada();
    }

    //2.6
    @Override
    public Retorno pasajesDevueltos(String nombreAerolinea) {
        return Retorno.noImplementada();
    }

    //2.7
    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {
        return Retorno.noImplementada();
    }

}
