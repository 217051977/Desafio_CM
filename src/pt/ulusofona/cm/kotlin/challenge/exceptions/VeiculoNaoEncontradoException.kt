package pt.ulusofona.cm.kotlin.challenge.exceptions

import java.lang.Exception

/*O veiculo $veiculo.identificador não foi encontrado*/
class VeiculoNaoEncontradoException(message: String) : Exception(message) {
    init {
        printStackTrace()
    }
}