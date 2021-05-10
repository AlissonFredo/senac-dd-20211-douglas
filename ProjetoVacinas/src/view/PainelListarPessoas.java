package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.ControllerPessoa;
import model.vo.PessoaVO;
import model.vo.VacinaVO;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class PainelListarPessoas extends JPanel {
	private String[] nomesColunas = { "nome", "Sexo", "Cpf", "Data nasc", "Tipo"};
	private JTable table;
	ControllerPessoa controllerPessoa = new ControllerPessoa();
	List<PessoaVO> pessoas = new ArrayList<PessoaVO>();
	PessoaVO pessoaVO = new PessoaVO();
	private JButton btnExcluir;
	private JButton btnEditar;
	
	

	/**
	 * Create the panel.
	 */
	public PainelListarPessoas() {
		setLayout(null);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTela();
			}
		});
		btnConsultar.setBounds(321, 12, 117, 25);
		add(btnConsultar);
		
		table = new JTable();
		table.setBounds(12, 49, 426, 185);
		add(table);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoaVO = pessoas.get(table.getSelectedRow() -1);
				String mensagem = "Tem certeza que quer excluir \n" + pessoaVO.toString() + "?";
				int opcaoSelect = JOptionPane.showConfirmDialog(null, mensagem, "Tem certeza?", JOptionPane.YES_NO_OPTION);
				
				if (opcaoSelect == JOptionPane.YES_NO_OPTION) {
					
				}
			}
		});
		btnExcluir.setBounds(321, 246, 117, 25);
		add(btnExcluir);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(198, 246, 117, 25);
		add(btnEditar);
		
		this.limparTabela();
	}

	protected void atualizarTela() {
		this.limparTabela();
		pessoas = controllerPessoa.consultarTodosPessoaController();
		DefaultTableModel model = (DefaultTableModel) this.table.getModel();
		
		for (PessoaVO pessoa: pessoas) {
			Object[] novaLinha = new Object[6];
			novaLinha[0] = pessoa.getNome();
			novaLinha[1] = pessoa.getSexo();
			novaLinha[2] = pessoa.getCpf();
			novaLinha[3] = pessoa.getDataNacimento();
			novaLinha[4] = pessoa.getTipo();
			model.addRow(novaLinha);
		}
	}

	protected void limparTabela() {
		table.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
		//btnExcluir.setEnabled(false);
		//btnEditar.setEnabled(false);
	}
}
