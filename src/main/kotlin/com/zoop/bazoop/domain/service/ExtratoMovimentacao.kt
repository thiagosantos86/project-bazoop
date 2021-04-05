package com.zoop.bazoop.domain.service

import com.zoop.bazoop.business.ContaDigital
import model.Cliente

class ExtratoMovimentacao(cliente: Cliente) : ContaDigital(cliente = cliente) {
    fun debito(debito : Double)
    {

        var saldoAtualizado :Double

        saldoAtualizado = Saldo - debito
        if (saldoAtualizado >= 0){
        println("\n Vc teve um debito de $debito e o seu saldo agora e $saldoAtualizado \n")
    }else{
            println("\n Vc tentou fazer um debito de $debito e não tem saldo agora para isso seu saldo atual e $Saldo \n")
        }
    }


fun credito(creditado : Double)
{

    var saldoAtualizado :Double

    saldoAtualizado = Saldo + creditado
    if (saldoAtualizado >= 0){
        println("\n foi creditado na sua contao valor $creditado e o seu saldo agora e $saldoAtualizado \n")
    }else{
        println("\n Vc tentou fazer um debito de $debito e não tem saldo agora para isso seu saldo atual e $Saldo \n")
    }
}

}