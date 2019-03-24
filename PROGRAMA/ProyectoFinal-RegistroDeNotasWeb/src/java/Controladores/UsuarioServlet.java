
package Controladores;

import BEAN.DocenteBEAN;
import BEAN.EstudianteBEAN;
import BEAN.PersonalBEAN;
import BEAN.UsuarioBEAN;
import DAO.DocenteDAO;
import DAO.EstudianteDAO;
import DAO.PersonalDAO;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cadop=request.getParameter("op");
        int op=Integer.parseInt(cadop);
        String pagina="";
        
        switch(op)
        {
            
            case 1:
            {
                
                
                UsuarioDAO objusudao=new UsuarioDAO();
                ArrayList<UsuarioBEAN> listatipos;
                listatipos=objusudao.listarTiposUsuario();
                request.setAttribute("LISTATIPO", listatipos);
                
                pagina="/Mantenimiento/Usuario/FrmMantenimientoUsuario.jsp";
                break;
            }
            
            case 2:
            {
                
                UsuarioDAO objusu=new UsuarioDAO();
                ArrayList<UsuarioBEAN> listatipos;
                listatipos=objusu.listarTiposUsuario();
                request.setAttribute("LISTATIPO", listatipos);
                String tipo=request.getParameter("cbTipoUsu");
                request.setAttribute("TIPO", tipo);
                
                ArrayList<UsuarioBEAN> lista=null;
                UsuarioDAO objusudao=new UsuarioDAO();
                if(tipo.equals("Alumno"))
                {
                    lista=objusudao.listarUsuarioMantenimientoAlumno(); 
                    if(lista.size()==0)
                        request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                    else
                        request.setAttribute("LISTA", lista);
                }
                else if(tipo.equals("Docente"))
                {
                    lista=objusudao.listarUsuarioMantenimientoDocente();
                    if(lista.size()==0)
                        request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                    else
                        request.setAttribute("LISTA", lista);
                }
                else if(tipo.equals("Personal Administrativo"))
                {
                    lista=objusudao.listarUsuarioMantenimientoPersonal();
                    if(lista.size()==0)
                        request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                    else
                        request.setAttribute("LISTA", lista);
                }
                
                
                
                pagina="/Mantenimiento/Usuario/FrmMantenimientoUsuario.jsp";
                break;
            }
             
            case 3:
            {
                pagina="/Seguridad/Personal/PersonalAdministrativo/FrmPersonalAdministrativoPrincipal.jsp";
                break;
            }
            
            case 4:
            {
                
                String tipo=request.getParameter("cbTipoUsu");
                request.setAttribute("TIPO", tipo);
                pagina="/Mantenimiento/Usuario/FrmMantenimientoRegistrarUsuario.jsp";
                break;
            }
            
            case 5:
            {
                
                String tipo=request.getParameter("txtTipo");
                request.setAttribute("TIPO", tipo);
                pagina="/Mantenimiento/Usuario/FrmMantenimientoUsuario.jsp";
                break;
            }
            
            case 6:
            {
                
                String strdni=request.getParameter("txtDNI");
                int dni=Integer.parseInt(strdni);
                String nom1=request.getParameter("txtNom1");
                String nom2=request.getParameter("txtNom2");
                String apepa=request.getParameter("txtApePa");
                String apema=request.getParameter("txtApeMa");
                String correo=request.getParameter("txtCorreo");
                String tel=request.getParameter("txtTel");
                String usu=request.getParameter("txtUsu");
                String contra=request.getParameter("txtContra");
                String tipo=request.getParameter("txtTipo");
                String sexo=request.getParameter("cbSexo");
                               
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int codigo=objusuDAO.capturarCodigoUsuario();
               
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codigo);
                objusuBEAN.setDNI(dni);
                objusuBEAN.setNombre(usu);
                objusuBEAN.setContraseña(contra);
                objusuBEAN.setTipo(tipo);
                objusuBEAN.setSexo(sexo);
                objusuBEAN.setTelefono(tel);
                objusuBEAN.setCorreo(correo);
                objusuBEAN.setApellidoMaterno(apema);
                objusuBEAN.setApellidoPaterno(apepa);
                objusuBEAN.setPrimerNombre(nom1);
                objusuBEAN.setSegundoNombre(nom2);
               
                int usuarioexistencia=objusuDAO.capturarUsuario(objusuBEAN);
                int CantidadCuenta=objusuDAO.VerificarCuenta(objusuBEAN);
                boolean VerificacionDocente=false,VerificacionPersonal=false,VerificacionAlumno=false;
                if(tipo.equals("Docente"))
                {
                    DocenteBEAN doc=new DocenteBEAN();
                    doc.setDNI(dni);
                    DocenteDAO docdao=new DocenteDAO();
                    VerificacionDocente=docdao.ConsultaXDNI(doc);
                }
                else if(tipo.equals("Alumno"))
                {
                    EstudianteBEAN est=new EstudianteBEAN();
                    est.setDNI(dni);
                    EstudianteDAO docdao=new EstudianteDAO();
                    VerificacionAlumno=docdao.ConsultaXDNI(est);
                } 
                else
                {
                    PersonalBEAN per=new PersonalBEAN();
                    per.setDNI(dni);
                    PersonalDAO perdao=new PersonalDAO();
                    VerificacionPersonal=perdao.ConsultaXDNI(per);
                }
                
               
                if(usuarioexistencia==0)
                {
                   if(CantidadCuenta==0)
                   {     
                        int i;
                        if(VerificacionAlumno==true || VerificacionDocente==true || VerificacionPersonal==true)
                        {
                            i=objusuDAO.InsertarUsuario(objusuBEAN);
                            request.setAttribute("MENSAJE", "EL USUARIO SE HA REGISTRADO CORRECTAMENTE");
                        }
                        else
                        {
                            request.setAttribute("MENSAJE", "LA PERSONA A REGISTRAR NO FORMA PARTE DE LA INSTITUCIÓN O NO COINCIDE CON EL TIPO DE USUARIO");
                            
                        }
                            
                   }
                   else
                   {
                       request.setAttribute("MENSAJE", "LA PERSONA A REGISTRAR YA TIENE UNA CUENTA");
                   }
                }
                else
                {
                   request.setAttribute("MENSAJE", "EL USUARIO INGRESADO YA EXISTE");
                }
                
                
                String tipousu=request.getParameter("txtTipo");
                request.setAttribute("TIPO", tipousu);

                pagina="/Mantenimiento/Usuario/FrmMantenimientoRegistrarUsuario.jsp";
                break; 
            }
            
            case 7:
            {
                
                String strcodusua=request.getParameter("codusu");
                int codusu=Integer.parseInt(strcodusua);
                String strdni=request.getParameter("dni");
                int dni=Integer.parseInt(strdni);
                String nomusu=request.getParameter("nomusu");
                String cont=request.getParameter("cont");
                String fecha=request.getParameter("fecha");
                String tipo=request.getParameter("tipo");
                String nom1=request.getParameter("nom1");
                String nom2=request.getParameter("nom2");
                String apepa=request.getParameter("apepa");
                String apema=request.getParameter("apema");
                String sexo=request.getParameter("sexo");
                String correo=request.getParameter("correo");
                String tel=request.getParameter("tel");
                
                UsuarioBEAN objusubean=new UsuarioBEAN();
                objusubean.setCodigoUsuario(codusu);
                objusubean.setDNI(dni);
                objusubean.setApellidoMaterno(apema);
                objusubean.setApellidoPaterno(apepa);
                objusubean.setNombre(nomusu);
                objusubean.setContraseña(cont);
                objusubean.setFechaRegistro(fecha);
                objusubean.setTipo(tipo);
                objusubean.setPrimerNombre(nom1);
                objusubean.setSegundoNombre(nom2);
                objusubean.setSexo(sexo);
                objusubean.setCorreo(correo);
                objusubean.setTelefono(tel);
                
                request.setAttribute("OBJETOUSUARIO", objusubean);
                pagina="/Mantenimiento/Usuario/FrmMantenimientoModificarUsuario.jsp";
                break;
            }
           
            case 8:
            {
                
                String strcodusua=request.getParameter("codusu");
                int codusu=Integer.parseInt(strcodusua);
                String strdni=request.getParameter("dni");
                int dni=Integer.parseInt(strdni);
                String nomusu=request.getParameter("txtUsu");
                String cont=request.getParameter("txtContra");
                String fecha=request.getParameter("fecha");
                String tipo=request.getParameter("tipo");
                String nom1=request.getParameter("txtNom1");
                String nom2=request.getParameter("txtNom2");
                String apepa=request.getParameter("txtApePa");
                String apema=request.getParameter("txtApeMa");
                String sexo=request.getParameter("cbSexo");
                String correo=request.getParameter("txtCorreo");
                String tel=request.getParameter("txtTel");
                
                UsuarioBEAN objusubean=new UsuarioBEAN();
                objusubean.setCodigoUsuario(codusu);
                objusubean.setDNI(dni);
                objusubean.setApellidoMaterno(apema);
                objusubean.setApellidoPaterno(apepa);
                objusubean.setNombre(nomusu);
                objusubean.setContraseña(cont);
                objusubean.setFechaRegistro(fecha);
                objusubean.setTipo(tipo);
                objusubean.setPrimerNombre(nom1);
                objusubean.setSegundoNombre(nom2);
                objusubean.setSexo(sexo);
                objusubean.setCorreo(correo);
                objusubean.setTelefono(tel);
                
                UsuarioDAO objusudao=new UsuarioDAO();
                int i=objusudao.ModificarUsuario(objusubean);
                
                if(i==0)
                    request.setAttribute("MENSAJE", "EL USUARIO INGRESADO YA EXISTE");
                else
                    request.setAttribute("MENSAJE", " SE HA MODIFICADO CORRECTAMENTE EL REGISTRO");
                
                UsuarioDAO usudao=new UsuarioDAO();
                UsuarioBEAN obj=usudao.listarObjetoUsuario(objusubean);
                request.setAttribute("OBJETOUSUARIO", obj);
                pagina="/Mantenimiento/Usuario/FrmMantenimientoModificarUsuario.jsp";
                break;
            }
            
            case 9:
            {
                String strcodusuario=request.getParameter("codusu");
                int codusu=Integer.parseInt(strcodusuario);
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                objusuDAO.EliminarUsuario(objusuBEAN);
                request.setAttribute("MENSAJE", "SE HA ELIMINADO EL REGISTRO CORRECTAMENTE");
                        
                
                UsuarioDAO objusu=new UsuarioDAO();
                ArrayList<UsuarioBEAN> listatipos;
                listatipos=objusu.listarTiposUsuario();
                request.setAttribute("LISTATIPO", listatipos);
                String tipo=request.getParameter("cbTipoUsu");
                request.setAttribute("TIPO", tipo);
                
                ArrayList<UsuarioBEAN> lista=null;
                UsuarioDAO objusudao=new UsuarioDAO();
                if(tipo.equals("Alumno"))
                {
                    lista=objusudao.listarUsuarioMantenimientoAlumno();
                    if(lista.size()==0)
                        request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                    else
                        request.setAttribute("LISTA", lista);
                }
                else if(tipo.equals("Docente"))
                {
                    lista=objusudao.listarUsuarioMantenimientoDocente();
                    if(lista.size()==0)
                        request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                    else
                        request.setAttribute("LISTA", lista);
                }
                else if(tipo.equals("Personal Administrativo"))
                {
                    lista=objusudao.listarUsuarioMantenimientoPersonal();
                    if(lista.size()==0)
                        request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                    else
                        request.setAttribute("LISTA", lista);
                }
                
                
                pagina="/Mantenimiento/Usuario/FrmMantenimientoUsuario.jsp";
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
