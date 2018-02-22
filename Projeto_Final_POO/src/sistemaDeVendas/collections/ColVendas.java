/**@IFPB
 * @author Alan Giovanni | Suelando Alves | William Soares
 * @version 1.0
 * @since 03 December 2017
 * @CommentLanguage Pt-Br
 * 
 * Esta cole��o representa um ARRAY de Vendas
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
import sistemaDeVendas.collections.*;

public class ColVendas implements Serializable{
	private ArrayList<Vendas> colVendas = new ArrayList<Vendas>();
	
	private static final long serialVersionUID = 1L;
	
	public ColVendas(){
		
	}
	
	public void adicionaVendaNaLista(Vendas venda) throws Exception{
		try{
			//tenta adicionar a venda a cole��o
			colVendas.add(venda);
			} catch (Exception ex){
			//caso o usuario tenha digitado um caractere inv�lido, uma exception ser� lan�ada
			throw new Exception("ERRO AO ADICIONAR ESTA VENDA A COLE��O"); //N�o quero tratar esse erro aqui, quero que o c�digo que chame esse m�todo se vire com isso
			}
	}
	public int tamanhoDaLista(){
		int tamanho = 0;
		for(Vendas listaDeVendas: colVendas) {
			tamanho ++;
		}
		return tamanho;
	}
	
	public void salvaEmXML(String localArmazenamento){
		XStream xStream = new XStream(new StaxDriver());
        File arquivo = new File(localArmazenamento);
        xStream.alias("Venda", Vendas.class);
        FileOutputStream gravar;
        try {
            gravar = new FileOutputStream(arquivo);
            gravar.write(xStream.toXML(colVendas).getBytes());
            gravar.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } 
	}
	public void lerDoXML(String localArmazenamento){
		try {
			XStream xStream = new XStream(new StaxDriver());
			//Quest�es de seguran�a
			XStream.setupDefaultSecurity(xStream);
			xStream.addPermission(AnyTypePermission.ANY); 
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(localArmazenamento));
			xStream.alias("Venda", Vendas.class);
			xStream.processAnnotations(Vendas.class);
			ArrayList<Vendas> lista = (ArrayList<Vendas>) xStream.fromXML(input);
			input.close();
			
			this.colVendas = lista;
			
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Vendas Realizadas\n" + colVendas;
	}

}
