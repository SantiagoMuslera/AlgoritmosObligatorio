package sistemaAutogestion;


public interface IObligatorio {
    
    /*
    **************** REGISTROS **************************************
    */
    
    //pre:      post:
    public Retorno crearSistemaDeGestion();
    
     /*
    pre:Se recibe un nombre, un pais y la cantidad de aviones, el nombre
    ,no nulos y no vacios, no puede ser repetido y la cantidad de 
    aviones debe ser mayor a 0.
    post:Se crea una nueva aerolinea , se guarda en el sistema y retorna un ok.
    */
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones);
    
      /*
    pre:Recibe un nombre de aerolinea para eliminar, no nulo y no vacio, si no existe da un error,
    y si tiene aviones registrado no se podrá eliminar.
    post:Retorna un ok en caso se elimino correctamente la aerolinea.
    */
    public  Retorno eliminarAerolinea(String nombre);
    
     /*
    pre:recibe un codigo de avion,la capacidad maxima y el nombre de la aerolinea,
    no nulos y no vacios, donde el codigo si ya esta en la aerolinea,la capacidad
    es menor a 9 o no es multiplo de 3,la aerolinea no existe o la aerolinea ya 
    no puede tenes màs aviones daran un error.
    post:retorna un ok si se agrego el avion correctamente.
    */
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea);
     
    //pre:recibe un codigo de avion,la capacidad maxima y el nombre de la aerolinea,
    //no nulos y no vacios, donde si la aerolinea no existe,el codigo no le pertenezca
    //a la aerolinea o el avion ya tiene pasajes vendidos dará un error.
    //post:retorna un ok si se elimino el avion correctamente.
    public Retorno eliminarAvion(String nomAerolinea, String codAvion); 
    
     /*
    pre:Se recibe un pasaporte,que es un codigo alfanumerico de 7 caracteres,
    un nombre y una edad, los cuales no son 
    nulos o vacíos,si la edad es menor igual a 0,el pasaporte tiene màs o menos 
    de 7 caracteres o en caso el pasaporte ya esta registrado dará un error.
    post:Retorna un ok en caso se pudo registrar al cliente.
    */
    public Retorno registrarCliente(String pasaporte, String nombre, int edad);

    
      /*
    **************** GESTIÓN DE VUELOS Y PASAJES **************************************
    */
    
     /*
    pre:
    post:
    */
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase);
     /*
    pre:
    post:
    */
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje);
     /*
    pre:
    post:
    */
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo);

     /*
    **************** REPORTES Y CONSULTAS **************************************
    */
    //pre:En el sistema hay una lista de aerolineas con al menos una aerolinea 
    //post:Se imprime en pantalla todas las 
    //aerolineas mostrando su 'nombre-pais-cantAviones'
    public Retorno listarAerolineas();
    //pre:Se ingresa el nombre de una aerolinea y se busca si existe.
    //Si existe mostrara la lista de los avion, en caso contrario no lo hará.
    //post:Se imprime en pantalla todas los aviones 
    //de esa aerolinea mostrando su 'codigo-CantidadPasajeros'
    public Retorno listarAvionesDeAerolinea(String nombre);
    //pre:      post: 
    public Retorno listarClientes();
    //pre:      post: 
    public Retorno listarVuelos();
    //pre:      post: 
    public Retorno vuelosDeCliente(String pasaporte);
    //pre:      post: 
    public Retorno pasajesDevueltos(String nombreAerolinea);
    //pre:      post: 
    public Retorno vistaDeVuelo(String codigoVuelo);
    
    
    
}
