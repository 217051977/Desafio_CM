package pt.ulusofona.cm.kotlin.challenge.exceptions

import java.lang.Exception

class VeiculoLigadoException(message: String = "O veiculo já está ligado!") : Exception(message) {
    init {
        printStackTrace()
    }
}