package com.zoop.bazoop.infra

import com.zoop.bazoop.domain.ClienteNaoEncontradoException
import com.zoop.bazoop.domain.service.AccountCreationLimitExceededException
import com.zoop.bazoop.domain.service.ContaException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerAdvice {
    @ExceptionHandler(ClienteNaoEncontradoException::class)
    fun tratarRecursoNaoEncontrado(exception: ClienteNaoEncontradoException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.message)
    }

    @ExceptionHandler(ContaException::class)
    fun tratarRecursoNaoEncontradoConta(exception: ContaException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.message)
    }
    @ExceptionHandler(AccountCreationLimitExceededException::class)
    fun tratarCondicaoNaoEncontradoConta(exception: AccountCreationLimitExceededException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(exception.message)
    }

}