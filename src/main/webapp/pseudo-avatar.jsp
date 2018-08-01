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
        <c:import url="/Template/_STYLESHEET.jsp" />
    </head>


    <body class="container">

        <c:import url="/Template/_HEADER.jsp" />


        <div class="jumbotron">

            <h3>Choisissez un pseudo:</h3>
            <form method="POST">
                <div class="form-group">
                    <label for="formGroupExampleInput"></label>
                    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="pseudo" name="pseudo">
                </div>

                <h3>
                    Choisissez un avatar:
                </h3>
                <br>

                <div class="row">
                    <div class="col-sm-3">
                        <div class="col-item">
                            <div class="photo">
                                <img src="<c:url value="/CSS/img/avatar1.png"/>" class="img-responsive" alt="a" />
                                <input type="radio" name="avatar" value="avatar1">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="col-item">
                            <div class="photo">
                                <img src="<c:url value="/CSS/img/avatar2.png"/>" class="img-responsive" alt="a" />
                                <input type="radio" name="avatar" value="avatar2">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3">
                        <div class="col-item">
                            <div class="photo">
                                <img src="<c:url value="/CSS/img/avatar3.png"/>" class="img-responsive" alt="a" />
                                <input type="radio" name="avatar" value="avatar3">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-3" >
                        <div class="col-item">
                            <div class="photo">
                                <img src="<c:url value="/CSS/img/avatar4.png"/>" class="img-responsive" alt="a" />
                                <input type="radio" name="avatar" value="avatar4">
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <br>


                <div class="form-group">
                    <button type="submit" class="btn btn-primary right">Rejoindre</button>

                    
                </div>
            </form>
        </div>







        <c:import url="/Template/_FOOTER.jsp" />
        <c:import url="/Template/_JAVASCRIPTS.jsp" />
    </body>

</html>