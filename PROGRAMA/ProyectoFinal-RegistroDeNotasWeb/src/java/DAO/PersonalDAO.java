
package DAO;
import BEAN.PersonalBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class PersonalDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<PersonalBEAN> lista=null;
    
    public int Consulta(PersonalBEAN Personal)
    {
        int cant=0;
        try 
        {
           conexion=new ConexionBD();
           sql="{CALL ConsultaPersonal(?)}";
           instruccion=conexion.getConexionBD().prepareCall(sql);
           instruccion.setInt(1,Personal.getCodigoPersonal());
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
    
    public boolean ConsultaXDNI(PersonalBEAN Personal)
    {
        boolean b=false;
        try 
        {
           conexion=new ConexionBD();
           sql="{CALL ConsultaXDNIPersonal(?)}";
           instruccion=conexion.getConexionBD().prepareCall(sql);
           instruccion.setInt(1,Personal.getDNI());
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
    
    public int CapturarDNI(PersonalBEAN Personal)
    {
        int dni=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL CapturarDNIPersonal(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Personal.getCodigoPersonal());
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
    
    public int ConsultarCargos(PersonalBEAN Personal)
    {
        int cont=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ConsultarCargos(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Personal.getDNI());
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
    
    public ArrayList<PersonalBEAN> listarPersonalMantenimiento()
    {
        
        try 
        {
            conexion=new ConexionBD();           
            sql="{CALL listarPersonalMantenimiento()}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<PersonalBEAN>();
            
            while(tabla.next())
            {
                PersonalBEAN obj=new PersonalBEAN();
                obj.setCodigoPersonal(tabla.getInt(1));
                obj.setDNI(tabla.getInt(2));
                obj.setHoraIngreso(tabla.getString(3));
                obj.setHoraSalida(tabla.getString(4));
                obj.setCargo(tabla.getString(5));
                obj.setCodigoDistrito(tabla.getInt(6));
                obj.setCodigoProvincia(tabla.getInt(7));
                obj.setCodigoDepartamento(tabla.getInt(8));
                obj.setCodigoCalle(tabla.getInt(9));
                obj.setNombre(tabla.getString(10));
                obj.setApellidoPaterno(tabla.getString(11));
                obj.setApellidoMaterno(tabla.getString(12));
                obj.setSexo(tabla.getString(13));
                obj.setFechaNac(tabla.getString(14));
                obj.setCorreo(tabla.getString(15));
                obj.setTelefono(tabla.getString(16));
                obj.setNumExt(tabla.getInt(17));
                obj.setNumInt(tabla.getInt(18));
                
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
    
    public PersonalBEAN listarObjetoPersonal(PersonalBEAN Personal)
    {
        PersonalBEAN obj=null;
        try 
        {
            conexion=new ConexionBD();           
            sql="{CALL listarObjetoPersonal(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Personal.getCodigoPersonal());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                obj=new PersonalBEAN();
                obj.setCodigoPersonal(tabla.getInt(1));
                obj.setDNI(tabla.getInt(2));
                obj.setHoraIngreso(tabla.getString(3));
                obj.setHoraSalida(tabla.getString(4));
                obj.setCargo(tabla.getString(5));
                obj.setCodigoDistrito(tabla.getInt(6));
                obj.setCodigoProvincia(tabla.getInt(7));
                obj.setCodigoDepartamento(tabla.getInt(8));
                obj.setCodigoCalle(tabla.getInt(9));
                obj.setNombre(tabla.getString(10));
                obj.setApellidoPaterno(tabla.getString(11));
                obj.setApellidoMaterno(tabla.getString(12));
                obj.setSexo(tabla.getString(13));
                obj.setFechaNac(tabla.getString(14));
                obj.setCorreo(tabla.getString(15));
                obj.setTelefono(tabla.getString(16));
                obj.setNumExt(tabla.getInt(17));
                obj.setNumInt(tabla.getInt(18));
                
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        
        return obj;
    }
    
    public int InsertarPersonal(PersonalBEAN Personal)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL InsertarPersonal(?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Personal.getDNI());
            instruccion.setString(2, Personal.getHoraIngreso());
            instruccion.setString(3, Personal.getHoraSalida());
            instruccion.setString(4, Personal.getCargo());
            i=instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
        
        return i;
    }
    
    public int ModificarPersonal(PersonalBEAN Personal)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ModificarPersonal(?,?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Personal.getDNI());
            instruccion.setString(2, Personal.getHoraIngreso());
            instruccion.setString(3, Personal.getHoraSalida());
            instruccion.setString(4, Personal.getCargo());
            instruccion.setInt(5, Personal.getCodigoPersonal());
            i=instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
        
        return i;
    }
    
    public void EliminarPersonal(PersonalBEAN Personal)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL EliminarPersonal(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Personal.getCodigoPersonal());
            instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
    }
}
