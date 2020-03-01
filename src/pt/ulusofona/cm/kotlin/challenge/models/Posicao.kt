package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException

class Posicao constructor(var x: Int = 0, var y: Int = 0) {

    fun alterarPosicao(x: Int, y: Int) {
        try {
            if (this.x == x && this.y == y) {
                throw AlterarPosicaoException("Já se encontra na posição ($x, $y)")
            } else {
                this.x = x
                this.y = y
            }
        } catch (mesmaPosicao: AlterarPosicaoException) {}
    }

//    fun equals(other: Posicao): Boolean {
//        return other.x == x && other.y == y
//    }

    override fun equals(other: Any?): Boolean {
        return toString() == other.toString()
    }

    override fun toString(): String {
        return "Posicao | x:$x | y:$y"
    }

}