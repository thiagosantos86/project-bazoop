package com.zoop.bazoop.repository

import com.zoop.bazoop.domain.ClienteNaoEncontradoException
import com.zoop.bazoop.business.Cliente
import org.springframework.beans.factory.annotation.Autowired
//import model.Cpf
import org.springframework.stereotype.Repository

@Repository
class ClienteRepository {
    @Autowired
    lateinit var repository: ClienteJPARepository
    private val database: MutableList<Cliente> = ArrayList()

    fun salvar(cliente: Cliente): Cliente {
        return repository.save(cliente)
    }

    fun obter(clienteId: Int): Cliente {

        return database.firstOrNull { it.id == clienteId } ?: throw ClienteNaoEncontradoException()
    }

    fun excluir(clienteId: Int) {

        if (!database.removeIf { it.id == clienteId }) {
            throw ClienteNaoEncontradoException()
        }
    }

    fun alterar(cliente: Cliente): Cliente {

        return cliente
    }

    fun listar(): List<Cliente> = database
}
