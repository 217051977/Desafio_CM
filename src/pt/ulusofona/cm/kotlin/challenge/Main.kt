package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import sun.util.resources.CalendarData
import java.util.*

/*class Stuff {

    override fun toString(): String {

        return "${this.javaClass.simpleName}\n$l\n$s"
    }

}*/

fun main() {

    var data: Date = Date(2020, 2, 1)
    println("${if (data.day.toString().length == 1) {"0${data.day}"} else {"${data.day}"}}-" +
            "${if (data.month.toString().length == 1) {"0${data.month}"} else {"${data.month}"}}-" +
            "${data.year}")
    println(Date())
    println(Date().date)
    println(Date().month + 1)
    println(if((Date().year + 1900) - data.year<18){"0"} else {"1"})


/*    val stuff: Stuff = Stuff()

    println(stuff)*/

}