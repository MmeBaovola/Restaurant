<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>serveur</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Recherche pourboire</h1>
            <form action="resultatServeur.html" method="get">
                <p>Serveur: <select name="serveur">
                        <option value="serveur">serveur</option>
                    </select></p>
                <p>Date min: <input type="date" name="dateMin"></p>
                <p>Date max: <input type="date" name="dateMax"></p>
                <p><input type="submit" value="valider"></p>
            </form>
            <h1>Liste des serveurs</h1>
            <table class="table table-dark table-striped">
                <thead>
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Valeur</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listeServeur}" var="serveur">
                        <tr>
                            <td>${serveur.nom}</td>
                            <td>${serveur.somme}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
