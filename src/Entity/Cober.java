/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;

/**
 *
 * @author Sebastian
 */
public class Cober {
    
private int Numero;
private String Nombre;
private List <String> Clausulas;


    

   

    public int getNumero() {
        return Numero;
    }

    public List<String> getClausulas() {
        return Clausulas;
    }

    public void setClausulas(List<String> Clausulas) {
        this.Clausulas = Clausulas;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public String toString(){
        return this.Nombre;
    }
    }

