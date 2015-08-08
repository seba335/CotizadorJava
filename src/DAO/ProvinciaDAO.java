/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Provincia;
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
public class ProvinciaDAO {
    public List <Provincia> ObtenerProvincia () throws Exception{ 
        List <Provincia> lista=new ArrayList<Provincia>();
        try{
            Connection conn;
    
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    conn =DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=src\\BasedeDatosCuotas.mdb;");
    String query="Select * from Provincias";
    PreparedStatement ps=conn.prepareStatement(query);
    ResultSet rs=ps.executeQuery();
    while (rs.next()){
     Provincia p=new Provincia();
     p.setNombre(rs.getString("Nombre"));
     p.setId(rs.getString("Id"));
     p.setTasa(Double.parseDouble(rs.getString("Tasa")));
     lista.add(p);
    }
    
    }
        
        catch(Exception e){
        throw new Exception("Error al obtener provincia");
        }
        finally {}
        return lista;
    }
}
