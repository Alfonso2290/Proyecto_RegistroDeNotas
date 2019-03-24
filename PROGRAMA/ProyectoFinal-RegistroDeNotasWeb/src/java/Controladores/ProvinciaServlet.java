
package Controladores;

import BEAN.AulaBEAN;
import BEAN.CicloBEAN;
import BEAN.DepartamentoBEAN;
import BEAN.DocenteBEAN;
import BEAN.EstudianteBEAN;
import BEAN.MateriaBEAN;
import BEAN.NivelBEAN;
import BEAN.PersonalBEAN;
import BEAN.ProvinciaBEAN;
import DAO.CicloDAO;
import DAO.DepartamentoDAO;
import DAO.DocenteDAO;
import DAO.MateriaDAO;
import DAO.NivelDAO;
import DAO.PersonalDAO;
import DAO.ProvinciaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.EstudianteDAO;

public class ProvinciaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cadop=request.getParameter("op");
        int op=Integer.parseInt(cadop);
        String pagina="";
        
        switch(op)
        {
            case 1:
            {
                
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                
                request.setAttribute("LISTADEPARTAMENTOS",lista);
                
                String strcoddep=request.getParameter("cbDepartamento");
                int coddep=Integer.parseInt(strcoddep);
                DepartamentoBEAN objdepbean=new DepartamentoBEAN();
                objdepbean.setCodigoDepartamento(coddep);
                ProvinciaDAO objprodao=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listapro;
                listapro=objprodao.listarProvincias(objdepbean);
                
                request.setAttribute("LISTAPROVINCIAS",listapro);
                
                String strcodpro=request.getParameter("cbProvincia");
                request.setAttribute("CODIGODEPARTAMENTO",strcoddep);
                request.setAttribute("CODIGOPROVINCIA",strcodpro);
                pagina="/Mantenimiento/Personal/PersonalAdministrativo/FrmMantenimientoRegistrarPersonalAdministrativo.jsp";
                break;
            }
            case 2:
            {
                
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                
                request.setAttribute("LISTADEPARTAMENTOS",lista);
                
                String strcoddep=request.getParameter("cbDepartamento");
                int coddep=Integer.parseInt(strcoddep);
                DepartamentoBEAN objdepbean=new DepartamentoBEAN();
                objdepbean.setCodigoDepartamento(coddep);
                ProvinciaDAO objprodao=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listapro;
                listapro=objprodao.listarProvincias(objdepbean);
                
                request.setAttribute("LISTAPROVINCIAS",listapro);
                
                String strcodpro=request.getParameter("cbProvincia");
                request.setAttribute("CODIGODEPARTAMENTO",strcoddep);
                request.setAttribute("CODIGOPROVINCIA",strcodpro);
                
                String strcodper=request.getParameter("codper");
                int codper=Integer.parseInt(strcodper);
                PersonalBEAN objperbean=new PersonalBEAN();
                objperbean.setCodigoPersonal(codper);
                PersonalDAO perdao=new PersonalDAO();
                PersonalBEAN obj=perdao.listarObjetoPersonal(objperbean);
                request.setAttribute("OBJETOPERSONAL", obj);
                pagina="/Mantenimiento/Personal/PersonalAdministrativo/FrmMantenimientoModificarPersonalAdministrativo.jsp";
                break;
            }
            case 3:
            {
                
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                
                request.setAttribute("LISTADEPARTAMENTOS",lista);
                
                String strcoddep=request.getParameter("cbDepartamento");
                int coddep=Integer.parseInt(strcoddep);
                DepartamentoBEAN objdepbean=new DepartamentoBEAN();
                objdepbean.setCodigoDepartamento(coddep);
                ProvinciaDAO objprodao=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listapro;
                listapro=objprodao.listarProvincias(objdepbean);
                
                request.setAttribute("LISTAPROVINCIAS",listapro);
                
                String strcodpro=request.getParameter("cbProvincia");
                request.setAttribute("CODIGODEPARTAMENTO",strcoddep);
                request.setAttribute("CODIGOPROVINCIA",strcodpro);
                
                ///
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
                
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoRegistrarEstudiante.jsp";
                break;
            }
            case 4:
            {
                
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                
                request.setAttribute("LISTADEPARTAMENTOS",lista);
                
                String strcoddep=request.getParameter("cbDepartamento");
                int coddep=Integer.parseInt(strcoddep);
                DepartamentoBEAN objdepbean=new DepartamentoBEAN();
                objdepbean.setCodigoDepartamento(coddep);
                ProvinciaDAO objprodao=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listapro;
                listapro=objprodao.listarProvincias(objdepbean);
                
                request.setAttribute("LISTAPROVINCIAS",listapro);
                
                String strcodpro=request.getParameter("cbProvincia");
                request.setAttribute("CODIGODEPARTAMENTO",strcoddep);
                request.setAttribute("CODIGOPROVINCIA",strcodpro);
                
                String strcodalu=request.getParameter("codalu");
                int codalu=Integer.parseInt(strcodalu);
                EstudianteBEAN objalubean=new EstudianteBEAN();
                objalubean.setCodigoEstudiante(codalu);
                EstudianteDAO aludao=new EstudianteDAO();
                EstudianteBEAN obj=aludao.listarObjetoAlumno(objalubean);
                request.setAttribute("OBJETOALUMNO", obj);
                
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoModificarEstudiante.jsp";
                break;
            }
            case 5:
            {
                
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                
                request.setAttribute("LISTADEPARTAMENTOS",lista);
                
                String strcoddep=request.getParameter("cbDepartamento");
                int coddep=Integer.parseInt(strcoddep);
                DepartamentoBEAN objdepbean=new DepartamentoBEAN();
                objdepbean.setCodigoDepartamento(coddep);
                ProvinciaDAO objprodao=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listapro;
                listapro=objprodao.listarProvincias(objdepbean);
                
                request.setAttribute("LISTAPROVINCIAS",listapro);
                
                String strcodpro=request.getParameter("cbProvincia");
                request.setAttribute("CODIGODEPARTAMENTO",strcoddep);
                request.setAttribute("CODIGOPROVINCIA",strcodpro);
                pagina="/Mantenimiento/Personal/Docente/FrmMantenimientoRegistrarDocente.jsp";
                break;
            }
            case 6:
            {
                
                DepartamentoDAO depdao=new DepartamentoDAO();
                ArrayList<DepartamentoBEAN> lista; 
                lista=depdao.listarDepartamentos(); 
                
                request.setAttribute("LISTADEPARTAMENTOS",lista);
                
                String strcoddep=request.getParameter("cbDepartamento");
                int coddep=Integer.parseInt(strcoddep);
                DepartamentoBEAN objdepbean=new DepartamentoBEAN();
                objdepbean.setCodigoDepartamento(coddep);
                ProvinciaDAO objprodao=new ProvinciaDAO();
                ArrayList<ProvinciaBEAN> listapro;
                listapro=objprodao.listarProvincias(objdepbean);
                
                request.setAttribute("LISTAPROVINCIAS",listapro);
                
                String strcodpro=request.getParameter("cbProvincia");
                request.setAttribute("CODIGODEPARTAMENTO",strcoddep);
                request.setAttribute("CODIGOPROVINCIA",strcodpro);
                
                String strcoddoc=request.getParameter("coddoc");
                int coddoc=Integer.parseInt(strcoddoc);
                DocenteBEAN objdocbean=new DocenteBEAN();
                objdocbean.setCodigoDocente(coddoc);
                DocenteDAO docdao=new DocenteDAO();
                DocenteBEAN obj=docdao.listarObjetoDocente(objdocbean);
                request.setAttribute("OBJETODOCENTE", obj);
                pagina="/Mantenimiento/Personal/Docente/FrmMantenimientoModificarDocente.jsp";
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
