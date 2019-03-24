<html>
    <head>
       <title>INICIO DE SESIÓN DEL PERSONAL</title>
       <link href="<%=request.getContextPath()%>/css/HojaEstilo01.css" rel="stylesheet" type="text/css">
       <link href="<%=request.getContextPath()%>/css/HojaEstilo002.css" rel="stylesheet" type="text/css">
       <link href="<%=request.getContextPath()%>/css/HojaEstilo03.css" rel="stylesheet" type="text/css">
       <script src="<%=request.getContextPath()%>/javascript/Metodos.js" type="text/javascript"></script>
              <!-- boostrap y estilo del login-->
       <link href="<%=request.getContextPath()%>/css/boostrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
       <link href="<%=request.getContextPath()%>/css/Login.css" rel="stylesheet" type="text/css"/>
       <script src="<%=request.getContextPath()%>/javascript/Metodos.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos1.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos2.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos3.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos4.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos5.js" type="text/javascript"></script>
       
       <script src="<%=request.getContextPath()%>/js/jquery_3.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min5.js"></script>
        <script src="<%=request.getContextPath()%>/js/jssor.slider-22.0.15.mini.js" type="text/javascript" data-library="jssor.slider.mini" data-version="22.0.15"></script>
        <script src="<%=request.getContextPath()%>/js/responsiveslides.min.js"></script>   
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.flexisel.js"></script>
        <script src="<%=request.getContextPath()%>/js/javascript.js" type="text/javascript"></script>
        
    </head>
    <body onload="FocoTipo()">
         <div class="fullDiv">
            <div class="innerLeftBlurred"></div>
        </div>
                
        <div class="innerRightBlurred"></div>
        
            <div class="innerRight">
                <div class="row">
                    <h1 class="titulologin">Personal</h1>
                    <div class="account-wall">      
                        <img class="profile-img"  src="<%=request.getContextPath()%>/imagenes/perfil.jpg" alt=""/>           
                        <form name="form" class="form-signin">
                            <input type="hidden" name="op">
                            <select name="cbTipo" class="form-control">
                                    <option value="" selected>Tipo de Usuario</option>
                                    <option value="Docente">Docente</option>
                                    <option value="Personal Administrativo">Personal Administrativo</option>
                            </select>
                            <br>
                            <input type="text" name="txtUsu" class="form-control" placeholder="Usuario" required>
                            <input type="password" name="txtPas" class="form-control" placeholder="Contraseña" required>
                             
                            <button type="button" class="btn btn-lg btn-primary btn-block sign-in" onclick="EnlacePrincipalPersonal('<%=request.getContextPath()%>','PersonalServlet',1)" >
                                INICIAR SESIÓN		
                            </button>
                            
                            <a  href="javascript: EnlaceConfirmarCodigoPersonal('<%=request.getContextPath()%>','PersonalServlet',3)" class="text-center new-account">Registrate!</a>                             
                        
                        </form>
   
                    </div>
                    <div class="alert alert-success" style="width: 90%;font-size: 10pt;">
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
                             
		</div>
                            
            </div>
    </body>
</html>

