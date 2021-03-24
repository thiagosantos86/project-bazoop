package com.zoop.bazoop.domain.service

import com.zoop.bazoop.business.Contadigital
import com.zoop.bazoop.impl.ContaRepository
import org.springframework.stereotype.Service

@Service
class operacaoServiceImpl(
    private val repository: ContaRepository
) : operacaoService {
    override fun credito(contadigital: Contadigital, valor: Int): Contadigital {
        contadigital.Saldo = contadigital.Saldo + valor
        print("\n agora vc tem ${contadigital.Saldo} de credito \n")
        return repository.salvar(contadigital)
    }

    override fun debito(contadigital: Contadigital, valor: Int): Contadigital {
        contadigital.Saldo = contadigital.Saldo - valor
        print("\n vc teve um debito de ${contadigital.debito} \n")
        return repository.salvar(contadigital)
    }

    override fun transferencia(contaDebitada: Contadigital, contaCreditada: Contadigital, valor: Int): Contadigital {

        contaDebitada.Saldo = contaDebitada.Saldo - valor
        print("\n vc teve um debito de $valor e seu saldo e ${contaDebitada.Saldo}\n")
        contaCreditada.Saldo = contaCreditada.Saldo + valor
        println("\n vc teve um credito de $valor e seu saldo e ${contaCreditada.Saldo} \n")
        repository.salvar(contaCreditada)
        return repository.salvar(contaDebitada)
    }
}
