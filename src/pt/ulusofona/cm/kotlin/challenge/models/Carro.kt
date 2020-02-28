package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro(identificador: String, val motor: Motor) : Veiculo(identificador), Ligavel {

    override fun requerCarta(): Boolean {

        return true

    }

    override fun ligar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun desligar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun estaLigado(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun moverPara(x: Int, y: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName} | $identificador | $motor"
    }

}