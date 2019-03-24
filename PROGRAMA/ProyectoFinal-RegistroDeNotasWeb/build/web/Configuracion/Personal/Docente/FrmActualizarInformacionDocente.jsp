<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.UsuarioBEAN"%>
<%@page session="true" %>

<%!
    UsuarioBEAN usu;
    ArrayList<UsuarioBEAN> lista;
%>

<%
    usu=(UsuarioBEAN)session.getAttribute("DATOSUSUARIO");
    lista=(ArrayList<UsuarioBEAN>)request.getAttribute("LISTAUSUARIO");
%>

<%
    if(session.getAttribute("DATOSUSUARIO")==null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <title>ACTUALIZAR INFORMACIÓN DOCENTE</title>
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
    <body onload="FocoUsuario()">
        <form name="form">
            <%
                if(session.getAttribute("DATOSUSUARIO")!=null)
                {
            %>
            <input type="hidden" name="op">
            <input type="hidden" name="codusuario" value="<%=usu.getCodigoUsuario()%>">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">    
                <%@include file="../../../Menu/FrmMenuDocente.jsp" %>
                <div class="CabeceraMenus">Actualizar Información</div>
            </nav>    
            <center>
                <div class="DivPrincipalActualizarInfo">
                    <br><br>
                    <div class="alert alert-success" style="width: 90%">
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
                    <table class="TablaPrincipalActualizarInfo">
                        
                        <%
                            for(UsuarioBEAN usu:lista)
                            {
                        %>
                        
                        <tr class="Columna1">
                            <td>Nombre de Usuario:</td>
                            <td><input class="Textbox" placeholder=" Ingrese Nombre de Usuario" type="text" name="txtUsu" value="<%=usu.getNombre()%>"></td>
                        </tr>
                        <tr class="Columna1">
                            <td>Primer Nombre:</td>
                            <td><input class="Textbox" placeholder=" Ingrese Primer Nombre" type="text" name="txtNom1" value="<%=usu.getPrimerNombre()%>"></td>
                        </tr>
                        <tr class="Columna1">
                            <td>Segundo Nombre:</td>
                            <td><input class="Textbox" placeholder=" Ingrese Segundo Nombre <opcional> " type="text" name="txtNom2" value="<%=usu.getSegundoNombre()%>"></td>
                        </tr>
                        <tr class="Columna1">
                            <td>Apellido Paterno:</td>
                            <td><input class="Textbox" placeholder=" Ingrese Apellido Paterno" type="text" name="txtApePa" value="<%=usu.getApellidoPaterno()%>"></td>
                        </tr>
                        <tr class="Columna1">
                            <td>Apellido Materno:</td>
                            <td><input class="Textbox" placeholder=" Ingrese Apellido Materno" type="text" name="txtApeMa" value="<%=usu.getApellidoMaterno()%>"></td>
                        </tr>
                        <tr class="Columna1">
                            <td>Teléfono:</td>
                            <td><input class="Textbox" placeholder=" Ingrese Teléfono referencial" onkeypress="return soloNumeros(event)" type="tel" name="txtTele" value="<%=usu.getTelefono()%>"></td>
                        </tr>
                        <tr class="Columna1">
                            <td>Correo:</td>
                            <td><input class="Textbox" placeholder=" Ejm: nombre@empresa.com" type="email" name="txtCorreo" value="<%=usu.getCorreo()%>"></td>
                        </tr> 
                        <tr class="Columna1">
                            <td>Sexo:</td>
                            <td>
                                <select class="ComboBoxActualizarInformacion" name="cboSexo">
                  
                                <%
                                    if(usu.getSexo().equals("Masculino"))
                                    {
                                %>
                                    
                                    <option value="Masculino" selected>Masculino</option>
                                    <option value="Femenino">Femenino</option>
                                    
                                <%
                                    }
                                    else
                                    {
                                %>
                                
                                    <option value="Masculino">Masculino</option>
                                    <option value="Femenino" selected>Femenino</option>
                                
                                <%
                                    }
                                %>
                                    
                                </select>
                            </td>
                        </tr>
                        
                        <%
                            }
                        %>
                    </table> 
                    <br>
                    <table  class="TablaBotonesActualizarInfo">   
                        <tr>
                            <td>
                                <center>
                                    <button type="button" class="botonActualizarInfo" onclick="ModificarUsuario('<%=request.getContextPath()%>','DocenteServlet',8)">
                                        <img src="<%=request.getContextPath()%>/imagenes/actualizar.png" width="20" height="20">
                                        Modificar
                                    </button>
                                </center>
                            </td>
                            <td>
                                <button type="button" class="botonRegistrar" onclick="SalirPrincipal('<%=request.getContextPath()%>','DocenteServlet',6)">
                                    <img src="<%=request.getContextPath()%>/imagenes/salir.png" width="20" height="20">
                                    Salir
                                </button>
                            </td>
                        </tr>
                    </table>
                    <br><br>                    
                </div>
                
            </center> 
            <%
                }
            %>
        </form>
    </body>
</html>


