package com.zoop.bazoop.business

import java.util.Random
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name="conta_digital")
class ContaDigital(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id", referencedColumnName = "id")
    val cliente: Cliente,
    @Id
    val id: Int = Random().nextInt(100000000),
    val numConta: Int = Random().nextInt(1000) + 1,
    @field:Enumerated(EnumType.STRING)
    var status: Status = Status.ABERTA,
    @field:Enumerated(EnumType.STRING)
    var tipo: Tipo = Tipo.CONTACOMUM,
    var saldo: Double = 1000.0
) {

    enum class Status {
        ABERTA, FECHADA
    }

    fun fecharConta() {
        var status: Status = Status.FECHADA
        print("\nsua conta de numero : ${numConta} conta foi fechada ")
    }

    fun consultarExtrato() {
        print("\no numero da sua conta e : $numConta ela esta $status e do tipo $tipo  seu saldo e $saldo \n")
    }
}

enum class Tipo {
    CONTACOMUM, CONTAVIP
}


