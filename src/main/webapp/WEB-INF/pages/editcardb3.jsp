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
<script src="./static/testscript.js"></script>
<script>


    var btnAdd = document.getElementById("btnAddCar");
    var statusCar = document.getElementById("statusCar");
    var ws = new SockJs("${socketAddres}");


    ws.onopen = function () {
        console.log('Соединение оброботчиком на сервере произошло!!!');

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


                </form>
                <button id="btnAddCar"><s:message code="btn.addcar"></s:message></button>
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

</body>
</html>
