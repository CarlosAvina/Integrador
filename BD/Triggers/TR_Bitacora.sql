/*    ==Scripting Parameters==

    Source Server Version : SQL Server 2017 (14.0.1000)
    Source Database Engine Edition : Microsoft SQL Server Enterprise Edition
    Source Database Engine Type : Standalone SQL Server

    Target Server Version : SQL Server 2017
    Target Database Engine Edition : Microsoft SQL Server Standard Edition
    Target Database Engine Type : Standalone SQL Server
*/

USE [JugueteriaWonka]
GO
/****** Object:  Trigger [dbo].[TR_bitacora]    Script Date: 10/11/2017 01:01:39 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
ALTER TRIGGER [dbo].[TR_bitacora]
      ON [dbo].[DetalleBitacora]
      AFTER Insert
      AS
        BEGIN

      UPDATE P
      SET P.Stock = P.Stock + D.Cantidad from Producto as P inner join
	  inserted as D on 
      P.IdProducto = D.IdProducto
END