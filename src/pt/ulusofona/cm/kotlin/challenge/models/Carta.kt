package pt.ulusofona.cm.kotlin.challenge.models

open class Carta(var temCarta: Boolean = false) {

    fun tirarCarta() {
        temCarta = true
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