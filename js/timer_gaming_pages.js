/*
Erstellt von Theinert Thomas
Idee für die Timer-Funktion der Tabellen ist von stackoverflow übernommen, siehe:
https://stackoverflow.com/questions/29971898/how-to-create-an-accurate-timer-in-javascript
 */
var seconds = 0;
function pad ( val ) { return val > 9 ? val : "0" + val; }
setInterval( function(){
    document.getElementById("seconds").innerHTML=pad(++seconds%60);
    document.getElementById("minutes").innerHTML=pad(parseInt(seconds/60,10));
}, 1000);