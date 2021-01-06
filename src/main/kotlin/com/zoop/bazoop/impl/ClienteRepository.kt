package com.zoop.bazoop.impl

import model.Cliente
import org.springframework.stereotype.Repository

@Repository
class ClienteRepository {
    private val database: MutableList<Cliente> = ArrayList()

    fun salvar(cliente: Cliente): Cliente {
        database.add(cliente)
        return cliente
    }

    fun obter(clienteId: Int): Cliente? {
        for (cliente in database) {
            if (cliente.id == clienteId) return cliente
        }

        return null
    }

    fun excluir(clienteId: Int) {
        for (i in database.indices) {
            if (database[i].id == clienteId) {
                database.removeAt(i)
                return
            }
        }
    }
    fun listar(): List<Cliente> = database
}