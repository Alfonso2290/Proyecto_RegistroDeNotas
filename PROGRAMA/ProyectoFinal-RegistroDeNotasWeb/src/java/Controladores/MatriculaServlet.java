
package Controladores;

import BEAN.AulaBEAN;
import BEAN.CalificacionBEAN;
import BEAN.CicloBEAN;
import BEAN.DepartamentoBEAN;
import BEAN.DocenteBEAN;
import BEAN.EstudianteBEAN;
import BEAN.MateriaBEAN;
import BEAN.MatriculaBEAN;
import BEAN.ModuloBEAN;
import BEAN.NivelBEAN;
import BEAN.PersonaBEAN;
import BEAN.PersonalBEAN;
import DAO.AulaDAO;
import DAO.CalificacionDAO;
import DAO.CicloDAO;
import DAO.DepartamentoDAO;
import DAO.DocenteDAO;
import DAO.EstudianteDAO;
import DAO.MateriaDAO;
import DAO.MatriculaDAO;
import DAO.ModuloDAO;
import DAO.NivelDAO;
import DAO.PersonaDAO;
import DAO.PersonalDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MatriculaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cadop=request.getParameter("op");
        int op=Integer.parseInt(cadop);
        String pagina="";
        
        switch(op)
        {
            case 1:
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
                
                EstudianteDAO objaludao=new EstudianteDAO();
                int codalu=objaludao.capturarCodigoEstudiante();
                ModuloBEAN modbean=new ModuloBEAN();
                modbean.setCodigoMateria(codmat);
                modbean.setCodigoNivel(codniv);
                modbean.setCodigoCiclo(codcic);
                ModuloDAO moddao=new ModuloDAO();
                String codmodulo=moddao.capturarCodigoModulo(modbean);
                               
                EstudianteBEAN objaluBEAN=new EstudianteBEAN();
                objaluBEAN.setCodigoEstudiante(codalu);
                objaluBEAN.setDNI(dni);
                
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
                
                MatriculaBEAN matri=new MatriculaBEAN();
                matri.setCodigoEstudiante(codalu);
                matri.setNumAula(numaula);
                
                CalificacionBEAN objcalbean=new CalificacionBEAN();
                objcalbean.setCodigoEstudiante(codalu);
                objcalbean.setCodigoModulo(codmodulo);
               
                EstudianteDAO objaluDAO=new EstudianteDAO();
                PersonaDAO objpeDAO=new PersonaDAO();
                MatriculaDAO objmatDAO=new MatriculaDAO();
                CalificacionDAO objcalDAO=new CalificacionDAO();
                
                AulaDAO auladao=new AulaDAO();
                AulaBEAN aulabean=new AulaBEAN();
                aulabean.setNumAula(numaula);
                int cupos=auladao.VacanteCupo(aulabean);
                MatriculaDAO matdao=new MatriculaDAO();
                MatriculaBEAN matbean=new MatriculaBEAN();
                matbean.setNumAula(numaula);
                int cantalumnos=matdao.CantidadAlumnosXAula(matbean);
                
                
                if(cantalumnos<cupos)
                {
                    int j=objpeDAO.InsertarPersona(objpeBEAN);
                    int i=objaluDAO.InsertarAlumno(objaluBEAN);
                    int m=objmatDAO.RegistrarMatricula(matri);
                    int n=objcalDAO.RegistrarCalificacion(objcalbean);
                    if(i==0)
                    {
                        request.setAttribute("MENSAJE", "NO SE HA REALIZADO EL REGISTRO");
                    } 
                    else
                    {
                        request.setAttribute("MENSAJE", "SE HA REALIZADO EL REGISTRO CORRECTAMENTE");
                    }
                }
                
                
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                request.setAttribute("LISTADEPARTAMENTOS", lista);
                
                //
                AulaBEAN objaubean=new AulaBEAN();
                objaubean.setCodigoMateria(codmat);
                objaubean.setCodigoNivel(codniv);
                objaubean.setCodigoCiclo(codcic);
                objaubean.setCodigoDocente(coddoc);
                MateriaDAO matedao=new MateriaDAO();
                MateriaBEAN mat=matedao.capturarNombre(objaubean);
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
                
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoRegistrarEstudiante.jsp";
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
