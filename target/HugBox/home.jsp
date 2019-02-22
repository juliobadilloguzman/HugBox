<%--
  Created by IntelliJ IDEA.
  User: julioguzman
  Date: 2019-02-18
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="input" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <link rel="stylesheet" href="css/fontawesome-all.min.css">
    <link rel="stylesheet" href="css/stylesHome.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
          crossorigin="anonymous">
    <link rel="stylesheet" href="css/contextMenu.css">
    <!-- CSS -->
    <link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/css/alertify.min.css" />
    <!-- Default theme -->
    <link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/css/themes/default.min.css" />
    <!-- Semantic UI theme -->
    <link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/css/themes/semantic.min.css" />
    <!-- Bootstrap theme -->
    <link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/css/themes/bootstrap.min.css" />
</head>

<body>

<div class="container-fluid">

    <!-- Navigation -->
    <nav class="row navbar">

        <div class="col-2 p-5 noPadding">
            <img class="logo" src="img/logo2.png" alt="">
        </div>

        <div class="col-4 bg-white">

        </div>

        <div class="col-3">

        </div>

        <div class="col-2">
            <div class="dropdown">
                <button class=" text-white dropStyle btn-sm truncate btn dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">
                    julioxguzman@gmail.com
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">Cerrar Sesión</a>

                </div>
            </div>
        </div>

    </nav>


    <div class="container mb-4">

        <!-- Title -->
        <div class="row containerTitle justify-content-between mt-5">
            <div class="col-2 centerVertically">
                <h5 class="text-secondary">Dashboard</h5>
            </div>
            <div class="col-2 centerVertically">
                <h5 class="text-secondary">Home/Dashboard</h5>
            </div>
        </div>

        <div class="row mt-5">
            <div class="col-4">
                <button type="button" class="buttonStyle btn" data-toggle="modal" data-target="#exampleModalCenter">
                    <i class="fas fa-plus colorPrimary"></i> Cargar archivo
                </button>
            </div>
        </div>


        <!-- Archivos -->

        <input type="hidden" id="idArchivo">

            <div class="card-group mt-5 row" style="width:100% !important">

                <s:iterator value="listaDocumentos">

                    <div class="col-3 mt-3">
                        <div class="card">



                            <s:if test="%{type=='.docx'}">
                                <img class="card-img-top" src="img/types/docx.jpg" alt="Card image cap">
                            </s:if>
                            <s:elseif test="%{type=='.zip'}">
                                <img class="card-img-top" src="img/types/zip.jpg" alt="Card image cap">
                            </s:elseif>
                            <s:elseif test="%{type=='.txt'}">
                                <img class="card-img-top" src="img/types/default.jpg" alt="Card image cap">
                            </s:elseif>
                            <s:elseif test="%{type=='.html'}">
                                <img class="card-img-top" src="img/types/html.jpg" alt="Card image cap">
                            </s:elseif>
                            <s:elseif test="%{type=='.pdf'}">
                                <img class="card-img-top" src="img/types/pdf.jpg" alt="Card image cap">
                            </s:elseif>
                            <s:elseif test="%{type=='.jpg'}">
                                <img class="card-img-top" src="img/types/image.jpg" alt="Card image cap">
                            </s:elseif>
                            <s:elseif test="%{type=='.jpeg'}">
                                <img class="card-img-top" src="img/types/image.jpg" alt="Card image cap">
                            </s:elseif>
                            <s:elseif test="%{type=='.gif'}">
                                <img class="card-img-top" src="img/types/image.jpg" alt="Card image cap">
                            </s:elseif>
                            <s:elseif test="%{type=='.png'}">
                                <img class="card-img-top" src="img/types/image.jpg" alt="Card image cap">
                            </s:elseif>
                            <s:elseif test="%{type=='.rar'}">
                                <img class="card-img-top" src="img/types/image.jpg" alt="Card image cap">
                            </s:elseif>
                            <s:elseif test="%{type=='.js'}">
                                <img class="card-img-top" src="img/types/js.jpg" alt="Card image cap">
                            </s:elseif>
                            <s:elseif test="%{type=='.svg'}">
                                <img class="card-img-top" src="img/types/svg.jpg" alt="Card image cap">
                            </s:elseif>
                            <s:else>
                                <img class="card-img-top" src="img/types/file.jpg" alt="Card image cap">
                            </s:else>



                            <div class="card-body">
                                <button data-target=".shareModal" class="contextMenu text-muted removeButtonStyle styleButton getId" data-id='<s:property value="%{link}" />'>
                                    <s:property value="%{filename}" /><s:property value="%{type}" />
                                </button>
                            </div>

                        </div>
                    </div>

                </s:iterator>

            </div>


    </div>


</div>


<!-- MODALES -->

<!--MODAL SUBIR ARCHIVO -->

<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Subir archivo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="file">
                    <div class="form-group">
                        <form>
                            <input type="file" class="form-control-file" name="content" id="archivo">
                            <input type="hidden" id="fileName"/>
                            <input type="hidden" id="type"/>
                        </form>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary bRadius" data-dismiss="modal">Cerrar</button>
                <button type="button" class="btn colorPrimaryBg text-white bRadius" id="btn-fileUpload">Subir</button>
            </div>
        </div>
    </div>
</div>

<!--MODAL COMPARTIR LINK-->

<div class="modal fade bd-example-modal-lg shareModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Link para compartir</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <input type="text" class="form-control" id="sharedLink">
                    </div>
                    <div class="col-2">
                        <button class="btn btn-primary bRadius">Copiar</button>
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
<script src="http://cdn.jsdelivr.net/npm/alertifyjs@1.11.2/build/alertify.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="js/contextMenu.js"></script>
<script src="js/appFiles.js"></script>
