<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Commander plat</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Commander plats</h1>
            <form action="CommanderPlat" method="get">
                <p>Table: <select name="idTable">
                        <!--<option value="Table1">table1</option>-->
                        <c:forEach items="${listeTable}" var="table">
                            <option value="${table.id}">${table.nom}</option>
                        </c:forEach>
                    </select></p>
                <p><input type="submit" value="valider"></p>
            </form>
            <div class="row">
                <div class="col-md-8">
                    <h2>Liste des commandes de la table ${idTable}</h2>
                    <table class="table table-dark">
                        <thead>
                            <tr>
                                <th scope="col">Plats</th>
                                <th scope="col">Prix</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listeCommandeView}" var="commandeView">
                                <tr>
                                    <td>${commandeView.nomPlat}</td>
                                    <td>${commandeView.prix}</td>
                                    <td>
                                        <button onclick="masakevana(${commandeView.id_commande_detail})" class="btn btn-warning">Masakevana</button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-4">
                    <form action="InsertPlat" method="get">
                        <input type="hidden" name="idCommande" value=${idCommande}>
                        <input type="hidden" name="idTable" value=${idTable}>
                        <h2>Commander un plat pour la table ${idTable}</h2>
                        <p>Plats: <select name="idPlat">
                                <c:forEach items="${listeProduit}" var="produit">
                                    <option value="${produit.id}">${produit.nom}</option>
                                </c:forEach>
                            </select></p>
                        <p>Quantite:
                            <input type="number" name="quantite">
                        <p><input type="submit" value="ajouter"></p>
                    </form>
                </div>
            </div>
            <h4><b>Prix total des commandes : ${total} Ar</b></h4>
            <form action="FermerCommande" method="get">
                <input type="hidden" name="idCommande" value="${idCommande}">
                <p><button class="btn btn-danger" type="submit">Fermer la commande</button></p>
            </form>
        </div>
    </body>
    <script>
        function masakevana(idCommandeDetail){
            window.location.href = "Masakevation?idCommandeDetail="+idCommandeDetail;
            console.log("lelena");
        }
    </script>
</html>
