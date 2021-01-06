package com.zoop.bazoop.domain.service

import com.zoop.bazoop.business.Contadigital
import com.zoop.bazoop.impl.ContaRepository
import model.Cliente
import org.springframework.stereotype.Service

@Service
class ContaServiceImpl (
    private val repository: ContaRepository
) : ContaService {
    override fun criarConta(cliente: Cliente): Contadigital {
        return repository.salvar(Contadigital(cliente))
    }
}