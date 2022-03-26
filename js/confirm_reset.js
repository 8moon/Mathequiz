/* Erstellt von Hoan Lu */
'use strict';
document.addEventListener("DOMContentLoaded", init);

function init() {
    // set DOM
    var regi = document.getElementById("registrieren");
    // set Event Listener
    regi.addEventListener("reset",confirmResetForm);

}

function confirmResetForm(evt) {
    var reallyReset = confirm("Formular wirklich zurücksetzen?");
    if (!reallyReset) {
        evt.preventDefault();
    }
}
