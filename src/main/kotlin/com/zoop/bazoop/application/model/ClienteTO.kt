package com.zoop.bazoop.application.model

import model.Cliente
//import model.Cpf
import java.time.LocalDate

open class ClienteTO {
    var nome: String? = null
    var cpf: String? = null
    var data: LocalDate? = null

    fun alterar(cliente: Cliente) {
        cliente.also {
            it.cpf = Cliente.Cpf(cpf!!)
            it.data = data!!
            it.nome = nome!!
        }
    }

    fun toDomain(): Cliente {
        return Cliente().also {
            it.cpf = Cliente.Cpf(cpf!!)
            it.nome = nome!!
            it.data = data!!
        }
    }
}

class ClienteTOResponse : ClienteTO() {
    var clienteId: Int = 0

    companion object {
        fun fromCliente(cliente: Cliente): ClienteTOResponse {
            //todo criar cliente to response tecnica todomain
            return ClienteTOResponse().also {
            it.clienteId = cliente.id
            it.cpf=cliente.cpf.value
            it.data=cliente.data
            it.nome=cliente.nome
            }
        }
    }
}
