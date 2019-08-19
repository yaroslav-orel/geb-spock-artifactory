package pages

import geb.Page
import geb.module.TextInput
import modules.SearchResultRow

class QuickSearchPage extends Page {
    static url = "webapp/#/search/quick/"
    static at = { searchButton.displayed }

    static content = {
        seachValueInput { $("#criterion-string-0").module(TextInput) }
        searchButton { $("[ng-click='queryMaker.search()']") }
        searchResultsCounterLabel { $("[class='search-results-title ng-binding']") }
        foundArtifactRows(wait: false, required: false) {
            $("[class*='ui-grid-render-container-body'] [ng-if='!row.entity._emptyRow']")
                    .moduleList(SearchResultRow)
        }
    }

    def searchArtifact(name){
        seachValueInput = name
        searchButton.click()
    }

    def getSearchResultsSummary(){
        waitFor {searchResultsCounterLabel.text().contains("Items")}
        searchResultsCounterLabel.text()
    }

}
