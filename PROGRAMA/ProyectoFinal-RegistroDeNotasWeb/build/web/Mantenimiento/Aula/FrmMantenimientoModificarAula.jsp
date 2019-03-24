
<%@page import="BEAN.EstudianteBEAN"%>
<%@page import="BEAN.CalleBEAN"%>
<%@page import="BEAN.UsuarioBEAN"%>
<%@page session="true" %>
<%@page import="BEAN.AulaBEAN"%>
<%@page import="BEAN.DocenteBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.PersonalBEAN"%>

<%!
    UsuarioBEAN usu;
    ArrayList<DocenteBEAN> listadoc;
    AulaBEAN objaula;
    
%>

<%
    usu=(UsuarioBEAN)session.getAttribute("DATOSUSUARIO");
    listadoc=(ArrayList<DocenteBEAN>)request.getAttribute("LISTADOCENTES");
    objaula=(AulaBEAN)request.getAttribute("OBJETOAULA");
%>

<%
    if(session.getAttribute("DATOSUSUARIO")==null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <title>MANTENIMIENTO MODIFICAR TABLA AULA</title>
        <link href="<%=request.getContextPath()%>/css/HojaEstilo01.css" rel="stylesheet" type="text/css">
        <link href="<%=request.getContextPath()%>/css/HojaEstilo03.css" rel="stylesheet" type="text/css">
        <link href="<%=request.getContextPath()%>/css/HojaEstilo002.css" rel="stylesheet" type="text/css">
        <link href="<%=request.getContextPath()%>/css/HojaEstilo05.css" rel="stylesheet" type="text/css">
        <script src="<%=request.getContextPath()%>/javascript/Metodos.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/javascript/Metodos1.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/javascript/Metodos2.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/javascript/Metodos3.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/javascript/Metodos4.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/javascript/Metodos5.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/javascript/Metodos10.js" type="text/javascript"></script>
        
        <link href="<%=request.getContextPath()%>/css/bootstrap.min2.css" rel="stylesheet"> 
        <link href="<%=request.getContextPath()%>/css/modern-business.css" rel="stylesheet">   
        <link href="<%=request.getContextPath()%>/css/style2.css" rel="stylesheet" type="text/css" media="all" />
        <script src="<%=request.getContextPath()%>/js/jquery_3.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min5.js"></script>
        <script src="<%=request.getContextPath()%>/js/jssor.slider-22.0.15.mini.js" type="text/javascript" data-library="jssor.slider.mini" data-version="22.0.15"></script>
        <script src="<%=request.getContextPath()%>/js/responsiveslides.min.js"></script>   
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.flexisel.js"></script>
        <script src="<%=request.getContextPath()%>/js/javascript.js" type="text/javascript"></script>
        
    </head>
    <body>
        <form name="form">
            <%
                if(session.getAttribute("DATOSUSUARIO")!=null)
                {
            %>
            <input type="hidden" name="op">
            <input type="hidden" name="codusuario" value="<%=usu.getCodigoUsuario()%>">
            <input type="hidden" name="numaula" value="<%=objaula.getNumAula()%>">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <%@include file="../../Menu/FrmMenuPersonalAdministrativo.jsp" %>
                <div class="CabeceraMenus">Modificar Tabla Aula</div>
            </nav>  
            <center>
                <div class="DivPrincipalMantenimientoRegistrar">
                    <br><br>
                    <div class="alert alert-success">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <strong>
                            
                                <%
                                    if(request.getAttribute("MENSAJE")!=null)
                                    {
                                %>                                   

                                    <%=request.getAttribute("MENSAJE")%>

                                <%
                                    }
                                %>
                           
                        </strong>
                    </div>
                    
                    <table class="TablaPrincipalMantenimientoModificarAula" cellpadding="7">
                        <tr>
                            <td>Aula:</td>
                            <td><input type="text" name="txtAula"  class="Textbox" disabled value="<%=objaula.getNumAula()%>"></td>
                        </tr> 
                        <tr>   
                            <td>Docente:</td>
                            <td>
                                
                                    <div>
                                        <select name="cboDocente" class="ComboBoxActualizarInformacion" >
                                            
                                            
                                            

                                            <%
                                                if(request.getAttribute("LISTADOCENTES")!=null)
                                                for(DocenteBEAN obj3: listadoc){
                                                    
                                            %>
                                            
                                            <%
                                                if(objaula.getCodigoDocente()==obj3.getCodigoDocente()){
                                            %>

                                            <option value="<%=objaula.getCodigoDocente()%>" selected><%=objaula.getNombreDocente()%> <%=objaula.getApePaternoDocente()%> <%=objaula.getApeMaternoDocente()%></option>

                                            <%
                                                  }
                                                else{
                                                
                                            %>
                                            <option value="<%=obj3.getCodigoDocente()%>" ><%=obj3.getNombre()%> <%=obj3.getApellidoPaterno()%> <%=obj3.getApellidoMaterno()%></option>
                                            
                                            <%
                                                    }
                                                }
                                            %>
                                        
                                        </select>
                                    </div>
                                
                            </td>
                        
                        </tr>
                        <tr>
                            <td>Materia:</td>
                            <td>
                                <select name="cboMateria" class="ComboBoxActualizarInformacion" disabled>
                                    <option value="<%=objaula.getCodigoMateria()%>"><%=objaula.getNomMateria()%></option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Nivel:</td>
                            <td>
                                <select name="cboNivel" class="ComboBoxActualizarInformacion" disabled>
                                    <option value="<%=objaula.getCodigoNivel()%>"><%=objaula.getNomNivel()%></option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Ciclo:</td>
                            <td>
                                <select name="cboCiclo" class="ComboBoxActualizarInformacion" disabled>
                                    <option value="<%=objaula.getCodigoCiclo()%>"><%=objaula.getNumCiclo()%></option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Modalidad:</td>
                            <td>
                                <select  name="cboModalidad" class="ComboBoxActualizarInformacion">
                                    <%
                                        if(objaula.getModalidad().equals("Presencial")){
                                    %>
                                    <option value="Presencial" selected>Presencial</option>
                                    <option value="SemiPresencial">SemiPresencial</option>
                                    <%
                                        }
                                        else
                                        {
                                    %>
                                    <option value="Presencial">Presencial</option>
                                    <option value="SemiPresencial" selected>SemiPresencial</option>
                                    <%
                                        }
                                    %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Hora Ingreso:</td>
                            <td><input type="time" name="txtHoraI" class="Textbox" ></td>
                            
                        </tr>
                        
                        <tr>
                            <td>Hora Salida:</td>
                            <td><input type="time" name="txtHoraS" class="Textbox" ></td>  
                            
                        </tr>                        
                        <tr>
                            <td>Cupos:</td>
                            <td><input type="text" name="txtCupo" onkeypress="return soloNumeros(event)" class="Textbox" placeholder=" Ingrese la cantidad máxima de alumnos" value="<%=objaula.getCupo()%>"></td>
                        </tr>
                        
                    </table>
                    <br><br>
                    <table class="TablaPrincipalMantenimiento2">
                        <tr>
                            <td>
                                <center>
                                    <button type="button" class="botonActualizarInfo" onclick="ModificarRegistroAula('<%=request.getContextPath()%>','AulaServlet',10)">
                                        <img src="<%=request.getContextPath()%>/imagenes/actualizar.png" width="20" height="20">
                                        Modificar
                                    </button>
                                </center>
                            </td>
                            <td>
                                <button type="button" class="botonActualizarInfo" onclick="SalirAula('<%=request.getContextPath()%>','AulaServlet',7)">
                                    <img src="<%=request.getContextPath()%>/imagenes/salir.png" width="20" height="20">
                                    Salir
                                </button>
                            </td>
                        </tr>
                    </table>
                    <br>
                </div>
            </center>
            <%
                }
            %>                        
        </form>
    </body>
</html>




