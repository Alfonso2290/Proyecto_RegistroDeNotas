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
        <title>PERFIL DOCENTE</title>
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
    <body>
        <form name="form">
            <%
                if(session.getAttribute("DATOSUSUARIO")!=null)
                {
            %>
            <input type="hidden" name="op">
            <input type="hidden" name="codusuario" value="<%=usu.getCodigoUsuario()%>">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">    
                <%@include file="../../../Menu/FrmMenuDocente.jsp" %>
                <div class="CabeceraMenus">Mi Perfil</div>
            </nav> 
            <center>
                <div class="DivPrincipalPerfil">
                    <br><br>
                    
                    <table class="TablaPrincipalPerfil">
                        
                        <%
                            for(UsuarioBEAN usu:lista)
                            {
                        %>
                        
                        <tr class="Columna1">
                            <td style="width: 40%">Nombre de Usuario:</td>
                            <td><input class="Textbox" type="text" name="txtUsu" value="<%=usu.getNombre()%>" disabled></td>
                        </tr>
                        <tr class="Columna1">
                            <td>Nombres:</td>
                            <td><input class="Textbox" type="text" name="txtNom" value="<%=usu.getPrimerNombre()%> <%=usu.getSegundoNombre()%>" disabled></td>
                        </tr>
                        <tr class="Columna1">
                            <td>Apellido Paterno:</td>
                            <td><input class="Textbox" type="text" name="txtApePa" value="<%=usu.getApellidoPaterno()%>" disabled></td>
                        </tr>
                        <tr class="Columna1">
                            <td>Apellido Materno:</td>
                            <td><input class="Textbox" type="text" name="txtApeMa" value="<%=usu.getApellidoMaterno()%>" disabled></td>
                        </tr>
                        <tr class="Columna1">
                            <td>Telefono:</td>
                            <td><input class="Textbox" type="tel" name="txtTele" value="<%=usu.getTelefono()%>" disabled></td>
                        </tr>
                        <tr class="Columna1">
                            <td>Correo:</td>
                            <td><input class="Textbox" type="email" name="txtCorreo" value="<%=usu.getCorreo()%>" disabled></td>
                        </tr> 
                        <tr class="Columna1">
                            <td>Sexo:</td>
                            <td><input class="Textbox" type="text" name="txtSexo" value="<%=usu.getSexo()%>" disabled></td>
                        </tr>
                        <tr class="Columna1">
                            <td>Fecha de Registro:</td>
                            <td><input class="Textbox" type="text" name="txtFReg" value="<%=usu.getFechaRegistro()%>" disabled></td>
                        </tr>
                        
                        <%
                            }
                        %>
                        
                    </table> 
                    <br><br>
                    <div class="CabeceraTablaPerfil">
                        <center>
                            <button type="button" class="botonRegistrar" onclick="SalirPrincipal('<%=request.getContextPath()%>','DocenteServlet',6)">
                                <img src="<%=request.getContextPath()%>/imagenes/salir.png" width="20" height="20">
                                Salir
                            </button>
                        </center>
                    </div>  
                   <br><br>             
                </div>
                                
            </center>
            
        </form>
        <%
            }
        %>
    </body>
</html>
