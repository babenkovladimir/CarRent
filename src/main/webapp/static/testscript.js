/**
 * Created by Владимир on 02.07.2017.
 */
window.onload = function () {
    var label = document.getElementById("status");
    var message = document.getElementById("message");
    var btnSend = document.getElementById("send");
    var btnStop = document.getElementById("stop");
    var btnSympleButtom = document.getElementById("sympleButtom");


    btnSend.onclick = function () {

        /*
         * WebSocket.CONNECTING
         * WebSocket.OPEN
         * WebSocket.CLOSING
         * WebSocket.Closed
         * */

        console.log("Нажали кнопочку чтобы отправить сообщение!!!");
        if (socket.readyState === WebSocket.OPEN) {

            socket.send(message.value);
            message.set('');
        }

        socket.bufferedAmount;//Если равняется 0, значит все данные без проблемм ушли. Использовать при больших объемах данных
    };

    btnStop.onclick = function () {
        socket.close();
    };

    btnSympleButtom.onclick = function () {
        console.log("Нажали какуюто кнопочку");
        label.innerHTML = 'Нажали какуюто кнопочку';
    };

    // Будем работать на Эхо сервер!!!
    var socket = new WebSocket("ws://echo.websocket.org");

    socket.onopen = function (event) {
        console.log('Соединение с эхо сервером произошло!!!');
        label.innerText = 'Соединение с эхо сервером произошло!!! по адресу ' + socket.url;
    };
    socket.onclose = function (event) {
        console.log('Соединение закрыто ');
        label.innerText = 'Соединение закрыто';

        var code = event.code;
        var wasClean = event.wasClean;
        if (wasClean) {
            console.log('Соединение закрыто корректно');
            label.innerText = 'Соединение закрыто корректно';
        }
        else {
            console.log('Соединение закрыто НЕкорректно');
            label.innerText = 'Соединение закрыто корректно';
        }

    };
    socket.onerror = function (event) {
        console.log('websocket E R R O R');

    };
//    И наконец то самое важное в этом всём, это

    socket.onmessage = function (event) {
        if (typeof event.data === 'string') {
            label.innerHTML = event.data;


        }
        ;
    };
};
/*
 * 1. Потдержка WS браузерами
 * 2. Создание объекта
 * 3. Соединение с Сервером
 * 4. Назначение обработчиков событий
 * 5. Обмен информацией с сервером
 * 6. Закрытие соединения
 * */