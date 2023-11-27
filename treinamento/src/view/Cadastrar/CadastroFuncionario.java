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
import controller.api.FuncionarioController;
import controller.impl.AreaAbrangenciaControllerImpl;
import controller.impl.CursoControllerImpl;
import controller.impl.FuncionarioControllerImpl;
import model.entidade.AreaAbrangencia;
import model.entidade.Curso;
import model.entidade.Funcionario;
import model.exception.AreaAbrangenciaInexistenteException;

public class CadastroFuncionario extends JFrame {
	
	private JPanel panel;
	private JTextField textFieldId;
	private JTextField textFieldNome;
	private JTextField textFieldDataNascimento;
	private JTextField textFieldCpf;
	private JTextField textFieldEmail;
	
	private JTextField textFieldDataAdmissao;
	private JTextField textFieldCargo;
	private JTextField textFieldFuncao;
	private JTextField textFieldFormacao;
	private JTextField textFieldAcessibilidade;
	
	private JPanel panelLista;
	private JList<Funcionario> listFuncionarios;
	private DefaultListModel<Funcionario> listFuncionarioModel;
	
	private FuncionarioController funcionarioController;
	
	public CadastroFuncionario () {
		setTitle("Cadastro de Funcionarios");
		setLayout(new BorderLayout());
		
		funcionarioController = new FuncionarioControllerImpl();
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(500,2000));
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);
		
		criarTextFieldId("Código");
		criarTextFieldNome("Nome");
		criarTextFieldDataNascimento("Data de Nascimento");
		criarTextFieldCpf("CPF");
		criarTextFieldEmail("E-mail");
		
		criarTextFieldDataAdmissao("Data de Admissão");
		criarTextFieldCargo("Cargo");
		criarTextFieldFuncao("Função");
		criarTextFieldFormacao("Formação");
		criarTextFieldAcessibilidade("Acessibilidade (0 ou 1)");
		
		criarBotao("Salvar", new ButtonSalvarHandler());
		criarBotao("Excluir", new ButtonExcluirHandler());
		criarBotao("Buscar por Id", new ButtonBuscarPorIdHandler());
		criarBotao("Listar Todos", new ButtonListarHandler());
		criarBotao("Voltar", new ButtonVoltarHandler());
		
		setSize(500,800);
		setPreferredSize(new Dimension(500,2000));
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
	
	private void criarTextFieldDataNascimento(String label) {
		this.criarLabel(label);
		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldDataNascimento);
	}
	
	private void criarTextFieldCpf(String label) {
		this.criarLabel(label);
		textFieldCpf = new JTextField();
		textFieldCpf.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldCpf);
	}
	
	private void criarTextFieldEmail(String label) {
		this.criarLabel(label);
		textFieldEmail = new JTextField();
		textFieldEmail.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldEmail);
	}
	
	
	
	private void criarTextFieldDataAdmissao(String label) {
		this.criarLabel(label);
		textFieldDataAdmissao = new JTextField();
		textFieldDataAdmissao.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldDataAdmissao);
	}
	
	private void criarTextFieldCargo(String label) {
		this.criarLabel(label);
		textFieldCargo = new JTextField();
		textFieldCargo.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldCargo);
	}
	
	private void criarTextFieldFuncao(String label) {
		this.criarLabel(label);
		textFieldFuncao = new JTextField();
		textFieldFuncao.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldFuncao);
	}
	
	private void criarTextFieldFormacao(String label) {
		this.criarLabel(label);
		textFieldFormacao = new JTextField();
		textFieldFormacao.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldFormacao);
	}
	
	private void criarTextFieldAcessibilidade(String label) {
		this.criarLabel(label);
		textFieldAcessibilidade = new JTextField();
		textFieldAcessibilidade.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldAcessibilidade);
	}
	
	private void criarBotao(String label, ActionListener handler) {
		JButton button = new JButton(label);
		button.addActionListener(handler);
		button.setPreferredSize(new Dimension(200,50));
		panel.add(button);
	}
	
	private Funcionario criarObjetoFuncionario() {
		
		
		Funcionario funcionario = new Funcionario();
	
		
		if(!textFieldId.getText().isEmpty()) {
			funcionario.setIdFuncionario(Integer.parseInt(textFieldId.getText()));			
		}
		funcionario.setNome(textFieldNome.getText());
		funcionario.setDataNascimento(textFieldDataNascimento.getText());
		funcionario.setCpf(textFieldCpf.getText());
		funcionario.setEmail(textFieldEmail.getText());
		
		funcionario.setDataAdmissao(textFieldDataAdmissao.getText());
		funcionario.setCargo(textFieldCargo.getText());
		funcionario.setFuncao(textFieldFuncao.getText());
		funcionario.setFormacao(textFieldFormacao.getText());
		funcionario.setAcessibilidade(Boolean.parseBoolean(textFieldAcessibilidade.getText()));
		
		
		
		return funcionario;
	}
	
	private void limparCampos() {
		textFieldId.setText("");
		textFieldNome.setText("");
		textFieldDataNascimento.setText("");
		textFieldCpf.setText("");
		textFieldEmail.setText("");
		
		textFieldDataAdmissao.setText("");
		textFieldCargo.setText("");
		textFieldFuncao.setText("");
		textFieldFormacao.setText("");
		textFieldAcessibilidade.setText("");
		
	}
	
	private class ButtonSalvarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Funcionario funcionario = criarObjetoFuncionario();
			funcionarioController.salvar(funcionario);
			limparCampos();
			JOptionPane.showMessageDialog(null, "Funcionario cadastrado com Sucesso!");
		}
	}
	
	private class ButtonExcluirHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				funcionarioController.excluir(Integer.parseInt(textFieldId.getText()));
				limparCampos();
				JOptionPane.showMessageDialog(null, "Funcionário excluido com sucesso!");
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
			new view.Listar.ListagemFuncionario();
		}
	}
	
	private class ButtonBuscarPorIdHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Funcionario funcionario = funcionarioController.buscarPorId(Integer.parseInt(textFieldId.getText()));
			textFieldId.setText(String.valueOf(funcionario.getIdFuncionario()));
			textFieldNome.setText(funcionario.getNome());
			textFieldDataNascimento.setText(String.valueOf(funcionario.getDataNascimento()));
			textFieldCpf.setText(String.valueOf(funcionario.getCpf()));
			textFieldEmail.setText(funcionario.getEmail());
			
			textFieldDataAdmissao.setText(funcionario.getDataAdmissao());
			textFieldCargo.setText(funcionario.getCargo());
			textFieldFuncao.setText(funcionario.getFuncao());
			textFieldFormacao.setText(funcionario.getFormacao());
			textFieldAcessibilidade.setText(String.valueOf(funcionario.isAcessibilidade()));
		}
	}
	
	
private class ButtonVoltarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	}
	
	

}
