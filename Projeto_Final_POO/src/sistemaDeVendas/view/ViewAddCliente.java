package sistemaDeVendas.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Panel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import sistemaDeVendas.collections.*;
import sistemaDeVendas.classes.*;


public class ViewAddCliente extends JInternalFrame {
	private JTextField textNome;
	private JTextField textCpf;

	/**
	 * Launch the application.
	 */

	public ViewAddCliente() {
	}
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ViewAddCliente frame = new ViewAddCliente();
					frame.setVisible(true);
			}
		});
	}
// ================================================ A FESTA COMEÇA AQUI ==========================================================
	/**
	 * Create the frame.
	 */
	public ViewAddCliente(ColClientes clientes) {
		setTitle("ADICIONAR CLIENTE");
		setBounds(100, 100, 368, 410);
		getContentPane().setLayout(null);
		
		JLabel lblDigiteONome = new JLabel("Digite o NOME do Cliente: ");
		lblDigiteONome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteONome.setBounds(10, 68, 332, 22);
		getContentPane().add(lblDigiteONome);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF do Cliente: (Sem s\u00EDmbolos ou pontos)");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteOCpf.setBounds(10, 147, 332, 22);
		getContentPane().add(lblDigiteOCpf);
		
		textNome = new JTextField();
		textNome.setBounds(10, 101, 332, 35);
		getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(10, 180, 332, 35);
		getContentPane().add(textCpf);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeCliente = textNome.getText();
				String cpfCliente = textCpf.getText();
				Clientes c1 = new Clientes(nomeCliente, cpfCliente);
				clientes.adicionaClienteNaLista(c1);
				JOptionPane.showMessageDialog (null, "Cliente Adicionado com Sucesso!");
				textCpf.setText("");
				textNome.setText("");
			}
		});
		btnSalvar.setBounds(10, 226, 332, 54);
		getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewAddCliente.this.setVisible(false);
			}
		});
		btnCancelar.setBounds(229, 334, 113, 35);
		getContentPane().add(btnCancelar);
		
		JLabel lblAdicionarUmNovo = new JLabel("ADICIONAR UM NOVO CLIENTE NO SISTEMA");
		lblAdicionarUmNovo.setForeground(Color.RED);
		lblAdicionarUmNovo.setFont(new Font("Algerian", Font.PLAIN, 13));
		lblAdicionarUmNovo.setBounds(10, 11, 256, 46);
		getContentPane().add(lblAdicionarUmNovo);

	}
}
