package tads;

public class ListaEnlazada<T extends Comparable<T>> implements IListaEnlazada<T> {

    private class NodoEnlazado<T extends Comparable<T>> {

        private T dato;
        private NodoEnlazado<T> siguiente;
        private NodoEnlazado<T> anterior;

        public NodoEnlazado(T dato) {
            this.dato = dato;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

        public NodoEnlazado<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(NodoEnlazado<T> siguiente) {
            this.siguiente = siguiente;
        }

        public NodoEnlazado<T> getAnterior() {
            return anterior;
        }

        public void setAnterior(NodoEnlazado<T> anterior) {
            this.anterior = anterior;
        }

    }
    private NodoEnlazado<T> inicio;
    private NodoEnlazado<T> ultimo;
    private int cantidadElementos;

    public ListaEnlazada() {
    }

    @Override
    public boolean esVacia() {
        return cantidadElementos == 0;
    }

    @Override
    public int cantidadElementos() {
        return this.cantidadElementos;
    }

    @Override
    public String mostrarLista() {
        StringBuilder sb = new StringBuilder();
        NodoEnlazado<T> actual = inicio;
        while (actual != null) {
            sb.append(actual.dato.toString());
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    @Override
    public void vaciar() {
        inicio = null;
        ultimo = null;
    }

    @Override
    public void agregarInicio(T dato) {
        NodoEnlazado<T> nuevoNodo = new NodoEnlazado<>(dato);
        nuevoNodo.setSiguiente(this.inicio);
        inicio = nuevoNodo;
        if (ultimo == null) {
            ultimo = inicio;
        }
        this.cantidadElementos++;
    }

    @Override
    public void agregarFinal(T x) {
        if (inicio == null) {
            agregarInicio(x);
        } else {
            NodoEnlazado<T> nuevoNodo = new NodoEnlazado<>(x);
            nuevoNodo.setAnterior(ultimo);
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
            this.cantidadElementos++;
        }
    }

    @Override
    public void eliminarInicio() {
        this.inicio = this.inicio.getSiguiente();
        this.inicio.setAnterior(null);
        this.cantidadElementos--;
    }

    @Override
    public void eliminarFinal() {
        this.ultimo = this.ultimo.getAnterior();
        this.ultimo.setSiguiente(null);
        this.cantidadElementos--;
    }

    @Override
    public boolean estaElemento(T x) {
        if (inicio.getDato().equals(x) || ultimo.getDato().equals(x)) {
            return true;
        }
        NodoEnlazado<T> actual = inicio.getSiguiente();
        boolean encontrado = false;
        while (actual != null && !encontrado) {
            if (actual.getDato().equals(x)) {
                encontrado = true;
            }
            actual = actual.getSiguiente();
        }
        return encontrado;
    }

    @Override
    public void eliminarElemento(T x) {
        NodoEnlazado<T> actual = inicio.getSiguiente();
        boolean encontrado = false;
        while (actual != null && !encontrado) {
            if(actual.getDato().equals(x)){
                encontrado = true;
                actual.getAnterior().setSiguiente(actual.getSiguiente());
                actual.getSiguiente().setAnterior(actual.getAnterior());
                this.cantidadElementos--;
            }   
        }
    }

    @Override
    public void agregarOrdenado(T x) {
        NodoEnlazado<T> nuevoNodo = new NodoEnlazado<>(x);
        if (inicio == null) {
            agregarInicio(x);
        } else {
            NodoEnlazado<T> actual = inicio;
            while (inicio != null) {
                if (actual.getDato().compareTo(x) < 0) {
                    actual = actual.getSiguiente();
                } else {
                    NodoEnlazado<T> nodoAnterior = actual.getAnterior();
                    actual.setAnterior(nuevoNodo);
                    nuevoNodo.setSiguiente(actual);
                    nuevoNodo.setAnterior(nodoAnterior);
                    nodoAnterior.setSiguiente(nuevoNodo);
                }
            }
            this.cantidadElementos++;
        }
    }

    @Override
    public T obtenerElemento(T x) {
        NodoEnlazado<T> actual = inicio;
        T retorno = null;
        while (actual != null && retorno == null) {
            if (actual.getDato().equals(x)) {
                retorno = actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return retorno;
    }

}
