
<%@page import="BEAN.MateriaBEAN"%>
<%@page import="BEAN.NivelBEAN"%>
<%@page import="BEAN.CicloBEAN"%>
<%@page import="BEAN.DocenteBEAN"%>
<%@page import="BEAN.AulaBEAN"%>
<%@page import="BEAN.EstudianteBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.UsuarioBEAN"%>
<%@page session="true" %>

<%!
    UsuarioBEAN usu;
    ArrayList<MateriaBEAN> listamat;
    ArrayList<NivelBEAN> listaniv;
    ArrayList<CicloBEAN> listacic;
    ArrayList<AulaBEAN> listaaula;
    ArrayList<DocenteBEAN> listadoc;
    ArrayList<AulaBEAN> listamoda;
    ArrayList<EstudianteBEAN> lista;
    String strcodmat,strcodniv,strcodcic,numaula,strcoddoc,moda;
    int codmat,codniv,codcic,coddoc;
%>

<%
    usu=(UsuarioBEAN)session.getAttribute("DATOSUSUARIO");
    listamat=(ArrayList<MateriaBEAN>)request.getAttribute("LISTAMATERIAS");
    listaniv=(ArrayList<NivelBEAN>)request.getAttribute("LISTANIVELES");
    listacic=(ArrayList<CicloBEAN>)request.getAttribute("LISTACICLOS");
    listaaula=(ArrayList<AulaBEAN>)request.getAttribute("LISTAAULAS");
    listadoc=(ArrayList<DocenteBEAN>)request.getAttribute("LISTADOCENTES");
    listamoda=(ArrayList<AulaBEAN>)request.getAttribute("LISTAMODALIDADES");
    lista=(ArrayList<EstudianteBEAN>)request.getAttribute("LISTA");
 
    strcodmat=(String)request.getAttribute("CODIGOMATERIA");
    strcodniv=(String)request.getAttribute("CODIGONIVEL");
    strcodcic=(String)request.getAttribute("CODIGOCICLO");
    numaula=(String)request.getAttribute("NUMEROAULA");
    strcoddoc=(String)request.getAttribute("CODIGODOCENTE");
    moda=(String)request.getAttribute("MODALIDAD");
%>

