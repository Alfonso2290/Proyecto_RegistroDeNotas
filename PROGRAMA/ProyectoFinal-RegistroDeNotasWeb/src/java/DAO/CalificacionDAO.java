
package DAO;
import BEAN.CalificacionBEAN;
import BEAN.DocenteBEAN;
import BEAN.AulaBEAN;
import BEAN.NivelBEAN;
import BEAN.CicloBEAN;
import BEAN.EstudianteBEAN;
import BEAN.MateriaBEAN;
import BEAN.ModuloBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.*;

public class CalificacionDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<CalificacionBEAN> lista=null;
    
    public ArrayList<CalificacionBEAN> listarCalificacionesAula(DocenteBEAN Docente,AulaBEAN Aula,CicloBEAN Ciclo,NivelBEAN Nivel,MateriaBEAN Materia)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarCalificacionesAula(?,?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Nivel.getCodigoNivel());
            instruccion.setInt(2,Ciclo.getCodigoCiclo());
            instruccion.setInt(3,Materia.getCodigoMateria());
            instruccion.setInt(4,Docente.getCodigoDocente());
            instruccion.setString(5,Aula.getNumAula());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<CalificacionBEAN>();
            
            while(tabla.next())
            {
                CalificacionBEAN objBEAN=new CalificacionBEAN();
                objBEAN.setCodigoEstudiante(tabla.getInt(1));
                objBEAN.setApellidoPaterno(tabla.getString(2));
                objBEAN.setApellidoMaterno(tabla.getString(3));
                objBEAN.setNombre(tabla.getString(4));
                if(tabla.getString(5)==null)
                {
                    objBEAN.setStrNParcial("");
                }
                else
                {
                    objBEAN.setStrNParcial(tabla.getString(5));
                }
                if(tabla.getString(6)==null)
                {
                    objBEAN.setStrNFinal("");
                }
                else
                {
                    objBEAN.setStrNFinal(tabla.getString(6));
                }
                if(tabla.getString(7)==null)
                {
                    objBEAN.setStrPromFinal("");
                }
                else
                {
                    objBEAN.setStrPromFinal(tabla.getString(7));
                }
                
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
    
    public String capturarCodigoModulo(DocenteBEAN Docente,AulaBEAN Aula,CicloBEAN Ciclo,NivelBEAN Nivel,MateriaBEAN Materia)
    {
        String codigo="";
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarCodigoModulo(?,?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Nivel.getCodigoNivel());
            instruccion.setInt(2,Ciclo.getCodigoCiclo());
            instruccion.setInt(3,Materia.getCodigoMateria());
            instruccion.setInt(4,Docente.getCodigoDocente());
            instruccion.setString(5,Aula.getNumAula());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                codigo=tabla.getString(1);
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return codigo;
    }
    
    public void ActualizarCalificacion(EstudianteBEAN Estudiante,CalificacionBEAN Calificacion,ModuloBEAN Modulo)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ActualizarCalificacion(?,?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1,Calificacion.getStrNParcial());
            instruccion.setString(2,Calificacion.getStrNFinal());
            instruccion.setString(3,Calificacion.getStrPromFinal());
            instruccion.setInt(4,Estudiante.getCodigoEstudiante());
            instruccion.setString(5,Modulo.getCodigoModulo());
            instruccion.executeUpdate();
            instruccion.close();
        } 
        catch (Exception e) {}
    }
      
    public ArrayList<CalificacionBEAN> listarCalificacionesAulaEstudiante(EstudianteBEAN Estudiante,AulaBEAN Aula,CicloBEAN Ciclo,NivelBEAN Nivel,MateriaBEAN Materia)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarCalificacionesAulaEstudiante(?,?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Nivel.getCodigoNivel());
            instruccion.setInt(2,Ciclo.getCodigoCiclo());
            instruccion.setInt(3,Materia.getCodigoMateria());
            instruccion.setInt(4,Estudiante.getCodigoEstudiante());
            instruccion.setString(5,Aula.getNumAula());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<CalificacionBEAN>();
            
            while(tabla.next())
            {
                CalificacionBEAN objBEAN=new CalificacionBEAN();
                objBEAN.setCodigoModulo(tabla.getString(1));
                objBEAN.setApePaternoDocente(tabla.getString(2));
                objBEAN.setApeMaternoDocente(tabla.getString(3));
                objBEAN.setNombreDocente(tabla.getString(4));
                if(tabla.getString(5)==null)
                {
                    objBEAN.setStrNParcial("");
                }
                else
                {
                    objBEAN.setStrNParcial(tabla.getString(5));
                }
                if(tabla.getString(6)==null)
                {
                    objBEAN.setStrNFinal("");
                }
                else
                {
                    objBEAN.setStrNFinal(tabla.getString(6));
                }
                if(tabla.getString(7)==null)
                {
                    objBEAN.setStrPromFinal("");
                }
                else
                {
                    objBEAN.setStrPromFinal(tabla.getString(7));
                }
                
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
    
    public int RegistrarCalificacion(CalificacionBEAN Calificacion)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL RegistrarCalificacion(?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Calificacion.getCodigoEstudiante());
            instruccion.setString(2, Calificacion.getCodigoModulo());
            i=instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
        
        return i;
    }
}
