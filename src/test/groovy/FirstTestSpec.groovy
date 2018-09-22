import Pages.EmailRegistrationPage
import Pages.RegisterSuccess
import geb.spock.GebReportingSpec

import java.time.Year

class FirstTestSpec extends GebReportingSpec {

    def "Registering new username should be successful"() {
        given: "user is on main G2A ID page"
        def loginPage = to new IdLoginPage()
        when: "user dismisses cookie modal"
        loginPage.consentLaterButton.click()
        driver.navigate().refresh()

        and: "clicks on register button"
        loginPage.registerButton.click()

        then: "user should be redirected to registration page"
        at EmailRegistrationPage

        when: "enters correct credentials"
        def emailRegisterPage = to new EmailRegistrationPage()
        emailRegisterPage.usernameField = "test-geb" + System.currentTimeMillis() + "@g2a.gr"
        emailRegisterPage.passwordField = "Test1234"
        emailRegisterPage.passwordConfirmationField = "Test1234"
        emailRegisterPage.termsCheckbox.click()

        and: "submits registration from"
        emailRegisterPage.registerButton.click()

        then: "user should be redirected to registration success page"
        at RegisterSuccess
    }

    def "Copyright year displayed in the footer should match current one"() {
        given: "user is on main G2A ID page"
        def loginPage = to new IdLoginPage()
        when: "user dismisses cookie modal"
//        loginPage.consentLaterButton.click()
//        driver.navigate().refresh()
        def elementFoo = loginPage.footerModule.footer
        interact {
            moveToElement(elementFoo)
        }

        then: "Copyright year displayed should match current one"
        assert elementFoo.text().contains(Year.now().getValue().toString())
    }

    def "Registering new username with invalid credentials should fail"() {
        given: "user is on main G2A ID page"
        def loginPage = to new IdLoginPage()
//        when: "user dismisses cookie modal"
//        loginPage.consentLaterButton.click()
//        driver.navigate().refresh()

        when: "clicks on register button"
        loginPage.registerButton.click()

        then: "user should be redirected to registration page"
        at EmailRegistrationPage

        when: "enters correct credentials"
        def emailRegisterPage = to new EmailRegistrationPage()
        emailRegisterPage.usernameField = "test-geb" + System.currentTimeMillis() + "@g2a.gr"
        emailRegisterPage.passwordField = "';DROP)Test1234"
        emailRegisterPage.passwordConfirmationField = "';DROP)Test1234"
        emailRegisterPage.termsCheckbox.click()

        and: "submits registration from"
        emailRegisterPage.registerButton.click()

        then: "user should be redirected to registration success page"
        at RegisterSuccess
    }
}
