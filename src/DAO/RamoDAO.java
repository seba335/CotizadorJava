/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Ramo;
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
public class RamoDAO {
    public List <Ramo> ObtenerRamo () throws Exception{ 
        List <Ramo> lista=new ArrayList<Ramo>();
        try{
            Connection conn;
    
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    conn =DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=src\\BasedeDatosCuotas.mdb;");
    String query="Select * from Ramos";
    PreparedStatement ps=conn.prepareStatement(query);
    ResultSet rs=ps.executeQuery();
    while (rs.next()){
     Ramo r=new Ramo();
     r.setNombre(rs.getString("Nombre"));
     r.setNumero(rs.getString("Numero"));
     lista.add(r);
    }
    
    }
        
        catch(Exception e){
        throw new Exception("Error al obtener ramo");
        }
        finally {}
        return lista;
    }
    }
    
    

