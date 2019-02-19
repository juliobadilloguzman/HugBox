$(document).ready(function(){

    $('#errorIncorrectCredentials').hide();
    $('#errorFormatEmail').hide();
    $('#errorFormatPassword').hide();

    //Login
    $('#btn-login').on('click', function(){

        if(isValidEmail($('#email'))){

            $.ajax({

                url: "login",
                method: "POST",
                cache:false,
                data: {
                    email: $('#email').val(),
                    password: $('#password').val()
                },
                success: function(response){

                    if(response=="error"){

                        $('#errorIncorrectCredentials').show();


                    }else{

                        window.location.replace("home.jsp");

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

    function isValidPassword(input) {

        var m = input.val();

        var expreg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{8,14}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }
   

});