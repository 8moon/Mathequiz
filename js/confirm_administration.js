/*
Erstellt von Theinert Thomas
 */
"use strict";
document.addEventListener("DOMContentLoaded", init);

function init() {
    var createNewUser = document.getElementById("CreateNewUserOnAdminPage");
    createNewUser.addEventListener("reset", confirmReset)
    createNewUser.addEventListener("submit", confirmSubmit);

    var updateUser = document.getElementById("UpdateUserOnAdminPage");
    updateUser.addEventListener("reset", confirmReset)
    updateUser.addEventListener("submit", confirmSubmit);

    var deleteUser = document.getElementById("DeleteUserOnAdminPage");
    deleteUser.addEventListener("submit", confirmDelete);
}

function confirmReset(evt) {
    var confirmReset = confirm("Alle Eingaben wirklich zurücksetzen?");
    if (!confirmReset) {
        evt.preventDefault();
    }
}

function confirmSubmit(evt) {
    var confirmSubmit = confirm("Alle Eingaben wirklich in die Datenbank übernehmen?");
    if (!confirmSubmit) {
        evt.preventDefault();
    }
}

function confirmDelete(evt) {
    var confirmDelete = confirm("User wirklich aus der Datenbank löschen?");
    if (!confirmDelete) {
        evt.preventDefault();
    }
}