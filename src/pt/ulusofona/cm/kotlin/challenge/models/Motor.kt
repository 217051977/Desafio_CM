package pt.ulusofona.cm.kotlin.challenge.models

class Motor(val _cavalos: Int, val _cilindrada: Int) : VeiculosMotorizados() {

    override fun toString(): String {
        return "Motor | $_cavalos | $_cilindrada | $ligado"
    }

}