
package DAO;

import BEAN.EstudianteBEAN;
import BEAN.UsuarioBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.*;

public class UsuarioDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<UsuarioBEAN> lista=null;
    
    public ArrayList<UsuarioBEAN> listarUsuario(UsuarioBEAN Usuario)
    {
        
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarUsuario(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Usuario.getCodigoUsuario());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<UsuarioBEAN>();
            
            while(tabla.next())
            {
                UsuarioBEAN obj=new UsuarioBEAN();
                
                obj.setNombre(tabla.getString("NOMBRE"));
                obj.setPrimerNombre(tabla.getString("PRIMER_NOMBRE"));
                obj.setSegundoNombre(tabla.getString("SEGUNDO_NOMBRE"));
                obj.setApellidoPaterno(tabla.getString("APELLIDO_PATERNO"));
                obj.setApellidoMaterno(tabla.getString("APELLIDO_MATERNO"));
                obj.setSexo(tabla.getString("SEXO"));
                obj.setCorreo(tabla.getString("CORREO"));
                obj.setTelefono(tabla.getString("TELEFONO"));
                obj.setFechaRegistro(tabla.getString("FECHA_REGISTRO"));
                
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
    
    public UsuarioBEAN listarObjetoUsuario(UsuarioBEAN Usuario)
    {
        UsuarioBEAN obj=null;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarObjetoUsuario(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Usuario.getCodigoUsuario());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                obj=new UsuarioBEAN();
                obj.setNombre(tabla.getString("NOMBRE"));
                obj.setPrimerNombre(tabla.getString("PRIMER_NOMBRE"));
                obj.setSegundoNombre(tabla.getString("SEGUNDO_NOMBRE"));
                obj.setApellidoPaterno(tabla.getString("APELLIDO_PATERNO"));
                obj.setApellidoMaterno(tabla.getString("APELLIDO_MATERNO"));
                obj.setSexo(tabla.getString("SEXO"));
                obj.setCorreo(tabla.getString("CORREO"));
                obj.setTelefono(tabla.getString("TELEFONO"));
                obj.setFechaRegistro(tabla.getString("FECHA_REGISTRO"));
                obj.setContraseña(tabla.getString("CONTRASEÑA"));
                obj.setDNI(tabla.getInt("DNI"));
                obj.setCodigoUsuario(tabla.getInt("COD_USUARIO"));
                obj.setTipo(tabla.getString("TIPO"));
                
                
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        
        return obj;
    }
    
    
    public void Insertar(UsuarioBEAN Usuario)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL Insertar(?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Usuario.getDNI());
            instruccion.setString(2,Usuario.getNombre());
            instruccion.setString(3,Usuario.getContraseña());
            instruccion.setString(4,Usuario.getTipo());
            instruccion.executeUpdate();
            
            instruccion.close();
            
        } 
        catch (Exception e) 
        {}
    }
    
    public int InsertarUsuario(UsuarioBEAN Usuario)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL InsertarUsuario(?,?,?,?,?,?,?,?,?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Usuario.getCodigoUsuario());
            instruccion.setInt(2,Usuario.getDNI());
            instruccion.setString(3,Usuario.getNombre());
            instruccion.setString(4,Usuario.getContraseña());
            instruccion.setString(5,Usuario.getTipo());
            instruccion.setString(6,Usuario.getPrimerNombre());
            instruccion.setString(7,Usuario.getSegundoNombre());
            instruccion.setString(8,Usuario.getApellidoPaterno());
            instruccion.setString(9,Usuario.getApellidoMaterno());
            instruccion.setString(10,Usuario.getSexo());
            instruccion.setString(11,Usuario.getCorreo());
            instruccion.setString(12,Usuario.getTelefono());
            i=instruccion.executeUpdate();
            
            instruccion.close();
            
        } 
        catch (Exception e) 
        {}
        
        return i;
    }
    
    public int capturarCodigoUsuario()
    {
        int codigo=1;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarCodigoUsuario()}";
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
    
    public int capturarUsuario(UsuarioBEAN Usuario)
    {
        int cant=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarUsuario()}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                if(tabla.getString(1).equals(Usuario.getNombre()))
                {
                    cant++;
                }
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {}
        
        return cant;
    }
    
    public int VerificarCuenta(UsuarioBEAN Usuario)
    {
        int cant=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL VerificarCuenta()}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                if(tabla.getInt(1)==Usuario.getDNI())
                {
                    cant++;
                }
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {}
        
        return cant;
    }
    
    public int ConfirmacionCuenta(UsuarioBEAN Usuario)
    {
        int cant=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ConfirmacionCuenta(?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1,Usuario.getNombre());
            instruccion.setString(2,Usuario.getContraseña());
            instruccion.setString(3,Usuario.getTipo());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                
                cant++;
                
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {}
        
        return cant;
    }
    
    public String ConsultarCodigoUsuario(UsuarioBEAN Usuario)
    {
        String codigousu="";
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ConsultarCodigoUsuario(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1,Usuario.getNombre());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
              codigousu=tabla.getString("COD_USUARIO"); 
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {}
        
        return codigousu;
    }
    
    public int confirmarUsuarioContraseñaxCodigo(UsuarioBEAN Usuario)
    {
        int cant=0;
        
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL confirmarUsuarioContraseñaxCodigo(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Usuario.getCodigoUsuario());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                if(tabla.getString("CONTRASEÑA").equals(Usuario.getContraseña()))
                {
                    cant++;
                }
                
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        
        return cant;
    }
    
    public void ActualizarContraseña(UsuarioBEAN Usuario)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ActualizarContraseña(?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1, Usuario.getContraseña());
            instruccion.setInt(2, Usuario.getCodigoUsuario());
            instruccion.executeUpdate();
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
            
    }
    
    public void ActualizarUsuario(UsuarioBEAN Usuario)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ActualizarUsuario(?,?,?,?,?,?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1, Usuario.getNombre());
            instruccion.setString(2, Usuario.getPrimerNombre());
            instruccion.setString(3, Usuario.getSegundoNombre());
            instruccion.setString(4, Usuario.getApellidoPaterno());
            instruccion.setString(5, Usuario.getApellidoMaterno());
            instruccion.setString(6, Usuario.getCorreo());
            instruccion.setString(7, Usuario.getTelefono());
            instruccion.setString(8, Usuario.getSexo());
            instruccion.setInt(9,Usuario.getCodigoUsuario());
            instruccion.executeUpdate();
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
            
    }
    
    public String ConsultarNombreUsuario(UsuarioBEAN Usuario)
    {
        String usu="";
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ConsultarNombreUsuario(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Usuario.getCodigoUsuario());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
              usu=tabla.getString("NOMBRE"); 
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {}
        
        return usu;
    }
    
    public int capturarDNI(UsuarioBEAN Usuario)
    {
        int dni=0;
        
        try
        {
            conexion=new ConexionBD();
            sql="{CALL capturarDNIUsuario(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Usuario.getCodigoUsuario());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                dni=tabla.getInt(1);
            }
            
            instruccion.close();
            tabla.close();
        }
        catch(Exception e)
        {}
        
        return dni;
    }
        
    public ArrayList<UsuarioBEAN> listarUsuarioMantenimientoAlumno()
    {
        
        try 
        {
            conexion=new ConexionBD();           
            sql="{CALL listarUsuarioMantenimientoAlumno()}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<UsuarioBEAN>();
            
            while(tabla.next())
            {
                UsuarioBEAN obj=new UsuarioBEAN();
                obj.setCodigoUsuario(tabla.getInt(1));
                obj.setNombre(tabla.getString(2));
                obj.setPrimerNombre(tabla.getString(3));
                obj.setSegundoNombre(tabla.getString(4));
                obj.setApellidoPaterno(tabla.getString(5));
                obj.setApellidoMaterno(tabla.getString(6));
                obj.setCorreo(tabla.getString(7));
                obj.setTelefono(tabla.getString(8));
                obj.setTipo(tabla.getString(9));
                obj.setSexo(tabla.getString(10));
                obj.setFechaRegistro(tabla.getString(11));
                obj.setDNI(tabla.getInt(12));
                obj.setContraseña(tabla.getString(13));
                
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
    
    public ArrayList<UsuarioBEAN> listarUsuarioMantenimientoDocente()
    {
        
        try 
        {
            conexion=new ConexionBD();           
            sql="{CALL listarUsuarioMantenimientoDocente()}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<UsuarioBEAN>();
            
            while(tabla.next())
            {
                UsuarioBEAN obj=new UsuarioBEAN();
                obj.setCodigoUsuario(tabla.getInt(1));
                obj.setNombre(tabla.getString(2));
                obj.setPrimerNombre(tabla.getString(3));
                obj.setSegundoNombre(tabla.getString(4));
                obj.setApellidoPaterno(tabla.getString(5));
                obj.setApellidoMaterno(tabla.getString(6));
                obj.setCorreo(tabla.getString(7));
                obj.setTelefono(tabla.getString(8));
                obj.setTipo(tabla.getString(9));
                obj.setSexo(tabla.getString(10));
                obj.setFechaRegistro(tabla.getString(11));
                obj.setDNI(tabla.getInt(12));
                obj.setContraseña(tabla.getString(13));
                
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
    
    public ArrayList<UsuarioBEAN> listarUsuarioMantenimientoPersonal()
    {
        
        try 
        {
            conexion=new ConexionBD();           
            sql="{CALL listarUsuarioMantenimientoPersonal()}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<UsuarioBEAN>();
            
            while(tabla.next())
            {
                UsuarioBEAN obj=new UsuarioBEAN();
                obj.setCodigoUsuario(tabla.getInt(1));
                obj.setNombre(tabla.getString(2));
                obj.setPrimerNombre(tabla.getString(3));
                obj.setSegundoNombre(tabla.getString(4));
                obj.setApellidoPaterno(tabla.getString(5));
                obj.setApellidoMaterno(tabla.getString(6));
                obj.setCorreo(tabla.getString(7));
                obj.setTelefono(tabla.getString(8));
                obj.setTipo(tabla.getString(9));
                obj.setSexo(tabla.getString(10));
                obj.setFechaRegistro(tabla.getString(11));
                obj.setDNI(tabla.getInt(12));
                obj.setContraseña(tabla.getString(13));
                
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
    
    public ArrayList<UsuarioBEAN> listarTiposUsuario()
    {
        
        UsuarioBEAN obj=new UsuarioBEAN();
        lista =new ArrayList<UsuarioBEAN>();
        obj.setTipo("Alumno");
        lista.add(obj);
        UsuarioBEAN obj1=new UsuarioBEAN();
        obj1.setTipo("Docente");
        lista.add(obj1);
        UsuarioBEAN obj2=new UsuarioBEAN();
        obj2.setTipo("Personal Administrativo");
        lista.add(obj2);

        return lista;
    }
    
    public int ModificarUsuario(UsuarioBEAN Usuario)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ModificarUsuario(?,?,?,?,?,?,?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1, Usuario.getNombre());
            instruccion.setString(2, Usuario.getPrimerNombre());
            instruccion.setString(3, Usuario.getSegundoNombre());
            instruccion.setString(4, Usuario.getApellidoPaterno());
            instruccion.setString(5, Usuario.getApellidoMaterno());
            instruccion.setString(6, Usuario.getCorreo());
            instruccion.setString(7, Usuario.getTelefono());
            instruccion.setString(8, Usuario.getSexo());
            instruccion.setString(9, Usuario.getContraseña());
            instruccion.setInt(10,Usuario.getCodigoUsuario());
            i=instruccion.executeUpdate();
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
         
        return i;
    }
    
    public void EliminarUsuario(UsuarioBEAN Usuario)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL EliminarUsuario(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Usuario.getCodigoUsuario());
            instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
    }
    
    public void EliminarUsuarioXDNI(UsuarioBEAN Usuario)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL EliminarUsuarioXDNI(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Usuario.getDNI());
            instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
    }
}
