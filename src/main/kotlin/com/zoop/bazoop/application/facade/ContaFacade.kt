package com.zoop.bazoop.application.facade

import com.zoop.bazoop.application.model.ContaTO
import com.zoop.bazoop.application.model.ContaTOResponse
import com.zoop.bazoop.impl.ClienteRepository
import com.zoop.bazoop.impl.ContaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ContaFacade {
    @Autowired
    lateinit var contarepository: ContaRepository

    @Autowired
    lateinit var repository: ClienteRepository
    fun obterTodosContas(): List<ContaTOResponse> {

        return contarepository.listar().map { ContaTOResponse.fromConta(it) }
    }

    fun criarconta(id: Int, request: ContaTO): ContaTOResponse {
        val cliente = repository.obter(id)
        repository.salvar(cliente)
        val conta = cliente.criarConta()
        contarepository.salvar(conta)
        return ContaTOResponse.fromConta(conta)
    }

    fun obterConta(contaId: Int): ContaTOResponse? {
        return contarepository.obter(contaId)?.let {
            ContaTOResponse.fromConta(
                it
            )
        }
    }

    fun deletar(id: Int) {
        contarepository.excluir(id)
    }

    fun alterarConta(id: Int, request: ContaTO): ContaTOResponse? {
        val conta = contarepository.obter(id)
        if (conta != null) {
            request.alterar(conta)
        }
        contarepository.alterar(conta)

        return conta?.let { ContaTOResponse.fromConta(it) }
    }
}