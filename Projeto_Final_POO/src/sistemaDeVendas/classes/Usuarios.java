/**@IFPB
 * @author Alan Giovanni | Suelando Alves | William Soares
 * @version 1.0
 * @since 03 December 2017
 * @CommentLanguage Pt-Br
 */

package sistemaDeVendas.classes;

import java.io.Serializable;

public class Usuarios implements Serializable{
	
	private String nome;
	private String login;
	private String senha;
	
	private static final long serialVersionUID = 1L;
	
	public Usuarios(String nome, String login, String senha){
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuarios \nnome=" + nome + "\nlogin=" + login + "\nsenha=" + senha + "\n\n";
	}
	

}
