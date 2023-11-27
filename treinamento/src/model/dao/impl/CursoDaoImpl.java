package model.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.api.CursoDAO;
import model.entidade.Curso;

public class CursoDaoImpl implements CursoDAO {
	
	// REALIZA AS AÇÕES NA TABELA CURSO NO BANCO DE DADOS
	private static final String INSERT_CURSO = "INSERT INTO curso (nome, dataInicio, dataTermino, cargaHoraria, instrutor_id, instrutor_instituicao_id) values (?,?,?,?,?,?)";
	private static final String UPDATE_CURSO = "UPDATE curso SET nome = ?, dataInicio = ?, dataTermino = ?, cargaHoraria = ?, instrutor_id = ?, instrutor_instituicao_id = ? WHERE id = ?";
	private static final String EXCLUIR_CURSO = "DELETE FROM curso WHERE id = ?";
	private static final String LISTAR_TODOS_CURSO = "SELECT * FROM curso";
	private static final String BUSCAR_POR_ID_CURSO = "SELECT * FROM curso WHERE id = ?";	
	
	
	//VERIFICA SE É UM NOVO CURSO OU SE ESTÁ ATUALIZANDO UM EXISTENTE
	@Override
	public void salvar(Curso curso) {
		if ((curso != null) && (curso.getIdCurso() == 0)) {
			this.salvarCurso(curso);
		} else {
			this.alterarCurso(curso);
		}
	}
	
	//SALVA CURSO
	private void salvarCurso(Curso curso) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(INSERT_CURSO)) {
			ps.setString(1, curso.getNome());
			ps.setString(2, curso.getDataInicio());		//ps.setDate(2, (Date) curso.getDataInicio());
			ps.setString(3, curso.getDataTermino());		//ps.setDate(3, (Date) curso.getDataTermino());
			ps.setString(4, curso.getCargaHoraria());
			ps.setInt(5, curso.getInstrutor_id());
			ps.setInt(6, curso.getInstrutor_instituicao_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ALTERA CURSO
	private void alterarCurso(Curso curso) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(UPDATE_CURSO)){
			ps.setString(1, curso.getNome());
			ps.setString(2, curso.getDataInicio());
			ps.setString(3, curso.getDataTermino());
			ps.setString(4, curso.getCargaHoraria());
			ps.setInt(5, curso.getInstrutor_id());
			ps.setInt(6, curso.getInstrutor_instituicao_id());
			ps.setInt(7, curso.getIdCurso());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//EXCLUI CURSO
	@Override
	public void excluir(int id) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(EXCLUIR_CURSO)){
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//LISTA TODOS OS CURSOS CADASTRADOS
	public List<Curso> listarTodos() {
		List<Curso> cursos = new ArrayList<Curso>();
		try (
			PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(LISTAR_TODOS_CURSO);
			ResultSet resultSet = ps.executeQuery();
			){
			while (resultSet.next()) {
				Curso curso = new Curso();
				curso.setIdCurso(resultSet.getInt("id"));
				curso.setNome(resultSet.getString("nome"));
				curso.setDataInicio(resultSet.getString("dataInicio"));
				curso.setDataTermino(resultSet.getString("dataTermino"));
				curso.setCargaHoraria(resultSet.getString("cargaHoraria"));
				curso.setInstrutor_id(resultSet.getInt("instrutor_id"));
				curso.setInstrutor_instituicao_id(resultSet.getInt("instrutor_instituicao_id"));
				cursos.add(curso);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursos;
	}
	
	//BUSCA CURSO ESPECIFICO
	@Override
	public Curso buscarPorId(int id) {
		Curso curso = null;
		try (
			PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(BUSCAR_POR_ID_CURSO);
			){
			ps.setInt(1, id);
			try (
				ResultSet resultSet = ps.executeQuery();
				){
				while (resultSet.next()) {
					curso = new Curso();
					curso.setIdCurso(resultSet.getInt("id"));
					curso.setNome(resultSet.getString("nome"));
					curso.setDataInicio(resultSet.getString("dataInicio"));
					curso.setDataTermino(resultSet.getString("dataTermino"));
					curso.setCargaHoraria(resultSet.getString("cargaHoraria"));
					curso.setInstrutor_id(resultSet.getInt("instrutor_id"));
					curso.setInstrutor_instituicao_id(resultSet.getInt("instrutor_instituicao_id"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return curso;
	}
	
}
