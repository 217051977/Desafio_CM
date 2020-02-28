package pt.ulusofona.cm.kotlin.challenge.models

class Data(var dia: Int = 1, var mes: Int = 2, var ano: Int = 2020) {

    override fun toString(): String {
        return "${this.javaClass.simpleName} | " +
                "${if (dia.toString().length==1) {"0$dia"}else{"$dia"}}-" +
                "${if (mes.toString().length==1) {"0$mes"}else{"$mes"}}-$ano"
    }

}