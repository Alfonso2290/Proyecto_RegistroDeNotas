<html>
    <head>
       <title>CONFIRMAR CODIGO PERSONAL</title>
       
    <!-- Validar y confirmar codigo -->
        <link href="<%=request.getContextPath()%>/css/Registrar/registro.css" rel="stylesheet" type="text/css"/>
        <!-- fondo-->
        <link href="<%=request.getContextPath()%>/css/Login.css" rel="stylesheet" type="text/css"/> 
    <!--/Validar y confirmar codigo -->
       
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
        <link href="<%=request.getContextPath()%>/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>
    <body onload="FocoTipo()">
        <div class="fullDiv">
            <div class="fondoopaco"></div>
        </div>
        <div class="derecha"></div>
          <!-- Formulario de registro-->
       <div class="message warning">
            <div class="inset">
                <div class="login-head">
                    <div style="font-size: 14pt;color:white;"> <center>Confirmaci�n de C�digo del Personal</center></div>
                        <div class="alert-close"> </div>
                        </div>
            <form name="form">
                <input type="hidden" name="op">
                    
                
                <div class="alert alert-success" style="width: 100%">
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
			
                            <select name="cbTipo" style="color: #9e61a3; font-size: 14px;" >
                                <option value="" selected="">Seleccione el Tipo de Usuario</option>
                                <option value="Docente">Docente</option>
                                <option value="Personal Administrativo">Personal Administrativo</option>
                            </select>
			
                        
                         
                             <input type="text" class="text" value="  C�digo" name="txtCod" onkeypress="return soloNumeros(event);" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '  C�digo';}"> 

			<div class="clear"> </div>
                        
			<div class="submit">
                        <div class="clear">  </div>
                        
                            <input type="button" value="Confirmar" onclick="EnlaceRegistrarPersonal('<%=request.getContextPath()%>','PersonalServlet',4)">
                               
                             <h4><a href="javascript: EnlaceLogin('<%=request.getContextPath()%>','PersonalServlet',2)">Regresar</a></h4>    
                        <div class="clear">  </div> 
			</div>
		</form>
		</div>
	</div>    
                      
    </body>
</html>

