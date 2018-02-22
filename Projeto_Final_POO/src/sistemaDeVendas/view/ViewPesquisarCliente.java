package sistemaDeVendas.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import sistemaDeVendas.classes.Clientes;
import sistemaDeVendas.collections.ColClientes;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class ViewPesquisarCliente extends JInternalFrame {
	private JTextField cpf;

	/**
	 * Launch the application.
	 */
	public ViewPesquisarCliente() {
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPesquisarCliente frame = new ViewPesquisarCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// ================================================== A FESTA COMEÇA AQUI =====================================================

	/**
	 * Create the frame.
	 */
	public ViewPesquisarCliente(ColClientes clientes) {
		setTitle("Pesquisar Cliente");
		setBounds(100, 100, 346, 405);
		getContentPane().setLayout(null);
		
		JLabel lblPesquisarClientePor = new JLabel("Pesquisar Cliente por CPF");
		lblPesquisarClientePor.setForeground(Color.RED);
		lblPesquisarClientePor.setFont(new Font("Algerian", Font.PLAIN, 16));
		lblPesquisarClientePor.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisarClientePor.setBounds(10, 11, 310, 42);
		getContentPane().add(lblPesquisarClientePor);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF do Cliente: (Apenas n\u00FAmeros)");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteOCpf.setBounds(10, 75, 310, 33);
		getContentPane().add(lblDigiteOCpf);
		
		cpf = new JTextField();
		cpf.setBounds(10, 119, 310, 42);
		getContentPane().add(cpf);
		cpf.setColumns(10);
		
		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpfCliente = cpf.getText();
				String retorno = clientes.pesquisarClienteDaLista(cpfCliente);
				
				if (retorno == null){
					JOptionPane.showMessageDialog (null, "CPF NÃO ENCONTRADO","CPF NÃO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
					cpf.setText("");
				} else {
					JOptionPane.showMessageDialog (null, retorno );
					cpf.setText("");
				}
				
			}
		});
		btnPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPesquisa.setBounds(10, 172, 310, 42);
		getContentPane().add(btnPesquisa);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewPesquisarCliente.this.setVisible(false);
			}
		});
		btnCancelar.setBounds(210, 331, 110, 33);
		getContentPane().add(btnCancelar);

	}
}
