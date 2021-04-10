
document.getElementById("searchSubmit").addEventListener("click", SearchUsername);

function SearchUsername() {
    var xmlhttp = new XMLHttpRequest();
    var username = document.getElementById("username").value;
//    window.alert(username);

    var url = "SearchServlet?username=" + username;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    console.log(xmlhttp.responseText);
    document.getElementById("resultSearch1").innerHTML = "";
    document.getElementById("resultSearch2").innerHTML = "";
    document.getElementById("resultSearch3").innerHTML = "";
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//            window.alert(xmlhttp.responseText);
            var result = new Array();
            result = xmlhttp.responseText.split(",", 3);
//            alert(result.length);
            if (result.length > 1) {
                document.getElementById("resultSearch1").innerHTML = result[0];
                document.getElementById("resultSearch2").innerHTML = result[1];
                document.getElementById("resultSearch3").innerHTML = result[2];
            }else{
                document.getElementById("resultSearch1").innerHTML = result[0];
            }
        }
    }
}


function ReservationsView(OH_Id) {

    var userActiveId = document.getElementById("reservationsView").value;

    var xmlhttp = new XMLHttpRequest();

    var url = "reservationsView?OH_Id=" + OH_Id + "&userActiveId=" + userActiveId;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            document.getElementById("resultViewRes").innerHTML = xmlhttp.responseText;
        }
    }
}



document.getElementById("OHSubmitAdd").addEventListener("click", AddOH);

function AddOH() {

    var OHDateAdd = document.getElementById("OHDateAdd").value;
    var OHTimeFromAdd = document.getElementById("OHTimeFromAdd").value;
    var OHTimeToAdd = document.getElementById("OHTimeToAdd").value;
    var StaffID = document.getElementById("StaffID").value;
    var xmlhttp = new XMLHttpRequest();


    var url = "AddOH?OHDateAdd=" + OHDateAdd + "&OHTimeFromAdd=" + OHTimeFromAdd + "&OHTimeToAdd=" + OHTimeToAdd + "&StaffID=" + StaffID;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            window.alert(xmlhttp.responseText);
        }
    }
}

document.getElementById("OHSubmitEdit").addEventListener("click", EditOH);

function EditOH() {

    var OHDateEdit = document.getElementById("OHDateEdit").value;
    var OHTimeFromEdit = document.getElementById("OHTimeFromEdit").value;
    var OHTimeToEdit = document.getElementById("OHTimeToEdit").value;
    var OHID = document.getElementById("OHID").value;
    var StaffIDEdit = document.getElementById("StaffIDEdit").value;
    var xmlhttp = new XMLHttpRequest();
//window.alert(OHDateEdit + " ,OHTimeFromEdit " + OHTimeFromEdit + " ,OHTimeToEdit " + OHTimeToEdit + ",OHID " + OHID + ", StaffIDEdit " + StaffIDEdit );
    var url = "EditOH?OHDateEdit=" + OHDateEdit + "&OHTimeFromEdit=" + OHTimeFromEdit + "&OHTimeToEdit=" + OHTimeToEdit + "&OHID=" + OHID + "&StaffIDEdit=" + StaffIDEdit;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//            window.alert(OHDateEdit + " ," + OHTimeFromEdit + " , " + OHTimeToEdit + "," + OHID);
            window.alert(xmlhttp.responseText);
        }
    }
}




function DeleteOH(office_hoursDeleteID) {

    var xmlhttp = new XMLHttpRequest();
    var url = "DeleteOH?office_hoursDeleteID=" + office_hoursDeleteID;
//    alert(url);
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            window.alert(xmlhttp.responseText);
        }
    }
}

function ReservationsCancle(OH_Id) {

    var userActiveId = document.getElementById("reservationsCancle").value;

    var xmlhttp = new XMLHttpRequest();

    var url = "reservationsCancle?OH_Id=" + OH_Id + "&userActiveId=" + userActiveId;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            alert(xmlhttp.responseText);
        }
    }
}