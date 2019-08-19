package modules

import geb.Module

class SearchResultRow extends Module {

    static content = {
        nameLabel { $("[class*='autotest-quick-artifact']") }
    }

}
