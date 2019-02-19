$(document).ready(function(){

    $('#errorFormatEmail').hide();
    $('#errorFormatPassword').hide();



    $('#btn-signUp').on('click', function(){

        if(isValidEmail($('#email'))){

            $.ajax({

                url: "signUp",
                method: "POST",
                cache: false,
                data: {
                    email: $('#email').val(),
                    password: $('#password').val()
                },
                success: function(response){
                    if(response != "error"){


                        swal({
                            title: "Buen Trabajo!",
                            text: "Cuenta creada satisfactoriamente",
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
                                window.location.replace("index.jsp");
                                break;


                            }
                        });



                    }else{
                        swal ( "Error!" ,  "Ya existe una cuenta con ese correo" ,  "error" );
                    }
                }

            });

        }


    });

    //Validaciones
    function isValidEmail(input) {

        var m = input.val();

        var expreg = /^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            $('#errorFormatEmail').show();
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
            $('#errorFormatEmail').hide();
        }

        return true;
    }


});