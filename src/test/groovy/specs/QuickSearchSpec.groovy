package specs


import pages.QuickSearchPage
import utils.ArtifactManager
import utils.RestAssuredHelper

class QuickSearchSpec extends BaseSpec {

    def setupSpec(){
        RestAssuredHelper.configureRestAssured(browser, config)
        ArtifactManager.deployArtifact(config.artifact.name, config.artifact.repo)
    }

    def cleanupSpec(){
        ArtifactManager.deleteArtifact(config.artifact.name, config.artifact.repo)
    }

    def "User can find artifact using quick search"() {
        given: "User is on Quick Search page"
        to QuickSearchPage

        when: "User searches using correct artifact name"
        searchArtifact("important-memo.txt")

        then: "Artifact appears in search results"
        getSearchResultsSummary().contains("1 Items")
        getFoundArtifactRowsCount() == 1
    }

    def "User is shown empty results searching for non-existing artifact"() {
        given: "User is on Quick Search page"
        to QuickSearchPage

        when: "User searches using non-existing artifact name"
        searchArtifact("not-here.txt")

        then: "Nothing appears in search results"
        getSearchResultsSummary().contains("0 Items")
        getFoundArtifactRowsCount() == 0
    }
}
