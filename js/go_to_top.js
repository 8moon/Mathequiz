/*
Erstellt von Theinert Thomas
Idee für den Scroll-To_Top Button ist von W3Schools übernommen, siehe:
https://www.w3schools.com/howto/howto_js_scroll_to_top.asp
 */


document.addEventListener("DOMContentLoaded", init);

window.onscroll = function() {scrollFunction()};

function init() {
document.getElementById("goToTopButton").addEventListener("click", goToTop);
}

function scrollFunction() {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        document.getElementById("goToTopButton").style.display = "block";
    } else {
        document.getElementById("goToTopButton").style.display = "none";
    }
}

function goToTop() {
    document.documentElement.scrollTop = 0;
}