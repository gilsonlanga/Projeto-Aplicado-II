package model.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.dao.api.InstrutorDAO;
import model.entidade.Instrutor;

public class InstrutorDaoImpl implements InstrutorDAO {
	
	// REALIZA AS AÇÕES NA TABELA INSTRUTOR NO BANCO DE DADOS
	private static final String INSERT_INSTRUTOR = "INSERT INTO instrutor (nome, formacao, instituicao_id) values (?,?,?)";
	private static final String UPDATE_INSTRUTOR = "UPDATE instrutor SET nome = ?, formacao = ?, instituicao_id = ? WHERE id = ?";
	private static final String EXCLUIR_INSTRUTOR = "DELETE FROM instrutor WHERE id = ?";
	private static final String LISTAR_TODOS_INSTRUTOR = "SELECT * FROM instrutor";
	private static final String BUSCAR_POR_ID_INSTRUTOR = "SELECT * FROM instrutor WHERE id = ?";	
	
	
	//VERIFICA SE É UM NOVO INSTRUTOR OU SE ESTÁ ATUALIZANDO UM EXISTENTE
	@Override
	public void salvar(Instrutor instrutor) {
		if ((instrutor != null) && (instrutor.getIdInstrutor() == 0)) {
			this.salvarInstrutor(instrutor);
		} else {
			this.alterarInstrutor(instrutor);
		}
	}
	
	//SALVA INSTRUTOR
	private void salvarInstrutor(Instrutor instrutor) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(INSERT_INSTRUTOR)) {
			ps.setString(1, instrutor.getNome());
			ps.setString(2, instrutor.getFormacao());
			ps.setInt(3, instrutor.getInstituicao_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ALTERA INSTRUTOR
	private void alterarInstrutor(Instrutor instrutor) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(UPDATE_INSTRUTOR)){
			ps.setString(1, instrutor.getNome());
			ps.setString(2, instrutor.getFormacao());
			ps.setInt(3, instrutor.getInstituicao_id());
			ps.setInt(4, instrutor.getIdInstrutor());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//EXCLUI INSTRUTOR
	@Override
	public void excluir(int id) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(EXCLUIR_INSTRUTOR)){
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//LISTA TODAS OS INSTRUTORES CADASTRADOS
	public List<Instrutor> listarTodos() {
		List<Instrutor> instrutores = new ArrayList<Instrutor>();
		try (
			PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(LISTAR_TODOS_INSTRUTOR);
			ResultSet resultSet = ps.executeQuery();
			){
			while (resultSet.next()) {
				Instrutor instrutor = new Instrutor();
				instrutor.setIdInstrutor(resultSet.getInt("id"));
				instrutor.setNome(resultSet.getString("nome"));
				instrutor.setFormacao(resultSet.getString("formacao"));
				instrutor.setInstituicao_id(resultSet.getInt("instituicao_id"));
				instrutores.add(instrutor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instrutores;
	}
	
	//BUSCA INSTRUTOR ESPECIFICO
	@Override
	public Instrutor buscarPorId(int id) {
		Instrutor instrutor = null;
		try (
			PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(BUSCAR_POR_ID_INSTRUTOR);
			){
			ps.setInt(1, id);
			try (
				ResultSet resultSet = ps.executeQuery();
				){
				while (resultSet.next()) {
					instrutor = new Instrutor();
					instrutor.setIdInstrutor(resultSet.getInt("id"));
					instrutor.setNome(resultSet.getString("nome"));
					instrutor.setFormacao(resultSet.getString("formacao"));
					instrutor.setInstituicao_id(resultSet.getInt("instituicao_id"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instrutor;
	}
	
}
