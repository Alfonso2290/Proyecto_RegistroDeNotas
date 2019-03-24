function RegistrarUsuario(controlador,ruta,op)
{
    var usu=document.form.txtUsu.value;
    var pas1=document.form.txtPas.value;
    var pas2=document.form.txtPas2.value;

    if(usu.length==0)
    {
        alert("Rellene el campo Usuario");
        document.form.txtUsu.focus();
        return;
    }
    else if(pas1.length==0)
    {
        alert("Rellene el campo Password");
        document.form.txtPas.focus();
        return;
    }
    else if(pas2.length==0)
    {
        alert("Rellene el campo Repetir Password");
        document.form.txtPas2.focus();
        return;
    }
    else if(pas1==pas2)
    {
        document.form.action=controlador + "/" + ruta;
        document.form.method="POST";
        document.form.op.value=op;
        document.form.submit();
    }
    else
    {
        alert("Los Passwords ingresados no coinciden");
        document.form.txtPas.value="";
        document.form.txtPas2.value="";
        document.form.txtPas.focus();
        return;
    }
}
function EnlaceRegistrarPersonal(controlador,ruta,op)
{
    var cod=document.form.txtCod.value;
    var tipo=document.form.cbTipo.value;

    if(tipo.length==0)
    {
        alert("Seleccione el campo Tipo");
        document.form.cbTipo.focus();
        return;
    }
    else if(cod.length==0)
    {
        alert("Rellene el campo Codigo");
        document.form.txtCod.focus();
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
function EnlaceConfirmarCodigoPersonal(controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
}




