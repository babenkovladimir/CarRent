<%--
  Created by IntelliJ IDEA.
  User: Владимир
  Date: 28.06.2017
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>

<%--
Для того, чтобы на страничке сработали тэги с ошибками, необходимо перекинуть в качесте
Флэш атрибутаназвание  attributes.addFlashAttribute("org.springframework.validation.BindingResult.car",result);


--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>Работа с базой данных</title>
</head>
<body>
<h1>Редактирование базы данных автомобиля</h1>

<div class="container">
    <h2>Adding Car </h2>

    <div class="row">
            <div class="col-sm-6 col-sm-push-3">
            <sf:form modelAttribute="car" action="" cssClass="form-horizontal">
                <div class="panel panel-primary">
                    <div class="panel-heading">Add</div>
                    <div class="panel-body">

                            ${error}

                        <div class="form-group">
                            <label for="model" class="col-sm-3 control-label"><spring:message
                                    code="car.model"></spring:message></label>
                            <div class="col-sm-9">
                                <sf:input path="model" cssClass="form-control"/>
                            </div>
                            <sf:errors path="model" cssClass="error"/>
                        </div>

                        <div class="form-group">
                            <label for="concernName" class="col-sm-3 control-label"><spring:message
                                    code="car.concern"></spring:message></label>
                            <div class="col-sm-9">
                                <sf:input path="concernName" cssClass="form-control"/>
                            </div>
                            <sf:errors path="concernName" cssClass="error"/>
                        </div>

                        <div class="form-group">
                            <label for="color" class="col-sm-3 control-label"><spring:message
                                    code="car.color"></spring:message></label>
                            <div class="col-sm-9">
                                <sf:input path="color" cssClass="form-control"/>
                            </div>
                            <sf:errors path="color" cssClass="error"/>
                        </div>


                        <div class="form-group">
                            <label for="power" class="col-sm-3 control-label"><spring:message
                                    code="car.power"></spring:message></label>
                            <div class="col-sm-9">
                                <sf:input path="power" cssClass="form-control"/>
                            </div>
                            <sf:errors path="power" cssClass="error"/>
                        </div>

                        <div class="form-group">
                            <label for="car.carNumber" class="col-sm-3 control-label"><spring:message
                                    code="car.carNumber"></spring:message></label>
                            <div class="col-sm-9">
                                <sf:input path="carNumber" cssClass="form-control"/>
                            </div>
                            <sf:errors path="carNumber" cssClass="error"/>
                        </div>
                    </div>


                    <button type="submit" class="btn btn-primary"><spring:message code="auth.submit"/></button>

                </div>
            </sf:form>
        </div>
    </div>
</div>

<br/>


<form action="./">
    <input type="submit" value="Exit"/>
</form>


</body>
</html>
