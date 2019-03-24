<%@page import="BEAN.DocenteBEAN"%>
<%@page import="BEAN.AulaBEAN"%>
<%@page import="BEAN.CicloBEAN"%>
<%@page import="BEAN.NivelBEAN"%>
<%@page import="BEAN.MateriaBEAN"%>
<%@page import="BEAN.DistritoBEAN"%>
<%@page import="BEAN.CalleBEAN"%>
<%@page import="BEAN.ProvinciaBEAN"%>
<%@page import="BEAN.DepartamentoBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.PersonalBEAN"%>
<%@page import="BEAN.UsuarioBEAN"%>
<%@page session="true" %>

<%!
    UsuarioBEAN usu;
    String strcoddep,strcodpro,strcoddis,strcodcal;
    int coddepa,codprov,coddist,codcall;
    ArrayList<DepartamentoBEAN> listadep;
    ArrayList<ProvinciaBEAN> listapro;
    ArrayList<DistritoBEAN> listadis;
    ArrayList<CalleBEAN> listacal;
    
    AulaBEAN objaula;
%>

<%
    usu=(UsuarioBEAN)session.getAttribute("DATOSUSUARIO");    
    strcoddep=(String)request.getAttribute("CODIGODEPARTAMENTO");
    strcodpro=(String)request.getAttribute("CODIGOPROVINCIA");
    strcoddis=(String)request.getAttribute("CODIGODISTRITO");
    strcodcal=(String)request.getAttribute("CODIGOCALLE");
    listadep=(ArrayList<DepartamentoBEAN>)request.getAttribute("LISTADEPARTAMENTOS");
    listapro=(ArrayList<ProvinciaBEAN>)request.getAttribute("LISTAPROVINCIAS");
    listadis=(ArrayList<DistritoBEAN>)request.getAttribute("LISTADISTRITOS");
    listacal=(ArrayList<CalleBEAN>)request.getAttribute("LISTACALLES");
    
    objaula=(AulaBEAN)request.getAttribute("OBJETOAULA");
%>

