<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="org_jwonkanet_gui_Login" %>

<!DOCTYPE html>
<html lang="en">
<head runat="server">
    <title>Juguetería KAD's</title>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
	<link rel="stylesheet" href="css/bootstrapL.min.css">
	<link rel="stylesheet" href="css/estilos.css">
	<link rel="stylesheet" href="css/colores.css">

    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/scripts.js"></script>
</head>
<body>
    <form id="form1" runat="server">
        <section id="header1-1" style="margin-top:70px;">
            <div class="mbr-table-cell">
                <div class="container">
                <div class="row">
                        <div class="col-xs-10 col-xs-offset-1 text-xs-center">
                            <h1 >Iniciar Sesión</h1><br /><br />
                          <div>
                            <div class="form-group">
                              <label for="Usuario" class="">Usuario</label>
                              <input type="email" class="form-control" id="usuario" placeholder="Usuario"/>
                            </div>
                            <div class="form-group">
                              <label for="Contraseña" class="">Contraseña</label>
                              <input type="password" class="form-control" id="clave" placeholder="Password"/>
                            </div>
                            <br/>
                            <a id="btn" href="Clientes.html" id="btnB" class="btn btn-success">Acceder</a>
                          </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </form>
</body>
</html>
