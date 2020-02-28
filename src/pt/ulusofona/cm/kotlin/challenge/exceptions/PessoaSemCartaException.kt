package pt.ulusofona.cm.kotlin.challenge.exceptions

import java.lang.Exception

/*$Pessoa.nome não tem carta*/
class PessoaSemCartaException(message: String ) : Exception(message) {
    init {
        printStackTrace()
    }
}