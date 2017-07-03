
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
    <title>CarRent</title>
    <link rel="stylesheet" type="text/css" href="./static/indexstyle.css">
    <p><center><img src="./static/images/bmw_PNG1672.png" width="1000" height="400" ></center></p>
</head>
<body>


<div id="head">
    <h1>Сервис оренды Автомобилей</h1>
</div>

<a href="${spring:mvcUrl('editingCarDB').build()}">Редактирование базы автомобилей</a>
<br/>
<a href="${spring:mvcUrl('editingCarDB2').build()}">Редактирование базы автомобилей myEdition</a>
<br/>
<a href="${spring:mvcUrl('editingcerdbwebsockets').build()}">Редактирование базы автомобилей На основе ВэбСокетов</a>

<br>
<br>


</body>
</html>
