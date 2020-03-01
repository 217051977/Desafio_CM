package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

open class Veiculo
(val identificador: String, var posicao: Posicao = Posicao()) : Movimentavel {
    var dataDeAquisicao: Date

    init {
        val _date: Date = Date()
        dataDeAquisicao = Date(_date.year + 1900, _date.month + 1, _date.date)
    }

    open fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicao(x, y)
    }

    override fun equals(other: Any?): Boolean {
        return toString() == other.toString()
    }

    override fun toString(): String {
        val day: Int = dataDeAquisicao.date
        val month: Int = dataDeAquisicao.month
        return "${this.javaClass.simpleName} | $identificador | " +
                "${if (day.toString().length == 1){"0${day}"} else {"$day"}}-" +
                "${if (month.toString().length == 1){"0${month + 1}"} else {"${month+1}"}}-" +
                "${dataDeAquisicao.year + 1900} | $posicao"
    }

}