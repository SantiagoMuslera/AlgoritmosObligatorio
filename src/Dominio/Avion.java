/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Objects;


/*los aviones se enlazan con las aerolineas mediante la lista que tiene
las aerolineas de los aviones. no se necesita este atributo de nomAerolinea
*/
public class Avion implements Comparable <Avion>{
    private String codigo;
    private int capacidadMax;
    private Aerolinea aerolinea;

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }
    
    public Avion (String codigo, int capacidadMax,Aerolinea aerolinea){
        this.codigo = codigo;
        this.capacidadMax = capacidadMax;
        this.aerolinea = aerolinea;
    }
    
    public Avion(String codigo){
        this.codigo = codigo;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }


    @Override
    public boolean equals(Object avion) {
       if (!this.getClass().equals(avion.getClass())) {
            return false;
        } else {
             Avion otroAvion=(Avion) avion;
            
        return this.codigo==otroAvion.getCodigo();
        }
    }

    @Override
    public String toString() {
        return this.codigo + "-" +this.capacidadMax;
    }
    

    @Override
    public int compareTo(Avion o) {
        Avion objetoAvion= (Avion) o;
       return this.codigo.compareTo(objetoAvion.codigo);
    }
}


