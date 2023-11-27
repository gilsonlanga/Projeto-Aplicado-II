package view.Cadastrar;

import java.awt.BorderLayout;
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
import controller.impl.AreaAbrangenciaControllerImpl;
import controller.impl.CursoControllerImpl;
import model.entidade.AreaAbrangencia;
import model.entidade.Curso;
import model.exception.AreaAbrangenciaInexistenteException;

public class CadastroCurso extends JFrame {
	
	private JPanel panel;
	private JTextField textFieldId;
	private JTextField textFieldNome;
	private JTextField textFieldDataInicio;
	private JTextField textFieldDataTermino;
	private JTextField textFieldCargaHoraria;
	
	private JTextField textFieldInstrutorId;
	private JTextField textFieldInstrutorInstituicaoId;
	
	private JPanel panelLista;
	private JList<Curso> listCursos;
	private DefaultListModel<Curso> listCursoModel;
	
	private CursoController cursoController;
	
	public CadastroCurso () {
		setTitle("Cadastro de Cursos");
		setLayout(new BorderLayout());
		
		cursoController = new CursoControllerImpl();
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(500,1000));
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);
		
		criarTextFieldId("Código");
		criarTextFieldNome("Nome");
		criarTextFieldDataInicio("Data Início");
		criarTextFieldDataTermino("Data Término");
		criarTextFieldCargaHoraria("Carga Horária");
		
		criarTextFieldInstrutorId("Id Instrutor");
		criarTextFieldInstrutorInstituicaoId("Id Instrutor-Instituição");
		
		
		criarBotao("Salvar", new ButtonSalvarHandler());
		criarBotao("Excluir", new ButtonExcluirHandler());
		criarBotao("Buscar por Id", new ButtonBuscarPorIdHandler());
		criarBotao("Listar Todos", new ButtonListarHandler());
		criarBotao("Voltar", new ButtonVoltarHandler());
		
		setSize(500,800);
		setPreferredSize(new Dimension(500,1000));
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
	
	private void criarTextFieldDataInicio(String label) {
		this.criarLabel(label);
		textFieldDataInicio = new JTextField();
		textFieldDataInicio.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldDataInicio);
	}
	
	private void criarTextFieldDataTermino(String label) {
		this.criarLabel(label);
		textFieldDataTermino = new JTextField();
		textFieldDataTermino.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldDataTermino);
	}
	
	private void criarTextFieldCargaHoraria(String label) {
		this.criarLabel(label);
		textFieldCargaHoraria = new JTextField();
		textFieldCargaHoraria.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldCargaHoraria);
	}
	
	
	private void criarTextFieldInstrutorId(String label) {
		this.criarLabel(label);
		textFieldInstrutorId = new JTextField();
		textFieldInstrutorId.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldInstrutorId);
	}
	
	private void criarTextFieldInstrutorInstituicaoId(String label) {
		this.criarLabel(label);
		textFieldInstrutorInstituicaoId = new JTextField();
		textFieldInstrutorInstituicaoId.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldInstrutorInstituicaoId);
	}
	
	
	
	private void criarBotao(String label, ActionListener handler) {
		JButton button = new JButton(label);
		button.addActionListener(handler);
		button.setPreferredSize(new Dimension(200,50));
		panel.add(button);
	}
	
	private Curso criarObjetoCurso() {
		
		
		Curso curso = new Curso();
		
	

		
		if(!textFieldId.getText().isEmpty()) {
			curso.setIdCurso(Integer.parseInt(textFieldId.getText()));			
		}
		curso.setNome(textFieldNome.getText());
		curso.setDataInicio(textFieldDataInicio.getText());
		curso.setDataTermino(textFieldDataTermino.getText());
		curso.setCargaHoraria((textFieldCargaHoraria.getText()));
		
		curso.setInstrutor_id(Integer.parseInt(textFieldInstrutorId.getText()));
		curso.setInstrutor_instituicao_id(Integer.parseInt(textFieldInstrutorInstituicaoId.getText()));
		
				
		return curso;
	}
	
	private void limparCampos() {
		textFieldId.setText("");
		textFieldNome.setText("");
		textFieldDataInicio.setText("");
		textFieldDataTermino.setText("");
		textFieldCargaHoraria.setText("");
		textFieldInstrutorId.setText("");
		textFieldInstrutorInstituicaoId.setText("");
	}
	
	private class ButtonSalvarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Curso curso = criarObjetoCurso();
			cursoController.salvar(curso);
			limparCampos();
			JOptionPane.showMessageDialog(null, "Curso cadastrado com Sucesso!");
		}
	}
	
	private class ButtonExcluirHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				cursoController.excluir(Integer.parseInt(textFieldId.getText()));
				limparCampos();
				JOptionPane.showMessageDialog(null, "Curso excluido com sucesso!");
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
			new view.Listar.ListagemCurso();
			
		}
	}
	
	private class ButtonBuscarPorIdHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Curso curso = cursoController.buscarPorId(Integer.parseInt(textFieldId.getText()));
			textFieldId.setText(String.valueOf(curso.getIdCurso()));
			textFieldNome.setText(curso.getNome());
			textFieldDataInicio.setText(String.valueOf(curso.getDataInicio()));
			textFieldDataTermino.setText(String.valueOf(curso.getDataTermino()));
			textFieldCargaHoraria.setText(curso.getCargaHoraria());
			
			textFieldInstrutorId.setText(String.valueOf(curso.getInstrutor_id()));
			textFieldInstrutorInstituicaoId.setText(String.valueOf(curso.getInstrutor_instituicao_id()));
		}
	}
	
	
	
private class ButtonVoltarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	}
	
	

}
