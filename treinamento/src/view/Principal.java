package view;

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

public class Principal extends JFrame {
	
	private JPanel panel;

	
	private AreaAbrangenciaController areaAbrangenciaController;
	
	
	public Principal () {
		setTitle("Sistema - Treinamentos");
		setLayout(new FlowLayout());
		
		areaAbrangenciaController = new AreaAbrangenciaControllerImpl();
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(500,800));
		add(panel);
		
		
		
		criarBotao("Cadastrar/Alterar", new ButtonCadastrarHandler());
		criarBotao("Listar", new ButtonListarHandler());
		criarBotao("Pesquisar Treinamentos", new ButtonPesquisarHandler());
		criarBotao("Sair", new ButtonSairHandler());
		
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
	
	
	
	private class ButtonCadastrarHandler implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			new view.Cadastrar.Cadastrar();
			
		}

	}
	
	
	
	private class ButtonListarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new view.Listar.Listar();
			
		}

	}
	
	
	
	private class ButtonPesquisarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new view.Pesquisar.Pesquisar();
			
			
		}
	}
	

	
	
	private class ButtonSairHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
	
	
	public static void main(String[] args) {
		new Principal();
	}
	

}
