package utils

class ConfigReader {

    def static getAppConfig(){
        new ConfigSlurper().parse(new File("src/test/resources/AppConfig.groovy").toURI().toURL())
    }
}
