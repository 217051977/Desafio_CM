package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException

class Carro(identificador: String, val motor: Motor) : Veiculo(identificador) {

    override fun moverPara(x: Int, y: Int) {
        if (motor.estaLigado()) {
            super.moverPara(x, y)
            if (!motor.estaLigado()) {
                motor.ligar()
            }
        } else {
            super.moverPara(x, y)
            if (motor.estaLigado()) {
                motor.desligar()
            }
        }
//        try {
//            if (motor.estaLigado()) {
//                super.moverPara(x, y)
//            } else {
//                throw VeiculoDesligadoException()
//            }
//        } catch (veiculoDesligado: VeiculoDesligadoException){}
    }

    override fun toString(): String {
        return "${super.toString()} | $motor"
    }

}