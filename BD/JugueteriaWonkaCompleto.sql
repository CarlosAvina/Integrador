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
/****** Object:  Table [dbo].[Producto]    Script Date: 10/11/2017 01:01:13 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Producto](
	[IdProducto] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[EdadMinima] [int] NOT NULL,
	[EdadMaxima] [int] NOT NULL,
	[Descripcion] [varchar](180) NOT NULL,
	[Precio] [float] NOT NULL,
	[Stock] [int] NOT NULL,
	[Fotografia] [text] NULL,
	[Activo] [int] NOT NULL,
	[IdMarca] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdProducto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Marca]    Script Date: 10/11/2017 01:01:14 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Marca](
	[IdMarca] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdMarca] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Venta]    Script Date: 10/11/2017 01:01:14 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Venta](
	[IdVenta] [int] IDENTITY(1,1) NOT NULL,
	[Fecha] [datetime] NOT NULL,
	[IdEmpleado] [int] NOT NULL,
	[IdCliente] [int] NOT NULL,
	[IdFormaPago] [int] NOT NULL,
	[Activo] [int] NULL,
	[Total] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdVenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DetalleVenta]    Script Date: 10/11/2017 01:01:14 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetalleVenta](
	[IdDetalleVenta] [int] IDENTITY(1,1) NOT NULL,
	[CantidadProducto] [int] NULL,
	[Precio] [float] NULL,
	[IdVenta] [int] NOT NULL,
	[IdProducto] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDetalleVenta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[V_DetalleVenta]    Script Date: 10/11/2017 01:01:14 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE VIEW [dbo].[V_DetalleVenta] AS
	SELECT d.IdDetalleVenta,
			v.IdVenta,
			p.Nombre as Producto,
			p.Descripcion,
			p.Precio,
			d.CantidadProducto,
			d.Precio as Total,
			p.Fotografia,
			m.Nombre as Marca
	FROM DetalleVenta d
			INNER JOIN Venta v ON d.IdVenta = v.IdVenta
			INNER JOIN Producto p ON d.IdProducto = p.IdProducto
			INNER JOIN Marca m ON p.IdMarca = m.IdMarca
GO
/****** Object:  View [dbo].[V_Productos]    Script Date: 10/11/2017 01:01:14 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE view [dbo].[V_Productos] as
	SELECT		pr.IdProducto,
				pr.Nombre,
				pr.Descripcion,
				pr.Precio,
				pr.Stock,
				pr.EdadMinima,
				pr.EdadMaxima,
				pr.Fotografia,
				pr.IdMarca,
				m.Nombre as Marca,
				pr.Activo
	FROM		Producto pr Inner Join Marca m ON pr.IdMarca = m.IdMarca
	where Activo = 1

GO
/****** Object:  View [dbo].[V_Marcas]    Script Date: 10/11/2017 01:01:14 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



CREATE view [dbo].[V_Marcas] as
	SELECT		m.Nombre
	FROM		Marca m

GO
/****** Object:  Table [dbo].[Rol]    Script Date: 10/11/2017 01:01:14 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rol](
	[IdRol] [int] IDENTITY(1,1) NOT NULL,
	[Descripcion] [varchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[V_Roles]    Script Date: 10/11/2017 01:01:14 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO





CREATE view [dbo].[V_Roles] as
	SELECT		r.Descripcion
	FROM		Rol r



GO
/****** Object:  Table [dbo].[Persona]    Script Date: 10/11/2017 01:01:14 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Persona](
	[IdPersona] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NOT NULL,
	[ApellidoPaterno] [varchar](50) NOT NULL,
	[ApellidoMaterno] [varchar](50) NULL,
	[Genero] [varchar](2) NULL,
	[Rfc] [varchar](14) NULL,
	[Curp] [varchar](20) NULL,
	[FechaNacimiento] [date] NULL,
	[Cp] [varchar](15) NULL,
	[Fotografia] [text] NULL,
	[Domicilio] [varchar](128) NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPersona] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Empleado]    Script Date: 10/11/2017 01:01:14 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Empleado](
	[IdEmpleado] [int] IDENTITY(1,1) NOT NULL,
	[Salario] [float] NULL,
	[Codigo] [varchar](20) NULL,
	[FechaIngreso] [datetime] NULL,
	[Activo] [int] NULL,
	[IdPersona] [int] NOT NULL,
	[IdUsuario] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdEmpleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Codigo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[IdUsuario] [int] IDENTITY(1,1) NOT NULL,
	[Password] [varchar](64) NULL,
	[Username] [varchar](64) NULL,
	[Activo] [int] NULL,
	[IdRol] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[V_Empleados]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE view [dbo].[V_Empleados] as
	SELECT		e.IdEmpleado,
				p.IdPersona,
				p.Nombre,
				p.ApellidoPaterno,
				p.ApellidoMaterno,
				p.Genero,
				p.Rfc,
				p.Curp,
				CONVERT(NVARCHAR,p.FechaNacimiento, 103) as FechaNacimiento,
				p.Cp,
				p.Fotografia,
				p.Domicilio,
				e.Salario,
				e.FechaIngreso,
				e.Codigo as Username,
				e.Activo,
				u.Password,
				r.Descripcion,
				u.IdUsuario
	FROM		Empleado e Inner Join Persona p ON e.IdPersona = p.IdPersona
				Inner Join Usuario u On E.IdUsuario = u.IdUsuario
				Inner Join Rol r On u.IdRol = r.IdRol
				Where e.Activo =1

GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[IdCliente] [int] IDENTITY(1,1) NOT NULL,
	[Email] [varchar](128) NULL,
	[Telefono] [varchar](20) NULL,
	[Activo] [int] NULL,
	[IdPersona] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[V_Clientes]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE view [dbo].[V_Clientes] as
	SELECT		c.IdCliente,
				p.IdPersona,
				p.Nombre,
				p.ApellidoPaterno,
				p.ApellidoMaterno,
				p.Genero,
				p.Rfc,
				p.Curp,
				CONVERT(NVARCHAR,p.FechaNacimiento, 103) as FechaNacimiento,
				p.Cp,
				p.Fotografia,
				p.Domicilio,
				c.Email,
				c.Telefono,
				c.Activo
	FROM		Cliente c Inner Join Persona p ON c.IdPersona = p.IdPersona
GO
/****** Object:  Table [dbo].[Bitacora]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bitacora](
	[IdBitacora] [int] IDENTITY(1,1) NOT NULL,
	[FechaAbastecimiento] [datetime] NOT NULL,
	[Activo] [int] NOT NULL,
	[Total] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[IdBitacora] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DetalleBitacora]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetalleBitacora](
	[IdDetalleBitacora] [int] IDENTITY(1,1) NOT NULL,
	[Cantidad] [int] NOT NULL,
	[PrecioCompra] [float] NOT NULL,
	[IdBitacora] [int] NOT NULL,
	[IdProducto] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdDetalleBitacora] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FormaPago]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FormaPago](
	[IdFormaPago] [int] IDENTITY(1,1) NOT NULL,
	[Descripcion] [varchar](180) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdFormaPago] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Bitacora] ADD  DEFAULT (getdate()) FOR [FechaAbastecimiento]
GO
ALTER TABLE [dbo].[Cliente] ADD  DEFAULT ('') FOR [Email]
GO
ALTER TABLE [dbo].[Cliente] ADD  DEFAULT ('') FOR [Telefono]
GO
ALTER TABLE [dbo].[Cliente] ADD  DEFAULT ((1)) FOR [Activo]
GO
ALTER TABLE [dbo].[DetalleBitacora] ADD  DEFAULT ((1)) FOR [Cantidad]
GO
ALTER TABLE [dbo].[DetalleBitacora] ADD  DEFAULT ((0)) FOR [PrecioCompra]
GO
ALTER TABLE [dbo].[Empleado] ADD  DEFAULT ((1)) FOR [Activo]
GO
ALTER TABLE [dbo].[FormaPago] ADD  DEFAULT ('') FOR [Descripcion]
GO
ALTER TABLE [dbo].[Marca] ADD  DEFAULT ('') FOR [Nombre]
GO
ALTER TABLE [dbo].[Persona] ADD  DEFAULT ('') FOR [ApellidoMaterno]
GO
ALTER TABLE [dbo].[Persona] ADD  DEFAULT ('O') FOR [Genero]
GO
ALTER TABLE [dbo].[Persona] ADD  DEFAULT ('') FOR [Domicilio]
GO
ALTER TABLE [dbo].[Producto] ADD  DEFAULT ('') FOR [Nombre]
GO
ALTER TABLE [dbo].[Producto] ADD  DEFAULT ((0)) FOR [EdadMinima]
GO
ALTER TABLE [dbo].[Producto] ADD  DEFAULT ((99)) FOR [EdadMaxima]
GO
ALTER TABLE [dbo].[Producto] ADD  DEFAULT ('') FOR [Descripcion]
GO
ALTER TABLE [dbo].[Producto] ADD  DEFAULT ((0.0)) FOR [Precio]
GO
ALTER TABLE [dbo].[Producto] ADD  DEFAULT ((0)) FOR [Stock]
GO
ALTER TABLE [dbo].[Producto] ADD  DEFAULT ((1)) FOR [Activo]
GO
ALTER TABLE [dbo].[Usuario] ADD  DEFAULT ((1)) FOR [Activo]
GO
ALTER TABLE [dbo].[Venta] ADD  DEFAULT (getdate()) FOR [Fecha]
GO
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_ClientePersona] FOREIGN KEY([IdPersona])
REFERENCES [dbo].[Persona] ([IdPersona])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_ClientePersona]
GO
ALTER TABLE [dbo].[DetalleBitacora]  WITH CHECK ADD  CONSTRAINT [FK_DetalleBitacoraBitacora] FOREIGN KEY([IdBitacora])
REFERENCES [dbo].[Bitacora] ([IdBitacora])
GO
ALTER TABLE [dbo].[DetalleBitacora] CHECK CONSTRAINT [FK_DetalleBitacoraBitacora]
GO
ALTER TABLE [dbo].[DetalleBitacora]  WITH CHECK ADD  CONSTRAINT [FK_DetalleBitacoraProducto] FOREIGN KEY([IdProducto])
REFERENCES [dbo].[Producto] ([IdProducto])
GO
ALTER TABLE [dbo].[DetalleBitacora] CHECK CONSTRAINT [FK_DetalleBitacoraProducto]
GO
ALTER TABLE [dbo].[DetalleVenta]  WITH CHECK ADD  CONSTRAINT [FK_DetalleVentaProducto] FOREIGN KEY([IdProducto])
REFERENCES [dbo].[Producto] ([IdProducto])
GO
ALTER TABLE [dbo].[DetalleVenta] CHECK CONSTRAINT [FK_DetalleVentaProducto]
GO
ALTER TABLE [dbo].[DetalleVenta]  WITH CHECK ADD  CONSTRAINT [FK_DetalleVentaVenta] FOREIGN KEY([IdVenta])
REFERENCES [dbo].[Venta] ([IdVenta])
GO
ALTER TABLE [dbo].[DetalleVenta] CHECK CONSTRAINT [FK_DetalleVentaVenta]
GO
ALTER TABLE [dbo].[Empleado]  WITH CHECK ADD  CONSTRAINT [FK_EmpleadoPersona] FOREIGN KEY([IdPersona])
REFERENCES [dbo].[Persona] ([IdPersona])
GO
ALTER TABLE [dbo].[Empleado] CHECK CONSTRAINT [FK_EmpleadoPersona]
GO
ALTER TABLE [dbo].[Empleado]  WITH CHECK ADD  CONSTRAINT [FK_EmpleadoUsuario] FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[Usuario] ([IdUsuario])
GO
ALTER TABLE [dbo].[Empleado] CHECK CONSTRAINT [FK_EmpleadoUsuario]
GO
ALTER TABLE [dbo].[Producto]  WITH CHECK ADD  CONSTRAINT [FK_ProductoMarca] FOREIGN KEY([IdMarca])
REFERENCES [dbo].[Marca] ([IdMarca])
GO
ALTER TABLE [dbo].[Producto] CHECK CONSTRAINT [FK_ProductoMarca]
GO
ALTER TABLE [dbo].[Usuario]  WITH CHECK ADD  CONSTRAINT [FK_UsuarioRol] FOREIGN KEY([IdRol])
REFERENCES [dbo].[Rol] ([IdRol])
GO
ALTER TABLE [dbo].[Usuario] CHECK CONSTRAINT [FK_UsuarioRol]
GO
ALTER TABLE [dbo].[Venta]  WITH CHECK ADD  CONSTRAINT [FK_VentaCliente] FOREIGN KEY([IdCliente])
REFERENCES [dbo].[Cliente] ([IdCliente])
GO
ALTER TABLE [dbo].[Venta] CHECK CONSTRAINT [FK_VentaCliente]
GO
ALTER TABLE [dbo].[Venta]  WITH CHECK ADD  CONSTRAINT [FK_VentaEmpleado] FOREIGN KEY([IdEmpleado])
REFERENCES [dbo].[Empleado] ([IdEmpleado])
GO
ALTER TABLE [dbo].[Venta] CHECK CONSTRAINT [FK_VentaEmpleado]
GO
ALTER TABLE [dbo].[Venta]  WITH CHECK ADD  CONSTRAINT [FK_VentaFormaPago] FOREIGN KEY([IdFormaPago])
REFERENCES [dbo].[FormaPago] ([IdFormaPago])
GO
ALTER TABLE [dbo].[Venta] CHECK CONSTRAINT [FK_VentaFormaPago]
GO
/****** Object:  StoredProcedure [dbo].[ActualizarProducto]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[ActualizarProducto] 
	-- Add the parameters for the stored procedure here
	@IdProducto int,
	@Nombre VARCHAR(50),
	@Descripcion Varchar(180),
	@Precio float,
	@EdadMinima int,
	@EdadMaxima int,
	@Fotografia text,
	@IdMarca int

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here

	
	UPDATE Producto SET [Nombre] = @Nombre, [EdadMinima]=@EdadMinima,[EdadMaxima]=@EdadMaxima,[Descripcion]=@Descripcion,[Precio]=@Precio,[Fotografia]=@Fotografia, [IdMarca]=@IdMarca where IdProducto = @IdProducto



	END


GO
/****** Object:  StoredProcedure [dbo].[InsertarBitacora]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[InsertarBitacora]
	-- Add the parameters for the stored procedure here
	@Total float,
	@IdBitacora int out

AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	 insert into dbo.Bitacora (FechaAbastecimiento, Total, Activo) 
	 values (Getdate(), @Total, 1) 
    -- Insert statements for procedure here
	set @IdBitacora= SCOPE_IDENTITY ();
END



/****** Object:  StoredProcedure [dbo].[InsertarDetalleBitacora]    Script Date: 24/10/2017 11:45:01 ******/
SET ANSI_NULLS ON
GO
/****** Object:  StoredProcedure [dbo].[InsertarCliente]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[InsertarCliente] 
	-- Add the parameters for the stored procedure here
	@Nombre varchar(50),
	@ApellidoPaterno varchar(50),
	@ApellidoMaterno varchar(50),
	@Genero varchar(2),
	@Rfc varchar(13),
	@FechaNacimiento varchar(20),
	@Cp varchar(15),
	@Domicilio varchar(120),
	@Fotografia text,
	@Email varchar(20),
	@Telefono varchar(20),
	@Curp varchar(20),
	@IdPersonaGenerado int out,
	@IdClienteGenerado int out
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO Persona(Nombre,ApellidoPaterno,ApellidoMaterno,Genero,Rfc,Curp,FechaNacimiento,Cp,Fotografia,Domicilio)
	VALUES (@Nombre,@ApellidoPaterno,@ApellidoMaterno,@Genero,@Rfc,@Curp, CONVERT(DATE, @FechaNacimiento,103),@Cp,@Fotografia,@Domicilio)

	SET @IdPersonaGenerado = SCOPE_IDENTITY()

	INSERT INTO Cliente(Email,Telefono,IdPersona,Activo)
	VALUES (@Email,@Telefono,@IdPersonaGenerado,1)
	SET @IdClienteGenerado = SCOPE_IDENTITY()
END
GO
/****** Object:  StoredProcedure [dbo].[InsertarDetalleBitacora]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[InsertarDetalleBitacora]
	-- Add the parameters for the stored procedure here
	@idBitacora int,
	@idProducto int,
	@cantidad int,
	@PrecioCompra float
	

	
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	--SELECT @id=id, @cuenta=COUNT(id) from Person where @Nickname=Nickname and @Contrasena=Contrasena and @Nombre=Nombre 
	--and @Apellido=Apellido and @edad=edad group by id;
	--if @cuenta=0 begin set @id=0 end 
	insert into dbo.DetalleBitacora(IdBitacora,IdProducto,Cantidad,PrecioCompra) 
	values (@idBitacora,@idProducto,@cantidad,@PrecioCompra)

END


/****** Object:  StoredProcedure [dbo].[pa_supBitacora]    Script Date: 24/10/2017 11:45:18 ******/
SET ANSI_NULLS ON
GO
/****** Object:  StoredProcedure [dbo].[InsertarEmpleado]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[InsertarEmpleado]
	@Nombre VARCHAR(50),
	@ApellidoPaterno Varchar(50),
	@ApellidoMaterno Varchar(50),
	@Genero VARCHAR(2),
	@Rfc VARCHAR(13),
	@FechaNacimiento date,
	@Cp VARCHAR(15),
	@Domicilio VARCHAR(120),
	@Fotografia TEXT,
	@Curp VARCHAR(20),
	@Salario float,
	@Codigo VARCHAR(20),
	@Password varchar(64),
	@IdRol int,
	@IdPersonaGenerado INT out,
	@IdEmpleadoGenerado INT out,
	@IdUsuarioGenerado INT out
AS
BEGIN
Declare @Username VARCHAR(20) = @Codigo
INSERT INTO Persona(Nombre,ApellidoPaterno,ApellidoMaterno,Genero,Rfc,Curp,FechaNacimiento,Cp,Fotografia,Domicilio)
	VALUES (@Nombre,@ApellidoPaterno,@ApellidoMaterno,@Genero,@Rfc,@Curp,@FechaNacimiento,@Cp,@Fotografia,@Domicilio)

	SET @IdPersonaGenerado = SCOPE_IDENTITY()

	Insert INTO Usuario(Password, Username, Activo, IdRol)
	Values (@Password,@Username,1,@IdRol)

	SET @IdUsuarioGenerado = SCOPE_IDENTITY()

	Insert INTO Empleado(Salario, FechaIngreso, Codigo, IdPersona, Activo,IdUsuario)
	Values (@Salario,GETDATE(),@Codigo,@IdPersonaGenerado,1,@IdUsuarioGenerado)

	SET @IdEmpleadoGenerado = SCOPE_IDENTITY()
END
--exec dbo.InsertarEmpleado @Nombre='a',@ApellidoPaterno='a',@ApellidoMaterno='a',@Genero='M',@Rfc='a',@FechaNacimiento='2017-10-24',@Cp='a',@Domicilio='a',
--@Fotografia='',@Curp='a',@Salario=2,@Codigo='a',@Password='a',@IdRol=1,@IdPersonaGenerado=0,@IdEmpleadoGenerado=0,@IdUsuarioGenerado=0
GO
/****** Object:  StoredProcedure [dbo].[InsertarProducto]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[InsertarProducto] 
	-- Add the parameters for the stored procedure here
	@Nombre VARCHAR(50),
	@Descripcion Varchar(180),
	@Precio float,
	@EdadMinima int,
	@EdadMaxima int,
	@Fotografia text,
	@IdMarca int,
	@IdProductoGenerado INT out
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here

	
	INSERT INTO Producto(Nombre,EdadMinima,EdadMaxima,Descripcion,Precio,Stock,Fotografia, IdMarca,Activo)
	VALUES (@Nombre,@EdadMinima,@EdadMaxima,@Descripcion,@Precio,0,@Fotografia, @IdMarca,1)

	SET @IdProductoGenerado = SCOPE_IDENTITY()
	END


GO
/****** Object:  StoredProcedure [dbo].[pa_del_venta]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[pa_del_venta] 
	-- Add the parameters for the stored procedure here
	@IdVenta int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE dbo.Venta SET Activo = 0 WHERE IdVenta = @IdVenta
END
GO
/****** Object:  StoredProcedure [dbo].[pa_EliminarEmpleado]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pa_EliminarEmpleado]
	@IdEmpleado INT,
	@IdUsuario int
AS
BEGIN
	UPDATE Empleado SET Activo = 0 WHERE IdEmpleado = @IdEmpleado;
	UPDATE Usuario SET Activo = 0 WHERE IdUsuario = @IdUsuario;
END
GO
/****** Object:  StoredProcedure [dbo].[pa_EliminarProducto]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pa_EliminarProducto]
	@IdProducto INT
AS
BEGIN
	UPDATE Producto SET Activo = 0 WHERE IdProducto = @IdProducto;
END
GO
/****** Object:  StoredProcedure [dbo].[pa_ins_detalleVenta]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[pa_ins_detalleVenta] 
	-- Add the parameters for the stored procedure here
	@CantidadProducto int,
	@Precio float,
	@IdVenta int,
	@IdProducto int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO dbo.DetalleVenta (CantidadProducto,Precio,IdVenta,IdProducto)
	VALUES (@CantidadProducto,@Precio,@IdVenta,@IdProducto)
END
GO
/****** Object:  StoredProcedure [dbo].[pa_ins_RealizarVenta]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[pa_ins_RealizarVenta] 
	-- Add the parameters for the stored procedure here
	@IdEmpleado int,
	@IdCliente int,
	@IdFormaPago int,
	@Total float,
	@IdVenta int out
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO dbo.Venta (Fecha,IdEmpleado,IdCliente,IdFormaPago,Total,Activo)
	VALUES (CONVERT(DATE, GETDATE(),103),@IdEmpleado,@IdCliente,@IdFormaPago,@Total,1)

	SET @IdVenta = SCOPE_IDENTITY()
END
GO
/****** Object:  StoredProcedure [dbo].[pa_sel_detalleVenta]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[pa_sel_detalleVenta] 
	-- Add the parameters for the stored procedure here
	@IdVenta int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT  p.Nombre as Producto,
			p.Descripcion,
			p.Precio,
			d.CantidadProducto,
			d.Precio as Total,
			p.Fotografia,
			m.Nombre as Marca
	FROM DetalleVenta d
			INNER JOIN Venta v ON d.IdVenta = v.IdVenta
			INNER JOIN Producto p ON d.IdProducto = p.IdProducto
			INNER JOIN Marca m ON p.IdMarca = m.IdMarca
			WHERE v.IdVenta = @IdVenta
END
GO
/****** Object:  StoredProcedure [dbo].[pa_sel_formaPago]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[pa_sel_formaPago] 
	-- Add the parameters for the stored procedure here
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT * FROM dbo.FormaPago
END
GO
/****** Object:  StoredProcedure [dbo].[pa_sel_productos]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[pa_sel_productos] 
	-- Add the parameters for the stored procedure here
	@Nombre varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT IdProducto,p.Nombre as Producto,Descripcion,Precio,Stock,m.Nombre as Marca FROM dbo.Producto p
	INNER JOIN dbo.Marca m ON m.IdMarca = p.IdMarca
	WHERE p.Nombre LIKE '%'+@Nombre+'%' and Activo = 1 and p.Stock > 0
END
GO
/****** Object:  StoredProcedure [dbo].[pa_sel_venta]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[pa_sel_venta]
	-- Add the parameters for the stored procedure here
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT  v.IdVenta,
			v.Fecha,
			v.IdEmpleado,
			pe.Nombre as Empleado,
			v.IdCliente,
			pc.Nombre as Cliente,
			v.Total,
			f.Descripcion
	FROM Venta v
			INNER JOIN Empleado e ON v.IdEmpleado = e.IdEmpleado
			INNER JOIN Cliente c ON v.IdCliente = c.IdCliente
			INNER JOIN FormaPago f ON v.IdFormaPago = f.IdFormaPago
			INNER JOIN Persona pc ON pc.IdPersona = c.IdPersona
			INNER JOIN Persona pe ON pe.IdPersona = e.IdPersona
			WHERE v.Activo = 1
END
GO
/****** Object:  StoredProcedure [dbo].[pa_supBitacora]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pa_supBitacora]
	@IdBitacora INT
AS
BEGIN
	UPDATE Bitacora SET Activo = 0 WHERE IdBitacora = @IdBitacora;
END




/****** Object:  Trigger [dbo].[TR_bitacora]    Script Date: 24/10/2017 11:45:35 ******/
SET ANSI_NULLS ON
GO
/****** Object:  StoredProcedure [dbo].[UpdateEmpleado]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[UpdateEmpleado]
	@IdPersona int,
	@Nombre varchar(50),
	@ApellidoPaterno varchar(50),
	@ApellidoMaterno varchar(50),
	@Genero varchar(2),
	@Rfc varchar(14),
	@Curp varchar(20),
	@FechaNacimiento date,
	@Cp varchar(15),
	@Fotografia text,
	@Domicilio varchar(128),
	@IdEmpleado int,
	@Salario float,
	@Codigo varchar(20),
	@Password varchar(64),
	@IdUsuario int,
	@IdRol int
AS
BEGIN
	UPDATE Persona SET Nombre = @Nombre, ApellidoPaterno = @ApellidoPaterno, ApellidoMaterno = @ApellidoMaterno, 
					   Genero = @Genero, Rfc = @Rfc, Curp = @Curp, FechaNacimiento = CONVERT(DATE, @FechaNacimiento, 103), 
	                   Cp = @Cp, Fotografia = @Fotografia, Domicilio = @Domicilio
	WHERE IdPersona = @IdPersona;

	UPDATE Empleado SET Codigo = @Codigo, Salario = @Salario, Activo = 1, IdPersona = @IdPersona
	WHERE IdEmpleado = @IdEmpleado

	UPDATE Usuario Set Username = @Codigo, Password = @Password, IdRol = @IdRol
	WHERE IdUsuario = @IdUsuario
END
GO
/****** Object:  StoredProcedure [dbo].[uspActualizarEmpleado]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[uspActualizarEmpleado]
	   @IdE int
	  ,@IdP int
	  ,@Nombre varchar(50)
      ,@ApellidoPaterno varchar(50)
      ,@ApellidoMaterno varchar(50)
      ,@Genero varchar(2)
      ,@Rfc varchar(13)
      ,@Curp varchar(20)
      ,@FechaNacimiento varchar(20)
      ,@Cp varchar(15) 
      ,@Fotografia text
      ,@Domicilio varchar(128)
      ,@Salario float
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	UPDATE Persona SET
	[Nombre] =@Nombre
      ,[ApellidoPaterno]=@ApellidoPaterno
      ,[ApellidoMaterno]=@ApellidoMaterno
      ,[Genero]=@Genero
      ,[Rfc]=@Rfc
      ,[Curp]=@Curp
      ,[FechaNacimiento]=CONVERT(date,@FechaNacimiento,103)
      ,[Cp]=@Cp
      ,[Fotografia]=@Fotografia
      ,[Domicilio]=@Domicilio
	  WHERE IdPersona=@IdP;

	UPDATE Empleado SET
	   [Salario]=@Salario
     	WHERE
		IdEmpleado=@IdE

		END
GO
/****** Object:  StoredProcedure [dbo].[uspConsultarUsuarioEmpleadoPorNombre]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[uspConsultarUsuarioEmpleadoPorNombre]
      @nombre varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	SELECT
	Persona.IdPersona
	,IdEmpleado
	,Persona.[Nombre]
      ,[ApellidoPaterno]
      ,[ApellidoMaterno]
      ,CONVERT(nvarchar,[FechaNacimiento],103)  as FechaNacimiento
      ,[CURP]
      ,[RFC]
	  ,Cp
      ,[Genero]
	  ,Domicilio
	  ,Fotografia
      ,CONVERT(nvarchar,[FechaIngreso],103) AS FechaIngreso
      ,[Salario]
      ,[Codigo]
	  ,Rol.Descripcion
	  ,Rol.IdRol
	  ,Username
	  ,Usuario.Activo as ActivoUs
	  ,Empleado.Activo as ActivoEm
	  ,Usuario.IdUsuario
	   FROM Empleado
	  INNER JOIN Persona ON Persona.IdPersona=Empleado.IdPersona
	  INNER JOIN Usuario ON Usuario.IdUsuario=Empleado.IdUsuario
	  INNER JOIN Rol ON Rol.IdRol=Usuario.IdRol 
	  WHERE Empleado.Activo=1 AND (Persona.Nombre like('%'+@nombre+'%') OR Persona.ApellidoPaterno like('%'+@nombre+'%') OR Persona.ApellidoMaterno like('%'+@nombre+'%') );
END
GO
/****** Object:  StoredProcedure [dbo].[uspEliminarEmpleado]    Script Date: 10/11/2017 01:01:15 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[uspEliminarEmpleado]
	   @ID int
      
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	UPDATE Empleado SET
	   [Activo]=0 
	   WHERE
		IdEmpleado=@ID
END

GO
