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
public class Cobertura {
    
    private String Nombre;
    private double SumaAsegurada;
    private double Tasa;
    private String AjusteTasa;
    private double Prima;
    private List <String> Clausulas;
    private Provincia Provincia;
    private double PrimaConVar;
    private double PrimaConRecargoCuotas;
    private double PrimaConImpuestoProv;

    public double getPrimaConVar() {
        return PrimaConVar;
    }

    public void setPrimaConVar(double PrimaConVar) {
        this.PrimaConVar = PrimaConVar;
    }

    public double getPrimaConRecargoCuotas() {
        return PrimaConRecargoCuotas;
    }

    public void setPrimaConRecargoCuotas(double PrimaConRecargoCuotas) {
        this.PrimaConRecargoCuotas = PrimaConRecargoCuotas;
    }

    public double getPrimaConImpuestoProv() {
        return PrimaConImpuestoProv;
    }

    public void setPrimaConImpuestoProv(double PrimaConImpuestoProv) {
        this.PrimaConImpuestoProv = PrimaConImpuestoProv;
    }
    
 
    public Provincia getProvincia() {
        return Provincia;
    }

    public void setProvincia(Provincia Provincia) {
        this.Provincia = Provincia;
    }

    public String getAjusteMensual() {
        return AjusteMensual;
    }

    public void setAjusteMensual(String AjusteMensual) {
        this.AjusteMensual = AjusteMensual;
    }
    private String AjusteMensual;
    
    public Cobertura(String Nombre, double SumaAsegurada, double Tasa, String AjusteTasa, double Prima, List <String> Clausulas,String AjusteMensual,Provincia Provincia) {
        this.Nombre = Nombre;
        this.SumaAsegurada = SumaAsegurada;
        this.Tasa = Tasa;
        this.AjusteTasa = AjusteTasa;
        this.Prima = Prima;
        this.Clausulas = Clausulas;
        this.AjusteMensual=AjusteMensual;
        this.Provincia=Provincia;
    }
    
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getSumaAsegurada() {
        return SumaAsegurada;
    }

    public void setSumaAsegurada(double SumaAsegurada) {
        this.SumaAsegurada = SumaAsegurada;
    }

    public double getTasa() {
        return Tasa;
    }

    public void setTasa(double Tasa) {
        this.Tasa = Tasa;
    }

    public String getAjusteTasa() {
        return AjusteTasa;
    }

    public void setAjusteTasa(String AjusteTasa) {
        this.AjusteTasa = AjusteTasa;
    }

    public double getPrima() {
        return Prima;
    }

    public void setPrima(double Prima) {
        this.Prima = Prima;
    }

    public List <String> getClausulas() {
        return Clausulas;
    }

    public void setClausulas(List <String> Clausulas) {
        this.Clausulas = Clausulas;
    }
    
}
