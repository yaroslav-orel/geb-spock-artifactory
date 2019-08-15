package pages

import geb.Page

class LoginPage extends Page {

    static url = "webapp/#/login"
    static at = { username.displayed }

    static content = {
        username { $("#user") }
        password { $("#password") }
        login { $("#login") }
        errorMsg { $("[ng-bind = 'Login.errorMessage']") }
    }

    def authenticate(user, pass){
        username.value(user)
        password.value(pass)
        login.click()
    }

    def getErrorMessage(){
        errorMsg.text()
    }
}
