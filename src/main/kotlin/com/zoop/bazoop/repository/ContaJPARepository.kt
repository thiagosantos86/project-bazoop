package com.zoop.bazoop.repository

import com.zoop.bazoop.business.Cliente
import com.zoop.bazoop.business.ContaDigital
import org.springframework.data.jpa.repository.JpaRepository

interface ContaJPARepository : JpaRepository<ContaDigital, Int> {
}