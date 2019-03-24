
package Controladores;

import BEAN.CalleBEAN;
import BEAN.DepartamentoBEAN;
import BEAN.DistritoBEAN;
import BEAN.PersonaBEAN;
import BEAN.PersonalBEAN;
import BEAN.ProvinciaBEAN;
import BEAN.UsuarioBEAN;
import DAO.CalleDAO;
import DAO.DepartamentoDAO;
import DAO.DistritoDAO;
import DAO.PersonaDAO;
import DAO.PersonalDAO;
import DAO.ProvinciaDAO;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PersonalAdministrativoServlet extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String cadop=request.getParameter("op");
        int op=Integer.parseInt(cadop);
        String pagina="";
        
        switch(op)
        {
            case 1:
            {
                HttpSession misesion=request.getSession();
                misesion.invalidate();
                pagina="/index.jsp";
                break;
            }
            case 2:
            {
               HttpSession misesion=request.getSession();
               misesion.invalidate();
               pagina="/Seguridad/Personal/FrmPersonalLogin.jsp";
               break;
            }
            case 3:
            {
                String strcodusu=request.getParameter("codusuario");
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN= new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                
                ArrayList<UsuarioBEAN> listaUsuario;
                UsuarioDAO objusuDAO=new UsuarioDAO();
                listaUsuario=objusuDAO.listarUsuario(objusuBEAN);
                
                request.setAttribute("LISTAUSUARIO", listaUsuario);
                
                
                pagina="/Visualizar/Personal/PersonalAdministrativo/FrmPerfilPersonalAdministrativo.jsp";
                break;
            }
            case 4:
            {
               
               pagina="/Seguridad/Personal/PersonalAdministrativo/FrmPersonalAdministrativoPrincipal.jsp";
               break;
            }
            case 5:
            {
                String strcodusu=request.getParameter("codusuario");
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN= new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                
                ArrayList<UsuarioBEAN> listaUsuario;
                UsuarioDAO objusuDAO=new UsuarioDAO();
                listaUsuario=objusuDAO.listarUsuario(objusuBEAN);
                
                request.setAttribute("LISTAUSUARIO", listaUsuario);
                
                pagina="/Configuracion/Personal/PersonalAdministrativo/FrmActualizarInformacionPersonalAdministrativo.jsp";
                break;
            }
            case 6:
            {
                String strcodusu=request.getParameter("codusuario");
                int codusu=Integer.parseInt(strcodusu);
                String usu=request.getParameter("txtUsu");
                String nom1=request.getParameter("txtNom1");
                String nom2=request.getParameter("txtNom2");
                String apepa=request.getParameter("txtApePa");
                String apema=request.getParameter("txtApeMa");
                String tel=request.getParameter("txtTele");
                String correo=request.getParameter("txtCorreo");
                String sexo=request.getParameter("cboSexo");
                
                UsuarioBEAN objusuBEAN= new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                objusuBEAN.setNombre(usu);
                objusuBEAN.setPrimerNombre(nom1);
                objusuBEAN.setSegundoNombre(nom2);
                objusuBEAN.setApellidoPaterno(apepa);
                objusuBEAN.setApellidoMaterno(apema);
                objusuBEAN.setTelefono(tel);
                objusuBEAN.setCorreo(correo);
                objusuBEAN.setSexo(sexo);
                
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int existenciaUsuario=objusuDAO.capturarUsuario(objusuBEAN);
                String usuActual=objusuDAO.ConsultarNombreUsuario(objusuBEAN);
                
                if(existenciaUsuario==0)
                { 
                    objusuDAO.ActualizarUsuario(objusuBEAN);
                    request.setAttribute("MENSAJE", "Se ha actualizado el registro correctamente");
                }
                else
                {
                    if(usu.equals(usuActual))
                    {
                        objusuDAO.ActualizarUsuario(objusuBEAN);
                        request.setAttribute("MENSAJE", "Se ha actualizado el registro correctamente");
                    }
                    else
                    {
                        request.setAttribute("MENSAJE", "El Usuario al que desea cambiar ya existe");
                    }
                }
               
                ArrayList<UsuarioBEAN> listaUsuario;
                listaUsuario=objusuDAO.listarUsuario(objusuBEAN);
                
                request.setAttribute("LISTAUSUARIO", listaUsuario);
                
                pagina="/Configuracion/Personal/PersonalAdministrativo/FrmActualizarInformacionPersonalAdministrativo.jsp";
                break;
            }
            case 7:
            {
                
                pagina="/Configuracion/Personal/PersonalAdministrativo/FrmCambiarContraseñaPersonalAdministrativo.jsp";
                break;
            }
            case 8:
            {
               String strcodusu=request.getParameter("codusuario");
               int codusu=Integer.parseInt(strcodusu);

               String pas=request.getParameter("txtPas");
               
               UsuarioBEAN objusuBEAN=new UsuarioBEAN();
               objusuBEAN.setCodigoUsuario(codusu);
               objusuBEAN.setContraseña(pas);
               
               UsuarioDAO objusuDAO=new UsuarioDAO();
               int cant=objusuDAO.confirmarUsuarioContraseñaxCodigo(objusuBEAN);
               
               String newpas=request.getParameter("txtPas1");
               UsuarioBEAN objusuBEAN2=new UsuarioBEAN();
               objusuBEAN2.setCodigoUsuario(codusu);
               objusuBEAN2.setContraseña(newpas);
               
               
               
               if(cant==0)
               {
                   request.setAttribute("MENSAJE", "La Contraseña actual ingresada es incorrecta");
               }
               else
               {
                   objusuDAO.ActualizarContraseña(objusuBEAN2);
                   request.setAttribute("MENSAJE", "Se ha cambiada la contraseña correctamente");
               }
               
                
               pagina="/Configuracion/Personal/PersonalAdministrativo/FrmCambiarContraseñaPersonalAdministrativo.jsp";
               break;
            }
            case 9:
            {
                
                ArrayList<PersonalBEAN> lista=null;
                PersonalDAO objperdao=new PersonalDAO();
                lista=objperdao.listarPersonalMantenimiento(); 

                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                
                pagina="/Mantenimiento/Personal/PersonalAdministrativo/FrmMantenimientoPersonalAdministrativo.jsp";
                break;
            }
            case 10:
            {
                pagina="/Seguridad/Personal/PersonalAdministrativo/FrmPersonalAdministrativoPrincipal.jsp";
                break;
            }
            case 11:
            {
                
                ArrayList<PersonalBEAN> lista=null;
                PersonalDAO objperdao=new PersonalDAO();
                lista=objperdao.listarPersonalMantenimiento(); 

                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                
                pagina="/Mantenimiento/Personal/PersonalAdministrativo/FrmMantenimientoPersonalAdministrativo.jsp";
                break;
            }
            case 12:
            {
                String strdni=request.getParameter("txtDNI");
                int dni=Integer.parseInt(strdni);
                String nom=request.getParameter("txtNom");
                String apepa=request.getParameter("txtApePa");
                String apema=request.getParameter("txtApeMa");
                String cargo=request.getParameter("txtCargo");
                String horai=request.getParameter("txtHoraI");
                String horas=request.getParameter("txtHoraS");
                String sexo=request.getParameter("cbSexo");
                String fecha=request.getParameter("txtFechaNac");
                String correo=request.getParameter("txtCorreo");
                String tel=request.getParameter("txtTel");
                String strdep=request.getParameter("cbDepartamento");
                int dep=Integer.parseInt(strdep);
                String strpro=request.getParameter("cbProvincia");
                int pro=Integer.parseInt(strpro);
                String strdis=request.getParameter("cbDistrito");
                int dis=Integer.parseInt(strdis);
                String strcal=request.getParameter("cbCalle");
                int cal=Integer.parseInt(strcal);
                String strnume=request.getParameter("txtNumE");
                int nume=Integer.parseInt(strnume);
                String strnumi=request.getParameter("txtNumI");
                int numi=Integer.parseInt(strnumi);
                               
                PersonalBEAN objperBEAN=new PersonalBEAN();
                objperBEAN.setDNI(dni);
                objperBEAN.setHoraIngreso(horai);
                objperBEAN.setHoraSalida(horas);
                objperBEAN.setCargo(cargo);
                
                PersonaBEAN objpeBEAN=new PersonaBEAN();
                objpeBEAN.setDNI(dni);
                objpeBEAN.setCodigoDepartamento(dep);
                objpeBEAN.setCodigoProvincia(pro);
                objpeBEAN.setCodigoDistrito(dis);
                objpeBEAN.setCodigoCalle(cal);
                objpeBEAN.setNombre(nom);
                objpeBEAN.setApellidoPaterno(apepa);
                objpeBEAN.setApellidoMaterno(apema);
                objpeBEAN.setSexo(sexo);
                objpeBEAN.setFechaNac(fecha);
                objpeBEAN.setCorreo(correo);
                objpeBEAN.setTelefono(tel);
                objpeBEAN.setNumExt(nume);
                objpeBEAN.setNumInt(numi);
               
                PersonalDAO objperDAO=new PersonalDAO();
                PersonaDAO objpeDAO=new PersonaDAO();
                
                int j=objpeDAO.InsertarPersona(objpeBEAN);    
                int i=objperDAO.InsertarPersonal(objperBEAN);
                if(i==0)
                {
                    request.setAttribute("MENSAJE", "NO SE HA REALIZADO EL REGISTRO");
                } 
                else
                {
                    request.setAttribute("MENSAJE", "SE HA REALIZADO EL REGISTRO CORRECTAMENTE");
                }
                
                
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                request.setAttribute("LISTADEPARTAMENTOS", lista);
                
                pagina="/Mantenimiento/Personal/PersonalAdministrativo/FrmMantenimientoRegistrarPersonalAdministrativo.jsp";
                break; 
            }
            case 13:
            {
               
                String strcodper=request.getParameter("codper");
                int codper=Integer.parseInt(strcodper);
                String strdni=request.getParameter("dni");
                int dni=Integer.parseInt(strdni);
                String nom=request.getParameter("nom");
                String apepa=request.getParameter("apepa");
                String apema=request.getParameter("apema");
                String cargo=request.getParameter("cargo");
                String horai=request.getParameter("horaI");
                String horas=request.getParameter("horaS");
                String sexo=request.getParameter("sexo");
                String fecha=request.getParameter("fecha");
                String correo=request.getParameter("correo");
                String tel=request.getParameter("tel");
                String strdep=request.getParameter("coddep");
                int dep=Integer.parseInt(strdep);
                String strpro=request.getParameter("codpro");
                int pro=Integer.parseInt(strpro);
                String strdis=request.getParameter("coddis");
                int dis=Integer.parseInt(strdis);
                String strcal=request.getParameter("codcal");
                int cal=Integer.parseInt(strcal);
                String strnume=request.getParameter("NumE");
                int nume=Integer.parseInt(strnume);
                String strnumi=request.getParameter("NumI");
                int numi=Integer.parseInt(strnumi);
                
                PersonalBEAN objperBEAN=new PersonalBEAN();
                objperBEAN.setCodigoPersonal(codper);
                objperBEAN.setDNI(dni);
                objperBEAN.setHoraIngreso(horai);
                objperBEAN.setHoraSalida(horas);
                objperBEAN.setCargo(cargo);
                objperBEAN.setCodigoDepartamento(dep);
                objperBEAN.setCodigoProvincia(pro);
                objperBEAN.setCodigoDistrito(dis);
                objperBEAN.setCodigoCalle(cal);
                objperBEAN.setNombre(nom);
                objperBEAN.setApellidoPaterno(apepa);
                objperBEAN.setApellidoMaterno(apema);
                objperBEAN.setSexo(sexo);
                objperBEAN.setFechaNac(fecha);
                objperBEAN.setCorreo(correo);
                objperBEAN.setTelefono(tel);
                objperBEAN.setNumExt(nume);
                objperBEAN.setNumInt(numi);
               
                request.setAttribute("OBJETOPERSONAL", objperBEAN);
                
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                request.setAttribute("LISTADEPARTAMENTOS", lista);
                pagina="/Mantenimiento/Personal/PersonalAdministrativo/FrmMantenimientoModificarPersonalAdministrativo.jsp";
                break;
            }
            case 14:
            {
                
                String strcodper=request.getParameter("codper");
                int codper=Integer.parseInt(strcodper);
                String strdni=request.getParameter("dni");
                int dni=Integer.parseInt(strdni);
                String nom=request.getParameter("txtNom");
                String apepa=request.getParameter("txtApePa");
                String apema=request.getParameter("txtApeMa");
                String cargo=request.getParameter("txtCargo");
                String horai=request.getParameter("txtHoraI");
                String horas=request.getParameter("txtHoraS");
                String sexo=request.getParameter("cbSexo");
                String fecha=request.getParameter("txtFechaNac");
                String correo=request.getParameter("txtCorreo");
                String tel=request.getParameter("txtTel");
                String strdep=request.getParameter("cbDepartamento");
                int dep=Integer.parseInt(strdep);
                String strpro=request.getParameter("cbProvincia");
                int pro=Integer.parseInt(strpro);
                String strdis=request.getParameter("cbDistrito");
                int dis=Integer.parseInt(strdis);
                String strcal=request.getParameter("cbCalle");
                int cal=Integer.parseInt(strcal);
                String strnume=request.getParameter("txtNumE");
                int nume=Integer.parseInt(strnume);
                String strnumi=request.getParameter("txtNumI");
                int numi=Integer.parseInt(strnumi);
                
                PersonalBEAN objperBEAN=new PersonalBEAN();
                objperBEAN.setCodigoPersonal(codper);
                objperBEAN.setDNI(dni);
                objperBEAN.setHoraIngreso(horai);
                objperBEAN.setHoraSalida(horas);
                objperBEAN.setCargo(cargo);
                
                PersonaBEAN objpeBEAN=new PersonaBEAN();
                objpeBEAN.setDNI(dni);
                objpeBEAN.setCodigoDepartamento(dep);
                objpeBEAN.setCodigoProvincia(pro);
                objpeBEAN.setCodigoDistrito(dis);
                objpeBEAN.setCodigoCalle(cal);
                objpeBEAN.setNombre(nom);
                objpeBEAN.setApellidoPaterno(apepa);
                objpeBEAN.setApellidoMaterno(apema);
                objpeBEAN.setSexo(sexo);
                objpeBEAN.setFechaNac(fecha);
                objpeBEAN.setCorreo(correo);
                objpeBEAN.setTelefono(tel);
                objpeBEAN.setNumExt(nume);
                objpeBEAN.setNumInt(numi);
                
                PersonalDAO objperDAO=new PersonalDAO();
                PersonaDAO objpeDAO=new PersonaDAO();
                
                int j=objpeDAO.ModificarPersona(objpeBEAN);    
                int i=objperDAO.ModificarPersonal(objperBEAN);
                if(i==0)
                {
                    request.setAttribute("MENSAJE", "NO SE HA ACTUALIZADO EL REGISTRO");
                } 
                else
                {
                    request.setAttribute("MENSAJE", "SE HA ACTUALIZADO EL REGISTRO CORRECTAMENTE");
                }
                
                PersonalDAO perdao=new PersonalDAO();
                PersonalBEAN obj=perdao.listarObjetoPersonal(objperBEAN);
                request.setAttribute("OBJETOPERSONAL", obj);
                //
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                request.setAttribute("LISTADEPARTAMENTOS", lista);
                pagina="/Mantenimiento/Personal/PersonalAdministrativo/FrmMantenimientoModificarPersonalAdministrativo.jsp";
                break;
            }
            case 15:
            {
                String strcodpersonal=request.getParameter("codper");
                int codper=Integer.parseInt(strcodpersonal);
                
                PersonalBEAN objperBEAN=new PersonalBEAN();
                objperBEAN.setCodigoPersonal(codper);
                PersonalDAO objperDAO=new PersonalDAO();
                objperDAO.EliminarPersonal(objperBEAN);
                request.setAttribute("MENSAJE", "SE HA ELIMINADO EL REGISTRO CORRECTAMENTE");
                
                String strdni=request.getParameter("dni");
                int dni=Integer.parseInt(strdni);
                PersonalBEAN objper=new PersonalBEAN();
                objper.setDNI(dni);
                PersonalDAO perdao=new PersonalDAO();
                int cont=perdao.ConsultarCargos(objper);
                
                if(cont==0)
                {
                    UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                    objusuBEAN.setDNI(dni);
                    UsuarioDAO objusuDAO=new UsuarioDAO();
                    objusuDAO.EliminarUsuarioXDNI(objusuBEAN);
                }
                
                
                ArrayList<PersonalBEAN> lista=null;
                PersonalDAO objperdao=new PersonalDAO();
                lista=objperdao.listarPersonalMantenimiento(); 
                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                
                pagina="/Mantenimiento/Personal/PersonalAdministrativo/FrmMantenimientoPersonalAdministrativo.jsp";
                break;
            }
        }
        
        getServletContext().getRequestDispatcher(pagina).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
