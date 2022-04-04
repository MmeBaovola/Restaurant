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
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Nom</th>
                        <th scope="col">Prix</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listeProduit}" var="produit">
                        <tr>
                            <td>${produit.nom}</td>
                            <td>${produit.prix}</td>
                            <td>
                                <button class="btn btn-info" onclick="voirDetails(${produit.id})">
                                    Details
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
    <script>
        function voirDetails(idProduit) {
            window.location.href = "DetailsPlat?idProduit=" + idProduit;
        }
    </script>
</html>
