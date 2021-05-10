package view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelCadastrarPessoa extends JPanel {
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfDataNasc;
	private JComboBox cbSexo;
	private JComboBox cbTipo;

	/**
	 * Create the panel.
	 */
	public PainelCadastrarPessoa() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.WEST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 1;
		gbc_lblNome.gridy = 3;
		add(lblNome, gbc_lblNome);
		
		tfNome = new JTextField();
		GridBagConstraints gbc_tfNome = new GridBagConstraints();
		gbc_tfNome.anchor = GridBagConstraints.WEST;
		gbc_tfNome.insets = new Insets(0, 0, 5, 0);
		gbc_tfNome.gridx = 3;
		gbc_tfNome.gridy = 3;
		add(tfNome, gbc_tfNome);
		tfNome.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.WEST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 1;
		gbc_lblSexo.gridy = 4;
		add(lblSexo, gbc_lblSexo);
		
		cbSexo = new JComboBox();
		GridBagConstraints gbc_cbSexo = new GridBagConstraints();
		gbc_cbSexo.anchor = GridBagConstraints.WEST;
		gbc_cbSexo.insets = new Insets(0, 0, 5, 0);
		gbc_cbSexo.gridx = 3;
		gbc_cbSexo.gridy = 4;
		add(cbSexo, gbc_cbSexo);
		cbSexo.addItem("<selecione opção>");
		cbSexo.addItem("Masculino");
		cbSexo.addItem("Feminino");
		
		JLabel lblCpf = new JLabel("Cpf:");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.WEST;
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 1;
		gbc_lblCpf.gridy = 5;
		add(lblCpf, gbc_lblCpf);
		
		tfCpf = new JTextField();
		GridBagConstraints gbc_tfCpf = new GridBagConstraints();
		gbc_tfCpf.insets = new Insets(0, 0, 5, 0);
		gbc_tfCpf.anchor = GridBagConstraints.WEST;
		gbc_tfCpf.gridx = 3;
		gbc_tfCpf.gridy = 5;
		add(tfCpf, gbc_tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblDataNasc = new JLabel("Data nasc:");
		GridBagConstraints gbc_lblDataNasc = new GridBagConstraints();
		gbc_lblDataNasc.anchor = GridBagConstraints.WEST;
		gbc_lblDataNasc.insets = new Insets(0, 0, 5, 5);
		gbc_lblDataNasc.gridx = 1;
		gbc_lblDataNasc.gridy = 6;
		add(lblDataNasc, gbc_lblDataNasc);
		
		tfDataNasc = new JTextField();
		GridBagConstraints gbc_tfDataNasc = new GridBagConstraints();
		gbc_tfDataNasc.insets = new Insets(0, 0, 5, 0);
		gbc_tfDataNasc.anchor = GridBagConstraints.WEST;
		gbc_tfDataNasc.gridx = 3;
		gbc_tfDataNasc.gridy = 6;
		add(tfDataNasc, gbc_tfDataNasc);
		tfDataNasc.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		GridBagConstraints gbc_lblTipo = new GridBagConstraints();
		gbc_lblTipo.anchor = GridBagConstraints.WEST;
		gbc_lblTipo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipo.gridx = 1;
		gbc_lblTipo.gridy = 7;
		add(lblTipo, gbc_lblTipo);
		
		cbTipo = new JComboBox();
		GridBagConstraints gbc_cbTipo = new GridBagConstraints();
		gbc_cbTipo.insets = new Insets(0, 0, 5, 0);
		gbc_cbTipo.anchor = GridBagConstraints.WEST;
		gbc_cbTipo.gridx = 3;
		gbc_cbTipo.gridy = 7;
		add(cbTipo, gbc_cbTipo);
		cbTipo.addItem("<selecione opção>");
		cbTipo.addItem("Pesquisador");
		cbTipo.addItem("Não pesquisador");
		
		JButton btnSalvarPessoa = new JButton("Salvar");
		btnSalvarPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarPessoa();
			}
		});
		GridBagConstraints gbc_btnSalvarPessoa = new GridBagConstraints();
		gbc_btnSalvarPessoa.gridx = 3;
		gbc_btnSalvarPessoa.gridy = 9;
		add(btnSalvarPessoa, gbc_btnSalvarPessoa);

	}

	protected void cadastrarPessoa() {
		
	}

}
