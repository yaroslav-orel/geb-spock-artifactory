package specs


import pages.HomePage
import pages.LoginPage

class LoginSpec extends BaseSpec {

    def "User with valid creds should be authenticated"() {
        given: "User is on Login page"
        to LoginPage

        when: "User enters valid credentials"
        authenticate(config.admin.username, config.admin.password)

        then: "User is redirected to Home page"
        at HomePage
    }

    def "User with invalid creds should not be authenticated"() {
        given: "user is on Login page"
        to LoginPage

        when: "User enters invalid credentials"
        authenticate("admin1", "Password1")

        then: "User is shown error message"
        getLoginErrorMessageText() == 'Username or password are incorrect'
    }
}
