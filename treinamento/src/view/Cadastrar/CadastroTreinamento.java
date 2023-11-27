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


import controller.api.TreinamentoController;
import controller.impl.TreinamentoControllerImpl;
import model.entidade.Treinamento;
import model.exception.AreaAbrangenciaInexistenteException;

public class CadastroTreinamento extends JFrame {
	
	private JPanel panel;
	private JTextField textFieldId;
	private JTextField textFieldNome;
	private JTextField textFieldDataInicio;
	private JTextField textFieldDataTermino;
	private JTextField textFieldCargaHoraria;
	
	private JTextField textFieldNotaFuncionario;
	private JTextField textFieldVigencia;
	private JTextField textFieldTreinamentoConcluido;
	private JTextField textFieldCusto;
	private JTextField textFieldFuncionarioId;
	private JTextField textFieldAreaAbrangenciaId;
	private JTextField textFieldCursoId;
	
	private JPanel panelLista;
	private JList<Treinamento> listTreinamentos;
	private DefaultListModel<Treinamento> listTreinamentoModel;
	
	private TreinamentoController treinamentoController;
	
	public CadastroTreinamento () {
		setTitle("Cadastro de Treinamentos");
		setLayout(new BorderLayout());
		
		treinamentoController = new TreinamentoControllerImpl();
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(500,3000));
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);

		
		criarTextFieldId("Código");
		criarTextFieldNome("Nome");
		criarTextFieldDataInicio("Data de Início");
		criarTextFieldDataTermino("Data de Término");
		criarTextFieldCargaHoraria("Carga Horária");
		
		criarTextFieldNotaFuncionario("Nota");
		criarTextFieldVigencia("Data de Vigência");
		criarTextFieldTreinamentoConcluido("Treinamento Concluido (0 ou 1)");
		criarTextFieldCusto("Custo");
		criarTextFieldFuncionarioId("Id do Funcionário");
		criarTextFieldAreaAbrangenciaId("Id da Área de Abrangência");
		criarTextFieldCursoId("Id do Curso");
		
		criarBotao("Salvar", new ButtonSalvarHandler());
		criarBotao("Excluir", new ButtonExcluirHandler());
		criarBotao("Buscar por Id", new ButtonBuscarPorIdHandler());
		criarBotao("Listar Todos", new ButtonListarHandler());
		criarBotao("Voltar", new ButtonVoltarHandler());
		
		setSize(500,800);
		setPreferredSize(new Dimension(500,3000));
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
	
	
	private void criarTextFieldNotaFuncionario(String label) {
		this.criarLabel(label);
		textFieldNotaFuncionario = new JTextField();
		textFieldNotaFuncionario.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldNotaFuncionario);
	}
	
	private void criarTextFieldVigencia(String label) {
		this.criarLabel(label);
		textFieldVigencia = new JTextField();
		textFieldVigencia.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldVigencia);
	}
	
	private void criarTextFieldTreinamentoConcluido(String label) {
		this.criarLabel(label);
		textFieldTreinamentoConcluido = new JTextField();
		textFieldTreinamentoConcluido.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldTreinamentoConcluido);
	}
	
	private void criarTextFieldCusto(String label) {
		this.criarLabel(label);
		textFieldCusto = new JTextField();
		textFieldCusto.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldCusto);
	}
	
	private void criarTextFieldFuncionarioId(String label) {
		this.criarLabel(label);
		textFieldFuncionarioId = new JTextField();
		textFieldFuncionarioId.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldFuncionarioId);
	}
	
	private void criarTextFieldAreaAbrangenciaId(String label) {
		this.criarLabel(label);
		textFieldAreaAbrangenciaId = new JTextField();
		textFieldAreaAbrangenciaId.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldAreaAbrangenciaId);
	}
	
	private void criarTextFieldCursoId(String label) {
		this.criarLabel(label);
		textFieldCursoId = new JTextField();
		textFieldCursoId.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldCursoId);
	}
	
	
	private void criarBotao(String label, ActionListener handler) {
		JButton button = new JButton(label);
		button.addActionListener(handler);
		button.setPreferredSize(new Dimension(200,50));
		panel.add(button);
	}
	
	private Treinamento criarObjetoTreinamento() {
		
		
		Treinamento treinamento = new Treinamento();
	

		
		if(!textFieldId.getText().isEmpty()) {
			treinamento.setIdTreinamento(Integer.parseInt(textFieldId.getText()));			
		}
		treinamento.setNomeCurso(textFieldNome.getText());
		treinamento.setDataInicio(textFieldDataInicio.getText());
		treinamento.setDataTermino(textFieldDataTermino.getText());
		treinamento.setCargaHoraria((textFieldCargaHoraria.getText()));
		
		treinamento.setNotaFuncionario(Integer.parseInt(textFieldNotaFuncionario.getText()));
		treinamento.setVigencia(textFieldVigencia.getText());
		treinamento.setTreinamentoConcluido(Boolean.parseBoolean(textFieldTreinamentoConcluido.getText()));
		treinamento.setCusto(Float.parseFloat(textFieldCusto.getText()));
		treinamento.setFuncionario_id(Integer.parseInt(textFieldFuncionarioId.getText()));
		treinamento.setAreaAbrangencia_id(Integer.parseInt(textFieldAreaAbrangenciaId.getText()));
		treinamento.setCurso_id(Integer.parseInt(textFieldCursoId.getText()));
		
		
		
		return treinamento;
	}
	
	private void limparCampos() {
		textFieldId.setText("");
		textFieldNome.setText("");
		textFieldDataInicio.setText("");
		textFieldDataTermino.setText("");
		textFieldCargaHoraria.setText("");
		
		textFieldNotaFuncionario.setText("");
		textFieldVigencia.setText("");
		textFieldTreinamentoConcluido.setText("");
		textFieldCusto.setText("");
		textFieldFuncionarioId.setText("");
		textFieldAreaAbrangenciaId.setText("");
		textFieldCursoId.setText("");
	}
	
	private class ButtonSalvarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Treinamento treinamento = criarObjetoTreinamento();
			treinamentoController.salvar(treinamento);
			limparCampos();
			JOptionPane.showMessageDialog(null, "Treinamento cadastrado com Sucesso!");
		}
	}
	
	private class ButtonExcluirHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				treinamentoController.excluir(Integer.parseInt(textFieldId.getText()));
				limparCampos();
				JOptionPane.showMessageDialog(null, "Treinamento excluido com sucesso!");
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
			new view.Listar.ListagemTreinamento();
			
		}
	}
	
	private class ButtonBuscarPorIdHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Treinamento treinamento = treinamentoController.buscarPorId(Integer.parseInt(textFieldId.getText()));
			textFieldId.setText(String.valueOf(treinamento.getIdTreinamento()));
			textFieldNome.setText(treinamento.getNomeCurso());
			textFieldDataInicio.setText(String.valueOf(treinamento.getDataInicio()));
			textFieldDataTermino.setText(String.valueOf(treinamento.getDataTermino()));
			textFieldCargaHoraria.setText(treinamento.getCargaHoraria());
			
			textFieldNotaFuncionario.setText(String.valueOf(treinamento.getNotaFuncionario()));
			textFieldVigencia.setText(treinamento.getVigencia());
			textFieldTreinamentoConcluido.setText(String.valueOf(treinamento.isTreinamentoConcluido()));
			textFieldCusto.setText(String.valueOf(treinamento.getCusto()));
			textFieldFuncionarioId.setText(String.valueOf(treinamento.getFuncionario_id()));
			textFieldAreaAbrangenciaId.setText(String.valueOf(treinamento.getAreaAbrangencia_id()));
			textFieldCursoId.setText(String.valueOf(treinamento.getCurso_id()));
			
		}
	}
	
	
	
	
	
private class ButtonVoltarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	}
	
	

}
