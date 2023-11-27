package model.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import model.dao.api.FuncionarioDAO;
import model.entidade.Funcionario;

public class FuncionarioDaoImpl implements FuncionarioDAO {
	
	// REALIZA AS AÇÕES NA TABELA FUNCIONARIO NO BANCO DE DADOS
	private static final String INSERT_FUNCIONARIO = "INSERT INTO funcionario (nome, data, cpf, email, dataAdmissao, cargo, funcao, formacao, acessibilidade) values (?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_FUNCIONARIO = "UPDATE funcionario SET nome = ?, data = ?, cpf = ?, email = ?, dataAdmissao = ?, cargo = ?, funcao = ?, formacao = ?, acessibilidade = ? WHERE id = ?";
	private static final String EXCLUIR_FUNCIONARIO = "DELETE FROM funcionario WHERE id = ?";
	private static final String LISTAR_TODOS_FUNCIONARIO = "SELECT * FROM funcionario";
	private static final String BUSCAR_POR_ID_FUNCIONARIO = "SELECT * FROM funcionario WHERE id = ?";	
	
	
	//VERIFICA SE É UM NOVO FUNCIONARIO OU SE ESTÁ ATUALIZANDO UM EXISTENTE
	@Override
	public void salvar(Funcionario funcionario) {
		if ((funcionario != null) && (funcionario.getIdFuncionario() == 0)) {
			this.salvarFuncionario(funcionario);
		} else {
			this.alterarFuncionario(funcionario);
		}
	}
	
	//SALVA FUNCIONARIO
	private void salvarFuncionario(Funcionario funcionario) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(INSERT_FUNCIONARIO)) {
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getDataNascimento());		//ps.setDate(2, (Date) curso.getDataInicio());
			ps.setString(3, funcionario.getCpf());					//ps.setDate(3, (Date) curso.getDataTermino());
			ps.setString(4, funcionario.getEmail());
			
			ps.setString(5, funcionario.getDataAdmissao());
			ps.setString(6, funcionario.getCargo());
			ps.setString(7, funcionario.getFuncao());
			ps.setString(8, funcionario.getFormacao());
			ps.setBoolean(9, funcionario.isAcessibilidade());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ALTERA FUNCIONARIO
	private void alterarFuncionario(Funcionario funcionario) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(UPDATE_FUNCIONARIO)){
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getDataNascimento());		//ps.setDate(2, (Date) curso.getDataInicio());
			ps.setString(3, funcionario.getCpf());					//ps.setDate(3, (Date) curso.getDataTermino());
			ps.setString(4, funcionario.getEmail());			
			
			ps.setString(5, funcionario.getDataAdmissao());
			ps.setString(6, funcionario.getCargo());
			ps.setString(7, funcionario.getFuncao());
			ps.setString(8, funcionario.getFormacao());
			ps.setBoolean(9, funcionario.isAcessibilidade());
			ps.setInt(10, funcionario.getIdFuncionario());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//EXCLUI FUNCIONARIO
	@Override
	public void excluir(int id) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(EXCLUIR_FUNCIONARIO)){
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//LISTA TODOS OS FUNCIONÁRIOS CADASTRADOS
	public List<Funcionario> listarTodos() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		try (
			PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(LISTAR_TODOS_FUNCIONARIO);
			ResultSet resultSet = ps.executeQuery();
			){
			while (resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(resultSet.getInt("id"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setDataNascimento(resultSet.getString("data"));
				funcionario.setCpf(resultSet.getString("cpf"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setDataAdmissao(resultSet.getString("dataAdmissao"));
				funcionario.setCargo(resultSet.getString("cargo"));
				funcionario.setFuncao(resultSet.getString("funcao"));
				funcionario.setFormacao(resultSet.getString("formacao"));
				funcionario.setAcessibilidade(resultSet.getBoolean("acessibilidade"));
				funcionarios.add(funcionario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionarios;
	}
	
	//BUSCA FUNCIONARIO ESPECIFICO
	@Override
	public Funcionario buscarPorId(int id) {
		Funcionario funcionario = null;
		try (
			PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(BUSCAR_POR_ID_FUNCIONARIO);
			){
			ps.setInt(1, id);
			try (
				ResultSet resultSet = ps.executeQuery();
				){
				while (resultSet.next()) {
					funcionario = new Funcionario();
					funcionario.setIdFuncionario(resultSet.getInt("id"));
					funcionario.setNome(resultSet.getString("nome"));
					funcionario.setDataNascimento(resultSet.getString("data"));	//curso.setDataInicio((Date) resultSet.getDate("dataInicio"));
					funcionario.setCpf(resultSet.getString("cpf"));	//curso.setDataTermino((Date) resultSet.getDate("dataTermino"));
					funcionario.setEmail(resultSet.getString("email"));
					funcionario.setDataAdmissao(resultSet.getString("dataAdmissao"));
					funcionario.setCargo(resultSet.getString("cargo"));
					funcionario.setFuncao(resultSet.getString("funcao"));
					funcionario.setFormacao(resultSet.getString("formacao"));
					funcionario.setAcessibilidade(resultSet.getBoolean("acessibilidade"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionario;
	}
	
}
