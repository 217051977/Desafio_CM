package pt.ulusofona.cm.kotlin.challenge.exceptions

import java.lang.Exception

class VeiculoDesligadoException(message: String = "O veiculo já está desligado!") : Exception(message) {
    init {
        printStackTrace()
    }
}