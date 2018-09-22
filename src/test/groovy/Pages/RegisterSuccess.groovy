package Pages

import geb.Page

class RegisterSuccess extends Page {
    static url = "/register/success"
    static at = {thankYouHeading.text() == "Thank you"}
    static content = {
        successIcon {$("i.icomoon.icon-tick")}
        feedback {$("div.feedback")}
        thankYouHeading {feedback.$("h2")}
        successMsg {feedback.$("p:first-child")}
        confirmationEmailSentMsg {feedback.$("p:nth-child(2)")}
        confirmationEmailSentTo {confirmationEmailSentMsg.$("strong")}
    }
}
