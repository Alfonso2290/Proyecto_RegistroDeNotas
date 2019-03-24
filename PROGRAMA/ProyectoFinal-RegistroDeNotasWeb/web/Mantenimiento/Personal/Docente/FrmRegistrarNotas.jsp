
<%@page import="BEAN.CalificacionBEAN"%>
<%@page import="BEAN.AulaBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.UsuarioBEAN"%>
<%@page session="true" %>

<%!
    UsuarioBEAN usu;
    ArrayList<AulaBEAN> listadocmat;
    ArrayList<AulaBEAN> listamatniv;
    ArrayList<AulaBEAN> listadoccic;
    ArrayList<AulaBEAN> listaaula;
    ArrayList<CalificacionBEAN> listacali;
    String strcodmat,strcodniv,strcodcic,numaula;
    int codmat,codniv,codcic;
%>

<%
    usu=(UsuarioBEAN)session.getAttribute("DATOSUSUARIO");
    listadocmat=(ArrayList<AulaBEAN>)request.getAttribute("LISTAMATERIAS");
    listamatniv=(ArrayList<AulaBEAN>)request.getAttribute("LISTANIVELES");
    listadoccic=(ArrayList<AulaBEAN>)request.getAttribute("LISTACICLOS");
    listaaula=(ArrayList<AulaBEAN>)request.getAttribute("LISTAAULAS");
    listacali=(ArrayList<CalificacionBEAN>)request.getAttribute("LISTACALIFICACIONES");
    strcodmat=(String)request.getAttribute("CODIGOMATERIA");
    strcodniv=(String)request.getAttribute("CODIGONIVEL");
    strcodcic=(String)request.getAttribute("CODIGOCICLO");
    numaula=(String)request.getAttribute("NUMEROAULA");
%>

