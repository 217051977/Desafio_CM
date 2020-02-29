package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException

open class Carta {

    var temCarta: Boolean

    init {
        temCarta = false
    }

    fun tirarCarta() {
        try {
            temCarta = true
        } catch (menorDeIdade: MenorDeIdadeException) {}
    }

    fun perderCarta() {
        temCarta = false
    }

    fun temCarta(): Boolean {
        return temCarta
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName}: $temCarta"
    }

}