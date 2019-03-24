
package Controladores;

import BEAN.CicloBEAN;
import BEAN.MateriaBEAN;
import BEAN.NivelBEAN;
import DAO.CicloDAO;
import DAO.MateriaDAO;
import DAO.NivelDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CicloServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cadop=request.getParameter("op");
        int op=Integer.parseInt(cadop);
        String pagina="";
        
        switch(op)
        {
            case 1:
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
                
                request.setAttribute("CODIGONIVEL",strcodniv);
                request.setAttribute("CODIGOMATERIA",strcodmat);
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoEstudiante.jsp";
                break;
            }
            case 2:
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
                
                request.setAttribute("CODIGONIVEL",strcodniv);
                request.setAttribute("CODIGOMATERIA",strcodmat);
                pagina="/Mantenimiento/Aula/FrmMantenimientoAula.jsp";
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
