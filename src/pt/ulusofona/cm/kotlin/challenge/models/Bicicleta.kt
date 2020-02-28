package pt.ulusofona.cm.kotlin.challenge.models

class Bicicleta(_identificador: String) : Veiculo(_identificador) {

    override fun requerCarta(): Boolean {
        return false
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName} | $_identificador"
    }

}