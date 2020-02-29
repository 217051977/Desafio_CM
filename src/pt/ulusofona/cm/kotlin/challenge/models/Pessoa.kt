package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenoDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.util.*

class Pessoa(val nome: String, val dataDeNascimento: Data) : Movimentavel {

    var veiculos: MutableList<Veiculo> = mutableListOf()
    var carta: Carta = Carta()
    var posicao: Posicao = Posicao()

    private fun podeComprar(): Boolean {
        return try {
            if (dataDeNascimento.menorDeIdade()) {
                throw MenoDeIdadeException("$nome é menor de idade")
            } else {
                true
            }
        } catch (menorDeIdade: MenoDeIdadeException){
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

    private fun pesquisarVeiculo(identificador: String): Veiculo? {
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
            veiculo.dataDeAquisicao = Data().newDate(Date())
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

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicao(x, y)
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName} | $veiculos | $carta | $posicao"
    }

}