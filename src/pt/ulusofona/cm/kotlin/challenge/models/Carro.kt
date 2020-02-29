package pt.ulusofona.cm.kotlin.challenge.models

class Carro(identificador: String, val _motor: Motor) : Veiculo(identificador) {

    val motor get() = _motor

    override fun toString(): String {
        return "${this.javaClass.simpleName} | ${super.toString()} | $_motor"
    }

}