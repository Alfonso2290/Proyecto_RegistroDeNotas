function ActualizarContrasena(controlador,ruta,op)
{
    var pas=document.form.txtPas.value;
    var pas1=document.form.txtPas1.value;
    var pas2=document.form.txtPas2.value;

    if(pas=="")
    {
        alert("Digite el campo Contraseña Actual");
        document.form.txtPas.focus();
        return;
    }
    else if(pas1=="")
    {
        alert("Digite el campo Nueva Contraseña");
        document.form.txtPas1.focus();
        return;
    }
    else if(pas2=="")
    {
        alert("Digite el campo Repetir Contraseña");
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
        document.form.txtPas1.value="";
        document.form.txtPas2.value="";
        document.form.txtPas1.focus();
        return;
    }
}


