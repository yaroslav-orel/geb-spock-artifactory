package pages

import geb.Page

class QuickSearchPage extends Page {
    static url = "webapp/#/search/quick/"
    static at = { searchButton.displayed }

    static content = {
        seachValue { $("#criterion-string-0") }
        searchButton { $("[ng-click='queryMaker.search()']") }
        resultsCounter { $("[class='search-results-title ng-binding']") }
    }

    def searchArtifact(name){
        seachValue.value(name)
        searchButton.click()
    }

    def getSearchResultsSummary(){
        waitFor { resultsCounter.displayed }
        resultsCounter.text()
    }

}
