/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


var pagina;
pagina=$(document);
pagina.ready(inicial);

function inicial()
{
//    var inicia;
//    inicia=$("#Salud_Ocupacional");
//    inicia.click(inicio);
//    inicio();
//    $(".nav .menu li a#Salud_Ocupacional").addClass("active");
    
    var perfilSegurita;
    perfilSegurita=$("#Perfil_Salud_Ocupacional");
    perfilSegurita.click(PerfilSegu);
}
  
//function inicio()
//{
//    $(".nav .menu li a").removeClass("active");
//    $(this).addClass("active");
//    ListaSegurita();
//    $(".nav .menu li a#Salud_Ocupacional").addClass("active");
//}  
    
function PerfilSegu()
{
    $(".nav .menu li a").removeClass("active");
    $(this).addClass("active");
    Parte_perfil();
    $(".nav .menu li a#Perfil_Salud_Ocupacional").addClass("active");
}



function SerializeToJson(form)
{
    var o = {};
    var a = form;
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}

/*************************************************************************************
**************************************************************************************
******************************* carga del perfil *************************************
**************************************************************************************
**************************************************************************************/

function Parte_perfil()
{
    var request = {"opcionesSalud":"Perfil_Segurita"};
    var jsonobj=JSON.stringify(request);
    $.ajax({
                    data: {adminSalud:jsonobj},
                    dataType: 'json',
                    url: 'Servlet_Salud',
                    type: 'POST',
                    success: function(jsonObject)
                    {
                        cargarDatosPerfil(jsonObject);     
                    },
                    error: function(jsonObject) 
                    {
                        alert('Error al conectar con Servlet_Salud');
                    }
           });
}

function cargarDatosPerfil(jsonObject)
{
    var codigoHTML = '<table width="100%"border="0" cellspacing="2"  bgcolor="#000" >'+
	'<tr >'+
	'<td align="center" style="font-size:20px;color:#fff">Perfil del Usuario "' + jsonObject.nombres + '" </td>'+
	'</tr >'+
	'</table>'+
	'<br/>'+
        '<center>'+
        '<form id="modPerfil">'+
            '<fieldset>'+
            '<table border="0" >'+
                '<tr >'+
                    '<th align="right" style="padding-right:5px;">Nombre</th>'+
                    '<td>'+'<input type="text" class="comboPerfil" name="nombres"  value="' + jsonObject.nombres + '" size="30" maxlength="25" readonly/>'+'</td>'+
                '</tr>'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Nickname</th>'+
                    '<td>'+'<input type="text" class="comboPerfil" name="nickname" value="' + jsonObject.nickname + '" size="30" maxlength="20" readonly/>'+'</td>'+
                '</tr>'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Clave</th>'+
                    '<td>'+'<input type="password" class="comboPerfil" name="clave" value="' + jsonObject.clave + '" size="30" maxlength="30" readonly/>'+ '</td>'+
                '</tr>'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Celular</th>'+
                    '<td>'+'<input type="text" class="comboPerfil" name="celular" value="' + jsonObject.celular + '" size="30" maxlength="10" readonly/>'+ '</td>'+
                '</tr>'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Email</th>'+
                    '<td>'+'<input type="text" class="comboPerfil" name="email" value="' + jsonObject.email + '" size="30" maxlength="40" readonly/>'+ '</td>'+
                '</tr>'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Tipo</th>'+
                    '<td>'+'<input type="" class="comboPerfil" name="tipo"  value="' + jsonObject.tipo + '" size="30" maxlength="20" readonly/>'+ '</td>'+
                '</tr>'+ 
                '<tr>'+
                    '<td colspan="2" rowspan="9" align="right">'+
                        '<div class="foto">'+
                            '<div class="imagen" id="fotoVendedores">'+
                                '<img style="float:right;" src="segurita/'+ jsonObject.foto_perfil +'" id="imaperfil">'+
                            '</div>'+
                        '</div>'+
                    '</td>'+
                '</tr>'+
            '</table>'+
            '</fieldset>'+
            '<td colspan="4" align="center">'+
                '<input type="button" class="button_modificar" name="enviar" value="Modificar" size="30" maxlength="35"  required="required" id="modi" margin-right:100px"></td>'+
        '</form>'+
        '<center>';
$(".content_float4").html(codigoHTML);
$("#modi").click(seccionMPerfil);
cargarFoto();
}

function cargarFoto()
{
    var botonCargarFoto = $("#cargarFoto");
    
    new AjaxUpload(botonCargarFoto, 
    {
        action: 'ServletFoto',
        onSubmit : function(file, ext)
        {
                if (!(ext && /^(jpg|png|jpeg|gif)$/.test(ext)))
                {
                        // extensiones permitidas
                        alert('Error: Solo se permiten imagenes');
                        // cancela upload
                        return false;
                } 
                else 
                {
                        botonCargarFoto.attr("value", "Cargando");
                        this.disable();
                }
        },
        onComplete: function(file, response)
        {
                botonCargarFoto.attr("value", "Cargar Foto");
                // enable upload button
                this.enable();			
                // Agrega archivo a la lista
                var rutaFoto = "segurita/" + file;
                var htmlFoto = '<img src="' + rutaFoto + '" align="center" width="180px">';
                $('#rutaFoto').attr("value",file);
                $('#fotoVendedores').html(htmlFoto);
        }	
    });
}

