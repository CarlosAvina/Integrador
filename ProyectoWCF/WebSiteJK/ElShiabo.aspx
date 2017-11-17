<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ElShiabo.aspx.cs" Inherits="ElShiabo" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <script src="scripts/jQuery-3.2.1.min.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function () {
            $("#btnBuscar").click(function () {
                ISSC311.ContratoJSJK.ConsultarCliente();
            });
        });
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
    <div>
        <input type="button" value="Buscar" id="btnBuscar" />
    </div>
    </form>
</body>
</html>
