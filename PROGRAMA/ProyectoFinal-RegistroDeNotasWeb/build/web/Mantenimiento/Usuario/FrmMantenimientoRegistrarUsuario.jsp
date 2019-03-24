<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.UsuarioBEAN"%>
<%@page session="true" %>
<%!
    UsuarioBEAN usu;
    String tipo;
%>

<%
    usu=(UsuarioBEAN)session.getAttribute("DATOSUSUARIO");
    tipo=(String)request.getAttribute("TIPO");
%>

<%
    if(session.getAttribute("DATOSUSUARIO")==null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <title>MANTENIMIENTO REGISTRAR TABLA USUARIO</title>
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
        <script src="<%=request.getContextPath()%>/javascript/Metodos6.js" type="text/javascript"></script>
        
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
    <body onload="FocoDNI()">
        <form name="form">
            <%
                if(session.getAttribute("DATOSUSUARIO")!=null)
                {
            %>
            <input type="hidden" name="op">
            <input type="hidden" name="codusuario" value="<%=usu.getCodigoUsuario()%>">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <%@include file="../../Menu/FrmMenuPersonalAdministrativo.jsp" %>
                <div class="CabeceraMenus">Registrar Tabla Usuario</div>
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
                    <center>
                        <table class="TablaPrincipalMantenimientoRegistrarUsuario" cellpadding="7">

                            <tr>
                                <td>DNI:</td>
                                <td><input type="text" name="txtDNI" onkeypress="return soloNumeros(event)" class="Textbox" placeholder=" Ingrese DNI"></td>
                            </tr>
                            <tr>
                                <td>Primer Nombre:</td>
                                <td><input type="text" name="txtNom1" class="Textbox" placeholder=" Ingrese Primer Nombre"></td>
                            </tr>
                            <tr>
                                <td>Segundo Nombre:</td>
                                <td><input type="text" name="txtNom2" class="Textbox" placeholder=" Ingrese Segundo Nombre <opcional>"></td>
                            </tr>
                            <tr>
                                <td>Apellido Paterno:</td>
                                <td><input type="text" name="txtApePa" class="Textbox" placeholder=" Ingrese Apellido Paterno"></td>
                            </tr>
                            <tr>
                                <td>Apellido Materno:</td>
                                <td><input type="text" name="txtApeMa" class="Textbox" placeholder=" Ingrese Apellido Materno"></td>
                            </tr>                        
                            <tr>
                                <td>Tipo Usuario:</td>
                                <td><input type="text" name="txtTipo" value="<%=tipo%>" disabled class="Textbox"></td>
                            </tr>
                            <tr>
                                <td>Sexo:</td>
                                <td>
                                    <select  name="cbSexo" class="ComboBoxActualizarInformacion">
                                        <option value="Masculino">Masculino</option>
                                        <option value="Femenino">Femenino</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>Correo:</td>
                                <td><input type="email" name="txtCorreo" class="Textbox" placeholder=" Ejm: nombre@empresa.com"></td>
                            </tr>
                            <tr>
                                <td>Telefono:</td>
                                <td><input type="tel" name="txtTel" onkeypress="return soloNumeros(event)" class="Textbox" placeholder=" Ingrese Telefono referencial"></td>
                            </tr>
                            <tr>
                                <td>Nombre de Usuario:</td>
                                <td><input type="text" name="txtUsu" class="Textbox" placeholder=" Ingrese Nombre de Usuario"></td>
                            </tr>
                            <tr>
                                <td>Contraseña:</td>
                                <td><input type="password" name="txtContra" class="Textbox" placeholder=" Ingrese Contraseña"></td>
                            </tr>
                            <tr>
                                <td>Repita Contraseña:</td>
                                <td><input type="password" name="txtContra1" class="Textbox" placeholder=" Ingrese Contraseña nuevamente"></td>
                            </tr>
                        </table>
                    </center>
                    <br><br>
                    <table class="TablaPrincipalMantenimiento2">
                        <tr>
                            <td>
                                <center>
                                    <button type="button" class="botonActualizarInfo" onclick="GuardarNuevoUsuario('<%=request.getContextPath()%>','UsuarioServlet',6)">
                                        <img src="<%=request.getContextPath()%>/imagenes/nuevousuario.png" width="30" height="20">
                                        Guardar
                                    </button>
                                </center>
                            </td>
                            <td>
                                <button type="button" class="botonRegistrar" onclick="SalirNuevoRegistro('<%=request.getContextPath()%>','UsuarioServlet',5)">
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
