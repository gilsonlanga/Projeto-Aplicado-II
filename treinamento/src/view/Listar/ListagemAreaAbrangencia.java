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

import controller.api.AreaAbrangenciaController;
import controller.impl.AreaAbrangenciaControllerImpl;
import model.entidade.AreaAbrangencia;

public class ListagemAreaAbrangencia extends JFrame {
	
	private JPanel panel;
	private JList<AreaAbrangencia> listAreasAbrangencia;
	private DefaultListModel<AreaAbrangencia> listAreaAbrangenciaModel;
	private AreaAbrangenciaController areaAbrangenciaController;
	
	
	public ListagemAreaAbrangencia() {
		setTitle("Listagem das Áreas de Abrangência");
		setLayout(new FlowLayout());
		
		areaAbrangenciaController = new AreaAbrangenciaControllerImpl();
		
		this.panel = new JPanel();
		this.panel.setLayout(new FlowLayout());
		this.panel.setPreferredSize(new Dimension(500, 800));
		add(this.panel);
		
		criarBotao("Voltar", new ButtonVoltarHandler());
		
		criarList();
		
		List<AreaAbrangencia> areasCarregadas = areaAbrangenciaController.listarTodos();
		listAreaAbrangenciaModel.addAll(areasCarregadas);
		
		setSize(new Dimension(500,800));
		setPreferredSize(new Dimension(500,800));
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
        listAreaAbrangenciaModel = new DefaultListModel<>();
        listAreasAbrangencia = new JList<>(listAreaAbrangenciaModel);

        // Define um ListCellRenderer personalizado
        listAreasAbrangencia.setCellRenderer(new AreaAbrangenciaCellRenderer());

        listAreasAbrangencia.setPreferredSize(new Dimension(400, 500));
        JScrollPane scrollPane = new JScrollPane(listAreasAbrangencia);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        panel.add(scrollPane);
    }

    // Classe para o ListCellRenderer personalizado
    private class AreaAbrangenciaCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            // Chama a implementação padrão para obter o JLabel padrão
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Verifica se o valor é uma instância de AreaAbrangencia
            if (value instanceof AreaAbrangencia) {
                AreaAbrangencia area = (AreaAbrangencia) value;
                // Define o texto do JLabel com as informações desejadas
                label.setText("ID: " + area.getIdAreaAbrangencia() + ", Nome: " + area.getNome());
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
