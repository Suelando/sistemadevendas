package servidor;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import sistemaDeVendas.collections.*;

public class serverSocket {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		//SOCKET DO SERVIDOR
		ServerSocket socketServidor = new ServerSocket(5555);
		
		//1.1 ------------- COLCLIENTES ---------------------
		System.out.println("Aguardando Conexão ...");
		Socket conexaoServidor = socketServidor.accept();
		
		//1.2 SERIALIZANDO
		byte[] clientesEmByte = new byte[conexaoServidor.getReceiveBufferSize()];
		BufferedInputStream bf = new BufferedInputStream(conexaoServidor.getInputStream());
		bf.read(clientesEmByte);
		
		//1.3 RECEBENDO O CONTEÚDO E COLOCANDO NA VARIAVEL DE BACKUP
		ColClientes backupClientes = (ColClientes) getObject(clientesEmByte);
		
		//1.4 Fechando o socket
		conexaoServidor.close();
		
		//2.1 ------------ COLPRODUTOS ---------------------
		Socket conexaoServidor2 = socketServidor.accept();
		
		//2.2 SERIALIZANDO
		byte[] produtosEmByte = new byte[conexaoServidor2.getReceiveBufferSize()];
		BufferedInputStream bf2 = new BufferedInputStream(conexaoServidor2.getInputStream());
		bf2.read(produtosEmByte);
		
		//2.3 RECEBENDO O CONTEÚDO E COLOCANDO NA VARIAVEL DE BACKUP
		ColProdutos backupProdutos = (ColProdutos) getObject(produtosEmByte);
		
		//2.4 Fechando o socket
		conexaoServidor2.close();
		
		
		//3.1 ----------- COLVENDAS ------------------------------
		Socket conexaoServidor3 = socketServidor.accept();
		
		//3.2 SERIALIZANDO
		byte[] vendasEmByte = new byte[conexaoServidor3.getReceiveBufferSize()];
		BufferedInputStream bf3 = new BufferedInputStream(conexaoServidor3.getInputStream());
		bf3.read(vendasEmByte);
		
		//3.3 RECEBENDO O CONTEÚDO E COLOCANDO NA VARIAVEL DE BACKUP
		ColVendas backupVendas = (ColVendas) getObject(vendasEmByte);
		

		//FECHANDO OS SOCKETS
		socketServidor.close();
		conexaoServidor3.close();
		
		backupClientes.salvaEmXML("backupDoArmazenamento/ColClientesBKP.xml");
		backupProdutos.salvaEmXML("backupDoArmazenamento/ColProdutosBKP.xml");
		backupVendas.salvaEmXML("backupDoArmazenamento/ColVendasBKP.xml");
		}
	private static Object getObject(byte[] colecaoEmByte){
		Object obj = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		
		try{
			bis = new ByteArrayInputStream(colecaoEmByte);
			ois = new ObjectInputStream(bis);
			obj = ois.readObject();
			
			bis.close();
			ois.close();
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return obj;
	}
}