package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(val cavalos: Int, val cilindrada: Int) : Ligavel {

    var ligado: Boolean = false

    override fun ligar() {
        try {
            if (!ligado) {
                ligado = true
            } else {
                throw VeiculoLigadoException()
            }
        } catch (veiculoLigado: VeiculoLigadoException) {}
    }

    override fun desligar() {
        try {
            if (!ligado) {
                ligado = true
            } else {
                throw VeiculoDesligadoException()
            }
        } catch (veiculoDeligado: VeiculoDesligadoException) {}
    }

    override fun estaLigado(): Boolean {
        return ligado
    }

    override fun toString(): String {
        return "Motor | $cavalos | $cilindrada | $ligado"
    }

}