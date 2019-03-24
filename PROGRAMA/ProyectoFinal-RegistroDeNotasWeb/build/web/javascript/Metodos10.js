//
function EnlaceComboBoxAula(controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
}


//
function seleccionarfiltrosAula(controlador,ruta,op)
{
    
    var mat=document.form.cboMateria.value;
    var niv=document.form.cboNivel.value;
    var cic=document.form.cboCiclo.value;
    
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
    else
    {
        document.form.action=controlador + "/" + ruta;
        document.form.method="POST";
        document.form.op.value=op;
        document.form.submit();
    }
}

//
function NuevaAula(controlador,ruta,op)
{
    var mat,niv,cic;
    mat=document.form.cboMateria.value;
    niv=document.form.cboNivel.value;
    cic=document.form.cboCiclo.value;
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
    else
    {
        document.form.action=controlador + "/" + ruta;
        document.form.method="POST";
        document.form.op.value=op;
        document.form.submit();
    }
}
//
function SalirAula (controlador,ruta,op)
{
    document.form.action=controlador + "/" + ruta;
    document.form.method="POST";
    document.form.op.value=op;
    document.form.submit();
}

function FocoAula()
{
    document.form.txtAula.focus();
}
//
function GuardarNuevaAula (controlador,ruta,op)
{
    var numaula=document.form.txtAula.value;
    var coddoc=document.form.cboDocente.value;
    var moda=document.form.cboModalidad.value;
    var horai=document.form.txtHoraI.value;
    var horas=document.form.txtHoraS.value;
    var cupo=document.form.txtCupo.value;
    
    if(numaula.length==0)
    {
        alert("Usted debe rellenar el campo Aula");
        document.form.txtAula.focus();
        return;
    }
    else if(coddoc==0)
    {
        alert("Usted debe seleccionar el campo Docente");
        document.form.cbDocente.focus();
        return;
    }
    else if(moda.length==0)
    {
        alert("Usted debe seleccionar el campo Modalidad");
        document.form.cbModalidad.focus();
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
    else if(cupo.length==0)
    {
        alert("Usted debe rellenar el campo Cupos");
        document.form.txtCupo.focus();
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
        document.form.submit();
    }
}
//
function ModificarAula(controlador,ruta,op,numaula,coddoc,codmod,moda,horai,horas,cupo,nomdoc,apepadoc,apemadoc,codmat,codniv,codcic)
{
    var mat,niv,cic;
    mat=document.form.cboMateria.value;
    niv=document.form.cboNivel.value;
    cic=document.form.cboCiclo.value;
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
    else
    {
        document.form.action=controlador + "/" + ruta;
        document.form.method="POST";
        document.form.op.value=op;
        document.form.coddoc.value=coddoc;
        document.form.numaula.value=numaula;
        document.form.codmod.value=codmod;
        document.form.moda.value=moda;
        document.form.horas.value=horas;
        document.form.horai.value=horai;
        document.form.cupo.value=cupo;
        document.form.nomdoc.value=nomdoc; 
        document.form.apepadoc.value=apepadoc; 
        document.form.apemadoc.value=apemadoc; 
        document.form.codmat.value=codmat; 
        document.form.codniv.value=codniv; 
        document.form.codcic.value=codcic; 
        document.form.submit();
    }
    
}
//
function ModificarRegistroAula(controlador,ruta,op)
{
    var horai=document.form.txtHoraI.value;
    var horas=document.form.txtHoraS.value;
    var cupo=document.form.txtCupo.value;
    
    if(horai.length==0)
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
    else if(cupo.length==0)
    {
        alert("Usted debe rellenar el campo Cupos");
        document.form.txtCupo.focus();
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
        document.form.submit();
    }
}
//
function EliminarAula (controlador,ruta,op,numaula)
{
    var mat,niv,cic;
    mat=document.form.cboMateria.value;
    niv=document.form.cboNivel.value;
    cic=document.form.cboCiclo.value;
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
    else
    {
        document.form.action=controlador + "/" + ruta;
        document.form.method="POST";
        document.form.op.value=op;
        document.form.numaula.value=numaula;
        document.form.submit();
    }
    
}










