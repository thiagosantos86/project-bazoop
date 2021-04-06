package com.zoop.bazoop.domain.service

import com.zoop.bazoop.business.ContaDigital
import com.zoop.bazoop.repository.ContaRepository
import com.zoop.bazoop.business.Cliente
import org.springframework.stereotype.Service

@Service
class ContaServiceImpl (
    private val repository: ContaRepository
) : ContaService {
    override fun criarConta(cliente: Cliente): ContaDigital {
        return repository.salvar(ContaDigital(cliente = cliente))
    }
}
