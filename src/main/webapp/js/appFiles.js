$(document).ready(function () {

    var menu = [{
        name: 'Descargar',
        img: 'img/download-solid.svg',
        title: 'create button',
        fun: function () {
            alert('i am add button')
        }
    }, {
        name: 'Compartir',
        img: 'img/share-solid.svg',
        title: 'share button',
        fun: function () {
            alert('i am update button')
        }
    }];

    //Calling context menu
    $('.contextMenu').contextMenu(menu);

    //mensaje success
    alertify.success('Success message');

});