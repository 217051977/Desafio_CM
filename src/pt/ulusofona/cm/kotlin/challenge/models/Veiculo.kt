package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

open class Veiculo
(val _identificador: String, var posicao: Posicao = Posicao(), var dataDeAquisicao: Data = Data()) : Movimentavel {

    open fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicao(x, y)
    }

    val identificador get() = _identificador

    override fun toString(): String {
        return "${this.javaClass.simpleName} | $_identificador | $dataDeAquisicao | $posicao"
    }

}