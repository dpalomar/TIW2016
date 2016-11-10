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

    <title>Wallapop - Mi Perfil</title>

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
        <li style="color: white" ><b><i>Mi Perfil</i></b></li>
      </ol>

    </nav>

   <div class="row">
   <div class="container well">
       <div class="col-sm-10">
		<div class="row">
				<div class="col-xs-12"><h2>Tu Perfil de Usuario</h2></div>
                
        </div>
		<br /><br />
 
		<form action="usuario" class="form-horizontal" method="post"><div class="form-group">
					    <label class="col-sm-2 control-label" for="inputNombre">Nombre</label>
					    <div class="col-sm-4">
					      <input class="form-control" type="text" id="inputNombre" placeholder="Nombre">
					    </div>
					  </div>
 
					  <div class="form-group">
					    <label class="col-sm-2 control-label" for="inputApellidos">Apellidos</label>
					    <div class="col-sm-4">
					      <input class="form-control" type="text" id="inputApellidos" placeholder="Apellidos">
					    </div>
					  </div>
            
                        <div class="form-group">
                          <label for="inputCiudad" class="col-sm-2 control-label">Ciudad</label>
                          <div class="col-sm-4">
                          <input type="text" id="inputCiudad" class="form-control" placeholder="Ciudad" required>
                          </div>
                        </div>
 
					  <div class="form-group">
					    <label for="inputEmail" class="col-sm-2 control-label" for="formGroup">Email</label>
					    <div class="col-sm-4">
					      <input class="form-control" type="text" id="inputEmail" placeholder="Email">
					      
					    </div>
					  </div>
            
                      <div class="form-group">
                              <label for="inputPassword" class="col-sm-2 control-label">Contraseña</label>
                              <div class="col-sm-4">
                                <input type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required>
                              </div>
                      </div>

						<br />
                        
        </div>
        <div class="col-sm-2">
            <img class="form-group img-rounded center-block img-responsive" src="http://www.holatours.com/img/person256.png" alt="Generic placeholder image" width="250">
        </div>
 
						<div class="form-group">
					    <label class="col-sm-2 control-label" for="formGroup"></label>
					    <div class="col-sm-4">
					      
							<button type="submit" class="btn btn-success btn-lg"><span class="glyphicon glyphicon-floppy-saved"></span> Guardar</button>
							
							<button type="button" class="btn btn-danger btn-lg"><span class="glyphicon glyphicon-remove-circle"></span> Cancelar</button>
 							<input type="hidden" name="accion" value="EDITAR">
 
					    </div>
					  </div> </form>
 
					
 
 
 
		
 
 
 
	
    </div>
   

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