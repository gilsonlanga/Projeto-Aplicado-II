package view.Pesquisar;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.api.CursoController;
import controller.api.TreinamentoController;
import controller.impl.CursoControllerImpl;
import controller.impl.TreinamentoControllerImpl;
import model.entidade.Curso;
import model.entidade.Treinamento;

public class PesquisaFuncionario extends JFrame {
	
	private JPanel panel;
	private JList<Treinamento> listTreinamentos;
	private DefaultListModel<Treinamento> listTreinamentoModel;
	private TreinamentoController treinamentoController;
	private JTextField textFieldFuncionario;
	
	String funcionario;
	
	
	public PesquisaFuncionario() {
		setTitle("Pesquisa dos Treinamentos por Funcionario");
		setLayout(new FlowLayout());
		
		treinamentoController = new TreinamentoControllerImpl();
		
		this.panel = new JPanel();
		this.panel.setLayout(new FlowLayout());
		this.panel.setPreferredSize(new Dimension(1000, 2000));
		add(this.panel);
		
		criarTextFieldFuncionario("Funcionario");
		criarBotao("Buscar", new ButtonBuscarPorNomeHandler());
		criarBotao("Voltar", new ButtonVoltarHandler());
		

		
		setSize(new Dimension(1000,2000));
		setPreferredSize(new Dimension(1000,2000));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		
		
	}
	
	private void criarBotao(String label, ActionListener handler) {
		JButton button = new JButton(label);
		button.addActionListener(handler);
		button.setPreferredSize(new Dimension(100,40));
		panel.add(button);
		
	}
	
	
	
	private void criarList() {
        listTreinamentoModel = new DefaultListModel<>();
        listTreinamentos = new JList<>(listTreinamentoModel);

        // Define um ListCellRenderer personalizado
        listTreinamentos.setCellRenderer(new TreinamentoCellRenderer());

        listTreinamentos.setPreferredSize(new Dimension(1800, 500));
        JScrollPane scrollPane = new JScrollPane(listTreinamentos);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        panel.add(scrollPane);
    }

    // Classe para o ListCellRenderer personalizado
    public class TreinamentoCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            // Chama a implementação padrão para obter o JLabel padrão
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            String temp;
            // Verifica se o valor é uma instância de AreaAbrangencia
            if (value instanceof Treinamento) {
                Treinamento treinamento = (Treinamento) value;
             // Define o texto do JLabel com as informações desejadas
                label.setText("Id: " + treinamento.getIdTreinamento() + 
                		";   Nome: " + treinamento.getNomeCurso() + 
                		";   Data de Início: " + treinamento.getDataInicio() + 
                		";   Data de Término: " + treinamento.getDataTermino() +
                		";   Carga Horária: " + treinamento.getCargaHoraria() + 
                		";   Nota: " + treinamento.getNotaFuncionario() +
                		";   Vigência: " + treinamento.getVigencia() + 
                		";   Conclusão: " + treinamento.isTreinamentoConcluido() +
                		";   Custo: R$ " + treinamento.getCusto() +
                		";   Id Funcionário: " + treinamento.getFuncionario_id() +
                		";   Id Área de Abrangência: " + treinamento.getAreaAbrangencia_id() +
                		";   Id Curso: " + treinamento.getCurso_id());
            }

            return label;
        }
    }

	
	
	
	
	private class ButtonVoltarHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
		}
		
	}
	
	private void criarLabel(String texto) {
		JLabel label = new JLabel(texto);
		label.setPreferredSize(new Dimension(400,40));
		panel.add(label);
	}
	
	private void criarTextFieldFuncionario(String label) {
		this.criarLabel(label);
		textFieldFuncionario = new JTextField();
		textFieldFuncionario.setPreferredSize(new Dimension(400,40));
		panel.add(textFieldFuncionario);
	}
	
	private class ButtonBuscarPorNomeHandler implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			funcionario = textFieldFuncionario.getText();
			
			criarList();
			
			
			List<Treinamento> treinamentosCarregados = treinamentoController.listarFuncionario(funcionario);
			listTreinamentoModel.addAll(treinamentosCarregados);
			
			
			setSize(new Dimension(1000,2000));
			setPreferredSize(new Dimension(1000,2000));
			setVisible(true);
			limparCampos();
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			
			
			
		}
		
		private void limparCampos() {
			textFieldFuncionario.setText("");

		}
		
		
	}
	
	

}
