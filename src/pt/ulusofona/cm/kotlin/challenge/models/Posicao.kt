package pt.ulusofona.cm.kotlin.challenge.models

class Posicao
private constructor(var x: Int, var y: Int){

    constructor() : this(0, 0)

    fun alterarPosicao(x: Int, y: Int) {

        this.x = x
        this.y = y

    }

    override fun toString(): String {
        return "Posicao | x:$x | y:$y"
    }

}