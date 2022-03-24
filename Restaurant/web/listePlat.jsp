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
        <title>Liste des plats</title>
    </head>
    <body>
        <div class="container">
            <h3 class="text-center">Liste des plats</h3>
            <div class="text-center">
                <label for="filtre">Filtre :</label>
                <select class="form-control" id="filtre" name="idType">
                    <c:forEach items="${types}" var="type">
                        <option value="${type.getId()}">${type.getNom()}</option>
                    </c:forEach>
                </select>
                <button class="btn btn-success" onclick="filtrer()">Valider</button>
                <br/>
            </div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Prix</th>
                        <th scope="col">Cout de production</th>
                        <th scope="col">Prix de revient</th>
                        <th scope="col">Prix de revient suggeré</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${prixDeRevient}" var="pr">
                        <tr>
                            <td><a href="DetailsPlat?idProduit=${pr.getId()}">${pr.getNom()}</a></td>
                            <td>${pr.getPrix()}</td>
                            <td>${pr.getPrix_de_revient()}</td>
                            <td>${pr.getPrix() - pr.getPrix_de_revient()}</td>
                            <td>${pr.getPrixDeRevientSuggere()}</td>
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
