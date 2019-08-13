package utils

import io.restassured.RestAssured

import static io.restassured.RestAssured.preemptive

class RestAssuredHelper {

    def static configureRestAssured(browser, config){
        RestAssured.baseURI = browser.baseUrl
        RestAssured.authentication = preemptive().basic(config.admin.username, config.admin.password)
    }
}
