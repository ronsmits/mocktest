package no.tornadofx.view

import no.tornadofx.app.Styles
import tornadofx.*

class MainView : View("Hello TornadoFX") {
    override val root = hbox {
        label(title) {
            addClass(Styles.heading)
        }
    }
}