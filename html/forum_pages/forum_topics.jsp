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
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/confirm_forum_topics.js"></script>
        <title>Forum Topics</title>
    </head>
    <body>
        <header>
            <h1>Forum Seite des Mathequiz</h1>
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
                <h2>Hier könnt ihr in unserem Forum neue Themen/Topics eröffnen und in diesen diskutieren</h2>
            </article>
            <article>
                <form id="RefreshForumPage" action="${pageContext.request.contextPath}/RefreshForumTopicsPageServlet" method="post" accept-charset="UTF-8">
                    <button name="refreshPage" id="refreshPage" type="submit">Forums Seite aktualisieren</button>
                    <br><br><br>
                </form>
            </article>
            <c:if test="${not empty user}">
                <article>
                    <form id="CreateNewTopic" action="${pageContext.request.contextPath}/CreateNewForumTopicServlet" method="post" accept-charset="UTF-8">
                        <fieldset><legend>Neues Topic</legend>
                            <div>
                                <label for="newTopicText">Neues Topic/Thema: </label>
                                <input type="text" name="newTopicText" id="newTopicText" size="50" maxlength="500" required placeholder="Beschreibung neues Topic/Thema">
                            </div>
                            <div>
                                <button name="newTopic" id="newTopic" type="submit">Neues Topic/Thema eröffnen</button>
                            </div>
                        </fieldset>
                    </form>
                    <c:if test="${not empty createForumTopic}">
                        <p>Topic ${createForumTopic.topicText} wurde erfolgreich erstellt</p>
                    </c:if>
                </article>
            </c:if>
            <c:if test="${not empty user && user.userGroup eq 'administration'}">
                <article>
                    <form id="DeleteTopic" action="${pageContext.request.contextPath}/DeleteForumTopicServlet" method="post" accept-charset="UTF-8">
                        <fieldset><legend>Delete Topic</legend>
                            <div>
                                <label for="deleteForumTopic">Topic/Thema über dessen ID löschen:</label>
                                <input type="number" name="deleteForumTopic" id="deleteForumTopic" size="50" maxlength="20" required placeholder="ID des Topic/Thema">
                            </div>
                            <div>
                                <button name="deleteTopicButton" id="deleteTopicButton" type="submit">Topic/Thema löschen</button>
                            </div>
                        </fieldset>
                    </form>
                    <c:if test="${deleteForumTopicId != null}">
                        <p>Topic ${deleteForumTopicId} wurde erfolgreich gelöscht</p>
                    </c:if>
                </article>
            </c:if>
            <article>
                <h3>Übersicht aller Topics</h3>
                <input type="text" class="searchInput" id="searchInput" placeholder="Thema suchen...">
                <div class="responsive_table">
                    <table id="searchTable">
                        <thead>
                            <tr>
                                <th>Thema/Topic</th>
                                <th>Eröffnet von</th>
                                <c:if test="${user.username eq 'Admin'}">
                                    <th>Topic ID</th>
                                </c:if>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${user.userGroup eq 'administration'}">
                                    <c:forEach var="forumTopic" items="${forumTopicList}">
                                        <tr>
                                            <form name="forumContentForm" action="${pageContext.request.contextPath}/ForumContentServlet" method="post" id="forumContentForm">
                                                <td><button name="forumContentText" id="${forumTopic.topicId}forumContentAdmin" type="submit"><input type="hidden" name="topicId" value="${forumTopic.topicId}">${forumTopic.topicText}</button></td>
                                            </form>
                                            <td>${forumTopic.userName}</td>
                                            <td>${forumTopic.topicId}</td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="forumTopic" items="${forumTopicList}">
                                        <tr>
                                            <form name="forumContentForm" action="${pageContext.request.contextPath}/ForumContentServlet" method="post" id="forumContentForm1">
                                                <td><button name="forumContentText" id="${forumTopic.topicId}forumContentUser" type="submit"><input type="hidden" name="topicId" value="${forumTopic.topicId}">${forumTopic.topicText}</button></td>
                                            </form>
                                            <td>${forumTopic.userName}</td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </article>
            <button class="goToTopButton" id="goToTopButton">Seitenanfang</button>
        </main>
        </div>
        <footer>
            <%@include file="../jspf/footer.jspf"%>
        </footer>
    </body>
</html>
