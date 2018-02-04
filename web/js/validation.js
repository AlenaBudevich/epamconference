/**
 * Created by Asus on 03.02.2018.
 */

function validateLoginForm() {
    var login = document.forms["loginForm"]["login"].value;
    if (login == "") {
        alert("Login must be filled out");
        return false;
    }
    var password = document.forms["loginForm"]["password"].value;
    if (password == "") {
        alert("Password must be filled out");
        return false;
    }
}

function validateRegistrationForm() {
    var login = document.forms["registrationForm"]["login"].value;
    if (login.length < 3) {
        alert("Login must consist of more than 3 characters");
        return false;
    }
    var password = document.forms["registrationForm"]["password"].value;
    if (password.length < 6) {
        alert("Password must consist of more than 6 characters");
        return false;
    }
    var repeatpassword = document.forms["registrationForm"]["repeatpassword"].value;
    if (repeatpassword != password) {
        alert("Wrong repeat password");
        return false;
    }
    var email = document.forms["registrationForm"]["email"].value;
    var r = /^\w+@\w+\.\w{2,4}$/i;
    //начало строки, символы от одного до бесконечности, @, опять символы от одного до бесконечности, точка,
    //от двух до четырёх символов (если почта где-нибудь на .info), конец строки (регистр нк учитывается)
    if (!r.test(email)) {
        alert("Wrong email");
        return false;
    }
}

function validateAddConferenceForm() {
    var conferenceName = document.forms["addConferenceForm"]["conferenceName"].value;
    if (conferenceName.length < 6) {
        alert("Conference name must consist of more than 6 characters");
        return false;
    }
}

function validateUpdateConferenceForm() {
    var conferenceName = document.forms["updateConferenceInfoForm"]["conferenceName"].value;
    if (conferenceName.length < 6) {
        alert("Conference name must consist of more than 6 characters");
        return false;
    }
}

function validateAddSectionForm() {
    var conferenceName = document.forms["addSectionForm"]["conferenceName"].value;
    if (conferenceName.length < 6) {
        alert("Conference name must consist of more than 6 characters");
        return false;
    }
    var sectionName = document.forms["addSectionForm"]["sectionName"].value;
    if (sectionName == "") {
        alert("Section name must be filled out");
        return false;
    }
}

function validateUpdateSectionForm() {
    var sectionName = document.forms["updateSectionInfoForm"]["sectionName"].value;
    if (sectionName == "") {
        alert("Section name must be filled out");
        return false;
    }
}

function validateAddReportForm() {
    var reportName = document.forms["addBasicReportInfoForm"]["reportName"].value;
    if (reportName == "") {
        alert("Report name must be filled out");
        return false;
    }
    var reportTheses = document.forms["addBasicReportInfoForm"]["reportTheses"].value;
    if (reportTheses == "") {
        alert("Report theses must be filled out");
        return false;
    }
}

function validateUpdateReportForm() {
    var reportName = document.forms["updateReportInfoForm"]["reportName"].value;
    if (reportName == "") {
        alert("Report name must be filled out");
        return false;
    }
    var reportTheses = document.forms["updateReportInfoForm"]["reportTheses"].value;
    if (reportTheses == "") {
        alert("Report theses must be filled out");
        return false;
    }
}

function validateAddSectionReportForm() {
    var sectionName = document.forms["addSectionReportForm"]["sectionName"].value;
    if (sectionName == "") {
        alert("Section name must be filled out");
        return false;
    }
    var reportName = document.forms["addSectionReportForm"]["reportName"].value;
    if (reportName == "") {
        alert("Report name must be filled out");
        return false;
    }
}

function validateChangeProfileForm() {
    var email = document.forms["changeProfileInfoForm"]["email"].value;
    var r = /^\w+@\w+\.\w{2,4}$/i;
    //начало строки, символы от одного до бесконечности, @, опять символы от одного до бесконечности, точка,
    //от двух до четырёх символов (если почта где-нибудь на .info), конец строки (регистр нк учитывается)
    if (!r.test(email)) {
        alert("Wrong email");
        return false;
    }
}

function validateSendMessageForm() {
    var login = document.forms["sendMessageForm"]["login"].value;
    if (login == "") {
        alert("User login must be filled out");
        return false;
    }
    var messageText = document.forms["sendMessageForm"]["messageText"].value;
    if (messageText == "") {
        alert("Message text must be filled out");
        return false;
    }
}

function validateChangeMessageForm() {
    var messageText = document.forms["changeMessageForm"]["messageText"].value;
    if (messageText == "") {
        alert("Message text must be filled out");
        return false;
    }
}