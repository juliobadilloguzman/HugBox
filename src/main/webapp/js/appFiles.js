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

    //mensaje success
    alertify.success('Success message');

});