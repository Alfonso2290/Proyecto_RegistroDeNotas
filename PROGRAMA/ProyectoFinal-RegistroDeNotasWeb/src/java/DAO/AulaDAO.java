
package DAO;

import BEAN.AulaBEAN;
import BEAN.CicloBEAN;
import BEAN.DocenteBEAN;
import BEAN.EstudianteBEAN;
import BEAN.MateriaBEAN;
import BEAN.NivelBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.*;

public class AulaDAO 
{
    ConexionBD conexion=null;
    CallableStatement instruccion=null;
    ResultSet tabla=null;
    String sql="";
    ArrayList<AulaBEAN> lista=null;
    ArrayList<AulaBEAN> listamaterias=null;
    ArrayList<AulaBEAN> listaniveles=null;
    ArrayList<AulaBEAN> listaciclos=null;
    ArrayList<AulaBEAN> listaaulas=null;
    
    public ArrayList<AulaBEAN> listarAulaDocente(DocenteBEAN Docente,MateriaBEAN Materia,NivelBEAN Nivel,CicloBEAN Ciclo)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarAulaDocente(?,?,?,?)} ";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Docente.getCodigoDocente());
            instruccion.setInt(2,Materia.getCodigoMateria());
            instruccion.setInt(3,Nivel.getCodigoNivel());
            instruccion.setInt(4,Ciclo.getCodigoCiclo());
            tabla=instruccion.executeQuery();
            listaaulas=new ArrayList<AulaBEAN>();
            
            while(tabla.next())
            {
                AulaBEAN objBEAN=new AulaBEAN();
                objBEAN.setNumAula(tabla.getString(1));
                
                listaaulas.add(objBEAN);
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return listaaulas;
    }
    
    public int InsertarAula(AulaBEAN Aula)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL InsertarAula(?,?,?,?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1, Aula.getNumAula());
            instruccion.setInt(2, Aula.getCodigoDocente());
            instruccion.setString(3, Aula.getCodigoModulo());
            instruccion.setString(4, Aula.getModalidad());
            instruccion.setString(5, Aula.getHoraIngreso());
            instruccion.setString(6, Aula.getHoraSalida());
            instruccion.setInt(7, Aula.getCupo());
            i=instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
        
        return i;
    }
    
    public ArrayList<AulaBEAN> listarAulaMantenimiento(MateriaBEAN Materia,NivelBEAN Nivel,CicloBEAN Ciclo)
    {
        
        try 
        {
            conexion=new ConexionBD();           
            sql="{CALL listarAulaMantenimiento(?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Materia.getCodigoMateria());
            instruccion.setInt(2, Nivel.getCodigoNivel());
            instruccion.setInt(3, Ciclo.getCodigoCiclo());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<AulaBEAN>();
            
            while(tabla.next())
            {
                AulaBEAN obj=new AulaBEAN();
                obj.setNumAula(tabla.getString(1));
                obj.setCodigoDocente(tabla.getInt(2));
                obj.setCodigoModulo(tabla.getString(3));
                obj.setModalidad(tabla.getString(4));
                obj.setHoraIngreso(tabla.getString(5));
                obj.setHoraSalida(tabla.getString(6));
                obj.setCupo(tabla.getInt(7));
                obj.setNombreDocente(tabla.getString(8));
                obj.setApePaternoDocente(tabla.getString(9));
                obj.setApeMaternoDocente(tabla.getString(10));
                obj.setNomMateria(tabla.getString(11));
                obj.setNomNivel(tabla.getString(12));
                obj.setNumCiclo(tabla.getInt(13));
                obj.setCodigoMateria(tabla.getInt(14));
                obj.setCodigoNivel(tabla.getInt(15));
                obj.setCodigoCiclo(tabla.getInt(16));
                
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
    
    public void EliminarAula(AulaBEAN Aula)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL EliminarAula(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1, Aula.getNumAula());
            instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
    }
    
    public AulaBEAN listarObjetoAula(AulaBEAN Aula)
    {
        AulaBEAN obj=null;
        try 
        {
            conexion=new ConexionBD();           
            sql="{CALL listarObjetoAula(?)} ";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1, Aula.getNumAula());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                obj=new AulaBEAN();
                obj.setNumAula(tabla.getString(1));
                obj.setCodigoDocente(tabla.getInt(2));
                obj.setCodigoModulo(tabla.getString(3));
                obj.setModalidad(tabla.getString(4));
                obj.setHoraIngreso(tabla.getString(5));
                obj.setHoraSalida(tabla.getString(6));
                obj.setCupo(tabla.getInt(7));
                obj.setNombreDocente(tabla.getString(8));
                obj.setApePaternoDocente(tabla.getString(9));
                obj.setApeMaternoDocente(tabla.getString(10));
                obj.setNomMateria(tabla.getString(11));
                obj.setNomNivel(tabla.getString(12));
                obj.setNumCiclo(tabla.getInt(13));
                obj.setCodigoMateria(tabla.getInt(14));
                obj.setCodigoNivel(tabla.getInt(15));
                obj.setCodigoCiclo(tabla.getInt(16));
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        
        return obj;
    }
    
    public int ModificarAula(AulaBEAN Aula)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL ModificarAula(?,?,?,?,?,?)} ";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Aula.getCodigoDocente());
            instruccion.setString(2, Aula.getModalidad());
            instruccion.setString(3, Aula.getHoraIngreso());
            instruccion.setString(4, Aula.getHoraSalida());
            instruccion.setInt(5, Aula.getCupo());
            instruccion.setString(6, Aula.getNumAula());
            i=instruccion.executeUpdate();
            
            instruccion.close();
        } 
        catch (Exception e) {}
        
        return i;
    }
    
    public ArrayList<AulaBEAN> listarMateriaDocente(DocenteBEAN Docente)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarMateriaDocente(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Docente.getCodigoDocente());
            tabla=instruccion.executeQuery();
            listamaterias=new ArrayList<AulaBEAN>();
            
            while(tabla.next())
            {
                AulaBEAN objBEAN=new AulaBEAN();
                objBEAN.setCodigoMateria(tabla.getInt(1));
                objBEAN.setNomMateria(tabla.getString(2));
                
                listamaterias.add(objBEAN);
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return listamaterias;
    }
    
    public ArrayList<AulaBEAN> listarNivelDocente(MateriaBEAN Materia,DocenteBEAN Docente)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarNivelDocente(?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Docente.getCodigoDocente());
            instruccion.setInt(2,Materia.getCodigoMateria());
            tabla=instruccion.executeQuery();
            listaniveles=new ArrayList<AulaBEAN>();
            
            while(tabla.next())
            {
                AulaBEAN objBEAN=new AulaBEAN();
                objBEAN.setCodigoNivel(tabla.getInt(1));
                objBEAN.setNomNivel(tabla.getString(2));
                
                listaniveles.add(objBEAN);
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return listaniveles;
    }
    
    public ArrayList<AulaBEAN> listarCicloDocente(NivelBEAN Nivel,DocenteBEAN Docente,MateriaBEAN Materia)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarCicloDocente(?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Docente.getCodigoDocente());
            instruccion.setInt(2,Nivel.getCodigoNivel());
            instruccion.setInt(3,Materia.getCodigoMateria());
            tabla=instruccion.executeQuery();
            listaciclos=new ArrayList<AulaBEAN>();
            
            while(tabla.next())
            {
                AulaBEAN objBEAN=new AulaBEAN();
                objBEAN.setCodigoCiclo(tabla.getInt(1));
                objBEAN.setNomCiclo(tabla.getString(2));
                
                listaciclos.add(objBEAN);
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return listaciclos;
    }
     public ArrayList<AulaBEAN> listarAulaEstudiante(EstudianteBEAN Estudiante,MateriaBEAN Materia,NivelBEAN Nivel,CicloBEAN Ciclo)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarAulaEstudiante (?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Estudiante.getCodigoEstudiante());
            instruccion.setInt(2,Materia.getCodigoMateria());
            instruccion.setInt(3,Nivel.getCodigoNivel());
            instruccion.setInt(4,Ciclo.getCodigoCiclo());
            tabla=instruccion.executeQuery();
            listaaulas=new ArrayList<AulaBEAN>();
            
            while(tabla.next())
            {
                AulaBEAN objBEAN=new AulaBEAN();
                objBEAN.setNumAula(tabla.getString(1));
                
                listaaulas.add(objBEAN);
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return listaaulas;
    }
    
    public ArrayList<AulaBEAN> listarMateriaEstudiante(EstudianteBEAN Estudiante)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarMateriaEstudiante(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Estudiante.getCodigoEstudiante());
            tabla=instruccion.executeQuery();
            listamaterias=new ArrayList<AulaBEAN>();
            
            while(tabla.next())
            {
                AulaBEAN objBEAN=new AulaBEAN();
                objBEAN.setCodigoMateria(tabla.getInt(1));
                objBEAN.setNomMateria(tabla.getString(2));
                
                listamaterias.add(objBEAN);
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return listamaterias;
    }
    
    public ArrayList<AulaBEAN> listarNivelEstudiante(MateriaBEAN Materia,EstudianteBEAN Estudiante)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarNivelEstudiante(?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Estudiante.getCodigoEstudiante());
            instruccion.setInt(2,Materia.getCodigoMateria());
            tabla=instruccion.executeQuery();
            listaniveles=new ArrayList<AulaBEAN>();
            
            while(tabla.next())
            {
                AulaBEAN objBEAN=new AulaBEAN();
                objBEAN.setCodigoNivel(tabla.getInt(1));
                objBEAN.setNomNivel(tabla.getString(2));
                
                listaniveles.add(objBEAN);
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return listaniveles;
    }
    
    public ArrayList<AulaBEAN> listarCicloEstudiante(NivelBEAN Nivel,EstudianteBEAN Estudiante,MateriaBEAN Materia)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarCicloEstudiante(?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1,Estudiante.getCodigoEstudiante());
            instruccion.setInt(2,Nivel.getCodigoNivel());
            instruccion.setInt(3,Materia.getCodigoMateria());
            tabla=instruccion.executeQuery();
            listaciclos=new ArrayList<AulaBEAN>();
            
            while(tabla.next())
            {
                AulaBEAN objBEAN=new AulaBEAN();
                objBEAN.setCodigoCiclo(tabla.getInt(1));
                objBEAN.setNomCiclo(tabla.getString(2));
                
                listaciclos.add(objBEAN);
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return listaciclos;
    }
    
    public ArrayList<AulaBEAN> listarAulas(MateriaBEAN Materia,NivelBEAN Nivel,CicloBEAN Ciclo)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarAulas(?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Materia.getCodigoMateria());
            instruccion.setInt(2, Nivel.getCodigoNivel());
            instruccion.setInt(3, Ciclo.getCodigoCiclo());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<AulaBEAN>();
            
            while(tabla.next())
            {
                AulaBEAN objBEAN=new AulaBEAN();
                objBEAN.setNumAula(tabla.getString(1));
                
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
    
    public ArrayList<AulaBEAN> listarModalidades(MateriaBEAN Materia,NivelBEAN Nivel,CicloBEAN Ciclo,AulaBEAN Aula,DocenteBEAN Docente)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL listarModalidades(?,?,?,?,?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setInt(1, Materia.getCodigoMateria());
            instruccion.setInt(2, Nivel.getCodigoNivel());
            instruccion.setInt(3, Ciclo.getCodigoCiclo());
            instruccion.setString(4, Aula.getNumAula());
            instruccion.setInt(5, Docente.getCodigoDocente());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<AulaBEAN>();
            
            while(tabla.next())
            {
                AulaBEAN objBEAN=new AulaBEAN();
                objBEAN.setModalidad(tabla.getString(1));
                
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
    
    public int VacanteCupo(AulaBEAN Aula)
    {
        int cant=0;
        try 
        {
            conexion=new ConexionBD();
            sql="{CALL VacanteCupo(?)}";
            instruccion=conexion.getConexionBD().prepareCall(sql);
            instruccion.setString(1, Aula.getNumAula());
            tabla=instruccion.executeQuery();
            
            while(tabla.next())
            {
                cant=tabla.getInt("CUPO");
            }
            
            instruccion.close();
            tabla.close();
            
        } 
        catch (Exception e) 
        {
        }
        
        return cant;
    }
    
    
}