function seccionMPerfil()
{
    var request = {"opcionesSalud":"Perfil_Segurita"};
    var jsonobj=JSON.stringify(request);
    $.ajax({
                    data: {adminSalud:jsonobj},
                    dataType: 'json',
                    url: 'Servlet_Salud',
                    type: 'POST',
                    success: function(jsonObject)
                    {
                        cargarModificarPerfil(jsonObject);     
                    },
                    error: function(jsonObject) 
                    {
                        alert('Error al conectar con ServletAmbiental');
                    }
           });
}

function cargarModificarPerfil(jsonObject)
{
    var codigoHTML = '<table width="100%"border="0" cellspacing="2"  bgcolor="#000" >'+
	'<tr >'+
	'<td align="center" style="font-size:20px;color:#fff">Perfil del Usuario "' + jsonObject.nombres + '" </td>'+
	'</tr >'+
	'</table>'+
	'<br/>'+
        '<center>'+
        '<form id="modificacionPerfilTecnico1">'+
            '<fieldset>'+
            '<table border="0" >'+
                '<tr >'+
                    '<th align="right" style="padding-right:5px;">Nombre</th>'+
                    '<td>'+'<input type="text" class="comboPerfil" name="nombres" value="' + jsonObject.nombres + '" size="30" maxlength="40" />'+'</td>'+
                '</tr>'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Nickname</th>'+
                    '<td>'+'<input type="text" class="comboPerfil" name="nickname" value="' + jsonObject.nickname + '" size="30" maxlength="20" />'+'</td>'+
                '</tr>'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Clave</th>'+
                    '<td>'+'<input type="text" class="comboPerfil" name="clave" value="' + jsonObject.clave + '" size="30" maxlength="30" />'+ '</td>'+
                '</tr>'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Celular</th>'+
                    '<td>'+'<input type="text" class="comboPerfil" name="celular" value="' + jsonObject.celular + '" size="30" maxlength="10" />'+ '</td>'+
                '</tr>'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Email</th>'+
                    '<td>'+'<input type="text" class="comboPerfil" name="email" value="' + jsonObject.email + '" size="30" maxlength="40" />'+ '</td>'+
                '</tr>'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Tipo</th>'+
                    '<td>'+'<input type="" name="tipo" class="comboPerfil" value="' + jsonObject.tipo + '" size="30" maxlength="20" readonly/>'+ '</td>'+
                '</tr>'+
                '<tr>'+
                    '<td colspan="2" rowspan="9" align="right">'+
                        '<div class="foto">'+
                            '<div class="imagen" id="fotoVendedores">'+
                                '<img src="segurita/'+ jsonObject.foto_perfil + '" align="right" required="required" id="imaperfil" >'+
                            '</div>'+
                            '<div>'+
                                '<input type="button" value="Cargar Foto" class="botonCargaFoto" id="cargarFoto" />'+
                                '<input type="text" value="" name="foto_perfil" id="rutaFoto" />'+
                            '</div>'+   
                        '</div>'+
                    '</td>'+
                '</tr>'+
            '</table>'+
            '</fieldset>'+
            '<table align="center">'+
                '<tr>'+
                    '<td colspan="4" align="center">'+
                        '<input type="button" value="Volver" class="BotonPerfil" id="Cancelarr" />'+
                        '<input type="submit" value="Registrar" class="BotonPerfil" id="Adicionar_datos" />'+
                    '</td>'+
                '</tr>'+
            '</table> '+
        '</form>'+
        '<center>';
$(".content_float4").html(codigoHTML);
$("#modificacionPerfilTecnico1").submit(Elperfil);
$("#Cancelarr").click(Parte_perfil);
cargarFoto();
}

function Elperfil(evento)
{
    evento.preventDefault();
    var datos_formulario = $(this).serializeArray();   
    var datos = JSON.stringify(SerializeToJson(datos_formulario));
    var request = {"opcionesSalud":"ModPerfil","Datos":datos};
    var jsonobj=JSON.stringify(request);
    alert(jsonobj.toString());
    $.ajax({
                    data: {adminSalud:jsonobj},
                    dataType: 'json',
                    url: 'Servlet_Salud',
                    type: 'POST',
                    success: function(jsonObject)
                    {
                        verificarDatosPerfil(jsonObject);     
                    },
                    error: function(jsonObject) 
                    {
                        alert('Error al conectar con Servlet Salud');
                    }
           });
}


function verificarDatosPerfil(jsonObject)
{
    if (jsonObject.ModPerfil  =="true")
    {
        alert("El perfil se modificó correctamente");
    }
    
    else
    {
        alert("El perfil no se pudo modificar");
    } 
    
    Parte_perfil();
}