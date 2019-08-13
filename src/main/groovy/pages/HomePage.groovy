package pages

import geb.Page

class HomePage extends Page {

    static at = { homeIcon.displayed }

    static content = {
        homeIcon { $("[class = 'icon icon-home-new']") }
    }
}
