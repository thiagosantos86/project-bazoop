package com.zoop.bazoop.domain.service

import com.zoop.bazoop.business.Cliente

interface ClienteService {
    fun criar(cliente: Cliente): Cliente
    fun remover(cliente: Cliente)
    fun listar(): List<Cliente>
}
