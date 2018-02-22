/**@IFPB
 * @author Alan Giovanni | Suelando Alves | William Soares
 * @version 1.0
 * @since 03 December 2017
 * @CommentLanguage Pt-Br
 * 
 * Esta coleção representa um ARRAY de clientes
 */
package sistemaDeVendas.collections;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import sistemaDeVendas.classes.*;

public class ColClientes implements Serializable{
	private ArrayList<Clientes> colClientes = new ArrayList<Clientes>();
	private static final long serialVersionUID = 1L;
	
	public ColClientes(){
		
	}
	
	public void adicionaClienteNaLista(Clientes cliente){
		colClientes.add(cliente);
	}
	
	public void removeClienteDaLista(Clientes cliente){
		colClientes.remove(cliente);
	}
	
	public String pesquisarClienteDaLista(String cpfCliente){
		for(Clientes c: colClientes) {
			if(c.getCpf().equals(cpfCliente)) {
				return c.toString();
			}	
		}
		return null;
	}
	
	public String retornarNomeCliente(String cpfCliente){
		for(Clientes c: colClientes) {
			if(c.getCpf().equals(cpfCliente)) {
				return c.getNome();
			}
		}
		return null;
	}
	
	public Clientes retornaCliente (String cpf){
		for(Clientes c: colClientes) {
			if(c.getCpf().equals(cpf)) {
				return c;
			}	
		}
		return null;
	}
	
	public void alteraClienteNaLista(String cpfPesquisado, String nome, String cpf, String endereco, String cep, String bairro, String uf, String telefone){
		Clientes cliente = retornaCliente(cpfPesquisado);
		cliente.setBairro(bairro);
		cliente.setCep(cep);
		cliente.setCpf(cpf);
		cliente.setEndereco(endereco);
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		cliente.setUf(uf);
	}
	
	public void salvaEmXML(String localArmazenamento){
		XStream xStream = new XStream(new StaxDriver());
        File arquivo = new File(localArmazenamento);
        xStream.alias("Cliente", Clientes.class);
        FileOutputStream gravar;
        try {
            gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(colClientes).getBytes());
            gravar.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
		
	}
	
	public void lerDoXML(String localArmazenamento){
		try {
			XStream xStream = new XStream(new StaxDriver());
			//Questões de segurança
			XStream.setupDefaultSecurity(xStream);
			xStream.addPermission(AnyTypePermission.ANY); 
			xStream.alias("Cliente", Clientes.class);
			xStream.processAnnotations(Clientes.class);
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(localArmazenamento));
			ArrayList<Clientes> lista = (ArrayList<Clientes>) xStream.fromXML(input);
			input.close();
			
			this.colClientes = lista;
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "ColClientes [colClientes=" + colClientes + "]";
	}

	
}
