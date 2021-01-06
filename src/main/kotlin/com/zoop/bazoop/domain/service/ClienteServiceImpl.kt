package com.zoop.bazoop.domain.service

import com.zoop.bazoop.impl.ClienteRepository
import model.Cliente
import org.springframework.stereotype.Service

@Service
class ClienteServiceImpl (
    private val repository: ClienteRepository
) : ClienteService {
    override fun criar(cliente: Cliente): Cliente {
        return repository.salvar(cliente)
    }

    override fun remover(cliente: Cliente) {
        repository.excluir(cliente.id)
    }

    override fun listar(): List<Cliente> {
        return repository.listar()
    }
}