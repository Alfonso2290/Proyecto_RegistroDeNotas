
package DAO;
import BEAN.DepartamentoBEAN;
import BEAN.ProvinciaBEAN;
import java.sql.*;
import UTIL.ConexionBD;
import java.util.ArrayList;

public class ProvinciaDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<ProvinciaBEAN> lista=null;
    
    public ArrayList<ProvinciaBEAN> listarProvincias(DepartamentoBEAN Departamento)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarProvincias(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Departamento.getCodigoDepartamento());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<ProvinciaBEAN>();
            
            while(tabla.next())
            {
                ProvinciaBEAN objBEAN=new ProvinciaBEAN();
                objBEAN.setCodigoProvincia(tabla.getInt(1));
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
