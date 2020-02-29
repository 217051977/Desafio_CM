package pt.ulusofona.cm.kotlin.challenge.models

import java.util.*

class Data(var dia: Int = 1, var mes: Int = 2, var ano: Int = 2020) : Date() {

    fun newDate(date: Date): Data {
        val day: Int = date.date
        val month: Int = date.month + 1
        val year: Int = date.year + 1900
        return Data(day, month, year)
    }

    fun menorDeIdade(): Boolean {
        val actualYear: Int = Date().year + 1900
        val actualMonth: Int = Date().month + 1
        val actualDay: Int = Date().date
        if (actualYear - ano < 18) {
            return true
        } else if(actualYear - ano == 18 && actualMonth - mes < 0) {
            return true
        } else return actualYear - ano == 18 && actualMonth - mes == 0 && actualDay - dia < 0
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName} | " +
                "${if (dia.toString().length==1) {"0$dia"}else{"$dia"}}-" +
                "${if (mes.toString().length==1) {"0$mes"}else{"$mes"}}-$ano"
    }

}