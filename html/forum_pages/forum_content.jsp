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
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/forum_pages/forum_pages_tables.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tables_filter.css" type="text/css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/tables_filter_function.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/go_to_top.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/confirm_forum_content.js"></script>
        <title>Forum Content</title>
    </head>
    <body>
        <header>
            <h1>Topic Seite des Mathequiz</h1>
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
                <h2>Hier könnt ihr Beiträge zum zuvor ausgewählten Topic lesen und als angemeldeter User weitere Beiträge hinzufügen</h2>
            </article>
            <article>
                <form id="RefreshForumContentPage" action="${pageContext.request.contextPath}/ForumContentServlet" method="post" accept-charset="UTF-8">
                    <button name="refreshPage" id="refreshPage" type="submit">
                        <input type="hidden" name="topicId" value="${forumContentTopicId.topicId}">
                        Seite aktualisieren</button>
                    <br><br><br>
                </form>
                <form id="GoToForumTopics" action="${pageContext.request.contextPath}/RefreshForumTopicsPageServlet" method="post" accept-charset="UTF-8">
                    <button name="toForumTopics" id="toForumTopics" type="submit">Zurück zur Forum Topic Übersicht</button>
                    <br><br><br>
                </form>
            </article>
            <c:if test="${deleteContentId != null}">
                <article>
                <p>Ihr ausgewählter Beitrag mit der Nummer ${deleteContentId} wurde erfolgreich gelöscht</p>
                </article>
            </c:if>
            <article>
                <h2>Beiträge zu diesem Topic</h2>
                <input type="text" class="searchInput" id="searchInput" onkeyup="searchFunction()" placeholder="Beiträge durchsuchen...">
                <div class="responsive_table">
                    <table id="searchTable">
                        <thead>
                            <tr>
                                <th>Userbeiträge</th>
                                <th>Erstellt von</th>
                                <c:if test="${user.userGroup eq 'administration'}">
                                    <th>Beitrags ID</th>
                                </c:if>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${user.userGroup eq 'administration'}">
                                    <c:forEach var="forumContent" items="${forumContentList}">
                                        <tr>
                                            <td>${forumContent.contentText}</td>
                                            <td>${forumContent.userName}</td>
                                            <td>${forumContent.contentId}</td>
                                            <form name="deleteForumContentAdmin" action="${pageContext.request.contextPath}/DeleteForumContentServlet" method="post" id="${forumContent.contentId}deleteForumContentAdmin" class="deleteForumContentAdmin">
                                                <td><button name="deleteForumContentTextAdmin" id="deleteForumContentTextAdmin" type="submit"><input type="hidden" name="deleteContentId" value="${forumContent.contentId}">Beitrag löschen</button></td>
                                            </form>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="forumContent" items="${forumContentList}">
                                        <tr>
                                            <td>${forumContent.contentText}</td>
                                            <td>${forumContent.userName}</td>
                                            <c:if test="${forumContent.userName eq user.username}">
                                                <form name="deleteForumContentUser" action="${pageContext.request.contextPath}/DeleteForumContentServlet" method="post" id="deleteForumContentUser" class="deleteForumContentUser">
                                                    <td><button name="deleteForumContentTextUser" id="${forumContent.contentId}deleteForumContentTextUser" type="submit"><input type="hidden" name="deleteContentId" value="${forumContent.contentId}">Beitrag löschen</button></td>
                                                </form>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </article>
            <c:if test="${not empty user}">
            <article>
                <h2>Beitrag hinzufügen</h2>
                <form id="ContributeForm" action="${pageContext.request.contextPath}/ContributeContentTextServlet" method="post" accept-charset="UTF-8">
                    <fieldset><legend>Neuer Beitrag</legend>
                    <div>
                        <label for="contributionMessage">Ihre Nachricht:</label>
                        <textarea name="contributionMessage" id="contributionMessage" rows="15" cols="50" maxlength="5000" required placeholder="Beitrag schreiben..."></textarea>
                    </div>
                    <div>
                        <button name="sendContributionContent" id="sendContributionContent" type="submit">
                            <input type="hidden" name="contributionTopicId" value="${forumContentTopicId.topicId}">
                            <input type="hidden" name="contributionUserId" value="${user.userId}">
                            <input type="hidden" name="contributionUserName" value="${user.username}">
                            Beitrag hinzufügen</button>
                        <button name="reset" type="reset">Eingaben zurücksetzen</button>
                    </div>
                    </fieldset>
                </form>
            </article>
            <article>
                <c:if test="${not empty newForumContent}">
                    <p>Ihr Beitrag wurde erfolgreich zur Diskussion hinzugefügt</p>
                </c:if>
            </article>
            </c:if>
                    <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
        </main>
        </div>
        <footer>
            <%@include file="../jspf/footer.jspf"%>
        </footer>
    </body>
</html>
