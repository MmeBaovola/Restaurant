<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Facture</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Facture</h1>
            <form action="TotalPaiementFactureView" method="get">
                <p>Date min: <input type="date" name="dateMin"></p>
                <p>Date max: <input type="date" name="dateMax"></p>
                <p>Type: <select name="type">
                        <option value="">Tous</option>
                        <option value="Cheque">Cheque</option>
                        <option value="Espece">Espece</option>
                    </select></p>
                <p><input type="submit" value="Afficher"></p>
            </form>
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th scope="col">Date</th>
                        <th scope="col">Montant total à payer</th>
                        <th scope="col">Montant déjà payé</th>
                        <th scope="col">Reste à payer</th>
                        <th scope="col">Type</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listePaiement}" var="paiement">
                        <tr>
                            <td>${paiement.date}</td>
                            <td>${paiement.total_a_paye}</td>
                            <td>${paiement.deja_paye}</td>
                            <td>${paiement.reste_a_payer}</td>
                            <td>${paiement.nom_type}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
