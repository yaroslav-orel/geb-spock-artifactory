package pages

import geb.Page

class QuickSearchPage extends Page {
    static url = "webapp/#/search/quick/"
    static at = { searchButton.displayed }

    static content = {
        seachValueInput { $("#criterion-string-0") }
        searchButton { $("[ng-click='queryMaker.search()']") }
        searchResultsCounterLabel { $("[class='search-results-title ng-binding']") }
    }

    def searchArtifact(name){
        seachValueInput.value(name)
        searchButton.click()
    }

    def getSearchResultsSummary(){
        waitFor {searchResultsCounterLabel.text().contains("Items")}
        searchResultsCounterLabel.text()
    }

}
