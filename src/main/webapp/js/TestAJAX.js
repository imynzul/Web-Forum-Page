function testFunctionAJAX() {
    $.ajax({
        url: 'testController',
        success: function (data) {
            $('#text').text(data);
        },
        error: function () {
            alert('ERROR_ERROR!!!');
        }
    });

}