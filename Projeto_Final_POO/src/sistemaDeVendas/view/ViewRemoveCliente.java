package sistemaDeVendas.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import sistemaDeVendas.classes.Clientes;
import sistemaDeVendas.collections.ColClientes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewRemoveCliente extends JInternalFrame {
	private JTextField cpf;

	/**
	 * Launch the application.
	 */
	public ViewRemoveCliente(){
		setBounds(100, 100, 300, 360);
		getContentPane().setLayout(null);
		
		JLabel lblRemoverUmCliente = new JLabel("REMOVER UM CLIENTE DO SISTEMA");
		lblRemoverUmCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverUmCliente.setForeground(Color.RED);
		lblRemoverUmCliente.setFont(new Font("Algerian", Font.PLAIN, 16));
		lblRemoverUmCliente.setBounds(10, 11, 264, 46);
		getContentPane().add(lblRemoverUmCliente);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF do Cliente: ");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDigiteOCpf.setBounds(10, 68, 256, 22);
		getContentPane().add(lblDigiteOCpf);
		
		cpf = new JTextField();
		cpf.setColumns(10);
		cpf.setBounds(10, 101, 264, 35);
		getContentPane().add(cpf);
		
		JButton btnRemover = new JButton("Remover Cliente");
		btnRemover.setBounds(10, 147, 264, 54);
		getContentPane().add(btnRemover);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(161, 284, 113, 35);
		getContentPane().add(btnCancelar);
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRemoveCliente frame = new ViewRemoveCliente();
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
	public ViewRemoveCliente(ColClientes clientes) {
		setBounds(100, 100, 300, 360);
		getContentPane().setLayout(null);
		
		JLabel lblRemoverUmCliente = new JLabel("REMOVER UM CLIENTE DO SISTEMA");
		lblRemoverUmCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemoverUmCliente.setForeground(Color.RED);
		lblRemoverUmCliente.setFont(new Font("Algerian", Font.PLAIN, 16));
		lblRemoverUmCliente.setBounds(10, 11, 264, 46);
		getContentPane().add(lblRemoverUmCliente);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF do Cliente: ");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDigiteOCpf.setBounds(10, 68, 256, 22);
		getContentPane().add(lblDigiteOCpf);
		
		cpf = new JTextField();
		cpf.setColumns(10);
		cpf.setBounds(10, 101, 264, 35);
		getContentPane().add(cpf);
		
		JButton btnRemover = new JButton("Remover Cliente");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpfCliente = cpf.getText();
				Clientes antigoCliente = clientes.retornaCliente(cpfCliente);
				if (antigoCliente == null){
					JOptionPane.showMessageDialog (null, "CPF NÃO ENCONTRADO");
					cpf.setText("");
				} else {
					clientes.removeClienteDaLista(antigoCliente);
					JOptionPane.showMessageDialog (null, "Cliente Excluído com Sucesso!");
					cpf.setText("");
				}
			}
		});
		btnRemover.setBounds(10, 147, 264, 54);
		getContentPane().add(btnRemover);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewRemoveCliente.this.setVisible(false);
			}
		});
		btnCancelar.setBounds(161, 284, 113, 35);
		getContentPane().add(btnCancelar);

	}
}
