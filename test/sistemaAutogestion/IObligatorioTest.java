package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IObligatorioTest {
    
    private Sistema miSistema;
    
    public IObligatorioTest() {
        
    }
    
    @Before
    public void setUp() {
        miSistema = new Sistema();
        miSistema.crearSistemaDeGestion();
        miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 40);
        miSistema.registrarAvion("avion1", 60, "Aerolineas Argentinas");
        
		//Coloca aquí cualquier otra inicialización de listas necesaria
    }

    @Test
    public void testCrearSistemaDeGestion() {
        //Completar para primera entrega
        Retorno re = this.miSistema.crearSistemaDeGestion();
        assertEquals(Retorno.ok().resultado,re.resultado);
    }

    @Test
    public void testCrearAerolinea() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Iberia", "España", 35);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Iberia", "Italia", 45);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 0);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", -5);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolinea() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Iberia", "España", 35);
        assertEquals(Retorno.ok().resultado, r.resultado);
     
        r = miSistema.eliminarAerolinea("Aerolineas Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r =  miSistema.eliminarAerolinea("Aerolineas Perú");
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvion() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Iberia", "España", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarAvion("avion2", 12, "Aerolineas Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarAvion("avion2", 27, "Aerolineas Iberia");
        assertEquals(Retorno.error1().resultado, r.resultado);
        
        r = miSistema.registrarAvion("avion3", 20, "Aerolineas Iberia");
        assertEquals(Retorno.error2().resultado, r.resultado);
        
        r = miSistema.registrarAvion("avion3", 6, "Aerolineas Iberia");
        assertEquals(Retorno.error2().resultado, r.resultado);
        
        r = miSistema.registrarAvion("avion4", 21, "Aerolineas Perú");
        assertEquals(Retorno.error3().resultado, r.resultado);
        
    }

    @Test
    public void testEliminarAvion() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Brasil", "Brasil", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "avion1");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.eliminarAvion("Aerolineas Uruguay", "avion1");
        assertEquals(Retorno.error1().resultado, r.resultado);
        
        r = miSistema.eliminarAvion("Aerolineas Brasil", "avion3");
        assertEquals(Retorno.error2().resultado, r.resultado);
        
        // No se testeo el error 3 porque no se implementó el agregar pasaje.
    }
    @Test
    public void testListarAerolineas1() {
        Retorno r = miSistema.crearAerolinea("Gol", "Brasil", 10);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 2);
        
        r = miSistema.listarAerolineas();
        assertEquals("Pluna-Uruguay-2|\nGol-Brasil-10|\nAerolineas Argentinas-Argentina-40", r.valorString);
    }

    @Test
    public void testListarAvionesDeAerolinea1() {
        Retorno r = miSistema.listarAvionesDeAerolinea("Aerolineas Argentinas");
        assertEquals("avion1-60", r.valorString);
        
        r = miSistema.listarAvionesDeAerolinea("Pluna");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }
/*
    @Test
    public void testRegistrarCliente() {
        //Completar para segunda entrega
    }

    @Test
    public void testCrearVuelo() {
        //Completar para segunda entrega
    }

    @Test
    public void testComprarPasaje() {
        //Completar para segunda entrega
    }

    @Test
    public void testDevolverPasaje() {
        //Completar para segunda entrega
    }

    @Test
    public void testListarClientes() {
        //Completar para segunda entrega
    }

    @Test
    public void testListarVuelos() {
        //Completar para segunda entrega
    }

    @Test
    public void testVuelosDeCliente() {
        //Completar para segunda entrega
    }

    @Test
    public void testPasajesDevueltos() {
        //Completar para segunda entrega
    }

    @Test
    public void testVistaDeVuelo() {
        //Completar para segunda entrega
    }*/

    
}