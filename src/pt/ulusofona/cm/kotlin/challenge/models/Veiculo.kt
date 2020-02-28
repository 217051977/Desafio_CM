package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

abstract class Veiculo
(val identificador: String, var posicao: Posicao = Posicao(), var dataDeAquisicao: Data = Data()) : Movimentavel {

    abstract fun requerCarta(): Boolean

    override fun toString(): String {

        return "${this.javaClass.simpleName} | $identificador | $dataDeAquisicao | $posicao"

    }

}