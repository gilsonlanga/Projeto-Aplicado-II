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
import controller.impl.CursoControllerImpl;
import model.entidade.Curso;

public class ListagemCurso extends JFrame {
	
	private JPanel panel;
	private JList<Curso> listCursos;
	private DefaultListModel<Curso> listCursoModel;
	private CursoController cursoController;
	
	
	public ListagemCurso() {
		setTitle("Listagem dos Cursos");
		setLayout(new FlowLayout());
		
		cursoController = new CursoControllerImpl();
		
		this.panel = new JPanel();
		this.panel.setLayout(new FlowLayout());
		this.panel.setPreferredSize(new Dimension(1000, 2000));
		add(this.panel);
		
		criarBotao("Voltar", new ButtonVoltarHandler());
		
		criarList();
		
		List<Curso> cursosCarregados = cursoController.listarTodos();
		listCursoModel.addAll(cursosCarregados);
		
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
        listCursoModel = new DefaultListModel<>();
        listCursos = new JList<>(listCursoModel);

        // Define um ListCellRenderer personalizado
        listCursos.setCellRenderer(new CursoCellRenderer());

        listCursos.setPreferredSize(new Dimension(1000, 500));
        JScrollPane scrollPane = new JScrollPane(listCursos);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        panel.add(scrollPane);
    }

    // Classe para o ListCellRenderer personalizado
    private class CursoCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            // Chama a implementação padrão para obter o JLabel padrão
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Verifica se o valor é uma instância de AreaAbrangencia
            if (value instanceof Curso) {
                Curso curso = (Curso) value;
                // Define o texto do JLabel com as informações desejadas
                label.setText("Id: " + curso.getIdCurso() + 
                		";   Nome: " + curso.getNome() + 
                		";   Data Início: " + curso.getDataInicio() + 
                		";   Data Término: " + curso.getDataTermino() + 
                		";   Data Carga Horária: " + curso.getCargaHoraria() +
                		";   Id Instrutor: " + curso.getInstrutor_id() +
                		";   Id Instrutor Instituição: " + curso.getInstrutor_instituicao_id());
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
