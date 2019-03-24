
<html>
    <head>
       <title>VENTANA PRINCIPAL DEL SISTEMA WEB DEL INSTITUTO DE IDIOMAS</title>
       <link href="<%=request.getContextPath()%>/css/index/index.css" rel="stylesheet" type="text/css"/>
       <link href="<%=request.getContextPath()%>/css/index/botones.css" rel="stylesheet" type="text/css"/>
       
       <link href="<%=request.getContextPath()%>/css/HojaEstilo01.css" rel="stylesheet" type="text/css">
       <link href="<%=request.getContextPath()%>/css/HojaEstilo002.css" rel="stylesheet" type="text/css">
       <script src="<%=request.getContextPath()%>/javascript/Metodos.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos1.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos2.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos3.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos4.js" type="text/javascript"></script>
       <script src="<%=request.getContextPath()%>/javascript/Metodos5.js" type="text/javascript"></script>
    </head>
    <body onload="FocoUsuario()">       
        <div id="login_cont">
            
            <form name="form">
                <input type="hidden" name="op">
                
                <table class="TablaPrincipal3">
                    <tr>
                        <td colspan="3"><center><img src="<%=request.getContextPath()%>/imagenes/logo2.png" width="350" height="100"><hr id="hr"></center></td>                            
                    </tr>
                    <tr>
                        <td colspan="3" ><h2 id="login">Sistema Virtual de Registro de Notas</h2><hr id="hr"></td>
                    </tr>
                    <tr>
                        <td colspan="3"><center>    
                            <label id="Acceso">Acceso al Sistema</label>
                        </center></td>
                    </tr>
                    
                    
                    <tr>
                        <td colspan="2">
                            <div align="center">
                                <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','PersonalServlet',2)" >
                                    <div class="principal">
                                        <div class="principal_petit">
                                            <div class="principal_img">
                                                <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/173024/img_scale_sociaux.png" border="0" align="center"/>
                                            </div>
                                        </div>
                                    </div>
                                </a>
                                    <div align="center" style=" padding:5px; color:#ffffff; font-weight:300; font-size:30px; font-family:'Roboto';padding-top:20px;">Personal <font style="font-weight:400;"></font></div>                                
                            </div>
                        </td>
                        
                        <td colspan="3">
                            <div align="center">
                                <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','EstudianteServlet',4)">
                                    <div class="principalestudiante">
                                        <div class="principal_petit">
                                            <div class="principal_img">
                                                <img src="imagenes/index/person-flat (1) (1).png" border="0" align="center"/>
                                            </div>
                                        </div>
                                    </div>
                                </a>
 
                                <div align="center" style=" padding:5px; color:#ffffff; font-weight:300; font-size:30px; font-family:'Roboto';padding-top:20px;">Estudiante</div>
                            </div>  
                        </td>
                    </tr>
                </table>
                <link href='https://fonts.googleapis.com/css?family=Roboto:100,400,300,500,700' rel='stylesheet' type='text/css'>   
            </form>
        </div>
    </body>
</html>


