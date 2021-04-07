package teste

import com.zoop.bazoop.business.ContaDigital
import com.zoop.bazoop.domain.service.OperacaoServiceImpl
import com.zoop.bazoop.repository.ContaRepository
import com.zoop.bazoop.business.Cliente
//import model.Cpf
import org.junit.jupiter.api.Test
import java.time.LocalDate
import kotlin.random.Random

class TesteContaDigital {

    @Test
    fun `teste validar cpf`() {
        var cliente = Cliente()
        var result = cliente.cpfIsValid(cliente.cpf)
        assert(result)
    }

    @Test
    fun `teste cpf invalido`() {
        var cpfInvalido = Cliente.Cpf("1234567891")
        var cliente = Cliente()
        var result = cliente.cpfIsValid(cpfInvalido)
        assert(!result)
    }

    @Test
    fun `teste consultar extrato`() {
        var conta = ContaDigital(Cliente())
        conta.consultarExtrato()
    }

    @Test
    fun `teste credito valido`() {
        var creditar = OperacaoServiceImpl(ContaRepository())
        creditar.credito(ContaDigital(cliente = Cliente()), 2000)
    }

    @Test
    fun `teste debito valido`() {
        var debito = OperacaoServiceImpl(ContaRepository())
        debito.debito(ContaDigital(cliente = Cliente()), 200)
    }

    @Test
    fun `teste debito invalido`() {
        var debito = OperacaoServiceImpl(ContaRepository())
        debito.debito(ContaDigital(cliente = Cliente()), 2000)
    }

    @Test
    fun `teste transferencia valido`() {
        var tranferir = OperacaoServiceImpl(ContaRepository())
        tranferir.transferencia(ContaDigital(Cliente()), ContaDigital(Cliente()), 200)
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

        var fechar = ContaDigital(criarCliente()).fecharConta()
    }

    private fun criarCliente(): Cliente {
        var cpf = Cliente.Cpf("12345678910")
        var dataNasc: LocalDate = LocalDate.of(2018, 2, 2)
        var nome: String = "Thiago Azevedo"
        var cliente = Cliente(nome, cpf, dataNasc)
        var id = cliente.id
        var conta = ContaRepository()
        var NumConta: Int = java.util.Random().nextInt(1000) + 1
        println("${cliente.nome} ${cliente.cpf.value} ${cliente.data} o id e $id e conta ${NumConta}")
        return cliente
    }

    private fun criarConta(): ContaRepository {
        var cliente: Cliente
        var saldo: Long = 0
        var id: Long = Random.nextLong(100000000)
        var Numconta: Int = java.util.Random().nextInt(1000) + 1
        var conta = ContaRepository()
        println("""seu saldo ${saldo}  seu id $id seu numConta $Numconta""")
        return conta
    }
}
