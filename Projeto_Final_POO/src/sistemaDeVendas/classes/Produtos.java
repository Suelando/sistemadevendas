/**@IFPB
 * @author Alan Giovanni | Suelando Alves | William Soares
 * @version 1.0
 * @since 03 December 2017
 * @CommentLanguage Pt-Br
 */
package sistemaDeVendas.classes;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Produtos")
public class Produtos implements Serializable{
	
	private int idProduto;
	private String nome;
	private double valor;
	private int quantidade;
	
	private static final long serialVersionUID = 1L;
	
	public Produtos(int idProduto, String nome, double valor, int quantidade){
		this.idProduto = idProduto;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void reduzQuantidade (int quantidade){
		this.quantidade = this.quantidade - quantidade;
	}

	@Override
	public String toString() {
		return "Produtos: \nCódigo do Produto=" + idProduto + "\nNome=" + nome + "\nValor= R$" + valor + "\nQuantidade no estoque=" + quantidade
				+ "\n\n";
	}
	
	
}
