/*
Erstellt von Theinert Thomas
 */
"use strict";
document.addEventListener("DOMContentLoaded", init);

function init() {
    var contactForm = document.getElementById("ContactForm");
    contactForm.addEventListener("reset", confirmReset);
    contactForm.addEventListener("submit", confirmSubmit);
}

function confirmReset(evt) {
    var confirmReset = confirm("Alle Eingaben wirklich zurücksetzen?");
    if (!confirmReset) {
        evt.preventDefault();
    }
}

function confirmSubmit(evt) {
    var confirmSubmit = confirm("Kontaktanfrage wirklich abschicken?");
    if (!confirmSubmit) {
        evt.preventDefault();
    }
}