package com.zoop.bazoop.business

import com.zoop.bazoop.domain.service.ContaException
import java.time.LocalDate
import java.util.Random
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "cliente")
class Cliente(
    var nome: String = "A",
    @field:Embedded  var cpf: Cpf = Cpf("05794654708"),
    var data: LocalDate = LocalDate.of(1986,9,11),
    @Id
    val id: Int = Random().nextInt(100000000),
    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "cliente", fetch = FetchType.EAGER)
    val contas: MutableList<ContaDigital> = mutableListOf()

) {

    fun cpfIsValid(cpf: Cpf): Boolean {

        var result = false

        if (cpf.value.length == 11) {

            println("\n Cliente com cpf valido \n")
            result = true
        } else {
            println("\n Cliente com cpf invalido \n")
        }
        return result
    }
// lista de contas generikis

    fun criarConta(): ContaDigital {
        if (contas.size < 3) {
            return ContaDigital(this).also { contas.add(it) }
        }
        // mandar um exeçao de negocio
        // tratar controler,serviço,to
        throw ContaException()
    }
//execluir conta aqui

    fun deletarConta(): ContaDigital {
        if (contas == contas) {
            return ContaDigital(this).also { contas.remove(it) }
        }

        throw ContaException()
    }

    // private fun validateCPFLength(cpf: String) = cpf.length == 11

    fun imprimirInfo() {
        print("o nome $nome e cpf ${cpf.value} e a data de nasc ${data}")
    }

    @Embeddable
    class Cpf(@Column(name = "cpf") var value: String = "057.946.547-08")
}

