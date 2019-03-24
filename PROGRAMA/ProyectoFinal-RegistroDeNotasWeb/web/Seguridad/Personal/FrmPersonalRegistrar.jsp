<%!
    String strcod;
    int codper=0;
    String tipo;
%>

<%
    strcod=(String)request.getAttribute("CODIGOPERSONAL");
    codper=Integer.parseInt(strcod);
    tipo=(String)request.getAttribute("TIPO");

%>

<html>
    <head>
       <title>REGISTRO DE USUARIO: PERSONAL</title>
<!--     Validar y confirmar codigo -->
        <link href="<%=request.getContextPath()%>/css/Registrar/registro2.css" rel="stylesheet" type="text/css"/>
         
        <link href="<%=request.getContextPath()%>/css/Login.css" rel="stylesheet" type="text/css"/> 
<!--    /Validar y confirmar codigo -->
      <script src="<%=request.getContextPath()%>/javascript/Metodos.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos1.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos2.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos3.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos4.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos5.js" type="text/javascript"></script>
       
       <link href="<%=request.getContextPath()%>/css/bootstrap.min2.css" rel="stylesheet"> 
       <script src="<%=request.getContextPath()%>/js/jquery_3.js"></script>
        <script src="<%=request.getContextPath()%>/js/bootstrap.min5.js"></script>
        <script src="<%=request.getContextPath()%>/js/jssor.slider-22.0.15.mini.js" type="text/javascript" data-library="jssor.slider.mini" data-version="22.0.15"></script>
        <script src="<%=request.getContextPath()%>/js/responsiveslides.min.js"></script>   
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.flexisel.js"></script>
        <script src="<%=request.getContextPath()%>/js/javascript.js" type="text/javascript"></script>
        
    </head>
    <body onload="FocoUsuario()">
        <div class="fullDiv">
            <div class="fondoopaco"></div>
        </div>
        <div class="derecha"></div>
        Registro de Usuario personal
        <!-- Formulario de registro-->
       <div class="message warning">
            <div class="inset">
                <div class="login-head">
                    <div style="font-size: 14pt;color:white;"> <center> Registro de Usuario Personal</center></div>
                        <div class="alert-close"> </div>
                        </div>
            <form name="form">
                <input type="hidden" name="op">
                <input type="hidden" name="codper" value="<%=codper%>">
                <input type="hidden" name="tipo" value="<%=tipo%>">
                
                
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
                               
                                <table>
                                    <tr>
                                        <td><strong>Usuario:</strong></td>
                                        <td><input   type="text" class="text" name="txtUsu"  style="font-size: 10pt;"  placeholder=" Ingrese su Nombre de Usuario"></td>
                                    </tr>
                                    <tr>
                                        <td><strong>Password:</strong></td>
                                        <td><input  type="password" class="text" name="txtPas"  style="font-size: 10pt;" placeholder=" Ingrese su Password"> </td>
                                    </tr>
                                    <tr>
                                        <td><strong>Repetir Password:</strong></td>
                                        <td><input type="password" class="text" name="txtPas2" style="font-size: 10pt;" placeholder=" Ingrese nuevamente su Password"> </td>
                                    </tr>
                                </table>  
                               
                    <div class="clear"> </div>
                        
			<div class="submit">
                        <div class="clear">  </div>
                            
                        <button style="margin-left:20px; margin-right:60px;" type="button"  onclick="RegistrarUsuario('<%=request.getContextPath()%>','PersonalServlet',5)"><img src="<%=request.getContextPath()%>/imagenes/nuevousuario.png" width="30" height="20" ><font style="botonon" ><strong>  Registrar</strong></font></button>
                            <button style=" margin-right:20px;" type="button"  onclick="EnlaceLogin('<%=request.getContextPath()%>','PersonalServlet',2)"><img src="<%=request.getContextPath()%>/imagenes/retroceder.png" width="30" height="20" ><font style="botonon" ><strong>  Inicia Sesión</strong></font></button>
                        
                            <div class="clear">  </div> 
			</div> 
            </form> 
                </div>
       </div>
    </body>
</html>

