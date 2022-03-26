/* Erstellt von Hoan Lu*/
'use strict';
document.addEventListener("DOMContentLoaded", init);

function init() {
    // set DOM
    var pro = document.getElementById("profil");
    var pass = document.getElementById("delete");
    // set Event Listener
    pro.addEventListener("reset",confirmResetForm);
    pass.addEventListener("reset",confirmResetForm);
}

function confirmResetForm(evt) {
    var reallyReset = confirm("Formular wirklich zurücksetzen?");
    if (!reallyReset) {
        evt.preventDefault();
    }
}
