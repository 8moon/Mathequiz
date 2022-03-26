/*
Erstellt von Theinert Thomas
 */
document.addEventListener("DOMContentLoaded", function () {

    var table = document.getElementById("quick_game_result_table");
    for (var r = 1; r < table.rows.length; r++) {
        if (table.rows[r].cells[2].innerText === table.rows[r].cells[3].innerText) {
            table.rows[r].cells[2].style.backgroundColor = "green";
        } else {
            table.rows[r].cells[2].style.backgroundColor = "red";
        }
    }

})








