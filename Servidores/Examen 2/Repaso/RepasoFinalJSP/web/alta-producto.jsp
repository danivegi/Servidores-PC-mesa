<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Documento sin título</title>
</head>

<body>

<table width="100%" border="0">
  <tr>
    <td colspan="7" bgcolor="#333333">&nbsp;</td>
  </tr>
  <tr align="center">
    <td colspan="7" bgcolor="#CCCCCC"><h1>APLICACIÓN DE GESTIÓN COMERCIAL</h1></td>
  </tr>
  
  <tr align="center">
      <td><a href="ventas.jsp"><img src="imagenes/ventas.jpg" width="180" height="123" /></a></td>
    <td></td>
    <td><a href="productos.jsp"><img src="imagenes/productos.jpg" width="180" height="123" /></a></td>
  </tr>
    <tr align="center">
        <td><a href="nueva-venta.jsp">Nueva venta</a></td>
        <td></td>
        <td><a href="alta-producto.jsp">Alta de producto</a></td>
    </tr>
    <tr align="center">
        <td><a href="listado-ventas.jsp">Listado de ventas</a></td>
        <td></td>
        <td><a href="baja-producto.jsp">Baja de productos</a></td>
    </tr>
    <tr align="center">
        <td></td>
        <td></td>
        <td><a href="mod-producto.jsp">Modificación de producto</a></td>
    </tr>
  <tr>
    <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td> 
  </tr>
  <tr align="center">
    <td colspan="7">
    
        <h3>Añadir un nuevo producto</h3>
        
        <form method="post" action="ServletProducto">
            <label>Referencia</label>
            <input type="text" name="referencia" id="referencia"></input><br></br>
            
            <label>Nombre</label>
            <input type="text" name="nombre" id="nombre"></input><br></br>
            
            <label>Descripcion</label>
            <input type="text" name="descripcion" id="descripcion"></input><br></br>
            
            <label>Precio</label>
            <input type="text" name="precio" id="precio"></input><br></br>
            
            <label>Descuento</label>
            <input type="text" name="descuento" id="descuento"></input><br></br>
            
            <input type="submit" value="Aceptar"></input>
            <input type="reset" value="Cancelar"></input>
        </form>
        

    </td>
  </tr>
  
  <tr>
    <td colspan="7">&nbsp;</td>
  </tr>
  <tr>
    <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td>
  </tr>
</table>

</body>
</html>