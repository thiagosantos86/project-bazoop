package com.zoop.bazoop.domain.service

import com.zoop.bazoop.business.Contadigital
import model.Cliente

class Extratomovimentacao(cliente: Cliente) : Contadigital(cliente = cliente) {
    fun Debito(debito : Double)
    {

        var Saldoatualizado :Double

        Saldoatualizado = Saldo - debito
        if (Saldoatualizado >= 0){
        println("Vc teve um debito de $debito e o seu saldo agora e $Saldoatualizado")
    }else{
            println("Vc tentou fazer um debito de $debito e não tem saldo agora para isso seu saldo atual e $Saldo")
        }
    }


fun Credito(creditado : Double)
{

    var Saldoatualizado :Double

    Saldoatualizado = Saldo + creditado
    if (Saldoatualizado >= 0){
        println("foi creditado na sua contao valor $creditado e o seu saldo agora e $Saldoatualizado")
    }else{
        println("Vc tentou fazer um debito de $debito e não tem saldo agora para isso seu saldo atual e $Saldo")
    }
}

}