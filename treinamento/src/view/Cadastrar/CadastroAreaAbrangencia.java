package view.Cadastrar;

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
import view.Listar.ListagemAreaAbrangencia;

public class CadastroAreaAbrangencia extends JFrame {
	
	private JPanel panel;
	private JTextField textFieldId;
	private JTextField textFieldNome;
	
	private JPanel panelLista;
	private JList<AreaAbrangencia> listAreasAbrangencia;
	private DefaultListModel<AreaAbrangencia> listAreaAbrangenciaModel;
	
	private AreaAbrangenciaController areaAbrangenciaController;
	
	public CadastroAreaAbrangencia () {
		setTitle("Cadastro de Áreas de Abrangencia");
		setLayout(new FlowLayout());
		
		areaAbrangenciaController = new AreaAbrangenciaControllerImpl();
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setPreferredSize(new Dimension(500,800));
		add(panel);
		
		criarTextFieldId("Código");
		criarTextFieldNome("Nome");
		
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
	
	private void criarBotao(String label, ActionListener handler) {
		JButton button = new JButton(label);
		button.addActionListener(handler);
		button.setPreferredSize(new Dimension(200,50));
		panel.add(button);
	}
	
	private AreaAbrangencia criarObjetoAreaAbrangencia() {
		AreaAbrangencia areaAbrangencia = new AreaAbrangencia();
		if(!textFieldId.getText().isEmpty()) {
			areaAbrangencia.setIdAreaAbrangencia(Integer.parseInt(textFieldId.getText()));
		}
		areaAbrangencia.setNome(textFieldNome.getText());
		return areaAbrangencia;
	}
	
	private void limparCampos() {
		textFieldId.setText("");
		textFieldNome.setText("");
	}
	
	private class ButtonSalvarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			AreaAbrangencia areaAbrangencia = criarObjetoAreaAbrangencia();
			areaAbrangenciaController.salvar(areaAbrangencia);
			limparCampos();
			JOptionPane.showMessageDialog(null, "Area de Abrangencia cadastrada com Sucesso!");
		}
	}
	
	private class ButtonExcluirHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				areaAbrangenciaController.excluir(Integer.parseInt(textFieldId.getText()));
				limparCampos();
				JOptionPane.showMessageDialog(null, "Area de Abrangencia excluida com sucesso!");
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
			new ListagemAreaAbrangencia();
			
		}
	}
	
	private class ButtonBuscarPorIdHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			AreaAbrangencia areaAbrangencia = areaAbrangenciaController.buscarPorId(Integer.parseInt(textFieldId.getText()));
			textFieldId.setText(String.valueOf(areaAbrangencia.getIdAreaAbrangencia()));
			textFieldNome.setText(areaAbrangencia.getNome());
		}
	}
	

private class ButtonVoltarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	}
	

}
