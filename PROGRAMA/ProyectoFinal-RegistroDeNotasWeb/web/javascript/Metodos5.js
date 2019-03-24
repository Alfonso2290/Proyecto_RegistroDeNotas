function ModificarUsuario(controlador,ruta,op)
{
    var usu=document.form.txtUsu.value;
    var nom1=document.form.txtNom1.value;
    var apepa=document.form.txtApePa.value;
    var apema=document.form.txtApeMa.value;
    var tel=document.form.txtTele.value;
    var correo=document.form.txtCorreo.value;

    if(usu.length==0)
    {
        alert("Es necesario que llene el campo NOMBRE DE USUARIO");
        document.form.txtUsu.focus();
        return;
    }
    else if(nom1.length==0)
    {
        alert("El campo PRIMER NOMBRE esta vacio");
        document.form.txtNom1.focus();
        return;
    }
    else if(apepa.length==0)
    {
        alert("El campo APELLIDO PATERNO esta vacio");
        document.form.txtApePa.focus();
        return;
    }
    else if(apema.length==0)
    {
        alert("El campo APELLIDO MATERNO esta vacio");
        document.form.txtApeMa.focus();
        return;
    }
    else if(tel.length==0)
    {
        alert("El campo TELEFONO esta vacio");
        document.form.txtTele.focus();
        return;
    }
    else if(correo.length==0)
    {
        alert("El campo CORREO esta vacio");
        document.form.txtCorreo.focus();
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




