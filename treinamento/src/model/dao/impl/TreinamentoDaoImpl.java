package model.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.api.CursoDAO;
import model.dao.api.TreinamentoDAO;
import model.entidade.Curso;
import model.entidade.Treinamento;

public class TreinamentoDaoImpl implements TreinamentoDAO {
	
	// REALIZA AS AÇÕES NA TABELA TREINAMENTO NO BANCO DE DADOS
	private static final String INSERT_TREINAMENTO = "INSERT INTO treinamento (nomeCurso, dataInicio, dataTermino, cargaHoraria, funcionario_id, notaFuncionario, vigencia, treinamentoConcluido, areaAbrangencia_id, custo, curso_id) values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_TREINAMENTO = "UPDATE treinamento SET nomeCurso = ?, dataInicio = ?, dataTermino = ?, cargaHoraria = ?, funcionario_id = ?, notaFuncionario = ?, vigencia = ?, treinamentoConcluido = ?, areaAbrangencia_id = ?, custo = ?, curso_id = ?  WHERE idTreinamento = ?";
	private static final String EXCLUIR_TREINAMENTO = "DELETE FROM treinamento WHERE idTreinamento = ?";
	private static final String LISTAR_TODOS_TREINAMENTO = "SELECT * FROM treinamento";
	private static final String BUSCAR_POR_ID_TREINAMENTO = "SELECT * FROM treinamento WHERE idTreinamento = ?";
	
	private static final String LISTAR_TREINAMENTO_NOME_CURSO = "SELECT * FROM treinamento WHERE nomeCurso = ?";
	private static final String LISTAR_TREINAMENTO_VIGENCIA = "SELECT * FROM treinamento WHERE vigencia = ?";
	private static final String LISTAR_TREINAMENTO_FUNCIONARIO = "SELECT * FROM treinamento WHERE funcionario_id = ?";
	private static final String LISTAR_ID_FUNCIONARIO = "SELECT * FROM funcionario WHERE nome = ?";
	private static final String LISTAR_TREINAMENTO_TERMINO = "SELECT * FROM treinamento WHERE dataTermino = ?";
	
	
	int idFuncionario;
	
	//VERIFICA SE É UM NOVO TREINAMENTO OU SE ESTÁ ATUALIZANDO UM EXISTENTE
	@Override
	public void salvar(Treinamento treinamento) {
		if ((treinamento != null) && (treinamento.getIdTreinamento() == 0)) {
			this.salvarTreinamento(treinamento);
		} else {
			JOptionPane.showMessageDialog(null, "Atualizando");
			this.alterarTreinamento(treinamento);
		}
	}
	
