package com.zoop.bazoop.domain.service

import com.zoop.bazoop.business.Contadigital
import model.Cliente

interface ContaService {
    fun criarConta(cliente: Cliente):Contadigital
}