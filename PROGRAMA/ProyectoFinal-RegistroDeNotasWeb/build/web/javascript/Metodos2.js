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
function FocoCodigo()
{
    document.form.txtCod.focus();
}
function FocoUsuario()
{
   document.form.txtUsu.focus();
}
function FocoPassword()
{
   document.form.txtPas.focus();
}
function FocoTipo()
{
    document.form.cbTipo.focus();
}


