package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException

class Carro(identificador: String, val _motor: Motor) : Veiculo(identificador) {

    val motor get() = _motor

    override fun moverPara(x: Int, y: Int) {
        try {
            if (motor.estaLigado()) {
                super.moverPara(x, y)
            } else {
                throw VeiculoDesligadoException()
            }
        } catch (veiculoDesligado: VeiculoDesligadoException){}

    }

    override fun toString(): String {
        return "${this.javaClass.simpleName} | ${super.toString()} | $_motor"
    }

}