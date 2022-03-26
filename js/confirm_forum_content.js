/*
Erstellt von Theinert Thomas
 */
"use strict";
document.addEventListener("DOMContentLoaded", init);

function init() {
    var deleteContentAdmin = document.getElementsByClassName("deleteForumContentAdmin");
    for (var i = 0; i < deleteContentAdmin.length; i++) {
        deleteContentAdmin[i].addEventListener("submit", confirmDeleteContent);
    }

    var deleteContentUser = document.getElementById("deleteForumContentUser");
    for (var i = 0; i < deleteContentUser.length; i++) {
        deleteContentUser.addEventListener("submit", confirmDeleteContent);
    }

    var contributeForumContent = document.getElementById("ContributeForm");
    contributeForumContent.addEventListener("reset", confirmResetContent)
    contributeForumContent.addEventListener("submit", confirmSubmitContent);
}

function confirmDeleteContent(evt) {
    var confirmDelete = confirm("Beitrag wirklich löschen?");
    if (!confirmDelete) {
        evt.preventDefault();
    }
}

function confirmResetContent(evt) {
    var confirmReset = confirm("Alle Eingaben zurücksetzen?");
    if (!confirmReset) {
        evt.preventDefault();
    }
}

function confirmSubmitContent(evt) {
    var confirmSubmit = confirm("Beitrag zur Diskussion hinzufügen");
    if (!confirmSubmit) {
        evt.preventDefault();
    }
}