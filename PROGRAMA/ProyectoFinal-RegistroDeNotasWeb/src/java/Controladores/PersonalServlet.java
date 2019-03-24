
package Controladores;

import BEAN.DocenteBEAN;
import BEAN.PersonalBEAN;
import BEAN.UsuarioBEAN;
import DAO.DocenteDAO;
import DAO.PersonalDAO;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PersonalServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cadop=request.getParameter("op");
        int op=Integer.parseInt(cadop);
        String pagina="";
        
        switch(op)
        {
            case 1:
            {
                String tipo=request.getParameter("cbTipo");
                String usu=request.getParameter("txtUsu");
                String pas=request.getParameter("txtPas");

                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setNombre(usu);
                objusuBEAN.setContraseña(pas);
                objusuBEAN.setTipo(tipo);
               
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int cant=objusuDAO.ConfirmacionCuenta(objusuBEAN);
                String codigousu=objusuDAO.ConsultarCodigoUsuario(objusuBEAN);
                int codusu=Integer.parseInt(codigousu);
                if(cant==0)
                {
                    request.setAttribute("MENSAJE", "El usuario y/o contraseña son incorrectos");
                    pagina="/Seguridad/Personal/FrmPersonalLogin.jsp";
                }
                else
                {
                    UsuarioBEAN usuario=new UsuarioBEAN();
                    usuario.setNombre(usu);
                    usuario.setContraseña(pas);
                    usuario.setCodigoUsuario(codusu);
                    HttpSession misesion=request.getSession();
                    misesion.setAttribute("DATOSUSUARIO", usuario);
                    if(tipo.equals("Docente"))
                    {
                        pagina="/Seguridad/Personal/Docente/FrmDocentePrincipal.jsp";
                    }
                    else
                    {
                        pagina="/Seguridad/Personal/PersonalAdministrativo/FrmPersonalAdministrativoPrincipal.jsp";
                    } 
                }
               
               break; 
            }
            case 2:
            {
               pagina="/Seguridad/Personal/FrmPersonalLogin.jsp";
               break;
            }
            case 3:
            {
               pagina="/Seguridad/Personal/FrmConfirmarCodigoPersonal.jsp";
               break;
            }
            case 4:
            {
                String strcodigo=request.getParameter("txtCod");
                int codigo=Integer.parseInt(strcodigo);
                String tipo=request.getParameter("cbTipo");
                int cantidad;
                
                if(tipo.equals("Docente"))
                {
                    DocenteBEAN objdocBEAN=new DocenteBEAN();
                    objdocBEAN.setCodigoDocente(codigo);
                   
                    DocenteDAO objdocDAO=new DocenteDAO();
                    cantidad=objdocDAO.Consulta(objdocBEAN);
                   
                }
                else
                {
                    PersonalBEAN ObjperBEAN=new PersonalBEAN();
                    ObjperBEAN.setCodigoPersonal(codigo);
                    
                    PersonalDAO objperDAO=new PersonalDAO();
                    cantidad=objperDAO.Consulta(ObjperBEAN);
                    
                }
                
                if(cantidad==0)
                {
                    request.setAttribute("MENSAJE", "El código ingresado no es correcto");
                    pagina="/Seguridad/Personal/FrmConfirmarCodigoPersonal.jsp";
                }
                else
                {
                    request.setAttribute("CODIGOPERSONAL", strcodigo);
                    request.setAttribute("TIPO", tipo);
                    pagina="/Seguridad/Personal/FrmPersonalRegistrar.jsp";
                }
                
                break;
            }
            case 5:
            {
                
                String strcodper=request.getParameter("codper");
                int codper=Integer.parseInt(strcodper);
                
                String tipo=request.getParameter("tipo");
                String usu=request.getParameter("txtUsu");
                String pas=request.getParameter("txtPas");
                int dni;
                
                if(tipo.equals("Docente"))
                {
                    DocenteBEAN objdocBEAN=new DocenteBEAN();
                    objdocBEAN.setCodigoDocente(codper);
                    
                    DocenteDAO objdocDAO=new DocenteDAO();
                    dni=objdocDAO.CapturarDNI(objdocBEAN);
                    
                }
                else
                {
                    PersonalBEAN objperBEAN=new PersonalBEAN();
                    objperBEAN.setCodigoPersonal(codper);
                    
                    PersonalDAO objperDAO=new PersonalDAO();
                    dni=objperDAO.CapturarDNI(objperBEAN);
                }
                               
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int codigo=objusuDAO.capturarCodigoUsuario();
               
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codigo);
                objusuBEAN.setDNI(dni);
                objusuBEAN.setNombre(usu);
                objusuBEAN.setContraseña(pas);
                objusuBEAN.setTipo(tipo);
               
                int usuarioexistencia=objusuDAO.capturarUsuario(objusuBEAN);
                int CantidadCuenta=objusuDAO.VerificarCuenta(objusuBEAN);
               
                request.setAttribute("CODIGOPERSONAL", strcodper);
                request.setAttribute("TIPO", tipo);
                if(usuarioexistencia==0)
                {
                   if(CantidadCuenta==0)
                   {
                   
                        objusuDAO.Insertar(objusuBEAN);
                        request.setAttribute("MENSAJE", "EL USUARIO SE HA REGISTRADO CORRECTAMENTE");
                   }
                   else
                   {
                       request.setAttribute("MENSAJE", "USTED YA TIENE UNA CUENTA");
                   }
                }
                else
                {
                   request.setAttribute("MENSAJE", "EL USUARIO INGRESADO YA EXISTE");
                }

                pagina="/Seguridad/Personal/FrmPersonalRegistrar.jsp";
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
