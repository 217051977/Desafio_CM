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

    private fun maiorDeIdade(date: Date): Boolean {
        val dateToPass: Date = Date(dataDeNascimento.year + 12, dataDeNascimento.month, dataDeNascimento.date)
        val _date: Date = Date()
        val actualDate: Date = Date(_date.year + 1900, _date.month + 1, _date.date)
        return actualDate.after(dateToPass)
    }

    private fun podeComprar(): Boolean {
        return try {
            if (maiorDeIdade(Date())) {
                throw MenorDeIdadeException("$nome é menor de idade")
            } else {
                true
            }
        } catch (menorDeIdade: MenorDeIdadeException){
            false
        }
    }

    private fun podeConduzir(): Boolean {
        return try {
            if (podeComprar() && carta.temCarta) {
                true
            } else {
                throw PessoaSemCartaException("$nome não tem carta para conduzir o veiculo indicado")
            }
        } catch (semCarta: PessoaSemCartaException) {
            false
        }
    }

    fun pesquisarVeiculo(identificador: String): Veiculo? {
        try {
            var _veiculo: Veiculo? = null
            for (veiculo in veiculos) {
                if (veiculo.identificador == identificador) {
                    _veiculo = veiculo
                }
            }
            return _veiculo?: throw VeiculoNaoEncontradoException("O veiculo com o id $identificador não foi encontrado!")
        }catch (veiculoNaoEncontrado: VeiculoNaoEncontradoException){
            return null
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
        if (podeConduzir()) {
            pesquisarVeiculo(identificador)?.moverPara(x, y)
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
        return "${this.javaClass.simpleName} | $nome | " +
                "${dataDeNascimento.date}-${dataDeNascimento.month}-${dataDeNascimento.year} | " +
                "$veiculos | $carta | $posicao"
    }

}