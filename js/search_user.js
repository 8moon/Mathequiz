/*
Erstellt von Theinert Thomas und Lu Hoan
 */
"use strict";
document.addEventListener("DOMContentLoaded", init);
function init() {
    document.getElementById("username").addEventListener("keyup", changeContent);
}

function changeContent() {
    var searchURL = "../SearchUserAdminPageServlet";
    var username = document.getElementById("username").value;
    if (username != null && username.length>0)
        searchURL += "?username=" + encodeURIComponent(username);

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("searchUserList").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET", searchURL , true);
    xmlhttp.send();
}
