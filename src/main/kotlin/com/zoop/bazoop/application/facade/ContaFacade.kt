package com.zoop.bazoop.application.facade

import com.zoop.bazoop.application.model.ContaTO
import com.zoop.bazoop.application.model.ContaTOResponse
import com.zoop.bazoop.repository.ClienteRepository
import com.zoop.bazoop.repository.ContaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ContaFacade {
    @Autowired
    lateinit var contaRepository: ContaRepository

    @Autowired
    lateinit var repository: ClienteRepository
    fun obterTodosContas(): List<ContaTOResponse> {

        return contaRepository.listar().map { ContaTOResponse.fromConta(it) }
    }

    fun criarConta(id: Int, request: ContaTO): ContaTOResponse {
        val cliente = repository.obter(id)
        repository.salvar(cliente)
        val conta = cliente.criarConta()
        contaRepository.salvar(conta)
        return ContaTOResponse.fromConta(conta)
    }

    fun obterConta(contaId: Int): ContaTOResponse? {
        return contaRepository.obter(contaId)?.let {
            ContaTOResponse.fromConta(
                it
            )
        }
    }

    fun deletar(id: Int) {
        contaRepository.excluir(id)
    }

    fun alterarConta(id: Int, request: ContaTO): ContaTOResponse? {
        val conta = contaRepository.obter(id)
        if (conta != null) {
            request.alterar(conta)
        }
        contaRepository.alterar(conta)

        return conta?.let { ContaTOResponse.fromConta(it) }
    }
}