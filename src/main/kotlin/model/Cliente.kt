package model
import com.zoop.bazoop.business.ContaDigital
import com.zoop.bazoop.domain.service.ContaException
//import org.graalvm.compiler.debug.TTY.print
//import org.graalvm.compiler.debug.TTY.println
import java.time.LocalDate
import java.util.Random

 class Cliente(
     var nome: String="A",
     var cpf : Cpf = Cpf("12345678910"),
     var data : LocalDate = LocalDate.of(2018,2,2),
     var id: Int = Random().nextInt(100000000),
     val contas: MutableList<ContaDigital> = mutableListOf()

 ) {

     fun cpfIsValid(cpf: Cpf): Boolean {

         var result = false

         if (cpf.value.length == 11) {

             println("\n Cliente com cpf valido \n")
             result = true
         } else {
             println("\n Cliente com cpf invalido \n")
         }
         return result
     }
// lista de contas generikis

     fun criarConta():ContaDigital{
         if(contas.size < 3 ){
           return ContaDigital(this).also { contas.add(it) }
         }
         // mandar um exeçao de negocio
         // tratar controler,serviço,to
          throw ContaException()
     }
//execluir conta aqui

     // private fun validateCPFLength(cpf: String) = cpf.length == 11

         fun imprimirInfo() {
             print("o nome $nome e cpf ${cpf.value} e a data de nasc ${data}")
         }

         class Cpf(var value: String)
     }

