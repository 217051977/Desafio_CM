package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

class Bicicleta(identificador: String) : Veiculo(identificador), Movimentavel {

    override fun requerCarta(): Boolean {

        return false

    }

    override fun moverPara(x: Int, y: Int) {

        posicao = Posicao(x, y)

    }

    override fun toString(): String {
        return "${this.javaClass.simpleName} | $identificador"
    }

}