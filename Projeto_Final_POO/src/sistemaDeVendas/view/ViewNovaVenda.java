package sistemaDeVendas.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JRadioButton;

import sistemaDeVendas.classes.*;
import sistemaDeVendas.collections.*;

public class ViewNovaVenda extends JInternalFrame {
	private JTextField textIdProduto;
	private JTextField textCpf;
	private JTextField txtNomeCliente;
	private JTextField textQtdeEstoque;
	private JTextField textQtdeProdutosLevar;
	private JTextField textValorUnitario;
	private JTextField textCartaoCredito;
	
	/**
	 * Launch the application.
	 */
	
	public ViewNovaVenda() {
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewNovaVenda frame = new ViewNovaVenda();
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
	public ViewNovaVenda(ColClientes clientes, ColProdutos produtos, ColVendas vendas) {
		setClosable(true);
		setBounds(100, 100, 590, 590);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nova Venda");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Algerian", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 554, 50);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCpfDoCliente = new JLabel("CPF do Cliente: ");
		lblCpfDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpfDoCliente.setBounds(10, 72, 97, 28);
		getContentPane().add(lblCpfDoCliente);
		
		textCpf = new JTextField();
		textCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCpf.setBounds(135, 74, 261, 28);
		getContentPane().add(textCpf);
		textCpf.setColumns(10);
		
		JButton btnPesquisarCpf = new JButton("Pesquisar");
		btnPesquisarCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpfCliente = textCpf.getText();
				
				//SE O USUÁRIO DEIXOU O CAMPO EM BRANCO MOSTRE UMA MENSAGEM
				if(cpfCliente.isEmpty()){
					JOptionPane.showMessageDialog (null, "DIGITE O CPF DO CLIENTE","Aviso", JOptionPane.ERROR_MESSAGE);
				}else{
					//SE NÃO, FAÇA ISSO
					String retorno = clientes.retornarNomeCliente(cpfCliente);
					if (retorno == null){ //SE O RETORNO DA PESQUISA FOR NULO ENTÃO NADA FOI ENCONTRADO
						JOptionPane.showMessageDialog (null, "CPF NÃO ENCONTRADO","CPF NÃO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
						textCpf.setText("");
					} else {
						//CLIENTE ENCONTRADO
						JOptionPane.showMessageDialog(null, "Cliente Encontrado: " + retorno);
						txtNomeCliente.setText(clientes.retornarNomeCliente(cpfCliente));
					}
				}
			}
		});
		btnPesquisarCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisarCpf.setBounds(406, 72, 158, 28);
		getContentPane().add(btnPesquisarCpf);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente:");
		lblNomeDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDoCliente.setBounds(10, 111, 112, 28);
		getContentPane().add(lblNomeDoCliente);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(135, 111, 429, 28);
		getContentPane().add(txtNomeCliente);
		
		JLabel lblDigiteOCdigo = new JLabel("Digite o C\u00F3digo do Produto:");
		lblDigiteOCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteOCdigo.setBounds(10, 182, 191, 28);
		getContentPane().add(lblDigiteOCdigo);
		
		textIdProduto = new JTextField();
		textIdProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textIdProduto.setBounds(10, 221, 357, 28);
		getContentPane().add(textIdProduto);
		textIdProduto.setColumns(10);
		
		JButton btnPesquisarProduto = new JButton("Pesquisar");
		btnPesquisarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idProduto = 0;
				int erroDoUsuario = 0;
				String testeEntrada = textIdProduto.getText();
				// SESSÃO DE TESTES - BEGIN - SE HOUVER ALGUM ERRO A VARIÁVEL ERRO DO USUARIO SERÁ INCREMENTADA
				if(testeEntrada.isEmpty()){
					JOptionPane.showMessageDialog (null, "DIGITE O CÓDIGO DO PRODUTO","Aviso", JOptionPane.ERROR_MESSAGE);
					erroDoUsuario ++;
				}else{
					try{
						idProduto = Integer.parseInt(textIdProduto.getText());
					}catch(Exception erro){
						JOptionPane.showMessageDialog (null, "NÃO É UM CODIGO NUMÉRICO","Aviso", JOptionPane.ERROR_MESSAGE);
						erroDoUsuario ++;
					}
				}
				
				// SESSÃO DE TESTES - END
				
				//SE O USUÁRIO FEZ ALGO ERRADO, NÃO FAÇA NADA
				if(erroDoUsuario != 0){
				} else{
					//SE NÃO FAÇA ISSO
					Produtos produtoPesquisado = produtos.retornaProdutoDaLista(idProduto);
					if (produtoPesquisado == null){
						JOptionPane.showMessageDialog (null, "PRODUTO NÃO ENCONTRADO","PRODUTO NÃO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
						textIdProduto.setText("");
					} else {
						textQtdeEstoque.setText(Integer.toString(produtoPesquisado.getQuantidade())); //Converter a quantidade do produto em STRING
						textQtdeProdutosLevar.setText("1");
						textQtdeProdutosLevar.setEditable(true);
						textValorUnitario.setText(String.valueOf(produtoPesquisado.getValor())); //Converter o valor do produto em STRING
					}
				}
			}
		});
		btnPesquisarProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisarProduto.setBounds(377, 221, 187, 28);
		getContentPane().add(btnPesquisarProduto);
		
		JLabel lblQuantidadeEmEstoque = new JLabel("Quantidade em Estoque:");
		lblQuantidadeEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidadeEmEstoque.setBounds(10, 260, 158, 28);
		getContentPane().add(lblQuantidadeEmEstoque);
		
		JLabel lblQuantosVaiLevar = new JLabel("Quantos produtos:");
		lblQuantosVaiLevar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantosVaiLevar.setBounds(188, 260, 158, 28);
		getContentPane().add(lblQuantosVaiLevar);
		
		JLabel lblValorUnitrio = new JLabel("Valor Unit\u00E1rio");
		lblValorUnitrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorUnitrio.setBounds(396, 260, 168, 28);
		getContentPane().add(lblValorUnitrio);
		
		JLabel lblR = new JLabel("R$");
		lblR.setEnabled(false);
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblR.setBounds(366, 297, 30, 28);
		getContentPane().add(lblR);
		
		textQtdeEstoque = new JTextField();
		textQtdeEstoque.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textQtdeEstoque.setEditable(false);
		textQtdeEstoque.setBounds(10, 299, 158, 28);
		getContentPane().add(textQtdeEstoque);
		textQtdeEstoque.setColumns(10);
		
		textQtdeProdutosLevar = new JTextField();
		textQtdeProdutosLevar.setEditable(false);
		textQtdeProdutosLevar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textQtdeProdutosLevar.setColumns(10);
		textQtdeProdutosLevar.setBounds(188, 299, 158, 28);
		getContentPane().add(textQtdeProdutosLevar);
		
		textValorUnitario = new JTextField();
		textValorUnitario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textValorUnitario.setEditable(false);
		textValorUnitario.setColumns(10);
		textValorUnitario.setBounds(393, 299, 171, 28);
		getContentPane().add(textValorUnitario);
		
		JLabel lblMtodoDePagamento = new JLabel("M\u00E9todo de Pagamento");
		lblMtodoDePagamento.setForeground(Color.RED);
		lblMtodoDePagamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblMtodoDePagamento.setFont(new Font("Algerian", Font.PLAIN, 21));
		lblMtodoDePagamento.setBounds(10, 338, 554, 40);
		getContentPane().add(lblMtodoDePagamento);
		
		JTextField textDinheiro = new JTextField();
		JRadioButton rdbtnDinheiro = new JRadioButton("Pagamento \u00E0 VISTA");
		JRadioButton rdbtnCartao = new JRadioButton("Cart\u00E3o de Cr\u00E9dito");
		rdbtnDinheiro.setSelected(true);
		
		rdbtnDinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCartao.setSelected(false);
				textCartaoCredito.setEditable(false);
				textDinheiro.setEditable(true);
			}
		});
		rdbtnDinheiro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnDinheiro.setBounds(10, 385, 269, 23);
		getContentPane().add(rdbtnDinheiro);
		
		rdbtnCartao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDinheiro.setSelected(false);
				textDinheiro.setEditable(false);
				textCartaoCredito.setEditable(true);
			}
		});
		rdbtnCartao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnCartao.setBounds(310, 385, 254, 23);
		getContentPane().add(rdbtnCartao);
		
		JLabel lblValorRecebido = new JLabel("Valor Recebido:");
		lblValorRecebido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorRecebido.setBounds(10, 415, 97, 28);
		getContentPane().add(lblValorRecebido);
		
		JLabel label = new JLabel("R$");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setEnabled(false);
		label.setBounds(110, 415, 24, 28);
		getContentPane().add(label);
		
		textDinheiro.setEditable(true);
		textDinheiro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textDinheiro.setColumns(10);
		textDinheiro.setBounds(135, 415, 144, 28);
		getContentPane().add(textDinheiro);
		
		JLabel lblQuantasParcelas = new JLabel("Quantas Parcelas:");
		lblQuantasParcelas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantasParcelas.setBounds(310, 415, 112, 28);
		getContentPane().add(lblQuantasParcelas);
		
		JButton btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qtdeProdutosComprados = 0;
				int idVenda = vendas.tamanhoDaLista() + 1;
				int idProduto = 0;
				int erroDoUsuario = 0;
				float valorDaCompra = 0;
				String metodoPagamento = null;
				String nomeCliente = null;		
				
				String entradaCpfCliente = textCpf.getText();
				String entradaProduto = textIdProduto.getText();
				String entradaProdutoLevar = textQtdeProdutosLevar.getText();
				String entradaCartaoCredito = textCartaoCredito.getText();
				String entradaDinheiro = textDinheiro.getText();
				
				//SESSÃO DE TESTES
				if(entradaCpfCliente.isEmpty() || entradaProduto.isEmpty() || entradaProdutoLevar.isEmpty()){
					JOptionPane.showMessageDialog (null, "PREENCHA OS CAMPOS CORRETAMENTE ANTES DE FINALIZAR A COMPRA", "AVISO", JOptionPane.ERROR_MESSAGE);
				}else if (rdbtnCartao.isSelected() && entradaCartaoCredito.isEmpty()){
					JOptionPane.showMessageDialog (null, "DIGITE QUANTAS PARCELAS IRÁ DIVIDIR A COMPRA ANTES DE FINALIZA-LA", "AVISO", JOptionPane.ERROR_MESSAGE);
					} else if(rdbtnDinheiro.isSelected() && entradaDinheiro.isEmpty()){
						JOptionPane.showMessageDialog (null, "DIGITE QUANTO O CAIXA RECEBEU ANTES DE FINALIZAR A COMPRA", "AVISO", JOptionPane.ERROR_MESSAGE);
					} else {
						try{
							qtdeProdutosComprados = Integer.parseInt(entradaProdutoLevar);
							idProduto = Integer.parseInt(entradaProduto);
							erroDoUsuario = 0;
						}catch(Exception erro){
							JOptionPane.showMessageDialog (null, "CAMPOS NUMERICOS NÃO PREENCHIDOS CORRETAMENTE", "AVISO", JOptionPane.ERROR_MESSAGE);
							erroDoUsuario = 1;
						}
						
						if(erroDoUsuario != 0){
							
						} else {
							nomeCliente = clientes.retornarNomeCliente(entradaCpfCliente);
							valorDaCompra = Float.valueOf(textValorUnitario.getText()) * qtdeProdutosComprados; // Valor da compra
							
							Produtos produtoPesquisado = produtos.retornaProdutoDaLista(idProduto); //Pegando o produto da coleção
							
							int novaQuantidade = Integer.parseInt(entradaProdutoLevar);
							produtoPesquisado.reduzQuantidade(novaQuantidade); //Reduz a quantidade de produtos do estoque.
							
							if (rdbtnCartao.isSelected()){
								float valorParcelas = valorDaCompra / Integer.parseInt(entradaCartaoCredito); // Valor da compra / Quantidade de vezes que o cliente optou.
								metodoPagamento = "Cartao de Credito: " + entradaCartaoCredito + "x\nParcelas de: R$ " + valorParcelas;
							}
							
							if (rdbtnDinheiro.isSelected()){
								float troco = Float.valueOf(entradaDinheiro) - valorDaCompra; // Quantidade recebida pelo caixa - valor da compra
								metodoPagamento = "Dinheiro. Caixa recebeu R$ " + entradaDinheiro + "\n Troco: R$ " + troco;
							}
							
							//CRIANDO UMA VENDA
							Vendas novaVenda = new Vendas(idVenda, idProduto, qtdeProdutosComprados, nomeCliente, entradaCpfCliente, metodoPagamento, valorDaCompra);
							
							//Adicionando a venda a coleção de vendas com exception
							try{
								vendas.adicionaVendaNaLista(novaVenda);
								JOptionPane.showMessageDialog (null, "VENDA REALIZADA COM SUCESSO");
							}catch(Exception erro){
								JOptionPane.showMessageDialog (null, "O seguinte erro aconteceu: " + erro, "AVISO", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
			}
		});
		
		textCartaoCredito = new JTextField();
		textCartaoCredito.setEditable(false);
		textCartaoCredito.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCartaoCredito.setColumns(10);
		textCartaoCredito.setBounds(432, 415, 132, 28);
		getContentPane().add(textCartaoCredito);
		btnFinalizarVenda.setForeground(Color.GREEN);
		btnFinalizarVenda.setFont(new Font("Algerian", Font.PLAIN, 18));
		btnFinalizarVenda.setBounds(10, 454, 554, 42);
		getContentPane().add(btnFinalizarVenda);
		
		JButton btnCancelarVenda = new JButton("Cancelar Venda");
		btnCancelarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewNovaVenda.this.setVisible(false);
			}
		});
		btnCancelarVenda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelarVenda.setBounds(390, 509, 174, 40);
		getContentPane().add(btnCancelarVenda);

	}
}
