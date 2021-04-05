package com.zoop.bazoop.domain.service

import com.zoop.bazoop.business.ContaDigital

interface OperacaoService {
    fun credito(contaDigital: ContaDigital, valor: Int): ContaDigital
    fun debito(contaDigital: ContaDigital, valor: Int): ContaDigital
    fun transferencia(contaDebitada: ContaDigital, contaCreditada: ContaDigital, valor: Int): ContaDigital
}