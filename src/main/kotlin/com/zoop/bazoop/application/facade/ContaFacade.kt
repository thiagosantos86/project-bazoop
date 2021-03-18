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
    lateinit var repository: ClienteRepository
    fun obterTodosContas(): List<ContaTOResponse> {

        return contarepository.listar().map { ContaTOResponse.fromConta(it) }
    }

    //criar conta
    fun criarconta(id: Int): ContaTOResponse {
        //paasar id cliente como parametro
        val cliente = repository.obter(id)
        val conta = cliente.criarConta()
        /*println("""seu saldo ${saldo}  seu id $id seu numConta $Numconta""")*/
        return ContaTOResponse.fromConta(conta)
    }

    fun obterConta(contaId: Int): ContaTOResponse? {
        return contarepository.obter(contaId)?.let {
            ContaTOResponse.fromConta(
                it
            )
        }
    }

    //deletar cliente
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