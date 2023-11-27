package view.Listar;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import controller.impl.AreaAbrangenciaControllerImpl;
import model.entidade.AreaAbrangencia;
import model.exception.AreaAbrangenciaInexistenteException;
import view.Cadastrar.CadastroAreaAbrangencia;
import view.Cadastrar.CadastroCurso;
import view.Cadastrar.CadastroFuncionario;
import view.Cadastrar.CadastroInstituicao;
import view.Cadastrar.CadastroInstrutor;
import view.Cadastrar.CadastroTreinamento;
import view.Listar.ListagemAreaAbrangencia;

public class Listar extends JFrame {
	
	private JPanel panel;
	
	
	private AreaAbrangenciaController areaAbrangenciaController;
	
	
	public Listar () {
		setTitle("Tela Listar");
		setLayout(new FlowLayout());
		
		areaAbrangenciaController = new AreaAbrangenciaControllerImpl();
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(500,800));
		add(panel);
		
		
		criarBotao("Listar Áreas de Abrangência", new ButtonAreaAbrangenciaHandler());
		criarBotao("Listar Cursos", new ButtonCursoHandler());
		criarBotao("Listar Funcionários", new ButtonFuncionarioHandler());
		criarBotao("Listar Instituições", new ButtonInstituicaoHandler());
		criarBotao("Listar Instrutores", new ButtonInstrutorHandler());
		criarBotao("Listar Treinamentos", new ButtonTreinamentoHandler());
		criarBotao("Voltar", new ButtonVoltarHandler());
		
		setSize(500,800);
		setPreferredSize(new Dimension(500,800));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	private void criarBotao(String label, ActionListener handler) {
		JButton button = new JButton(label);
		button.addActionListener(handler);
		button.setPreferredSize(new Dimension(300,50));
		panel.add(button);
	}
	
	
	
	private class ButtonAreaAbrangenciaHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new ListagemAreaAbrangencia();
		}
	}
		
	
	private class ButtonCursoHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new ListagemCurso();
			
		}
		
		
		
	}
	
	
	
	private class ButtonInstituicaoHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new ListagemInstituicao();
		
			
		}
	}
	
	
	private class ButtonFuncionarioHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new ListagemFuncionario();
			
		}
	}
	
	
	
	
	private class ButtonInstrutorHandler implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ListagemInstrutor();
			}
		
		
		
	}


	private class ButtonTreinamentoHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new ListagemTreinamento();
		}
		
		
		
	}
	
	private class ButtonVoltarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	}

	

}
