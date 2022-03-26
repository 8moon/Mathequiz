<%--
Erstellt von Theinert Thomas
--%>
<table>
    <thead>
        <tr>
            <th>User ID</th>
            <th>User Vorname</th>
            <th>User Nachname</th>
            <th>Username</th>
            <th>Usergroup</th>
            <th>User E-Mail Adresse</th>
            <th>User Geschlecht</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>${updateUserAdministrationAjax.userId}</td>
            <td>${updateUserAdministrationAjax.firstname}</td>
            <td>${updateUserAdministrationAjax.lastname}</td>
            <td>${updateUserAdministrationAjax.username}</td>
            <td>${updateUserAdministrationAjax.userGroup}</td>
            <td>${updateUserAdministrationAjax.email}</td>
            <td>${updateUserAdministrationAjax.gender}</td>
        </tr>
    </tbody>
</table>