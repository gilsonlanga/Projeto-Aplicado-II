package model.service.impl;

import java.util.List;

import model.dao.api.CursoDAO;
import model.dao.api.FuncionarioDAO;
import model.dao.impl.CursoDaoImpl;
import model.dao.impl.FuncionarioDaoImpl;
import model.entidade.Curso;
import model.entidade.Funcionario;
import model.exception.AreaAbrangenciaInexistenteException;
import model.exception.FuncionarioInexistenteException;
import model.service.api.CursoService;
import model.service.api.FuncionarioService;

// É NO SERVICE QUE SÃO IMPLEMENTADAS AS REGRAS DE NEGÓCIO
// É NO SERVICE QUE SÃO FEITAS AS VALIDAÇÕES
// O SERVICE REALIZA A COMUNICAÇÃO COM A CAMADA DAO
// NEM O CONTROLLER NEM A VISÃO PODEM ACESSAR O DAO DIRETAMENTE, SOMENTE ATRAVES DO SERVICE

public class FuncionarioServiceImpl implements FuncionarioService {
	
	private FuncionarioDAO funcionarioDao;
	
	public FuncionarioServiceImpl() {
		this.funcionarioDao = new FuncionarioDaoImpl();
	}
	
	@Override
	public void salvar(Funcionario funcionario) {
		this.funcionarioDao.salvar(funcionario);
	}
	
	@Override
	public void excluir(int id) {
		Funcionario funcionarioParaExclusao = this.buscarPorId(id);
		if(funcionarioParaExclusao == null) {
			throw new FuncionarioInexistenteException("Não foi possível obter o funcionário que você deseja remover!");
		}
		this.funcionarioDao.excluir(id);
	}
	
	@Override
	public List<Funcionario> listarTodos() {
		return this.funcionarioDao.listarTodos();
	}
	
	@Override
	public Funcionario buscarPorId(int id) {
		return this.funcionarioDao.buscarPorId(id);
	}
	
	

}

