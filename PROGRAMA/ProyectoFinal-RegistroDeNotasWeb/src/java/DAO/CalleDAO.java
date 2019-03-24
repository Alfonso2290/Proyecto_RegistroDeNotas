
package DAO;
import BEAN.CalleBEAN;
import BEAN.DepartamentoBEAN;
import BEAN.DistritoBEAN;
import BEAN.ProvinciaBEAN;
import java.sql.*;
import UTIL.ConexionBD;
import java.util.ArrayList;

public class CalleDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<CalleBEAN> lista=null;
    
    public ArrayList<CalleBEAN> listarCalles(DepartamentoBEAN Departamento,ProvinciaBEAN Provincia,DistritoBEAN Distrito)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarCalles(?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Departamento.getCodigoDepartamento());
            instruccion.setInt(2, Provincia.getCodigoProvincia());
            instruccion.setInt(3, Distrito.getCodigoDistrito());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<CalleBEAN>();
            
            while(tabla.next())
            {
                CalleBEAN objBEAN=new CalleBEAN();
                objBEAN.setCodigoCalle(tabla.getInt(1));
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

