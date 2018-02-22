package sistemaDeVendas.view;

import java.awt.EventQueue;

import sistemaDeVendas.classes.Clientes;
import sistemaDeVendas.classes.Produtos;
import sistemaDeVendas.collections.ColProdutos;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAddProduto extends JInternalFrame {
	private JTextField textIdProduto;
	private JTextField textNome;
	private JTextField textValor;
	private JTextField textQuantidade;
	private JTextField txtR;

	/**
	 * Launch the application.
	 */
	public ViewAddProduto() {
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAddProduto frame = new ViewAddProduto();
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
	public ViewAddProduto(ColProdutos produtos) {
		setClosable(true);
		setTitle("ADICIONAR PRODUTO");
		setBounds(100, 100, 400, 440);
		getContentPane().setLayout(null);
		
		JLabel lblAdicionarUmNovo = new JLabel("Adicionar um Novo Produto");
		lblAdicionarUmNovo.setForeground(Color.RED);
		lblAdicionarUmNovo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarUmNovo.setFont(new Font("Algerian", Font.PLAIN, 16));
		lblAdicionarUmNovo.setBounds(10, 11, 364, 31);
		getContentPane().add(lblAdicionarUmNovo);
		
		JLabel lblCdigoDeBarras = new JLabel("C\u00F3digo do Produto (apenas numeros):");
		lblCdigoDeBarras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigoDeBarras.setBounds(10, 53, 364, 22);
		getContentPane().add(lblCdigoDeBarras);
		
		textIdProduto = new JTextField();
		textIdProduto.setBounds(10, 86, 364, 31);
		getContentPane().add(textIdProduto);
		textIdProduto.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 128, 364, 22);
		getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(10, 161, 364, 31);
		getContentPane().add(textNome);
		
		JLabel lblValor = new JLabel("Valor: (50.25)");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(10, 203, 182, 22);
		getContentPane().add(lblValor);
		
		textValor = new JTextField();
		textValor.setColumns(10);
		textValor.setBounds(43, 236, 149, 31);
		getContentPane().add(textValor);
		
		JLabel lblQuantidade = new JLabel("Quantidade: ");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidade.setBounds(202, 203, 164, 22);
		getContentPane().add(lblQuantidade);
		
		textQuantidade = new JTextField();
		textQuantidade.setColumns(10);
		textQuantidade.setBounds(202, 236, 172, 31);
		getContentPane().add(textQuantidade);
		
		JButton btnAdicionarProduto = new JButton("Adicionar Produto");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeProduto = textNome.getText();
				int idProduto = Integer.parseInt(textIdProduto.getText());
				Double valorProduto = Double.parseDouble(textValor.getText());
				int qtdeProduto = Integer.parseInt(textQuantidade.getText());
				
				Produtos resultPesquisa = produtos.retornaProdutoDaLista(idProduto);
					if (resultPesquisa != null){
						JOptionPane.showMessageDialog (null, "PRODUTO JÁ CADASTRADO","PRODUTO JÁ CADASTRADO", JOptionPane.ERROR_MESSAGE);
						textIdProduto.setText("");
						textNome.setText("");
						textValor.setText("");
						textQuantidade.setText("");	
					} else{
						Produtos p = new Produtos(idProduto, nomeProduto, valorProduto, qtdeProduto);
						produtos.adicionaProdutoNaLista(p);
						JOptionPane.showMessageDialog (null, "Produto Adicionado com Sucesso!");
						textIdProduto.setText("");
						textNome.setText("");
						textValor.setText("");
						textQuantidade.setText("");
					}
				}
		});
		btnAdicionarProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdicionarProduto.setBounds(10, 287, 364, 31);
		getContentPane().add(btnAdicionarProduto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewAddProduto.this.setVisible(false);
			}
		});
		btnCancelar.setBounds(276, 368, 98, 31);
		getContentPane().add(btnCancelar);
		
		txtR = new JTextField();
		txtR.setHorizontalAlignment(SwingConstants.CENTER);
		txtR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtR.setEditable(false);
		txtR.setText("R$");
		txtR.setBounds(10, 236, 33, 31);
		getContentPane().add(txtR);
		txtR.setColumns(10);

	}
}
