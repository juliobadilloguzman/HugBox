$(document).ready(function () {

    //Actualiza el id del archivo que presiono
    $('.getId').on('click', function(){
       $('#idArchivo').val($(this).data('id'));

    });

    var menu = [{
        name: 'Descargar',
        img: 'img/download-solid.svg',
        title: 'create button',
        fun: function () {
            alert("Descargando: " +  $('#idArchivo').val());
        }
    }, {
        name: 'Compartir',
        img: 'img/share-solid.svg',
        title: 'share button',
        fun: function () {
            $('.shareModal').modal('toggle');
        }
    }];

    //Calling context menu
    $('.contextMenu').contextMenu(menu);

    /////////////////////////////////////////////////SUBIR ARCHIVOS

    $('#archivo').change(function(e){

        var fileName = e.target.files[0].name;
        var fileName2 = e.target.files[0].name;

        fileName = fileName.replace(/\.[^/.]+$/, "");

        $('#fileName').val(fileName);

        var type = "."+fileName2.split('.').pop().toLocaleLowerCase();

        $('#type').val(type);

        console.log(document.getElementById('archivo').files);

    });


    $('#btn-fileUpload').on('click', function(){


        var form = $("form")[0];

        var data = new FormData(form);

        data.append("filename", $('#fileName').val());
        data.append("type", $('#type').val());


        $.ajax({

            url: 'fileUpload',
            data: data,
            method: 'POST',
            cache: false,
            encType: "multipart/form-data",
            contentType: false,
            processData: false,
            success: function(response){

                if(response == "error")
                    swal ( "Oops" ,  "No se pudo subir el archivo, intente de nuevo!" ,  "error" );
                else{

                    swal({
                        title: "Buen Trabajo!",
                        text: "Archivo subido satisfactoriamente",
                        icon: "success",
                        buttons: {
                            catch: {
                                text: "Ok!",
                                value: "ok",
                            }
                        },
                    })
                        .then((value) => {

                        switch (value) {


                        case "ok":
                            window.location.replace("files");
                            break;


                        }
                    });

                }


            },
            error: function(){

            }

        });

    });




});