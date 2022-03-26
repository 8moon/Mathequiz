/*
Erstellt von Kahraman Ali
 */
document.addEventListener("DOMContentLoaded", init)

function init (){
    var form = document.getElementById("SpielErgebnis");

    form.addEventListener("reset", confirmResetForm);
}

function confirmResetForm(evt) {
    var reallyReset = confirm("Formular wirklich zurücksetzen?");
    if (!reallyReset) {
        evt.preventDefault();
    }
}