<%
    if(session.getAttribute("DATOSUSUARIO")==null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <title>MANTENIMIENTO TABLA ALUMNO</title>
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
        <script src="<%=request.getContextPath()%>/javascript/Metodos8.js" type="text/javascript"></script>
        
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
            <input type="hidden" name="codalu">
            <input type="hidden" name="dni">
            <input type="hidden" name="coddis">
            <input type="hidden" name="coddep">
            <input type="hidden" name="codpro">
            <input type="hidden" name="codcal">
            <input type="hidden" name="nom">
            <input type="hidden" name="apepa">
            <input type="hidden" name="apema">
            <input type="hidden" name="sexo">
            <input type="hidden" name="fecha">
            <input type="hidden" name="correo">
            <input type="hidden" name="tel">
            <input type="hidden" name="NumI">
            <input type="hidden" name="NumE">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <%@include file="../../Menu/FrmMenuPersonalAdministrativo.jsp" %>
                <div class="CabeceraMenus">Mantenimiento Tabla Alumno</div>
            </nav> 
            <center>
                <div class="DivPrincipalMantenimiento">
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
                    <table class="TablaPrincipalMantenimiento0002" >
                        <tr>
                            
                            <td><center>Materia</center></td>
                            <td><center>Nivel</center></td>
                            <td><center>Ciclo</center></td>
                            <td><center>Aula</center></td>
                            <td><center>Docente</center></td>
                            <td><center>Modalidad</center></td>
                            <td></td>
                        </tr>
                        <tr>
                            
                            <td>
                                <center>
                                    <div>
                                        <select name="cboMateria" class="ComboBoxMateria" onchange="EnlaceComboBox('<%=request.getContextPath()%>','NivelServlet',1)">

                                            <%
                                                if(request.getAttribute("CODIGOMATERIA")!=null)
                                                {
                                                    codmat=Integer.parseInt(strcodmat);
                                            %>
                                                    <option value=0>--Seleccionar Materia--</option>
                                            <%
                                                if(request.getAttribute("LISTAMATERIAS")!=null)
                                                for(MateriaBEAN obj: listamat){
                                            %>

                                            <%
                                                if(obj.getCodigoMateria()==codmat)
                                                {

                                            %>

                                            <option value="<%=obj.getCodigoMateria()%>" selected><%=obj.getNombre()%></option>

                                            <%
                                                }
                                                else
                                                {

                                            %>

                                            <option value="<%=obj.getCodigoMateria()%>"><%=obj.getNombre()%></option>

                                            <%
                                                }
                                               }

                                            %>

                                            <%
                                                }
                                                else
                                                {
                                            %>

                                                <option value=0 selected>--Seleccionar Materia--</option>

                                            <%
                                                if(request.getAttribute("LISTAMATERIAS")!=null)
                                                for(MateriaBEAN obj: listamat){
                                            %>

                                            <option value="<%=obj.getCodigoMateria()%>"><%=obj.getNombre()%></option>

                                            <%
                                                  }
                                                }
                                            %>

                                        </select>
                                    </div>
                                </center>
                            </td>
                            <td>
                                <center>
                                    <div>
                                        <select name="cboNivel" class="ComboBoxMateria" onchange="EnlaceComboBox('<%=request.getContextPath()%>','CicloServlet',1)">

                                            <%
                                                if(request.getAttribute("CODIGONIVEL")!=null)
                                                {
                                                    codniv=Integer.parseInt(strcodniv);
                                            %>
                                                    <option value=0>--Seleccionar Nivel--</option>
                                            <%
                                                if(request.getAttribute("LISTANIVELES")!=null)
                                                for(NivelBEAN obj2: listaniv){
                                            %>

                                            <%
                                                if(obj2.getCodigoNivel()==codniv)
                                                {

                                            %>

                                            <option value="<%=obj2.getCodigoNivel()%>" selected><%=obj2.getNombre()%></option>

                                            <%
                                                }
                                                else
                                                {

                                            %>

                                            <option value="<%=obj2.getCodigoNivel()%>"><%=obj2.getNombre()%></option>

                                            <%
                                                }
                                               }

                                            %>

                                            <%
                                                }
                                                else
                                                {
                                            %>

                                                <option value=0 selected>--Seleccionar Nivel--</option>

                                            <%
                                                if(request.getAttribute("LISTANIVELES")!=null)
                                                for(NivelBEAN obj2: listaniv){
                                            %>

                                            <option value="<%=obj2.getCodigoNivel()%>"><%=obj2.getNombre()%></option>

                                            <%
                                                  }
                                                }
                                            %>

                                        </select>
                                    </div>
                                </center>
                                
                            </td>
                            <td>
                                <center>
                                    <div>
                                        <select name="cboCiclo" class="ComboBoxMateria" onchange="EnlaceComboBox('<%=request.getContextPath()%>','AulaServlet',2)">
                                            
                                            <%
                                                if(request.getAttribute("CODIGOCICLO")!=null)
                                                {
                                                    codcic=Integer.parseInt(strcodcic);
                                            %>
                                                    <option value=0>--Seleccionar Ciclo--</option>
                                            <%
                                                if(request.getAttribute("LISTACICLOS")!=null)
                                                for(CicloBEAN obj3: listacic){
                                            %>

                                            <%
                                                if(obj3.getCodigoCiclo()==codcic)
                                                {

                                            %>

                                            <option value="<%=obj3.getCodigoCiclo()%>" selected><%=obj3.getNumCiclo()%></option>

                                            <%
                                                }
                                                else
                                                {

                                            %>

                                            <option value="<%=obj3.getCodigoCiclo()%>"><%=obj3.getNumCiclo()%></option>

                                            <%
                                                }
                                               }

                                            %>

                                            <%
                                                }
                                                else
                                                {
                                            %>

                                            <option value=0 selected>--Seleccionar Ciclo--</option>

                                            <%
                                                if(request.getAttribute("LISTACICLOS")!=null)
                                                for(CicloBEAN obj3: listacic){
                                            %>

                                            <option value="<%=obj3.getCodigoCiclo()%>"><%=obj3.getNumCiclo()%></option>

                                            <%
                                                  }
                                                }
                                            %>

                                        </select>
                                    </div>
                                </center>
                            </td>
                            <td>
                                <center>
                                    <div>
                                        <select name="cboAula" class="ComboBoxMateria" onchange="EnlaceComboBox('<%=request.getContextPath()%>','DocenteServlet',21)">
                                            
                                            <%
                                                if(request.getAttribute("NUMEROAULA")!=null)
                                                {
                                            %>
                                                    <option value="">--Seleccionar Aula--</option>
                                            <%
                                                if(request.getAttribute("LISTAAULAS")!=null)
                                                for(AulaBEAN obj4: listaaula){
                                            %>

                                            <%
                                                if(obj4.getNumAula().equals(numaula))
                                                {

                                            %>

                                            <option value="<%=obj4.getNumAula()%>" selected><%=obj4.getNumAula()%></option>

                                            <%
                                                }
                                                else
                                                {

                                            %>

                                            <option value="<%=obj4.getNumAula()%>"><%=obj4.getNumAula()%></option>

                                            <%
                                                }
                                               }

                                            %>

                                            <%
                                                }
                                                else
                                                {
                                            %>

                                            <option value="" selected>--Seleccionar Aula--</option>

                                            <%
                                                if(request.getAttribute("LISTAAULAS")!=null)
                                                for(AulaBEAN obj4: listaaula){
                                            %>

                                            <option value="<%=obj4.getNumAula()%>"><%=obj4.getNumAula()%></option>

                                            <%
                                                  }
                                                }
                                            %>

                                        </select>
                                    </div>
                                </center>
                            </td>
                            <td>
                                <center>
                                    <div>
                                        <select name="cboDocente" class="ComboBoxMateria" onchange="EnlaceComboBox('<%=request.getContextPath()%>','AulaServlet',3)">
                                            
                                            <%
                                                if(request.getAttribute("CODIGODOCENTE")!=null)
                                                {
                                                    coddoc=Integer.parseInt(strcoddoc);
                                            %>
                                                    <option value=0>--Seleccionar Docente--</option>
                                            <%
                                                if(request.getAttribute("LISTADOCENTES")!=null)
                                                for(DocenteBEAN obj3: listadoc){
                                            %>

                                            <%
                                                if(obj3.getCodigoDocente()==coddoc)
                                                {

                                            %>

                                            <option value="<%=obj3.getCodigoDocente()%>" selected><%=obj3.getNombre()%> <%=obj3.getApellidoPaterno()%></option>

                                            <%
                                                }
                                                else
                                                {

                                            %>

                                            <option value="<%=obj3.getCodigoDocente()%>" ><%=obj3.getNombre()%> <%=obj3.getApellidoPaterno()%></option>

                                            <%
                                                }
                                               }

                                            %>

                                            <%
                                                }
                                                else
                                                {
                                            %>

                                            <option value=0 selected>--Seleccionar Docente--</option>

                                            <%
                                                if(request.getAttribute("LISTADOCENTES")!=null)
                                                for(DocenteBEAN obj3: listadoc){
                                            %>

                                            <option value="<%=obj3.getCodigoDocente()%>" ><%=obj3.getNombre()%> <%=obj3.getApellidoPaterno()%></option>

                                            <%
                                                  }
                                                }
                                            %>

                                        </select>
                                    </div>
                                </center>
                            </td>
                            <td>
                                <center>
                                    <div>
                                        <select name="cboModalidad" class="ComboBoxMateria">
                                            
                                            <%
                                                if(request.getAttribute("MODALIDAD")!=null)
                                                {
                                            %>
                                                    <option value="">Seleccionar Modalidad</option>
                                            <%
                                                if(request.getAttribute("LISTAMODALIDADES")!=null)
                                                for(AulaBEAN obj4: listamoda){
                                            %>

                                            <%
                                                if(obj4.getModalidad().equals(moda))
                                                {

                                            %>

                                            <option value="<%=obj4.getModalidad()%>" selected><%=obj4.getModalidad()%></option>

                                            <%
                                                }
                                                else
                                                {

                                            %>

                                            <option value="<%=obj4.getModalidad()%>"><%=obj4.getModalidad()%></option>

                                            <%
                                                }
                                               }

                                            %>

                                            <%
                                                }
                                                else
                                                {
                                            %>

                                            <option value="" selected>Seleccionar Modalidad</option>

                                            <%
                                                if(request.getAttribute("LISTAMODALIDADES")!=null)
                                                for(AulaBEAN obj4: listamoda){
                                            %>

                                            <option value="<%=obj4.getModalidad()%>"><%=obj4.getModalidad()%></option>

                                            <%
                                                  }
                                                }
                                            %>

                                        </select>
                                    </div>
                                </center>
                                
                            </td>
                            <td>
                                <center>
                                    <button type="button" name="btnBuscar" class="botonInicioSesion" onclick="seleccionarfiltros('<%=request.getContextPath()%>','EstudianteServlet',18)">
                                        <img src="<%=request.getContextPath()%>/imagenes/buscar.png" width="20" height="20">    
                                        Buscar
                                    </button>
                                </center>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="7">
                                <button type="button" class="botonNuevo" onclick="NuevoAlumno('<%=request.getContextPath()%>','EstudianteServlet',20)">
                                    <img src="<%=request.getContextPath()%>/imagenes/agregar.png" width="30" height="25">
                                    Nuevo
                                </button>
                            </td>
                        </tr>
                    </table>
                    <br><br>
                    <%
                       if(request.getAttribute("LISTA")!=null){
                    %>
                    
                    <div class="container" style="width: 95%">
                        <div class="form-group">
                            <select name="estado" id="maxRows" class="form-control" style="width: 150px;margin-left:-975px;">
                                <option value="5000">N� Registros</option>
                                <option value="5">5</option>
                                <option value="10">10</option>
                                <option value="15">15</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                                <option value="75">75</option>
                                <option value="100">100</option>
                            </select>
                        </div>
                        <table cellpadding="10" id="miTabla" class="table table-bordered table-striped" border="2"  >
                            <thead>
                                <tr style="background: lightblue;">
                                    <th style="height:50px;">COD.ALUMNO</th>
                                    <th>DNI</th>
                                    <th>ALUMNO</th>
                                    <th>CORREO</th>
                                    <th>TELEFONO</th>
                                    <th>FECHA NACIMIENTO</th>
                                    <th>MODIFICAR</th>
                                    <th>ELIMINAR</th>
                                </tr>
                            </thead>
                            <tbody>
                        <%
                        
                            for(EstudianteBEAN obj:lista){
                        %>
                        
                                <tr>
                                    <td style="height:50px;"><%=obj.getCodigoEstudiante()%></td>
                                    <td><%=obj.getDNI()%></td>
                                    <td><%=obj.getNombre()%> <%=obj.getApellidoPaterno()%> <%=obj.getApellidoMaterno()%></td>
                                    <td><%=obj.getCorreo()%></td>
                                    <td><%=obj.getTelefono()%></td>
                                    <td><%=obj.getFechaNac()%></td>
                                    <td>
                                        <button type="button" class="botonNuevo" name="btnModificar" onclick="ModificarAlumno('<%=request.getContextPath()%>','EstudianteServlet',22,'<%=obj.getCodigoEstudiante()%>','<%=obj.getDNI()%>','<%=obj.getCodigoDepartamento()%>','<%=obj.getCodigoProvincia()%>','<%=obj.getCodigoDistrito()%>','<%=obj.getCodigoCalle()%>','<%=obj.getNombre()%>','<%=obj.getApellidoPaterno()%>','<%=obj.getApellidoMaterno()%>','<%=obj.getSexo()%>','<%=obj.getFechaNac()%>','<%=obj.getCorreo()%>','<%=obj.getTelefono()%>','<%=obj.getNumExt()%>','<%=obj.getNumInt()%>')">
                                            <img src="<%=request.getContextPath()%>/imagenes/actualizar.png" width="20" height="20">
                                            Modificar
                                        </button>
                                    </td>
                                    <td>
                                        <button type="button" class="botonNuevo" name="btnEliminar" onclick="EliminarAlumno('<%=request.getContextPath()%>','EstudianteServlet',24,'<%=obj.getCodigoEstudiante()%>','<%=obj.getDNI()%>')">
                                            <img src="<%=request.getContextPath()%>/imagenes/eliminar.png" width="20" height="20">
                                            Eliminar
                                        </button>
                                    </td>
                                </tr>
                        
                        <%
                                
                            }
                        %>
                            </tbody>
                        </table>
                    <div class="pagination-container">
                            <nav>
                                <ul class="pagination"></ul>
                            </nav>
                        </div>
                    </div>
 
                    <script>
                        var table='#miTabla';
                        $('#maxRows').on('change', function()
                        {
                           $('.pagination').html('');
                           var trnum = 0;
                           var maxRows = parseInt($(this).val());
                           var totalRows = $(table+' tbody tr').length;
                           $(table+' tr:gt(0)').each(function()
                           {
                              trnum++;
                              if(trnum > maxRows)
                              {
                                  $(this).hide();
                              }
                              if(trnum <= maxRows)
                              {
                                  $(this).show();
                              }
                           });
                           if(totalRows > maxRows)
                           {
                               var pagenum=Math.ceil(totalRows/maxRows);
                               for(var i=1;i<=pagenum;)
                               {
                                   $('.pagination').append('<li data-page="'+i+'">\<span>'+ i++ +'<span class="sr-only">(current)</span></span>\</li>').show();
                               }
                           }
                           $('.pagination li:first-child').addClass('active');
                           $('.pagination li').on('click',function()
                           {
                              var pageNum=$(this).attr('data-page');
                              var trIndex=0;
                              $('.pagination li').removeClass('active');
                              $(this).addClass('active');
                              $(table+' tr:gt(0)').each(function()
                              {
                                 trIndex++;
                                 if(trIndex > (maxRows*pageNum) || trIndex <= ((maxRows*pageNum)-maxRows))
                                 {
                                     $(this).hide();
                                 }
                                 else
                                 {
                                     $(this).show();
                                 }
                              });
                           });
                        });
        
                    </script>
                    
                    <%
                        }
                    %>
                    <br><br>
                    <table class="TablaPrincipalMantenimiento2">
                        <tr>
                            <td>
                                <center>
                                    <button type="button" class="botonActualizarInfo" onclick="EnlaceLogin('<%=request.getContextPath()%>','EstudianteServlet',19)">
                                        <img src="<%=request.getContextPath()%>/imagenes/salir.png" width="20" height="20">
                                        Salir
                                    </button>
                                </center>
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

