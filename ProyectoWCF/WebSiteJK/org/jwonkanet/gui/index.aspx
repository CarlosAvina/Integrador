﻿<%@ Page Language="C#" AutoEventWireup="true" CodeFile="index.aspx.cs" Inherits="org_jwonkanet_gui_index" %>

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
          div class="modal-dialog">
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
            	<li class="upper-links"><a class="links" href="index.aspx">Inicio</a></li>
                
                <li class="upper-links"><a class="links" href="Tiendas.aspx">Tiendas</a></li>
                <li class="upper-links"><a class="links" href="Contacto.aspx">Contacto</a></li>
                <li class="upper-links"><a class="links" href="Nosotros.aspx">Sobre Nosotros</a></li>

            </ul>
        </div>
        <div class="row row2">
            <div class="col-sm-2">
                <h2 style="margin:0px;"><span class="smallnav menu" onclick="openNav()">☰ KAD's</span></h2>
                <h1 style="margin:0px; text-align: center;"><span class="largenav">
                	<a href="Index.aspx"><img src="img/logo.png" alt="KAD's" style="max-height: 60px" class="img-responsive"></a></span></h1>
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
			          <li><a href="Tienda.aspx">0 - 3</a></li>
			          <li><a href="Tienda.aspx">4 - 12</a></li>
			          <li><a href="Tienda.aspx">13 +</a></li>
			        </ul>
 					<a href="Tienda.aspx">Promociones</a>
 					<a href="Tienda.aspx">Nuevo</a>
 					<a href="Tienda.aspx">Catálogo</a>
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
    <a href="Index.aspx">Inicio</a>
    <a href="Nosotros.aspx">Nosotros</a>
    <a href="Tiendas.aspx">Tiendas</a>
    <a href="Contacto.aspx">Contacto</a>
    <hr>
    <a href="Tienda.aspx">Promociones</a>
    <a href="Tienda.aspx">Nuevo</a>
    <a href="Tienda.aspx">Catálogo</a>
    <hr>
    <a href="#" data-toggle="modal" data-target="#login-modal">Iniciar Sesión</a>
    <a href="">Registrarse</a>
</div>
<div class="container main">
	<div class="header-stripe-wrapper ">
  <div class="header-stripe-info">
    <div class="shipping-stripe">
      <p>Envío gratis en la compra de más de $500 MXN</p>
      <span class="slice"></span>
    </div>
    <div class="return-stripe">
      <p>Devolución gratuita en nuestras tiendas</p>
    </div>
  </div>
</div>
    <hr>
    <div class="row" style="margin-top: 50px"> 
        <div class="col-sm-6">
           <img src="img/b1.jpg" alt="" style="cursor:pointer" class="img-responsive center-block">
        </div>
        <div class="row col-sm-6">
            <div class="col-xs-6">
              <img src="img/b2.jpg" alt="" style="cursor:pointer" class="img-responsive">
            </div>
            <div class="col-xs-6">
              <img src="img/b3.jpg" alt="" style="cursor:pointer" class="img-responsive">
            </div>
            <div class="col-xs-6">
              <img src="img/b4.jpg" alt="" style="cursor:pointer" class="img-responsive">
            </div>
            <div class="col-xs-6">
              <img src="img/b5.jpg" alt="" style="cursor:pointer" class="img-responsive">
            </div>
        </div>
    </div>
</div>

<div class="container">
  <div class="row">
    <h2 style="text-align: center;">Nuestras Marcas</h2>
  </div>
  <div class='row'>
    <div class='col-md-12'>
      <div class="carousel slide media-carousel" id="media">
        <div class="carousel-inner">
          <div class="item  active">
            <div class="row">
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="" src="img/m1.jpg"></a>
              </div>          
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="" src="img/m2.jpg"></a>
              </div>
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="" src="img/m3.jpg"></a>
              </div>        
            </div>
          </div>
          <div class="item">
            <div class="row">
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="" src="img/m4.jpg"></a>
              </div>          
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="" src="img/m5.png"></a>
              </div>
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="" src="img/m6.jpg"></a>
              </div>        
            </div>
          </div>
          <div class="item">
            <div class="row">
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="" src="img/m7.jpg"></a>
              </div>          
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="" src="img/m8.jpg"></a>
              </div>
              <div class="col-md-4">
                <a class="thumbnail" href="#"><img alt="" src="img/m9.jpg"></a>
              </div>      
            </div>
          </div>
        </div>
        <a data-slide="prev" href="#media" class="left carousel-control">‹</a>
        <a data-slide="next" href="#media" class="right carousel-control">›</a>
      </div>                          
    </div>
  </div>
</div>

