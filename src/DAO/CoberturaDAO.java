/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Cober;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public class CoberturaDAO {
    public List <Cober> ObtenerCobertura (String nroRamo) throws Exception{ 
        List <Cober> lista=new ArrayList<Cober>();
        try{
            Connection conn;
    
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    conn =DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=src\\BasedeDatosCuotas.mdb;");
    String query="Select * from Coberturas where Coberturas.NumeroRamo = '"+nroRamo+"'";
    int nroCobertura;
    
    PreparedStatement ps=conn.prepareStatement(query);
   
    ResultSet rs=ps.executeQuery();
    while (rs.next()){
     Cober c=new Cober();
     c.setNombre(rs.getString("Nombre"));
     c.setNumero(Integer.parseInt(rs.getString("Numero")));
     nroCobertura=c.getNumero();
     String query2="Select NumeroClausula from CoberturaClausula where CoberturaClausula.NumeroRamo = '"+nroRamo+"' and CoberturaClausula.NumeroCobertura = "+nroCobertura;
     PreparedStatement ps2=conn.prepareStatement(query2);
     ResultSet rs2=ps2.executeQuery();
     List <String> lClausulas=new ArrayList <String>();
     while (rs2.next()){
        lClausulas.add(rs2.getString("NumeroClausula"));
         
     }
     c.setClausulas(lClausulas);
     lista.add(c);
    }
    
    }
        
        catch(Exception e){
        throw new Exception("Error al obtener cobertura");
        }
        finally {}
        return lista;
    }
}
