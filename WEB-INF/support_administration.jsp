<%--
Erstellt von Theinert Thomas
--%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <base href="${pageContext.request.requestURI}"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/default_grid.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/maintenance/maintenance_pages_tables.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tables_filter.css" type="text/css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tables_filter_function.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
        <title>Support Page</title>
        	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
    </head>
    <body>
        <header>
            <h1>Übersicht der Support Tickets</h1>
        </header>
        <nav>
            <%@include file="../html/jspf/navigation.jspf"%>
        </nav>
        <div id="flex_main_container">
            <aside>
                <%@include file="../html/jspf/aside.jspf"%>
            </aside>
        <main>
            <c:if test="${not empty saveEditSupportTicket}">
                <article>
                    <p>Die Änderungen am Ticket mit der ID ${saveEditSupportTicket.ticketId} wurden erfolgreich gespeichert!</p>
                    <p>Für Visualisierung in den Tabellen die Seite über den entsprechenden Button aktualisieren</p>
                </article>
            </c:if>
            <article>
                <p>Folgende Listen beinhalten die von Usern verfassten Kontaktnachrichten, deren Kontaktdaten und deren Bearbeitungsstatus</p>
            </article>
            <article>
                <form id="RefreshSupportPage" action="${pageContext.request.contextPath}/RefreshSupportPageServlet" method="post" accept-charset="UTF-8">
                    <button name="refresh" id="refresh" type="submit">Support Seite aktualisieren!</button>
                    <br><br><br>
                </form>
            </article>
            <article>
                <h2>Offene Support Tickets</h2>
                <input type="text" class="searchInput" id="searchInput1" onkeyup="searchFunction1()" placeholder="Offene Tickets durchsuchen...">
                <div class="responsive_table">
                <table id="searchTable1">
                    <thead>
                        <tr>
                            <th>Ticket ID</th>
                            <th>Kontakt E-Mail Adresse</th>
                            <th>Vorname</th>
                            <th>Nachname</th>
                            <th>Nachricht</th>
                            <th>Support Kommentar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="supportTicket" items="${openSupportTicketsList}">
                            <tr>
                                <td>${supportTicket.ticketId}</td>
                                <td>${supportTicket.ticketMail}</td>
                                <td>${supportTicket.ticketFirstName}</td>
                                <td>${supportTicket.ticketLastName}</td>
                                <td>${supportTicket.ticketMessage}</td>
                                <td>${supportTicket.supportComment}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div>
            </article>
            <article>
                <p>Hier kann ein Ticket über seine ID ausgewählt und bearbeitet werden</p>
                <form id="EditSupportTicket" action="${pageContext.request.contextPath}/EditSupportTicketServlet" method="post" accept-charset="UTF-8">
                    <label for="editTicket">Ticket über die ID aufrufen:</label>
                    <input type="number" name="editTicket" id="editTicket" size="50" required placeholder="Ticket ID">
                    <br>
                    <button name="edit" id="edit" type="submit">Ticket bearbeiten</button>
                    <br><br><br>
                </form>
            </article>
            <article>
                <h2>Geschlossene Support Tickets</h2>
                <input type="text" class="searchInput" id="searchInput2" onkeyup="searchFunction2()" placeholder="Geschlossene Tickets durchsuchen...">
                <div class="responsive_table">
                <table id="searchTable2">
                    <thead>
                        <tr>
                            <th>Ticket ID</th>
                            <th>Kontakt E-Mail Adresse</th>
                            <th>Vorname</th>
                            <th>Nachname</th>
                            <th>Nachricht</th>
                            <th>Support Kommentar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="supportTicket" items="${closedSupportTicketsList}">
                            <tr>
                                <td>${supportTicket.ticketId}</td>
                                <td>${supportTicket.ticketMail}</td>
                                <td>${supportTicket.ticketFirstName}</td>
                                <td>${supportTicket.ticketLastName}</td>
                                <td>${supportTicket.ticketMessage}</td>
                                <td>${supportTicket.supportComment}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </div>
            </article>
                    <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
        </main>
        </div>
        <footer>
            <%@include file="../html/jspf/footer.jspf"%>
        </footer>
    </body>
</html>
