package com.zoop.bazoop.application.model

import com.zoop.bazoop.business.ContaDigital

class ContaTOResponse : ContaTO() {
    var contaId: Int = 0

    companion object {
        fun fromConta(contaDigital: ContaDigital): ContaTOResponse {

            return ContaTOResponse().also {

                it.status = contaDigital.status.toString()
                it.tipo = contaDigital.tipo.toString()
                it.contaId = contaDigital.id
                it.numConta = contaDigital.numConta
            }
        }
    }
}
