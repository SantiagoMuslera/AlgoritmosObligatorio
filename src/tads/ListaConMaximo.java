package tads;

public class ListaConMaximo<T extends Comparable<T>> implements ILista<T> {

    private Nodo<T> inicio;

    private int cantidadMaxima;

    private Nodo<T> fin;

    public Nodo<T> getFin() {
        return fin;
    }

    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    private int cantidad = 0;

    public Nodo<T> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(int CantidadMaxima) {
        this.cantidadMaxima = CantidadMaxima;
    }

    public ListaConMaximo(int cantidadMaxima) {
        this.inicio = null;
        this.cantidadMaxima = cantidadMaxima;
    }
    
    public boolean estaLlena(){
        return cantidad == cantidadMaxima;
    }

    @Override
    public boolean esVacia() {
        return this.cantidad == 0 ? true : false;
    }

    @Override
    public int cantidadElementos() {
        return this.cantidad;
    }

    @Override
    public String mostrarLista() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = this.inicio;
        while (actual != null) {
            sb.append(actual.getDato()).append('|').append("\n");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public void vaciar() {
        this.inicio = null;
        this.fin = null;
        this.cantidad = 0;
    }

    @Override
    public void agregarInicio(T dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (this.cantidad < this.cantidadMaxima) {
            if (this.inicio == null) {
                this.inicio = nuevoNodo;
                this.fin = nuevoNodo;
            } else {
                nuevoNodo.setSiguiente(inicio);
                this.inicio = nuevoNodo;
            }
            this.cantidad++;
        }
    }

    @Override
    public void agregarFinal(T dato) {
        if (this.cantidad < this.cantidadMaxima) {
            if (this.cantidad == 0) {
                agregarInicio(dato);
            } else {
                Nodo nuevoNodo = new Nodo(dato);
                this.fin.setSiguiente(nuevoNodo);
                this.fin = nuevoNodo;
                this.cantidad++;
            }
        }
    }

    @Override
    public void eliminarInicio() {
        if (this.cantidad > 0) {
            this.inicio = this.inicio.getSiguiente();
            this.cantidad--;
            if (this.cantidad == 1) {
                this.fin = null;
            }
        }
    }

    @Override
    public void eliminarFinal() {
        if (this.cantidad > 0) {
            if (this.cantidad == 1) {
                eliminarInicio();
            } else {
                Nodo nodoactual = this.inicio;
                while (nodoactual != null) {
                    if (nodoactual.getSiguiente().getSiguiente() == null) {
                        nodoactual.setSiguiente(null);
                        this.fin = nodoactual;
                    }
                }
                this.cantidad--;
            }
        }
    }

    @Override
    public boolean estaElemento(T x) {
        if (this.cantidad == 0) {
            return false;
        } else {
            boolean encontrado = false;
            Nodo<T> nodoactual = this.inicio;
            while (nodoactual != null && !encontrado) {
                if (nodoactual.getDato().equals(x)) {
                    encontrado = true;
                }
                nodoactual = nodoactual.getSiguiente();
            }
            return encontrado;
        }
    }

    @Override
    public void eliminarElemento(T x) {
        if (estaElemento(x)) {
            boolean encontrado = false;
            if (this.inicio.getDato().equals(x)) {
                this.inicio = this.inicio.getSiguiente();
            } else {
                if (this.fin.getDato().equals(x)) {
                    this.fin = null;
                } else {
                    Nodo<T> nodoactual = this.inicio;
                    while (nodoactual != null && !encontrado) {
                        if (nodoactual.getSiguiente().getDato().equals(x)) {
                            nodoactual.setSiguiente(nodoactual
                                    .getSiguiente().getSiguiente());
                            encontrado = true;
                        }
                        nodoactual = nodoactual.getSiguiente();
                    }
                }
            }
            this.cantidad--;
        }
    }

    @Override
    public void agregarOrdenado(T x) {
        if (this.cantidad < this.cantidadMaxima) {
            Nodo<T> actual = this.inicio;
            Nodo<T> nuevoNodo = new Nodo(x);
            boolean noAgregado = true;
            while (actual != null && noAgregado) {
                if (actual.getSiguiente() == null) {
                    actual.setSiguiente(nuevoNodo);
                    noAgregado = false;
                } else {
                    if (actual.getSiguiente().getDato().compareTo(x) < 0) {
                        actual = actual.getSiguiente();
                    } else {
                        nuevoNodo.setSiguiente(actual.getSiguiente());
                        actual.setSiguiente(nuevoNodo);
                        noAgregado = false;
                    }
                }
            }
            this.cantidad++;
        }

    }

    @Override
    public Nodo<T> obtenerElemento(T x) {
        if (estaElemento(x)) {
            boolean encontrado = false;
            Nodo<T> nodoactual = this.inicio;
            while (nodoactual != null && !encontrado) {
                if (nodoactual.getDato().equals(x)) {
                    encontrado = true;
                } else {
                    nodoactual = nodoactual.getSiguiente();
                }
            }
            return nodoactual;
        }
        return new Nodo<T>(x);
    }
}
