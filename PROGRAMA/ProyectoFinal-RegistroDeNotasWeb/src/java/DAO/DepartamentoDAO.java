
package DAO;
import BEAN.DepartamentoBEAN;
import java.sql.*;
import UTIL.ConexionBD;
import java.util.ArrayList;

public class DepartamentoDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<DepartamentoBEAN> lista=null;
    
    public ArrayList<DepartamentoBEAN> listarDepartamentos()
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarDepartamentos()}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<DepartamentoBEAN>();
            
            while(tabla.next())
            {
                DepartamentoBEAN objBEAN=new DepartamentoBEAN();
                objBEAN.setCodigoDepartamento(tabla.getInt(1));
                objBEAN.setNombre(tabla.getString(2));
                
                lista.add(objBEAN);
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return lista;
    }
}
