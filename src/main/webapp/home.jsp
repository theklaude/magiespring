<%--
   Document   : _TEMPLATE
   Created on : 10 juil. 2018, 16:42:27
   Author     : The Klaude
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Magic Game</title>
        <c:import url="/Template/_STYLESHEET.jsp"/>
    </head>


    <body class="container">

        <c:import url="/Template/_HEADER.jsp"/>


                <div class="jumbotron text-center" >
                    <h3 class="display-5">Welcome to the Magic Game!</h3>
                    <br>
                    <br>
                    <div class="btn-group">
                        <a class="btn btn-primary btn-lg" href="<c:url value="/creer-partie"/>?" role="button">Créer une partie</a>
                    </div>

                    <div class="btn-group">
                        <a class="btn btn-primary btn-lg" href="<c:url value="/lister-partie"/>?" role="button">Rejoindre une partie</a>
                    </div>
                </div>
            
                     

        <c:import url="/Template/_FOOTER.jsp"/>
        <c:import url="/Template/_JAVASCRIPTS.jsp"/>
    </body>

</html>
