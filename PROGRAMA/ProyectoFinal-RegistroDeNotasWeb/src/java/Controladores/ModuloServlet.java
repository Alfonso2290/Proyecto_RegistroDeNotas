
package Controladores;

import BEAN.CicloBEAN;
import BEAN.MateriaBEAN;
import BEAN.ModuloBEAN;
import BEAN.NivelBEAN;
import DAO.CicloDAO;
import DAO.MateriaDAO;
import DAO.ModuloDAO;
import DAO.NivelDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ModuloServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cadop=request.getParameter("op");
        int op=Integer.parseInt(cadop);
        String pagina="";
        
        switch(op)
        {
            case 1:
            {
               
                ArrayList<ModuloBEAN> lista=null;
                ModuloDAO objmoddao=new ModuloDAO();
                lista=objmoddao.listarModuloMantenimiento(); 

                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                
                pagina="/Mantenimiento/Modulo/FrmMantenimientoModulo.jsp";
                break;
            }
            case 2:
            {
               
               pagina="/Seguridad/Personal/PersonalAdministrativo/FrmPersonalAdministrativoPrincipal.jsp";
               break;
            }
            case 3:
            {
              
               pagina="/Mantenimiento/Modulo/FrmMantenimientoRegistrarModulo.jsp";
               break;
            }
            case 4:
            {
                
                ArrayList<ModuloBEAN> lista=null;
                ModuloDAO objmoddao=new ModuloDAO();
                lista=objmoddao.listarModuloMantenimiento(); 

                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                
                pagina="/Mantenimiento/Modulo/FrmMantenimientoModulo.jsp";
                break;
            }
            case 5:
            {
                
                String mat=(String)request.getParameter("txtMat");
                String niv=(String)request.getParameter("cboNivel");
                String strcic=request.getParameter("cboCiclo");
                int cic=Integer.parseInt(strcic);
                int codmat,codniv,codcic;
                MateriaDAO matdao=new MateriaDAO();
                codmat=matdao.capturarCodigoMateria();
                NivelDAO nivdao=new NivelDAO();
                codniv=nivdao.capturarCodigoNivel();
                CicloDAO cicdao=new CicloDAO();
                codcic=cicdao.capturarCodigoCiclo();
                
                MateriaBEAN objmat=new MateriaBEAN();
                objmat.setCodigoMateria(codmat);
                objmat.setNombre(mat);
                
                NivelBEAN objniv=new NivelBEAN();
                objniv.setCodigoNivel(codniv);
                objniv.setNombre(niv);
                
                CicloBEAN objcic=new CicloBEAN();
                objcic.setCodigoCiclo(codcic);
                objcic.setNumCiclo(cic);
                
                
                
                MateriaDAO objmatDAO=new MateriaDAO();
                NivelDAO objnivDAO=new NivelDAO();
                CicloDAO objcicDAO=new CicloDAO();
                ModuloDAO objmodDAO=new ModuloDAO();
                
                objmatDAO.InsertarMateria(objmat);    
                objnivDAO.InsertarNivel(objniv);
                objcicDAO.InsertarCiclo(objcic);  
                
                String codmod="";
                String matmay=mat.toUpperCase();
                String nivmay=niv.toUpperCase();
                if(mat.length()>=3)
                {
                    codmod+=matmay.charAt(0) + "" + matmay.charAt(1)+ "" + matmay.charAt(2) + "";
                }
                else
                {
                    codmod+=matmay + "";
                }
                codmod+=nivmay.charAt(0)+ "" + nivmay.charAt(1) + ""+ nivmay.charAt(2) + "";
                if(cic<10)
                {
                    codmod+="0" + cic + "";
                }
                else
                {
                    codmod+=cic + "";
                }
                ModuloBEAN objmod=new ModuloBEAN();
                objmod.setCodigoModulo(codmod);
                int codmateria;
                MateriaBEAN materia=new MateriaBEAN();
                materia.setNombre(mat);
                MateriaDAO daomat=new MateriaDAO();
                codmateria=daomat.capturarCodigoMateriaXNombre(materia);
                objmod.setCodigoMateria(codmateria);
                int codnivel;
                NivelBEAN nivel=new NivelBEAN();
                nivel.setNombre(niv);
                NivelDAO daoniv=new NivelDAO();
                codnivel=daoniv.capturarCodigoNivelXNombre(nivel);
                objmod.setCodigoNivel(codnivel);
                int codciclo;
                CicloBEAN ciclo=new CicloBEAN();
                ciclo.setNumCiclo(cic);
                CicloDAO daocic=new CicloDAO();
                codciclo=daocic.capturarCodigoCicloXNombre(ciclo);
                objmod.setCodigoCiclo(codciclo);
                int i=objmodDAO.InsertarModulo(objmod);
                
                if(i==0)
                    request.setAttribute("MENSAJE", "EL MODULO INGRESADO YA EXISTE EN LA BASE DE DATOS");
                else
                    request.setAttribute("MENSAJE", "SE HA REALIZADO EL REGISTRO CORRECTAMENTE");

                pagina="/Mantenimiento/Modulo/FrmMantenimientoRegistrarModulo.jsp";
               break; 
            }
            case 6:
            {
                String codmod=request.getParameter("codmod");
                
                ModuloBEAN objmodBEAN=new ModuloBEAN();
                objmodBEAN.setCodigoModulo(codmod);
                ModuloDAO objmodDAO=new ModuloDAO();
                objmodDAO.EliminarModulo(objmodBEAN);
                request.setAttribute("MENSAJE", "SE HA ELIMINADO EL REGISTRO CORRECTAMENTE");
                
                
                ArrayList<ModuloBEAN> lista=null;
                ModuloDAO objmoddao=new ModuloDAO();
                lista=objmoddao.listarModuloMantenimiento(); 

                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                
                pagina="/Mantenimiento/Modulo/FrmMantenimientoModulo.jsp";
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
