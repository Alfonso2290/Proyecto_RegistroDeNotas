
package DAO;
import BEAN.AulaBEAN;
import BEAN.CicloBEAN;
import BEAN.DocenteBEAN;
import BEAN.EstudianteBEAN;
import BEAN.MateriaBEAN;
import BEAN.NivelBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class EstudianteDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<EstudianteBEAN> lista=null;
       
    public int Consulta(EstudianteBEAN Estudiante)
    {
        int cant=0;
        try 
        {
           conexion=new ConexionBD();
           sql="{CALL ConsultaAlumno(?)}";
           instruccion=conexion.getConexionBD().prepareCall(sql);
           instruccion.setInt(1,Estudiante.getCodigoEstudiante());
           tabla=instruccion.executeQuery();
           
           if(tabla.next())
           {
                cant++;
           }
           
           instruccion.close();
           tabla.close();
           
           
        } catch (Exception e) 
        {
        }
        
        return cant;
    }
    
    public void EliminarAlumno(EstudianteBEAN Estudiante)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL EliminarAlumno(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Estudiante.getCodigoEstudiante());
            instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
    }
    
    public int ConsultarCursosMatriculados(EstudianteBEAN Estudiante)
    {
        int cont=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ConsultarCursosMatriculados(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Estudiante.getDNI());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                cont++;
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return cont;
    }
    
    public EstudianteBEAN listarObjetoAlumno(EstudianteBEAN Estudiante)
    {
        EstudianteBEAN obj=null;
        try 
        {
            conexion=new ConexionBD();           
            sql="{CALL listarObjetoAlumno(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Estudiante.getCodigoEstudiante());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                obj=new EstudianteBEAN();
                obj.setCodigoEstudiante(tabla.getInt(1));
                obj.setDNI(tabla.getInt(2));
                obj.setCodigoDistrito(tabla.getInt(3));
                obj.setCodigoProvincia(tabla.getInt(4));
                obj.setCodigoDepartamento(tabla.getInt(5));
                obj.setCodigoCalle(tabla.getInt(6));
                obj.setNombre(tabla.getString(7));
                obj.setApellidoPaterno(tabla.getString(8));
                obj.setApellidoMaterno(tabla.getString(9));
                obj.setSexo(tabla.getString(10));
                obj.setFechaNac(tabla.getString(11));
                obj.setCorreo(tabla.getString(12));
                obj.setTelefono(tabla.getString(13));
                obj.setNumExt(tabla.getInt(14));
                obj.setNumInt(tabla.getInt(15));
                
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        
        return obj;
    }
    
    public int capturarCodigoEstudiante()
    {
        int codigo=1;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarCodigoEstudiante()}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                codigo=tabla.getInt(1);
            }
            
            instruccion.close();
            tabla.close();
           
        } 
        catch (Exception e) 
        {}
        
        return codigo;
    }
    
    public boolean ConsultaXDNI(EstudianteBEAN Estudiante)
    {
        boolean b=false;
        try 
        {
           conexion=new ConexionBD();
           sql="{CALL ConsultaXDNIAlumno(?)}";
           instruccion=conexion.getConexionBD().prepareCall(sql);
           instruccion.setInt(1,Estudiante.getDNI());
           tabla=instruccion.executeQuery();
           
           if(tabla.next())
           {
                b=true;
           }
           
           instruccion.close();
           tabla.close();
           
           
        } catch (Exception e) 
        {
        }
        
        return b;
    }
    
    public int CapturarDNI(EstudianteBEAN Estudiante)
    {
        int dni=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL CapturarDNIAlumno(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Estudiante.getCodigoEstudiante());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                dni=tabla.getInt("DNI");
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return dni;
    }
    
    public int CapturarCodigo(EstudianteBEAN Estudiante)
    {
        int codigo=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL CapturarCodigoAlumno(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Estudiante.getDNI());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                codigo=tabla.getInt("COD_ALUMNO");
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return codigo;
    }
    
    public ArrayList<EstudianteBEAN> listarAlumnosMantenimiento(MateriaBEAN Materia,NivelBEAN Nivel,CicloBEAN Ciclo,AulaBEAN Aula,DocenteBEAN Docente)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarAlumnosMantenimiento(?,?,?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Materia.getCodigoMateria());
            instruccion.setInt(2, Nivel.getCodigoNivel());
            instruccion.setInt(3, Ciclo.getCodigoCiclo());
            instruccion.setString(4, Aula.getNumAula());
            instruccion.setInt(5, Docente.getCodigoDocente());
            instruccion.setString(6, Aula.getModalidad());
            tabla=instruccion.executeQuery();
            lista= new ArrayList<EstudianteBEAN>();
            
            while(tabla.next())
            {
                EstudianteBEAN objBEAN=new EstudianteBEAN();
                objBEAN.setCodigoEstudiante(tabla.getInt(1));
                objBEAN.setDNI(tabla.getInt(2));
                objBEAN.setCodigoDistrito(tabla.getInt(3));
                objBEAN.setCodigoProvincia(tabla.getInt(4));
                objBEAN.setCodigoDepartamento(tabla.getInt(5));
                objBEAN.setCodigoCalle(tabla.getInt(6));
                objBEAN.setNombre(tabla.getString(7));
                objBEAN.setApellidoPaterno(tabla.getString(8));
                objBEAN.setApellidoMaterno(tabla.getString(9));
                objBEAN.setSexo(tabla.getString(10));
                objBEAN.setFechaNac(tabla.getString(11));
                objBEAN.setCorreo(tabla.getString(12));
                objBEAN.setTelefono(tabla.getString(13));
                objBEAN.setNumExt(tabla.getInt(14));
                objBEAN.setNumInt(tabla.getInt(15));
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
    
    public int InsertarAlumno(EstudianteBEAN Estudiante)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL InsertarAlumno(?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Estudiante.getCodigoEstudiante());
            instruccion.setInt(2, Estudiante.getDNI());
            i=instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
        
        return i;
    }
}
