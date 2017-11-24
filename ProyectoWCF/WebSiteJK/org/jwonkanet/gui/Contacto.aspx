<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Contacto.aspx.cs" Inherits="org_jwonkanet_gui_Contacto" %>

<!DOCTYPE html>
<html lang="en">
<head runat="server">
    <title>Juguetería KAD's</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/estilos.css">
	<link rel="stylesheet" href="css/colores.css">

    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>
    <form id="form1" runat="server">
        <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
          <div class="modal-dialog">
                <div class="loginmodal-container">
                    <h1>Iniciar Sesión</h1><br>
                  <form>
                    <input type="text" name="user" placeholder="Username">
                    <input type="password" name="pass" placeholder="Password">
                    <input type="submit" name="login" class="login loginmodal-submit" value="Login">
                  </form>
                    
                  <div class="login-help">
                    <a href="#">Registrar</a> - <a href="#">Olvidé mi contraseña</a>
                  </div>
                </div>
            </div>
          </div>
<div id="flipkart-navbar">
    <div class="container-fluid">
        <div class="row row1 hidden-xs">
            <ul class="largenav pull-right">
                <li class="upper-links"><a class="links" href="index.html">Inicio</a></li>
                
                <li class="upper-links"><a class="links" href="Tiendas.html">Tiendas</a></li>
                <li class="upper-links"><a class="links" href="Contacto.html">Contacto</a></li>
                <li class="upper-links"><a class="links" href="Nosotros.html">Sobre Nosotros</a></li>

            </ul>
        </div>
        <div class="row row2">
            <div class="col-sm-2">
                <h2 style="margin:0px;"><span class="smallnav menu" onclick="openNav()">☰ KAD's</span></h2>
                <h1 style="margin:0px; text-align: center;"><span class="largenav">
                	<a href="Index.html"><img src="img/logo.png" alt="KAD's" style="max-height: 60px" class="img-responsive"></a></span></h1>
            </div>
            <div class="flipkart-navbar-search smallsearch col-sm-8 col-xs-11">
                <div class="row">
                    <input class="flipkart-navbar-input col-xs-11" type="" placeholder="Busca tu juguete" name="">
                    <button class="flipkart-navbar-button col-xs-1">
                        <svg width="15px" height="15px">
                            <path d="M11.618 9.897l4.224 4.212c.092.09.1.23.02.312l-1.464 1.46c-.08.08-.222.072-.314-.02L9.868 11.66M6.486 10.9c-2.42 0-4.38-1.955-4.38-4.367 0-2.413 1.96-4.37 4.38-4.37s4.38 1.957 4.38 4.37c0 2.412-1.96 4.368-4.38 4.368m0-10.834C2.904.066 0 2.96 0 6.533 0 10.105 2.904 13 6.486 13s6.487-2.895 6.487-6.467c0-3.572-2.905-6.467-6.487-6.467 "></path>
                        </svg>
                    </button>
                </div>
            </div>
            <div class="cart largenav col-sm-2">
                <a class="cart-button">
                    <svg class="cart-svg " width="16 " height="16 " viewBox="0 0 16 16 ">
                        <path d="M15.32 2.405H4.887C3 2.405 2.46.805 2.46.805L2.257.21C2.208.085 2.083 0 1.946 0H.336C.1 0-.064.24.024.46l.644 1.945L3.11 9.767c.047.137.175.23.32.23h8.418l-.493 1.958H3.768l.002.003c-.017 0-.033-.003-.05-.003-1.06 0-1.92.86-1.92 1.92s.86 1.92 1.92 1.92c.99 0 1.805-.75 1.91-1.712l5.55.076c.12.922.91 1.636 1.867 1.636 1.04 0 1.885-.844 1.885-1.885 0-.866-.584-1.593-1.38-1.814l2.423-8.832c.12-.433-.206-.86-.655-.86 " fill="#fff "></path>
                    </svg> Carrito
                    <span class="item-number ">0</span>
                </a>
            </div>
        </div>
        <div class="row row3 hidden-xs">
        	<div class="container">
        		<nav class="navbar" id="navS">
				  <ul class="nav navbar-nav" style="width: 100%">
				    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Edades
			        <span class="caret"></span></a>
			        <ul class="dropdown-menu">
			          <li><a href="Tienda.html">0 - 3</a></li>
			          <li><a href="Tienda.html">4 - 12</a></li>
			          <li><a href="Tienda.html">13 +</a></li>
			        </ul>
 					<a href="Tienda.html">Promociones</a>
 					<a href="Tienda.html">Nuevo</a>
 					<a href="Tienda.html">Catálogo</a>
					<ul class="pull-right" style="">
	 					     <a href="#"><span class="glyphicon glyphicon-user"></span> Registrarse</a><a href="#" data-toggle="modal" data-target="#login-modal"><span class="glyphicon glyphicon-log-in"></span> Iniciar Sesión</a>
    				</ul>
				</nav>
        	</div>
        </div>
    </div>
</div>
<div id="mySidenav" class="sidenav">
    <div class="container" style="background-color: rgb(12, 52, 93); padding-top: 10px;">
        <span class="sidenav-heading">Home</span>
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
    </div>
    <a href="Index.html">Inicio</a>
    <a href="Nosotros.html">Nosotros</a>
    <a href="Tiendas.html">Tiendas</a>
    <a href="Contacto.html">Contacto</a>
    <hr>
    <a href="Tienda.html">Promociones</a>
    <a href="Tienda.html">Nuevo</a>
    <a href="Tienda.html">Catálogo</a>
    <hr>
    <a href="#" data-toggle="modal" data-target="#login-modal">Iniciar Sesión</a>
    <a href="">Registrarse</a>
