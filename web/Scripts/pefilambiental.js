/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var pagina;
pagina=$(document);
pagina.ready(inicial);

function inicial()
{
    var unico;
    unico=$("#TPAmbiental");
    unico.click(iniciar);
    iniciar();
    $(".nav .menu li a#TPAmbiental").addClass("active");
    
    var perfilA;
    perfilA=$("#Perfil_ambiental");
    perfilA.click(CAPerfil);
}
    
    
function iniciar()
{
    $(".nav .menu li a").removeClass("active");
    $(this).addClass("active");
    ListaAmbiental();
    $(".nav .menu li a#TPAmbiental").addClass("active");
}

function CAPerfil()
{
    $(".nav .menu li a").removeClass("active");
    $(this).addClass("active");
    Parte_perfil();
    $(".nav .menu li a#Perfil_ambiental").addClass("active");
}

//**********************************************************************************
//**********************************************************************************
//*************                                                *********************
//*************  FUNCIONES PARA CREAR Y ACTIVAR EVENTOS        *********************
//*************  EN LOS TABERS DE LA APLICACION                *********************
//*************                                                *********************
//**********************************************************************************
//**********************************************************************************

function IniciarTabers()
{
    $(".tab_content").hide();
    $("ul.tabs li:first").addClass("active").show();
    $(".tab_content:first").show();

    $("ul.tabs li").click(function()
    {
        $("ul.tabs li").removeClass("active");
        $(this).addClass("active");
        $(".tab_content").hide();

        var activeTab = $(this).find("a").attr("href");
        $(activeTab).show();

        return false;
    });
}


/*************************************************
/* esta funcion iniciliza el listado de Ambiental*
/*************************************************/
function ListaAmbiental() 
{
    var request = {"opcionesadmin":"Lista"};
    var jsonobj=JSON.stringify(request);
    alert(jsonobj.toString());
    $.ajax({
    data: {administrador:jsonobj},
                  dataType: 'json',
                  url: 'Servlet_Ambiental',
                  type: 'POST',
                  success: function(jsonArray)
                  {
                     CargaLista(jsonArray);     
                  },
                  error: function(jsonArray) 
                  {
                     alert('Error al conectar con Servlet');
                  }
            });
}

function CargaLista(jsonArray)
{
    alert("json Array muestra las tablas primarias");
    var codigoHTML = '<div class="titulodelamatriz">Matriz</div>'+
                            '<div class="cargalamatriz">'+
                                '<tr>'+
                                    '<th colspan="1" align="center"><img src="Imagenes/excel.png" title="Adicionar" id="AGregarUsuario01" /></th>'+
                                    '<th colspan="1"><a href="ServletsReportesPDF?informe=ListadoUsuarios"><img src="Imagenes/PDF.png" title="Generar Informe" id="GenerarReporte" /></a></th>'+     
                                '</tr>'+
                                '<table class="cargalamatriz"'+
                                 '<table cellpadding="0" border="0" width="100%">'+
                                    '</tr>'+
                                        '<th colspan="3" align="center"><img src="Imagenes/adicionar.png" title="Adicionar" id="AGregarDatos" /></th>'+
                                        '<th align="center">N°</th>'+
                                        '<th align="center">Ambientes</th>'+
                                        '<th align="center">Responsable</th>'+
                                        '<th align="center">Proceso De Acuerdo</th>'+
                                        '<th align="center">Actividad que genera el Impacto</th>'+
                                        '<th align="center">Fecha De Ingreso</th>'+
                                        '<th align="center">Descripcion Del Impacto Ambiental</td>'+
                                        
                                     '</tr>';
   for (var i = 0; i < jsonArray.length; i++)
    {
           if (i % 2 == 0)
                codigoHTML+=               '<tr>';
           else
                codigoHTML+=               '<tr class="even" bgcolor="#238376">';
                           
            codigoHTML+=                            '<td colspan="1" ><img src="Imagenes/modificar.png" title="Modificar" class="modificardatos" id="' + jsonArray[i].ambientalarea0 + '" /></td>'+
                                                    '<td colspan="1" ><img src="Imagenes/eliminar.png" title="Eliminar" class="eliminardatos" id="' + jsonArray[i].ambientalarea0 + '" /></td>'+
                                                    '<td colspan="1" ><img src="Imagenes/b_search1.png" title="Visualizar" class="visualizardatos" id="' + jsonArray[i].ambientalarea0 + '" /></td>';
           codigoHTML+=                             '<td>' + jsonArray[i].ambientalarea0 +'</td>';
            codigoHTML+=                            '<td>' + jsonArray[i].ambientalarea1 + '</td>'; 
            codigoHTML+=                            '<td>' + jsonArray[i].ambientalarea2 + '</td>';  
            codigoHTML+=                            '<td>' + jsonArray[i].ambientalarea3 + '</td>'; 
            codigoHTML+=                            '<td>' + jsonArray[i].ambientalarea4 + '</td>';
            codigoHTML+=                            '<td>' + jsonArray[i].ambientalarea6 + '</td>';
            codigoHTML+=                     '</tr>';
}
            codigoHTML+=                '</table>'+
//                                        
                                    '</div>';
//                                        
    $(".content_float4").html(codigoHTML);
    $("#AGregarDatos").click(cargaAllcombobox);
//    $(".visualizardatos").click(visualizarMatriz);
//    $(".eliminardatos").click(Borrar_matriz);
//    $(".modificardatos").click(DatosModificar_Matriz);

}


