package controller.impl;

import java.util.List;

import controller.api.FuncionarioController;
import model.entidade.Funcionario;
import model.exception.CursoInexistenteException;
import model.service.api.FuncionarioService;
import model.service.impl.FuncionarioServiceImpl;

// SE TIVER USANDO NO ANDROID, POR EXEMPLO, É NO CONTROLLER QUE DEVERÃO SER FEITAS AS DEVIDAS CONVERSÕES
// PARA QUE O SOFTWARE FUNCIONE ADEQUADAMENTE.

// O CONTROLADOR É O RESPONSÁVEL POR GARANTIR A COMPATIBILIDADE DA VISÃO COM O MODELO

public class FuncionarioControllerImpl implements FuncionarioController {
	
	private FuncionarioService funcionarioService;
	
	public FuncionarioControllerImpl() {
		this.funcionarioService = new FuncionarioServiceImpl();
	}
	
	@Override
	public void salvar(Funcionario funcionario) {
		this.funcionarioService.salvar(funcionario);
	}
	
	@Override
	public void excluir(int id) throws CursoInexistenteException {
		this.funcionarioService.excluir(id);
	}
	
	@Override
	public List<Funcionario> listarTodos() {
		return this.funcionarioService.listarTodos();
	}
	
	@Override
	public Funcionario buscarPorId(int id) {
		return this.funcionarioService.buscarPorId(id);
	}

}

