package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Carro(_identificador: String, val _motor: Motor) : Veiculo(_identificador) {

    val motor get() = _motor

    override fun toString(): String {
        return "${this.javaClass.simpleName} | $_identificador | $_motor"
    }

}