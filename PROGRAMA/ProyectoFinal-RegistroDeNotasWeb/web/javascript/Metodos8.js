//
function EnlaceComboBox(controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
}

//
function seleccionarfiltros(controlador,ruta,op)
{
    
    var mat=document.form.cboMateria.value;
    var niv=document.form.cboNivel.value;
    var cic=document.form.cboCiclo.value;
    var numaula=document.form.cboAula.value;
    var doc=document.form.cboDocente.value;
    var moda=document.form.cboModalidad.value;
    
    if(mat==0)
    {
        alert("Usted debe seleccionar la Materia");
        document.form.cboMateria.focus();
    }
    else if(niv==0)
    {
        alert("Usted debe seleccionar el Nivel");
        document.form.cboNivel.focus();
    }
    else if(cic==0)
    {
        alert("Usted debe seleccionar el Ciclo");
        document.form.cboCiclo.focus();
    }
    else if(numaula=="")
    {
        alert("Usted debe seleccionar el Aula");
        document.form.cboAula.focus();
    }
    else if(doc==0)
    {
        alert("Usted debe seleccionar el Docente");
        document.form.cboDocente.focus();
    }
    else if(moda=="")
    {
        alert("Usted debe seleccionar la Modalidad");
        document.form.cboModalidad.focus();
    }
    else
    {
        document.form.action=controlador + "/" + ruta;
        document.form.method="POST";
        document.form.op.value=op;
        document.form.submit();
    }
}
//
function HabilitarCampos()
{
    var cal=document.form.cbCalle.value;
    if(cal!=0)
    {
        document.form.txtDNI.disabled=false;
        document.form.txtNom.disabled=false;
        document.form.txtApePa.disabled=false;
        document.form.txtApeMa.disabled=false;
        document.form.txtFechaNac.disabled=false;
        document.form.txtCorreo.disabled=false;
        document.form.txtTel.disabled=false;
        document.form.txtNumE.disabled=false;
        document.form.txtNumI.disabled=false;
        document.form.cbSexo.disabled=false;
        document.form.txtDNI.focus();
    }
    else
    {
        document.form.txtDNI.disabled=true;
        document.form.txtNom.disabled=true;
        document.form.txtApePa.disabled=true;
        document.form.txtApeMa.disabled=true;
        document.form.txtFechaNac.disabled=true;
        document.form.txtCorreo.disabled=true;
        document.form.txtTel.disabled=true;
        document.form.txtNumE.disabled=true;
        document.form.txtNumI.disabled=true;
        document.form.cbSexo.disabled=true;
    }
}
//
function HabilitarCamposMod()
{
    var cal=document.form.cbCalle.value;
    if(cal!=0)
    {
        document.form.txtNom.disabled=false;
        document.form.txtApePa.disabled=false;
        document.form.txtApeMa.disabled=false;
        document.form.txtFechaNac.disabled=false;
        document.form.txtCorreo.disabled=false;
        document.form.txtTel.disabled=false;
        document.form.txtNumE.disabled=false;
        document.form.txtNumI.disabled=false;
        document.form.cbSexo.disabled=false;
        document.form.txtNom.focus();
    }
    else
    {
        document.form.txtNom.disabled=true;
        document.form.txtApePa.disabled=true;
        document.form.txtApeMa.disabled=true;
        document.form.txtFechaNac.disabled=true;
        document.form.txtCorreo.disabled=true;
        document.form.txtTel.disabled=true;
        document.form.txtNumE.disabled=true;
        document.form.txtNumI.disabled=true;
        document.form.cbSexo.disabled=true;
    }
}
//
function NuevoAlumno(controlador,ruta,op)
{
    var mat,niv,cic,au,doc,mod;
    mat=document.form.cboMateria.value;
    niv=document.form.cboNivel.value;
    cic=document.form.cboCiclo.value;
    au=document.form.cboAula.value;
    doc=document.form.cboDocente.value;
    mod=document.form.cboModalidad.value;
    if(mat==0)
    {
        alert("Usted debe seleccionar la Materia");
        document.form.cboMateria.focus();
        return;
    }
    else if(niv==0)
    {
        alert("Usted debe seleccionar el Nivel");
        document.form.cboNivel.focus();
        return;
    }
    else if(cic==0)
    {
        alert("Usted debe seleccionar el Ciclo");
        document.form.cboCiclo.focus();
        return;
    }
    else if(au==0)
    {
        alert("Usted debe seleccionar el Aula");
        document.form.cboAula.focus();
        return;
    }
    else if(doc==0)
    {
        alert("Usted debe seleccionar el Docente");
        document.form.cboDocente.focus();
        return;
    }
    else if(mod==0)
    {
        alert("Usted debe seleccionar la Modalidad");
        document.form.cboModalidad.focus();
        return;
    }
    else
    {
        document.form.action=controlador + "/" + ruta;
        document.form.method="POST";
        document.form.op.value=op;
        document.form.submit();
    }
    
}

