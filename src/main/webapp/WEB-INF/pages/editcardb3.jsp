<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 30.06.2017
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%--Добавляем название кнопок из пропертисов--%>
<html>
<head>

    <title>WebSocketEdit</title>
    <p>
    <center><img src="./static/images/e39.png" width="600" height="300"></center>
    </p>


</head>
<%--Между хедом и боди подключим библиотеку, которая позволит работать с ВэбСокетами--%>
<script src="http://cdn.jsdelivr.net/sockjs/0.3.4/sockjs.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="./static/testscript.js"></script>
<script>
    function ready() {
        document.getElementById("btnAddCar").addEventListener("click", addCarToDB);
        document.getElementById("GetListOfCars").addEventListener("click", getListOfCars);
        document.getElementById("SendSomethink").addEventListener("click", sendSomethink);


    }
    document.addEventListener("DOMContentLoaded", ready);
    //ready();
    function gohome() {
        window.location.href = "/CarRent";
    }
    var socket = new SockJS("${sockUrl}");

    socket.onopen = function () {
        console.log('Соединение оброботчиком на сервере произошло!!!');

    }
    //  действие, которое отробатывает при закрытии соединения.
    // с проверкой на правильное или неправильное закрытие соединения
    socket.onclose = function (event) {
        if (event.wasClean) {
            console.log("Connection close!");
        } else {
            console.log("Connection closed because of error!");
        }
//            window.location.href = "/";
    };
    socket.onerror = function (error) {
        console.log("error");
//            window.location.href = "/";
    };
    socket.onmessage = function (event) {
        var json_message = JSON.parse(event.data);

        if (json_message.auth == "yes") {
            var ul_element = document.createElement("ul");//Создали элемент списка
            ul_element.type = "circle"
            var li_element = document.createElement("li");
            li_element.innerHTML = json_message.auth;

            ul_element.appendChild(li_element);
            var listofcars_div = document.getElementById('listofcarsinDb');
            listofcars_div.appendChild(ul_element);
        }


    }

    /*
     * По легенде, эта функция отправляет запрос обработчику вэбсокетов
     * */

    function getListOfCars() {
        var zapros = {};
        zapros["target"] = 'getlistOfcars';
        socket.send(JSON.stringify(zapros));

    }
    function sendSomethink() {
        var somemessage = {};//Обозначили ка массив?
        somemessage["message"] = message.value;
        socket.send(JSON.stringify(somemessage));
        console.log('НАжата кнопка какойто отправки чегото на сервер')
    }
    function addCarToDB() {
        var carDTO = {};//Определили, что CarDto - это массив. далее будем добавляить в него данные из формы
        carDTO["target"] = 'savecartodb';
        carDTO["concernName"] = concern.value;
        carDTO["concernName"] = concern.value;
        carDTO["model"] = model.value;
        carDTO["color"] = color.value;
        carDTO["power"] = power.value;
        carDTO["carNumber"] = carNumber.value;
        socket.send(JSON.stringify(carDTO));
        alert("Машинка полетела на сервер");

    }
    //-------------------------------------------------------------------------------------------------------------
    /*
     * Далее делаем ajax запрост
     *
     * */

    function ajax_request() {
        $.ajax({
            type:'GET',
            contentType:'/getCarListAjax',
            dataType:'json',
            success:function(data,textStatus,jxXHR){
                //Сдесь будет тело
//alert('Пришёл джисон ответ с сервера');

            }



        });


    }

</script>
<body>


<h2>Тестовый олемент странички с тестовым скриптом</h2>
<div>
    <br/>
    <input type="text" name="" id="message" placeholder="input text"/>
    <input type="button" value="Send" id="send"/>
    <input type="button" value="Stop" id="stop"/>
    <input type="button" value="SympleButtom" id="sympleButtom"/>
    <br/>
    <label id="status">Статус соеинения</label>
</div>

<p>=============================================================================================================</p>
<h2>Добавление автомобиля в базу данных при помощи ВебСокетов</h2>
<%-- Попробуем сделать таблицу из 2 элементов. в первом - будет форма для заполнения машин, во втором отображение списка автомобилей
Сооответсвнно пакеты, которыми будет общаться форма, будет json!!!--%>
<div id="edit_car_div">

    <table border="1px solid black">
        <tr>
            <td>
                <form>
                    <input type="text" id="concern" placeholder="concern name"/>
                    <br/>
                    <input type="text" id="model" placeholder="model"/>
                    <br/>
                    <input type="text" id="color" placeholder="color"/>
                    <br/>
                    <input type="text" id="power" placeholder="power"/>
                    <br/>
                    <input type="text" id="carNumber" placeholder="carNumber"/>
                    <br/>
                </form>
                <button id="btnAddCar" onclick="console.log('Нажата кнопочка')"><s:message
                        code="btn.addcar"></s:message></button>
                <button onclick=gohome()>GoHome</button>
            </td>
            <td>
                <div id="listofcarsinDb">List Of cars in DB!!!</div>
            </td>
            <td>
                <label id="statusCar">Статус соеинения</label>
            </td>
        </tr>

    </table>
</div>
<button id="GetListOfCars"> Получить Список автомобилей от из базы данных</button>
<button id="SendSomethink"> SendSomething to server</button>
<button id="GetListOfCars_ajaxs"> CarList ajax request</button>


</body>
</html>
