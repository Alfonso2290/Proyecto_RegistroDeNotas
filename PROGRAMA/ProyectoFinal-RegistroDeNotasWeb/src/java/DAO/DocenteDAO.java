
package DAO;
import BEAN.AulaBEAN;
import BEAN.CicloBEAN;
import BEAN.DocenteBEAN;
import BEAN.MateriaBEAN;
import BEAN.NivelBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.ArrayList;

public class DocenteDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<DocenteBEAN> lista;
    
    public int Consulta(DocenteBEAN Docente)
    {
        int cant=0;
        try 
        {
           conexion=new ConexionBD();
           sql="{CALL ConsultaCodigoDocente(?)}";
           instruccion=conexion.getConexionBD().prepareCall(sql);
           instruccion.setInt(1,Docente.getCodigoDocente());
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
    public void EliminarDocente(DocenteBEAN Docente)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL EliminarDocente(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Docente.getCodigoDocente());
            instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
    }
    
    public int ConsultarCargosDocente(DocenteBEAN Docente)
    {
        int cont=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ConsultarCargosDocente(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Docente.getDNI());
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
    
    public ArrayList<DocenteBEAN> listarDocenteMantenimiento()
    {
        
        try 
        {
            conexion=new ConexionBD();           
            sql="{CALL listarDocenteMantenimiento()}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<DocenteBEAN>();
            
            while(tabla.next())
            {
                DocenteBEAN obj=new DocenteBEAN();
                obj.setCodigoDocente(tabla.getInt(1));
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
    
    public DocenteBEAN listarObjetoDocente(DocenteBEAN Docente)
    {
        DocenteBEAN obj=null;
        try 
        {
            conexion=new ConexionBD();           
            sql="{CALL listarObjetoDocente(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Docente.getCodigoDocente());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                obj=new DocenteBEAN();
                obj.setCodigoDocente(tabla.getInt(1));
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
    
    
    public int InsertarDocente(DocenteBEAN Docente)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL InsertarDocente(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Docente.getDNI());
            i=instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
        
        return i;
    }
    
    public DocenteBEAN capturarNombre(AulaBEAN obj)
    {
        DocenteBEAN objBEAN=null;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarNombreDocente(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, obj.getCodigoDocente());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                objBEAN=new DocenteBEAN();
                objBEAN.setNombre(tabla.getString(1));
                objBEAN.setApellidoPaterno(tabla.getString(2));
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return objBEAN;
    }
    
    public boolean ConsultaXDNI(DocenteBEAN Docente)
    {
        boolean b=false;
        try 
        {
           conexion=new ConexionBD();
           sql="{CALL ConsultaDocenteXDNI(?)}";
           instruccion=conexion.getConexionBD().prepareCall(sql);
           instruccion.setInt(1,Docente.getDNI());
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
    
    public int CapturarDNI(DocenteBEAN Docente)
    {
        int dni=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL CapturarDNIDocente(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Docente.getCodigoDocente());
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
    
    public int CapturarCodigo(DocenteBEAN Docente)
    {
        int codigo=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL CapturarCodigoDocente(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Docente.getDNI());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                codigo=tabla.getInt("COD_DOCENTE");
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return codigo;
    }
    
    public ArrayList<DocenteBEAN> listarDocentes(MateriaBEAN Materia,NivelBEAN Nivel,CicloBEAN Ciclo,AulaBEAN Aula)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarDocentes(?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Materia.getCodigoMateria());
            instruccion.setInt(2, Nivel.getCodigoNivel());
            instruccion.setInt(3, Ciclo.getCodigoCiclo());
            instruccion.setString(4, Aula.getNumAula());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<DocenteBEAN>();
            
            while(tabla.next())
            {
                DocenteBEAN objBEAN=new DocenteBEAN();
                objBEAN.setCodigoDocente(tabla.getInt(1));
                objBEAN.setNombre(tabla.getString(2));
                objBEAN.setApellidoPaterno(tabla.getString(3));
                
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
    
    public ArrayList<DocenteBEAN> listarTodosDocentes()
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarTodosDocentes()}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<DocenteBEAN>();
            
            while(tabla.next())
            {
                DocenteBEAN objBEAN=new DocenteBEAN();
                objBEAN.setCodigoDocente(tabla.getInt(1));
                objBEAN.setNombre(tabla.getString(2));
                objBEAN.setApellidoPaterno(tabla.getString(3));
                objBEAN.setApellidoMaterno(tabla.getString(4));
                
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
