<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Login.aspx.cs" Inherits="Login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <script src="scripts/jQuery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#btnLogin").click(function () {
                var nick = $('#txtNick').val();
                //var pass = sha256($('#txtPwd').val());
                var pass = $('#txtPwd').val();
                if (nick != '' && pass != '') {
                    LoginJS(nick, pass);
                }
                else {
                    alert('Proporciona nick y password');
                }
            });
        });
        function LoginJS(nick, password) {
            var objJson = {//Se nombran igual que los atributos del objeto
                "Nick": nick,
                "Password": password
            }
            ISSC311.ContratoJSUsuarios.Login(objJson, OnRequestComplete, onError);
        }

        function OnRequestComplete(response, state)
        {
            if (response = 0){
                alert('Bienvenido');
                window.location.href = "ElShiabo.aspx";
            }
            else
                alert('Usuario y/o contraseña incorrectos');
        }
        function onError()
        {
            alert('Ocurrio un error');
        }
    </script>
</head>
<body>
    <form id="form1" runat="server">
        
    <div>
       <asp:ScriptManager ID="ScriptManager1" runat="server">
           <Services>
               <asp:ServiceReference Path="http://localhost:83/wcfServiciosJK/ServiceJS.svc" />
           </Services>
       </asp:ScriptManager>
        
    </div>
         Nick:<input type="text" id="txtNick" />
        <br/>

        Password:<input type="password" id="txtPwd" />
        <br/>

        <input type="button" id="btnLogin" value="Login" />
    </form>
</body>
</html>
