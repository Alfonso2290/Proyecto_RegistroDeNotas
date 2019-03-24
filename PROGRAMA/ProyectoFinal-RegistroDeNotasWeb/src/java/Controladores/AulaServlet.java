
package Controladores;

import BEAN.AulaBEAN;
import BEAN.CicloBEAN;
import BEAN.DocenteBEAN;
import BEAN.MateriaBEAN;
import BEAN.ModuloBEAN;
import BEAN.NivelBEAN;
import DAO.AulaDAO;
import DAO.CicloDAO;
import DAO.DocenteDAO;
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

public class AulaServlet extends HttpServlet {

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
                
                pagina="/Mantenimiento/Aula/FrmMantenimientoAula.jsp";
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
                
                request.setAttribute("CODIGOCICLO",strcodcic);
                request.setAttribute("CODIGONIVEL",strcodniv);
                request.setAttribute("CODIGOMATERIA",strcodmat);
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoEstudiante.jsp";
                break;
            }
            case 3:
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
                
                String moda=request.getParameter("cboModalidad");
                request.setAttribute("MODALIDAD", moda);
                request.setAttribute("CODIGODOCENTE",strcoddocente);
                request.setAttribute("NUMEROAULA",numaula);
                request.setAttribute("CODIGOCICLO",strcodcic);
                request.setAttribute("CODIGONIVEL",strcodniv);
                request.setAttribute("CODIGOMATERIA",strcodmat);
                pagina="/Mantenimiento/Estudiante/FrmMantenimientoEstudiante.jsp";
                break;
            }
            case 4:
            {
               pagina="/Seguridad/Personal/PersonalAdministrativo/FrmPersonalAdministrativoPrincipal.jsp";
               break;
            }
            case 5:
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
                
                ArrayList<AulaBEAN> lista;
                AulaDAO objauladao=new AulaDAO();
                lista=objauladao.listarAulaMantenimiento(materia, nivel, ciclo); 

                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                
                request.setAttribute("CODIGOCICLO",strcodcic);
                request.setAttribute("CODIGONIVEL",strcodniv);
                request.setAttribute("CODIGOMATERIA",strcodmat);
                pagina="/Mantenimiento/Aula/FrmMantenimientoAula.jsp";
                break;
            }
            case 6:
            {
                
                
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                String strcodcic=request.getParameter("cboCiclo");
                int codcic=Integer.parseInt(strcodcic);
                AulaBEAN objaubean=new AulaBEAN();
                objaubean.setCodigoMateria(codmat);
                objaubean.setCodigoNivel(codniv);
                objaubean.setCodigoCiclo(codcic);
                MateriaDAO matdao=new MateriaDAO();
                MateriaBEAN mat=matdao.capturarNombre(objaubean);
                NivelDAO nivdao=new NivelDAO();
                NivelBEAN niv=nivdao.capturarNombre(objaubean);
                CicloDAO cicdao=new CicloDAO();
                CicloBEAN cic=cicdao.capturarNombre(objaubean);
                objaubean.setNomMateria(mat.getNombre());
                objaubean.setNomNivel(niv.getNombre());
                objaubean.setNumCiclo(cic.getNumCiclo());
                request.setAttribute("OBJETOAULA",objaubean);
                
                
                DocenteDAO docdao=new DocenteDAO();
                ArrayList<DocenteBEAN> listadoc;
                listadoc=docdao.listarTodosDocentes();
                request.setAttribute("LISTADOCENTES", listadoc);
                
                

                pagina="/Mantenimiento/Aula/FrmMantenimientoRegistrarAula.jsp";
                break;
            }
            case 7:
            {
                
                MateriaDAO matdao=new MateriaDAO();
                ArrayList<MateriaBEAN> listamat;
                listamat=matdao.listarMaterias();
                request.setAttribute("LISTAMATERIAS", listamat);
                pagina="/Mantenimiento/Aula/FrmMantenimientoAula.jsp";
                break;
            }
            case 8:
            {
                String strcodmat=request.getParameter("cboMateria");
                int codmat=Integer.parseInt(strcodmat);
                String strcodniv=request.getParameter("cboNivel");
                int codniv=Integer.parseInt(strcodniv);
                String strcodcic=request.getParameter("cboCiclo");
                int codcic=Integer.parseInt(strcodcic);
                String numaula=request.getParameter("txtAula");
                String strcoddocente=request.getParameter("cboDocente");
                int coddoc=Integer.parseInt(strcoddocente);
                String moda=request.getParameter("cboModalidad");
                String horai=request.getParameter("txtHoraI");
                String horas=request.getParameter("txtHoraS");
                String strcupo=request.getParameter("txtCupo");
                int cupo=Integer.parseInt(strcupo);
                
                ModuloBEAN modbean=new ModuloBEAN();
                modbean.setCodigoMateria(codmat);
                modbean.setCodigoNivel(codniv);
                modbean.setCodigoCiclo(codcic);
                ModuloDAO moddao=new ModuloDAO();
                String codmodulo=moddao.capturarCodigoModulo(modbean);
                               
                AulaBEAN objaulaBEAN=new AulaBEAN();
                objaulaBEAN.setNumAula(numaula);
                objaulaBEAN.setCodigoModulo(codmodulo);
                objaulaBEAN.setCodigoDocente(coddoc);
                objaulaBEAN.setModalidad(moda);
                objaulaBEAN.setHoraIngreso(horai);
                objaulaBEAN.setHoraSalida(horas);
                objaulaBEAN.setCupo(cupo);

                AulaDAO objaulaDAO=new AulaDAO();    
                int i=objaulaDAO.InsertarAula(objaulaBEAN);
                if(i==0)
                {
                    request.setAttribute("MENSAJE", "EL AULA INGRESADA YA EXISTE");
                } 
                else
                {
                    request.setAttribute("MENSAJE", "SE HA REALIZADO EL REGISTRO CORRECTAMENTE");
                }
                
                
                
                AulaBEAN objaubean=new AulaBEAN();
                objaubean.setCodigoMateria(codmat);
                objaubean.setCodigoNivel(codniv);
                objaubean.setCodigoCiclo(codcic);
                MateriaDAO matdao=new MateriaDAO();
                MateriaBEAN mat=matdao.capturarNombre(objaubean);
                NivelDAO nivdao=new NivelDAO();
                NivelBEAN niv=nivdao.capturarNombre(objaubean);
                CicloDAO cicdao=new CicloDAO();
                CicloBEAN cic=cicdao.capturarNombre(objaubean);
                objaubean.setNomMateria(mat.getNombre());
                objaubean.setNomNivel(niv.getNombre());
                objaubean.setNumCiclo(cic.getNumCiclo());
                request.setAttribute("OBJETOAULA",objaubean);
                
                DocenteDAO docdao=new DocenteDAO();
                ArrayList<DocenteBEAN> listadoc;
                listadoc=docdao.listarTodosDocentes();
                request.setAttribute("LISTADOCENTES", listadoc);
                
                pagina="/Mantenimiento/Aula/FrmMantenimientoRegistrarAula.jsp";
                break;
            }
            case 9:
            {
                
                String strcodmat=request.getParameter("codmat");
                int codmat=Integer.parseInt(strcodmat);
                String strcodniv=request.getParameter("codniv");
                int codniv=Integer.parseInt(strcodniv);
                String strcodcic=request.getParameter("codcic");
                int codcic=Integer.parseInt(strcodcic);
                String numaula=request.getParameter("numaula");
                String strcoddoc=request.getParameter("coddoc");
                int coddoc=Integer.parseInt(strcoddoc);
                String codmod=request.getParameter("codmod");
                String moda=request.getParameter("moda");
                String horai=request.getParameter("horai");
                String horas=request.getParameter("horas");
                String strcupo=request.getParameter("cupo");
                String nomdoc=request.getParameter("nomdoc");
                String apepadoc=request.getParameter("apepadoc");
                String apemadoc=request.getParameter("apemadoc");
                int cupo=Integer.parseInt(strcupo);
                
                AulaBEAN objaubean=new AulaBEAN();
                objaubean.setCodigoMateria(codmat);
                objaubean.setCodigoNivel(codniv);
                objaubean.setCodigoCiclo(codcic);
                MateriaDAO matdao=new MateriaDAO();
                MateriaBEAN mat=matdao.capturarNombre(objaubean);
                NivelDAO nivdao=new NivelDAO();
                NivelBEAN niv=nivdao.capturarNombre(objaubean);
                CicloDAO cicdao=new CicloDAO();
                CicloBEAN cic=cicdao.capturarNombre(objaubean);
                objaubean.setNomMateria(mat.getNombre());
                objaubean.setNomNivel(niv.getNombre());
                objaubean.setNumCiclo(cic.getNumCiclo());
                objaubean.setNumAula(numaula);
                objaubean.setCodigoDocente(coddoc);
                objaubean.setNombreDocente(nomdoc);
                objaubean.setApePaternoDocente(apepadoc);
                objaubean.setApeMaternoDocente(apemadoc);
                objaubean.setCodigoModulo(codmod);
                objaubean.setModalidad(moda);
                objaubean.setHoraIngreso(horai);
                objaubean.setHoraSalida(horas);
                objaubean.setCupo(cupo);
                request.setAttribute("OBJETOAULA",objaubean);
                
                
                DocenteDAO docdao=new DocenteDAO();
                ArrayList<DocenteBEAN> listadoc;
                listadoc=docdao.listarTodosDocentes();
                request.setAttribute("LISTADOCENTES", listadoc);
                
                

                pagina="/Mantenimiento/Aula/FrmMantenimientoModificarAula.jsp";
                break;
            }
            case 10:
            {
                
                String numaula=request.getParameter("numaula");
                String strcoddoc=request.getParameter("cboDocente");
                int coddoc=Integer.parseInt(strcoddoc);
                String strcupo=request.getParameter("txtCupo");
                int cupo=Integer.parseInt(strcupo);
                String horai=request.getParameter("txtHoraI");
                String horas=request.getParameter("txtHoraS");
                String moda=request.getParameter("cboModalidad");
                
                
                AulaBEAN objaubean=new AulaBEAN();
                objaubean.setNumAula(numaula);
                objaubean.setCodigoDocente(coddoc);
                objaubean.setModalidad(moda);
                objaubean.setHoraIngreso(horai);
                objaubean.setHoraSalida(horas);
                objaubean.setCupo(cupo);
                
                AulaDAO objaulaDAO=new AulaDAO();
                
                int j=objaulaDAO.ModificarAula(objaubean);    
                if(j==0)
                {
                    request.setAttribute("MENSAJE", "NO SE HA ACTUALIZADO EL REGISTRO");
                } 
                else
                {
                    request.setAttribute("MENSAJE", "SE HA ACTUALIZADO EL REGISTRO CORRECTAMENTE");
                }
                
                AulaBEAN aulabean=new AulaBEAN();
                aulabean.setNumAula(numaula);
                AulaDAO auladao=new AulaDAO();
                AulaBEAN obj=auladao.listarObjetoAula(aulabean);
                request.setAttribute("OBJETOAULA", obj);
                
                DocenteDAO objdocdao=new DocenteDAO();
                ArrayList<DocenteBEAN> listadoc;
                listadoc=objdocdao.listarTodosDocentes();
                request.setAttribute("LISTADOCENTES", listadoc);
                pagina="/Mantenimiento/Aula/FrmMantenimientoModificarAula.jsp";
                break;
            }
            case 11:
            {
                String numaula=request.getParameter("numaula");
                
                AulaBEAN objaulaBEAN=new AulaBEAN();
                objaulaBEAN.setNumAula(numaula);
                AulaDAO objaulaDAO=new AulaDAO();
                objaulaDAO.EliminarAula(objaulaBEAN);
                request.setAttribute("MENSAJE", "SE HA ELIMINADO EL REGISTRO CORRECTAMENTE");
                
               
               
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
                
                ArrayList<AulaBEAN> lista;
                AulaDAO objauladao=new AulaDAO();
                lista=objauladao.listarAulaMantenimiento(materia, nivel, ciclo); 

                
                if(lista.size()==0)
                    request.setAttribute("MENSAJE", "NO HAY REGISTROS A MOSTRAR");
                else
                    request.setAttribute("LISTA", lista);
                
                request.setAttribute("CODIGOCICLO",strcodcic);
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
