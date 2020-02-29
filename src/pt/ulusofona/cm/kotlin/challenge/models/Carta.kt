package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenoDeIdadeException

open class Carta(var temCarta: Boolean = false) {

    fun tirarCarta() {
        try {
            temCarta = true
        } catch (menorDeIdade: MenoDeIdadeException) {}
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