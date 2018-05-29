<%--
  Created by IntelliJ IDEA.
  User: Thomas
  Date: 28.05.2018
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <base href="${pageContext.request.requestURI}" />
        <title>Support Page</title>
    </head>
    <body>
        <header>
            <h1>Ticketseite für Support Mitarbeiter</h1>
        </header>
        <nav>
            <p>
                <a href="../../index.jsp">Startseite</a>
                <c:if test = "${not empty user}">
                    <a >Abmeldung</a>
                </c:if>
            </p>
        </nav>
        <aside>
            <c:if test="${not empty user}">
                <h3><a href="../user_pages/profil.jsp">Mein Profil</a></h3>
            </c:if>
        </aside>
        <main>
            <article>
                <p>Folgende Liste beinhaltet die von Usern verfassten Kontaktnachrichten und deren Kontaktdaten</p>
            </article>
            <form id="RefreshSupportPage" action="../../RefreshSupportPageServlet" method="post" accept-charset="UTF-8">
                <button name="refresh" id="refresh" type="submit">Support Seite aktualisieren!</button>
            </form>
            <h2>Offene Support Tickets</h2>
            <table>
                <tbody>
                <tr>
                    <th>Ticket ID</th>
                    <th>Kontakt E-Mail Adresse</th>
                    <th>Vorname</th>
                    <th>Nachname</th>
                    <th>Nachricht</th>
                </tr>
                <c:forEach var="supportTicket" items="${supportTicketsList}">
                    <tr>
                        <td>${supportTicket.ticketId}</td>
                        <td>${supportTicket.ticketMail}</td>
                        <td>${supportTicket.ticketFirstName}</td>
                        <td>${supportTicket.ticketLastName}</td>
                        <td>${supportTicket.ticketMessage}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </main>
        <footer>
            <p>
                <a href="html/kontakt.jsp">Kontakt</a>
                <a href="html/faq.jsp">FAQ</a>
                <a href="html/impressum.jsp">Impressum</a>
            </p>
        </footer>
    </body>
</html>
