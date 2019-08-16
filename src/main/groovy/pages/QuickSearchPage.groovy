package pages

import geb.Page
import geb.module.TextInput

class QuickSearchPage extends Page {
    static url = "webapp/#/search/quick/"
    static at = { searchButton.displayed }

    static content = {
        seachValueInput { $("#criterion-string-0").module(TextInput) }
        searchButton { $("[ng-click='queryMaker.search()']") }
        searchResultsCounterLabel { $("[class='search-results-title ng-binding']") }
        foundArtifactRows(wait: false, required: false) {
            $("[class*='ui-grid-render-container-body'] [ng-if='!row.entity._emptyRow']")
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

    def getFoundArtifactRowsCount(){
        foundArtifactRows.size()
    }

}
