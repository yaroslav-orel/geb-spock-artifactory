package pages

import geb.Page
import geb.module.PasswordInput
import geb.module.TextInput

class LoginPage extends Page {

    static url = "webapp/#/login"
    static at = { usernameInput.displayed }

    static content = {
        usernameInput { $("#user").module(TextInput) }
        passwordInput { $("#password").module(PasswordInput) }
        loginButton { $("#login") }
        errorMessageLabel { $("[ng-bind = 'Login.errorMessage']") }
    }

    def authenticate(username, password){
        usernameInput = username
        passwordInput = password
        loginButton.click()
    }

    def getLoginErrorMessageText(){
        errorMessageLabel.text()
    }
}