</div>



<div class="jumbotron jumbotron-sm">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <h1 class="h1">
                    Contáctanos <small>Siéntete cerca de nosotros</small></h1>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div class="well well-sm">
                <form>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Nombre</label>
                            <input type="text" class="form-control" id="Nombre" placeholder="Nombre" required="required" />
                        </div>
                        <div class="form-group">
                            <label for="email">
                                Correo Electrónico</label>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                </span>
                                <input type="email" class="form-control" id="email" placeholder="email" required="required" /></div>
                        </div>
                        <div class="form-group">
                            <label for="subject">
                                Asunto</label>
                            <select id="subject" name="subject" class="form-control" required="required">
                                <option value="na" selected="">Elija uno:</option>
                                <option value="service">Informes</option>
                                <option value="suggestions">Sugerencias</option>
                                <option value="product">Soporte</option>
                                <option value="product">Quejas</option>
                                <option value="product">Otro</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="name">
                                Mensaje</label>
                            <textarea name="message" id="message" class="form-control" rows="9" cols="25" required="required"
                                placeholder="Mensaje"></textarea>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary pull-right" id="btnContactUs">
                            Send Message</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
        <div class="col-md-4">
            <form>
            <legend><span class="glyphicon glyphicon-globe"></span> Nuestra sucursal</legend>
            <address>
                <strong>KAD's.</strong><br>
                Avenida Universidad 602<br>
                Lomas del Campestre, 37150, León, Gto.<br>
                <abbr title="Phone">
                    P:</abbr>
                (123) 456-7890
            </address>
            <address>
                <strong>Full Name</strong><br>
                <a href="mailto:#">soporte@kads.com</a>
            </address>
            </form>
        </div>
    </div>
</div>

<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3606.727897523484!2d-101.71345370876683!3d21.15237345119359!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x842bc06e4e1d5a79%3A0x40248ea06dc675dc!2sUniversidad+De+La+Salle+Baj%C3%ADo!5e0!3m2!1ses-419!2smx!4v1510917112947" width="100%" height="450px" frameborder="0" style="border:0" allowfullscreen></iframe>

 <div class="header-bg"></div>

    

    <footer class="main-footer" id="footer" >
    <div class="stck-social">
      <div class="bg-social">
        <p class="text">Siguenos:</p>
        <ul class="social"><li class="menu_item i youtube"><a data-no-turbolink="true" href="https://www.youtube.com">Youtube</a></li><li class="menu_item i facebook"><a data-no-turbolink="true" href="https://www.facebook.com">Facebook</a></li><li class="menu_item i twitter"><a data-no-turbolink="true" href="https://twitter.com">Twitter</a>
      </div>
    </div>

<footer style="margin-top: 150px">
<div style="min-height: 250px;" class="footer" id="footer-sub">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h5> AYUDA </h5>
            <ul>
                <li><a href="Tienda.html">Pagos</a><hr></li>
                <li><a href="Tienda.html">Tarjetas participantes</a><hr></li>
                <li><a href="Tienda.html">Envío</a><hr ></li>
                <li><a href="Tienda.html">Cancelación</a><hr></li>
                <li><a href="Tienda.html">FAQ</a></li>               
            </ul>
            </div>

             <div class="col-md-4">
                <h5> KAD's </h5>
            <ul>
                <li><a href="Contacto.html">Contacto</a><hr></li>
                <li><a href="Nosotros.html">Acerca de nosotros</a><hr></li>
                <li><a href="Tienda.html">Careers</a><hr></li>
            
            </ul>
        </div>

         <div class="col-md-4">
            <h5> MISC </h5>
            <ul>
                <li><a href="Tienda.html">Catálogo</a><hr></li>
                <li><a href="Tienda.html">Afíliate a nuestras promociones</a><hr></li>

                <li><a href="Index.html">Sitemap</a></li>               
            </ul>
        </div>
       
        </div>

        
 <hr style="margin-bottom:0px; margin-top:30px; padding:0px;">
        <div class="row" id="sub-two">

            <div class="col-md-4">
                <div class="vertical-line text-center">
                    <span class="glyphicon glyphicon-map-marker"></span>
                    <h4>Rastrear mi pedido</h4>
                </div>
            </div>

            <div class="col-md-4">
                <div class="vertical-line text-center">
                    <span class="glyphicon glyphicon-refresh"></span>
                    <h4>Devoluciones</h4>
                </div>
            </div>

            <div class="col-md-4">
                <div style="margin:8px;" class="text-center">
                    <span class="glyphicon glyphicon-remove-circle"></span>
                    <h4 style="color:#6d6c6c;">Cancelación de pedido</h4>
                </div>
            </div>
            

        </div>
        <hr style="margin-bottom:30px; margin-top:0px; padding:0px;">

       

    </div>
</div>
<div style="min-height: 50px;" id="footer-main">

<ul>
    <li><a href="Nosotros.html"><b>Acerca de nosotros</b></a></li>
    <li><a href="Tienda.html"><b>Sé parte de nosotros</b></a></li>
    <li><a href="Tienda.html"><b>Términos y cnodiciones</b></a></li>
    <li><a href="Tiendas.html"><b>Tiendas</b></a></li>
    <li><a href="Nosotros.html"><b>Servicio</b></a></li>
</ul>

<div id="social-menu">
    <ul>
    <li><a href=""><img style="max-width:18px; margin-top: -7px;" src=""></a></li>
    <li><a href=""><img style="max-width:18px; margin-top: -7px;" src=""></a></li>
    <li><a href=""><img style="max-width:18px; margin-top: -7px;" src=""></a></li>
</ul>
</div>

</div>
</footer>
    </form>
</body>
</html>
