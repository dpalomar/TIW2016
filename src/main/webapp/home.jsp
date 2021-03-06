
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Wallapop - Registro</title>

    <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="http://getbootstrap.com/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="http://getbootstrap.com/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  <style type="text/css">
  
    
    body {
  padding-top: 50px;
}
  </style>




  </head>

  <body>





    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" style="padding: 7px;"><img src="https://lh3.googleusercontent.com/eiHGogXLz3iBRZhKrdr7FOkw6q5P_iuGSwqGWmd1yRzMcc-B7V6xIKR9wzuqDrD61K4=w300" alt="Wallapop" height="38" width="38" ></a> 
        <a class="navbar-brand" href="MisProductos">Wallapop TIW</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-left">
              <li class="active"><a href="home.jsp"><span class="glyphicon glyphicon-home"></span> Home</a></li>
              <li><a href="MisProductos"><span class="glyphicon glyphicon-list-alt"></span> Mis productos</a></li>
              <li><a href="Perfil.jsp"><span class="glyphicon glyphicon-user"></span> Mi perfil</a></li>
            </ul>
           <ul class="nav navbar-nav navbar-right">
              <li><a href="usuario?id=${usuario.id }&accion=SALIR }"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul> 
        </div><!--/.navbar-collapse -->
      </div>
    </nav>


    <nav class="navbar">

      <ol class="breadcrumb" style="background-color: #23C5B2; color: white">
        <li><a href="home.jsp" style="color: white"><b>Home</b></a></li>
      </ol>

    </nav>


    <div class="container text-center" style="padding: 15px">
      <div class="row">

        <div class="col-md-3 well">
        
          <div class="well"  style="background-color: white">
          <h4>Búsqueda Simple</h4>
            <form class="form-group input-group" role="search" action="busqueda" method="post">
              <input type="text" class="form-control" placeholder="Buscar.." name="busqueda">
              <span class="input-group-btn">
                <button class="btn btn-default" type="submit">
                  <span class="glyphicon glyphicon-search"></span>
                </button>
              </span>
            </form>
          </div>
          <div class="well"  style="background-color: white">
          <h4>B&uacute;squeda Avanzada</h4>
            <div class="form-group input-group">
              <input type="text" class="form-control" placeholder="Buscar..">
              <span class="input-group-btn">
                <button class="btn btn-default" type="button">
                  <span class="glyphicon glyphicon-search"></span>
                </button>
              </span>
            </div>
          </div>
        </div>


        <div class="col-md-9 well" style="background-color: white">
        <h2>Bienvenido ${sessionScope.usuario.nombre}</h2>
        




		
        <c:forEach items="${productos }" var="producto">
      

	        <div class="col-md-4 well">
				
	         <!--   <img src="${usuario.apellidos }" alt="Generic product" width="240" height="180">  -->
	          <h2>${producto.titulo}</h2>
	          <p><a class="btn btn-info" href="producto?id={producto.id }&accion=VER" role="button">View details &raquo;</a></p>
	        </div><!-- /.col-lg-4 -->
	      
	     </c:forEach>

	
      	</div>
    
    </div>
    
    </div>


      <!-- Three columns of text below the carousel -->


      <footer style="background-color: #555;
      color: white;
      padding: 15px;">
        <p>&copy; 2016 Company, Inc.</p>
      </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>