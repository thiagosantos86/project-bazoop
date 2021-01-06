package com.zoop.bazoop.domain.service

import model.Cliente

interface ClienteService {
    fun criar(cliente: Cliente):Cliente
    fun remover(cliente: Cliente)
    fun listar(): List<Cliente>
}