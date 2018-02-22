package sistemaDeVendas.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import sistemaDeVendas.classes.Produtos;
import sistemaDeVendas.collections.ColProdutos;

public class ViewPesquisarProduto extends JInternalFrame {
	private JTextField textIdProduto;

	/**
	 * Launch the application.
	 */
	public ViewPesquisarProduto(){
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPesquisarProduto frame = new ViewPesquisarProduto();
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
	public ViewPesquisarProduto(ColProdutos produtos) {
		setTitle("PESQUISAR PRODUTOS");
		setClosable(true);
		setBounds(100, 100, 383, 366);
		getContentPane().setLayout(null);
		
		JLabel lblPesquisarProdutoPor = new JLabel("Pesquisar Produto por C\u00F3digo de Produto ");
		lblPesquisarProdutoPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisarProdutoPor.setFont(new Font("Algerian", Font.PLAIN, 15));
		lblPesquisarProdutoPor.setForeground(Color.RED);
		lblPesquisarProdutoPor.setBounds(10, 11, 347, 38);
		getContentPane().add(lblPesquisarProdutoPor);
		
		JLabel lblDigiteOCdigo = new JLabel("Digite o c\u00F3digo do Produto:");
		lblDigiteOCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteOCdigo.setBounds(10, 60, 347, 31);
		getContentPane().add(lblDigiteOCdigo);
		
		textIdProduto = new JTextField();
		textIdProduto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textIdProduto.setBounds(10, 102, 347, 31);
		getContentPane().add(textIdProduto);
		textIdProduto.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int idProduto = Integer.parseInt(textIdProduto.getText());
				Produtos resultPesquisa = produtos.retornaProdutoDaLista(idProduto);
				
				if (resultPesquisa == null){
					JOptionPane.showMessageDialog (null, "PRODUTO NÃO CADASTRADO","PRODUTO NÃO CADASTRADO", JOptionPane.ERROR_MESSAGE);
					textIdProduto.setText("");
				} else {
					JOptionPane.showMessageDialog (null, resultPesquisa);
					textIdProduto.setText("");
				}
			}
		});
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPesquisar.setBounds(10, 149, 347, 38);
		getContentPane().add(btnPesquisar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPesquisarProduto.this.setVisible(false);
			}
		});
		btnCancelar.setBounds(253, 294, 104, 31);
		getContentPane().add(btnCancelar);

	}
}
