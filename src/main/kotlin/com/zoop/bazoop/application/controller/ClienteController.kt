package com.zoop.bazoop.application.controller

import com.zoop.bazoop.application.facade.ClienteFacade
import com.zoop.bazoop.application.model.ClienteTO
import com.zoop.bazoop.application.model.ClienteTOResponse
import com.zoop.bazoop.business.Contadigital
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping( "/bazoop",produces = [MediaType.APPLICATION_JSON_VALUE])
class ClienteController  {
    @Autowired
    lateinit var facade: ClienteFacade
// refatora

@PostMapping("/criarcliente")
    fun criarCliente(@RequestBody cliente: ClienteTO):ResponseEntity<ClienteTOResponse> {
    var clint = facade.criarCliente(cliente)
    return ResponseEntity.ok(facade.criarCliente(cliente))
}
@PostMapping("/criarconta")
    fun criarconta(@RequestBody contadigital: Contadigital):ResponseEntity<Contadigital>{
    var conta = facade.criarconta(contadigital)
    return ResponseEntity.ok(facade.criarconta(contadigital))
    }

@DeleteMapping("/deletarcliente")
    fun deletar(cliente: ClienteTO): ResponseEntity<Unit> {
    var delet =facade.deletar(cliente)
    return ResponseEntity.ok(facade.deletar(cliente))
    }
//put alterar
@PutMapping("/alterarcliente")
    fun alterarcliente(cliente : ClienteTO): ResponseEntity<ClienteTOResponse> {
    var alterar =facade.alterarCliente(cliente)
    return ResponseEntity.ok(facade.alterarCliente(cliente))
    }
@GetMapping("/clientes")
    fun listarClientes(): ResponseEntity<List<ClienteTO>>
    {
        return ResponseEntity.ok(facade.obterTodosClientes())
    }
}






// infra estrutura do jsom