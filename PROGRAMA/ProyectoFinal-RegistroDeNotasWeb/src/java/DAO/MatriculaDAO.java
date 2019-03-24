
package DAO;
import BEAN.EstudianteBEAN;
import BEAN.MatriculaBEAN;
import BEAN.ModuloBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
public class MatriculaDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    
    public int CantidadAlumnosXAula(MatriculaBEAN Matricula)
    {
        int cant=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL CantidadAlumnosXAula(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1, Matricula.getNumAula());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                cant=tabla.getInt(1);
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return cant;
    }
    
    public int RegistrarMatricula(MatriculaBEAN Matricula)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL RegistrarMatricula(?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Matricula.getCodigoEstudiante());
            instruccion.setString(2, Matricula.getNumAula());
            i=instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
        
        return i;
    }
}
