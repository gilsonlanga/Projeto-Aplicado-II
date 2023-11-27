package view.Cadastrar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.api.AreaAbrangenciaController;
import controller.api.CursoController;
import controller.api.InstrutorController;
import controller.impl.AreaAbrangenciaControllerImpl;
import controller.impl.CursoControllerImpl;
import controller.impl.InstrutorControllerImpl;
import model.entidade.AreaAbrangencia;
import model.entidade.Curso;
import model.entidade.Instrutor;
import model.exception.AreaAbrangenciaInexistenteException;

public class CadastroInstrutor extends JFrame {
	
	private JPanel panel;
	private JTextField textFieldId;
	private JTextField textFieldNome;
	private JTextField textFieldFormacao;
	private JTextField textFieldInstituicaoId;
	
	private JPanel panelLista;
	private JList<Curso> listInstrutores;
	private DefaultListModel<Curso> listInstrutorModel;
	
	private InstrutorController instrutorController;
	
	public CadastroInstrutor () {
		setTitle("Cadastro de Instrutores");
		setLayout(new FlowLayout());
		
		instrutorController = new InstrutorControllerImpl();
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(500,800));
		add(panel);
		
		criarTextFieldId("Código");
		criarTextFieldNome("Nome");
		criarTextFieldFormacao("Formação");
		criarTextFieldInstituicaoId("Id da Instituição");

		
		criarBotao("Salvar", new ButtonSalvarHandler());
		criarBotao("Excluir", new ButtonExcluirHandler());
		criarBotao("Buscar por Id", new ButtonBuscarPorIdHandler());
		criarBotao("Listar Todos", new ButtonListarHandler());
		criarBotao("Voltar", new ButtonVoltarHandler());
		
		setSize(500,800);
		setPreferredSize(new Dimension(500,800));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void criarLabel(String texto) {
		JLabel label = new JLabel(texto);
		label.setPreferredSize(new Dimension(400,40));
		panel.add(label);
	}
	
	private void criarTextFieldId(String label) {
		this.criarLabel(label);
		textFieldId = new JTextField();
		textFieldId.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldId);
	}
	
	private void criarTextFieldNome(String label) {
		this.criarLabel(label);
		textFieldNome = new JTextField();
		textFieldNome.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldNome);
	}
	
	private void criarTextFieldFormacao(String label) {
		this.criarLabel(label);
		textFieldFormacao = new JTextField();
		textFieldFormacao.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldFormacao);
	}
	
	private void criarTextFieldInstituicaoId(String label) {
		this.criarLabel(label);
		textFieldInstituicaoId = new JTextField();
		textFieldInstituicaoId.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldInstituicaoId);
	}
	
	
	private void criarBotao(String label, ActionListener handler) {
		JButton button = new JButton(label);
		button.addActionListener(handler);
		button.setPreferredSize(new Dimension(200,50));
		panel.add(button);
	}
	
	private Instrutor criarObjetoInstrutor() {
		
		
		Instrutor instrutor = new Instrutor();
	

		
		if(!textFieldId.getText().isEmpty()) {
			instrutor.setIdInstrutor(Integer.parseInt(textFieldId.getText()));			
		}
		instrutor.setNome(textFieldNome.getText());
		instrutor.setFormacao(textFieldFormacao.getText());
		instrutor.setInstituicao_id(Integer.parseInt(textFieldInstituicaoId.getText()));
		
		
		return instrutor;
	}
	
	private void limparCampos() {
		textFieldId.setText("");
		textFieldNome.setText("");
		textFieldFormacao.setText("");
		textFieldInstituicaoId.setText("");

	}
	
	private class ButtonSalvarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Instrutor instrutor = criarObjetoInstrutor();
			instrutorController.salvar(instrutor);
			limparCampos();
			JOptionPane.showMessageDialog(null, "Instrutor cadastrado com Sucesso!");
		}
	}
	
	private class ButtonExcluirHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				instrutorController.excluir(Integer.parseInt(textFieldId.getText()));
				limparCampos();
				JOptionPane.showMessageDialog(null, "Instrutor excluido com sucesso!");
			} catch (AreaAbrangenciaInexistenteException exception) {
				JOptionPane.showMessageDialog(null, exception.getMessage());
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "É obrigatório informar um valor numérico no id para exclusão!");
			}
		}
	}
	
	private class ButtonListarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new view.Listar.ListagemInstrutor();
			
			
		}
	}
	
	private class ButtonBuscarPorIdHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Instrutor instrutor = instrutorController.buscarPorId(Integer.parseInt(textFieldId.getText()));
			textFieldId.setText(String.valueOf(instrutor.getIdInstrutor()));
			textFieldNome.setText(instrutor.getNome());
			textFieldFormacao.setText(instrutor.getFormacao());
			textFieldInstituicaoId.setText(String.valueOf(instrutor.getInstituicao_id()));;
		}
	}
	
	
	
private class ButtonVoltarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	}
	
	
}
