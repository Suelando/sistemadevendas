package sistemaDeVendas.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import sistemaDeVendas.classes.Clientes;
import sistemaDeVendas.collections.ColClientes;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class ViewAlterarCliente extends JInternalFrame {
	private JTextField nomeCliente;
	private JTextField cpfCliente;
	private JTextField telefoneCliente;
	private JTextField cpfPesquisado;
	private JTextField cepCliente;
	private JTextField enderecoCliente;
	private JTextField ufCliente;
	private JTextField bairroCliente;

	/**
	 * Launch the application.
	 */
	public ViewAlterarCliente() {
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAlterarCliente frame = new ViewAlterarCliente();
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
	public ViewAlterarCliente(ColClientes clientes) {
		setBounds(100, 100, 590, 506);
		getContentPane().setLayout(null);
		
		JLabel lblAlterarInformaesDe = new JLabel("ALTERAR INFORMA\u00C7\u00D5ES DE UM CLIENTE");
		lblAlterarInformaesDe.setBounds(10, 11, 546, 60);
		lblAlterarInformaesDe.setForeground(Color.RED);
		lblAlterarInformaesDe.setFont(new Font("Algerian", Font.PLAIN, 17));
		lblAlterarInformaesDe.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblAlterarInformaesDe);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente: ");
		lblNomeDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDoCliente.setBounds(10, 158, 355, 25);
		getContentPane().add(lblNomeDoCliente);
		
		nomeCliente = new JTextField();
		nomeCliente.setEnabled(false);
		nomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nomeCliente.setBounds(10, 194, 355, 25);
		getContentPane().add(nomeCliente);
		nomeCliente.setColumns(10);
		
		JLabel lblCpfDoCliente = new JLabel("CPF: ");
		lblCpfDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpfDoCliente.setBounds(375, 158, 181, 25);
		getContentPane().add(lblCpfDoCliente);
		
		cpfCliente = new JTextField();
		cpfCliente.setEnabled(false);
		cpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cpfCliente.setColumns(10);
		cpfCliente.setBounds(375, 194, 181, 25);
		getContentPane().add(cpfCliente);
		
		JLabel label_1 = new JLabel("Telefone");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(375, 302, 180, 25);
		getContentPane().add(label_1);
		
		telefoneCliente = new JTextField();
		telefoneCliente.setEnabled(false);
		telefoneCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		telefoneCliente.setColumns(10);
		telefoneCliente.setBounds(376, 338, 180, 25);
		getContentPane().add(telefoneCliente);
		
		cpfPesquisado = new JTextField();
		cpfPesquisado.setBounds(10, 122, 415, 25);
		getContentPane().add(cpfPesquisado);
		cpfPesquisado.setColumns(10);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF do Cliente para atualizar as informa\u00E7\u00F5es");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDigiteOCpf.setBounds(10, 82, 384, 31);
		getContentPane().add(lblDigiteOCpf);
		
		JLabel label = new JLabel("CEP:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(375, 230, 181, 25);
		getContentPane().add(label);
		
		cepCliente = new JTextField();
		cepCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cepCliente.setEnabled(false);
		cepCliente.setColumns(10);
		cepCliente.setBounds(375, 266, 181, 25);
		getContentPane().add(cepCliente);
		
		JLabel label_2 = new JLabel("Logradouro: ");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 230, 355, 25);
		getContentPane().add(label_2);
		
		enderecoCliente = new JTextField();
		enderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		enderecoCliente.setEnabled(false);
		enderecoCliente.setColumns(10);
		enderecoCliente.setBounds(10, 266, 355, 25);
		getContentPane().add(enderecoCliente);
		
		JLabel label_3 = new JLabel("UF:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(201, 302, 164, 25);
		getContentPane().add(label_3);
		
		ufCliente = new JTextField();
		ufCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ufCliente.setEnabled(false);
		ufCliente.setColumns(10);
		ufCliente.setBounds(201, 338, 165, 25);
		getContentPane().add(ufCliente);
		
		JLabel label_4 = new JLabel("Bairro:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(10, 302, 181, 25);
		getContentPane().add(label_4);
		
		bairroCliente = new JTextField();
		bairroCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bairroCliente.setEnabled(false);
		bairroCliente.setColumns(10);
		bairroCliente.setBounds(10, 338, 181, 25);
		getContentPane().add(bairroCliente);
		
		JButton btnLoad = new JButton("Carregar");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpfFieldText = cpfPesquisado.getText();
				Clientes cliente = clientes.retornaCliente(cpfFieldText);
				
				if (cliente == null){
					JOptionPane.showMessageDialog (null, "CPF NÃO ENCONTRADO");
					cpfPesquisado.setText("");
				} else {
					nomeCliente.setText(cliente.getNome());
					nomeCliente.setEnabled(true);
					
					
					cpfCliente.setText(cliente.getCpf());
					cpfCliente.setEnabled(true);
					
					cepCliente.setText(cliente.getCep());
					cepCliente.setEnabled(true);
					
					enderecoCliente.setText(cliente.getEndereco());
					enderecoCliente.setEnabled(true);
					
					ufCliente.setText(cliente.getUf());
					ufCliente.setEnabled(true);
					
					telefoneCliente.setText(cliente.getTelefone());
					telefoneCliente.setEnabled(true);
					
					bairroCliente.setText(cliente.getBairro());
					bairroCliente.setEnabled(true);
				}
				
			}
		});
		btnLoad.setBounds(436, 122, 120, 25);
		getContentPane().add(btnLoad);
		
		JButton btnAtualizar = new JButton("Atualizar Informa\u00E7\u00F5es");
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = nomeCliente.getText();
				String cpf = cpfCliente.getText();
				String endereco = enderecoCliente.getText();
				String cep = cepCliente.getText();
				String uf = ufCliente.getText();
				String bairro = bairroCliente.getText();
				String telefone = telefoneCliente.getText();
				
				String cpfPesquisadoString = cpfPesquisado.getText();
				clientes.alteraClienteNaLista(cpfPesquisadoString, nome, cpf, endereco, cep, bairro, uf, telefone);
				JOptionPane.showMessageDialog (null, "Alteração feita com Sucesso!!");
			}
		});
		btnAtualizar.setBounds(10, 385, 546, 37);
		getContentPane().add(btnAtualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAlterarCliente.this.setVisible(false);
			}
		});
		btnCancelar.setBounds(456, 433, 100, 32);
		getContentPane().add(btnCancelar);

	}
}
