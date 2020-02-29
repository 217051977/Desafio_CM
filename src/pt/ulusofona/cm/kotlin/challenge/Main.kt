package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.*
import java.util.*

fun main() {
    val bike = Bicicleta("bikelas")
    val veiculo: List<Veiculo> = listOf(Carro("1", Motor(15, 20)),
        Veiculo("2"),
        Veiculo("3"),
        Veiculo("4"),
        Veiculo("5"),
        bike)
    val pessoa = Pessoa("Ola", Date(90, 2, 1))
//    println(pessoa)
    pessoa.veiculos = veiculo.toMutableList()
//    println(pessoa.veiculos)
//    println(pessoa.pesquisarVeiculo("6"))

    println(pessoa.posicao)
    pessoa.moverPara(-868138257, -699885381)
    println(pessoa.posicao)

//    println(pessoa.carta)
//    pessoa.tirarCarta()
//    println(pessoa.carta)
//
//    println(pessoa.pesquisarVeiculo("1"))
//    pessoa.moverVeiculoPara("1", 1547436299, 1810124764)
//    println(pessoa.pesquisarVeiculo("1"))
}