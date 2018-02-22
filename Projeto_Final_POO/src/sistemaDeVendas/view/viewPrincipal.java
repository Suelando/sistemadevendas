package sistemaDeVendas.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Insets;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import sistemaDeVendas.collections.*;
import sistemaDeVendas.classes.*;

import javax.swing.JEditorPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class viewPrincipal extends JFrame {
	private JPanel contentPane;
	public ColClientes clientes = new ColClientes();
	public ColProdutos produtos = new ColProdutos();
	public ColVendas vendas = new ColVendas();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewPrincipal frame = new viewPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public viewPrincipal() {
		// ======== AQUI O PROGRAMA IRÁ VERIFICAR SE EXISTE ALGUM XML SALVO LOCALMENTE PARA CARREGAR AS INFORMAÇÕES ========
		if(existeXML("armazenamento/ColClientes.xml")){
			clientes.lerDoXML("armazenamento/ColClientes.xml");
		}
		if(existeXML("armazenamento/ColProdutos.xml")){
			produtos.lerDoXML("armazenamento/ColProdutos.xml");
		}
		if(existeXML("armazenamento/ColVendas.xml")){
			vendas.lerDoXML("armazenamento/ColVendas.xml");
		}
		// ===================================== FIM DA VERIFICAÇÃO ==============================================
		
		setTitle("SISTEMA DE VENDAS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 700);
		
		JDesktopPane desktopPane = new JDesktopPane();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu menu1 = new JMenu("         Consultar         ");
		menu1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menu1);
		
		JMenuItem mntmValorDoProduto = new JMenuItem("Valor de Produtos");
		mntmValorDoProduto.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmValorDoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o Código do Produto: "));
				Produtos resultPesquisa = produtos.retornaProdutoDaLista(idProduto);
				
				if (resultPesquisa == null){
					JOptionPane.showMessageDialog (null, "PRODUTO NÃO CADASTRADO","PRODUTO NÃO CADASTRADO", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog (null, "R$" + resultPesquisa.getValor());
				}
			}
		});
		mntmValorDoProduto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		menu1.add(mntmValorDoProduto);
		
		JMenuItem mntmRelatrioDeVendas = new JMenuItem("Relat\u00F3rio de Vendas");
		mntmRelatrioDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Exibindo as vendas na tela
				if (vendas.tamanhoDaLista() != 0){
					JOptionPane.showMessageDialog (null, vendas, "VENDAS REALIZADAS", JOptionPane.DEFAULT_OPTION);
				} else {
					JOptionPane.showMessageDialog (null, "NÃO HOUVE NENHUMA VENDA PELO SISTEMA", "AVISO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		mntmRelatrioDeVendas.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menu1.add(mntmRelatrioDeVendas);
		
		JMenu menu2 = new JMenu("         Pesquisar         ");
		menu2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menu2);
		
		JMenuItem mntmPesquisarCliente = new JMenuItem("Por Cliente");
		mntmPesquisarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmPesquisarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewPesquisarCliente obj = new ViewPesquisarCliente(clientes);
				desktopPane.add(obj);
				obj.setVisible(true);
			}
		});
		menu2.add(mntmPesquisarCliente);
		
		JMenuItem mntmProduto = new JMenuItem("Por Produto");
		mntmProduto.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPesquisarProduto obj = new ViewPesquisarProduto(produtos);
				desktopPane.add(obj);
				obj.setVisible(true);
			}
		});
		menu2.add(mntmProduto);
		
		JMenu menu4 = new JMenu("         Vendas         ");
		menu4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menu4);
		
		JMenuItem mntmNovaVenda = new JMenuItem("Nova Venda");
		mntmNovaVenda.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewNovaVenda obj = new ViewNovaVenda(clientes, produtos, vendas);
				desktopPane.add(obj);
				obj.setVisible(true);
			}
		});
		mntmNovaVenda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menu4.add(mntmNovaVenda);
		
		JMenu menu3 = new JMenu("           Clientes           ");
		menu3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menu3);
		
		JMenuItem menuAdicionarCliente = new JMenuItem("Adicionar");
		menuAdicionarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		menuAdicionarCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		menuAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAddCliente obj = new ViewAddCliente(clientes);
				desktopPane.add(obj);
				obj.setVisible(true);
				
			}
		});
		menu3.add(menuAdicionarCliente);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAlterarCliente obj = new ViewAlterarCliente(clientes);
				desktopPane.add(obj);
				obj.setVisible(true);
			}
		});
		menu3.add(mntmAlterar);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewRemoveCliente obj = new ViewRemoveCliente(clientes);
				desktopPane.add(obj);
				obj.setVisible(true);
			}
		});
		menu3.add(mntmExcluir);
		
		JMenu menu5 = new JMenu("         Produtos         ");
		menu5.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menu5);
		
		JMenuItem mntmLogarNoSistema = new JMenuItem("Adicionar");
		mntmLogarNoSistema.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmLogarNoSistema.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mntmLogarNoSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAddProduto obj = new ViewAddProduto(produtos);
				desktopPane.add(obj);
				obj.setVisible(true);
			}
		});
		menu5.add(mntmLogarNoSistema);
		
		JMenuItem mntmExcluir_1 = new JMenuItem("Alterar");
		mntmExcluir_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAlterarProduto obj = new ViewAlterarProduto(produtos);
				desktopPane.add(obj);
				obj.setVisible(true);
			}
		});
		menu5.add(mntmExcluir_1);
		
		JMenuItem mntmExcluir_2 = new JMenuItem("Excluir");
		mntmExcluir_2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mntmExcluir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewRemoveProduto obj = new ViewRemoveProduto(produtos);
				desktopPane.add(obj);
				obj.setVisible(true);
			}
		});
		menu5.add(mntmExcluir_2);
		
		JMenu mnNewMenu = new JMenu("      Configura\u00E7\u00F5es      ");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmRealizarBackup = new JMenuItem("Realizar Backup");
		mntmRealizarBackup.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mntmRealizarBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//SALVANDO AS INFORMAÇÕES ANTES DE REALIZAR O BACKUP VIA SOCKET
				clientes.salvaEmXML("armazenamento/ColClientes.xml");
				produtos.salvaEmXML("armazenamento/ColProdutos.xml");
				vendas.salvaEmXML("armazenamento/ColVendas.xml");
				try {
					copiaObjetosParaServidor(clientes, produtos, vendas);
					JOptionPane.showMessageDialog (null, "BACKUP PARA O SERVIDOR REALIZADO COM SUCESSO!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mntmRealizarBackup.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(mntmRealizarBackup);
		
		JMenuItem mntmAjuda = new JMenuItem("Ajuda");
		mntmAjuda.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(mntmAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre...");
		mntmSobre.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnNewMenu.add(mntmSobre);
		
		JLabel label_1 = new JLabel("                           ");
		label_1.setEnabled(false);
		menuBar.add(label_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane.setBounds(10, 0, 1024, 626);
		contentPane.add(desktopPane);
		
		JButton btnNovaVenda = new JButton("Nova Venda ( F1 )");
		btnNovaVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewNovaVenda obj = new ViewNovaVenda(clientes, produtos, vendas);
				desktopPane.add(obj);
				obj.setVisible(true);
			}
		});
		btnNovaVenda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNovaVenda.setBounds(179, 137, 231, 109);
		desktopPane.add(btnNovaVenda);
		
		JButton btnConsultarValorDe = new JButton("Consultar Valor de Produtos ( F2 )");
		btnConsultarValorDe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConsultarValorDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idProduto = Integer.parseInt(JOptionPane.showInputDialog("Digite o Código do Produto: "));
				Produtos resultPesquisa = produtos.retornaProdutoDaLista(idProduto);
				
				if (resultPesquisa == null){
					JOptionPane.showMessageDialog (null, "PRODUTO NÃO CADASTRADO","PRODUTO NÃO CADASTRADO", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog (null, resultPesquisa.getValor());
				}
			}
		});
		btnConsultarValorDe.setBounds(592, 137, 231, 109);
		desktopPane.add(btnConsultarValorDe);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar Novo Cliente ( F3 )");
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAddCliente obj = new ViewAddCliente(clientes);
				desktopPane.add(obj);
				obj.setVisible(true);
			}
		});
		btnCadastrarCliente.setBounds(179, 308, 231, 109);
		desktopPane.add(btnCadastrarCliente);
		
		JButton btnSalvar = new JButton("Salvar as Informa\u00E7\u00F5es");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					copiaObjetosParaServidor(clientes, produtos, vendas);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clientes.salvaEmXML("armazenamento/ColClientes.xml");
				produtos.salvaEmXML("armazenamento/ColProdutos.xml");
				vendas.salvaEmXML("armazenamento/ColVendas.xml");
				JOptionPane.showMessageDialog (null, "INFORMAÇÕES SALVAS LOCALMENTE");
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSalvar.setBounds(592, 308, 231, 109);
		desktopPane.add(btnSalvar);
		
		JLabel lblDesenvolvidoPelaEquipe = new JLabel("Desenvolvido pela Equipe 2: Alan Giovanni | William Gomes | Suelando Alves");
		lblDesenvolvidoPelaEquipe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesenvolvidoPelaEquipe.setBounds(10, 601, 834, 14);
		desktopPane.add(lblDesenvolvidoPelaEquipe);
		lblDesenvolvidoPelaEquipe.setForeground(Color.RED);
		
		JLabel lblSistemaDeVendas = new JLabel("SISTEMA DE VENDAS - IFPB");
		lblSistemaDeVendas.setHorizontalAlignment(SwingConstants.CENTER);
		lblSistemaDeVendas.setFont(new Font("Algerian", Font.PLAIN, 30));
		lblSistemaDeVendas.setForeground(Color.RED);
		lblSistemaDeVendas.setBounds(98, 11, 834, 67);
		desktopPane.add(lblSistemaDeVendas);
	}

	public boolean existeXML(String caminhoDoArquivo){
		File arquivo = new File(caminhoDoArquivo);
		if(arquivo.exists()){
		return true;
		} else{
			return false;
		}
	}
	
	public void copiaObjetosParaServidor(ColClientes clientes, ColProdutos produtos, ColVendas vendas) throws UnknownHostException, IOException{
		//SOCKET PARA A COLECAO DE CLIENTES
		Socket conexaoCliente = new Socket("localhost", 5555);
		BufferedOutputStream byteColecaoClientes = new BufferedOutputStream(conexaoCliente.getOutputStream());
		
		//SERIALIZANDO A COLEÇAO DE CLIENTES
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		ObjectOutputStream ous = new ObjectOutputStream(bao);
		ous.writeObject(clientes);
		byte[] clienteEmByte = bao.toByteArray();
		
		//FINALIZANDO					
		byteColecaoClientes.write(clienteEmByte);
		byteColecaoClientes.flush();
		byteColecaoClientes.close();
		
		//FECHANDO A CONEXÃO
		conexaoCliente.close();
		
		//SOCKET PARA A COLECAO DE PRODUTOS
		Socket conexaoCliente2 = new Socket("localhost", 5555);
		BufferedOutputStream byteColecaoProduto = new BufferedOutputStream(conexaoCliente2.getOutputStream());
		
		//SERIALIZANDO A COLEÇAO DE PRODUTOS
		ByteArrayOutputStream bao2 = new ByteArrayOutputStream();
		ObjectOutputStream ous2 = new ObjectOutputStream(bao2);
		ous2.writeObject(produtos);
		byte[] produtosEmByte = bao2.toByteArray();
		
		//FINALIZANDO
		byteColecaoProduto.write(produtosEmByte);
		byteColecaoProduto.flush();
		byteColecaoProduto.close();
		
		//FECHANDO A CONEXÃO
		conexaoCliente2.close();
		
		//SOCKET PARA A COLECAO DE VENDAS
		Socket conexaoCliente3 = new Socket("localhost", 5555);
		BufferedOutputStream byteColecaoVendas = new BufferedOutputStream(conexaoCliente3.getOutputStream());
		
		//SERIALIZANDO A COLEÇAO DE VENDAS
		ByteArrayOutputStream bao3 = new ByteArrayOutputStream();
		ObjectOutputStream ous3 = new ObjectOutputStream(bao3);
		ous3.writeObject(vendas);
		byte[] vendasEmByte = bao3.toByteArray();
		
		//FINALIZANDO					
		byteColecaoVendas.write(vendasEmByte);
		byteColecaoVendas.flush();
		byteColecaoVendas.close();
		
		//FECHANDO A CONEXÃO
		conexaoCliente3.close();
	}
}