/*******************************************************
/*********************Agrega datos *********************
/*******************************************************/

function cargaAllcombobox() /* esta funcion iniciliza el listado de Ambiental*/
{
    var request = {"opcionesadmin":"combobox"};
    var jsonobj=JSON.stringify(request);
    alert(jsonobj.toString());
    $.ajax({
    data: {administrador:jsonobj},
              dataType: 'json',
              url: 'Servlet_Ambiental',
              type: 'POST',
              success: function(jsonArray)
              {
                AGregarDatosfuncion(jsonArray);     
              },
              error: function(jsonArray) 
              {
                alert('Error al conectar con Servlet');
              }
          });
}

function AGregarDatosfuncion(jsonArray)
{   
       alert("AGregarDatosfuncion");
       var codigoHTML ='<div class="encabezado2">Adicionar Matriz </div>'+
                    '<div class="tabla">'+
                        '<ul class="tabs">'+
                            '<li><a href="#Personal">Personal</a></li>'+
                            '<li><a href="#Laboral">Laboral</a></li>'+
                            '<li><a href="#Laborals">Laboral</a></li>'+
                        '</ul>'+

                        '<form id="form_crear_usuario">'+                
                                '<div class="tab_container">'+   
                                '<div id="Personal" class="tab_content">'+
                                    '<table align="center" border="0" align="left">'+
                                       '<tr>'+
                                            '<th align="right" style="padding-right:5px;"></th>'+
                                            '<td><input name="id_numero" type="hidden" required="required" value="" size="30" maxlength="100" /></td>'+
                                        '</tr>'+
                                        '<tr>'+
                                            '<th align="right" style="padding-right:5px;">NOMBRE DEL AMBIENTE</th>'+
                                            '<td>'+
                                                '<select name="cod_ambiente" id="listadoZonas" >'+
                                                     '<option ></option>'+
                                                '</select>'+
                                            '</td>'+
                                        '</tr>'+
                                        '<tr>'+
                                            '<th align="right" style="padding-right:5px;">RESPONSABLE DEL DILIGENCIAMIENTO</th>'+
                                            '<td>'+
                                                  '<select name="id_usuarios" id="listadoresponsables" >'+
                                                     '<option ></option>'+
                                                 '</select>'+
                                            '</td>'+
                                        '</tr>'+
                                        '<tr>'+
                                            '<th align="right" style="padding-right:5px;">PROCESO DE ACUERDO A LA CADENA DE VALOR DEL SENA</th>'+
                                            '<td>'+
                                                '<select name="proceso" id="listadoproceso">'+
                                                      '<option value=""></option>'+
                                                '</select>'+
                                            '</td>'+
                                        '</tr>'+
                                        '<tr>'+
                                            '<th align="right" style="padding-right:5px;">ACTIVIDAD QUE GENERA EL IMPACTO</th>'+
                                            '<td><input type="text" class="combo_box" name="actividad" value="" maxlength="100" required="required" /></td>'+
                                        '</tr>'+
                                        '<tr>'+
                                            '<th align="right" style="padding-right:5px;">FECHA DE INGRESO</th>'+
                                            '<td><input type="text" name="fecha_de_ingreso" id="date_field13" value=""  /></td>'+
                                        '</tr>'+
                                        '<tr>'+
                                                '<th align="right" style="padding-right:5px;">ASPECTO AMBIENTAL</th>'+
                                                '<td>'+
                                                    '<select name="id_aspecto" id="listadoASPECTO">'+
                                                         '<option value=""></option>'+
                                                    '</select>'+
                                                '</td>'+
                                        '</tr>'+
                                        '<tr>'+
                                            '<th align="right" style="padding-right:5px;">DESCRIPCIÓN DEL ASPECTO AMBIENTAL</th>'+
                                            '<td><input type="text" class="combo_box" name="descripcion_del_aspecto" value="" maxlength="100" required="required" /></td>'+
                                        '</tr>'+
                                        '<tr>'+
                                            '<th align="right" style="padding-right:5px;">IMPACTO AMBIENTAL</th>'+
                                            '<td>'+
                                              '<select name="id_impacto" id="listadoimpacto" >'+
                                                       '<option value="1"></option>'+
                                               '</select>'+
                                            '</td>'+
                                        '</tr>'+
                                        '<tr>'+
                                            '<th align="right" style="padding-right:5px;">DESCRIPCIÓN DEL IMPACTO AMBIENTAL</th>'+
                                            '<td><input type="text" class="combo_box" name="descripcion_del_impacto" value="" maxlength="100" required="required" /></td>'+
                                        '</tr>'+
                                        '<tr>'+
                                            '<th align="right" style="padding-right:5px;">LEGISLACIÓN AMBIENTAL ASOCIADA (tipo, número y fecha de expedición)</th>'+
                                            '<td><input type="text" class="combo_box" name="legislacion" value="" maxlength="100" required="required" /></td>'+
                                        '</tr>'+
                                        '<tr>'+
                                            '<th align="right" style="padding-right:5px;">CUMPLE CON LA LEGISLACIÓN</th>'+
                                            '<td>'+
                                                '<select name="cumple_legislacion" >'+
                                                    '<option value=""></option>'+
                                                    '<option value="Cumple">Cumple</option>'+
                                                    '<option value="No Cumple">No Cumple</option>'+  
                                                '</select>'+
                                            '</td>'+
                                        '</tr>'+
                                    '</table>'+
                                '</div>'+
                                '<div id="Laboral" class="tab_content">'+
                                  '<table>'+
                                    '<tr>'+
                                        '<th align="right" style="padding-right:5px;">Naturaleza</th>'+
                                        '<td>'+
                                            '<select name="naturaleza" id="naturaleza" >'+
                                                '<option value=""></option>'+
                                                '<option value="+">+</option>'+
                                                '<option value="-">-</option>'+  
                                            '</select>'+
                                        '</td>'+    
                                        '<th align="right" style="padding-right:5px;">Extensión</th>'+
                                        '<td>'+
                                            '<select name="idextencion" id="extensión" >'+
                                            '</select>'+
                                        '</td>'+
                                    '</tr>'+
                                    '<tr>'+
                                        '<th align="right" style="padding-right:5px;">Persistencia</th>'+
                                        '<td>'+
                                            '<select name="idpersistencia" id="persistencia" >'+
                                            '</select>'+
                                        '</td>'+
                                        '<th align="right" style="padding-right:5px;">Sinergia</th>'+
                                        '<td>'+
                                            '<select name="idsinergia" id="sinergia" >'+
                                            '</select>'+
                                        '</td>'+
                                    '</tr>'+
                                    '<tr>'+
                                        '<th align="right" style="padding-right:5px;">Efecto</th>'+
                                        '<td>'+
                                            '<select name="idefecto" id="efecto" >'+
                                            '</select>'+
                                        '</td>'+
                                        '<th align="right" style="padding-right:5px;">Recuperabilidad</th>'+
                                        '<td>'+
                                            '<select name="idrecuperabilidad" id="recuperabilidad" >'+
                                            '</select>'+
                                        '</td>'+
                                    '</tr>'+
                                    '<tr>'+
                                        '<th align="right" style="padding-right:5px;">Intensidad</th>'+
                                        '<td>'+
                                            '<select name="idintensidad" id="intensidad">'+
                                            '</select>'+
                                        '</td>'+
                                        '<th align="right" style="padding-right:5px;">Momento</th>'+
                                        '<td>'+
                                            '<select name="idmomento" id="momento" >'+
                                            '</select>'+
                                        '</td>'+
                                    '</tr>'+
                                    '<tr>'+
                                        '<th align="right" style="padding-right:5px;">Reversibilidad</th>'+
                                        '<td>'+
                                            '<select name="idreversibilidad" id="reversibilidad">'+
                                            '</select>'+
                                        '</td>'+
                                        '<th align="right" style="padding-right:5px;">Acumulación</th>'+
                                        '<td>'+
                                            '<select name="idacumulacion" id="acumulacion">'+
                                            '</select>'+
                                        '</td>'+
                                    '</tr>'+
                                    '<tr>'+
                                        '<th align="right" style="padding-right:5px;">Periodicidad</th>'+
                                        '<td>'+
                                            '<select name="idperiodicidad" id="periodicidad" >'+
                                            '</select>'+
                                        '</td>'+
                                    '</tr>'+
                                    '<tr>'+
                                        '<td>'+
                                             '<input type="button" value="Calcular" class="button_cacular" id="Id_calcularDatos" />'+
                                        '</td>'+
                                    '</tr>'+
                                  '</table>'+
                                '</div>'+
                                '<div id="Laborals" class="tab_content">'+
                                  '<table>'+ 
                                    '<tr>'+
                                        '<th align="right" style="padding-right:5px;">IMPORTANCIA</th>'+
                                        '<td><input type="text" class="combo_box" name="importancia" id="importancia" value="" required="required" /></td>'+
                                        '<th align="right" style="padding-right:5px;">CLASIFICACIÓN</th>'+
                                        '<td><input type="text" class="combo_box" name="clasificacion" id="clasificacion" value="" required="required" /></td>'+
                                    '</tr>'+
                                    '<tr>'+
                                        '<td colspan="4" align="left">'+'OBSERVACIÓN:<br>'+
                                                '<textarea name="observacion" cols="74" rows="6" required="required" ></textarea>'+
                                        '</td>'+
                                    '</tr>'+       
                                  '</table>'+
                                '</div>'+
                            '</div>'+

                            '<br>'+
                            '<table align="center">'+
                                '<tr>'+
                                  '<td colspan="4" align="center">'+
                                      '<input type="button" value="Volver"  id="AddVendedor" />'+
                                      '<input type="submit" value="Registrar" id="AddVendedor" />'+
                                  '</td>'+
                                '</tr>'+
                            '</table> '+      
                        '</form>'+
                    '</div>';
                               
   $(".content_float4").html(codigoHTML);
   IniciarTabers();
//   $("#form_crear_usuario").submit(enviarAgreDatos);
//   $("#Id_calcularDatos").click(Id_calcularDatos);
   $("#volverAmatriz").click(ListaAmbiental);
   
   $('#date_field13').datepick({yearRange: '1980:2050'});
   $('#date_field13').datepick('option', {dateFormat: $.datepick.ATOM});
   /*cargarZonas(jsonArray[0]);
   cargaresponsables(jsonArray[1]);
   cargaproceso(jsonArray[2]);
   cargaaspecto(jsonArray[3]);
   cargaimpacto(jsonArray[4]);
   cargarExtencion(jsonArray[5]);
   cargarPersist(jsonArray[6]);
   cargarsinergia(jsonArray[7]);
   cargarefecty(jsonArray[8]);
   cargarecupera(jsonArray[9]);
   cargaintenci(jsonArray[10]);
   cargamomento(jsonArray[11]);
   cargareversi(jsonArray[12]);
   cargaacumula(jsonArray[13]);
   //cargaperiod(jsonArray[14]);*/
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

function Id_calcularDatos(evento)
{
    var extension = parseInt($('#extensión').val());
    var persistencia = parseInt($('#persistencia').val());
    var sinergia = parseInt($('#sinergia').val());
    var efecto = parseInt($('#efecto').val());
    var recuperabilidad = parseInt($('#recuperabilidad').val());
    var intensidad = parseInt($('#intensidad').val());
    var momento = parseInt($('#momento').val());
    var reversibilidad = parseInt($('#reversibilidad').val());
    var acumulacion = parseInt($('#acumulacion').val());
    var periodicidad = parseInt($('#periodicidad').val());
    
    var importancia = 3*intensidad+2*extension+sinergia+efecto+recuperabilidad+momento+reversibilidad+acumulacion+periodicidad+persistencia;
    var clasificacion;
    alert(importancia);
    
    if (importancia <= 25)
    {
        clasificacion = "Baja";
    }
    else
    {
        if (importancia > 25 && importancia <= 50)
        {
            clasificacion = "Media";
        }
        
        else
        {
            if (importancia > 50 && importancia <= 75)
            {
                clasificacion = "Alta";
            }
            
            else
            {
                clasificacion = "Muy Alta";
            }
        }
    }
    
    $('#importancia').attr('value', importancia);
    $('#clasificacion').attr('value', clasificacion);
}


function enviarAgreDatos(evento)
{
    evento.preventDefault();
    var datos_form = $(this).serializeArray();   
    var datos = JSON.stringify(SerializeToJson(datos_form));
    alert(datos.toString());
    var request = {"opcionesadmin":"AgregarMatriz","Datos":datos};
    var jsonobj=JSON.stringify(request);
    alert(jsonobj.toString());
    
    $.ajax({        
                    data: {administrador:jsonobj},
                    type: 'POST',
                    dataType: 'json',
                    url: 'Servlet_Ambiental',
                    success: function(jsonObj)
                    {
                        verificacionDeDatos(jsonObj);
                    },
                    error: function() 
                    {
                        alert('Error al conectar con el servidor');
                    }
                });
}

function verificacionDeDatos(jsonObj)
{
    if (jsonObj.AgregarMatriz  =="true")
    {
        alert("Se Agrego correctamente el Dato A la Matriz");
    }
    
    else
    {
        alert("No Se Agregar El Dato A la Matriz");
    }   
    
    ListaAmbiental();
}

function cargarZonas(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var j = 0; j < jsonArray.length; j++)
    {
        codigoHTML += '<option value="'+ jsonArray[j].cod_ambiente +'">'+ jsonArray[j].ambientes +'</option>';
    }
    
    $('#listadoZonas').html(codigoHTML);  
}
//
function cargaresponsables(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var k = 0; k < jsonArray.length; k++)
    {
        codigoHTML += '<option value="'+ jsonArray[k].id_usuarios +'">'+ jsonArray[k].nombres +'</option>';
    }
    
    $('#listadoresponsables').html(codigoHTML);  
}
//
function cargaproceso(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var t = 0; t < jsonArray.length; t++)
    {
        codigoHTML += '<option value="'+ jsonArray[t].id_proceso +'">'+ jsonArray[t].proceso +'</option>';
    }
    
    $('#listadoproceso').html(codigoHTML);  
}
//
function cargaaspecto(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var f = 0; f < jsonArray.length; f++)
    {
        codigoHTML += '<option value="'+ jsonArray[f].id_aspecto +'">'+ jsonArray[f].aspecto +'</option>';
    }
    
    $('#listadoASPECTO').html(codigoHTML);  
}
//
function cargaimpacto(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var a = 0; a < jsonArray.length; a++)
    {
        codigoHTML += '<option value="'+ jsonArray[a].id_impacto +'">'+ jsonArray[a].impacto_ambiental +'</option>';
    }
    
    $('#listadoimpacto').html(codigoHTML);  
}
//
function cargarExtencion(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var p = 0; p < jsonArray.length; p++)
    {
        codigoHTML += '<option value="'+ jsonArray[p].idextencion +'">'+ jsonArray[p].extencion +'</option>';
    }
    
    $('#extensión').html(codigoHTML);  
}

