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


        <div class="jumbotron  text-center">
            <h3 class="display-5">Liste des parties</h3>
            <br>
            <br>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Nombre de joueurs</th>
                        <th scope="col"> </th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach items="${listeParties}" var="partie">
                        <tr>

                            <td>${partie.id}</td>
                            <td>${partie.nom}</td>
                            <td>${partie.joueurs.size()}</td>
                            <td><a href="<c:url value="/pseudo-avatar"/>?idPartie=${partie.id}">
                                    <button class="btn btn-primary">Rejoindre partie</button>
                                </a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>





        <c:import url="/Template/_FOOTER.jsp"/>
        <c:import url="/Template/_JAVASCRIPTS.jsp"/>
    </body>

</html>
