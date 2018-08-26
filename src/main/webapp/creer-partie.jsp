<%--
   Document   : _TEMPLATE
   Created on : 10 juil. 2018, 16:42:27
   Author     : The Klaude
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Magic Game</title>
        <c:import url="/Template/_STYLESHEET.jsp"/>
    </head>


    <body class="container">

        <c:import url="/Template/_HEADER.jsp"/>


        <div class="jumbotron">
            <h3>Donner un nom à votre partie:</h3>
            <form:form modelAttribute="partie">
                <div class="form-group">
                    <label for="formGroupExampleInput"></label>
                    <form:input type="text" class="form-control" id="formGroupExampleInput" placeholder="nom" path="nom"/>
                </div>

                <div class="form-group">
                    <button type="submit" class="btn btn-primary right">Créer</button>
                </div>
            </form:form>
        </div>
    </div>



    <c:import url="/Template/_FOOTER.jsp"/>
    <c:import url="/Template/_JAVASCRIPTS.jsp"/>
</body>

</html>
