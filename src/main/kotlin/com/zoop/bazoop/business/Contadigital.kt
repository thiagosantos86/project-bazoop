package com.zoop.bazoop.business

import com.zoop.bazoop.application.model.ContaTO
import model.Cliente
//import org.graalvm.compiler.debug.TTY.print
import java.util.Random

open class Contadigital(
    var cliente: Cliente,
    var id: Int = Random().nextInt(100000000),
    var Numconta: Int = Random().nextInt(1000) + 1,
    var status: Status = Status.ABERTA,
    var tipo: Tipo = Tipo.CONTACOMUN,
    var Saldo: Double = 1000.0,
    var debito: Int = 50
) {
    //gerar numeros automatico
    
    enum class Status
    {
        ABERTA,FECHADA
    }


    fun fecharConta() {
        var status : Status = Status.FECHADA
        print("\nsua conta de numero : ${Numconta} conta foi fechada ")
    }

    fun Pqrcode()
    {
    }

    fun Consultarextrato()
    {
        print("\no numero da sua conta e : $Numconta ela esta $status e do tipo $tipo  seu saldo e $Saldo \n" )

    }

}
enum class Tipo
{
    CONTACOMUN,CONTAVIP
}


