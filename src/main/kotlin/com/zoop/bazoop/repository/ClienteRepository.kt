package com.zoop.bazoop.repository

import com.zoop.bazoop.domain.ClienteNaoEncontradoException
import com.zoop.bazoop.business.Cliente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
//import model.Cpf
import org.springframework.stereotype.Repository

@Repository
class ClienteRepository {
    @Autowired
    lateinit var repository: ClienteJPARepository


    fun salvar(cliente: Cliente): Cliente {
        return repository.save(cliente)
    }

    fun obter(clienteId: Int): Cliente {

        return repository.findByIdOrNull(clienteId)  ?: throw ClienteNaoEncontradoException()
    }

    fun excluir(clienteId: Int) {
        repository.delete(obter(clienteId))
    }

    fun alterar(cliente: Cliente): Cliente {

        return cliente
    }

    fun listar(): List<Cliente> = repository.findAll()
}
