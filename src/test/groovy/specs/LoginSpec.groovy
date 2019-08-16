package specs


import pages.HomePage
import pages.LoginPage

class LoginSpec extends BaseSpec {

    def setup(){
        given: "user is on Login page"
        to LoginPage
    }

    def "user with valid creds should be authenticated"() {
        when: "user enters valid credentials"
        authenticate(config.admin.username, config.admin.password)

        then: "user is redirected to Home page"
        at HomePage
    }

    def "user with invalid creds should not be authenticated"() {
        when: "user enters invalid credentials"
        authenticate("admin1", "Password1")

        then: "user is shown error message"
        getErrorMessage() == 'Username or password are incorrect'
    }
}
