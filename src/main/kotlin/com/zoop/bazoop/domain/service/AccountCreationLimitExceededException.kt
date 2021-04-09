package com.zoop.bazoop.domain.service

class AccountCreationLimitExceededException : Exception("Voce possui mais de 3 contas não pode abrir outra") {
}