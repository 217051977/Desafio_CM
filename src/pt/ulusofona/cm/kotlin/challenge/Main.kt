package pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.*
import java.util.*

fun main() {
    val bike = Bicicleta("bikelas")
    val car = Carro("1", Motor(15, 20))
    val car2 = Carro("10", Motor(15, 20))
    val veiculo: MutableList<Veiculo> = mutableListOf(car,
        Veiculo("2"),
        Veiculo("3"),
        Veiculo("4"),
        Veiculo("5"),
        bike)
    val pessoa = Pessoa("Ola", Date(90, 2, 1))
    val pessoa2 = Pessoa("Ola2", Date())
//    println(pessoa)
    pessoa.veiculos = veiculo
    pessoa2.veiculos = mutableListOf(car2)
/*    println(pessoa.veiculos)
    println(pessoa.pesquisarVeiculo("6"))*/

/*    println(pessoa.posicao)
    pessoa.moverPara(-868138257, -699885381)
    println(pessoa.posicao)*/

    println(pessoa.carta)
    pessoa.tirarCarta()
    println(pessoa.carta)

    println(bike)
    bike.posicao = Posicao(1,2)
    println(bike)
    pessoa.moverVeiculoPara("bikelas", 3, 4)
    println(bike)
    println(car)
    pessoa.moverVeiculoPara("10", 3, 4)
    println(car)

    println(pessoa2.carta)
    pessoa2.tirarCarta()
    println(pessoa2.carta)

/*
    println(pessoa.pesquisarVeiculo("1"))
    pessoa.moverVeiculoPara("1", 1547436299, 1810124764)
    println(pessoa.pesquisarVeiculo("1"))*/

}