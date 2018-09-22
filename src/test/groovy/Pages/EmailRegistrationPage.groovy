package Pages

import geb.Page

class EmailRegistrationPage extends Page {
    static url = "/register"
    static at = {registerButton.text() == 'Register'}
    static content = {
        usernameField {$('input', name: 'username')}
        passwordField {$('input', name: 'password')}
        passwordConfirmationField {$('input', name: 'password_confirmation')}
        termsForm {$('label[for=\'terms\']')}
        termsCheckbox {termsForm.$('i')}
        registerButton(to: RegisterSuccess) {$('button', type: 'submit')}
    }
}
