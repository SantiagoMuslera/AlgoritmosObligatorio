package sistemaAutogestion;
import tads.*;
import java.util.*;

public class Sistema implements IObligatorio {
    
    private Lista<Aerolinea> listaAerolineas;
    
    public Sistema(){
        this.listaAerolineas = new Lista();
    }
    
    
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
        //La capacidad es menor a 9 o no es multiplo de 3
        if (capacidadMax < 9 || capacidadMax % 3 != 0) {
            return Retorno.error2();
        }
        //No existe la aerolinea
        if (!this.listaAerolineas.estaElemento(new Aerolinea(nomAerolinea))) {
            return Retorno.error3();
        }
        Aerolinea aero = (Aerolinea)this.listaAerolineas.obtenerElemento(new Aerolinea(nomAerolinea)).getDato();
        
        Avion avion = new Avion(codigo,capacidadMax);
        //El codigo ya esta en la aerolinea
        if(aero.getAviones().estaElemento(avion)){
            return Retorno.error1();
        }
        //finalmente si no esta en el codigo en la aerolinea se agrega el avion.
        aero.getAviones().agregarInicio(avion);
        return Retorno.ok();
    }

    //1.5
    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        if (!this.listaAerolineas.estaElemento(new Aerolinea(nomAerolinea))) {
            return Retorno.error1();
        }
        Aerolinea aero = (Aerolinea)this.listaAerolineas
                .obtenerElemento(new Aerolinea(nomAerolinea)).getDato();;
      
        //Si el codigo no esta dentro de la aerolinea
        if(true/*Se busca dentro de la lista de aerolinea dentro de sus avione si tiene el avion*/){
            return Retorno.error2();
        }
        /*
        Avion avionbuscado = aero.Buscar(codAvion);
        if(avionbuscado.size() >0{
            return Retorno.error3();
        }
        */
        /*aero.EliminarAvion(codAvion);*/
        return Retorno.ok();
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
