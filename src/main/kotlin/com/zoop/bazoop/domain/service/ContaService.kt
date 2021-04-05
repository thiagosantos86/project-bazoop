package com.zoop.bazoop.domain.service

import com.zoop.bazoop.business.ContaDigital
import model.Cliente

interface ContaService {
    fun criarConta(cliente: Cliente):ContaDigital
}