	//SALVA TREINAMENTO
	private void salvarTreinamento(Treinamento treinamento) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(INSERT_TREINAMENTO)) {
			ps.setString(1, treinamento.getNomeCurso());
			ps.setString(2, treinamento.getDataInicio());		//ps.setDate(2, (Date) curso.getDataInicio());
			ps.setString(3, treinamento.getDataTermino());		//ps.setDate(3, (Date) curso.getDataTermino());
			ps.setString(4, treinamento.getCargaHoraria());
			
			ps.setInt(5, treinamento.getFuncionario_id());	//funcionario_id: 1 ou 3
			ps.setInt(6, treinamento.getNotaFuncionario());	//nota funcionario: 0 a 10
			
			ps.setString(7, treinamento.getVigencia());	//vigencia
			ps.setBoolean(8, treinamento.isTreinamentoConcluido());	// treinamentoConcluido
			ps.setInt(9, treinamento.getAreaAbrangencia_id());	// areaAbrangencia_id: 1, 3 ou 4
			ps.setFloat(10, treinamento.getCusto());	// custo
			ps.setInt(11, treinamento.getCurso_id());	//curso_id: 2, 3, 5 ou 6
			
			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ALTERA TREINAMENTO
	private void alterarTreinamento(Treinamento treinamento) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(UPDATE_TREINAMENTO)){
			ps.setString(1, treinamento.getNomeCurso());
			
			ps.setString(2, treinamento.getDataInicio());		//ps.setDate(2, (Date) curso.getDataInicio());
			
			
			ps.setString(3, treinamento.getDataTermino());		//ps.setDate(3, (Date) curso.getDataTermino());
			ps.setString(4, treinamento.getCargaHoraria());
			
			ps.setInt(5, treinamento.getFuncionario_id());	//funcionario_id: 1 ou 3
			ps.setInt(6, treinamento.getNotaFuncionario());	//nota funcionario: 0 a 10
			
			ps.setString(7, treinamento.getVigencia());	//vigencia
			ps.setBoolean(8, treinamento.isTreinamentoConcluido());	// treinamentoConcluido
			ps.setInt(9, treinamento.getAreaAbrangencia_id());	// areaAbrangencia_id: 1, 3 ou 4
			ps.setFloat(10, treinamento.getCusto());	// custo
			ps.setInt(11, treinamento.getCurso_id());	//curso_id: 2, 3, 5 ou 6
			
			ps.setInt(12, treinamento.getIdTreinamento());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//EXCLUI TREINAMENTO
	@Override
	public void excluir(int id) {
		try (PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(EXCLUIR_TREINAMENTO)){
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//LISTA TODOS OS TREINAMENTOS CADASTRADOS
	public List<Treinamento> listarTodos() {
		List<Treinamento> treinamentos = new ArrayList<Treinamento>();
		try (
			PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(LISTAR_TODOS_TREINAMENTO);
			ResultSet resultSet = ps.executeQuery();
			){
			while (resultSet.next()) {
				Treinamento treinamento = new Treinamento();
				treinamento.setIdTreinamento(resultSet.getInt("idTreinamento"));
				treinamento.setNomeCurso(resultSet.getString("nomeCurso"));
				treinamento.setDataInicio(resultSet.getString("dataInicio"));	//curso.setDataInicio((Date) resultSet.getDate("dataInicio"));
				treinamento.setDataTermino(resultSet.getString("dataTermino"));	//curso.setDataTermino((Date) resultSet.getDate("dataTermino"));
				
				treinamento.setCargaHoraria(resultSet.getString("cargaHoraria"));
				treinamento.setNotaFuncionario(resultSet.getInt("notaFuncionario"));
				treinamento.setVigencia(resultSet.getString("vigencia"));
				treinamento.setTreinamentoConcluido(resultSet.getBoolean("treinamentoConcluido"));
				treinamento.setCusto(resultSet.getFloat("custo"));
				treinamento.setFuncionario_id(resultSet.getInt("funcionario_id"));
				treinamento.setAreaAbrangencia_id(resultSet.getInt("areaAbrangencia_id"));
				treinamento.setCurso_id(resultSet.getInt("curso_id"));
				treinamentos.add(treinamento);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return treinamentos;
	}
	
	//BUSCA TREINAMENTO ESPECIFICO
	@Override
	public Treinamento buscarPorId(int id) {
		Treinamento treinamento = null;
		try (
			PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(BUSCAR_POR_ID_TREINAMENTO);
			){
			ps.setInt(1, id);
			try (
				ResultSet resultSet = ps.executeQuery();
				){
				while (resultSet.next()) {
					treinamento = new Treinamento();
					treinamento.setIdTreinamento(resultSet.getInt("idTreinamento"));
					treinamento.setNomeCurso(resultSet.getString("nomeCurso"));
					treinamento.setDataInicio(resultSet.getString("dataInicio"));	//curso.setDataInicio((Date) resultSet.getDate("dataInicio"));
					treinamento.setDataTermino(resultSet.getString("dataTermino"));	//curso.setDataTermino((Date) resultSet.getDate("dataTermino"));
					
					treinamento.setCargaHoraria(resultSet.getString("cargaHoraria"));
					treinamento.setNotaFuncionario(resultSet.getInt("notaFuncionario"));
					treinamento.setVigencia(resultSet.getString("vigencia"));
					treinamento.setTreinamentoConcluido(resultSet.getBoolean("treinamentoConcluido"));
					treinamento.setCusto(resultSet.getFloat("custo"));
					treinamento.setFuncionario_id(resultSet.getInt("funcionario_id"));
					treinamento.setAreaAbrangencia_id(resultSet.getInt("areaAbrangencia_id"));
					treinamento.setCurso_id(resultSet.getInt("curso_id"));
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return treinamento;
	}
	
	
	//LISTA TODOS OS TREINAMENTOS COM O NOME ?
		public List<Treinamento> listarNome(String nomeCurso) {
			
			List<Treinamento> treinamentos = new ArrayList<Treinamento>();

			
			

			try (
				PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(LISTAR_TREINAMENTO_NOME_CURSO);
				){
				ps.setString(1, nomeCurso);
				
				try (
					ResultSet resultSet = ps.executeQuery();
					){
					while (resultSet.next()) {
						Treinamento treinamento = new Treinamento();
						treinamento.setIdTreinamento(resultSet.getInt("idTreinamento"));
						treinamento.setNomeCurso(resultSet.getString("nomeCurso"));
						treinamento.setDataInicio(resultSet.getString("dataInicio"));	//curso.setDataInicio((Date) resultSet.getDate("dataInicio"));
						treinamento.setDataTermino(resultSet.getString("dataTermino"));	//curso.setDataTermino((Date) resultSet.getDate("dataTermino"));
						
						treinamento.setCargaHoraria(resultSet.getString("cargaHoraria"));
						treinamento.setNotaFuncionario(resultSet.getInt("notaFuncionario"));
						treinamento.setVigencia(resultSet.getString("vigencia"));
						treinamento.setTreinamentoConcluido(resultSet.getBoolean("treinamentoConcluido"));
						treinamento.setCusto(resultSet.getFloat("custo"));
						treinamento.setFuncionario_id(resultSet.getInt("funcionario_id"));
						treinamento.setAreaAbrangencia_id(resultSet.getInt("areaAbrangencia_id"));
						treinamento.setCurso_id(resultSet.getInt("curso_id"));
						
						treinamentos.add(treinamento);
					}
					
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return treinamentos;
	
		}
		
		
		
		//LISTA TODOS OS TREINAMENTOS COM A VIGENCIA ?
		public List<Treinamento> listarVigencia(String dataVigencia) {
			List<Treinamento> treinamentos = new ArrayList<Treinamento>();

			
			

			try (
				PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(LISTAR_TREINAMENTO_VIGENCIA);
				){
				ps.setString(1, dataVigencia);
				
				try (
					ResultSet resultSet = ps.executeQuery();
					){
					while (resultSet.next()) {
						Treinamento treinamento = new Treinamento();
						treinamento.setIdTreinamento(resultSet.getInt("idTreinamento"));
						treinamento.setNomeCurso(resultSet.getString("nomeCurso"));
						treinamento.setDataInicio(resultSet.getString("dataInicio"));	//curso.setDataInicio((Date) resultSet.getDate("dataInicio"));
						treinamento.setDataTermino(resultSet.getString("dataTermino"));	//curso.setDataTermino((Date) resultSet.getDate("dataTermino"));
						
						treinamento.setCargaHoraria(resultSet.getString("cargaHoraria"));
						treinamento.setNotaFuncionario(resultSet.getInt("notaFuncionario"));
						treinamento.setVigencia(resultSet.getString("vigencia"));
						treinamento.setTreinamentoConcluido(resultSet.getBoolean("treinamentoConcluido"));
						treinamento.setCusto(resultSet.getFloat("custo"));
						treinamento.setFuncionario_id(resultSet.getInt("funcionario_id"));
						treinamento.setAreaAbrangencia_id(resultSet.getInt("areaAbrangencia_id"));
						treinamento.setCurso_id(resultSet.getInt("curso_id"));
						
						treinamentos.add(treinamento);
					}
					
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return treinamentos;
	
		}
		
		
		
		
		//LISTA TODOS OS TREINAMENTOS COM O FUNCIONARIO ?
				public List<Treinamento> listarFuncionario(String funcionario) {
					List<Treinamento> treinamentos = new ArrayList<Treinamento>();
					

				try (PreparedStatement ps1 = Conexao.getInstance().getConnection().prepareStatement(LISTAR_ID_FUNCIONARIO);
						){
						ps1.setString(1, funcionario);
						
						try (ResultSet resultSet1 = ps1.executeQuery();
								){
								while (resultSet1.next()) {
									idFuncionario = resultSet1.getInt("id");
								}
							try (
									PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(LISTAR_TREINAMENTO_FUNCIONARIO);
									){
									ps.setInt(1, idFuncionario);
									
									try (
										ResultSet resultSet = ps.executeQuery();
										){
										while (resultSet.next()) {
											Treinamento treinamento = new Treinamento();
											treinamento.setIdTreinamento(resultSet.getInt("idTreinamento"));
											treinamento.setNomeCurso(resultSet.getString("nomeCurso"));
											treinamento.setDataInicio(resultSet.getString("dataInicio"));	//curso.setDataInicio((Date) resultSet.getDate("dataInicio"));
											treinamento.setDataTermino(resultSet.getString("dataTermino"));	//curso.setDataTermino((Date) resultSet.getDate("dataTermino"));
											
											treinamento.setCargaHoraria(resultSet.getString("cargaHoraria"));
											treinamento.setNotaFuncionario(resultSet.getInt("notaFuncionario"));
											treinamento.setVigencia(resultSet.getString("vigencia"));
											treinamento.setTreinamentoConcluido(resultSet.getBoolean("treinamentoConcluido"));
											treinamento.setCusto(resultSet.getFloat("custo"));
											treinamento.setFuncionario_id(resultSet.getInt("funcionario_id"));
											treinamento.setAreaAbrangencia_id(resultSet.getInt("areaAbrangencia_id"));
											treinamento.setCurso_id(resultSet.getInt("curso_id"));
											
											treinamentos.add(treinamento);
										}
										
										
										
									} catch (SQLException e) {
										e.printStackTrace();
									}
									
									
								} catch (SQLException e) {
									e.printStackTrace();
								}
						} catch (SQLException e) {
							e.printStackTrace();
						}	
						
							
						} catch (SQLException e) {
							e.printStackTrace();
						}
					
				

				
					
					return treinamentos;
			
				}
	
	
				//LISTA TODOS OS TREINAMENTOS COM A DATA DE TÉRMINO ?
				public List<Treinamento> listarDataTermino(String dataTermino) {
					List<Treinamento> treinamentos = new ArrayList<Treinamento>();

					
					

					try (
						PreparedStatement ps = Conexao.getInstance().getConnection().prepareStatement(LISTAR_TREINAMENTO_TERMINO);
						){
						ps.setString(1, dataTermino);
						
						try (
							ResultSet resultSet = ps.executeQuery();
							){
							while (resultSet.next()) {
								Treinamento treinamento = new Treinamento();
								treinamento.setIdTreinamento(resultSet.getInt("idTreinamento"));
								treinamento.setNomeCurso(resultSet.getString("nomeCurso"));
								treinamento.setDataInicio(resultSet.getString("dataInicio"));	//curso.setDataInicio((Date) resultSet.getDate("dataInicio"));
								treinamento.setDataTermino(resultSet.getString("dataTermino"));	//curso.setDataTermino((Date) resultSet.getDate("dataTermino"));
								
								treinamento.setCargaHoraria(resultSet.getString("cargaHoraria"));
								treinamento.setNotaFuncionario(resultSet.getInt("notaFuncionario"));
								treinamento.setVigencia(resultSet.getString("vigencia"));
								treinamento.setTreinamentoConcluido(resultSet.getBoolean("treinamentoConcluido"));
								treinamento.setCusto(resultSet.getFloat("custo"));
								treinamento.setFuncionario_id(resultSet.getInt("funcionario_id"));
								treinamento.setAreaAbrangencia_id(resultSet.getInt("areaAbrangencia_id"));
								treinamento.setCurso_id(resultSet.getInt("curso_id"));
								
								treinamentos.add(treinamento);
							}
							
							
							
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
					return treinamentos;
			
				}
			
	
	
}
