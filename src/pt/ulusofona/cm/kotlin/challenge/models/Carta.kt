package pt.ulusofona.cm.kotlin.challenge.models

open class Carta(var temCarta: Boolean = false) {

    fun adicionarCarta() {
        temCarta = true
    }

    fun removerCarta() {
        temCarta = false
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName}: $temCarta"
    }

}