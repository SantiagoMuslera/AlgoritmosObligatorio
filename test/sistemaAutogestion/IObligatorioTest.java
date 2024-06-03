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
        miSistema.registrarCliente("P123456", "Lucho Lucheiro", 20);
        miSistema.crearVuelo("V321", "Aerolineas Argentinas", "avion1", "Uruguay", 5, 8, 2023, 30, 15);
        miSistema.comprarPasaje("V321", "P123456", 1);

        //Coloca aquí cualquier otra inicialización de listas necesaria
    }

    @Test
    public void testCrearSistemaDeGestion() {
        //Completar para primera entrega
        Retorno re = this.miSistema.crearSistemaDeGestion();
        assertEquals(Retorno.ok().resultado, re.resultado);
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
        r = miSistema.eliminarAerolinea("Aerolineas Perú");
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

    @Test
    public void testRegistrarCliente() {

        Retorno r = miSistema.registrarCliente("P654321", "Juan Perez", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarCliente("P234567", "Oscar Martinez", -5); // edad menor que 0
        assertEquals(Retorno.error1().resultado, r.resultado);

        r = miSistema.registrarCliente("P1234567", "Maria Lopez", 25); // Pasaporte + 7 caracteres
        assertEquals(Retorno.error2().resultado, r.resultado);

        r = miSistema.registrarCliente("P12345", "Ana Gomez", 26); // Pasapirte - 7 caracteres
        assertEquals(Retorno.error2().resultado, r.resultado);

        r = miSistema.registrarCliente("P123456", "Lucho Lucheiro", 20);
        assertEquals(Retorno.error3().resultado, r.resultado); // Paporte ya existe

    }

    @Test
    public void testCrearVuelo() {

        // Caso 1: Crear vuelo correctamente
        Retorno r = miSistema.crearVuelo("V123", "Aerolineas Argentinas", "avion1", "Brasil", 1, 7, 2023, 30, 15);
        assertEquals(Retorno.ok().resultado, r.resultado);

        // Caso 1: Código de vuelo ya existe
        r = miSistema.crearVuelo("V321", "Aerolineas Argentinas", "avion1", "Uruguay", 5, 8, 2023, 30, 15);
        assertEquals(Retorno.error1().resultado, r.resultado);

        // Caso 2: Aerolínea no existe
        r = miSistema.crearVuelo("V124", "Aerolineas Ficticia", "avion1", "Brasil", 1, 7, 2023, 30, 15);
        assertEquals(Retorno.error2().resultado, r.resultado);

        // Caso 3: Código de avión no existe en la aerolínea
        r = miSistema.crearVuelo("V125", "Aerolineas Argentinas", "avion2", "Brasil", 1, 7, 2023, 30, 15);
        assertEquals(Retorno.error3().resultado, r.resultado);

        // Caso 4: Ya existe un vuelo para ese avión en esa fecha
        r = miSistema.crearVuelo("V126", "Aerolineas Iberia", "avion1", "Chile", 1, 7, 2023, 30, 15);
        assertEquals(Retorno.error4().resultado, r.resultado);

        // Caso 5: Cantidades de pasajes no son múltiplos de 3
        r = miSistema.crearVuelo("V127", "Aerolineas Iberia", "avion1", "Perú", 2, 7, 2023, 31, 16);
        assertEquals(Retorno.error5().resultado, r.resultado);

        // Caso 6: Suma de pasajes supera la cantidad máxima permitida por el avión
        r = miSistema.crearVuelo("V128", "Aerolineas Iberia", "avion1", "Uruguay", 2, 7, 2023, 40, 25);
        assertEquals(Retorno.error6().resultado, r.resultado);
    }

    @Test
    public void testComprarPasaje() {
        Retorno r = miSistema.comprarPasaje("V123", "P123456", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.comprarPasaje("V123", "P123456", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.comprarPasaje("V123", "P654321", 1);
        assertEquals(Retorno.error1().resultado, r.resultado); // Pasaporte del cliente no existe

        r = miSistema.comprarPasaje("V124", "P123456", 1);
        assertEquals(Retorno.error2().resultado, r.resultado); // Codigo del vuelo no existe
    }

    @Test
    public void testDevolverPasaje() {

        Retorno r = miSistema.devolverPasaje("V321", "P123456");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.devolverPasaje("V321", "P654321");
        assertEquals(Retorno.error1().resultado, r.resultado); // Pasaporte no registrado

        r = miSistema.devolverPasaje("V124", "P123456");
        assertEquals(Retorno.error2().resultado, r.resultado); // Vuelo no registrado
    }

    @Test
    public void testListarClientes() {

        miSistema.registrarCliente("P765432", "Maria Lopez", 25);
        miSistema.registrarCliente("P234567", "Juan Perez", 30);

        Retorno r = miSistema.listarClientes();
        assertEquals("P234567-Juan Perez-30|\nP765432-Maria Lopez-25|\nP123456-Lucho Lucheiro-20", r.valorString);
    }

    @Test
    public void testListarVuelos() {

        Retorno r = miSistema.listarVuelos();
        assertEquals("V321-Aerolineas Argentinas-avion1-1-0-60", r.valorString);
    }

    @Test
    public void testVuelosDeCliente() {
        miSistema.registrarCliente("P123456", "Juan Perez", 30);
        miSistema.crearVuelo("V123", "Aerolineas Argentinas", "avion1", "Brasil", 1, 7, 2023, 50, 10);
        miSistema.crearVuelo("V124", "Aerolineas Argentinas", "avion1", "Uruguay", 5, 7, 2023, 40, 8);
        miSistema.comprarPasaje("V123", "P123456", 1);
        miSistema.comprarPasaje("V124", "P123456", 2);

        Retorno r = miSistema.vuelosDeCliente("P123456");
        assertEquals("V123-Brasil-01/07/2023|\nV124-Uruguay-05/07/2023", r.valorString);
    }

    @Test
    public void testPasajesDevueltos() {
        
        miSistema.comprarPasaje("V321", "P123456", 1);
        miSistema.devolverPasaje("V123", "P123456");
        Retorno r = miSistema.pasajesDevueltos("Aerolineas Argentinas");
        assertEquals("V321-Uruguay-05/08/2023-P123456-Lucho Lucheiro", r.valorString);
    }

    @Test
    public void testVistaDeVuelo() {
        miSistema.registrarCliente("P123456", "Juan Perez", 30);
        miSistema.crearVuelo("V123", "Aerolineas Argentinas", "avion1", "Brasil", 1, 7, 2023, 50, 10);
        miSistema.comprarPasaje("V123", "P123456", 1);

        Retorno r = miSistema.vistaDeVuelo("V123");
        assertEquals("V123-Brasil-01/07/2023|\nP123456-Juan Perez-30", r.valorString);
    }

}
