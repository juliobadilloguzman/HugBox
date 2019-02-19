$(document).ready(function(){


    $('#btn-signUp').on('click', function(){

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

    });


});