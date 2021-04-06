package com.zoop.bazoop.repository

import model.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteJPARepository : JpaRepository<Cliente,Int> {
}