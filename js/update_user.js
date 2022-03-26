/*
Erstellt von Theinert Thomas
 */
"use strict";
document.addEventListener("DOMContentLoaded", init);
function init() {

    var selectUserGroup = document.getElementsByClassName("selectUserGroup");
    for (var i = 0; i < selectUserGroup.length; i++) {
        selectUserGroup[i].addEventListener("change", updateUserGroup);
    }

    var selectUserGender = document.getElementsByClassName("selectUserGender");
    for (var x = 0; x < selectUserGender.length; x++) {
        selectUserGender[x].addEventListener("change", updateUserGender);
    }

    var selectUserName = document.getElementsByClassName("selectUserName");
    for (var i = 0; i < selectUserName.length; i++) {
        selectUserName[i].addEventListener("change", updateUserName);
    }

    var selectUserFirstName = document.getElementsByClassName("selectUserFirstName");
    for (var i = 0; i < selectUserFirstName.length; i++) {
        selectUserFirstName[i].addEventListener("change", updateUserFirstName);
    }

    var selectUserLastName = document.getElementsByClassName("selectUserLastName");
    for (var i = 0; i < selectUserLastName.length; i++) {
        selectUserLastName[i].addEventListener("change", updateUserLastName);
    }

    var selectUserEMail = document.getElementsByClassName("selectUserEMail");
    for (var i = 0; i < selectUserEMail.length; i++) {
        selectUserEMail[i].addEventListener("change", updateUserEMail);
    }
}

function updateUserGroup() {
    var userId = this.name;
    var selectedUserGroup = this.value;
    var userGroup = encodeURIComponent(selectedUserGroup);
    var sendString = "userId=" + userId + "&userGroup=" + userGroup;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("lastUpdatedUser").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open("POST", "../UpdateUserAdminPageAJAXServlet" , true);
    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xmlhttp.send(sendString);
}

function updateUserGender() {
    var userId = this.name;
    var selectedUserGender = this.value;
    var userGender = encodeURIComponent(selectedUserGender);
    var sendString = "userId=" + userId + "&gender=" + userGender;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("lastUpdatedUser").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open("POST", "../UpdateUserAdminPageAJAXServlet" , true);
    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xmlhttp.send(sendString);
}

function updateUserName() {
    var userId = this.name;
    var selectedUserName = this.value;
    var userName = encodeURIComponent(selectedUserName);
    var sendString = "userId=" + userId + "&userName=" + userName;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("lastUpdatedUser").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open("POST", "../UpdateUserAdminPageAJAXServlet" , true);
    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xmlhttp.send(sendString);
}

function updateUserEMail() {
    var userId = this.name;
    var selectedUserEMail = this.value;
    var userEmail = encodeURIComponent(selectedUserEMail);
    var sendString = "userId=" + userId + "&eMail=" + userEmail;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("lastUpdatedUser").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open("POST", "../UpdateUserAdminPageAJAXServlet" , true);
    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xmlhttp.send(sendString);
}

function updateUserFirstName() {
    var userId = this.name;
    var selectedUserFirstName = this.value;
    var userFirstName = encodeURIComponent(selectedUserFirstName);
    var sendString = "userId=" + userId + "&firstName=" + userFirstName;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("lastUpdatedUser").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open("POST", "../UpdateUserAdminPageAJAXServlet" , true);
    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xmlhttp.send(sendString);
}

function updateUserLastName() {
    var userId = this.name;
    var selectedUserLastName = this.value;
    var userLastName = encodeURIComponent(selectedUserLastName);
    var sendString = "userId=" + userId + "&lastName=" + userLastName;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("lastUpdatedUser").innerHTML = xmlhttp.responseText;
        }
    };
    xmlhttp.open("POST", "../UpdateUserAdminPageAJAXServlet" , true);
    xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    xmlhttp.send(sendString);
}