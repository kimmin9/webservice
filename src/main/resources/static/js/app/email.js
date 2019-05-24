var email = {
    init : function () {
        var _this = this;
        $('#btn-send').on('click', function () {
            _this.send();
        });
    },
    send : function () {
        var data = {
            name: $('#name').val(),
            email: $('#email').val(),
            message: $('#message').val()
        };

        $.ajax({
            type: 'POST',
            url: '/email',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('메일이 성공적으로 보내졌습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

};

email.init();