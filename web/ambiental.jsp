<%-- 
    Document   : ambiental
    Created on : 26/05/2013, 09:22:17 AM
    Author     : Lunita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DISAST</title>
        <link type="text/css" href="css/estilodisast.css" rel="stylesheet"  media="screen"/>
        <link type="text/css" href="css/jquery.datepick.css" rel="stylesheet" media="screen" />
        <script type="text/javascript" src="Scripts/jquery.js" ></script> 
        <script type="text/javascript" src="Scripts/AjaxUpload.2.0.min.js"></script>
        <script type="text/javascript" src="Scripts/jquery.js"></script>
        <%--  <script type="text/javascript" src="Scripts/jquery.datepick.js"></script>
        <script type="text/javascript" src="Scripts/jquery.datepick-es-AR.js"></script> --%>
        <script type="text/javascript" src="Scripts/pefilambiental.js"></script>
        <script type="text/javascript" src="Scripts/jquery.datepick.js"></script>
        <script type="text/javascript" src="Scripts/jquery.datepick-es-AR.js"></script>
    </head>
    <body>
        <div class="sheet">
            <div class="sheet_body">
                <header class="header_body">
                    <div class="logo_sena"></div>
                    <div class="header_text">
                        <h1 class="titulo_header">DISAST</h1>
                    </div>
                </header>
                <nav class="nav">
                    <ul class="menu">
                        <li><a href="#" id="TPAmbiental">impactos_ambiental</a></li>
                        <li><a href="#" id="Perfil_ambiental">Perfil</a></li>
                        <li><a href="index.jsp">Cerrar Sesion</a></li>
                    </ul>
                </nav>
                <section class="content">
                    <article class="content_float4"></article>
                </section>
                <footer class="piedepagina">
                    <div class="texto_depie">
                        <p id="footerfinal">Copyright © 2013 - Todos los derechos Reservados.<br
                            />Diseño,Maquetacion y Desarrollo 398765.</p>
                    </div>
                </footer>
            </div>
        </div>
    </body>
</html>
