package sistemaDeVendas.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import sistemaDeVendas.collections.ColProdutos;
import sistemaDeVendas.classes.Clientes;
import sistemaDeVendas.classes.Produtos;

public class ViewAlterarProduto extends JInternalFrame {
	private JTextField idProdutoText;
	private JTextField nomeText;
	private JTextField textField_2;
	private JTextField valorText;
	private JTextField qtdeText;

	/**
	 * Launch the application.
	 */
	public ViewAlterarProduto() {
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAlterarProduto frame = new ViewAlterarProduto();
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
	public ViewAlterarProduto(ColProdutos produtos) {
		setClosable(true);
		setBounds(100, 100, 401, 440);
		getContentPane().setLayout(null);
		
		JLabel lblAlterarUmProduto = new JLabel("Alterar um Produto");
		lblAlterarUmProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterarUmProduto.setForeground(Color.RED);
		lblAlterarUmProduto.setFont(new Font("Algerian", Font.PLAIN, 17));
		lblAlterarUmProduto.setBounds(10, 11, 364, 31);
		getContentPane().add(lblAlterarUmProduto);
		
		JLabel lblDigiteOCdigo = new JLabel("Digite o c\u00F3digo do produto (apenas numeros):");
		lblDigiteOCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteOCdigo.setBounds(10, 53, 364, 22);
		getContentPane().add(lblDigiteOCdigo);
		
		idProdutoText = new JTextField();
		idProdutoText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		idProdutoText.setColumns(10);
		idProdutoText.setBounds(10, 86, 235, 31);
		getContentPane().add(idProdutoText);
		
		JLabel label_2 = new JLabel("Nome: ");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 128, 364, 22);
		getContentPane().add(label_2);
		
		nomeText = new JTextField();
		nomeText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nomeText.setEnabled(false);
		nomeText.setColumns(10);
		nomeText.setBounds(10, 161, 364, 31);
		getContentPane().add(nomeText);
		
		JLabel label_3 = new JLabel("Valor: (50.25)");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 203, 182, 22);
		getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setText("R$");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(10, 236, 33, 31);
		getContentPane().add(textField_2);
		
		valorText = new JTextField();
		valorText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		valorText.setEnabled(false);
		valorText.setColumns(10);
		valorText.setBounds(43, 236, 149, 31);
		getContentPane().add(valorText);
		
		JLabel label_4 = new JLabel("Quantidade: ");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(202, 203, 164, 22);
		getContentPane().add(label_4);
		
		qtdeText = new JTextField();
		qtdeText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		qtdeText.setEnabled(false);
		qtdeText.setColumns(10);
		qtdeText.setBounds(202, 236, 172, 31);
		getContentPane().add(qtdeText);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idProduto = Integer.parseInt(idProdutoText.getText());
				Produtos produtoPesquisado = produtos.retornaProdutoDaLista(idProduto);
				
				if (produtoPesquisado == null){
					JOptionPane.showMessageDialog (null, "PRODUTO NÃO ENCONTRADO");
					idProdutoText.setText("");
				} else {
					nomeText.setText(produtoPesquisado.getNome());
					nomeText.setEnabled(true);
					
					valorText.setText(String.valueOf(produtoPesquisado.getValor())); // Converter o double em STRING
					valorText.setEnabled(true);
					
					qtdeText.setText(String.valueOf(produtoPesquisado.getQuantidade()));
					qtdeText.setEnabled(true);
				}
			}
		});
		btnPesquisar.setBounds(255, 86, 119, 31);
		getContentPane().add(btnPesquisar);
		
		JButton btnAtualizarInformacoes = new JButton("Atualizar Informa\u00E7\u00F5es");
		btnAtualizarInformacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idProduto = Integer.parseInt(idProdutoText.getText());
				String nomeProduto = nomeText.getText();
				Double valorProduto = Double.parseDouble(valorText.getText());
				int quantidadeProduto = Integer.parseInt(qtdeText.getText());
				
				produtos.alteraProdutoDaLista(idProduto, quantidadeProduto, nomeProduto, valorProduto);
				JOptionPane.showMessageDialog (null, "Informações do Produto Atualizado com Sucesso!");
				idProdutoText.setText("");
				nomeText.setText("");
				valorText.setText("");
				qtdeText.setText("");
			}
		});
		btnAtualizarInformacoes.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAtualizarInformacoes.setBounds(10, 287, 364, 31);
		getContentPane().add(btnAtualizarInformacoes);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAlterarProduto.this.setVisible(false);
			}
		});
		btnCancelar.setBounds(276, 368, 98, 31);
		getContentPane().add(btnCancelar);

	}
}
