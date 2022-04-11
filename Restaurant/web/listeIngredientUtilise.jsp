<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body class="text-center">
        <h1>Liste des ingredients</h1>
        <form action="" method="get">
            <p>Date min: <input type="date" name="dateMin"></p>
            <p>Date max: <input type="date" name="dateMax"></p>
            <p><input type="submit" value="afficher"></p>
        </form>
        <table class="table" border="1">
            <tr>
                <th>Ingredient</th>
                <th>Quantite</th>
                <th>Prix_total</th>
            </tr>
            <c:forEach items="${listeIngredientUtilise}" var="ingredient">
                <tr>
                    <td>${ingredient.nom_ingredient}</td>
                    <td>${ingredient.sum_quantite} g</td>
                    <td>${ingredient.prix_total}</td>
                </tr>
            </c:forEach>
        </table>
        <h2>
           Prix total : ${prixTotal} AR
        </h2>
    </body>
</html>
