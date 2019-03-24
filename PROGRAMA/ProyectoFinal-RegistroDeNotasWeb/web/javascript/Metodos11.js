

//
function NuevoModulo(controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
}
//
function SalirModulo (controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
}
//
function FocoMateria()
{
    document.form.txtMat.focus();
}
//
function GuardarNuevoModulo (controlador,ruta,op)
{
    var mat=document.form.txtMat.value;
    var niv=document.form.cboNivel.value;
    var cic=document.form.cboCiclo.value;
    
    if(mat.length==0)
    {
        alert("Usted debe rellenar el campo Materia");
        document.form.txtMat.focus();
        return;
    }
    else if(niv.length==0)
    {
        alert("Usted debe seleccionar el campo Nivel");
        document.form.cboNivel.focus();
        return;
    }
    
    else if(cic.length==0)
    {
        alert("Usted debe seleccionar el campo Ciclo");
        document.form.cboCiclo.focus();
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
function EliminarModulo (controlador,ruta,op,codmod)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.codmod.value=codmod;
    document.form.submit();
    
}
