
//document.getElementById("SendMessageSubmit").addEventListener("click", SendMessage);


function SendMessage(UserID) {
    var contactMessage = document.getElementById("contactMessage").value;
    var TeamMessage = document.getElementById("TeamMessage").checked;
    var specificMessage = document.getElementById("specificMessage").checked;
//    alert("TeamMessage -- > " + TeamMessage + "  specificMessage ---> " + specificMessage);
    var xmlhttp = new XMLHttpRequest();

    var url = "";

    if (TeamMessage == true) {
        var subjectValue = document.getElementById("subjectValue").value;
        url = "SendMessage?team=true&subjectValue=" + subjectValue + "&contactMessage=" + contactMessage + "&UserID=" + UserID;
//            window.alert(urlForSubject);
    } else {
        var emailToSend = document.getElementById("emailPart").value;
        url = "SendMessage?team=false&emailToSend=" + emailToSend + "&contactMessage=" + contactMessage + "&UserID=" + UserID;
//            window.alert(urlForSpecefic);
    }

    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
//            window.alert(url);
            window.alert(xmlhttp.responseText);
        }
    }
}

document.getElementById("specificMessage").onchange = function () {
//    alert("specificMessage");
    document.getElementById("emailPart").hidden = false;
    document.getElementById("subjectPart").hidden = true;
};

document.getElementById("TeamMessage").onchange = function () {
//    alert("subjectTeam");
    document.getElementById("subjectPart").hidden = false;
    document.getElementById("emailPart").hidden = true;
};