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
        document.form.txtCargo.disabled=false;
        document.form.txtHoraI.disabled=false;
        document.form.txtHoraS.disabled=false;
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
        document.form.txtCargo.disabled=true;
        document.form.txtHoraI.disabled=true;
        document.form.txtHoraS.disabled=true;
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
        document.form.txtCargo.disabled=false;
        document.form.txtHoraI.disabled=false;
        document.form.txtHoraS.disabled=false;
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
        document.form.txtCargo.disabled=true;
        document.form.txtHoraI.disabled=true;
        document.form.txtHoraS.disabled=true;
        document.form.txtFechaNac.disabled=true;
        document.form.txtCorreo.disabled=true;
        document.form.txtTel.disabled=true;
        document.form.txtNumE.disabled=true;
        document.form.txtNumI.disabled=true;
        document.form.cbSexo.disabled=true;
    }
}
//
function NuevoPersonal(controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
}
//
function SalirPersonal (controlador,ruta,op)
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
function GuardarNuevoPersonal (controlador,ruta,op)
{
    var dni=document.form.txtDNI.value;
    var nom=document.form.txtNom.value;
    var apepa=document.form.txtApePa.value;
    var apema=document.form.txtApeMa.value;
    var cargo=document.form.txtCargo.value;
    var horai=document.form.txtHoraI.value;
    var horas=document.form.txtHoraS.value;
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
    else if(cargo.length==0)
    {
        alert("Usted debe rellenar el campo Cargo");
        document.form.txtCargo.focus();
        return;
    }
    else if(horai.length==0)
    {
        alert("Usted debe rellenar el campo Hora Ingreso");
        document.form.txtHoraI.focus();
        return;
    }
    else if(horas.length==0)
    {
        alert("Usted debe rellenar el campo Hora Salida");
        document.form.txtHoraS.focus();
        return;
    }
    else if(fecha.length==0)
    {
        alert("Usted debe rellenar el campo Fecha de Nacimiento");
        document.form.txtFechaNac.focus();
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
function ModificarPersonalAdm(controlador,ruta,op,codper,dni,horaI,horaS,cargo,coddis,coddep,codpro,codcal,nom,apepa,apema,sexo,fecha,correo,tel,NumE,NumI)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.codper.value=codper;
    document.form.dni.value=dni; 
    document.form.horaI.value=horaI;
    document.form.horaS.value=horaS;
    document.form.cargo.value=cargo;
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
function ModificarRegistroPersonalAdm(controlador,ruta,op)
{
    var nom=document.form.txtNom.value;
    var apepa=document.form.txtApePa.value;
    var apema=document.form.txtApeMa.value;
    var cargo=document.form.txtCargo.value;
    var horai=document.form.txtHoraI.value;
    var horas=document.form.txtHoraS.value;
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
    else if(cargo.length==0)
    {
        alert("Usted debe rellenar el campo Cargo");
        document.form.txtCargo.focus();
        return;
    }
    else if(horai.length==0)
    {
        alert("Usted debe rellenar el campo Hora Ingreso");
        document.form.txtHoraI.focus();
        return;
    }
    else if(horas.length==0)
    {
        alert("Usted debe rellenar el campo Hora Salida");
        document.form.txtHoraS.focus();
        return;
    }
    else if(fecha.length==0)
    {
        alert("Usted debe rellenar el campo Fecha de Nacimiento");
        document.form.txtFechaNac.focus();
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
function EliminarPersonal (controlador,ruta,op,codper,dni)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.codper.value=codper;
    document.form.dni.value=dni;
    document.form.submit();
}




