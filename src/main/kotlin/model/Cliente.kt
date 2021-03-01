package model
import com.zoop.bazoop.business.Contadigital
import com.zoop.bazoop.domain.ClienteNaoEncontradoException
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
     val contas: MutableList<Contadigital> = mutableListOf()

 ) {

     fun cpfIsValid(cpf: Cpf): Boolean {

         var result = false

         if (cpf.value.length == 11) {

             print("Cliente com cpf valido")
             result = true
         } else {
             println("Cliente com cpf invalido")
         }
         return result
     }
// lista de contas generikis

     fun criarConta():Contadigital{
         if(contas.size < 3 ){
           return Contadigital(this).also { contas.add(it) }
         }
         // mandar um exeçao de negocio
         // tratar controler,serviço,to
         return  throw ContaException()
     }


     // private fun validateCPFLength(cpf: String) = cpf.length == 11

         fun imprimirInfo() {
             print("o nome $nome e cpf ${cpf.value} e a data de nasc ${data}")
         }

         class Cpf(var value: String)
     }