<%
    if(session.getAttribute("DATOSUSUARIO")==null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<html>
    <head>
        <title>REGISTRO DE NOTAS</title>
        <link href="<%=request.getContextPath()%>/css/HojaEstilo01.css" rel="stylesheet" type="text/css">
        <link href="<%=request.getContextPath()%>/css/HojaEstilo03.css" rel="stylesheet" type="text/css">
        <link href="<%=request.getContextPath()%>/css/HojaEstilo05.css" rel="stylesheet" type="text/css">
        <link href="<%=request.getContextPath()%>/css/HojaEstilo002.css" rel="stylesheet" type="text/css">
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
        
        <script>
            function EnlaceComboBox(controlador,ruta,op)
            {
                document.form.action=controlador + "/" + ruta;
                document.form.method="POST";
                document.form.op.value=op;
                document.form.submit();
            }
            
            function EnlazarRegistro(op,cantidad)
            {
                document.form.action="<%=request.getContextPath()%>/DocenteServlet";
                document.form.method="POST";
                document.form.op.value=op;
                document.form.cantidad.value=cantidad;
                document.form.submit();
            }
            
            function GuardarCalificacion(op,cantidad)
            {
                var semestre=document.getElementById('cboSemestre').value;
                var cont1=0;
                var cont2=0;
                if(semestre=='')
                {
                    alert("Usted debe seleccionar el Periodo en el cual realizará el Registro de Notas");
                }
                else if(semestre=='Primer Periodo')
                {
                    <%
                        if(request.getAttribute("LISTACALIFICACIONES")!=null)
                        {
                            int n=listacali.size();
                            for(int i=1;i<=n;i++){
                    %>
                        
                        var parcial=document.getElementById('ep<%=i%>').value;
                        if(parcial!='')
                        {
                            cont1++;
                        }
                                
                    <%
                            }
                        }
                    %>
                    if(cont1==cantidad)
                    {
                        <%
                            if(request.getAttribute("LISTACALIFICACIONES")!=null)
                            {
                                int n=listacali.size();
                                for(int i=1;i<=n;i++){
                        %>   
                                        
                            document.getElementById('ep<%=i%>').disabled=false;
                            document.getElementById('ef<%=i%>').disabled=false;
                        
                        <%
                                }
                            }
                        %>
                        
                        EnlazarRegistro(op,cantidad);
                    }
                    else
                    {
                        alert("Usted debe Ingresar todas las Notas Parciales");
                    } 
                }
                else
                {
                    <%
                        if(request.getAttribute("LISTACALIFICACIONES")!=null)
                        {
                            int n=listacali.size();
                            for(int j=1;j<=n;j++){
                    %>
                        
                        var final=document.getElementById('ef<%=j%>').value;
                        if(final!='')
                        {
                            cont2++;
                        }
                                
                    <%
                            }
                        }
                    %>
                    if(cont2==cantidad)
                    {
                        <%
                            if(request.getAttribute("LISTACALIFICACIONES")!=null)
                            {
                                int n=listacali.size();
                                for(int i=1;i<=n;i++){
                        %>   
                                        
                            document.getElementById('ep<%=i%>').disabled=false;
                            document.getElementById('ef<%=i%>').disabled=false;
                        
                        <%
                                }
                            }
                        %>
                        
                        EnlazarRegistro(op,cantidad);
                    }
                    else
                    {
                        alert("Usted debe Ingresar todas las Notas Finales");
                    } 
                }
            }
            
            function Habilitar()
            {
                var semestre=document.getElementById('cboSemestre').value;
                if(semestre=='')
                {
                    <%
                        if(request.getAttribute("LISTACALIFICACIONES")!=null)
                        {
                            int n=listacali.size();
                            for(int i=1;i<=n;i++){
                    %>
                         
                        document.getElementById('ep<%=i%>').disabled=true;
                        document.getElementById('ef<%=i%>').disabled=true;
                    
                    <%
                            }
                        }
                    %>
                }
                else if(semestre=='Primer Periodo')
                {
                    <%
                        if(request.getAttribute("LISTACALIFICACIONES")!=null)
                        {
                            int n=listacali.size();
                            for(int i=1;i<=n;i++){
                    %>
                        
                        document.getElementById('ep<%=i%>').disabled=false;
                        document.getElementById('ef<%=i%>').disabled=true;
                                
                    <%
                            }
                        }
                    %>
                }
                else
                {
                    <%
                        if(request.getAttribute("LISTACALIFICACIONES")!=null)
                        {
                            int n=listacali.size();
                            for(int j=1;j<=n;j++){
                    %>
                        
                        document.getElementById('ep<%=j%>').disabled=true;
                        document.getElementById('ef<%=j%>').disabled=false;
                                
                    <%
                            }
                        }
                    %>
               }
            }
            
            function SalirRegistro(op)
            {
                document.form.action="<%=request.getContextPath()%>/DocenteServlet";
                document.form.method="POST";
                document.form.op.value=op;
                document.form.submit();
            }
            
            function OcultarDiv()
            {
                var div=document.getElementById('DivOc');
                div.style.display="none";
                div.style.visibility="hidden";
            }
            
            function soloNumeros(evt)
            {
                if (window.event) 
                {
                    keynum = evt.keyCode;
             
                } else 
                {
                    keynum = evt.which;
                }
                if ((keynum == 8) || (keynum > 47 && keynum<58))
                    return true;
                else
                    return false;  
            }
            
            function ValidacionCampos(id)
            {
                var num=document.getElementById(id).value;
                
                if(num>20)
                {
                    document.getElementById(id).value="";
                    alert("Calificación Invalida");
                    document.getElementById(id).focus();
                }
            }
            
            function Busqueda(id)
            {
                var codmat=document.form.cboMateria.value;
                var codnivel=document.form.cboNivel.value;
                var codciclo=document.form.cboCiclo.value;
                var numaula=document.form.cboAula.value;
                
                if(codmat==0)
                {
                    alert("Usted debe seleccionar el campo MATERIA");
                    document.form.cboMateria.focus();
                    return;
                }
                else if(codnivel==0)
                {
                    alert("Usted debe seleccionar el campo NIVEL");
                    document.form.cboNivel.focus();
                    return;
                }
                else if(codciclo==0)
                {
                    alert("Usted debe seleccionar el campo CICLO");
                    document.form.cboCiclo.focus();
                    return;
                }
                else if(numaula=="")
                {
                    alert("Usted debe seleccionar el campo AULA");
                    document.form.cboAula.focus();
                    return;
                }
                else
                {
                    <%
                        if(request.getAttribute("LISTACALIFICACIONES")!=null){
                        if(listacali.size()!=0){
                    %>
                        
                        OcultarDiv();
                        var strHTML="";
                        strHTML+="<div class ='DivPrincipalRegistroNotas02'>";
                        strHTML+="<br><br>";
                            
                        strHTML+="<select id='cboSemestre' class='ComboBoxSemestres' onchange='Habilitar()'>";
                            strHTML+="<option value='' selected>--Seleccione Periodo--</option>";
                            strHTML+="<option value='Primer Periodo' >Primer Periodo</option>";
                            strHTML+="<option value='Segundo Periodo' >Segundo Periodo</option>";
                        strHTML+="</select>";
                        strHTML+="<br><br>";
                        
                        strHTML+="<div class='container' style='width: 95%'>";
                        
                        strHTML+="<table cellpadding='10' id='miTabla' class='table table-bordered table-striped' border='2'>";
                            
                       
                                strHTML+="<tr class='Columna1' style='background: lightblue;'>";
                                    strHTML+="<td>Nº Registro</td>";
                                    strHTML+="<td>CODIGO</td>";
                                    strHTML+="<td>ALUMNO</td>";
                                    strHTML+="<td>PARCIAL</td>";
                                    strHTML+="<td>FINAL</td>";
                                    strHTML+="<td>PROMEDIO FINAL</td>";

                                strHTML+="</tr>";
                            
                            <%
                                int i=0;
                                if(request.getAttribute("LISTACALIFICACIONES")!=null)
                                for(CalificacionBEAN obj: listacali){
                                    i++;
                            %>
                                strHTML+="<tr class='Columna1'>";

                                    strHTML+="<td><%=i%></td>";
                                    strHTML+="<td><input type='hidden' id='cod<%=i%>' name='txtCodigo<%=i%>' value='<%=obj.getCodigoEstudiante()%>'><%=obj.getCodigoEstudiante()%></td>"; 
                                    strHTML+="<td><%=obj.getApellidoPaterno()%> <%=obj.getApellidoMaterno()%> <%=obj.getNombre()%></td>";
                                    strHTML+="<td><input  id='ep<%=i%>' type='text' name='txtNParcial<%=i%>' class='TextboxRegistroNotas'  value='<%=obj.getStrNParcial()%>'  maxlength='2' onkeypress='return soloNumeros(event)' onblur='ValidacionCampos(this.id)' placeholder='(0-20)' disabled> </td>";
                                    strHTML+="<td><input  id='ef<%=i%>' type='text' name='txtNFinal<%=i%>'  class='TextboxRegistroNotas' value='<%=obj.getStrNFinal()%>'  maxlength='2' onkeypress='return soloNumeros(event)' onblur='ValidacionCampos(this.id)' placeholder='(0-20)' disabled> </td>";
                                    strHTML+="<td><%=obj.getStrPromFinal()%></td>";


                                strHTML+="</tr>";

                            <%
                                }
                            %>  
                            
                        strHTML+="</table>";
                    strHTML+="</div>";
                        strHTML+="<br><br>";
  
                        strHTML+="<div class='DivPrincipalRegistroNotas02'>";
                            strHTML+="<center>";
                                strHTML+="<table class='TablaPrincipalRegistroNotas03'>";
                                    strHTML+="<tr class='Columna1'>";
                                        strHTML+="<td>";
                                            strHTML+="<center>";
                                                strHTML+="<button type='button' name='btnGuardar' class='botonRegistrar' onclick='GuardarCalificacion(15,<%=listacali.size()%>)' > ";
                                                    strHTML+="<img src='<%=request.getContextPath()%>/imagenes/agregar.png' width='30' height='25'>";
                                                    strHTML+="Guardar";
                                                strHTML+="</button>";
                                            strHTML+="</center>";
                                        strHTML+="</td>";
                                        strHTML+="<td >";
                                            strHTML+="<center>";
                                                strHTML+="<button type='button' class='botonRegistrar' onclick='SalirRegistro(6)'>";
                                                    strHTML+="<img src='<%=request.getContextPath()%>/imagenes/salir.png' width='20' height='20'>";
                                                    strHTML+="Salir";
                                                strHTML+="</button>";
                                            strHTML+="</center>";
                                        strHTML+="</td>";
                                    strHTML+="</tr>";
                                strHTML+="</table>";
                            strHTML+="</center>";
                        strHTML+="</div>";
                        strHTML+="<br><br><br><br>";
                        strHTML+="</div>";
                        
                        document.getElementById(id).innerHTML=strHTML;
                        
                    <%
                        }
                        else
                        {
                    %>
                                
                        alert("No hay registro de alumnos");
                        
                    <%
                        }
                     }
                    %>
                }
            }
        </script>
    </head>
    <body>
        <form name="form">
            <%
                if(session.getAttribute("DATOSUSUARIO")!=null)
                {
            %>
            <input type="hidden" name="op">
            <input type="hidden" name="codusuario" value="<%=usu.getCodigoUsuario()%>">
            <input type="hidden" name="cantidad">
            
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">    
                <%@include file="../../../Menu/FrmMenuDocente.jsp" %>
                <div class="CabeceraMenus">Registro de Notas</div>
            </nav>
                
            <center>
                <div class="DivPrincipalRegistroNotas">
                    <br><br>
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
                    <table class="TablaPrincipalRegistroNotas">
                        <tr class="Columna1">
                            <td>
                                <center>
                                    Materia
                                </center>
                            </td>
                            <td>
                                <center>
                                    Nivel
                                </center>
                            </td>
                            <td>
                                <center>
                                    Ciclo
                                </center>
                            </td>
                            <td>
                                <center>
                                    Aula
                                </center>
                            </td>
                            <td></td>
                        </tr>
                        <tr class="Columna1">
                            <td>
                                <center>
                                    <div>
                                        <select name="cboMateria" class="ComboBoxMateria" onchange="EnlaceComboBox('<%=request.getContextPath()%>','DocenteServlet',11)">

                                            <%
                                                if(request.getAttribute("CODIGOMATERIA")!=null)
                                                {
                                                    codmat=Integer.parseInt(strcodmat);
                                            %>
                                                    <option value=0>--Seleccionar Materia--</option>
                                            <%
                                                if(request.getAttribute("LISTAMATERIAS")!=null)
                                                for(AulaBEAN obj: listadocmat){
                                            %>

                                            <%
                                                if(obj.getCodigoMateria()==codmat)
                                                {

                                            %>

                                            <option value="<%=obj.getCodigoMateria()%>" selected><%=obj.getNomMateria()%></option>

                                            <%
                                                }
                                                else
                                                {

                                            %>

                                            <option value="<%=obj.getCodigoMateria()%>"><%=obj.getNomMateria()%></option>

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
                                                for(AulaBEAN obj: listadocmat){
                                            %>

                                            <option value="<%=obj.getCodigoMateria()%>"><%=obj.getNomMateria()%></option>

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
                                        <select name="cboNivel" class="ComboBoxMateria" onchange="EnlaceComboBox('<%=request.getContextPath()%>','DocenteServlet',12)">

                                            <%
                                                if(request.getAttribute("CODIGONIVEL")!=null)
                                                {
                                                    codniv=Integer.parseInt(strcodniv);
                                            %>
                                                    <option value=0>--Seleccionar Nivel--</option>
                                            <%
                                                if(request.getAttribute("LISTANIVELES")!=null)
                                                for(AulaBEAN obj2: listamatniv){
                                            %>

                                            <%
                                                if(obj2.getCodigoNivel()==codniv)
                                                {

                                            %>

                                            <option value="<%=obj2.getCodigoNivel()%>" selected><%=obj2.getNomNivel()%></option>

                                            <%
                                                }
                                                else
                                                {

                                            %>

                                            <option value="<%=obj2.getCodigoNivel()%>"><%=obj2.getNomNivel()%></option>

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
                                                for(AulaBEAN obj2: listamatniv){
                                            %>

                                            <option value="<%=obj2.getCodigoNivel()%>"><%=obj2.getNomNivel()%></option>

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
                                        <select name="cboCiclo" class="ComboBoxMateria" onchange="EnlaceComboBox('<%=request.getContextPath()%>','DocenteServlet',13)">
                                            
                                            <%
                                                if(request.getAttribute("CODIGOCICLO")!=null)
                                                {
                                                    codcic=Integer.parseInt(strcodcic);
                                            %>
                                                    <option value=0>--Seleccionar Ciclo--</option>
                                            <%
                                                if(request.getAttribute("LISTACICLOS")!=null)
                                                for(AulaBEAN obj3: listadoccic){
                                            %>

                                            <%
                                                if(obj3.getCodigoCiclo()==codcic)
                                                {

                                            %>

                                            <option value="<%=obj3.getCodigoCiclo()%>" selected><%=obj3.getNomCiclo()%></option>

                                            <%
                                                }
                                                else
                                                {

                                            %>

                                            <option value="<%=obj3.getCodigoCiclo()%>"><%=obj3.getNomCiclo()%></option>

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
                                                for(AulaBEAN obj3: listadoccic){
                                            %>

                                            <option value="<%=obj3.getCodigoCiclo()%>"><%=obj3.getNomCiclo()%></option>

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
                                        <select name="cboAula" class="ComboBoxMateria" onchange="EnlaceComboBox('<%=request.getContextPath()%>','DocenteServlet',14)">
                                            
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
                                    <button type="button" name="btnBuscar" class="botonRegistrar" onclick="Busqueda('tabla')">
                                        <img src="<%=request.getContextPath()%>/imagenes/buscar.png" width="20" height="20">    
                                        Buscar
                                    </button>
                                </center>
                            </td>
                        </tr>
                    </table>
                    <div id="tabla"></div>
                    <br><br>
                    <div class="DivPrincipalRegistroNotas02" id="DivOc">
                        <center>
                            <table class="TablaPrincipalRegistroNotas03">
                                <tr class="ColumnaSalirRegistro">
                                    <td >
                                        <center>
                                            <button type="button" class="botonRegistrar" onclick="SalirPrincipal('<%=request.getContextPath()%>','DocenteServlet',6)">
                                                <img src="<%=request.getContextPath()%>/imagenes/salir.png" width="20" height="20">
                                                Salir
                                            </button>
                                        </center>
                                    </td>
                                </tr>
                            </table>
                            <br><br>                    
                        </center>
                    </div>
                    
                </div> 
                
            </center>
            <%
                }
            %>                                    
        </form>
    </body>
</html>

