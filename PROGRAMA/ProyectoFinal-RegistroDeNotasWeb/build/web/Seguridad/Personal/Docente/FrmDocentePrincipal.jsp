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
	
	<title>MENÚ PRINCIPAL DOCENTE</title>
      
        <script src="<%=request.getContextPath()%>/javascript/Metodos.js" type="text/javascript"></script>
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/mobile.css">
	<script src="js/mobile.js" type="text/javascript"></script>
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
        <style>
        .embed-container {
            position: relative; padding-bottom: 56.25%; height: 900px; 
            overflow: hidden; max-width: 80%;
        } 
        .embed-container iframe, .embed-container object, .embed-container embed { 
            position: absolute; top: 0; left: 0; width: 100%; height: 50%; 
        }
    </style>
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
            </nav>
            <%
                }
            %>
        </form>  
        <br><br> <br><br><br> <br>
        
            <link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
            <link href='https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300' rel='stylesheet' type='text/css'>
            <div style="font-family: Oswald; font-size: 60px; text-align: center; color: #303F9F; text-shadow: 4px 4px #00BCD4; width: 722px; margin: 0 auto;">
                BIENVENIDO AL SISTEMA WEB DE REGISTRO DE NOTAS 
                <i>!</i></div>
            <br>
            
            <div style="font-family: Open Sans Condesed; 
                 font-size: 15px; width: 722px; 
                 margin: 0 auto; border-bottom: 10px double #00BCD4;
                 padding-bottom: 13px; text-align: justify; margin-top:
                 -19px; text-transform: lowercase; color: #303F9F; line-height: 90%">
                Ha ingresado al Sistema de Docente, este sistema le ayudará a tener una buena gestión de registros de notas
                de sus Alumnos, para aprender a utilizar el Sistema de información, le invitamos a ver el siguiente video tutorial 
                ...</div>
    
<br>
        <br>
    
    <div align="center">
        
      <div class='embed-container'><iframe src='https://www.youtube.com/embed/mlMaH0jar8E' frameborder='0' allowfullscreen></iframe></div>
  </div>  
    </body>
</html>