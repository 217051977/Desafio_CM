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

    fun comprarVeiculo(veiculo: Veiculo) {
        try {
            if (carta.temCarta) {
                if (dataDeNascimento.menorDeIdade()) {
                    throw MenoDeIdadeException("$nome é menor de idade!")
                } else {
                    veiculo.dataDeAquisicao = Data().newDate(Date())
                    veiculos.add(veiculo)
                }
            } else {
                throw PessoaSemCartaException("$nome não tem carta!")
            }
        } catch (pessoaSemCarta: PessoaSemCartaException) {
        } catch (menorDeIdade: MenoDeIdadeException){}
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

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        val veiculoParaVender: Veiculo? = pesquisarVeiculo(identificador)

        if (veiculoParaVender != null) {
            comprador.comprarVeiculo(veiculoParaVender)
        }
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        pesquisarVeiculo(identificador)?.moverPara(x, y)
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicao(x, y)
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName} | $veiculos | $carta | $posicao"
    }

}