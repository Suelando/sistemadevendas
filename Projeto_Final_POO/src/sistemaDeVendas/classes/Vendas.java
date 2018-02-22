/**@IFPB
 * @author Alan Giovanni | Suelando Alves | William Soares
 * @version 1.0
 * @since 03 December 2017
 * @CommentLanguage Pt-Br
 */
package sistemaDeVendas.classes;
import java.io.Serializable;
import java.util.Date;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Venda")
public class Vendas implements Serializable{

	private int idVenda;
	private int idProduto;
	private int qtdeProdutosComprados;
	private String nomeCliente;
	private String cpfCliente;
	private String metodoPagamento;
	Date dataDaVendaNaoFormatada;
	private double valorDaCompra;
	
	private static final long serialVersionUID = 1L;
	
	public Vendas (int idVenda, int idProduto, int qtdeProdutosComprados, String nomeCliente, String cpfCliente, String metodoPagamento, double valorDaCompra){
		
		this.idVenda = idVenda;
		this.idProduto = idProduto;
		this.qtdeProdutosComprados = qtdeProdutosComprados;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.metodoPagamento = metodoPagamento;
		
		dataDaVendaNaoFormatada = new Date(System.currentTimeMillis()); //Pego a data atual do Sistema		
		this.valorDaCompra = valorDaCompra;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public int getQtdeProdutosComprados() {
		return qtdeProdutosComprados;
	}

	public void setQtdeProdutosComprados(int qtdeProdutosComprados) {
		this.qtdeProdutosComprados = qtdeProdutosComprados;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public double getValorDaCompra() {
		return valorDaCompra;
	}

	public void setValorDaCompra(double valorDaCompra) {
		this.valorDaCompra = valorDaCompra;
	}

	@Override
	public String toString() {
		return "Vendas \nidVenda=" + idVenda + "\nidProduto=" + idProduto + "\nQuantidade de Produtos Comprados: " + qtdeProdutosComprados + "\nNome do Cliente=" + nomeCliente + "\nCpf do Cliente: " + cpfCliente + "\nvalorDaCompra=" + valorDaCompra + "\nData da Venda: " + dataDaVendaNaoFormatada + "\nMétodo de Pagamento: " + metodoPagamento + "\n\n";
	}
	
	
}
