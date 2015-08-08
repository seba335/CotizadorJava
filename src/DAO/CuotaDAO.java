/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.Cuota;
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
public class CuotaDAO {
    public List <Cuota> ObtenerCuota () throws Exception{ 
        List <Cuota> lista=new ArrayList<Cuota>();
        try{
            Connection conn;
    
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    conn =DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=src\\BasedeDatosCuotas.mdb;");
    String query="Select * from Cuotas";
    PreparedStatement ps=conn.prepareStatement(query);
    ResultSet rs=ps.executeQuery();
    while (rs.next()){
     Cuota c=new Cuota();
     c.setNumero(Integer.parseInt(rs.getString("Numero")));
     c.setPorcentaje(rs.getString("Recargo financiero"));
     lista.add(c);
    }
    
    }
        
        catch(Exception e){
        throw new Exception("Error al obtener Cuota");
        }
        finally {}
        return lista;
    }
}
