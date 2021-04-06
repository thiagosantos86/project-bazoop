package com.zoop.bazoop.repository

import com.zoop.bazoop.business.Cliente
import org.springframework.data.jpa.repository.JpaRepository

interface ClienteJPARepository : JpaRepository<Cliente,Int> {
}
