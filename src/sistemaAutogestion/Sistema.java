package sistemaAutogestion;
import Dominio.Cliente;
import Dominio.Avion;
import Dominio.Aerolinea;
import tads.*;

public class Sistema implements IObligatorio {
    
    private Lista<Aerolinea> listaAerolineas;
    private Lista<Cliente> listaClientes;
    
    public Sistema(){
        this.listaAerolineas = new Lista();
        this.listaClientes = new Lista();
    }
    
    
    //1.1
    @Override
    public Retorno crearSistemaDeGestion() {
        this.listaAerolineas = new Lista<>();
        this.listaClientes = new Lista<>();
        return Retorno.ok();
    }

    //1.2
    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
        Aerolinea aerolinea = new Aerolinea(nombre, pais, cantMaxAviones);
       if(this.listaAerolineas.estaElemento(aerolinea)){
           return Retorno.error1();
       }
       if(cantMaxAviones<=0){
           return Retorno.error2();
       }
       this.listaAerolineas.agregarFinal(aerolinea);
       return Retorno.ok();
    }

    //1.3
    @Override
    public Retorno eliminarAerolinea(String nombre) {
        Aerolinea aerolinea = (Aerolinea)this.listaAerolineas
                .obtenerElemento(new Aerolinea(nombre)).getDato();
        if(!listaAerolineas.estaElemento(aerolinea)){
            return Retorno.error1();
        }
        int cantAviones = aerolinea.cantidadAviones();
        if(cantAviones > 0){
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
        
        Aerolinea aero = (Aerolinea)this.listaAerolineas.obtenerElemento(new Aerolinea(nomAerolinea)).getDato();
        
        Avion avion = new Avion(codigo,capacidadMax,nomAerolinea);
        //El codigo ya esta en la aerolinea
        if(aero.getAviones().estaElemento(avion)){
            return Retorno.error1();
        }
        if(!aero.SePuedeAgregarAvion()){
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
        Aerolinea aero = (Aerolinea)this.listaAerolineas
                .obtenerElemento(new Aerolinea(nomAerolinea)).getDato();
      
        //Si el codigo no esta dentro de la aerolinea
        if(!aero.getAviones().estaElemento(new Avion(codAvion))){
            return Retorno.error2();
        }
        Avion avionBuscado = (Avion)aero.getAviones()
                .obtenerElemento(new Avion(codAvion)).getDato();
        
        if(aero.hayPasajesVendidosEnAvion(avionBuscado)){
            return Retorno.error3();
        }
        
        aero.EliminarAvion(avionBuscado);
        return Retorno.ok();
    }

    //1.6
    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {
        Cliente nuevocliente = new Cliente(pasaporte,nombre,edad);
        if(edad<0){
            return Retorno.error1();
        }
        if(pasaporte.length() != 7){
            return Retorno.error2();
        }
        if(listaClientes.estaElemento(nuevocliente)){
            return Retorno.error3();
        }
        listaClientes.agregarInicio(nuevocliente);
        return Retorno.ok();
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
        String message = this.listaAerolineas.mostrarLista();
        return Retorno.ok(message);
    }

    //2.2
    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        Aerolinea aero = (Aerolinea)this.listaAerolineas
                .obtenerElemento(new Aerolinea(nombre)).getDato();
        if(!this.listaAerolineas.estaElemento(aero)){
            return Retorno.error1();
        }
        return Retorno.ok(aero.MostrarListaAviones());
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
