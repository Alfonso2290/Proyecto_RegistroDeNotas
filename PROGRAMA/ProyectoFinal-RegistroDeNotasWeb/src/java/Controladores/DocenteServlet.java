
package Controladores;

import BEAN.AulaBEAN;
import BEAN.CalificacionBEAN;
import BEAN.CicloBEAN;
import BEAN.DepartamentoBEAN;
import BEAN.DocenteBEAN;
import BEAN.EstudianteBEAN;
import BEAN.MateriaBEAN;
import BEAN.ModuloBEAN;
import BEAN.NivelBEAN;
import BEAN.PersonaBEAN;
import BEAN.UsuarioBEAN;
import DAO.AulaDAO;
import DAO.CalificacionDAO;
import DAO.CicloDAO;
import DAO.DepartamentoDAO;
import DAO.DocenteDAO;
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

public class DocenteServlet extends HttpServlet 
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
                
                pagina="/Configuracion/Personal/Docente/FrmCambiarContraseñaDocente.jsp";
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
                
                pagina="/Configuracion/Personal/Docente/FrmActualizarInformacionDocente.jsp";
                break;
            }
            case 4:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setDNI(dni);
                DocenteDAO objdocDAO=new DocenteDAO();
                int coddoc=objdocDAO.CapturarCodigo(objdocBEAN);
                
                DocenteBEAN objdoceBEAN=new DocenteBEAN();
                objdoceBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocmat;
                listadocmat=objaulaDAO.listarMateriaDocente(objdoceBEAN);
                
                request.setAttribute("LISTAMATERIAS", listadocmat);
                
                String strcodmat=request.getParameter("cboMateria");
                request.setAttribute("CODIGOMATERIA", strcodmat);

                pagina="/Visualizar/Personal/Docente/FrmCalificacionesDocente.jsp";
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
                
               
                pagina="/Visualizar/Personal/Docente/FrmPerfilDocente.jsp";
                break;
            }
            case 6:
            {
               
               pagina="/Seguridad/Personal/Docente/FrmDocentePrincipal.jsp";
               break;
            }
            case 7:
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
               
                
               pagina="/Configuracion/Personal/Docente/FrmCambiarContraseñaDocente.jsp";
               break;
            }
            case 8:
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
                pagina="/Configuracion/Personal/Docente/FrmActualizarInformacionDocente.jsp";
                break;
            }
            case 9:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setDNI(dni);
                DocenteDAO objdocDAO=new DocenteDAO();
                int coddoc=objdocDAO.CapturarCodigo(objdocBEAN);
                
                DocenteBEAN objdoceBEAN=new DocenteBEAN();
                objdoceBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocmat;
                listadocmat=objaulaDAO.listarMateriaDocente(objdoceBEAN);
                
                request.setAttribute("LISTAMATERIAS", listadocmat);
                
                String strcodmat=request.getParameter("cboMateria");
                request.setAttribute("CODIGOMATERIA", strcodmat);
                
                pagina="/Mantenimiento/Personal/Docente/FrmRegistrarNotas.jsp";
                break;
            }
            case 10:
            {
               HttpSession misesion=request.getSession();
               misesion.invalidate();
               pagina="/Seguridad/Personal/FrmPersonalLogin.jsp";
               break;
            }
            case 11:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setDNI(dni);
                DocenteDAO objdocDAO=new DocenteDAO();
                int coddoc=objdocDAO.CapturarCodigo(objdocBEAN);
                
                DocenteBEAN objdoceBEAN=new DocenteBEAN();
                objdoceBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocmat;
                listadocmat=objaulaDAO.listarMateriaDocente(objdoceBEAN);
                
                request.setAttribute("LISTAMATERIAS", listadocmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                DocenteBEAN objdocenBEAN=new DocenteBEAN();
                objdocenBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocniv;
                listadocniv=objaulDAO.listarNivelDocente(objmatBEAN, objdocenBEAN);
                
                request.setAttribute("LISTANIVELES", listadocniv);
                
                request.setAttribute("CODIGOMATERIA", strcodmat);
                
                pagina="/Mantenimiento/Personal/Docente/FrmRegistrarNotas.jsp";
                break;
            }
            case 12:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setDNI(dni);
                DocenteDAO objdocDAO=new DocenteDAO();
                int coddoc=objdocDAO.CapturarCodigo(objdocBEAN);
                
                DocenteBEAN objdoceBEAN=new DocenteBEAN();
                objdoceBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocmat;
                listadocmat=objaulaDAO.listarMateriaDocente(objdoceBEAN);
                
                request.setAttribute("LISTAMATERIAS", listadocmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                DocenteBEAN objdocenBEAN=new DocenteBEAN();
                objdocenBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocniv;
                listadocniv=objaulDAO.listarNivelDocente(objmatBEAN, objdocenBEAN);
                
                request.setAttribute("LISTANIVELES", listadocniv);
                
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                NivelBEAN objnivBEAN=new NivelBEAN();
                objnivBEAN.setCodigoNivel(codniv);
                DocenteBEAN objdocenteBEAN=new DocenteBEAN();
                objdocenteBEAN.setCodigoDocente(coddoc);
                MateriaBEAN objmateBEAN=new MateriaBEAN();
                objmateBEAN.setCodigoMateria(codmat);
                AulaDAO objauDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadoccic;
                listadoccic=objauDAO.listarCicloDocente(objnivBEAN, objdocenteBEAN,objmateBEAN);
                
                request.setAttribute("LISTACICLOS", listadoccic);
                
                String strcodcic=request.getParameter("cboCiclo");
                request.setAttribute("CODIGOCICLO", strcodcic);
                request.setAttribute("CODIGOMATERIA", strcodmat);
                request.setAttribute("CODIGONIVEL", strcodniv);
                pagina="/Mantenimiento/Personal/Docente/FrmRegistrarNotas.jsp";
                break;
            }
            case 13:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setDNI(dni);
                DocenteDAO objdocDAO=new DocenteDAO();
                int coddoc=objdocDAO.CapturarCodigo(objdocBEAN);
                
                DocenteBEAN objdoceBEAN=new DocenteBEAN();
                objdoceBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocmat;
                listadocmat=objaulaDAO.listarMateriaDocente(objdoceBEAN);
                
                request.setAttribute("LISTAMATERIAS", listadocmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                DocenteBEAN objdocenBEAN=new DocenteBEAN();
                objdocenBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocniv;
                listadocniv=objaulDAO.listarNivelDocente(objmatBEAN, objdocenBEAN);
                
                request.setAttribute("LISTANIVELES", listadocniv);
                
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                NivelBEAN objnivBEAN=new NivelBEAN();
                objnivBEAN.setCodigoNivel(codniv);
                DocenteBEAN objdocenteBEAN=new DocenteBEAN();
                objdocenteBEAN.setCodigoDocente(coddoc);
                MateriaBEAN objmateBEAN=new MateriaBEAN();
                objmateBEAN.setCodigoMateria(codmat);
                AulaDAO objauDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadoccic;
                listadoccic=objauDAO.listarCicloDocente(objnivBEAN, objdocenteBEAN,objmateBEAN);
                
                request.setAttribute("LISTACICLOS", listadoccic);
                
                String strcodcic=request.getParameter("cboCiclo");
                int codcic=Integer.parseInt(strcodcic);
                NivelBEAN objnivelBEAN=new NivelBEAN();
                objnivelBEAN.setCodigoNivel(codniv);
                DocenteBEAN objdocentBEAN=new DocenteBEAN();
                objdocentBEAN.setCodigoDocente(coddoc);
                MateriaBEAN objmateriaBEAN=new MateriaBEAN();
                objmateriaBEAN.setCodigoMateria(codmat);
                CicloBEAN objcicloBEAN=new CicloBEAN();
                objcicloBEAN.setCodigoCiclo(codcic);
                AulaDAO objaulasDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaaula;
                listaaula=objaulasDAO.listarAulaDocente(objdocentBEAN, objmateriaBEAN, objnivelBEAN, objcicloBEAN);
                
                request.setAttribute("LISTAAULAS", listaaula);
                
                String numaula=request.getParameter("cboAula");
                request.setAttribute("NUMEROAULA",numaula );
                request.setAttribute("CODIGOCICLO", strcodcic);
                request.setAttribute("CODIGOMATERIA", strcodmat);
                request.setAttribute("CODIGONIVEL", strcodniv);
                pagina="/Mantenimiento/Personal/Docente/FrmRegistrarNotas.jsp";
                break;
            }
            case 14:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setDNI(dni);
                DocenteDAO objdocDAO=new DocenteDAO();
                int coddoc=objdocDAO.CapturarCodigo(objdocBEAN);
                
                DocenteBEAN objdoceBEAN=new DocenteBEAN();
                objdoceBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocmat;
                listadocmat=objaulaDAO.listarMateriaDocente(objdoceBEAN);
                
                request.setAttribute("LISTAMATERIAS", listadocmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                DocenteBEAN objdocenBEAN=new DocenteBEAN();
                objdocenBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocniv;
                listadocniv=objaulDAO.listarNivelDocente(objmatBEAN, objdocenBEAN);
                
                request.setAttribute("LISTANIVELES", listadocniv);
                
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                NivelBEAN objnivBEAN=new NivelBEAN();
                objnivBEAN.setCodigoNivel(codniv);
                DocenteBEAN objdocenteBEAN=new DocenteBEAN();
                objdocenteBEAN.setCodigoDocente(coddoc);
                MateriaBEAN objmateBEAN=new MateriaBEAN();
                objmateBEAN.setCodigoMateria(codmat);
                AulaDAO objauDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadoccic;
                listadoccic=objauDAO.listarCicloDocente(objnivBEAN, objdocenteBEAN,objmateBEAN);
                
                request.setAttribute("LISTACICLOS", listadoccic);
                
                String strcodcic=request.getParameter("cboCiclo");
                int codcic=Integer.parseInt(strcodcic);
                NivelBEAN objnivelBEAN=new NivelBEAN();
                objnivelBEAN.setCodigoNivel(codniv);
                DocenteBEAN objdocentBEAN=new DocenteBEAN();
                objdocentBEAN.setCodigoDocente(coddoc);
                MateriaBEAN objmateriaBEAN=new MateriaBEAN();
                objmateriaBEAN.setCodigoMateria(codmat);
                CicloBEAN objcicloBEAN=new CicloBEAN();
                objcicloBEAN.setCodigoCiclo(codcic);
                AulaDAO objaulasDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaaula;
                listaaula=objaulasDAO.listarAulaDocente(objdocentBEAN, objmateriaBEAN, objnivelBEAN, objcicloBEAN);
                
                request.setAttribute("LISTAAULAS", listaaula);
                
                String numaula=request.getParameter("cboAula");
                NivelBEAN nivelBEAN=new NivelBEAN();
                nivelBEAN.setCodigoNivel(codniv);
                DocenteBEAN docentBEAN=new DocenteBEAN();
                docentBEAN.setCodigoDocente(coddoc);
                MateriaBEAN materiaBEAN=new MateriaBEAN();
                materiaBEAN.setCodigoMateria(codmat);
                CicloBEAN cicloBEAN=new CicloBEAN();
                cicloBEAN.setCodigoCiclo(codcic);
                AulaBEAN aulaBEAN=new AulaBEAN();
                aulaBEAN.setNumAula(numaula);
                CalificacionDAO objcaliDAO=new CalificacionDAO();
                ArrayList<CalificacionBEAN> listacali;
                listacali=objcaliDAO.listarCalificacionesAula(docentBEAN, aulaBEAN, cicloBEAN, nivelBEAN, materiaBEAN);
                
                request.setAttribute("LISTACALIFICACIONES", listacali);
                
                request.setAttribute("NUMEROAULA",numaula );
                request.setAttribute("CODIGOCICLO", strcodcic);
                request.setAttribute("CODIGOMATERIA", strcodmat);
                request.setAttribute("CODIGONIVEL", strcodniv);
                
                
                pagina="/Mantenimiento/Personal/Docente/FrmRegistrarNotas.jsp";
                break;
            }
            case 15:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setDNI(dni);
                DocenteDAO objdocDAO=new DocenteDAO();
                int coddoc=objdocDAO.CapturarCodigo(objdocBEAN);
                
                DocenteBEAN objdoceBEAN=new DocenteBEAN();
                objdoceBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocmat;
                listadocmat=objaulaDAO.listarMateriaDocente(objdoceBEAN);
                
                request.setAttribute("LISTAMATERIAS", listadocmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                DocenteBEAN objdocenBEAN=new DocenteBEAN();
                objdocenBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocniv;
                listadocniv=objaulDAO.listarNivelDocente(objmatBEAN, objdocenBEAN);
                
                request.setAttribute("LISTANIVELES", listadocniv);
                
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                NivelBEAN objnivBEAN=new NivelBEAN();
                objnivBEAN.setCodigoNivel(codniv);
                DocenteBEAN objdocenteBEAN=new DocenteBEAN();
                objdocenteBEAN.setCodigoDocente(coddoc);
                MateriaBEAN objmateBEAN=new MateriaBEAN();
                objmateBEAN.setCodigoMateria(codmat);
                AulaDAO objauDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadoccic;
                listadoccic=objauDAO.listarCicloDocente(objnivBEAN, objdocenteBEAN,objmateBEAN);
                
                request.setAttribute("LISTACICLOS", listadoccic);
                
                String strcodcic=request.getParameter("cboCiclo");
                int codcic=Integer.parseInt(strcodcic);
                NivelBEAN objnivelBEAN=new NivelBEAN();
                objnivelBEAN.setCodigoNivel(codniv);
                DocenteBEAN objdocentBEAN=new DocenteBEAN();
                objdocentBEAN.setCodigoDocente(coddoc);
                MateriaBEAN objmateriaBEAN=new MateriaBEAN();
                objmateriaBEAN.setCodigoMateria(codmat);
                CicloBEAN objcicloBEAN=new CicloBEAN();
                objcicloBEAN.setCodigoCiclo(codcic);
                AulaDAO objaulasDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaaula;
                listaaula=objaulasDAO.listarAulaDocente(objdocentBEAN, objmateriaBEAN, objnivelBEAN, objcicloBEAN);
                
                request.setAttribute("LISTAAULAS", listaaula);
                
                String numaula=request.getParameter("cboAula");
                
                NivelBEAN nivel=new NivelBEAN();
                nivel.setCodigoNivel(codniv);
                DocenteBEAN docente=new DocenteBEAN();
                docente.setCodigoDocente(coddoc);
                MateriaBEAN materia=new MateriaBEAN();
                materia.setCodigoMateria(codmat);
                CicloBEAN ciclo=new CicloBEAN();
                ciclo.setCodigoCiclo(codcic);
                AulaBEAN aula=new AulaBEAN();
                aula.setNumAula(numaula);
                CalificacionDAO caliDAO=new CalificacionDAO();
                String codigoModulo=caliDAO.capturarCodigoModulo(docente, aula, ciclo, nivel, materia);
                ModuloBEAN objmodBEAN=new ModuloBEAN();
                objmodBEAN.setCodigoModulo(codigoModulo);
                
                String cant=request.getParameter("cantidad");
                int n=Integer.parseInt(cant);
                for(int i=1;i<=n;i++)
                {
                    String ValueParcial="txtNParcial" + i;
                    String ValueFinal="txtNFinal" + i;
                    String ValueCodigoAlumno="txtCodigo" + i;
                    String strep=request.getParameter(ValueParcial);
                    String stref=request.getParameter(ValueFinal);

                    CalificacionBEAN caliBEAN=new CalificacionBEAN();
                    
                    if(strep.compareTo("")==0) 
                    {
                       caliBEAN.setStrNParcial(""); 
                    }
                    else if(strep.charAt(0)=='0')
                    {
                        ///////////////////////////////////////////////////
                        if(strep.length()==1)
                            caliBEAN.setStrNParcial(strep);
                        else
                            caliBEAN.setStrNParcial(strep.charAt(1) + "");
                        ///////////////////////////////////////////////////
                    }
                    else
                    {
                       caliBEAN.setStrNParcial(strep); 
                    }
                    
                    if(stref.compareTo("")==0)
                    {
                       caliBEAN.setStrNFinal(""); 
                    }
                    else if(stref.charAt(0)=='0')
                    {
                        ///////////////////////////////////////////////////
                        if(stref.length()==2)
                            caliBEAN.setStrNFinal(stref.charAt(1) + "");
                        else
                           caliBEAN.setStrNFinal(stref); 
                        ///////////////////////////////////////////////////
                    }
                    else
                    {
                       caliBEAN.setStrNFinal(stref);
                    }
                    
                    if(strep.compareTo("")==0 || stref.compareTo("")==0)
                    {
                        caliBEAN.setStrPromFinal("");
                    }
                    else
                    {
                        int ep=Integer.parseInt(strep);
                        int ef=Integer.parseInt(stref);
                        int pf;
                        if((ep + ef)%2!=0)
                            pf=(ep+ef+1)/2;
                        else
                            pf=(ep+ef)/2;
                        caliBEAN.setStrPromFinal(pf + "");
                    }
                    
                    EstudianteBEAN objestBEAN=new EstudianteBEAN();
                    String strcodalu=request.getParameter(ValueCodigoAlumno);
                    int codalu=Integer.parseInt(strcodalu);
                    objestBEAN.setCodigoEstudiante(codalu);
                    
                    CalificacionDAO objetocaliDAO=new CalificacionDAO();
                    objetocaliDAO.ActualizarCalificacion(objestBEAN, caliBEAN, objmodBEAN);
                }
                request.setAttribute("MENSAJE","Se ha registrado las notas con exito");
                
                NivelBEAN nivelBEAN=new NivelBEAN();
                nivelBEAN.setCodigoNivel(codniv);
                DocenteBEAN docentBEAN=new DocenteBEAN();
                docentBEAN.setCodigoDocente(coddoc);
                MateriaBEAN materiaBEAN=new MateriaBEAN();
                materiaBEAN.setCodigoMateria(codmat);
                CicloBEAN cicloBEAN=new CicloBEAN();
                cicloBEAN.setCodigoCiclo(codcic);
                AulaBEAN aulaBEAN=new AulaBEAN();
                aulaBEAN.setNumAula(numaula);
                CalificacionDAO objcaliDAO=new CalificacionDAO();
                ArrayList<CalificacionBEAN> listacali;
                listacali=objcaliDAO.listarCalificacionesAula(docentBEAN, aulaBEAN, cicloBEAN, nivelBEAN, materiaBEAN);
                
                request.setAttribute("LISTACALIFICACIONES", listacali);
                
                request.setAttribute("NUMEROAULA",numaula );
                request.setAttribute("CODIGOCICLO", strcodcic);
                request.setAttribute("CODIGOMATERIA", strcodmat);
                request.setAttribute("CODIGONIVEL", strcodniv);
                
                pagina="/Mantenimiento/Personal/Docente/FrmRegistrarNotas.jsp";
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
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setDNI(dni);
                DocenteDAO objdocDAO=new DocenteDAO();
                int coddoc=objdocDAO.CapturarCodigo(objdocBEAN);
                
                DocenteBEAN objdoceBEAN=new DocenteBEAN();
                objdoceBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocmat;
                listadocmat=objaulaDAO.listarMateriaDocente(objdoceBEAN);
                
                request.setAttribute("LISTAMATERIAS", listadocmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                DocenteBEAN objdocenBEAN=new DocenteBEAN();
                objdocenBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocniv;
                listadocniv=objaulDAO.listarNivelDocente(objmatBEAN, objdocenBEAN);
                
                request.setAttribute("LISTANIVELES", listadocniv);
                
                request.setAttribute("CODIGOMATERIA", strcodmat);
                
                pagina="/Visualizar/Personal/Docente/FrmCalificacionesDocente.jsp";
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
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setDNI(dni);
                DocenteDAO objdocDAO=new DocenteDAO();
                int coddoc=objdocDAO.CapturarCodigo(objdocBEAN);
                
                DocenteBEAN objdoceBEAN=new DocenteBEAN();
                objdoceBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocmat;
                listadocmat=objaulaDAO.listarMateriaDocente(objdoceBEAN);
                
                request.setAttribute("LISTAMATERIAS", listadocmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                DocenteBEAN objdocenBEAN=new DocenteBEAN();
                objdocenBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocniv;
                listadocniv=objaulDAO.listarNivelDocente(objmatBEAN, objdocenBEAN);
                
                request.setAttribute("LISTANIVELES", listadocniv);
                
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                NivelBEAN objnivBEAN=new NivelBEAN();
                objnivBEAN.setCodigoNivel(codniv);
                DocenteBEAN objdocenteBEAN=new DocenteBEAN();
                objdocenteBEAN.setCodigoDocente(coddoc);
                MateriaBEAN objmateBEAN=new MateriaBEAN();
                objmateBEAN.setCodigoMateria(codmat);
                AulaDAO objauDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadoccic;
                listadoccic=objauDAO.listarCicloDocente(objnivBEAN, objdocenteBEAN,objmateBEAN);
                
                request.setAttribute("LISTACICLOS", listadoccic);
                
                String strcodcic=request.getParameter("cboCiclo");
                request.setAttribute("CODIGOCICLO", strcodcic);
                request.setAttribute("CODIGOMATERIA", strcodmat);
                request.setAttribute("CODIGONIVEL", strcodniv);
                pagina="/Visualizar/Personal/Docente/FrmCalificacionesDocente.jsp";
                break;
            }
            
            case 18:
            {
                String strcodusu=request.getParameter("codusuario");
               
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setDNI(dni);
                DocenteDAO objdocDAO=new DocenteDAO();
                int coddoc=objdocDAO.CapturarCodigo(objdocBEAN);
                
                DocenteBEAN objdoceBEAN=new DocenteBEAN();
                objdoceBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocmat;
                listadocmat=objaulaDAO.listarMateriaDocente(objdoceBEAN);
                
                request.setAttribute("LISTAMATERIAS", listadocmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                DocenteBEAN objdocenBEAN=new DocenteBEAN();
                objdocenBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocniv;
                listadocniv=objaulDAO.listarNivelDocente(objmatBEAN, objdocenBEAN);
                
                request.setAttribute("LISTANIVELES", listadocniv);
                
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                NivelBEAN objnivBEAN=new NivelBEAN();
                objnivBEAN.setCodigoNivel(codniv);
                DocenteBEAN objdocenteBEAN=new DocenteBEAN();
                objdocenteBEAN.setCodigoDocente(coddoc);
                MateriaBEAN objmateBEAN=new MateriaBEAN();
                objmateBEAN.setCodigoMateria(codmat);
                AulaDAO objauDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadoccic;
                listadoccic=objauDAO.listarCicloDocente(objnivBEAN, objdocenteBEAN,objmateBEAN);
                
                request.setAttribute("LISTACICLOS", listadoccic);
                
                String strcodcic=request.getParameter("cboCiclo");
                int codcic=Integer.parseInt(strcodcic);
                NivelBEAN objnivelBEAN=new NivelBEAN();
                objnivelBEAN.setCodigoNivel(codniv);
                DocenteBEAN objdocentBEAN=new DocenteBEAN();
                objdocentBEAN.setCodigoDocente(coddoc);
                MateriaBEAN objmateriaBEAN=new MateriaBEAN();
                objmateriaBEAN.setCodigoMateria(codmat);
                CicloBEAN objcicloBEAN=new CicloBEAN();
                objcicloBEAN.setCodigoCiclo(codcic);
                AulaDAO objaulasDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaaula;
                listaaula=objaulasDAO.listarAulaDocente(objdocentBEAN, objmateriaBEAN, objnivelBEAN, objcicloBEAN);
                
                request.setAttribute("LISTAAULAS", listaaula);
                
                String numaula=request.getParameter("cboAula");
                request.setAttribute("NUMEROAULA",numaula );
                request.setAttribute("CODIGOCICLO", strcodcic);
                request.setAttribute("CODIGOMATERIA", strcodmat);
                request.setAttribute("CODIGONIVEL", strcodniv);
                pagina="/Visualizar/Personal/Docente/FrmCalificacionesDocente.jsp";
                break;
            }
            
            case 19:
            {
                String strcodusu=request.getParameter("codusuario");
                
                int codusu=Integer.parseInt(strcodusu);
                
                UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                objusuBEAN.setCodigoUsuario(codusu);
                UsuarioDAO objusuDAO=new UsuarioDAO();
                int dni=objusuDAO.capturarDNI(objusuBEAN);
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setDNI(dni);
                DocenteDAO objdocDAO=new DocenteDAO();
                int coddoc=objdocDAO.CapturarCodigo(objdocBEAN);
                
                DocenteBEAN objdoceBEAN=new DocenteBEAN();
                objdoceBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulaDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocmat;
                listadocmat=objaulaDAO.listarMateriaDocente(objdoceBEAN);
                
                request.setAttribute("LISTAMATERIAS", listadocmat);
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                MateriaBEAN objmatBEAN=new MateriaBEAN();
                objmatBEAN.setCodigoMateria(codmat);
                DocenteBEAN objdocenBEAN=new DocenteBEAN();
                objdocenBEAN.setCodigoDocente(coddoc);
                AulaDAO objaulDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadocniv;
                listadocniv=objaulDAO.listarNivelDocente(objmatBEAN, objdocenBEAN);
                
                request.setAttribute("LISTANIVELES", listadocniv);
                
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                NivelBEAN objnivBEAN=new NivelBEAN();
                objnivBEAN.setCodigoNivel(codniv);
                DocenteBEAN objdocenteBEAN=new DocenteBEAN();
                objdocenteBEAN.setCodigoDocente(coddoc);
                MateriaBEAN objmateBEAN=new MateriaBEAN();
                objmateBEAN.setCodigoMateria(codmat);
                AulaDAO objauDAO=new AulaDAO();
                ArrayList<AulaBEAN> listadoccic;
                listadoccic=objauDAO.listarCicloDocente(objnivBEAN, objdocenteBEAN,objmateBEAN);
                
                request.setAttribute("LISTACICLOS", listadoccic);
                
                String strcodcic=request.getParameter("cboCiclo");
                int codcic=Integer.parseInt(strcodcic);
                NivelBEAN objnivelBEAN=new NivelBEAN();
                objnivelBEAN.setCodigoNivel(codniv);
                DocenteBEAN objdocentBEAN=new DocenteBEAN();
                objdocentBEAN.setCodigoDocente(coddoc);
                MateriaBEAN objmateriaBEAN=new MateriaBEAN();
                objmateriaBEAN.setCodigoMateria(codmat);
                CicloBEAN objcicloBEAN=new CicloBEAN();
                objcicloBEAN.setCodigoCiclo(codcic);
                AulaDAO objaulasDAO=new AulaDAO();
                ArrayList<AulaBEAN> listaaula;
                listaaula=objaulasDAO.listarAulaDocente(objdocentBEAN, objmateriaBEAN, objnivelBEAN, objcicloBEAN);
                
                request.setAttribute("LISTAAULAS", listaaula);
                
                String numaula=request.getParameter("cboAula");
                NivelBEAN nivelBEAN=new NivelBEAN();
                nivelBEAN.setCodigoNivel(codniv);
                DocenteBEAN docentBEAN=new DocenteBEAN();
                docentBEAN.setCodigoDocente(coddoc);
                MateriaBEAN materiaBEAN=new MateriaBEAN();
                materiaBEAN.setCodigoMateria(codmat);
                CicloBEAN cicloBEAN=new CicloBEAN();
                cicloBEAN.setCodigoCiclo(codcic);
                AulaBEAN aulaBEAN=new AulaBEAN();
                aulaBEAN.setNumAula(numaula);
                CalificacionDAO objcaliDAO=new CalificacionDAO();
                ArrayList<CalificacionBEAN> listacali;
                listacali=objcaliDAO.listarCalificacionesAula(docentBEAN, aulaBEAN, cicloBEAN, nivelBEAN, materiaBEAN);
                
                request.setAttribute("LISTACALIFICACIONES", listacali);
                
                request.setAttribute("NUMEROAULA",numaula );
                request.setAttribute("CODIGOCICLO", strcodcic);
                request.setAttribute("CODIGOMATERIA", strcodmat);
                request.setAttribute("CODIGONIVEL", strcodniv);
                
                
                pagina="/Visualizar/Personal/Docente/FrmCalificacionesDocente.jsp";
                break;
            }
            case 20:
            {
                
                
                ArrayList<DocenteBEAN> lista=null;
                DocenteDAO objdocdao=new DocenteDAO();
                lista=objdocdao.listarDocenteMantenimiento(); 

                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                pagina="/Mantenimiento/Personal/Docente/FrmMantenimientoDocente.jsp";
                break;
            }
            //CASO DE FILTRO DE AULA EN COMBOBOX
            case 21:
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
                
                request.setAttribute("NUMEROAULA",numaula);
                request.setAttribute("CODIGOCICLO",strcodcic);
                request.setAttribute("CODIGONIVEL",strcodniv);
                request.setAttribute("CODIGOMATERIA",strcodmat);
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoEstudiante.jsp";
                break;
            }
            case 22:
            {
             
               pagina="/Seguridad/Personal/PersonalAdministrativo/FrmPersonalAdministrativoPrincipal.jsp";
               break;
            }
            case 23:
            {
               
                ArrayList<DocenteBEAN> lista=null;
                DocenteDAO objdocdao=new DocenteDAO();
                lista=objdocdao.listarDocenteMantenimiento(); 

                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                pagina="/Mantenimiento/Personal/Docente/FrmMantenimientoDocente.jsp";
                break;
            }
            case 24:
            {
                String strdni=request.getParameter("txtDNI");
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
                               
                DocenteBEAN objBEAN=new DocenteBEAN();
                objBEAN.setDNI(dni);
                
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
               
                DocenteDAO objdocDAO=new DocenteDAO();
                PersonaDAO objpeDAO=new PersonaDAO();
                
                int j=objpeDAO.InsertarPersona(objpeBEAN);    
                int i=objdocDAO.InsertarDocente(objBEAN);
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
                
                pagina="/Mantenimiento/Personal/Docente/FrmMantenimientoRegistrarDocente.jsp";
                break; 
            }
            case 25:
            {
                
                String strcoddoc=request.getParameter("coddoc");
                int coddoc=Integer.parseInt(strcoddoc);
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
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setCodigoDocente(coddoc);
                objdocBEAN.setDNI(dni);
                objdocBEAN.setCodigoDepartamento(dep);
                objdocBEAN.setCodigoProvincia(pro);
                objdocBEAN.setCodigoDistrito(dis);
                objdocBEAN.setCodigoCalle(cal);
                objdocBEAN.setNombre(nom);
                objdocBEAN.setApellidoPaterno(apepa);
                objdocBEAN.setApellidoMaterno(apema);
                objdocBEAN.setSexo(sexo);
                objdocBEAN.setFechaNac(fecha);
                objdocBEAN.setCorreo(correo);
                objdocBEAN.setTelefono(tel);
                objdocBEAN.setNumExt(nume);
                objdocBEAN.setNumInt(numi);
               
                request.setAttribute("OBJETODOCENTE", objdocBEAN);
                
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                request.setAttribute("LISTADEPARTAMENTOS", lista);
                
                pagina="/Mantenimiento/Personal/Docente/FrmMantenimientoModificarDocente.jsp";
                break;
            }
            case 26:
            {
                
                String strcoddoc=request.getParameter("coddoc");
                int coddoc=Integer.parseInt(strcoddoc);
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
                
                int j=objpeDAO.ModificarPersona(objpeBEAN);    
                if(j==0)
                {
                    request.setAttribute("MENSAJE", "NO SE HA ACTUALIZADO EL REGISTRO");
                } 
                else
                {
                    request.setAttribute("MENSAJE", "SE HA ACTUALIZADO EL REGISTRO CORRECTAMENTE");
                }
                
                DocenteBEAN objdocbean=new DocenteBEAN();
                objdocbean.setCodigoDocente(coddoc);
                DocenteDAO docdao=new DocenteDAO();
                DocenteBEAN obj=docdao.listarObjetoDocente(objdocbean);
                request.setAttribute("OBJETODOCENTE", obj);
                //
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                request.setAttribute("LISTADEPARTAMENTOS", lista);
                pagina="/Mantenimiento/Personal/Docente/FrmMantenimientoModificarDocente.jsp";
                break;
            }
            case 27:
            {
                String strcoddocente=request.getParameter("coddoc");
                int coddoc=Integer.parseInt(strcoddocente);
                
                DocenteBEAN objdocBEAN=new DocenteBEAN();
                objdocBEAN.setCodigoDocente(coddoc);
                DocenteDAO objdocDAO=new DocenteDAO();
                objdocDAO.EliminarDocente(objdocBEAN);
                request.setAttribute("MENSAJE", "SE HA ELIMINADO EL REGISTRO CORRECTAMENTE");
                
                String strdni=request.getParameter("dni");
                int dni=Integer.parseInt(strdni);
                DocenteBEAN objdoc=new DocenteBEAN();
                objdoc.setDNI(dni);
                DocenteDAO docdao=new DocenteDAO();
                int cont=docdao.ConsultarCargosDocente(objdoc);
                
                if(cont==0)
                {
                    UsuarioBEAN objusuBEAN=new UsuarioBEAN();
                    objusuBEAN.setDNI(dni);
                    UsuarioDAO objusuDAO=new UsuarioDAO();
                    objusuDAO.EliminarUsuarioXDNI(objusuBEAN);
                }
                
                
                ArrayList<DocenteBEAN> lista=null;
                DocenteDAO objdocdao=new DocenteDAO();
                lista=objdocdao.listarDocenteMantenimiento(); 

                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                
                pagina="/Mantenimiento/Personal/Docente/FrmMantenimientoDocente.jsp";
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
