package model.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.api.CursoDAO;
import model.dao.api.InstituicaoDAO;
import model.entidade.Curso;
import model.entidade.Instituicao;

public class InstituicaoDaoImpl implements InstituicaoDAO {
	
	// REALIZA AS AÇÕES NA TABELA INSTITUICAO NO BANCO DE DADOS
	private static final String INSERT_INSTITUICAO = "INSERT INTO instituicao (nome, endereco, cidade, estado, contato, interno) values (?,?,?,?,?,?)";
	private static final String UPDATE_INSTITUICAO = "UPDATE instituicao SET nome = ?, endereco = ?, cidade = ?, estado = ?, contato = ?, interno = ? WHERE id = ?";
	private static final String EXCLUIR_INSTITUICAO = "DELETE FROM instituicao WHERE id = ?";
	private static final String LISTAR_TODOS_INSTITUICAO = "SELECT * FROM instituicao";
	private static final String BUSCAR_POR_ID_INSTITUICAO = "SELECT * FROM instituicao WHERE id = ?";	
	
	
	//VERIFICA SE É UMA NOVA INSTITUIÇÃO OU SE ESTÁ ATUALIZANDO UMA EXISTENTE
	@Override
	public void salvar(Instituicao instituicao) {
		if ((instituicao != null) && (instituicao.getIdInstituicao() == 0)) {
			this.salvarInstituicao(instituicao);
		} else {
			this.alterarInstituicao(instituicao);
		}
	}
	
	//SALVA INSTITUIÇÃO
	private void salvarInstituicao(Instituicao instituicao) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(INSERT_INSTITUICAO)) {
			ps.setString(1, instituicao.getNome());
			ps.setString(2, instituicao.getEndereco());		
			ps.setString(3, instituicao.getCidade());		
			ps.setString(4, instituicao.getEstado());
			ps.setString(5, instituicao.getContato());
			ps.setBoolean(6, instituicao.isInterno());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ALTERA INSTITUIÇÃO
	private void alterarInstituicao(Instituicao instituicao) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(UPDATE_INSTITUICAO)){
			ps.setString(1, instituicao.getNome());
			ps.setString(2, instituicao.getEndereco());		
			ps.setString(3, instituicao.getCidade());		
			ps.setString(4, instituicao.getEstado());
			ps.setString(5, instituicao.getContato());
			ps.setBoolean(6, instituicao.isInterno());
			ps.setInt(7, instituicao.getIdInstituicao());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//EXCLUI INSTITUIÇÃO
	@Override
	public void excluir(int id) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(EXCLUIR_INSTITUICAO)){
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//LISTA TODAS AS INSTITUIÇÕES CADASTRADAS
	public List<Instituicao> listarTodos() {
		List<Instituicao> instituicoes = new ArrayList<Instituicao>();
		try (
			PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(LISTAR_TODOS_INSTITUICAO);
			ResultSet resultSet = ps.executeQuery();
			){
			while (resultSet.next()) {
				Instituicao instituicao = new Instituicao();
				instituicao.setIdInstituicao(resultSet.getInt("id"));
				instituicao.setNome(resultSet.getString("nome"));
				instituicao.setEndereco(resultSet.getString("endereco"));
				instituicao.setCidade(resultSet.getString("cidade"));
				instituicao.setEstado(resultSet.getString("estado"));
				instituicao.setContato(resultSet.getString("contato"));
				instituicao.setInterno(resultSet.getBoolean("interno"));
				instituicoes.add(instituicao);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instituicoes;
	}
	
	
	
	//BUSCA INSTITUICAO ESPECIFICA
	@Override
	public Instituicao buscarPorId(int id) {
		Instituicao instituicao = null;
		try (
			PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(BUSCAR_POR_ID_INSTITUICAO);
			){
			ps.setInt(1, id);
			try (
				ResultSet resultSet = ps.executeQuery();
				){
				while (resultSet.next()) {
					instituicao = new Instituicao();
					instituicao.setIdInstituicao(resultSet.getInt("id"));
					instituicao.setNome(resultSet.getString("nome"));
					instituicao.setEndereco(resultSet.getString("endereco"));
					instituicao.setCidade(resultSet.getString("cidade"));
					instituicao.setEstado(resultSet.getString("estado"));
					instituicao.setContato(resultSet.getString("contato"));
					instituicao.setInterno(resultSet.getBoolean("interno"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return instituicao;
	}
	
}
