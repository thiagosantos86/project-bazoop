package com.zoop.bazoop.application.model

import com.zoop.bazoop.business.ContaDigital
import com.zoop.bazoop.business.Tipo
import com.zoop.bazoop.business.Cliente

open class ContaTO {

    var numConta: Int? = null
    var status: String? = null
    var tipo: String? = null

    //todo refatora alterar e todomain para compartilhar a mesma logica
    fun alterar(contaDigital: ContaDigital) {
        contaDigital.also {
            it.status = ContaDigital.Status.ABERTA
            it.tipo = Tipo.CONTACOMUM

        }
    }

    fun toDomain(): ContaDigital {
        return ContaDigital(cliente = Cliente()).also {
            it.status = ContaDigital.Status.ABERTA
            it.tipo = Tipo.CONTACOMUM
        }
    }
}

