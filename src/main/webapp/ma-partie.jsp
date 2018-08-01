<%-- 
    Document   : ma-partie
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

            <div class="row">
                <div class="col-sm-4">
                    <div class="card" style="max-width: 10rem;">
                        <img class="card-img-top" src="<c:url value="/CSS/img/${joueur.avatar}.png"/>"alt="">
                        <div class="card-body">
                            <h5 class="card-title">${joueur.pseudo}</h5>
                        </div>
                    </div>

                    <br>
                    <button type="button" class="btn btn-primary  btn-block">Jeter un sort</button>
                    <button type="button" class="btn btn-secondary  btn-block">Passer la main</button>
                </div>

                <div class="col-sm-8">
                    <div class="card-deck">
                        <c:forEach items="${partie.joueurs}" var="joueur">
                            <div class="card" style="max-width: 10rem;">
                                <img class="card-img-top" src="<c:url value="/CSS/img/${joueur.avatar}.png"/>"alt="">
                            </div>
                        </c:forEach>
                    </div>  
                </div>
            </div>
        </div>

        <br>
        <br>
        <div class="jumbotron">
            <div class="card-deck">
                <c:forEach items="${partie.joueurs}" var="joueur">
                    <div class="card" style="max-width: 10rem;">
                        <img class="card-img-top" src="<c:url value="/CSS/img/${joueur.avatar}.png"/>"alt="">
                        <div class="card-body">
                            <h5 class="card-title">${joueur.pseudo}</h5>
                            <h5 class="card-title">${joueur.cartes.size}</h5>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <c:import url="/Template/_FOOTER.jsp"/>
        <c:import url="/Template/_JAVASCRIPTS.jsp"/>
    </body>

</html>

