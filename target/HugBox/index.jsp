<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>HugBox | Inicio</title>
    <link rel="stylesheet" href="css/stylesIndex.css">

    <link rel="stylesheet" href="css/fontawesome-all.min.css">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
          crossorigin="anonymous">
</head>

<body>

<!-- Container -->
<div class="form-body without-side">

    <!-- Logo -->
    <div class="website-logo">

        <div class="logo">
            <img class="logo-size" src="img/logo1.png" alt="">
        </div>

    </div>


    <div class="row">

        <div class="form-holder">
            <div class="form-content">
                <div class="form-items text-center">
                    <h3 class="text-center">¡Bienvenido de nuevo!</h3>
                    <p class="text-center">Nos da gusto que estes de vuelta</p>

                        <input class="form-control" type="email" placeholder="Correo Electrónico" required id="email">
                        <!-- <span class="text-danger mb-2">Incorrecto</span> -->
                        <input class="form-control" type="password" placeholder="Contraseña" required id="password">
                        <!-- <span class="text-danger">Incorrecto</span> -->

                        <!-- BOTON -->
                        <div class="form-button">
                            <button type="button" id="btn-login" class="ibtn">Ingresar</button>
                        </div>


                    <div class="page-links mt-3">
                        <a href="registro.jsp">Crear nueva cuenta</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- SCRIPTS -->
<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
        crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
        crossorigin="anonymous"></script>
<script src="js/appLogin.js"></script>

</body>

</html>