$(document).ready(function () {

    //Actualiza el id del archivo que presiono
    $('.getId').on('click', function(){
       $('#idArchivo').val($(this).data('id'));

    });

    //Copia a portapapeles
    $('.btnCopy').on('click', function(){
        copyToClipboard(document.getElementById("sharedLink"));

    });

    var menu = [{
        name: 'Descargar',
        img: 'img/download-solid.svg',
        title: 'create button',
        fun: function () {

            window.location.replace("downloadLink?link="+$('#idArchivo').val());


        }
    }, {
        name: 'Compartir',
        img: 'img/share-solid.svg',
        title: 'share button',
        fun: function () {

            $('#sharedLink').val("http://localhost:8080/HugBox/downloadLink?link="+$('#idArchivo').val());
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

    //https://stackoverflow.com/questions/22581345/click-button-copy-to-clipboard-using-jquery
    function copyToClipboard(elem) {
        // create hidden text element, if it doesn't already exist
        var targetId = "_hiddenCopyText_";
        var isInput = elem.tagName === "INPUT" || elem.tagName === "TEXTAREA";
        var origSelectionStart, origSelectionEnd;
        if (isInput) {
            // can just use the original source element for the selection and copy
            target = elem;
            origSelectionStart = elem.selectionStart;
            origSelectionEnd = elem.selectionEnd;
        } else {
            // must use a temporary form element for the selection and copy
            target = document.getElementById(targetId);
            if (!target) {
                var target = document.createElement("textarea");
                target.style.position = "absolute";
                target.style.left = "-9999px";
                target.style.top = "0";
                target.id = targetId;
                document.body.appendChild(target);
            }
            target.textContent = elem.textContent;
        }
        // select the content
        var currentFocus = document.activeElement;
        target.focus();
        target.setSelectionRange(0, target.value.length);

        // copy the selection
        var succeed;
        try {
            succeed = document.execCommand("copy");
        } catch(e) {
            succeed = false;
        }
        // restore original focus
        if (currentFocus && typeof currentFocus.focus === "function") {
            currentFocus.focus();
        }

        if (isInput) {
            // restore prior selection
            elem.setSelectionRange(origSelectionStart, origSelectionEnd);
        } else {
            // clear temporary content
            target.textContent = "";
        }
        return succeed;
    }


});