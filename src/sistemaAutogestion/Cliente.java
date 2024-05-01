/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

import java.util.Objects;

/**
 *
 * @author Santiago
 */
public class Cliente implements Comparable <Cliente> {
    private String pasaporte; //alfanumerico, 7 caracteres
    private String nombre;
    private int edad;
    
    public Cliente(String pasaporte, String nombre, int edad){
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   

    @Override
    public boolean equals(Object cliente) {
       if(!this.getClass().equals(cliente.getClass())){
           return false;
       }else{
           Cliente otroCliente = (Cliente) cliente;
           return this.pasaporte == otroCliente.pasaporte;
       }
    }

    @Override
    public String toString() {
        return "Cliente{" + "pasaporte=" + pasaporte + ", nombre=" + nombre + ", edad=" + edad + '}';
    }

    @Override
    public int compareTo(Cliente cliente) {
        Cliente otroCliente= (Cliente) cliente;
       return this.pasaporte.compareTo(otroCliente.pasaporte);
    }
}
