package sistemaDeVendas.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import sistemaDeVendas.collections.ColProdutos;
import sistemaDeVendas.classes.Produtos;

public class ViewRemoveProduto extends JInternalFrame {
	private JTextField textIdProduto;

	/**
	 * Launch the application.
	 */
	public ViewRemoveProduto() {
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRemoveProduto frame = new ViewRemoveProduto();
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
	public ViewRemoveProduto(ColProdutos produtos) {
		setClosable(true);
		setTitle("REMOVER PRODUTO");
		setBounds(100, 100, 287, 320);
		getContentPane().setLayout(null);
		
		JLabel lblRemoverUmTipo = new JLabel("REMOVER UM TIPO DE PRODUTO DO SISTEMA");
		lblRemoverUmTipo.setForeground(Color.RED);
		lblRemoverUmTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverUmTipo.setFont(new Font("Algerian", Font.PLAIN, 12));
		lblRemoverUmTipo.setBounds(10, 11, 249, 31);
		getContentPane().add(lblRemoverUmTipo);
		
		JLabel lblDigiteOCdigo = new JLabel("Digite o C\u00F3digo do Produto:");
		lblDigiteOCdigo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDigiteOCdigo.setBounds(10, 53, 251, 24);
		getContentPane().add(lblDigiteOCdigo);
		
		textIdProduto = new JTextField();
		textIdProduto.setBounds(10, 88, 251, 31);
		getContentPane().add(textIdProduto);
		textIdProduto.setColumns(10);
		
		JButton btnRemoveProduto = new JButton("Remover Produto");
		btnRemoveProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idProduto = Integer.parseInt(textIdProduto.getText());
				Produtos resultadoPesquisa = produtos.retornaProdutoDaLista(idProduto);
				 if (resultadoPesquisa == null){
					 JOptionPane.showMessageDialog (null, "PRODUTO NÃO CADASTRADO","PRODUTO NÃO CADASTRADO", JOptionPane.ERROR_MESSAGE);
					 textIdProduto.setText("");
				} else {
					produtos.removeProdutoDaLista(resultadoPesquisa);
					JOptionPane.showMessageDialog (null, "Produto Removido com Sucesso!");
					textIdProduto.setText("");
				}
			}
		});
		btnRemoveProduto.setBounds(10, 130, 251, 31);
		getContentPane().add(btnRemoveProduto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewRemoveProduto.this.setVisible(false);
			}
		});
		btnCancelar.setBounds(170, 256, 89, 23);
		getContentPane().add(btnCancelar);

	}
}
