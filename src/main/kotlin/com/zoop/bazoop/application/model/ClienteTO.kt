package com.zoop.bazoop.application.model

import model.Cliente
import model.Cpf
import java.time.LocalDate

open class ClienteTO {
    var nome: String? = null
    var cpf: String? = null
    var data: LocalDate? = null

    fun toDomain(): Cliente {
        return Cliente().also {
            it.cpf = Cpf(cpf!!)
            it.nome = nome!!
            it.data = data!!
        }
    }
}

class ClienteTOResponse : ClienteTO() {
    var id: Int = 0

    companion object {
        fun fromCliente(cliente: Cliente): ClienteTOResponse {
            //todo criar cliente to response tecnica todomain
            return ClienteTOResponse().also { it.id
            it.cpf
            it.data
            it.nome}
        }
    }
}
