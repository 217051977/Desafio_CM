package pt.ulusofona.cm.kotlin.challenge.models

import java.util.*

open class Veiculo
private constructor(val identificador: String, var posicao: Posicao, var dataDeAquisicao: Date) {

    constructor(identificador: String): this(identificador, posicao = Posicao(), dataDeAquisicao = Date())

    override fun toString(): String {

        return "Veiculo | $identificador | $dataDeAquisicao | $posicao"

    }

}