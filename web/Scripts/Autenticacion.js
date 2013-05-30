/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


var pagina;
pagina=$(document);
pagina.ready(iniciar);

function iniciar()
{
    var cargalogin;
    cargalogin=$("#inicial");
    cargalogin.click(Principal);
    
    var cARgainstituto;
    cARgainstituto=$("#instituto");
    cARgainstituto.click(instinto);
    
    var SaludP;
    SaludP=$("#saludt");
    SaludP.click(SaludyTra);
    
    var ambito;
    ambito=$("#ambient");
    ambito.click(Ambientalito);
    
        
    formulario_login();

}

function Principal()
{
    $(".nav .menu li a").removeClass("active");
    $(this).addClass("active");
    reseña();
}

function reseña()
{
    var codigoHTML= '<br/>'+
                        '<h2 class="ppostheader" style="text-align:center";>RESEÑA HISTORICA</h2>'+
                        '<p><Transcurría el año 1957 cuando Rodolfo Martínez Tono se embarcó en el sueño que></p>'+
                    '<br/>';
  $(".content_float3").html(codigoHTML); 
}


function instinto()
{
    $(".nav .menu li a").removeClass("active");
    $(this).addClass("active");
    seccionInstitucional();
}


function seccionInstitucional()
{
    var codigoHTML ='<br/>'+
                        '<h2 class="ppostheader">Mision</h2>'+
                        'El Servicio Nacional de Aprendizaje (SENA)'+
                        'se encarga de cumplir la funcion que le corresponde al Estado de invertir'+
                        'en el desarrollo'+
                        'social y tecnico de los trabajadores colombianos, ofreciendo y ejecutando la Formacion Profecional'+
                        'Integral gratuita, para la incorporacion y el desarrollo de las personas en actividades productivas'+
                        'que contribuyan al desarrollo social, economico y tecnologico del pais.'+
                    '<br/>'+
                    '<br>'+
                        '<h2 class="ppostheader" style="margin-left:20px;">Vision</h2>'+
                        'El SENA sera una organizacion de conocimiento'+
                        'para todos los colombianos, innovando permanentemente'+
                        'en sus estrategias y metodologias de'+
                        'aprendizaje, en total acuerdo con las tendencias y cambios tecnologicos y las necesidades'+
                        'del sector empresarial y de los trabajadores, impactando positivamente la productividad,'+
                        'la competitividad, la equidad y el desarrollo del pais.'+
                '</br>';

    $(".content_float3").html(codigoHTML);
}


function SaludyTra()
{
    $(".nav .menu li a").removeClass("active");
    $(this).addClass("active");
    seccionSSGT1();
}

function seccionSSGT1()
{
    var codigoHTML='<br>'+
                        '<div><img src="Imagenes/segurita.png" class="segurita"/></div>'+
                        '<h2 class="ppostheader" style="text-align:center";>Salud y Seguridad En El Trabajo</h2>'+
                        '<p><style="line-height: 15px;">Transcurría el año 1957 cuando Rodolfo Martínez Tono se embarcó en el sueño que></p>'+
                    '<br/>';
                        
    $(".content_float3").html(codigoHTML);
}


function Ambientalito()
{
    $(".nav .menu li a").removeClass("active");
    $(this).addClass("active");
    seccionImpactos();
}

function seccionImpactos()
{
    var codigoHTML='<br>'+
                        '<div><img src="Imagenes/ambientalito.png" class="ambientalito"/></div>'+
                        '<h2 class="ppostheader" style="text-align:center";>Aspectos e Impactos Ambientales</h2>'+
                        '<p style=align"center"> transcurría el año 1957 cuando Rodolfo Martínez Tono se embarcó en el sueño que</p>'+
                    '<br/>';

    $(".content_float3").html(codigoHTML);
}


function formulario_login()
{
    var codigoHTML ='<form id="form_login">'+
                                '<table cellspacing="5">'+
                                    '<tr>'+
                                        '<td colspan="5" align="center"><h2>Log In</h2></td>'+
                                    '</tr>'+
                                    '<tr>'+
                                        '<th align="leght"><p></p></th>'+
                                        '<td><input type="text" class="login"  name="usuario" title="" placeholder="usuario" value="" autocomplete="off" id="Usuario" size="12" maxlength="100 required="required" /></td>'+
                                    '</tr>'+
                                    '<tr>'+
                                        '<th align="leght"><p></p></th>'+
                                        '<td><input type="password" name="password" class="login" placeholder="Contraseña" value="" id="Password" size="12" maxlength="100 required="required" /></td>'+
                                    '</tr>'+
                                    '<tr>'+
                                        '<td colspan="2" align="right">'+
                                        '<input type="submit" class="botonIngresarLoguin" id="Ingresar" value="Ingresar" />'+
                                        '</td>'+
                                    '</tr>'+
                                    '<tr>'+
                                        '<td colspan="2" align="center">&nbsp;</td>'+
                                    '</tr>'+
                                '</table>'+
                        '</form>';

        $(".content_float2").html(codigoHTML); 
        $("#form_login").submit(verficarUsuario);
    
}

function verficarUsuario(evento)
{
    evento.preventDefault();
    var datos_formulario = $(this).serialize();
    alert(datos_formulario);
    $.ajax({
                data: datos_formulario,
                type: 'POST',
                dataType: 'json',
                url: 'Servlet_Autenticacion',
                success: function(jsonObj)
                {
                    cargarUsuario(jsonObj);
                },
                error: function() 
                {
                    alert('Error al conectar con el servidor');
                }
            });
}

function cargarUsuario(jsonObj)
{
    if (jsonObj.TipoUsuario =="false")
    {
        alert("El usuario no existe en el sistema");
    }
    
    if (jsonObj.TipoUsuario =="Ambientalito")
    {
        window.location = "ambiental.jsp";
    } 
    
    if (jsonObj.TipoUsuario =="Segurita")
    {
        window.location = "segurita.jsp";
    }
}



