<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <style>
        .container h3 {
            margin-bottom: 50px;
        }
        .container button{
            width: 100%;
            margin: 20px 0 20px 0;
        }
    </style>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.css" rel="stylesheet">
        <title>Details Plat</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Details du plat / Liste des ingredients</h1>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Quantite</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listeIngredientView}" var="ingredient">
                        <tr>
                            <td>${ingredient.nom_ingredient}</td>
                            <td>${ingredient.quantite}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    <script>
        function filtrer(e) {
            var filtre = document.getElementById("filtre");
            window.location.href = "ListePlat?idType=" + filtre.value;
        }
    </script>
</html>
