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
import controller.api.InstituicaoController;
import controller.impl.AreaAbrangenciaControllerImpl;
import controller.impl.CursoControllerImpl;
import controller.impl.InstituicaoControllerImpl;
import model.entidade.AreaAbrangencia;
import model.entidade.Curso;
import model.entidade.Instituicao;
import model.exception.AreaAbrangenciaInexistenteException;

public class CadastroInstituicao extends JFrame {
	
	private JPanel panel;
	private JTextField textFieldId;
	private JTextField textFieldNome;
	private JTextField textFieldEndereco;
	private JTextField textFieldCidade;
	private JTextField textFieldEstado;
	private JTextField textFieldContato;
	private JTextField textFieldInterno;
	
	private JPanel panelLista;
	private JList<Instituicao> listInstituicoes;
	private DefaultListModel<Instituicao> listInstituicaoModel;
	
	private InstituicaoController instituicaoController;
	
	public CadastroInstituicao () {
		setTitle("Cadastro de Instituições");
		setLayout(new BorderLayout());
		
		instituicaoController = new InstituicaoControllerImpl();
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(500,800));
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);
		
		criarTextFieldId("Código");
		criarTextFieldNome("Nome");
		criarTextFieldEndereco("Endereço");
		criarTextFieldCidade("Cidade");
		criarTextFieldEstado("Estado");
		criarTextFieldContato("Contato");
		criarTextFieldInterno("Interno - (0 ou 1)");
		
		
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
	
	private void criarTextFieldEndereco(String label) {
		this.criarLabel(label);
		textFieldEndereco = new JTextField();
		textFieldEndereco.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldEndereco);
	}
	
	private void criarTextFieldCidade(String label) {
		this.criarLabel(label);
		textFieldCidade = new JTextField();
		textFieldCidade.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldCidade);
	}
	
	private void criarTextFieldEstado(String label) {
		this.criarLabel(label);
		textFieldEstado = new JTextField();
		textFieldEstado.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldEstado);
	}
	
	private void criarTextFieldContato(String label) {
		this.criarLabel(label);
		textFieldContato = new JTextField();
		textFieldContato.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldContato);
	}
	
	private void criarTextFieldInterno(String label) {
		this.criarLabel(label);
		textFieldInterno = new JTextField();
		textFieldInterno.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldInterno);
	}
	
	
	private void criarBotao(String label, ActionListener handler) {
		JButton button = new JButton(label);
		button.addActionListener(handler);
		button.setPreferredSize(new Dimension(200,50));
		panel.add(button);
	}
	
	private Instituicao criarObjetoInstituicao() {
		
		
		Instituicao instituicao = new Instituicao();
	

		
		if(!textFieldId.getText().isEmpty()) {
			instituicao.setIdInstituicao(Integer.parseInt(textFieldId.getText()));			
		}
		instituicao.setNome(textFieldNome.getText());
		instituicao.setEndereco(textFieldEndereco.getText());
		instituicao.setCidade(textFieldCidade.getText());
		instituicao.setEstado((textFieldEstado.getText()));
		instituicao.setContato(textFieldContato.getText());
		instituicao.setInterno(Boolean.parseBoolean(textFieldInterno.getText()));
		

		
		
		return instituicao;
	}
	
	private void limparCampos() {
		textFieldId.setText("");
		textFieldNome.setText("");
		textFieldEndereco.setText("");
		textFieldCidade.setText("");
		textFieldEstado.setText("");
		textFieldContato.setText("");
		textFieldInterno.setText("");
	}
	
	private class ButtonSalvarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Instituicao instituicao = criarObjetoInstituicao();
			instituicaoController.salvar(instituicao);
			limparCampos();
			JOptionPane.showMessageDialog(null, "Instituição cadastrada com Sucesso!");
		}
	}
	
	private class ButtonExcluirHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				instituicaoController.excluir(Integer.parseInt(textFieldId.getText()));
				limparCampos();
				JOptionPane.showMessageDialog(null, "Instituição excluida com sucesso!");
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
			new view.Listar.ListagemInstituicao();

			
		}
	}
	
	private class ButtonBuscarPorIdHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Instituicao instituicao = instituicaoController.buscarPorId(Integer.parseInt(textFieldId.getText()));
			textFieldId.setText(String.valueOf(instituicao.getIdInstituicao()));
			textFieldNome.setText(instituicao.getNome());
			textFieldEndereco.setText(instituicao.getEndereco());
			textFieldCidade.setText(instituicao.getCidade());
			textFieldEstado.setText(instituicao.getEstado());
			textFieldContato.setText(instituicao.getContato());
			textFieldInterno.setText(String.valueOf(instituicao.isInterno()));
		}
	}
	

	
private class ButtonVoltarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	}
	
	

}
