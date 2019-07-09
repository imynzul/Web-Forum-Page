function getAllUsers() {
    $.ajax({
        url: 'getAllUsers',
        success: function (dataFromServer) {
            var table = '';
            for (var i = 0; i < dataFromServer.length; i++){
                var user = dataFromServer[i];
                var info = user.userInfo;

                table += '<tr>'

                table += '<td>' + user.id + '</td>'
                table += '<td>' + info.email + '</td>'
                table += '<td>' + user.login + '</td>'
                table += '<td>' + user.password + '</td>'
                table += '<td>' + (info.role == 1 ? 'user' : 'admin') + '</td>'
                table += '<td></td>'

                table += '</tr>'
            }
            $('#allusers').append(table);
        },
        error: function () {
            alert('ERROR_ERROR!!!');
        }
    });

}