package com.zoop.bazoop.domain.service

import com.zoop.bazoop.business.ContaDigital
import com.zoop.bazoop.business.Cliente

interface ContaService {
    fun criarConta(cliente: Cliente):ContaDigital
}
