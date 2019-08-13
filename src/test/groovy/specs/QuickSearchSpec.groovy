package specs

import geb.spock.GebSpec
import pages.QuickSearchPage
import spock.lang.Shared
import utils.ArtifactManager
import utils.ConfigReader
import utils.RestAssuredHelper

class QuickSearchSpec extends GebSpec {

    @Shared QuickSearchPage quickSearchPage = browser.page(QuickSearchPage)
    @Shared ConfigObject config = new ConfigReader().getAppConfig()

    def setupSpec(){
        RestAssuredHelper.configureRestAssured(browser, config)
        ArtifactManager.deployArtifact(config.artifact.name, config.artifact.repo)
    }

    def cleanupSpec(){
        ArtifactManager.deleteArtifact(config.artifact.name, config.artifact.repo)
    }

    def setup(){
        given: "user is on Quick Search page"
        to QuickSearchPage
    }

    def "user can find artifact using quick search"() {
        when: "user searches using correct artifact name"
        quickSearchPage.searchArtifact("important-memo.txt")

        then: "artifact appears in search results"
        assert quickSearchPage.getSearchResultsSummary().contains("1 Items")
    }

    def "user is shown empty results searching for non-existing artifact"() {
        when: "user searches using non-existing artifact name"
        quickSearchPage.searchArtifact("not-here.txt")

        then: "search results show 0 items"
        assert quickSearchPage.getSearchResultsSummary().contains("0 Items")
    }
}
