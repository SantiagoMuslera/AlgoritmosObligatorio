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
    }

    @Test
    public void testCrearSistemaDeGestion() {
        //Completar para primera entrega
        Retorno re = this.miSistema.crearSistemaDeGestion();
        assertEquals(Retorno.ok().resultado,re.resultado);
    }

    @Test
    public void testCrearAerolinea() {
        //Completar para primera entrega
    }

    @Test
    public void testEliminarAerolinea() {
        //Completar para primera entrega
    }

    @Test
    public void testRegistrarAvion() {
        //Completar para primera entrega
    }

    @Test
    public void testEliminarAvion() {
        //Completar para primera entrega
    }

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
    public void testListarAerolineas() {
        //Completar para primera entrega
    }

    @Test
    public void testListarAvionesDeAerolinea() {
        //Completar para primera entrega
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
    }

    
}
