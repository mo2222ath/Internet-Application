
document.getElementById("searchSubmitSpecific").addEventListener("click", SearchUsername);

function SearchUsername() {
    var xmlhttp = new XMLHttpRequest();
    var username = document.getElementById("usernameFromStudent").value;
//    window.alert(username);

    var url = "SearchServlet?username=" + username;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    console.log(xmlhttp.responseText);
    document.getElementById("resultSearch1S").innerHTML = "";
    document.getElementById("resultSearch2S").innerHTML = "";
    document.getElementById("resultSearch3S").innerHTML = "";
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//            window.alert(xmlhttp.responseText);
            var result = new Array();
            result = xmlhttp.responseText.split(",", 3);
            if(result.length > 1){
            document.getElementById("resultSearch1S").innerHTML = result[0];
            document.getElementById("resultSearch2S").innerHTML = result[1];
            document.getElementById("resultSearch3S").innerHTML = result[2];
        }else{
            document.getElementById("resultSearch1S").innerHTML = result;
        }
        }
    }
}

document.getElementById("searchSubmitSubject").addEventListener("click", SearchBySubject);

function SearchBySubject() {
    var xmlhttp = new XMLHttpRequest();
    var subjectValueSearch = document.getElementById("subjectValueSearch").value;

    var url = "searchBySubject?subjectValueSearch=" + subjectValueSearch;
//    alert(url);
    document.getElementById("resultSearch1S").innerHTML = "";
    document.getElementById("resultSearch2S").innerHTML = "";
    document.getElementById("resultSearch3S").innerHTML = "";
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {

            var ch = xmlhttp.responseText;
            if (ch.length != 66) {
                var result = new Array();
                result = xmlhttp.responseText.split("$");
                document.getElementById("resultSearch1S").innerHTML = result ;
            } else {
                document.getElementById("resultSearch1S").innerHTML = xmlhttp.responseText;
            }
        }
    }
}

document.getElementById("searchSubmitOH").addEventListener("click", ViewOH);

function ViewOH() {
    var xmlhttp = new XMLHttpRequest();
    var usernameStaffOH = document.getElementById("usernameStaffOH").value;
    var url = "viewOHforStaff?usernameStaffOH=" + usernameStaffOH;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
//    xmlhttp.onreadystatechange = function () {
//        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//        }
//    }
}

//document.getElementById("office_hoursBooking").addEventListener("click", BookingOH);

function BookingOH(office_hoursIDBOOKING, StudID) {
    var xmlhttp = new XMLHttpRequest();
//    var office_hoursIDBOOKING = document.getElementById("office_hoursIDBOOKING").value;
//    var StudID = document.getElementById("StudID").value;
    var url = "OHBooking?office_hoursIDBOOKING=" + office_hoursIDBOOKING + "&StudID=" + StudID;

    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            alert(xmlhttp.responseText);
        }
    }
}

//document.getElementById("reservationsCancle").addEventListener("click", CancleBooking);

function CancleBooking(RId, OHId) {
    var xmlhttp = new XMLHttpRequest();
//    var reservationsCancleIDOH = document.getElementById("reservationsCancleIDOH").value;
//    var reservationsIDOH = document.getElementById("reservationsIDOH").value;
    var url = "BookingCancle?RId=" + RId + "&OHId=" + OHId;
//    alert(url);
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            alert(xmlhttp.responseText);
        }
    }
}