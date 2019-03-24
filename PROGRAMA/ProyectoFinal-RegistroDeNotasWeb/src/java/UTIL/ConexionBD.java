package UTIL;
import java.sql.*;

public class ConexionBD 
{
    private Connection conexion;
    
    public Connection getConexionBD()
    {
        conexion=null;
       
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/instituto","root","");
            System.out.println("Conexion Exitosa con la Base de Datos");
        } 
        catch (Exception e) 
        {
            System.out.println("ERROR!!.No se pudo Conectar con la Base de Datos");
        }
        
        return conexion;
    }
    
    public void Desconectar()
    {
        try 
        {
            conexion.close();
        } 
        catch (Exception e) {}
    }
    
    public static void main(String[] args) 
    {
       ConexionBD objeto=new ConexionBD();
       objeto.getConexionBD();
    }
    
}


