
 
<div class="container">

    <!-- IMAGEN DEL LOGO -->
    <div class="navbar-header" style="width: 30%;height: 160px;">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <div class="logo" style="margin-top: 15px;margin-left: -70px;">
            <img src="<%=request.getContextPath()%>/imagenes/logo-instituto-unfv.png" style="width: 80%;height: 120px;" >
        </div>
    </div>

    <!-- BARRA DE DESPLIEGUE -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

        <ul class="nav navbar-nav navbar-right">
            <li class="active">
                <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','EstudianteServlet',6)">Inicio</a>
            </li>                          
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="">Visualizar <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','EstudianteServlet',10)">Perfil</a>
                    </li>
                    <li>
                        <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','EstudianteServlet',9)">Calificaciones</a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="">Configuración<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','EstudianteServlet',8)">Actualizar Información</a>                                
                    </li>
                    <li>                                
                      <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','EstudianteServlet',7)">Cambiar Contraseña</a>                                  
                    </li>                            
                </ul>
            </li>                    
            <li>
                <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','EstudianteServlet',4)" ><img src="">Cerrar Sesion </a>
            </li>
        </ul>
    </div>
</div>  
    



