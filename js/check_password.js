/* Erstellt von Hoan Lu   quelle: https://www.w3schools.com/jsref/prop_style_border.asp */
'use strict';
document.addEventListener("DOMContentLoaded", init);

var pw1;
var pw2;

function init() {
    // set DOM
    pw1 = document.getElementById("newPassword");
    pw2 = document.getElementById("passwordConfirmation");

    // set Event Listener

    pw1.addEventListener("input", function(e) {
        comparePasswords();
    });
    pw2.addEventListener("input", function(e) {
        comparePasswords();
    });
}

function comparePasswords() {
    if (pw1.value != pw2.value) {
        pw1.style.border = "5px groove red";
        pw2.style.border = "5px groove red";
    } else {
        pw1.style.border = "5px groove #00ff00";
        pw2.style.border = "5px groove #00ff00";
    }
}