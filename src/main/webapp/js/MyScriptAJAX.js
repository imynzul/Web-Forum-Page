function login() {

    var formData = $('#auth-form').serialize()

    $.ajax({
        url: 'auth',
        data: formData,
        success: function (dataFromServer) {
            if (dataFromServer.status === 'verified'){
                window.location.href = 'profile';
            } else if (dataFromServer.status === 'failed') {
                $('#loginErrorInformer').text(dataFromServer.loginError);
                $('#passErrorInformer').text(dataFromServer.passError);
            } else {
                alert('Stop doing this!!!');
            }
        },
        error: function () {
            alert('WebServer Error');
        }
    });
}


function registration() {
    /*$('#emailErrorInformer').text('');
    $('#loginErrorInformer').text('');
    $('#passErrorInformer').text('');
    $('#rPassErrorInformer').text('');*/

    var formData = $('#reg-form').serialize()

    $.ajax({
        url: 'reg',
        data: formData,
        success: function (dataFromServer) {
            if(dataFromServer.status === 'verified'){
                window.location.href = 'login';
            } else if (dataFromServer.status === 'failed') {
                $('#emailErrorInformer').text(dataFromServer.emailError);
                $('#loginErrorInformer').text(dataFromServer.loginError);
                $('.password_field').text(dataFromServer.passError);
            } else{
                alert('Stop doing this!!!');
            }
        },
        error: function () {
            alert('No connection to Tomcat');
        }
    });
}


function insertComment() {

    var formData = $('#commentForm').serialize()

    $.ajax({
        url: 'savecomment',
        data: formData,
        success: function (dataFromServer) {
            if (dataFromServer.status === 'verified') {
                document.location.reload(true);
            } else if (dataFromServer.status === 'failed') {
                $('#commentErrorInformer').text('No empty comments! Just write something!');
            }
        },
        error: function () {
            alert('ERROR_ERROR!!!');
        }
    });
}


function postNewArticle() {

    var formData = $('#newArticleForm').serialize()

    $.ajax({
        url: 'savearticle',
        data: formData,
        success: function (dataFromServer) {
            if (dataFromServer.status === 'verified') {
                var id = dataFromServer.newArtId;
                window.location.href = 'article?articleId=' + id;
            } else if (dataFromServer.status === 'failed') {
                $('#textAreaErrorInformer').text('You cant post empty article! Write something entertaining and post it!');
            }
        },
        error: function () {
            alert('ERROR_ERROR!!!');
        }
    });
}

/**
 * TODO
 * дописать возможность удаления статьи
 **/
function deleteArticle() {

    var id = $('#articleId').val();

    $.ajax({
        url: '',
        data: id,
        success: function (data) {
            document.location.reload();
        },
        error: function () {
            alert('ERROR_ERROR!!!');
        }
    });
}


function languageSelector(language){
    $.ajax({
        url: 'langselector',
        data: ({lang : language}),
        success: function (data) {
            document.location.reload();
        },
        error: function () {
            alert('ERROR_ERROR!!!');
        }
    });
}


function out(){
    $.ajax({
        url: 'out',
        success: function (data) {
            window.location.href = 'index';
        },
        error: function () {
            alert('ERROR_ERROR!!!');
        }
    });
}