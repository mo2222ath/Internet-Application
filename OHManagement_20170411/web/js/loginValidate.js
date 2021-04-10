function checkLogin() {
    var xmlhttp = new XMLHttpRequest();
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var url = "validateLogin?email=" + email + "&password=" + password;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
            if (xmlhttp.responseText === "staff") {
                window.location.href = "staffPage.jsp";
            } else if (xmlhttp.responseText === "student") {
                window.location.href = "studentPage.jsp";
            } else {
                window.alert(xmlhttp.responseText);
            }
        }
    }
}