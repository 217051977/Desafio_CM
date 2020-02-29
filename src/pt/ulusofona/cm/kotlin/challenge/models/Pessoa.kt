package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

class Pessoa(val nome: String, val dataDeNascimento: Date) : Movimentavel {

    var veiculos: MutableList<Veiculo> = mutableListOf()
    var carta: Carta = Carta()
    var posicao: Posicao = Posicao()

    private fun maiorDeIdade(): Boolean {
        val dateToPass: Date = Date(dataDeNascimento.year + 12, dataDeNascimento.month, dataDeNascimento.date - 1)
        val date: Date = Date()
        return date.after(dateToPass)
    }

    private fun podeComprar(): Boolean {
        return try {
            if (maiorDeIdade()) {
                true
            } else {
                throw MenorDeIdadeException("$nome é menor de idade")
            }
        } catch (menorDeIdade: MenorDeIdadeException){
            false
        }
    }

    private fun podeConduzir(veiculo: Veiculo?): Boolean {
        return try {
            if (veiculo != null) {
                if (veiculo.requerCarta()) {
                    if (maiorDeIdade() && temCarta()) {
                        true
                    } else {
                        throw PessoaSemCartaException("$nome não tem carta para conduzir o veiculo indicado")
                    }
                } else {
                    true
                }
            } else {
                false
            }
        } catch (semCarta: PessoaSemCartaException) {
            false
        }
    }

    fun pesquisarVeiculo(identificador: String): Veiculo? {
        return try {
            var _veiculo: Veiculo? = null
            for (veiculo in veiculos) {
                if (veiculo.identificador.equals(identificador)) {
                    _veiculo = veiculo
                    break
                }
            }
            _veiculo?: throw VeiculoNaoEncontradoException("O veiculo com o id $identificador não foi encontrado!")
        }catch (veiculoNaoEncontrado: VeiculoNaoEncontradoException){
            null
        }
    }

    fun comprarVeiculo(veiculo: Veiculo) {
        if (podeComprar()) {
            val _date: Date = Date()
            veiculo.dataDeAquisicao = Date(_date.year + 1900, _date.month + 1, _date.date)
            veiculos.add(veiculo)
        }
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        val veiculoParaVender: Veiculo? = pesquisarVeiculo(identificador)

        if (veiculoParaVender != null) {
            comprador.comprarVeiculo(veiculoParaVender)
        }
        veiculos.remove(veiculoParaVender)
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        val veiculo = pesquisarVeiculo(identificador)
        if (podeConduzir(veiculo)) {
            veiculo?.moverPara(x, y)
        }
    }

    fun tirarCarta() {
        if (podeComprar()) {
            carta.tirarCarta()
        }
    }

    fun temCarta(): Boolean {
        return carta.temCarta()
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicao(x, y)
    }

    override fun toString(): String {
        val day: Int = dataDeNascimento.date
        val month: Int = dataDeNascimento.month

        return "${this.javaClass.simpleName} | $nome | " +
                "${if (day.toString().length == 1){"0${day}"} else {"$day"}}-" +
                "${if (month.toString().length == 1){"0${month + 1}"} else {"${month+1}"}}-" +
                "${dataDeNascimento.year + 1900} | $posicao"
    }

}