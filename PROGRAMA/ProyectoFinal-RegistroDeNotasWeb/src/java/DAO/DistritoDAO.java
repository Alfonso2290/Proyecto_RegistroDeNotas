
package DAO;
import BEAN.DepartamentoBEAN;
import BEAN.DistritoBEAN;
import BEAN.ProvinciaBEAN;
import java.sql.*;
import UTIL.ConexionBD;
import java.util.ArrayList;

public class DistritoDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<DistritoBEAN> lista=null;
    
    public ArrayList<DistritoBEAN> listarDistritos(DepartamentoBEAN Departamento,ProvinciaBEAN Provincia)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarDistritos(?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Departamento.getCodigoDepartamento());
            instruccion.setInt(2, Provincia.getCodigoProvincia());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<DistritoBEAN>();
            
            while(tabla.next())
            {
                DistritoBEAN objBEAN=new DistritoBEAN();
                objBEAN.setCodigoDistrito(tabla.getInt(1));
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

