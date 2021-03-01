package com.zoop.bazoop.application.model

import com.zoop.bazoop.business.Contadigital
import com.zoop.bazoop.business.Tipo
import model.Cliente

open class ContaTO {

    var Numconta: Int? = null
    var status: String? = null
    var tipo: String? = null

    //todo refatora alterar e todomain para compartilhar a mesma logica
    fun alterar(contadigital: Contadigital) {
        contadigital.also {
            it.status = Contadigital.Status.ABERTA
            it.tipo = Tipo.CONTACOMUN

        }
    }

    fun toDomain(): Contadigital {
        return Contadigital(cliente = Cliente()).also {
            it.status = Contadigital.Status.ABERTA
            it.tipo = Tipo.CONTACOMUN
        }
    }
}

class ContaTOResponse : ContaTO() {
    var contaId: Int = 0

    companion object {
        fun fromConta(contadigital: Contadigital): ContaTOResponse {
            //todo criar cliente to response tecnica todomain
            return ContaTOResponse().also {

                it.status = contadigital.status.toString()
                it.tipo = contadigital.tipo.toString()
                it.contaId = contadigital.id
                it.Numconta = contadigital.Numconta
            }
        }
    }
}
