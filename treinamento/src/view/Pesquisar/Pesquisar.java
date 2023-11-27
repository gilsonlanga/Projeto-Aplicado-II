package view.Pesquisar;

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

public class Pesquisar extends JFrame {
	
	private JPanel panel;
	
	
	private AreaAbrangenciaController areaAbrangenciaController;
	
	
	public Pesquisar () {
		setTitle("Tela Pesquisar Treinamentos");
		setLayout(new FlowLayout());
		
		areaAbrangenciaController = new AreaAbrangenciaControllerImpl();
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(500,800));
		add(panel);
		
		criarBotao("Pesquisar por Curso", new ButtonNomeHandler());
		criarBotao("Pesquisar por Vigência", new ButtonVigenciaHandler());
		criarBotao("Pesquisar por Funcionário", new ButtonFuncionarioHandler());
		criarBotao("Pesquisar por Data de Término", new ButtonDataTerminoHandler());
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
	

	
	
	private class ButtonNomeHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new view.Pesquisar.PesquisaNome();
			
		}
		
		
	}
	
	
	
	private class ButtonVigenciaHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new view.Pesquisar.PesquisaVigencia();
			

		}

	}
	
	
	
	private class ButtonFuncionarioHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new view.Pesquisar.PesquisaFuncionario();
			
		}
	}
	
	
	private class ButtonDataTerminoHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new view.Pesquisar.PesquisaDataTermino();
			
		}
	}
	
	

private class ButtonVoltarHandler implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false);
	}
	
}


}
