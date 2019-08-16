package specs

import geb.spock.GebSpec
import spock.lang.Shared
import utils.ConfigReader

class BaseSpec extends GebSpec {
    @Shared ConfigObject config = ConfigReader.getAppConfig()
}
