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

    override fun toString(): String {
        return "${this.javaClass.simpleName} | $identificador | " +
                "${dataDeAquisicao.date}-${dataDeAquisicao.month}-${dataDeAquisicao.year} | $posicao"
    }

}