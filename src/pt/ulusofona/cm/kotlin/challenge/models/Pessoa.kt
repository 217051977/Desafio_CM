package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.MenoDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

class Pessoa(val nome: String, val dataDeNascimento: Data) : Carta(), Movimentavel {

    var veiculos: List<Veiculo> = mutableListOf()
    var carta: Carta = Carta()
    var posicao: Posicao = Posicao()

    fun comprarVeiculo(veiculo: Veiculo) {
        try {
            if (temCarta) {
                if (dataDeNascimento.menorDeIdade()) {
                    throw MenoDeIdadeException("$nome é menor de idade!")
                }
            } else {
                throw PessoaSemCartaException("$nome não tem carta!")
            }
        } catch (pessoaSemCarta: PessoaSemCartaException) {
        } catch (menorDeIdade: MenoDeIdadeException){}
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicao(x, y)
    }

}