package view.Listar;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.api.CursoController;
import controller.api.TreinamentoController;
import controller.impl.CursoControllerImpl;
import controller.impl.TreinamentoControllerImpl;
import model.entidade.Curso;
import model.entidade.Treinamento;

public class ListagemTreinamento extends JFrame {
	
	private JPanel panel;
	private JList<Treinamento> listTreinamentos;
	private DefaultListModel<Treinamento> listTreinamentoModel;
	private TreinamentoController treinamentoController;
	
	
	public ListagemTreinamento() {
		setTitle("Listagem dos Treinamentos");
		setLayout(new FlowLayout());
		
		treinamentoController = new TreinamentoControllerImpl();
		
		this.panel = new JPanel();
		this.panel.setLayout(new FlowLayout());
		this.panel.setPreferredSize(new Dimension(1000, 2000));
		add(this.panel);
		
		criarBotao("Voltar", new ButtonVoltarHandler());
		
		criarList();
		
		List<Treinamento> treinamentosCarregados = treinamentoController.listarTodos();
		listTreinamentoModel.addAll(treinamentosCarregados);
		
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

        listTreinamentos.setPreferredSize(new Dimension(1500, 500));
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

}
