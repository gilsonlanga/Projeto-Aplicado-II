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
import controller.api.InstituicaoController;
import controller.impl.CursoControllerImpl;
import controller.impl.InstituicaoControllerImpl;
import model.entidade.Curso;
import model.entidade.Instituicao;

public class ListagemInstituicao extends JFrame {
	
	private JPanel panel;
	private JList<Instituicao> listInstituicoes;
	private DefaultListModel<Instituicao> listInstituicaoModel;
	private InstituicaoController instituicaoController;
	
	
	public ListagemInstituicao() {
		setTitle("Listagem das Instituições");
		setLayout(new FlowLayout());
		
		instituicaoController = new InstituicaoControllerImpl();
		
		this.panel = new JPanel();
		this.panel.setLayout(new FlowLayout());
		this.panel.setPreferredSize(new Dimension(1000, 2000));
		add(this.panel);
		
		criarBotao("Voltar", new ButtonVoltarHandler());
		
		criarList();
		
		List<Instituicao> instituicoesCarregadas = instituicaoController.listarTodos();
		listInstituicaoModel.addAll(instituicoesCarregadas);
		
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
        listInstituicaoModel = new DefaultListModel<>();
        listInstituicoes = new JList<>(listInstituicaoModel);

        // Define um ListCellRenderer personalizado
        listInstituicoes.setCellRenderer(new InstituicaoCellRenderer());

        listInstituicoes.setPreferredSize(new Dimension(1200, 500));
        JScrollPane scrollPane = new JScrollPane(listInstituicoes);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        panel.add(scrollPane);
    }

    // Classe para o ListCellRenderer personalizado
    private class InstituicaoCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            // Chama a implementação padrão para obter o JLabel padrão
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Verifica se o valor é uma instância de AreaAbrangencia
            if (value instanceof Instituicao) {
                Instituicao instituicao = (Instituicao) value;
                // Define o texto do JLabel com as informações desejadas
                label.setText("ID: " + instituicao.getIdInstituicao() + 
                		";   Nome: " + instituicao.getNome() + 
                		";   Endereço: " + instituicao.getEndereco() + 
                		";   Cidade: " + instituicao.getCidade() + 
                		";   Estado: " + instituicao.getEstado() + 
                		";   Contato: " + instituicao.getContato() +
                		";   Interno: " + instituicao.isInterno());
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
