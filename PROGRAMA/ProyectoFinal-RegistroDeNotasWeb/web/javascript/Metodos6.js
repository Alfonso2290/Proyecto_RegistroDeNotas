
function seleccionarTipoUsuario(controlador,ruta,op)
{
    var tipo=document.form.cbTipoUsu.value;
    
    if(tipo=="")
    {
        alert("Usted debe seleccionar el Tipo de Usuario");
        document.form.cbTipoUsu.focus();
    }

    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
}

function NuevoUsuario(controlador,ruta,op)
{
    var tipo=document.form.cbTipoUsu.value;
    
    if(tipo=="")
    {
        alert("Usted debe seleccionar el Tipo de Usuario");
        document.form.cbTipoUsu.focus();
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

function SalirNuevoRegistro (controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
    document.form.txtTipo.disabled=false;
}

function FocoDNI()
{
    document.form.txtDNI.focus();
}

function GuardarNuevoUsuario (controlador,ruta,op)
{
    var dni=document.form.txtDNI.value;
    var nom1=document.form.txtNom1.value;
    var apepa=document.form.txtApePa.value;
    var apema=document.form.txtApeMa.value;
    var correo=document.form.txtCorreo.value;
    var tel=document.form.txtTel.value;
    var usu=document.form.txtUsu.value;
    var contra=document.form.txtContra.value;
    var contra1=document.form.txtContra1.value;
    
    if(dni.length==0)
    {
        alert("Usted debe rellenar el campo DNI");
        document.form.txtDNI.focus();
        return;
    }
    else if(nom1.length==0)
    {
        alert("Usted debe rellenar el campo Primer Nombre");
        document.form.txtNom1.focus();
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
    else if(usu.length==0)
    {
        alert("Usted debe rellenar el campo Nombre Usuario");
        document.form.txtUsu.focus();
        return;
    }
    else if(contra.length==0)
    {
        alert("Usted debe rellenar el campo Contrasena");
        document.form.txtContra.focus();
        return;
    }
    else if(contra1.length==0)
    {
        alert("Usted debe rellenar el campo Repita Contrasena");
        document.form.txtContra1.focus();
        return;
    }
    else if(contra!=contra1)
    {
        alert("Las contrasenas ingresados no coinciden");
        document.form.txtContra.value="";
        document.form.txtContra1.value="";
        document.form.txtContra.focus();
        return;
    }
    else
    {
        document.form.action=controlador + "/" + ruta;
        document.form.method="POST";
        document.form.op.value=op;
        document.form.txtTipo.disabled=false;
        document.form.submit();
    }
}

function ModificarUsuario(controlador,ruta,op,codusu,dni,nomusu,cont,fecha,tipo,nom1,nom2,apepa,apema,sexo,correo,tel)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.codusu.value=codusu; 
    document.form.dni.value=dni; 
    document.form.nomusu.value=nomusu; 
    document.form.cont.value=cont; 
    document.form.fecha.value=fecha; 
    document.form.tipo.value=tipo; 
    document.form.nom1.value=nom1; 
    document.form.nom2.value=nom2; 
    document.form.apepa.value=apepa; 
    document.form.apema.value=apema; 
    document.form.sexo.value=sexo; 
    document.form.correo.value=correo; 
    document.form.tel.value=tel; 
    document.form.submit();
}

function ModificarRegistroUsuario(controlador,ruta,op)
{
    var nomusu,cont,cont1,nom1,apepa,apema,correo,tel;
    nomusu=document.form.txtUsu.value;
    cont=document.form.txtContra.value;
    cont1=document.form.txtContra1.value;
    nom1=document.form.txtNom1.value;
    apepa=document.form.txtApePa.value;
    apema=document.form.txtApeMa.value;
    correo=document.form.txtCorreo.value;
    tel=document.form.txtTel.value;
    
    if(nom1.length==0)
    {
        alert("Usted debe rellenar el campo Primer Nombre");
        document.form.txtNom1.focus();
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
        alert("Usted debe rellenar el campo Correo");
        document.form.txtCorreo.focus();
        return;
    }
    else if(tel.length==0)
    {
        alert("Usted debe rellenar el campo Telefono");
        document.form.txtTel.focus();
        return;
    }
    else if(nomusu.length==0)
    {
        alert("Usted debe rellenar el campo Usuario");
        document.form.txtUsu.focus();
        return;
    }
    else if(cont.length==0)
    {
        alert("Usted debe rellenar el campo Contrasena");
        document.form.txtContra.focus();
        return;
    }
    else if(cont1.length==0)
    {
        alert("Usted debe rellenar el campo Repita Contrasena");
        document.form.txtContra1.focus();
        return;
    }
    else if(cont!=cont1)
    {
        alert("Las contrasenas ingresados no coinciden");
        document.form.txtContra.value="";
        document.form.txtContra1.value="";
        document.form.txtContra.focus();
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

function EliminarUsuario (controlador,ruta,op,codusu)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.codusu.value=codusu;
    document.form.submit();
}


