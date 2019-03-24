
package DAO;

import BEAN.EstudianteBEAN;
import BEAN.ModuloBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
public class ModuloDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<ModuloBEAN> lista=null;
    
    public int InsertarModulo(ModuloBEAN Modulo)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL InsertarModulo(?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1, Modulo.getCodigoModulo());
            instruccion.setInt(2, Modulo.getCodigoMateria());
            instruccion.setInt(3, Modulo.getCodigoNivel());
            instruccion.setInt(4, Modulo.getCodigoCiclo());
            i=instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
        
        return i;
    }
    
    public void EliminarModulo(ModuloBEAN Modulo)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL EliminarModulo(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1, Modulo.getCodigoModulo());
            instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
    }
    
    public String capturarCodigoModulo(ModuloBEAN Modulo)
    {
        String codigo="";
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL capturarCodigoModuloXMatNivCic(?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Modulo.getCodigoMateria());
            instruccion.setInt(2, Modulo.getCodigoNivel());
            instruccion.setInt(3, Modulo.getCodigoCiclo());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                codigo=tabla.getString(1);
            }
            
            instruccion.close();
            tabla.close();
           
        } 
        catch (Exception e) 
        {}
        
        return codigo;
    }
    
    public ArrayList<ModuloBEAN> listarModuloMantenimiento()
    {
        
        try 
        {
            conexion=new ConexionBD();           
            sql="{CALL listarModuloMantenimiento()}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<ModuloBEAN>();
            
            while(tabla.next())
            {
                ModuloBEAN obj=new ModuloBEAN();
                obj.setCodigoModulo(tabla.getString(1));
                obj.setCodigoMateria(tabla.getInt(2));
                obj.setCodigoNivel(tabla.getInt(3));
                obj.setCodigoCiclo(tabla.getInt(4));
                obj.setNomMateria(tabla.getString(5));
                obj.setNomNivel(tabla.getString(6));
                obj.setNomCiclo(tabla.getInt(7));
                
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
}
