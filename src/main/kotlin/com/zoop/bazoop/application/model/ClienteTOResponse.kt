package com.zoop.bazoop.application.model

import model.Cliente

class ClienteTOResponse : ClienteTO() {
    var clienteId: Int = 0

    companion object {
        fun fromCliente(cliente: Cliente): ClienteTOResponse {

            return ClienteTOResponse().also {
                it.clienteId = cliente.id
                it.cpf = cliente.cpf.value
                it.data = cliente.data
                it.nome = cliente.nome
            }
        }
    }
}