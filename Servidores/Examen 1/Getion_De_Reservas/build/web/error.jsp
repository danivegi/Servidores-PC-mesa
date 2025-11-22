<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    

        <body>
    <div><img src="Logo1.png" alt="" width="200" height="200">
          
      <table width="842" border="0">
          <tr>
            <td align="center" bgcolor="#D3A66D"><p>&nbsp;</p>
              <h2>ERROR!</h2>
              <%
                  String errores = (String) getServletContext().getAttribute("errores");
                  out.println(errores + ".");
              %>
            <p>&nbsp;</p></td>
          </tr>
          <tr>
            <td align="center" bgcolor="#D3A66D"><h3>Los siguientes datos son erroneos: xxxx, xxxx </h3></td>
          </tr>
        </table>
          
    </div>
    
    </body>
</html>