
package DAO;

import BEAN.AulaBEAN;
import BEAN.MateriaBEAN;
import BEAN.NivelBEAN;
import java.sql.*;
import UTIL.ConexionBD;
import java.util.ArrayList;

public class NivelDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<NivelBEAN> lista=null;
    
    public void InsertarNivel(NivelBEAN Nivel)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL InsertarNivel(?,?)} ";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Nivel.getCodigoNivel());
            instruccion.setString(2, Nivel.getNombre());
            instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
    }
    
    public ArrayList<NivelBEAN> listarNiveles(MateriaBEAN Materia)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarRegistroNiveles(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Materia.getCodigoMateria());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<NivelBEAN>();
            
            while(tabla.next())
            {
                NivelBEAN objBEAN=new NivelBEAN();
                objBEAN.setCodigoNivel(tabla.getInt(1));
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
    
    public NivelBEAN capturarNombre(AulaBEAN obj)
    {
        NivelBEAN objBEAN=null;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarNombreNivel(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, obj.getCodigoNivel());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                objBEAN=new NivelBEAN();
                objBEAN.setNombre(tabla.getString(1));
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return objBEAN;
    }
    
    public int capturarCodigoNivel()
    {
        int codigo=1;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarCodigoNivel()}";
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
    
    public int capturarCodigoNivelXNombre(NivelBEAN obj)
    {
        int codigo=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarCodigoNivelXNombre(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1, obj.getNombre());
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
}


