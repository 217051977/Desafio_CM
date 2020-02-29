package pt.ulusofona.cm.kotlin.challenge.models

class Posicao constructor(var x: Int = 0, var y: Int = 0) {

    fun alterarPosicao(x: Int, y: Int) {

        this.x = x
        this.y = y

    }

    override fun toString(): String {
        return "Posicao | x:$x | y:$y"
    }

}