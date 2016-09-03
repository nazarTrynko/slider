function executeQuery() {

    var prevValue = new Number($('#points').val());

    $.ajax({
        url: 'generate',
        success: function (data) {
            console.log(data)
            if ((prevValue - data) > 0) {
                var i = 0, howManyTimes = prevValue - data;
                window.setInterval(function () {
                    if (i < howManyTimes) {
                        i++;
                        $('#points').val(prevValue - i).slider('refresh');
                        if ((i + 2) < howManyTimes) {
                            i+= 2;
                        }
                    }
                }, 1);
            }
            else if ((prevValue - data) <= 0) {
                var i = 0, howManyTimes = data - prevValue;
                window.setInterval(function () {
                    if (i < howManyTimes) {
                        i++;
                        $('#points').val(prevValue + i).slider('refresh');
                        if ((i + 2) < howManyTimes) {
                            i+= 2;
                        }
                    }
                }, 1);
            }
        }
    });
    setTimeout(executeQuery, 2000);
}

$(document).ready(function() {
    setTimeout(executeQuery, 2000);
});