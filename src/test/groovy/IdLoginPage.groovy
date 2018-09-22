import Pages.EmailRegistrationPage
import Pages.modules.FooterModule
import geb.Page

class IdLoginPage extends Page {
    static url = "/login"
    static at = {header.isDisplayed()}
    static content = {
        consentLaterButton {$("button[data-modal-later]")}
        header {$("h1>a[title=\"G2A ID\"]")}
        loginForm {$("div", id: "login-main")}
        usernameField {$('input', name: 'username')}
        passwordField {$("input", name: 'password')}
        loginButton {$("button", type: "submit")}
        registerButton(to: EmailRegistrationPage) {$("a.btn-secondary")}

        footerModule {module FooterModule}
    }
    def login(username, password) {

    }
}
