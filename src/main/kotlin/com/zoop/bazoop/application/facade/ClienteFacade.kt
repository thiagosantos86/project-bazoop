package com.zoop.bazoop.application.facade

import com.zoop.bazoop.application.model.ClienteTO
import com.zoop.bazoop.application.model.ClienteTOResponse
import com.zoop.bazoop.repository.ClienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ClienteFacade {
    @Autowired
    lateinit var repository: ClienteRepository
    fun obterTodosClientes(): List<ClienteTOResponse> {

        return repository.listar().map { ClienteTOResponse.fromCliente(it) }
    }

    fun criarCliente(request: ClienteTO): ClienteTOResponse {
        val cliente = request.toDomain()
        repository.salvar(cliente)

        return ClienteTOResponse.fromCliente(cliente)
    }

    fun obterCliente(clienteId: Int): ClienteTOResponse {
        return ClienteTOResponse.fromCliente(
            repository.obter(clienteId)
        )
    }

    fun deletar(id: Int) {
        repository.excluir(id)
    }

    fun alterarCliente(id: Int, request: ClienteTO): ClienteTOResponse {
        val cliente = repository.obter(id)
        request.alterar(cliente)
        repository.alterar(cliente)

        return ClienteTOResponse.fromCliente(cliente)
    }

    //  traduçao de cliente para  cliente response
}