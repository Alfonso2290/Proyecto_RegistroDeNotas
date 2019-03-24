
package DAO;

import BEAN.AulaBEAN;
import BEAN.CicloBEAN;
import BEAN.MateriaBEAN;
import BEAN.NivelBEAN;
import java.sql.*;
import UTIL.ConexionBD;
import java.util.ArrayList;

public class CicloDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<CicloBEAN> lista=null;
    
    public int capturarCodigoCicloXNombre(CicloBEAN obj)
    {
        int codigo=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarCodigoCicloXNombre(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, obj.getNumCiclo());
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
    
    public ArrayList<CicloBEAN> listarNiveles(MateriaBEAN Materia,NivelBEAN Nivel)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarNiveles(?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Materia.getCodigoMateria());
            instruccion.setInt(2, Nivel.getCodigoNivel());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<CicloBEAN>();
            
            while(tabla.next())
            {
                CicloBEAN objBEAN=new CicloBEAN();
                objBEAN.setCodigoCiclo(tabla.getInt(1));
                objBEAN.setNumCiclo(tabla.getInt(2));
                
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
    
    public void InsertarCiclo(CicloBEAN Ciclo)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL InsertarCiclo(?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Ciclo.getCodigoCiclo());
            instruccion.setInt(2, Ciclo.getNumCiclo());
            instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
    }
    
    public CicloBEAN capturarNombre(AulaBEAN obj)
    {
        CicloBEAN objBEAN=null;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarNombreCiclo(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, obj.getCodigoCiclo());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                objBEAN=new CicloBEAN();
                objBEAN.setNumCiclo(tabla.getInt(1));
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return objBEAN;
    }
    
    public int capturarCodigoCiclo()
    {
        int codigo=1;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarCodigoCiclo()}";
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
}
