
   
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
                <a href="javascript: EnlaceLogin('<%=request.getContextPath()%>','PersonalAdministrativoServlet',1)">Principal</a>
            </li> 
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="">Mantenimiento <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','UsuarioServlet',1)">Tabla Usuario</a>
                    </li>
                    <li>
                        <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','PersonalAdministrativoServlet',9)">Tabla Personal</a>
                    </li>
                    <li>
                        <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','MateriaServlet',1)">Tabla Alumno</a>
                    </li>
                    <li>
                        <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','DocenteServlet',20)">Tabla Docente</a>
                    </li>
                    <li>
                        <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','AulaServlet',1)">Tabla Aula</a>
                    </li>
                    <li>
                        <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','ModuloServlet',1)">Tabla Modulo</a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="">Visualizar <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','PersonalAdministrativoServlet',3)">Perfil</a>
                    </li>
                </ul>
            </li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="">Configuración<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li>
                        <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','PersonalAdministrativoServlet',5)">Actualizar Información</a>                                
                    </li>
                    <li>                                
                      <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','PersonalAdministrativoServlet',7)">Cambiar Contraseña</a>                                  
                    </li>                            
                </ul>
            </li>                    
            <li>
                <a href="javascript:EnlaceLogin('<%=request.getContextPath()%>','PersonalAdministrativoServlet',2)" ><img src="">Cerrar Sesion </a>
            </li>
        </ul>
    </div>
</div>