<div class="container">
    <div class="page-header">
        <h1>Los mejores juguetes</h1>
    </div>
    <div class="row">
    	<div class="col-md-12" >
            <div class="panel with-nav-tabs panel-default">
                <div class="panel-heading" id="panel">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab2default" data-toggle="tab">Recomencación de la casa</a></li>
                        </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab2default"><div class="row">
        <div class="row">
            <div class="col-md-9">

            </div>
            <div class="col-md-3">
                <!-- Controls -->
                <div class="controls pull-right hidden-xs">
                    <a class="left fa fa-chevron-left btn btn-success" href="#carousel-example"
                        data-slide="prev"></a><a class="right fa fa-chevron-right btn btn-success" href="#carousel-example"
                            data-slide="next"></a>
                </div>
            </div>
        </div>
        <div id="carousel-example" class="carousel slide " data-ride="carousel">
            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active" >
                    <div class="row" >
                        <div class="col-sm-3" >
                            <div class="col-item" >
                                <div class="photo" >
                                    <img src="img/j1.png" style="max-height: 180px" class="img-responsive img-c" alt="a" />
                                </div>
                                <div class="info">
                                    <div class="row">
                                        <div class="price col-md-6">
                                            <h5 >
                                                Producto</h5>
                                            <h5 class="price-text-color">
                                                $199.99</h5>
                                        </div>
                                        <div class="rating hidden-sm col-md-6">
                                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="separator clear-left">
                                        <p class="btn-add">
                                            <i class="fa fa-shopping-cart"></i><a href="" class="hidden-sm">Añadir al carrito</a></p>
                                        
                                    </div>
                                    <div class="clearfix">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="col-item">
                                <div class="photo">
                                    <img src="img/j2.png" style="max-height: 180px" class="img-responsive img-c" alt="a" />
                                </div>
                                <div class="info">
                                    <div class="row">
                                        <div class="price col-md-6">
                                            <h5>
                                                Producto</h5>
                                            <h5 class="price-text-color">
                                                $249.99</h5>
                                        </div>
                                        <div class="rating hidden-sm col-md-6">
                                        </div>
                                    </div>
                                    <div class="separator clear-left">
                                        <p class="btn-add">
                                            <i class="fa fa-shopping-cart"></i><a href="" class="hidden-sm">Añadir al carrito</a></p>
                                        
                                    </div>
                                    <div class="clearfix">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="col-item">
                                <div class="photo">
                                    <img src="img/j3.png" style="max-height: 180px" class="img-responsive img-c" alt="a" />
                                </div>
                                <div class="info">
                                    <div class="row">
                                        <div class="price col-md-6">
                                            <h5>
                                                Producto</h5>
                                            <h5 class="price-text-color">
                                                $149.99</h5>
                                        </div>
                                        <div class="rating hidden-sm col-md-6">
                                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="separator clear-left">
                                        <p class="btn-add">
                                            <i class="fa fa-shopping-cart"></i><a href="" class="hidden-sm">Añadir al carrito</a></p>
                                        
                                    </div>
                                    <div class="clearfix">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="col-item">
                                <div class="photo">
                                    <img src="img/j4.png" style="max-height: 180px" class="img-responsive img-c" alt="a" />
                                </div>
                                <div class="info">
                                    <div class="row">
                                        <div class="price col-md-6">
                                            <h5>
                                                Producto</h5>
                                            <h5 class="price-text-color">
                                                $199.99</h5>
                                        </div>
                                        <div class="rating hidden-sm col-md-6">
                                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="separator clear-left">
                                        <p class="btn-add">
                                            <i class="fa fa-shopping-cart"></i><a href="" class="hidden-sm">Añadir al carrito</a></p>
                                        
                                    </div>
                                    <div class="clearfix">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="col-item">
                                <div class="photo">
                                    <img src="img/j5.png" style="max-height: 180px" class="img-responsive img-c" alt="a" />
                                </div>
                                <div class="info">
                                    <div class="row">
                                        <div class="price col-md-6">
                                            <h5>
                                                Producto</h5>
                                            <h5 class="price-text-color">
                                                $199.99</h5>
                                        </div>
                                        <div class="rating hidden-sm col-md-6">
                                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="separator clear-left">
                                        <p class="btn-add">
                                            <i class="fa fa-shopping-cart"></i><a href="" class="hidden-sm">Añadir al carrito</a></p>
                                        
                                    </div>
                                    <div class="clearfix">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="col-item">
                                <div class="photo">
                                    <img src="img/j1.png" style="max-height: 180px" class="img-responsive img-c" alt="a" />
                                </div>
                                <div class="info">
                                    <div class="row">
                                        <div class="price col-md-6">
                                            <h5>
                                                Producto</h5>
                                            <h5 class="price-text-color">
                                                $249.99</h5>
                                        </div>
                                        <div class="rating hidden-sm col-md-6">
                                        </div>
                                    </div>
                                    <div class="separator clear-left">
                                        <p class="btn-add">
                                            <i class="fa fa-shopping-cart"></i><a href="" class="hidden-sm">Añadir al carrito</a></p>
                                        
                                    </div>
                                    <div class="clearfix">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="col-item">
                                <div class="photo">
                                    <img src="img/j2.png" style="max-height: 180px" class="img-responsive img-c" alt="a" />
                                </div>
                                <div class="info">
                                    <div class="row">
                                        <div class="price col-md-6">
                                            <h5>
                                                Producto</h5>
                                            <h5 class="price-text-color">
                                                $149.99</h5>
                                        </div>
                                        <div class="rating hidden-sm col-md-6">
                                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="separator clear-left">
                                        <p class="btn-add">
                                            <i class="fa fa-shopping-cart"></i><a href="" class="hidden-sm">Añadir al carrito</a></p>
                                        
                                    </div>
                                    <div class="clearfix">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="col-item">
                                <div class="photo">
                                    <img src="img/j3.png" style="max-height: 180px" class="img-responsive img-c" alt="a" />
                                </div>
                                <div class="info">
                                    <div class="row">
                                        <div class="price col-md-6">
                                            <h5>
                                                Producto</h5>
                                            <h5 class="price-text-color">
                                                $199.99</h5>
                                        </div>
                                        <div class="rating hidden-sm col-md-6">
                                            <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                            </i><i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="separator clear-left">
                                        <p class="btn-add">
                                            <i class="fa fa-shopping-cart"></i><a href="" class="hidden-sm">Añadir al carrito</a></p>
                                        
                                    </div>
                                    <div class="clearfix">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
                        
