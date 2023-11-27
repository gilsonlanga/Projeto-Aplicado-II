package model.service.impl;

import java.util.List;

import model.dao.api.CursoDAO;
import model.dao.impl.CursoDaoImpl;
import model.entidade.Curso;
import model.exception.AreaAbrangenciaInexistenteException;
import model.exception.CursoInexistenteException;
import model.service.api.CursoService;

// É NO SERVICE QUE SÃO IMPLEMENTADAS AS REGRAS DE NEGÓCIO
// É NO SERVICE QUE SÃO FEITAS AS VALIDAÇÕES
// O SERVICE REALIZA A COMUNICAÇÃO COM A CAMADA DAO
// NEM O CONTROLLER NEM A VISÃO PODEM ACESSAR O DAO DIRETAMENTE, SOMENTE ATRAVES DO SERVICE

public class CursoServiceImpl implements CursoService {
	
	private CursoDAO cursoDao;
	
	public CursoServiceImpl() {
		this.cursoDao = new CursoDaoImpl();
	}
	
	@Override
	public void salvar(Curso curso) {
		this.cursoDao.salvar(curso);
	}
	
	@Override
	public void excluir(int id) {
		Curso cursoParaExclusao = this.buscarPorId(id);
		if(cursoParaExclusao == null) {
			throw new CursoInexistenteException("Não foi possível obter o curso que você deseja remover!");
		}
		this.cursoDao.excluir(id);
	}
	
	@Override
	public List<Curso> listarTodos() {
		return this.cursoDao.listarTodos();
	}
	
	@Override
	public Curso buscarPorId(int id) {
		return this.cursoDao.buscarPorId(id);
	}
	
	

}