<%
    if(session.getAttribute("DATOSUSUARIO")==null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <title>MANTENIMIENTO REGISTRAR TABLA ALUMNO</title>
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
    <body onload="FocoDNI()">
        <form name="form">
            <%
                if(session.getAttribute("DATOSUSUARIO")!=null)
                {
            %>
            <input type="hidden" name="op">
            <input type="hidden" name="codusuario" value="<%=usu.getCodigoUsuario()%>">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <%@include file="../../Menu/FrmMenuPersonalAdministrativo.jsp" %>
                <div class="CabeceraMenus">Registrar Tabla Alumno</div>
            </nav>  
            <center>
                <div class="DivPrincipalMantenimientoRegistrar">
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
                    <table class="TablaPrincipalMantenimientoRegistrarAlumno" cellpadding="7">
                        <tr>
                            <td>Departamento:</td>
                            <td>
                                <div>
                                <select name="cbDepartamento" class="ComboBoxActualizarInformacion" onchange="NuevoAlumnoComboBox('<%=request.getContextPath()%>','ProvinciaServlet',3)" >
                                    
                                    <%
                                        if(request.getAttribute("CODIGODEPARTAMENTO")!=null)
                                        {
                                            coddepa=Integer.parseInt(strcoddep);
                                    %>
                                            <option value=0>--Seleccionar Departamento--</option>
                                    <%
                                        if(request.getAttribute("LISTADEPARTAMENTOS")!=null)
                                        for(DepartamentoBEAN obj: listadep){
                                    %>

                                    <%
                                        if(obj.getCodigoDepartamento()==coddepa)
                                        {

                                    %>

                                    <option value="<%=obj.getCodigoDepartamento()%>" selected><%=obj.getNombre()%></option>

                                    <%
                                        }
                                        else
                                        {

                                    %>

                                    <option value="<%=obj.getCodigoDepartamento()%>"><%=obj.getNombre()%></option>

                                    <%
                                        }
                                       }

                                    %>

                                    <%
                                        }
                                        else
                                        {
                                    %>

                                        <option value=0 selected>--Seleccionar Departamento--</option>

                                    <%
                                        if(request.getAttribute("LISTADEPARTAMENTOS")!=null)
                                        for(DepartamentoBEAN obj: listadep){
                                    %>

                                    <option value="<%=obj.getCodigoDepartamento()%>"><%=obj.getNombre()%></option>

                                    <%
                                          }
                                        }
                                    %>

                                </select>
                                </div>    
                            </td>
                        </tr>
                        <tr>
                            <td>Provincia:</td>
                            <td>
                                <div>
                                <select name="cbProvincia" class="ComboBoxActualizarInformacion" onchange="NuevoAlumnoComboBox('<%=request.getContextPath()%>','DistritoServlet',3)">
                                    
                                    <%
                                        if(request.getAttribute("CODIGOPROVINCIA")!=null)
                                        {
                                            codprov=Integer.parseInt(strcodpro);
                                    %>
                                            <option value=0>--Seleccionar Provincia--</option>
                                    <%
                                        if(request.getAttribute("LISTAPROVINCIAS")!=null)
                                        for(ProvinciaBEAN obj1: listapro){
                                    %>

                                    <%
                                        if(obj1.getCodigoProvincia()==codprov)
                                        {

                                    %>

                                    <option value="<%=obj1.getCodigoProvincia()%>" selected><%=obj1.getNombre()%></option>

                                    <%
                                        }
                                        else
                                        {

                                    %>

                                    <option value="<%=obj1.getCodigoProvincia()%>"><%=obj1.getNombre()%></option>

                                    <%
                                        }
                                       }

                                    %>

                                    <%
                                        }
                                        else
                                        {
                                    %>

                                        <option value=0 selected>--Seleccionar Provincia--</option>

                                    <%
                                        if(request.getAttribute("LISTAPROVINCIAS")!=null)
                                        for(ProvinciaBEAN obj1: listapro){
                                    %>

                                    <option value="<%=obj1.getCodigoProvincia()%>"><%=obj1.getNombre()%></option>

                                    <%
                                          }
                                        }
                                    %>

                                </select>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>Disrito:</td>
                            <td>
                                <select name="cbDistrito" class="ComboBoxActualizarInformacion" onchange="NuevoAlumnoComboBox('<%=request.getContextPath()%>','CalleServlet',3)">
                                    <%
                                        if(request.getAttribute("CODIGODISTRITO")!=null)
                                        {
                                            coddist=Integer.parseInt(strcoddis);
                                    %>
                                            <option value=0>--Seleccionar Distrito--</option>
                                    <%
                                        if(request.getAttribute("LISTADISTRITOS")!=null)
                                        for(DistritoBEAN obj: listadis){
                                    %>

                                    <%
                                        if(obj.getCodigoDistrito()==coddist)
                                        {

                                    %>

                                    <option value="<%=obj.getCodigoDistrito()%>" selected><%=obj.getNombre()%></option>

                                    <%
                                        }
                                        else
                                        {

                                    %>

                                    <option value="<%=obj.getCodigoDistrito()%>"><%=obj.getNombre()%></option>

                                    <%
                                        }
                                       }

                                    %>

                                    <%
                                        }
                                        else
                                        {
                                    %>

                                        <option value=0 selected>--Seleccionar Distrito--</option>

                                    <%
                                        if(request.getAttribute("LISTADISTRITOS")!=null)
                                        for(DistritoBEAN obj: listadis){
                                    %>

                                    <option value="<%=obj.getCodigoDistrito()%>"><%=obj.getNombre()%></option>

                                    <%
                                          }
                                        }
                                    %>

                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Calle:</td>
                            <td>
                                <select name="cbCalle" class="ComboBoxActualizarInformacion" onchange="HabilitarCampos()">
                                    <%
                                        if(request.getAttribute("CODIGOCALLE")!=null)
                                        {
                                            codcall=Integer.parseInt(strcodcal);
                                    %>
                                            <option value=0>--Seleccionar Calle--</option>
                                    <%
                                        if(request.getAttribute("LISTACALLES")!=null)
                                        for(CalleBEAN obj: listacal){
                                    %>

                                    <%
                                        if(obj.getCodigoCalle()==codcall)
                                        {

                                    %>

                                    <option value="<%=obj.getCodigoCalle()%>" selected><%=obj.getNombre()%></option>

                                    <%
                                        }
                                        else
                                        {

                                    %>

                                    <option value="<%=obj.getCodigoCalle()%>"><%=obj.getNombre()%></option>

                                    <%
                                        }
                                       }

                                    %>

                                    <%
                                        }
                                        else
                                        {
                                    %>

                                        <option value=0 selected>--Seleccionar Calle--</option>

                                    <%
                                        if(request.getAttribute("LISTACALLES")!=null)
                                        for(CalleBEAN obj: listacal){
                                    %>

                                    <option value="<%=obj.getCodigoCalle()%>"><%=obj.getNombre()%></option>

                                    <%
                                          }
                                        }
                                    %>

                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>DNI:</td>
                            <td><input type="text" name="txtDNI" onkeypress="return soloNumeros(event)" class="Textbox" placeholder=" Ingrese DNI" disabled></td>
                        </tr>
                        <tr>
                            <td>Nombre:</td>
                            <td><input type="text" name="txtNom" class="Textbox" placeholder=" Ingrese Nombre" disabled></td>
                        </tr>
                        <tr>
                            <td>Apellido Paterno:</td>
                            <td><input type="text" name="txtApePa" class="Textbox" placeholder=" Ingrese Apellido Paterno" disabled></td>
                        </tr>
                        <tr>
                            <td>Apellido Materno:</td>
                            <td><input type="text" name="txtApeMa" class="Textbox" placeholder=" Ingrese Apellido Materno" disabled></td>
                        </tr>
                        <tr>
                            <td>Materia:</td>
                            <td>
                                
                                    <div>
                                        <select name="cboMateria" class="ComboBoxActualizarInformacion" disabled >
                                            <option value="<%=objaula.getCodigoMateria()%>"><%=objaula.getNomMateria()%></option>
                                        </select>
                                    </div>
                                
                            </td>
                        </tr>
                        <tr>
                            <td>Nivel:</td>
                            <td>
                               
                                    <div>
                                        <select name="cboNivel" class="ComboBoxActualizarInformacion" disabled >
                                            <option value="<%=objaula.getCodigoNivel()%>"><%=objaula.getNomNivel()%></option>
                                        </select>
                                    </div>
                                
                                
                            </td>
                        </tr>
                        <tr>
                            <td>Ciclo:</td>
                            <td>
                                
                                    <div>
                                        <select name="cboCiclo" class="ComboBoxActualizarInformacion" disabled >
                                            <option value="<%=objaula.getCodigoCiclo()%>"><%=objaula.getNumCiclo()%></option>
                                        </select>
                                    </div>
                                
                            </td>
                        </tr>
                        <tr>
                            <td>Aula:</td>
                            <td>
                                
                                    <div>
                                        <select name="cboAula" class="ComboBoxActualizarInformacion"  disabled >
                                            <option value="<%=objaula.getNumAula()%>"><%=objaula.getNumAula()%></option>
                                        </select>
                                    </div>
                                
                            </td>
                        </tr>
                        <tr>
                            <td>Docente:</td>
                            <td>
                                
                                    <div>
                                        <select name="cboDocente" class="ComboBoxActualizarInformacion" disabled >
                                            <option value="<%=objaula.getCodigoDocente()%>"><%=objaula.getNombreDocente()%> <%=objaula.getApePaternoDocente()%></option>
                                        </select>
                                    </div>
                                
                            </td>
                        </tr>
                        <tr>
                            <td>Modalidad:</td>
                            <td>
                                
                                    <div>
                                        <select name="cboModalidad" class="ComboBoxActualizarInformacion" disabled> 
                                            <option value="<%=objaula.getModalidad()%>"><%=objaula.getModalidad()%></option>
                                        </select>
                                    </div>
                                
                                
                            </td>
                        </tr>
                        <tr>
                            <td>Correo:</td>
                            <td><input type="email" name="txtCorreo" class="Textbox" placeholder=" Ejm: nombre@empresa.com" disabled></td>
                        </tr>
                        <tr>
                            <td>Telefono:</td>
                            <td><input type="tel" name="txtTel" onkeypress="return soloNumeros(event)" class="Textbox" placeholder=" Ingrese Telefono referencial" disabled></td>
                        </tr>
                        <tr>
                            <td>Sexo:</td>
                            <td>
                                <select  name="cbSexo" class="ComboBoxActualizarInformacion" disabled>
                                    <option value="Masculino">Masculino</option>
                                    <option value="Femenino">Femenino</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Fecha de Nacimiento:</td>
                            <td><input type="date" name="txtFechaNac" class="Textbox" disabled></td>
                        </tr>
                        <tr>
                            <td>Numero Externo:</td>
                            <td><input type="text" disabled onkeypress="return soloNumeros(event)" name="txtNumE" class="Textbox" placeholder=" Ingrese Número Externo de su domicilio"></td>
                        </tr>
                        <tr>
                            <td>Numero Interno:</td>
                            <td><input type="text" disabled onkeypress="return soloNumeros(event)" name="txtNumI" class="Textbox" placeholder=" Ingrese Número Interno de su domicilio"></td>
                        </tr>
                        
                    </table>
                    <br><br>
                    <table class="TablaPrincipalMantenimiento2">
                        <tr>
                            <td>
                                <center>
                                    <button type="button" class="botonActualizarInfo" onclick="GuardarNuevoAlumno('<%=request.getContextPath()%>','MatriculaServlet',1)">
                                        <img src="<%=request.getContextPath()%>/imagenes/nuevousuario.png" width="30" height="20">
                                        Guardar
                                    </button>
                                </center>
                            </td>
                            <td>
                                <button type="button" class="botonRegistrar" onclick="SalirAlumno('<%=request.getContextPath()%>','EstudianteServlet',21)">
                                    <img src="<%=request.getContextPath()%>/imagenes/salir.png" width="20" height="20">
                                    Salir
                                </button>
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


