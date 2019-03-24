function EnlaceLogin(controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
}
function EnlacePrincipalEstudiante(controlador,ruta,op)
{
    var usu,pas;
    usu=document.form.txtUsu.value;
    pas=document.form.txtPas.value;
    
    if(usu.length==0)
    {
        alert("Rellene el campo Usuario");
        document.form.txtUsu.focus();
        return;
    }
    else if(pas.length==0)
    {
        alert("Rellene el campo Password");
        document.form.txtPas.focus();
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
function EnlacePrincipalPersonal(controlador,ruta,op)
{
    var usu,pas,tipo;
    usu=document.form.txtUsu.value;
    pas=document.form.txtPas.value;
    tipo=document.form.cbTipo.value;
    
    if(tipo.length==0)
    {
        alert("Seleccione el campo Tipo");
        document.form.cbTipo.focus();
        return;
    }
    else if(usu.length==0)
    {
        alert("Rellene el campo Usuario");
        document.form.txtUsu.focus();
        return;
    }
    else if(pas.length==0)
    {
        alert("Rellene el campo Password");
        document.form.txtPas.focus();
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
function EnlaceConfirmarCodigoEstudiante(controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
}
function EnlaceRegistrarEstudiante(controlador,ruta,op)
{
    var cod=document.form.txtCod.value;
    if(cod.length==0)
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
