function cargarPersist(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var h = 0; h < jsonArray.length; h++)
    {
        codigoHTML += '<option value="'+ jsonArray[h].idpersistencia +'">'+ jsonArray[h].persistencia +'</option>';
    }
    
    $('#persistencia').html(codigoHTML);  
}

function cargarsinergia(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var e = 0; e < jsonArray.length; e++)
    {
        codigoHTML += '<option value="'+ jsonArray[e].idsinergia +'">'+ jsonArray[e].sinergia +'</option>';
    }
    
    $('#sinergia').html(codigoHTML);  
}

function cargarefecty(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var ñ = 0; ñ < jsonArray.length; ñ++)
    {
        codigoHTML += '<option value="'+ jsonArray[ñ].idefecto +'">'+ jsonArray[ñ].efecto +'</option>';
    }
    
    $('#efecto').html(codigoHTML);  
}

function cargarecupera(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var f = 0; f < jsonArray.length; f++)
    {
        codigoHTML += '<option value="'+ jsonArray[f].idrecuperabilidad +'">'+ jsonArray[f].recuperabilidad +'</option>';
    }
    
    $('#recuperabilidad').html(codigoHTML);  
}


function cargaintenci(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var g = 0; g < jsonArray.length; g++)
    {
        codigoHTML += '<option value="'+ jsonArray[g].idintensidad +'">'+ jsonArray[g].intensidad +'</option>';
    }
    
    $('#intensidad').html(codigoHTML);  
}

