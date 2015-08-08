/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Sebastian
 */
public class Provincia {
    private String Id;
    private String Nombre;
    private double Tasa;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getTasa() {
        return Tasa;
    }

    public void setTasa(double Tasa) {
        this.Tasa = Tasa;
    }
    
       public String toString(){
       return this.Nombre;
       }
}
