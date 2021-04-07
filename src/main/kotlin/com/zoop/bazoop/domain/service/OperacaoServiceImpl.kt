package com.zoop.bazoop.domain.service

import com.zoop.bazoop.business.ContaDigital
import com.zoop.bazoop.repository.ContaRepository
import org.springframework.stereotype.Service

@Service
class OperacaoServiceImpl(
    private val repository: ContaRepository
) : OperacaoService {
    override fun credito(contaDigital: ContaDigital, valor: Int): ContaDigital {
        contaDigital.saldo = contaDigital.saldo + valor
        print("\n agora vc tem ${contaDigital.saldo} de credito \n")
        return repository.salvar(contaDigital)
    }

    override fun debito(contaDigital: ContaDigital, valor: Int): ContaDigital {
        if (contaDigital.saldo >= valor) {
            contaDigital.saldo = contaDigital.saldo - valor
            print("\n vc teve um debito de ${valor} e seu saldo e ${contaDigital.saldo} \n")
        } else
            print("vc não tem saldo suficiente")
        return repository.salvar(contaDigital)
    }

    override fun transferencia(contaDebitada: ContaDigital, contaCreditada: ContaDigital, valor: Int): ContaDigital {

        debito(contaDebitada, valor)
        credito(contaCreditada, valor)
        return contaDebitada
    }
}
