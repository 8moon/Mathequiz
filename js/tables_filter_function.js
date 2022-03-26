/*
Erstellt von Theinert Thomas
Idee für die Filter-Funktion der Tabellen ist von W3Schools übernommen, siehe:
https://www.w3schools.com/howto/howto_js_filter_table.asp
 */
function searchFunction() {
    var input = document.getElementById("searchInput");
    var filter = input.value.toUpperCase();
    var table = document.getElementById("searchTable");
    var tr = table.getElementsByTagName("tr");

    for (var i = 0; i < tr.length; i++) {
        var td = tr[i].getElementsByTagName("td")[0];
        var td1 = tr[i].getElementsByTagName("td")[1];
        if (td && td1) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1 || td1.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function searchFunction1() {
    var input = document.getElementById("searchInput1");
    var filter = input.value.toUpperCase();
    var table = document.getElementById("searchTable1");
    var tr = table.getElementsByTagName("tr");

    for (var i = 0; i < tr.length; i++) {
        var td0 = tr[i].getElementsByTagName("td")[0];
        var td1 = tr[i].getElementsByTagName("td")[1];
        var td2 = tr[i].getElementsByTagName("td")[2];
        var td3 = tr[i].getElementsByTagName("td")[3];
        var td4 = tr[i].getElementsByTagName("td")[4];
        var td5 = tr[i].getElementsByTagName("td")[5];
        if (td0 && td1 && td2 && td3 && td4 && td5) {
            if (td0.innerHTML.toUpperCase().indexOf(filter) > -1 || td1.innerHTML.toUpperCase().indexOf(filter) > -1
                || td2.innerHTML.toUpperCase().indexOf(filter) > -1 || td3.innerHTML.toUpperCase().indexOf(filter) > -1
                || td4.innerHTML.toUpperCase().indexOf(filter) > -1 || td5.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

function searchFunction2() {
    var input = document.getElementById("searchInput2");
    var filter = input.value.toUpperCase();
    var table = document.getElementById("searchTable2");
    var tr = table.getElementsByTagName("tr");

    for (var i = 0; i < tr.length; i++) {
        var td0 = tr[i].getElementsByTagName("td")[0];
        var td1 = tr[i].getElementsByTagName("td")[1];
        var td2 = tr[i].getElementsByTagName("td")[2];
        var td3 = tr[i].getElementsByTagName("td")[3];
        var td4 = tr[i].getElementsByTagName("td")[4];
        var td5 = tr[i].getElementsByTagName("td")[5];
        if (td0 && td1 && td2 && td3 && td4 && td5) {
            if (td0.innerHTML.toUpperCase().indexOf(filter) > -1 || td1.innerHTML.toUpperCase().indexOf(filter) > -1
                || td2.innerHTML.toUpperCase().indexOf(filter) > -1 || td3.innerHTML.toUpperCase().indexOf(filter) > -1
                || td4.innerHTML.toUpperCase().indexOf(filter) > -1 || td5.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}

