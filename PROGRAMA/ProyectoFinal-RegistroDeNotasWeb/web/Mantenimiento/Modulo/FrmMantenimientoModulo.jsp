
<%@page import="BEAN.ModuloBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.UsuarioBEAN"%>
<%@page session="true" %>

<%!
    UsuarioBEAN usu;
    ArrayList<ModuloBEAN> lista;
%>

<%
    usu=(UsuarioBEAN)session.getAttribute("DATOSUSUARIO");
    lista=(ArrayList<ModuloBEAN>)request.getAttribute("LISTA");
%>

<%
    if(session.getAttribute("DATOSUSUARIO")==null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <title>MANTENIMIENTO TABLA MODULO</title>
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
        <script src="<%=request.getContextPath()%>/javascript/Metodos11.js" type="text/javascript"></script>
        
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
            <input type="hidden" name="codmod">
            <input type="hidden" name="codmat">
            <input type="hidden" name="codniv">
            <input type="hidden" name="codcic">
            <input type="hidden" name="nommat">
            <input type="hidden" name="nomniv">
            <input type="hidden" name="numcic">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <%@include file="../../Menu/FrmMenuPersonalAdministrativo.jsp" %>
                <div class="CabeceraMenus">Mantenimiento Tabla Modulo</div>
            </nav>  
            <center>
                <div class="DivPrincipalMantenimiento003">
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
                    <table class="TablaPrincipalMantenimiento2" >
                        <tr>
                            <td>
                                <button type="button" class="botonNuevo" onclick="NuevoModulo('<%=request.getContextPath()%>','ModuloServlet',3)">
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
                            <select name="estado" id="maxRows" class="form-control" style="width: 150px;margin-left:-460px;">
                                <option value="5000">Nº Registros</option>
                                <option value="5">5</option>
                                <option value="10">10</option>
                                <option value="15">15</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                                <option value="75">75</option>
                                <option value="100">100</option>
                            </select>
                        </div>
                        <table cellpadding="10" id="miTabla" class="table table-bordered table-striped" border="2" >
                            <thead>
                                <tr style="background: lightblue;">
                                    <th style="height:50px;">COD.MODULO</th>
                                    <th>MATERIA</th>
                                    <th>NIVEL</th>
                                    <th>CICLO</th>
                                    <th>ELIMINAR</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%

                                for(ModuloBEAN obj:lista){
                            %>

                                <tr>
                                    <td style="height:50px;"><%=obj.getCodigoModulo()%></td>
                                    <td><%=obj.getNomMateria()%></td>
                                    <td><%=obj.getNomNivel()%></td>
                                    <td><%=obj.getNomCiclo()%></td>
                                    <td>
                                        <button type="button" class="botonNuevo" name="btnEliminar" onclick="EliminarModulo('<%=request.getContextPath()%>','ModuloServlet',6,'<%=obj.getCodigoModulo()%>')">
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
                                    <button type="button" class="botonActualizarInfo" onclick="EnlaceLogin('<%=request.getContextPath()%>','ModuloServlet',2)">
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



