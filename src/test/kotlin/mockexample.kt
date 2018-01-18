import io.mockk.every
import io.mockk.mockk
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import org.junit.Assert
import org.junit.Test
import tornadofx.*
import kotlin.test.assertEquals


class Person {
    constructor(name: String, address: String) {
        this.name = name
        this.address = address
    }

    val addressProperty = SimpleStringProperty()
    var address by addressProperty
    val nameProperty = SimpleStringProperty()
    var name by nameProperty
}

class PersonController : Controller() {

    val persons = FXCollections.observableArrayList<Person>()
    fun allPersons() = persons

    fun count() = persons.size
}

class testclass {
    val controller: PersonController = mockk()

    val testpersons = listOf(Person("Ron", "Best"), Person("Edvin", "dontknow")).observable()
    @Test
    fun test1() {
        every { controller.count() } returns 10

        Assert.assertEquals(10, controller.count())
    }

    @Test
    fun test2() {
        every {controller.allPersons()} returns testpersons

        val testList = controller.allPersons()
        assertEquals(testList.size, 2)
        assertEquals(testList[0].name, "Ron")
        assertEquals(controller.allPersons().size, 2)
    }

}