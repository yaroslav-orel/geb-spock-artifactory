package pages

import geb.Page

class LoginPage extends Page {

    static url = "webapp/#/login"
    static at = { usernameInput.displayed }

    static content = {
        usernameInput { $("#user") }
        passwordInput { $("#password") }
        loginButton { $("#login") }
        errorMessageLabel { $("[ng-bind = 'Login.errorMessage']") }
    }

    def authenticate(username, password){
        usernameInput.value(username)
        passwordInput.value(password)
        loginButton.click()
    }

    def getLoginErrorMessageText(){
        errorMessageLabel.text()
    }
}
