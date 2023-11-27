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
import controller.api.FuncionarioController;
import controller.impl.CursoControllerImpl;
import controller.impl.FuncionarioControllerImpl;
import model.entidade.Curso;
import model.entidade.Funcionario;

public class ListagemFuncionario extends JFrame {
	
	private JPanel panel;
	private JList<Funcionario> listFuncionarios;
	private DefaultListModel<Funcionario> listFuncionarioModel;
	private FuncionarioController funcionarioController;
	
	
	public ListagemFuncionario() {
		setTitle("Listagem dos Funcionários");
		setLayout(new FlowLayout());
		
		funcionarioController = new FuncionarioControllerImpl();
		
		this.panel = new JPanel();
		this.panel.setLayout(new FlowLayout());
		this.panel.setPreferredSize(new Dimension(1000, 2000));
		add(this.panel);
		
		criarBotao("Voltar", new ButtonVoltarHandler());
		
		criarList();
		
		List<Funcionario> funcionariosCarregados = funcionarioController.listarTodos();
		listFuncionarioModel.addAll(funcionariosCarregados);
		
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
        listFuncionarioModel = new DefaultListModel<>();
        listFuncionarios = new JList<>(listFuncionarioModel);

        // Define um ListCellRenderer personalizado
        listFuncionarios.setCellRenderer(new FuncionarioCellRenderer());

        listFuncionarios.setPreferredSize(new Dimension(1600, 500));
        JScrollPane scrollPane = new JScrollPane(listFuncionarios);
        scrollPane.setPreferredSize(new Dimension(700, 400));
        panel.add(scrollPane);
    }

    // Classe para o ListCellRenderer personalizado
    private class FuncionarioCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            // Chama a implementação padrão para obter o JLabel padrão
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Verifica se o valor é uma instância de AreaAbrangencia
            if (value instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) value;
                // Define o texto do JLabel com as informações desejadas
                label.setText("Id: " + funcionario.getIdFuncionario() + 
                		";   Nome: " + funcionario.getNome() + 
                		";   Data de Nascimento: " + funcionario.getDataNascimento() + 
                		";   CPF: " + funcionario.getCpf() + 
                		";   E-mail: " + funcionario.getEmail() +
                		";   Data de Admissão: " + funcionario.getDataAdmissao() +
                		";   Cargo: " + funcionario.getCargo() +
                		";   Função: " + funcionario.getFuncao() +
                		";   Formação: " + funcionario.getFormacao() +
                		";   Acessibilidade: " + funcionario.isAcessibilidade());
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

