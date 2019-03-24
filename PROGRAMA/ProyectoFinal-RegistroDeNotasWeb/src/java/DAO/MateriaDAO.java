
package DAO;

import BEAN.AulaBEAN;
import BEAN.MateriaBEAN;
import java.sql.*;
import UTIL.ConexionBD;
import java.util.ArrayList;

public class MateriaDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<MateriaBEAN> lista=null;
    
    public ArrayList<MateriaBEAN> listarMaterias()
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarMaterias()}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<MateriaBEAN>();
            
            while(tabla.next())
            {
                MateriaBEAN objBEAN=new MateriaBEAN();
                objBEAN.setCodigoMateria(tabla.getInt(1));
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
    
    public MateriaBEAN capturarNombre(AulaBEAN obj)
    {
        MateriaBEAN objBEAN=null;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarNombreMateria(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, obj.getCodigoMateria());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                objBEAN=new MateriaBEAN();
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
    
    public int capturarCodigoMateria()
    {
        int codigo=1;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarCodigoMateria()}";
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
    
    public int capturarCodigoMateriaXNombre(MateriaBEAN obj)
    {
        int codigo=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarCodigoMateriaXNombre(?)}";
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
    
    public void InsertarMateria(MateriaBEAN Materia)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL InsertarMateria(?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Materia.getCodigoMateria());
            instruccion.setString(2, Materia.getNombre());
            instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
    }
}