//
function NuevoAlumnoComboBox(controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.cboMateria.disabled=false;
    document.form.cboNivel.disabled=false;
    document.form.cboCiclo.disabled=false;
    document.form.cboAula.disabled=false;
    document.form.cboDocente.disabled=false;
    document.form.cboModalidad.disabled=false;
    document.form.submit();
}
//
function NuevoAlumnoComboBoxMod(controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
}
//
function SalirAlumno (controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
}
//
function FocoDNI()
{
    document.form.txtDNI.focus();
}
//
function GuardarNuevoAlumno (controlador,ruta,op)
{
    
    var dni=document.form.txtDNI.value;
    var nom=document.form.txtNom.value;
    var apepa=document.form.txtApePa.value;
    var apema=document.form.txtApeMa.value;
    var fecha=document.form.txtFechaNac.value;
    var correo=document.form.txtCorreo.value;
    var tel=document.form.txtTel.value;
    var dep=document.form.cbDepartamento.value;
    var pro=document.form.cbProvincia.value;
    var dis=document.form.cbDistrito.value;
    var cal=document.form.cbCalle.value;
    var nume=document.form.txtNumE.value;
    var numi=document.form.txtNumI.value;
    
    if(dep==0)
    {
        alert("Usted debe seleccionar el campo Departamento");
        document.form.cbDepartamento.focus();
        return;
    }
    else if(pro==0)
    {
        alert("Usted debe seleccionar el campo Provincia");
        document.form.cbProvincia.focus();
        return;
    }
    else if(dis==0)
    {
        alert("Usted debe seleccionar el campo Distrito");
        document.form.cbDistrito.focus();
        return;
    }
    else if(cal==0)
    {
        alert("Usted debe seleccionar el campo Calle");
        document.form.cbCalle.focus();
        return;
    }
    else if(dni.length==0)
    {
        alert("Usted debe rellenar el campo DNI");
        document.form.txtDNI.focus();
        return;
    }
    else if(nom.length==0)
    {
        alert("Usted debe rellenar el campo Nombre");
        document.form.txtNom.focus();
        return;
    }
    else if(apepa.length==0)
    {
        alert("Usted debe rellenar el campo Apellido Paterno");
        document.form.txtApePa.focus();
        return;
    }
    else if(apema.length==0)
    {
        alert("Usted debe rellenar el campo Apellido Materno");
        document.form.txtApeMa.focus();
        return;
    }
    else if(correo.length==0)
    {
        alert("Usted debe rellenar el campo Correo ");
        document.form.txtCorreo.focus();
        return;
    }
    else if(tel.length==0)
    {
        alert("Usted debe rellenar el campo Telefono");
        document.form.txtTel.focus();
        return;
    }
    else if(fecha.length==0)
    {
        alert("Usted debe rellenar el campo Fecha de Nacimiento");
        document.form.txtFechaNac.focus();
        return;
    }
    else if(nume.length==0)
    {
        alert("Usted debe rellenar el campo Numero Externo");
        document.form.txtNumE.focus();
        return;
    }
    else if(numi.length==0)
    {
        alert("Usted debe rellenar el campo Numero Interno");
        document.form.txtNumI.focus();
        return;
    }
    else
    {
        document.form.action=controlador + "/" + ruta;
        document.form.method="POST";
        document.form.op.value=op;
        document.form.cboMateria.disabled=false;
        document.form.cboNivel.disabled=false;
        document.form.cboCiclo.disabled=false;
        document.form.cboAula.disabled=false;
        document.form.cboDocente.disabled=false;
        document.form.cboModalidad.disabled=false;
        document.form.submit();
    }
}
//
function ModificarAlumno(controlador,ruta,op,codalu,dni,coddis,coddep,codpro,codcal,nom,apepa,apema,sexo,fecha,correo,tel,NumE,NumI)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.codalu.value=codalu;
    document.form.dni.value=dni;
    document.form.coddis.value=coddis;
    document.form.coddep.value=coddep;
    document.form.codpro.value=codpro;
    document.form.codcal.value=codcal;
    document.form.nom.value=nom;
    document.form.NumI.value=NumI;
    document.form.NumE.value=NumE;
    document.form.fecha.value=fecha;  
    document.form.apepa.value=apepa; 
    document.form.apema.value=apema; 
    document.form.sexo.value=sexo; 
    document.form.correo.value=correo; 
    document.form.tel.value=tel; 
    document.form.submit();
}
//
function ModificarRegistroAlumno(controlador,ruta,op)
{
    var nom=document.form.txtNom.value;
    var apepa=document.form.txtApePa.value;
    var apema=document.form.txtApeMa.value;
    var fecha=document.form.txtFechaNac.value;
    var correo=document.form.txtCorreo.value;
    var tel=document.form.txtTel.value;
    var dep=document.form.cbDepartamento.value;
    var pro=document.form.cbProvincia.value;
    var dis=document.form.cbDistrito.value;
    var cal=document.form.cbCalle.value;
    var nume=document.form.txtNumE.value;
    var numi=document.form.txtNumI.value;
    
    if(dep==0)
    {
        alert("Usted debe seleccionar el campo Departamento");
        document.form.cbDepartamento.focus();
        return;
    }
    else if(pro==0)
    {
        alert("Usted debe seleccionar el campo Provincia");
        document.form.cbProvincia.focus();
        return;
    }
    else if(dis==0)
    {
        alert("Usted debe seleccionar el campo Distrito");
        document.form.cbDistrito.focus();
        return;
    }
    else if(cal==0)
    {
        alert("Usted debe seleccionar el campo Calle");
        document.form.cbCalle.focus();
        return;
    }
    else if(nom.length==0)
    {
        alert("Usted debe rellenar el campo Nombre");
        document.form.txtNom.focus();
        return;
    }
    else if(apepa.length==0)
    {
        alert("Usted debe rellenar el campo Apellido Paterno");
        document.form.txtApePa.focus();
        return;
    }
    else if(apema.length==0)
    {
        alert("Usted debe rellenar el campo Apellido Materno");
        document.form.txtApeMa.focus();
        return;
    }
    else if(correo.length==0)
    {
        alert("Usted debe rellenar el campo Correo ");
        document.form.txtCorreo.focus();
        return;
    }
    else if(tel.length==0)
    {
        alert("Usted debe rellenar el campo Telefono");
        document.form.txtTel.focus();
        return;
    }
    else if(fecha.length==0)
    {
        alert("Usted debe rellenar el campo Fecha de Nacimiento");
        document.form.txtFechaNac.focus();
        return;
    }
    
    else if(nume.length==0)
    {
        alert("Usted debe rellenar el campo Numero Externo");
        document.form.txtNumE.focus();
        return;
    }
    else if(numi.length==0)
    {
        alert("Usted debe rellenar el campo Numero Interno");
        document.form.txtNumI.focus();
        return;
    }
    else
    {
        document.form.action=controlador + "/" + ruta;
        document.form.method="POST";
        document.form.op.value=op;
        document.form.submit();
    }
}
//
function EliminarAlumno (controlador,ruta,op,codalu,dni)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.codalu.value=codalu;
    document.form.dni.value=dni;
    document.form.submit();
}







