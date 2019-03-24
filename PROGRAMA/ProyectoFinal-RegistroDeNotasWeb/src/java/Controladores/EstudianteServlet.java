
package Controladores;

import BEAN.AulaBEAN;
import BEAN.CalificacionBEAN;
import BEAN.CicloBEAN;
import BEAN.DepartamentoBEAN;
import BEAN.DocenteBEAN;
import BEAN.EstudianteBEAN;
import BEAN.MateriaBEAN;
import BEAN.NivelBEAN;
import BEAN.PersonaBEAN;
import BEAN.UsuarioBEAN;
import DAO.AulaDAO;
import DAO.CalificacionDAO;
import DAO.CicloDAO;
import DAO.DepartamentoDAO;
import DAO.DocenteDAO;
import DAO.EstudianteDAO;
import DAO.MateriaDAO;
import DAO.NivelDAO;
import DAO.PersonaDAO;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EstudianteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cadop=request.getParameter("op");
        int op=Integer.parseInt(cadop);
        String pagina="";
        
        switch(op)
        {
            case 1:
            {
               String usu=request.getParameter("txtUsu");
               String pas=request.getParameter("txtPas");
               
               UsuarioBEAN objusuBEAN=new UsuarioBEAN();
               objusuBEAN.setNombre(usu);
               objusuBEAN.setContraseña(pas);
               objusuBEAN.setTipo("Alumno");
               
               UsuarioDAO objusuDAO=new UsuarioDAO();
               int cant=objusuDAO.ConfirmacionCuenta(objusuBEAN);
               
               String codigousu=objusuDAO.ConsultarCodigoUsuario(objusuBEAN);
               int codusu=Integer.parseInt(codigousu);
               
               if(cant==0)
               {
                   request.setAttribute("MENSAJE", "El usuario y/o contraseña son incorrectos");
                   pagina="/Seguridad/Estudiante/FrmEstudianteLogin.jsp";
               }
               else
               {
                   UsuarioBEAN usuario=new UsuarioBEAN();
                   usuario.setNombre(usu);
                   usuario.setContraseña(pas);
                   usuario.setCodigoUsuario(codusu);
                   HttpSession misesion=request.getSession();
                   misesion.setAttribute("DATOSUSUARIO", usuario);
                   pagina="/Seguridad/Estudiante/FrmEstudiantePrincipal.jsp"; 
               }
               
               break; 
            }
            case 2:
            {
                pagina="/Seguridad/Estudiante/FrmConfirmarCodigoEsdtudiante.jsp";
                break;
            }
            case 3:
            {
                
                String strcodigo=request.getParameter("txtCod");
                int codigo=Integer.parseInt(strcodigo);
                
                EstudianteBEAN objetoBEAN=new EstudianteBEAN();
                objetoBEAN.setCodigoEstudiante(codigo);
                
                EstudianteDAO objetoDAO=new EstudianteDAO();
                int cantidad=objetoDAO.Consulta(objetoBEAN);
                
                if(cantidad==0)
                {
                    request.setAttribute("MENSAJE", "El código ingresado no es correcto");
                    pagina="/Seguridad/Estudiante/FrmConfirmarCodigoEsdtudiante.jsp";
                }
                else
                {
                    request.setAttribute("CODIGOESTUDIANTE", strcodigo);
                    pagina="/Seguridad/Estudiante/FrmEstudianteRegistrar.jsp";
                }

                break;
            }
            case 4:
            {
               HttpSession misesion=request.getSession();
               misesion.invalidate();
               pagina="/Seguridad/Estudiante/FrmEstudianteLogin.jsp";
               break;
            }
            case 5:
            {
               String strcodest=request.getParameter("codest");
               int codest=Integer.parseInt(strcodest);
               EstudianteBEAN objestBEAN=new EstudianteBEAN();
               objestBEAN.setCodigoEstudiante(codest);
               
               EstudianteDAO objestDAO=new EstudianteDAO();
               int dni=objestDAO.CapturarDNI(objestBEAN);               
               String usu=request.getParameter("txtUsu");
               String pas=request.getParameter("txtPas");
               String tipo="Alumno";

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
               
               request.setAttribute("CODIGOESTUDIANTE", strcodest);
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

               pagina="/Seguridad/Estudiante/FrmEstudianteRegistrar.jsp";
               break; 
            }
            case 6:
            {
               HttpSession misesion=request.getSession();
               misesion.invalidate();
               pagina="/index.jsp";
               break; 
            }
            case 7:
            {
                pagina="/Configuracion/Estudiante/FrmCambiarContraseñaEstudiante.jsp";
                break;
            }
            case 8:
            {
                String strcodusu=request.getParameter("codusuario");
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN= new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                
                ArrayList<UsuarioBEAN> listaUsuario;
                UsuarioDAO objusuDAO=new UsuarioDAO();
                listaUsuario=objusuDAO.listarUsuario(objusuBEAN);
                
                request.setAttribute("LISTAUSUARIO", listaUsuario);
                pagina="/Configuracion/Estudiante/FrmActualizarInformacionEstudiante.jsp";
                break;
            }
            //FALTA
            case 9:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                EstudianteBEAN objestBEAN=new EstudianteBEAN();
                objestBEAN.setDNI(dni);
                EstudianteDAO objestDAO=new EstudianteDAO();
                int codest=objestDAO.CapturarCodigo(objestBEAN);
                
                EstudianteBEAN objestuBEAN=new EstudianteBEAN();
                objestuBEAN.setCodigoEstudiante(codest);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaestmat;
                listaestmat=objaulaDAO.listarMateriaEstudiante(objestuBEAN);
                
                request.setAttribute("LISTAMATERIAS", listaestmat);
                
                String strcodmat=request.getParameter("cboMateria");
                request.setAttribute("CODIGOMATERIA", strcodmat);
                pagina="/Visualizar/Estudiante/FrmCalificacionesEstudiante.jsp";
                break;
            }
            case 10:
            {
                String strcodusu=request.getParameter("codusuario");
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN= new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                
                ArrayList<UsuarioBEAN> listaUsuario;
                UsuarioDAO objusuDAO=new UsuarioDAO();
                listaUsuario=objusuDAO.listarUsuario(objusuBEAN);
                
                request.setAttribute("LISTAUSUARIO", listaUsuario);
                
                
                pagina="/Visualizar/Estudiante/FrmPerfilEstudiante.jsp";
                break;
            }
            case 11:
            {
               
               pagina="/Seguridad/Estudiante/FrmEstudiantePrincipal.jsp";
               break;
            }
            case 12:
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
               
                
               pagina="/Configuracion/Estudiante/FrmCambiarContraseñaEstudiante.jsp";
               break;
            }
            case 13:
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
                
                pagina="/Configuracion/Estudiante/FrmActualizarInformacionEstudiante.jsp";
                break;
            }
            //NUEVO
            //NUEVO
            //NUEVO
            //NUEVO
            case 14:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                EstudianteBEAN objestBEAN=new EstudianteBEAN();
                objestBEAN.setDNI(dni);
                EstudianteDAO objestDAO=new EstudianteDAO();
                int codest=objestDAO.CapturarCodigo(objestBEAN);
                
                EstudianteBEAN objestuBEAN=new EstudianteBEAN();
                objestuBEAN.setCodigoEstudiante(codest);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaestmat;
                listaestmat=objaulaDAO.listarMateriaEstudiante(objestuBEAN);
                
                request.setAttribute("LISTAMATERIAS", listaestmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                EstudianteBEAN objestudBEAN=new EstudianteBEAN();
                objestudBEAN.setCodigoEstudiante(codest);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaaluniv;
                listaaluniv=objaulDAO.listarNivelEstudiante(objmatBEAN, objestudBEAN);
                
                request.setAttribute("LISTANIVELES", listaaluniv);
                
                request.setAttribute("CODIGOMATERIA", strcodmat);
                
                pagina="/Visualizar/Estudiante/FrmCalificacionesEstudiante.jsp";
                break;
            }
            //NUEVO
            //NUEVO
            //NUEVO
            //NUEVO
            case 15:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                EstudianteBEAN objestBEAN=new EstudianteBEAN();
                objestBEAN.setDNI(dni);
                EstudianteDAO objestDAO=new EstudianteDAO();
                int codest=objestDAO.CapturarCodigo(objestBEAN);
                
                EstudianteBEAN objestuBEAN=new EstudianteBEAN();
                objestuBEAN.setCodigoEstudiante(codest);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaestmat;
                listaestmat=objaulaDAO.listarMateriaEstudiante(objestuBEAN);
                
                request.setAttribute("LISTAMATERIAS", listaestmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                EstudianteBEAN objestudBEAN=new EstudianteBEAN();
                objestudBEAN.setCodigoEstudiante(codest);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaaluniv;
                listaaluniv=objaulDAO.listarNivelEstudiante(objmatBEAN, objestudBEAN);
                
                request.setAttribute("LISTANIVELES", listaaluniv);
                
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                NivelBEAN objnivBEAN=new NivelBEAN();
                objnivBEAN.setCodigoNivel(codniv);
                EstudianteBEAN objestudiBEAN=new EstudianteBEAN();
                objestudiBEAN.setCodigoEstudiante(codest);
                MateriaBEAN objmateBEAN=new MateriaBEAN();
                objmateBEAN.setCodigoMateria(codmat);
                AulaDAO objauDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaalucic;
                listaalucic=objauDAO.listarCicloEstudiante(objnivBEAN, objestudiBEAN,objmateBEAN);
                
                request.setAttribute("LISTACICLOS", listaalucic);
                
                String strcodcic=request.getParameter("cboCiclo");
                request.setAttribute("CODIGOCICLO", strcodcic);
                request.setAttribute("CODIGOMATERIA", strcodmat);
                request.setAttribute("CODIGONIVEL", strcodniv);
                pagina="/Visualizar/Estudiante/FrmCalificacionesEstudiante.jsp";
                break;
            }
            case 16:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                EstudianteBEAN objestBEAN=new EstudianteBEAN();
                objestBEAN.setDNI(dni);
                EstudianteDAO objestDAO=new EstudianteDAO();
                int codest=objestDAO.CapturarCodigo(objestBEAN);
                
                EstudianteBEAN objestuBEAN=new EstudianteBEAN();
                objestuBEAN.setCodigoEstudiante(codest);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaestmat;
                listaestmat=objaulaDAO.listarMateriaEstudiante(objestuBEAN);
                
                request.setAttribute("LISTAMATERIAS", listaestmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                EstudianteBEAN objestudBEAN=new EstudianteBEAN();
                objestudBEAN.setCodigoEstudiante(codest);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaaluniv;
                listaaluniv=objaulDAO.listarNivelEstudiante(objmatBEAN, objestudBEAN);
                
                request.setAttribute("LISTANIVELES", listaaluniv);
                
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                NivelBEAN objnivBEAN=new NivelBEAN();
                objnivBEAN.setCodigoNivel(codniv);
                EstudianteBEAN objestudiBEAN=new EstudianteBEAN();
                objestudiBEAN.setCodigoEstudiante(codest);
                MateriaBEAN objmateBEAN=new MateriaBEAN();
                objmateBEAN.setCodigoMateria(codmat);
                AulaDAO objauDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaalucic;
                listaalucic=objauDAO.listarCicloEstudiante(objnivBEAN, objestudiBEAN,objmateBEAN);
                
                request.setAttribute("LISTACICLOS", listaalucic);
                
                String strcodcic=request.getParameter("cboCiclo");
                int codcic=Integer.parseInt(strcodcic);
                NivelBEAN objnivelBEAN=new NivelBEAN();
                objnivelBEAN.setCodigoNivel(codniv);
                EstudianteBEAN objestudiaBEAN=new EstudianteBEAN();
                objestudiaBEAN.setCodigoEstudiante(codest);
                MateriaBEAN objmateriaBEAN=new MateriaBEAN();
                objmateriaBEAN.setCodigoMateria(codmat);
                CicloBEAN objcicloBEAN=new CicloBEAN();
                objcicloBEAN.setCodigoCiclo(codcic);
                AulaDAO objaulasDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaaula;
                listaaula=objaulasDAO.listarAulaEstudiante(objestudiaBEAN, objmateriaBEAN, objnivelBEAN, objcicloBEAN);
                
                request.setAttribute("LISTAAULAS", listaaula);
                
                String numaula=request.getParameter("cboAula");
                request.setAttribute("NUMEROAULA",numaula );
                request.setAttribute("CODIGOCICLO", strcodcic);
                request.setAttribute("CODIGOMATERIA", strcodmat);
                request.setAttribute("CODIGONIVEL", strcodniv);
                pagina="/Visualizar/Estudiante/FrmCalificacionesEstudiante.jsp";
                break;
            }
            case 17:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                EstudianteBEAN objestBEAN=new EstudianteBEAN();
                objestBEAN.setDNI(dni);
                EstudianteDAO objestDAO=new EstudianteDAO();
                int codest=objestDAO.CapturarCodigo(objestBEAN);
                
                EstudianteBEAN objestuBEAN=new EstudianteBEAN();
                objestuBEAN.setCodigoEstudiante(codest);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaestmat;
                listaestmat=objaulaDAO.listarMateriaEstudiante(objestuBEAN);
                
                request.setAttribute("LISTAMATERIAS", listaestmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                EstudianteBEAN objestudBEAN=new EstudianteBEAN();
                objestudBEAN.setCodigoEstudiante(codest);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaaluniv;
                listaaluniv=objaulDAO.listarNivelEstudiante(objmatBEAN, objestudBEAN);
                
                request.setAttribute("LISTANIVELES", listaaluniv);
                
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                NivelBEAN objnivBEAN=new NivelBEAN();
                objnivBEAN.setCodigoNivel(codniv);
                EstudianteBEAN objestudiBEAN=new EstudianteBEAN();
                objestudiBEAN.setCodigoEstudiante(codest);
                MateriaBEAN objmateBEAN=new MateriaBEAN();
                objmateBEAN.setCodigoMateria(codmat);
                AulaDAO objauDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaalucic;
                listaalucic=objauDAO.listarCicloEstudiante(objnivBEAN, objestudiBEAN,objmateBEAN);
                
                request.setAttribute("LISTACICLOS", listaalucic);
                
                String strcodcic=request.getParameter("cboCiclo");
                int codcic=Integer.parseInt(strcodcic);
                NivelBEAN objnivelBEAN=new NivelBEAN();
                objnivelBEAN.setCodigoNivel(codniv);
                EstudianteBEAN objestudiaBEAN=new EstudianteBEAN();
                objestudiaBEAN.setCodigoEstudiante(codest);
                MateriaBEAN objmateriaBEAN=new MateriaBEAN();
                objmateriaBEAN.setCodigoMateria(codmat);
                CicloBEAN objcicloBEAN=new CicloBEAN();
                objcicloBEAN.setCodigoCiclo(codcic);
                AulaDAO objaulasDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaaula;
                listaaula=objaulasDAO.listarAulaEstudiante(objestudiaBEAN, objmateriaBEAN, objnivelBEAN, objcicloBEAN);
                
                request.setAttribute("LISTAAULAS", listaaula);
                
                String numaula=request.getParameter("cboAula");
                NivelBEAN nivelBEAN=new NivelBEAN();
                nivelBEAN.setCodigoNivel(codniv);
                EstudianteBEAN estudianteBEAN=new EstudianteBEAN();
                estudianteBEAN.setCodigoEstudiante(codest);
                MateriaBEAN materiaBEAN=new MateriaBEAN();
                materiaBEAN.setCodigoMateria(codmat);
                CicloBEAN cicloBEAN=new CicloBEAN();
                cicloBEAN.setCodigoCiclo(codcic);
                AulaBEAN aulaBEAN=new AulaBEAN();
                aulaBEAN.setNumAula(numaula);
                CalificacionDAO objcaliDAO=new CalificacionDAO();
                ArrayList<CalificacionBEAN> listacali;
                listacali=objcaliDAO.listarCalificacionesAulaEstudiante(estudianteBEAN, aulaBEAN, cicloBEAN, nivelBEAN, materiaBEAN);
                
                request.setAttribute("LISTACALIFICACIONES", listacali);
                
                request.setAttribute("NUMEROAULA",numaula );
                request.setAttribute("CODIGOCICLO", strcodcic);
                request.setAttribute("CODIGOMATERIA", strcodmat);
                request.setAttribute("CODIGONIVEL", strcodniv);
                
                
                pagina="/Visualizar/Estudiante/FrmCalificacionesEstudiante.jsp";
                break;
            }
            case 18:
            {
                
                
                MateriaDAO matdao=new MateriaDAO();
                ArrayList<MateriaBEAN> listamat;
                listamat=matdao.listarMaterias();
                request.setAttribute("LISTAMATERIAS", listamat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatbean=new MateriaBEAN();
                objmatbean.setCodigoMateria(codmat);
                NivelDAO nivdao=new NivelDAO();
                ArrayList<NivelBEAN> listaniv;
                listaniv=nivdao.listarNiveles(objmatbean);
                request.setAttribute("LISTANIVELES", listaniv);
                
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                MateriaBEAN mate=new MateriaBEAN();
                mate.setCodigoMateria(codmat);
                NivelBEAN niv=new NivelBEAN();
                niv.setCodigoNivel(codniv);
                CicloDAO cicdao=new CicloDAO();
                ArrayList<CicloBEAN> listacic;
                listacic=cicdao.listarNiveles(mate, niv);
                request.setAttribute("LISTACICLOS", listacic);
                
                String strcodcic=request.getParameter("cboCiclo");
                int codcic=Integer.parseInt(strcodcic);
                MateriaBEAN materia=new MateriaBEAN();
                materia.setCodigoMateria(codmat);
                NivelBEAN nivel=new NivelBEAN();
                nivel.setCodigoNivel(codniv);
                CicloBEAN ciclo=new CicloBEAN();
                ciclo.setCodigoCiclo(codcic);
                AulaDAO auladao=new AulaDAO();
                ArrayList<AulaBEAN> listaaula;
                listaaula=auladao.listarAulas(materia, nivel, ciclo);
                request.setAttribute("LISTAAULAS", listaaula);
                
                String numaula=request.getParameter("cboAula");
                MateriaBEAN objmateria=new MateriaBEAN();
                objmateria.setCodigoMateria(codmat);
                NivelBEAN objnivel=new NivelBEAN();
                objnivel.setCodigoNivel(codniv);
                CicloBEAN objciclo=new CicloBEAN();
                objciclo.setCodigoCiclo(codcic);
                AulaBEAN objaula=new AulaBEAN();
                objaula.setNumAula(numaula);
                DocenteDAO docdao=new DocenteDAO();
                ArrayList<DocenteBEAN> listadoc;
                listadoc=docdao.listarDocentes(objmateria, objnivel, objciclo, objaula);
                request.setAttribute("LISTADOCENTES", listadoc);
                
                String strcoddocente=request.getParameter("cboDocente");
                int coddoc=Integer.parseInt(strcoddocente);
                MateriaBEAN objmateriabean=new MateriaBEAN();
                objmateriabean.setCodigoMateria(codmat);
                NivelBEAN objnivelbean=new NivelBEAN();
                objnivelbean.setCodigoNivel(codniv);
                CicloBEAN objciclobean=new CicloBEAN();
                objciclobean.setCodigoCiclo(codcic);
                AulaBEAN objaulabean=new AulaBEAN();
                objaulabean.setNumAula(numaula);
                DocenteBEAN objdocbean=new DocenteBEAN();
                objdocbean.setCodigoDocente(coddoc);
                AulaDAO objauladao=new AulaDAO();
                ArrayList<AulaBEAN> listamoda;
                listamoda=objauladao.listarModalidades(objmateriabean, objnivelbean, objciclobean, objaulabean, objdocbean);
                request.setAttribute("LISTAMODALIDADES", listamoda);
                
                
                
                request.setAttribute("CODIGOMATERIA",strcodmat);
                
                String moda=request.getParameter("cboModalidad");
                
                MateriaBEAN objemateriabean=new MateriaBEAN();
                objemateriabean.setCodigoMateria(codmat);
                NivelBEAN objenivelbean=new NivelBEAN();
                objenivelbean.setCodigoNivel(codniv);
                CicloBEAN objeciclobean=new CicloBEAN();
                objeciclobean.setCodigoCiclo(codcic);
                AulaBEAN objeaulabean=new AulaBEAN();
                objeaulabean.setNumAula(numaula);
                objeaulabean.setModalidad(moda);
                DocenteBEAN objedocbean=new DocenteBEAN();
                objedocbean.setCodigoDocente(coddoc);
                
                ArrayList<EstudianteBEAN> lista=null;
                EstudianteDAO objaludao=new EstudianteDAO();
                lista=objaludao.listarAlumnosMantenimiento(objemateriabean, objenivelbean, objeciclobean, objeaulabean, objedocbean); 

                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                
                request.setAttribute("MODALIDAD", moda);
                request.setAttribute("CODIGODOCENTE",strcoddocente);
                request.setAttribute("NUMEROAULA",numaula);
                request.setAttribute("CODIGOCICLO",strcodcic);
                request.setAttribute("CODIGONIVEL",strcodniv);
                
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoEstudiante.jsp";
                break;
            }
            case 19:
            {
                
                pagina="/Seguridad/Personal/PersonalAdministrativo/FrmPersonalAdministrativoPrincipal.jsp";
                break;
            }
            case 20:
            {
                
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                String strcodcic=request.getParameter("cboCiclo");
                int codcic=Integer.parseInt(strcodcic);
                String numaula=request.getParameter("cboAula");
                String strcoddocente=request.getParameter("cboDocente");
                int coddoc=Integer.parseInt(strcoddocente);
                String moda=request.getParameter("cboModalidad");
                AulaBEAN objaubean=new AulaBEAN();
                objaubean.setCodigoMateria(codmat);
                objaubean.setCodigoNivel(codniv);
                objaubean.setCodigoCiclo(codcic);
                objaubean.setCodigoDocente(coddoc);
                MateriaDAO matdao=new MateriaDAO();
                MateriaBEAN mat=matdao.capturarNombre(objaubean);
                NivelDAO nivdao=new NivelDAO();
                NivelBEAN niv=nivdao.capturarNombre(objaubean);
                CicloDAO cicdao=new CicloDAO();
                CicloBEAN cic=cicdao.capturarNombre(objaubean);
                DocenteDAO docdao=new DocenteDAO();
                DocenteBEAN doc=docdao.capturarNombre(objaubean);
                AulaBEAN aula=new AulaBEAN();
                aula.setCodigoMateria(codmat);
                aula.setNomMateria(mat.getNombre());
                aula.setCodigoNivel(codniv);
                aula.setNomNivel(niv.getNombre());
                aula.setCodigoCiclo(codcic);
                aula.setNumCiclo(cic.getNumCiclo());
                aula.setNumAula(numaula);
                aula.setCodigoDocente(coddoc);
                aula.setNombreDocente(doc.getNombre());
                aula.setApePaternoDocente(doc.getApellidoPaterno());
                aula.setModalidad(moda);
                request.setAttribute("OBJETOAULA", aula);
                
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos();
                request.setAttribute("LISTADEPARTAMENTOS", lista);
                String strcoddep=request.getParameter("cbDepartamento");
                request.setAttribute("CODIGODEPARTAMENTO",strcoddep);
                
                
                
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoRegistrarEstudiante.jsp";
                break;
            }
            case 21:
            {
                
                MateriaDAO matdao=new MateriaDAO();
                ArrayList<MateriaBEAN> listamat;
                listamat=matdao.listarMaterias();
                request.setAttribute("LISTAMATERIAS", listamat);
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoEstudiante.jsp";
                break;
            }
            case 22:
            {
                
                
                String strcodalu=request.getParameter("codalu");
                int codalu=Integer.parseInt(strcodalu);
                String strdni=request.getParameter("dni");
                int dni=Integer.parseInt(strdni);
                String nom=request.getParameter("nom");
                String apepa=request.getParameter("apepa");
                String apema=request.getParameter("apema");
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
                
                EstudianteBEAN objaluBEAN=new EstudianteBEAN();
                objaluBEAN.setCodigoEstudiante(codalu);
                objaluBEAN.setDNI(dni);
                objaluBEAN.setCodigoDepartamento(dep);
                objaluBEAN.setCodigoProvincia(pro);
                objaluBEAN.setCodigoDistrito(dis);
                objaluBEAN.setCodigoCalle(cal);
                objaluBEAN.setNombre(nom);
                objaluBEAN.setApellidoPaterno(apepa);
                objaluBEAN.setApellidoMaterno(apema);
                objaluBEAN.setSexo(sexo);
                objaluBEAN.setFechaNac(fecha);
                objaluBEAN.setCorreo(correo);
                objaluBEAN.setTelefono(tel);
                objaluBEAN.setNumExt(nume);
                objaluBEAN.setNumInt(numi);
               
                request.setAttribute("OBJETOALUMNO", objaluBEAN);
                
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                request.setAttribute("LISTADEPARTAMENTOS", lista);
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoModificarEstudiante.jsp";
                break;
            }
            case 23:
            {
                
                
                String strcodalu=request.getParameter("codalu");
                int codalu=Integer.parseInt(strcodalu);
                String strdni=request.getParameter("dni");
                int dni=Integer.parseInt(strdni);
                String nom=request.getParameter("txtNom");
                String apepa=request.getParameter("txtApePa");
                String apema=request.getParameter("txtApeMa");
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
                
                PersonaDAO objpeDAO=new PersonaDAO();
                
                int i=objpeDAO.ModificarPersona(objpeBEAN);
                if(i==0)
                {
                    request.setAttribute("MENSAJE", "NO SE HA ACTUALIZADO EL REGISTRO");
                } 
                else
                {
                    request.setAttribute("MENSAJE", "SE HA ACTUALIZADO EL REGISTRO CORRECTAMENTE");
                }
                
                EstudianteBEAN objalubean=new EstudianteBEAN();
                objalubean.setCodigoEstudiante(codalu);
                EstudianteDAO aludao=new EstudianteDAO();
                EstudianteBEAN obj=aludao.listarObjetoAlumno(objalubean);
                request.setAttribute("OBJETOALUMNO", obj);
                //
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                request.setAttribute("LISTADEPARTAMENTOS", lista);
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoModificarEstudiante.jsp";
                break;
            }
            case 24:
            {
                String strcodalumno=request.getParameter("codalu");
                int codalu=Integer.parseInt(strcodalumno);
                
                EstudianteBEAN objaluBEAN=new EstudianteBEAN();
                objaluBEAN.setCodigoEstudiante(codalu);
                EstudianteDAO objaluDAO=new EstudianteDAO();
                objaluDAO.EliminarAlumno(objaluBEAN);
                request.setAttribute("MENSAJE", "SE HA ELIMINADO EL REGISTRO CORRECTAMENTE");
                
                String strdni=request.getParameter("dni");
                int dni=Integer.parseInt(strdni);
                EstudianteBEAN objalu=new EstudianteBEAN();
                objalu.setDNI(dni);
                EstudianteDAO aludao=new EstudianteDAO();
                int cont=aludao.ConsultarCursosMatriculados(objalu);
                
                if(cont==0)
                {
                    UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                    objusuBEAN.setDNI(dni);
                    UsuarioDAO objusuDAO=new UsuarioDAO();
                    objusuDAO.EliminarUsuarioXDNI(objusuBEAN);
                }
                
                //
                
                
                MateriaDAO matdao=new MateriaDAO();
                ArrayList<MateriaBEAN> listamat;
                listamat=matdao.listarMaterias();
                request.setAttribute("LISTAMATERIAS", listamat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatbean=new MateriaBEAN();
                objmatbean.setCodigoMateria(codmat);
                NivelDAO nivdao=new NivelDAO();
                ArrayList<NivelBEAN> listaniv;
                listaniv=nivdao.listarNiveles(objmatbean);
                request.setAttribute("LISTANIVELES", listaniv);
                
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                MateriaBEAN mate=new MateriaBEAN();
                mate.setCodigoMateria(codmat);
                NivelBEAN niv=new NivelBEAN();
                niv.setCodigoNivel(codniv);
                CicloDAO cicdao=new CicloDAO();
                ArrayList<CicloBEAN> listacic;
                listacic=cicdao.listarNiveles(mate, niv);
                request.setAttribute("LISTACICLOS", listacic);
                
                String strcodcic=request.getParameter("cboCiclo");
                int codcic=Integer.parseInt(strcodcic);
                MateriaBEAN materia=new MateriaBEAN();
                materia.setCodigoMateria(codmat);
                NivelBEAN nivel=new NivelBEAN();
                nivel.setCodigoNivel(codniv);
                CicloBEAN ciclo=new CicloBEAN();
                ciclo.setCodigoCiclo(codcic);
                AulaDAO auladao=new AulaDAO();
                ArrayList<AulaBEAN> listaaula;
                listaaula=auladao.listarAulas(materia, nivel, ciclo);
                request.setAttribute("LISTAAULAS", listaaula);
                
                String numaula=request.getParameter("cboAula");
                MateriaBEAN objmateria=new MateriaBEAN();
                objmateria.setCodigoMateria(codmat);
                NivelBEAN objnivel=new NivelBEAN();
                objnivel.setCodigoNivel(codniv);
                CicloBEAN objciclo=new CicloBEAN();
                objciclo.setCodigoCiclo(codcic);
                AulaBEAN objaula=new AulaBEAN();
                objaula.setNumAula(numaula);
                DocenteDAO docdao=new DocenteDAO();
                ArrayList<DocenteBEAN> listadoc;
                listadoc=docdao.listarDocentes(objmateria, objnivel, objciclo, objaula);
                request.setAttribute("LISTADOCENTES", listadoc);
                
                String strcoddocente=request.getParameter("cboDocente");
                int coddoc=Integer.parseInt(strcoddocente);
                MateriaBEAN objmateriabean=new MateriaBEAN();
                objmateriabean.setCodigoMateria(codmat);
                NivelBEAN objnivelbean=new NivelBEAN();
                objnivelbean.setCodigoNivel(codniv);
                CicloBEAN objciclobean=new CicloBEAN();
                objciclobean.setCodigoCiclo(codcic);
                AulaBEAN objaulabean=new AulaBEAN();
                objaulabean.setNumAula(numaula);
                DocenteBEAN objdocbean=new DocenteBEAN();
                objdocbean.setCodigoDocente(coddoc);
                AulaDAO objauladao=new AulaDAO();
                ArrayList<AulaBEAN> listamoda;
                listamoda=objauladao.listarModalidades(objmateriabean, objnivelbean, objciclobean, objaulabean, objdocbean);
                request.setAttribute("LISTAMODALIDADES", listamoda);
                
                
                
                request.setAttribute("CODIGOMATERIA",strcodmat);
                
                String moda=request.getParameter("cboModalidad");
                
                MateriaBEAN objemateriabean=new MateriaBEAN();
                objemateriabean.setCodigoMateria(codmat);
                NivelBEAN objenivelbean=new NivelBEAN();
                objenivelbean.setCodigoNivel(codniv);
                CicloBEAN objeciclobean=new CicloBEAN();
                objeciclobean.setCodigoCiclo(codcic);
                AulaBEAN objeaulabean=new AulaBEAN();
                objeaulabean.setNumAula(numaula);
                objeaulabean.setModalidad(moda);
                DocenteBEAN objedocbean=new DocenteBEAN();
                objedocbean.setCodigoDocente(coddoc);
                
                ArrayList<EstudianteBEAN> lista=null;
                EstudianteDAO objaludao=new EstudianteDAO();
                lista=objaludao.listarAlumnosMantenimiento(objemateriabean, objenivelbean, objeciclobean, objeaulabean, objedocbean); 

                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                
                request.setAttribute("MODALIDAD", moda);
                request.setAttribute("CODIGODOCENTE",strcoddocente);
                request.setAttribute("NUMEROAULA",numaula);
                request.setAttribute("CODIGOCICLO",strcodcic);
                request.setAttribute("CODIGONIVEL",strcodniv);
                
                
                
                //
                
                
                
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoEstudiante.jsp";
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
