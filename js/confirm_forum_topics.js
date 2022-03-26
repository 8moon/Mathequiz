/*
Erstellt von Theinert Thomas
 */
"use strict";
document.addEventListener("DOMContentLoaded", init);

function init() {
    var newTopic = document.getElementById("CreateNewTopic");
    newTopic.addEventListener("submit", confirmSubmitNewTopic);

    var deleteTopic = document.getElementById("DeleteTopic");
    deleteTopic.addEventListener("submit", confirmDeleteTopic);
}

function confirmSubmitNewTopic(evt) {
    var confirmSubmit = confirm("Neus Topic erstellen");
    if (!confirmSubmit) {
        evt.preventDefault();
    }
}

function confirmDeleteTopic(evt) {
    var confirmDelete = confirm("Topic wirklich löschen?");
    if (!confirmDelete) {
        evt.preventDefault();
    }
}