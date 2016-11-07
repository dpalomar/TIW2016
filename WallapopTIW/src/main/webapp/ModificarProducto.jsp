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

    <title>Wallapop - Modificar Producto</title>

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

  #googleMap {
    width: 100%; /* Span the entire width of the screen */
    height: 250px; /* Set the height to 400 pixels */

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
          <a class="navbar-brand" href="#" style="padding: 7px;"><img src="https://lh3.googleusercontent.com/eiHGogXLz3iBRZhKrdr7FOkw6q5P_iuGSwqGWmd1yRzMcc-B7V6xIKR9wzuqDrD61K4=w300" alt="Wallapop" height="38" width="38" ></a> 
        <a class="navbar-brand" href="#">Wallapop TIW</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-left">
              <li><a href="#"><span class="glyphicon glyphicon-home"></span> Home</a></li>
              <li><a href="#"><span class="glyphicon glyphicon-list-alt"></span> Mis productos</a></li>
              <li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span> Mi perfil</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li><a href="#"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
            </ul> 
        </div><!--/.navbar-collapse -->
      </div>
    </nav>

    <nav class="navbar">

      <ol class="breadcrumb" style="background-color: #23C5B2; color: white">
        <li><a href="#" style="color: black"><b>Home</b></a></li>
          <li><a href="#" style="color: black"><b>Mis Productos</b></a></li>
        <li style="color: white" ><b><i>Modificar Producto</i></b></li>  
      </ol>

    </nav>

     <div class="row">
   <div class="container well">
		<div class="row">
				<div class="col-md-12"><h2>Actualiza los datos del producto</h2></div>
                
        </div>
		<br /><br />
 
		<form class="form-horizontal">
 
					<form class="form-signin">
      
          </br>
          
          <div class="form-group">
          <label for="inputTituloProducto" class="sr-only">Titulo del Producto</label>
          <input type="text" id="inputTituloProducto" class="form-control" placeholder="Título del Producto" required autofocus>
          </div>
          
          <div class="form-group">
          <label for="inputCategoria" class="sr-only">Categoria</label>
          <select id="inputCategoria" class="form-control" required>
            <option value="electronica" selected>Electr&oacute;nica</option>
            <option value="moda">Moda y Complementos</option>
            <option value="automoviles">Coches y Motos</option>
            <option value="entretenimiento">Libros, Pel&iacute;culas y M&uacute;sica</option>
            <option value="deporte">Deporte y ocio</option>
            <option value="electrodomesticos">Electodom&eacute;sticos</option>
            <option value="inmobiliaria">Inmobiliaria</option>
            <option value="ninos">Ni&ntilde;os y Beb&eacute;s</option>  
            <option value="gaming">Consolas y Videojuegos</option> 
            <option value="servicios">Servicios</option> 
            <option value="deco">Muebles, Deco y Jard&iacute;n</option>
            <option value="otros">Otros</option>
           </select>
          </div>

          <div class="form-group">
          <label for="inputDescripcion" class="sr-only">Descripcion</label>
          <input type="text" id="inputDescripcion" class="form-control" placeholder="Descripción" maxlength="500" required>
          </div>

          <div class="row">
            <div class="col-md-10">
              <div class="form-group">
                <label for="inputPrecio" class="sr-only">Precio</label>
                <input type="number" id="inputPrecio" class="form-control" placeholder="Precio" required>
              </div>
            </div>
            <div class="col-md-2">
             <label for="inputDivisa" class="sr-only">Divisa</label>
             <select id="inputDivisa" class="form-control" required>
                <option value="euro" selected>€</option>
                <option value="dolarAmericao">USD</option>
                <option value="libraEsterlina">GBP</option>
                <option value="realBrasileno">BRL</option>
                <option value="pesoColombiano">COP</option>
                <option value="pesoMexicano">MXN</option>
                <option value="pesoArgentino">ARS</option> 
             </select>
            </div>
          </div>
          
           <div class="form-group">
          <label for="inputEstado">Estado del Producto</label>
          <select id="inputEstado" class="form-control" required>
            <option value="electronica" selected>Vendido</option>
            <option value="moda">Reservado</option>
            <option value="automoviles" selected>Disponible</option>
           </select>
          </div>
          
           <div class="form-group">
            <label for="inputImagenProducto">Imagen del Producto</label>
            <input type="file" accept=".jpg, image/*" id="inputImagenProducto">
            <p class="help-block">La foto tiene que estar en formato jpg.</p>
            </div>
						<br />
                        
        <div class="col-md-2">
            <img class="img-rounded center-block img-responsive" src="http://cdn.wallapop.com/shnm-portlet/images?pictureId=253765517&pictureSize=W640" alt="Generic placeholder image" height="240">
        </div>
 
						<div class="form-group">
					    <label class="col-sm-2 control-label" for="formGroup"></label>
					    <div class="col-sm-4">
					      
							<button type="submit" class="btn btn-success btn-lg"><span class="glyphicon glyphicon-floppy-saved"></span> Guardar</button>
							
							<button type="button" class="btn btn-danger btn-lg"><span class="glyphicon glyphicon-remove-circle"></span> Cancelar</button>
                            </div>
 
 
					    </div>
					  </div>
 
 
 
		</form>	
 
 
 
	
    </div>
   

      <footer style="background-color: #555;
      color: white;
      padding: 15px;">
        <p>&copy; 2016 Company, Inc.</p>
      </footer>
    


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="http://maps.googleapis.com/maps/api/js"></script>
      
      <!-- Script para mostrar el Google Maps de la localización del producto -->
      <script>
      var myCenter = new google.maps.LatLng(41.878114, -87.629798);

      function initialize() {
      var mapProp = {
      center:myCenter,
      zoom:12,
      scrollwheel:false,
      draggable:false,
      mapTypeId:google.maps.MapTypeId.ROADMAP
      };

      var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

      var marker = new google.maps.Marker({
      position:myCenter,
      });

      marker.setMap(map);
      }

      google.maps.event.addDomListener(window, 'load', initialize);
      </script>

  </body>
</html>