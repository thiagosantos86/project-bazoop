package com.zoop.bazoop.application.controller

import com.zoop.bazoop.application.facade.ContaFacade
import com.zoop.bazoop.application.model.ContaTO
import com.zoop.bazoop.application.model.ContaTOResponse
import com.zoop.bazoop.application.model.MessageTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bazoop/clientes/{clienteId}/contas", produces = [MediaType.APPLICATION_JSON_VALUE])
class ContaController {
    @Autowired
    lateinit var contaFacade: ContaFacade

    //Todo criar um controlor de contas sempre vou precisar do do indentificardor do cliente

    @PostMapping
    fun criarConta(@PathVariable clienteId: Int, @RequestBody contadigital: ContaTO): ResponseEntity<ContaTOResponse> {
        return ResponseEntity.ok(contaFacade.criarConta(clienteId, contadigital))
    }

    @GetMapping("/{contaId}")
    fun obterConta(@PathVariable contaId: Int): ResponseEntity<ContaTOResponse?>? {
        return contaFacade.obterConta(contaId)?.let { ResponseEntity.ok(it) }
    }

    @DeleteMapping("/{contaId}")
    fun deletar(@PathVariable contaId: Int): ResponseEntity<MessageTO> {
        contaFacade.deletar(contaId)
        return ResponseEntity.ok(MessageTO("Conta excluida com sucesso!!"))
    }

    //put altera
    @PutMapping("/{contaId}")
    fun alterarConta(
        @PathVariable contaId: Int,
        @RequestBody contadigital: ContaTO
    ): ResponseEntity<ContaTOResponse?>? {

        return this.contaFacade.alterarConta(contaId, contadigital)?.let { ResponseEntity.ok(it) }
    }

    @GetMapping
    fun listarContas(): ResponseEntity<List<ContaTOResponse>> {
        return ResponseEntity.ok(contaFacade.obterTodosContas())
    }
}
