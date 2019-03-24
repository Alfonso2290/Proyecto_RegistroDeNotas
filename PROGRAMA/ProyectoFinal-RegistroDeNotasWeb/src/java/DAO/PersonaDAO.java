
package DAO;
import BEAN.PersonaBEAN;
import BEAN.UsuarioBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class PersonaDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<PersonaBEAN> lista=null;
    
    public ArrayList<PersonaBEAN> listarPersona(UsuarioBEAN Usuario)
    {
        
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarPersona(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Usuario.getCodigoUsuario());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<PersonaBEAN>();
            
            while(tabla.next())
            {
                PersonaBEAN obj=new PersonaBEAN();
                
                obj.setCodAlumno(tabla.getInt(1));
                obj.setNomUsuario(tabla.getString(2));
                obj.setDNI(tabla.getInt(3));
                obj.setNombre(tabla.getString(4));
                obj.setApellidoPaterno(tabla.getString(5));
                obj.setApellidoMaterno(tabla.getString(6));
                obj.setFechaNac(tabla.getString(7));
                obj.setSexo(tabla.getString(8));
                obj.setTelefono(tabla.getString(9));
                obj.setCorreo(tabla.getString(10));
                obj.setNomCalle(tabla.getString(11));
                obj.setNumExt(tabla.getInt(12));
                obj.setNumInt(tabla.getInt(13));
                obj.setNomDistrito(tabla.getString(14));
                obj.setNomProvincia(tabla.getString(15));
                obj.setNomDepartamento(tabla.getString(16));
                obj.setFechaReg(tabla.getString(17));
                
                lista.add(obj);
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        
        return lista;
    }
    
    public int InsertarPersona(PersonaBEAN Persona)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL InsertarPersona(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Persona.getDNI());
            instruccion.setInt(2, Persona.getCodigoDistrito());
            instruccion.setInt(3, Persona.getCodigoProvincia());
            instruccion.setInt(4, Persona.getCodigoDepartamento());
            instruccion.setInt(5, Persona.getCodigoCalle());
            instruccion.setString(6, Persona.getNombre());
            instruccion.setString(7, Persona.getApellidoPaterno());
            instruccion.setString(8, Persona.getApellidoMaterno());
            instruccion.setString(9, Persona.getSexo());
            instruccion.setString(10, Persona.getFechaNac());
            instruccion.setString(11, Persona.getCorreo());
            instruccion.setString(12, Persona.getTelefono());
            instruccion.setInt(13, Persona.getNumExt());
            instruccion.setInt(14, Persona.getNumInt());
            i=instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
        
        return i;
    }
    
    public boolean ConsultaExistenciaXDNI(PersonaBEAN obj)
    {
        boolean b=true;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ConsultaExistenciaXDNI(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,obj.getDNI());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
              b=false;   
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        
        return b;
    }
    
    public int ModificarPersona(PersonaBEAN Persona)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ModificarPersona(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Persona.getCodigoDistrito());
            instruccion.setInt(2, Persona.getCodigoProvincia());
            instruccion.setInt(3, Persona.getCodigoDepartamento());
            instruccion.setInt(4, Persona.getCodigoCalle());
            instruccion.setString(5, Persona.getNombre());
            instruccion.setString(6, Persona.getApellidoPaterno());
            instruccion.setString(7, Persona.getApellidoMaterno());
            instruccion.setString(8, Persona.getSexo());
            instruccion.setString(9, Persona.getFechaNac());
            instruccion.setString(10, Persona.getCorreo());
            instruccion.setString(11, Persona.getTelefono());
            instruccion.setInt(12, Persona.getNumExt());
            instruccion.setInt(13, Persona.getNumInt());
            instruccion.setInt(14, Persona.getDNI());
            i=instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
        
        return i;
    }
}
