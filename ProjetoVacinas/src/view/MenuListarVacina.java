package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControllerVacina;
import model.vo.VacinaVO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuListarVacina extends JFrame {

	private JPanel contentPane;
	private JTable tableVacinas;
	private String[] nomesColunas = { "nome", "pais de origem", "estagio", "data inicio", "fase", "quantidade" };
	ControllerVacina controllerVacina = new ControllerVacina();
	ArrayList<VacinaVO> vacinas = new ArrayList<VacinaVO>();
	VacinaVO vacinaVO = new VacinaVO();
	private JButton btnExcluir;
	private JButton btnEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuListarVacina frame = new MenuListarVacina();
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
	public MenuListarVacina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnConsultarVacinas = new JButton("Consultar vacinas");
		btnConsultarVacinas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarTela();
			}
		});
		btnConsultarVacinas.setBounds(555, 20, 169, 25);
		contentPane.add(btnConsultarVacinas);

		tableVacinas = new JTable();
		tableVacinas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableVacinas.getSelectedRow() > 0) {
					btnExcluir.setEnabled(true);
					btnEditar.setEnabled(true);
				}else {
					btnExcluir.setEnabled(false);
					btnEditar.setEnabled(false);
				}
			}
		});
		
		tableVacinas.setBounds(28, 57, 696, 192);
		contentPane.add(tableVacinas);

		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vacinaVO = vacinas.get(tableVacinas.getSelectedRow() - 1);
				String mensagemExcluir = "Realmente deseja excluir a vacina " + vacinaVO.toString() + "?";
				int opcaoSelect = JOptionPane.showConfirmDialog(null, mensagemExcluir, "Tem certeza?",
						JOptionPane.YES_NO_OPTION);
				if (opcaoSelect == JOptionPane.YES_OPTION) {
					String mensagem = controllerVacina.excluirVacinaController(vacinaVO);
					JOptionPane.showMessageDialog(null, mensagem);
					atualizarTela();
				}
			}
		});
		btnExcluir.setBounds(607, 261, 117, 25);
		contentPane.add(btnExcluir);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(478, 261, 117, 25);
		contentPane.add(btnEditar);
		
		this.limparTabela();
	}

	protected void atualizarTela() {
		this.limparTabela();
		vacinas = controllerVacina.consultarTodasVacinas();
		DefaultTableModel model = (DefaultTableModel) this.tableVacinas.getModel();

		for (VacinaVO vacina : vacinas) {
			Object[] novaLinha = new Object[6];
			novaLinha[0] = vacina.getNomeVacina();
			novaLinha[1] = vacina.getPaisOrigem();
			novaLinha[2] = vacina.getEstagioPesquisa();
			novaLinha[3] = vacina.getDataInicio();

			novaLinha[4] = vacina.getFase();
			novaLinha[5] = vacina.getQuantidadeDoses();
			model.addRow(novaLinha);
		}
	}

	protected void limparTabela() {
		tableVacinas.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
		btnExcluir.setEnabled(false);
		btnEditar.setEnabled(false);
	}
}
