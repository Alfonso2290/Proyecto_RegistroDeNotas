<%@page import="BEAN.DistritoBEAN"%>
<%@page import="BEAN.CalleBEAN"%>
<%@page import="BEAN.ProvinciaBEAN"%>
<%@page import="BEAN.DepartamentoBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.PersonalBEAN"%>
<%@page import="BEAN.UsuarioBEAN"%>
<%@page session="true" %>
<%!
    UsuarioBEAN usu;
%>

<%
    usu=(UsuarioBEAN)session.getAttribute("DATOSUSUARIO");
    
%>

<%
    if(session.getAttribute("DATOSUSUARIO")==null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <title>MANTENIMIENTO REGISTRAR TABLA MODULO</title>
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
        <script src="<%=request.getContextPath()%>/javascript/Metodos11.js" type="text/javascript"></script>
        
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
    <body onload="FocoMateria()">
        <form name="form">
            <%
                if(session.getAttribute("DATOSUSUARIO")!=null)
                {
            %>
            <input type="hidden" name="op">
            <input type="hidden" name="codusuario" value="<%=usu.getCodigoUsuario()%>">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <%@include file="../../Menu/FrmMenuPersonalAdministrativo.jsp" %>
                <div class="CabeceraMenus">Registrar Tabla Modulo</div>
            </nav>   
            <center>
                <div class="DivPrincipalMantenimientoRegistrar">
                    <br><br>
                    <div class="alert alert-success" >
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
                    <table class="TablaPrincipalMantenimientoRegistrarModulo" cellpadding="7">
                       
                        <tr>
                            <td>Materia:</td>
                            <td><input type="text" name="txtMat"  class="Textbox" placeholder=" Ingrese Materia"></td>
                        </tr>
                        <tr>
                            <td>Nivel:</td>
                            <td>
                                <select name="cboNivel" class="ComboBoxActualizarInformacion">
                                    <option value="" selected>--Seleccionar Ciclo--</option>
                                    <option value="Basico" >Basico</option>
                                    <option value="Intermedio" >Intermedio</option>
                                    <option value="Avanzado" >Avanzado</option>
                                </select>
                            </td>
                        </tr>
                        
                        <tr>
                            <td>Ciclo:</td>
                            <td>
                                <select name="cboCiclo" class="ComboBoxActualizarInformacion">
                                    <option value="" selected>--Seleccionar Ciclo--</option>
                                    
                                    <%
                                        for(int i=1;i<=10;i++){
                                    %>
                                    
                                    <option value="<%=i%>"><%=i%></option>
                                    
                                    <%
                                        }
                                    %>
                                    
                                </select>
                           </td>
                        </tr>
                        
                    </table>
                    <br><br>
                    <table class="TablaPrincipalMantenimiento2">
                        <tr>
                            <td>
                                <center>
                                    <button type="button" class="botonActualizarInfo" onclick="GuardarNuevoModulo('<%=request.getContextPath()%>','ModuloServlet',5)">
                                        <img src="<%=request.getContextPath()%>/imagenes/nuevousuario.png" width="30" height="20">
                                        Guardar
                                    </button>
                                </center>
                            </td>
                            <td>
                                <button type="button" class="botonRegistrar" onclick="SalirModulo('<%=request.getContextPath()%>','ModuloServlet',4)">
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



