package specs

import geb.spock.GebSpec
import pages.HomePage
import pages.LoginPage
import spock.lang.Shared
import utils.ConfigReader

class LoginSpec extends GebSpec {

    @Shared LoginPage loginPage = browser.page(LoginPage)
    @Shared ConfigObject config = new ConfigReader().getAppConfig()

    def setup(){
        given: "user is on Login page"
        to LoginPage
    }

    def "user with valid creds should be authenticated"() {
        when: "user enters valid credentials"
        loginPage.authenticate(config.admin.username, config.admin.password)

        then: "user is redirected to Home page"
        at HomePage
    }

    def "user with invalid creds should not be authenticated"() {
        when: "user enters invalid credentials"
        loginPage.authenticate("admin1", "Password1")

        then: "user is shown error message"
        assert loginPage.getErrorMessage() == 'Username or password are incorrect'
    }
}
