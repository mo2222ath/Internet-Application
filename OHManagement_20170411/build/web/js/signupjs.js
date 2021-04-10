function checkUsername() {
    var xmlhttp = new XMLHttpRequest();
    var username = document.getElementById("username").value;
    var url = "checkUsername?username=" + username;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
            document.getElementById("show_responseUsername").innerHTML = xmlhttp.responseText;
        }
    }
}
function checkEmail() {
    var xmlhttp = new XMLHttpRequest();
    var email = document.getElementById("email").value;
    var url = "checkEmail?email=" + email;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
            document.getElementById("show_responseEmail").innerHTML = xmlhttp.responseText;
        }
    }
}

document.getElementById("staffRadio").onchange = function () {
    document.getElementById("subjPart").hidden = false;
};

document.getElementById("studentRadio").onchange = function () {
    document.getElementById("subjPart").hidden = true;
};


function Signup() {
    
//    var response = grecaptcha.getResponse();
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var staffRadio = document.getElementById("staffRadio").checked;
    var studentRadio = document.getElementById("studentRadio").checked;
    var subjId = "";
    if (staffRadio) {
        subjId = document.getElementById("subjId").value;
//        alert(subjId);
    }
    var url = "RegisterServlet?username=" + username + "&email=" + email + "&type=" + studentRadio + "&subjId=" + subjId;

//    alert(url);

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
            //document.getElementById("show_responseEmail").innerHTML = xmlhttp.responseText;
            alert(xmlhttp.responseText);
        }
    }
}