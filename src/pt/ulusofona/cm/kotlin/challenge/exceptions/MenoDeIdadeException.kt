package pt.ulusofona.cm.kotlin.challenge.exceptions

import java.lang.Exception

/*$Pessoa.nome é menor de idade*/
class MenoDeIdadeException(message: String) : Exception(message) {
    init {
        printStackTrace()
    }
}