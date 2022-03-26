/*
Erstellt von Theinert Thomas
 */
"use strict";
document.addEventListener("DOMContentLoaded", init);

function init() {
    var processSupportTicket = document.getElementById("saveEditSupportTicket");
    processSupportTicket.addEventListener("reset", confirmReset)
    processSupportTicket.addEventListener("submit", confirmSubmit);
}

function confirmReset(evt) {
    var confirmReset = confirm("Alle Eingaben zurücksetzen?");
    if (!confirmReset) {
        evt.preventDefault();
    }
}

function confirmSubmit(evt) {
    var confirmSubmit = confirm("Alle Eingaben speichern?");
    if (!confirmSubmit) {
        evt.preventDefault();
    }
}