function cargamomento(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var tt = 0; tt < jsonArray.length; tt++)
    {
        codigoHTML += '<option value="'+ jsonArray[tt].idmomento +'">'+ jsonArray[tt].momento +'</option>';
    }
    
    $('#momento').html(codigoHTML);  
}

function cargareversi(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var rr = 0; rr < jsonArray.length; rr++)
    {
        codigoHTML += '<option value="'+ jsonArray[rr].idreversibilidad +'">'+ jsonArray[rr].reversibilidad +'</option>';
    }
    
    $('#reversibilidad').html(codigoHTML);  
}

function cargaacumula(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var pp = 0; pp < jsonArray.length; pp++)
    {
        codigoHTML += '<option value="'+ jsonArray[pp].idacumulacion +'">'+ jsonArray[pp].acumulacion +'</option>';
    }
    
    $('#acumulacion').html(codigoHTML);  
}


function cargaperiod(jsonArray)
{
    var codigoHTML =  '<option value="null"></option>';
    for (var kk = 0; kk < jsonArray.length; kk++)
    {
        codigoHTML += '<option value="'+ jsonArray[kk].idperiodicidad +'">'+ jsonArray[kk].periodicidad +'</option>';
    }
    
    $('#periodicidad').html(codigoHTML);  
}


///*************************************************************************************
//**************************************************************************************
//******************************* carga del perfil *************************************
//**************************************************************************************
//**************************************************************************************/
//
function Parte_perfil()
{
    var request = {"opcionesadmin":"Perfil_Ambientalito"};
    var jsonobj=JSON.stringify(request);
    $.ajax({
                    data: {administrador:jsonobj},
                    dataType: 'json',
                    url: 'Servlet_Ambiental',
                    type: 'POST',
                    success: function(jsonObject)
                    {
                        cargarDatosPerfil(jsonObject);     
                    },
                    error: function(jsonObject) 
                    {
                        alert('Error al conectar con ServletAmbiental');
                    }
           });
}

