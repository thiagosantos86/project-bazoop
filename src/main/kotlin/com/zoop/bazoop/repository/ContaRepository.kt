package com.zoop.bazoop.repository

import com.zoop.bazoop.business.ContaDigital
import com.zoop.bazoop.domain.service.ContaException
//import model.Cpf
import org.springframework.stereotype.Repository

@Repository
class ContaRepository {
    private val database: MutableList<ContaDigital> = ArrayList()

    fun salvar(contaDigital: ContaDigital): ContaDigital {
        // TODO: Buscar se já existe conta com o mesmo id.
        // Se existir, sobrescrever com a conta informada.
        // Se não existir, adicionar
        database.add(contaDigital)
        return contaDigital
    }

    fun obter(contaId: Int): ContaDigital? {
        for (contadigital in database) {
            if (contadigital.id == contaId)
                return contadigital
        }

        return null
    }

    fun listar(): MutableList<ContaDigital> = database

    fun excluir(contaId: Int) {

        if (!database.removeIf { it.id == contaId }) {
            throw ContaException()
        }
    }

    fun alterar(contaDigital: ContaDigital?): ContaDigital? {

        return contaDigital
    }
}


