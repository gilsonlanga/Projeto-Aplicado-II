package model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.api.AreaAbrangenciaDAO;
import model.entidade.AreaAbrangencia;

public class AreaAbrangenciaDaoImpl implements AreaAbrangenciaDAO {
	
	// REALIZA AS AÇÕES NA TABELA AREA ABRANGENCIA NO BANCO DE DADOS
	private static final String INSERT_AREA = "INSERT INTO areaabrangencia (nome) values (?)";
	private static final String UPDATE_AREA = "UPDATE areaabrangencia SET nome =? WHERE id = ?";
	private static final String EXCLUIR_AREA = "DELETE FROM areaabrangencia WHERE id = ?";
	private static final String LISTAR_TODOS_AREA = "SELECT * FROM areaabrangencia";
	private static final String BUSCAR_POR_ID_AREA = "SELECT * FROM areaabrangencia WHERE id = ?";	
	
	
	//VERIFICA SE É UMA NOVA AREA DE ABRANGENCIA OU SE ESTÁ ATUALIZANDO UMA EXISTENTE
	@Override
	public void salvar(AreaAbrangencia areaAbrangencia) {
		if ((areaAbrangencia != null) && (areaAbrangencia.getIdAreaAbrangencia() == 0)) {
			this.salvarAreaAbrangencia(areaAbrangencia);
		} else {
			this.alterarAreaAbrangencia(areaAbrangencia);
		}
	}
	
	//SALVA AREA DE ABRANGENCIA
	private void salvarAreaAbrangencia(AreaAbrangencia areaAbrangencia) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(INSERT_AREA)) {
			ps.setString(1, areaAbrangencia.getNome());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ALTERA AREA DE ABRANGENCIA
	private void alterarAreaAbrangencia(AreaAbrangencia areaAbrangencia) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(UPDATE_AREA)){
			ps.setString(1, areaAbrangencia.getNome());
			ps.setInt(2, areaAbrangencia.getIdAreaAbrangencia());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//EXCLUI AREA DE ABRANGENCIA
	@Override
	public void excluir(int id) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(EXCLUIR_AREA)){
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//LISTA TODAS AS AREAS DE ABRANGENCIA CADASTRADAS
	public List<AreaAbrangencia> listarTodos() {
		List<AreaAbrangencia> areasAbrangencia = new ArrayList<AreaAbrangencia>();
		try (
			PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(LISTAR_TODOS_AREA);
			ResultSet resultSet = ps.executeQuery();
			){
			while (resultSet.next()) {
				AreaAbrangencia areaAbrangencia = new AreaAbrangencia();
				areaAbrangencia.setIdAreaAbrangencia(resultSet.getInt("id"));
				areaAbrangencia.setNome(resultSet.getString("nome"));
				areasAbrangencia.add(areaAbrangencia);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return areasAbrangencia;
	}
	
	//BUSCA AREA DE ABRANGENCIA ESPECIFICA
	@Override
	public AreaAbrangencia buscarPorId(int id) {
		AreaAbrangencia areaAbrangencia = null;
		try (
			PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(BUSCAR_POR_ID_AREA);
			){
			ps.setInt(1, id);
			try (
				ResultSet resultSet = ps.executeQuery();
				){
				while (resultSet.next()) {
					areaAbrangencia = new AreaAbrangencia();
					areaAbrangencia.setIdAreaAbrangencia(resultSet.getInt("id"));
					areaAbrangencia.setNome(resultSet.getString("nome"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return areaAbrangencia;
	}
	
}
