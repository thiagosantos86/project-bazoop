package com.zoop.bazoop.application.model

import com.zoop.bazoop.business.Cliente
import java.time.LocalDate

open class ClienteTO {
    var nome: String? = null
    var cpf: String? = null
    var data: LocalDate? = null

    fun alterar(cliente: Cliente) {
        cliente.also {
            it.cpf = Cliente.Cpf()
            it.nome = nome!!
        }
    }

    fun toDomain(): Cliente {
        return Cliente().also {
            it.cpf = Cliente.Cpf()
            it.nome = nome!!
        }
    }
}


