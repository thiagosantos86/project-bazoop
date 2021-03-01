package com.zoop.bazoop.impl

import com.zoop.bazoop.business.Contadigital
import com.zoop.bazoop.domain.ClienteNaoEncontradoException
//import model.Cpf
import org.springframework.stereotype.Repository
import java.time.LocalDate
import kotlin.random.Random

@Repository
class ContaRepository {
    private val database: MutableList<Contadigital> = ArrayList()

    fun salvar(contadigital: Contadigital): Contadigital {
        // TODO: Buscar se já existe conta com o mesmo id.
        // Se existir, sobrescrever com a conta informada.
        // Se não existir, adicionar
        database.add(contadigital)
        return contadigital
    }

    fun obter(contaId: Int): Contadigital? {
        for (contadigital in database) {
            if (contadigital.id == contaId)
                return contadigital
        }

        return null
    }

    fun listar(): MutableList<Contadigital> = database

    fun excluir(contaId: Int) {

        if(!database.removeIf { it.id == contaId })  {throw ClienteNaoEncontradoException()
        }
    }

    fun alterar(contadigital: Contadigital?): Contadigital? {

        return contadigital
    }
}




data class Cliente(
    val nome: String,
    val cpf: String,
    val nascimento: LocalDate,
    val id: Long = Random.nextLong(100000000)
) {
    fun cpfIsValid(cpf: model.Cliente.Cpf): Boolean {

        var result = false

        if (cpf.value.length == 11) {

            print("Cliente com cpf valido")
            result = true
        }else{
            println("Cliente com cpf invalido")

        }
        return result


    }
    fun validarCpf(cliente: Cliente) {

        TODO("Fazer validação do CPF")
    }
}

data class contadigital(
    val cliente: Cliente,
    val saldo: Long = 0,
    val id: Long = Random.nextLong(100000000),
    val Numconta: Int = java.util.Random().nextInt(1000) + 1

)

