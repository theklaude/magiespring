<%-- 
    Document   : demarrer-partie
    Created on : 18 juil. 2018, 09:25:00
    Author     : theklaude
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

        <div class="jumbotron  text-center">
            <h3 class="display-5">Partie: ${partie.nom}</h3>
            <br>
            <br>

            <div class="card-deck">
                <c:forEach items="${partie.joueurs}" var="joueur">
                    <div class="card" style="max-width: 10rem;">
                        <img class="card-img-top" src="<c:url value="/CSS/img/${joueur.avatar}.png"/>"alt="">
                        <div class="card-body">
                            <h5 class="card-title">${joueur.pseudo}</h5>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <br>
            <br>
            <button class="btn btn-primary">Démarrer la partie</button>
        </div>

        <c:import url="/Template/_FOOTER.jsp"/>
        <c:import url="/Template/_JAVASCRIPTS.jsp"/>
    </body>

</html>

