package com.zoop.bazoop.domain.service

import com.zoop.bazoop.business.Contadigital

interface operacaoService {
    fun credito(contadigital: Contadigital, valor: Int): Contadigital
    fun debito(contadigital: Contadigital, valor: Int): Contadigital
    fun transferencia(contaDebitada: Contadigital, contaCreditada: Contadigital, valor: Int): Contadigital
}