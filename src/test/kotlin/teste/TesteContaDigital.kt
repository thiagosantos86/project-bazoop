package teste

import com.zoop.bazoop.business.Contadigital
import com.zoop.bazoop.domain.service.Extratomovimentacao
import com.zoop.bazoop.domain.service.operacaoServiceImpl
import com.zoop.bazoop.impl.ContaRepository
import model.Cliente
import model.Cpf
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.random.Random

class TesteContaDigital {


    @Test
    fun `teste validar cpf`() {
        var cliente = criarCliente()
        var result = cliente.cpfIsValid(cliente.cpf)
        assert(result)

    }

    @Test
    fun `teste cpf invalido`() {
        var cpfInvalido =  Cpf("1234567891")
        var cliente = criarCliente()
        var result = cliente.cpfIsValid(cpfInvalido)
        assert(!result)

    }

    @Test
    fun `teste consultar extrato`() {
        var conta = Contadigital(criarCliente())
        conta.Consultarextrato()


    }

    @Test
    fun `teste debito valido`() {
        var debitar  = Extratomovimentacao(criarCliente())
        debitar.Debito(250)
    }


    @Test
    fun `teste debito invalido`() {
        var debitar  = Extratomovimentacao(criarCliente())
        debitar.Debito(1001)

    }
    @Test
    fun `teste credito invalido`() {
        var creditar  = Extratomovimentacao(criarCliente())
        creditar.Credito(1001)

    }
    @Test
    fun `teste credito valido`() {
        var creditar  = operacaoServiceImpl(ContaRepository())
        creditar.credito(Contadigital(criarCliente()),2000)
    }
    @Test
    fun `teste transferencia valido`() {
        var tranferir  = operacaoServiceImpl(ContaRepository())
        tranferir.transferencia(Contadigital(criarCliente()), Contadigital(criarCliente()),200)
    }
    @Test
    fun `teste criarCliente`() {
        var criarcliente = criarCliente()

    }
    @Test
    fun `teste criarConta`() {
        var criarconta = criarConta()

    }
    @Test
    fun `teste fecharConta`() {

        var fechar = Contadigital(criarCliente()).fecharConta()

    }
    private fun criarCliente(): Cliente {
        var cpf  = Cpf("12345678910")
        var dataNasc : LocalDate = LocalDate.of(2018,2,2)
        var nome : String = "Thiago Azevedo"
        var cliente = Cliente(nome, cpf, dataNasc)
        var id = cliente.id
        var conta = ContaRepository()
        var NumConta :Int = java.util.Random().nextInt(1000) + 1
        println("${cliente.nome} ${cliente.cpf. value} ${cliente.data} o id e $id e conta ${NumConta}")
        return cliente
    }
    private fun criarConta(): ContaRepository {
        var cliente: Cliente
        var saldo: Long = 0
        var id: Long = Random.nextLong(100000000)
        var Numconta: Int = java.util.Random().nextInt(1000) + 1
        var conta =ContaRepository()
        println("""seu saldo ${saldo}  seu id $id seu numConta $Numconta""")
        return conta
    }
}