/**@IFPB
 * @author Alan Giovanni | Suelando Alves | William Soares
 * @version 1.0
 * @since 03 December 2017
 * @CommentLanguage Pt-Br
 * 
 * Este é uma classe que representa um Cliente
 */
package sistemaDeVendas.classes;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Clientes")
public class Clientes implements Serializable{
	
	private String nome;
	private String cpf;
	private String endereco;
	private String cep;
	private String bairro;
	private String uf;
	private String telefone;
	
	private static final long serialVersionUID = 1L;
	
	public Clientes(String nomeCliente, String cpfCliente){
		this.nome = nomeCliente;
		this.cpf = cpfCliente;
	}
	
	public Clientes(String nome, String cpf, String endereco, String cep, String bairro, String uf, String telefone){
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cep = cep;
		this.bairro = bairro;
		this.uf = uf;
		this.telefone = telefone;
	}

		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		return "\nClientes: \nnome=" + nome + "\ncpf=" + cpf + "\nendereco=" + endereco
				+ "\ncep=" + cep + "\nbairro=" + bairro + "\nuf=" + uf + "\ntelefone=" + telefone + "\n\n";
	}

}