</div></div>
                    </div>
                </div>
            </div>
        </div>

	</div>
</div>

<div class="intro-header"> 
<div class="container containerN"  align="center">
<div class="tab-content custom-tab-contentN" align="center">
<div class="subscribe-panel">
<h1>Suscríbete</h1>
<p>Recibirás nuestras promociones cada semana</p>
                
                <form action="" method="post">
                    	
							<div class="col-md-4"></div>
							<div class="col-md-4">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i></span>
									<input type="text" class="form-control input-lg" name="email" id="email"  placeholder="Ingrese su correo"/>
								</div>
							</div>
							<div class="col-md-4"></div>
                    <br/><br/><br/>
                    <button class="btn btn-warning btn-lg">Suscribirse ahora</button>
              </form>

</div>
</div>
</div>
</div>

<div class="container">
	<div class="wrapper">
  <div class="wrapper-banner">
    <div class="banner tiendas">
      <p class="title">LÍDER EN LOS MEJORES JUGUETES</p>
      <p class="text">Vendemos juguetes de calidad</p>
      <a href="">¡NO PIERDAD EL TUYO!</a>
    </div>
  </div>
  <div class="wrapper-banner">
    <div class="banner news">
      <p class="title">GARANTÍA</p>
      <p class="text">Si no te convence tu juguete, nosotros te lo cambiamis</p>
      <a title="Diversión al máximo" target="_blank" href="">Nunca te aburras</a>
    </div>
  </div>
</div>
</div>


      <div class="header-bg"></div>
    </div>

    

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
                <li><a href="Tienda.aspx">Pagos</a><hr></li>
                <li><a href="Tienda.aspx">Tarjetas participantes</a><hr></li>
                <li><a href="Tienda.aspx">Envío</a><hr ></li>
                <li><a href="Tienda.aspx">Cancelación</a><hr></li>
                <li><a href="Tienda.aspx">FAQ</a></li>               
            </ul>
            </div>

             <div class="col-md-4">
                <h5> KAD's </h5>
            <ul>
                <li><a href="Contacto.aspx">Contacto</a><hr></li>
                <li><a href="Nosotros.aspx">Acerca de nosotros</a><hr></li>
                <li><a href="Tienda.aspx">Careers</a><hr></li>
            
            </ul>
        </div>

         <div class="col-md-4">
            <h5> MISC </h5>
            <ul>
                <li><a href="Tienda.aspx">Catálogo</a><hr></li>
                <li><a href="Tienda.aspx">Afíliate a nuestras promociones</a><hr></li>

                <li><a href="Index.aspx">Sitemap</a></li>               
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
    <li><a href="Nosotros.aspx"><b>Acerca de nosotros</b></a></li>
    <li><a href="Tienda.aspx"><b>Sé parte de nosotros</b></a></li>
    <li><a href="Tienda.aspx"><b>Términos y cnodiciones</b></a></li>
    <li><a href="Tiendas.aspx"><b>Tiendas</b></a></li>
    <li><a href="Nosotros.aspx"><b>Servicio</b></a></li>
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