function cargarDatosPerfil(jsonObject)
{
    var codigoHTML = '<table width="100%"border="0" cellspacing="2"  bgcolor="#000" >'+
	'<tr >'+
	'<td align="center" style="font-size:20px;color:#fff">Perfil del Usuario ' + jsonObject.nombres + ' </td>'+
	'</tr >'+
	'</table>'+
	'<br/>'+
        '<center>'+
        '<form id="modPerfil">'+
            '<fieldset>'+
            '<table border="0">'+
                '<tr align="left" style="padding-right:15px;">'+
                    '<th align="right" style="padding-right:15px;">Nombres</th>'+
                    '<td>'+'<input type="text" name="nombres" class="comboPerfil" value="' + jsonObject.nombres + '" size="30" maxlength="25" readonly/>'+'</td>'+
                 '</tr>'+
                 '<tr align="left" >'+
                    '<th align="right" style="padding-right:15px;">Nickname</th>'+
                    '<td>'+'<input type="text" class="comboPerfil" name="nickname" value="' + jsonObject.nickname + '" size="30" maxlength="20" readonly/>'+'</td>'+
                '</tr>'+
                '<tr align="left" >'+
                    '<th align="right" style="padding-right:15px;">Clave</th>'+
                    '<td>'+'<input type="password" class="comboPerfil" name="clave" value="' + jsonObject.clave + '" size="30" maxlength="30" readonly/>'+ '</td>'+
                '</tr>'+
                '<tr align="left" >'+
                    '<th align="right" style="padding-right:15px;">Celular</th>'+
                    '<td>'+'<input type="text" class="comboPerfil" name="celular" value="' + jsonObject.celular + '" size="30" maxlength="10" readonly/>'+ '</td>'+
                '</tr>'+
                '<tr align="left" >'+
                    '<th align="right" style="padding-right:15px;">Email</th>'+
                    '<td>'+'<input type="text" class="comboPerfil" name="email" value="' + jsonObject.email + '" size="30" maxlength="40" readonly/>'+ '</td>'+
                '</tr>'+
                '<tr align="left" >'+
                    '<th align="right" style="padding-right:15px;">Tipo</th>'+
                    '<td>'+'<input type="" name="tipo" class="comboPerfil" value="' + jsonObject.tipo + '" size="30" maxlength="20" readonly/>'+ '</td>'+
                '</tr>'+
//                '<form id="form_enviar_foto"  enctype="multipart/form-data">'+
                    '<tr">'+
                        '<td colspan="2" rowspan="9" align="right">'+
                            '<div class="foto">'+
                                '<div class="imagen" id="fotoVendedores">'+
                                    '<img style="float:right;" src="segurita/' + jsonObject.foto_perfil + '" id="imaperfil" >'+
                                '</div>'+
                            '</div>'+
                        '</td>'+
                    '</tr>'+
                '</form>'+
            '</table>'+
            '</fieldset>'+
            '<td colspan="4" align="center">'+
                '<input type="button" class="botonPerfils" name="enviar" value="Modificar" size="30" maxlength="35"  required="required" id="modi" margin-right:100px"></td>'+
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
    var request = {"opcionesadmin":"Perfil_Ambientalito"};
    var jsonobj=JSON.stringify(request);
    $.ajax({
                    data: {administrador:jsonobj},
                    dataType: 'json',
                    url: 'Servlet_Ambiental',
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
	'<td align="center" style="font-size:20px;color:#fff">Perfil del Usuario ' + jsonObject.nombres + ' </td>'+
	'</tr >'+
	'</table>'+
	'<br/>'+
        '<center>'+
        '<form id="modificacionPerfilTecnico1">'+
            '<fieldset>'+
            '<table border="0" >'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Nombre</th>'+
                    '<td>'+'<input type="text" name="nombres" class="comboPerfil" value="' + jsonObject.nombres + '" size="30" maxlength="40" />'+'</td>'+
                '</tr>'+    
                    '<th align="right" style="padding-right:5px;">Nickname</th>'+
                    '<td>'+'<input type="text" name="nickname" class="comboPerfil" value="' + jsonObject.nickname + '" size="30" maxlength="20" />'+'</td>'+
                '</tr>'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Clave</th>'+
                    '<td>'+'<input type="text" name="clave" class="comboPerfil" value="' + jsonObject.clave + '" size="30" maxlength="30" />'+ '</td>'+
                '</tr>'+      
                    '<th align="right" style="padding-right:5px;">Celular</th>'+
                    '<td>'+'<input type="text"  name="celular" class="comboPerfil" value="' + jsonObject.celular + '" size="30" maxlength="10" />'+ '</td>'+
                '</tr>'+
                '<tr>'+
                    '<th align="right" style="padding-right:5px;">Email</th>'+
                    '<td>'+'<input type="text" name="email" class="comboPerfil" value="' + jsonObject.email + '" size="30" maxlength="40" />'+ '</td>'+
               '</tr>'+     
                    '<th align="right" style="padding-right:5px;">Tipo</th>'+
                    '<td>'+'<input type="" name="tipo" class="comboPerfil" value="' + jsonObject.tipo + '" size="30" maxlength="20" readonly/>'+ '</td>'+
                '</tr>'+
//                '<form id="form_enviar_foto"  enctype="multipart/form-data">'+
                '<tr>'+
                    '<td colspan="2" rowspan="9" align="right">'+
                        '<div class="foto">'+
                                '<div class="imagen" id="fotoVendedores">'+
                                    '<img src="segurita/' + jsonObject.foto_perfil + '" align="right" required="required" id="imaperfil" >'+
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
    var request = {"opcionesadmin":"ModPerfil","Datos":datos};
    var jsonobj=JSON.stringify(request);
    alert(jsonobj.toString());
    $.ajax({
                    data: {administrador:jsonobj},
                    dataType: 'json',
                    url: 'Servlet_Ambiental',
                    type: 'POST',
                    success: function(jsonObject)
                    {
                        verificarDatosPerfil(jsonObject);     
                    },
                    error: function(jsonObject) 
                    {
                        alert('Error al conectar con ServletAmbiental');
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
