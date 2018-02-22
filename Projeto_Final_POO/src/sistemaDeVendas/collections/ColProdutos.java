/**@IFPB
 * @author Alan Giovanni | Suelando Alves | William Soares
 * @version 1.0
 * @since 03 December 2017
 * @CommentLanguage Pt-Br
 * 
 * Esta coleção representa um ARRAY de Produtos
 */
package sistemaDeVendas.collections;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import sistemaDeVendas.classes.*;

public class ColProdutos implements Serializable{

	private ArrayList<Produtos> colProdutos = new ArrayList<Produtos>();
	
	private static final long serialVersionUID = 1L;
	
	public ColProdutos(){
		
	}
	
	public void adicionaProdutoNaLista(Produtos produto){
		colProdutos.add(produto);
	}
	
	public void removeProdutoDaLista(Produtos produto){
		colProdutos.remove(produto);
	}
	
	public Produtos retornaProdutoDaLista (int idProduto){
		for(Produtos p: colProdutos) {
			if(p.getIdProduto() == idProduto) {
				return p;
			}	
		}
		return null;
	}
	public void alteraProdutoDaLista (int idProduto, int quantidade, String nome, double valor){
		Produtos produto = retornaProdutoDaLista(idProduto);
		produto.setNome(nome);
		produto.setQuantidade(quantidade);
		produto.setValor(valor);
	}
	
	public void salvaEmXML(String localArmazenamento){
		XStream xStream = new XStream(new StaxDriver());
        File arquivo = new File(localArmazenamento);
        xStream.alias("Produto", Produtos.class);
        FileOutputStream gravar;
        try {
            gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(colProdutos).getBytes());
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
			xStream.alias("Produto", Produtos.class);
			xStream.processAnnotations(Produtos.class);
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(localArmazenamento));
			ArrayList<Produtos> lista = (ArrayList<Produtos>) xStream.fromXML(input);
			input.close();
			
			this.colProdutos = lista;
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "ColProdutos [colProdutos=" + colProdutos + "]";
	}
	
	
}
