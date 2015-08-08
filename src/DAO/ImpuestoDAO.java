/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sebastian
 */
public class ImpuestoDAO {
    public double ObtenerProvincia () throws Exception{ 
        double imp=0;
        try{
            Connection conn;
    
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    conn =DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=src\\BasedeDatosCuotas.mdb;");
    String query="Select * from Impuesto";
    PreparedStatement ps=conn.prepareStatement(query);
    ResultSet rs=ps.executeQuery();
    while (rs.next()){
     
    imp= Double.parseDouble(rs.getString("Porcentaje"));
     
    }
    
    }
        
        catch(Exception e){
        throw new Exception("Error al obtener impuesto");
        }
        finally {}
        return imp;
    }
}
