<%--
Erstellt von Theinert Thomas
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="de">
    <head>
        <base href="${pageContext.request.requestURI}"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/default_grid.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/maintenance/maintenance_pages_tables.css" type="text/css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/confirm_process_support_ticket.js"></script>
        <title>Support Edit Ticket Page</title>
        	<script type="text/javascript"
			src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
    </head>
    <body>
        <header>
            <h1>Bearbeitung des ausgewählten Support Tickets</h1>
        </header>
        <nav>
            <%@include file="../jspf/navigation.jspf"%>
        </nav>
        <div id="flex_main_container">
            <aside>
                <%@include file="../jspf/aside.jspf"%>
            </aside>
        <main>
            <article>
                <p>Hier wird das zuvor ausgewählte Support Ticket bearbeitet</p>
            </article>
            <article>
                <h2>Ausgewähltes Support Ticket</h2>
                <div class="responsive_table">
                    <table>
                        <thead>
                            <tr>
                                <th>Ticket ID</th>
                                <th>Kontakt E-Mail Adresse</th>
                                <th>Vorname</th>
                                <th>Nachname</th>
                                <th>Nachricht</th>
                                <th>Bisherige Support Kommentare</th>
                                <th>Bearbeitungsstatus</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${editSupportTicket.ticketId}</td>
                                <td>${editSupportTicket.ticketMail}</td>
                                <td>${editSupportTicket.ticketFirstName}</td>
                                <td>${editSupportTicket.ticketLastName}</td>
                                <td>${editSupportTicket.ticketMessage}</td>
                                <td>${editSupportTicket.supportComment}</td>
                                <td>${editSupportTicket.ticketStatus}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </article>
            <article>
                <form id="saveEditSupportTicket" action="${pageContext.request.contextPath}/SaveEditSupportTicketServlet" method="post" accept-charset="UTF-8">
                    <fieldset><legend>Supportmaßnahmen kommentieren und neuen Status setzen</legend>
                        <div>
                            <label for="latestSupportComment">Bearbeitungskommentar:</label>
                            <textarea name="latestSupportComment" id="latestSupportComment" rows="15" cols="50" maxlength="2500" required placeholder="Hier Supportkommentare eintragen..."></textarea>
                        </div>
                        <div class="form_radio">
                            <label>Status:</label>
                            <label for="statusOpen">Offen</label>
                            <input type="radio" name="newStatus" id="statusOpen" value="open" checked>
                            <label for="statusClosed">Geschlossen</label>
                            <input type="radio" name="newStatus" id="statusClosed" value="closed">
                        </div>
                        <div>
                            <button name="save" id="save" type="submit">Änderungen speichern</button>
                            <button name="reset" id="reset" type="reset">Änderungen zurücksetzen</button>
                            <br><br><br>
                        </div>
                    </fieldset>
                </form>
                <form id="GoToSupportAdministration" action="${pageContext.request.contextPath}/RefreshSupportPageServlet" method="post" accept-charset="UTF-8">
                    <button name="toSupportAdministration" id="toSupportAdministration" type="submit">Bearbeitung abbrechen und zurück zur Ticket Übersicht</button>
                </form>
            </article>
                    <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
            
        </main>
        </div>
        <footer>
            <%@include file="../jspf/footer.jspf"%>
        </footer>
    </body>
</html>