<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 29.06.2017
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>DBEdit2</title>
</head>
<body>
<h2>Добавление авто в БД вариант номер 2</h2>
<h1>Тестовая пробная страничка по передаче информации!!!</h1>

<sf:form modelAttribute="car" method="POST">

    <div>
        <label for="concernName"><spring:message code="car.concern"></spring:message></label>
        <sf:input path="concernName"/>
        <sf:errors path="concernName"/>
    </div>
    <p>-----------------------------------------------</p>
    <div>
        <label for="model"><spring:message code="car.model"></spring:message></label>
        <sf:input path="model"/>
        <sf:errors path="model"/>
    </div>
    <p>-----------------------------------------------</p>
    <div>
        <label for="color"><spring:message code="car.color"></spring:message></label>
        <sf:input path="color"/>
        <sf:errors path="color"/>
    </div>
    <p>-----------------------------------------------</p>
    <div>
        <label for="power"><spring:message code="car.power"></spring:message></label>
        <sf:input path="power"/>
        <sf:errors path="power"/>
    </div>

    <button type="submit" class="btn btn-primary"><spring:message code="auth.submit"/></button>
</sf:form>

<form action="./">
    <input type="submit" value="Exit"/>
</form>

</body>
</html>
