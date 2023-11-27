package controller.impl;

import java.util.List;

import controller.api.CursoController;
import model.entidade.Curso;
import model.exception.CursoInexistenteException;
import model.service.api.CursoService;
import model.service.impl.CursoServiceImpl;

// SE TIVER USANDO NO ANDROID, POR EXEMPLO, É NO CONTROLLER QUE DEVERÃO SER FEITAS AS DEVIDAS CONVERSÕES
// PARA QUE O SOFTWARE FUNCIONE ADEQUADAMENTE.

// O CONTROLADOR É O RESPONSÁVEL POR GARANTIR A COMPATIBILIDADE DA VISÃO COM O MODELO

public class CursoControllerImpl implements CursoController {
	
	private CursoService cursoService;
	
	public CursoControllerImpl() {
		this.cursoService = new CursoServiceImpl();
	}
	
	@Override
	public void salvar(Curso curso) {
		this.cursoService.salvar(curso);
	}
	
	@Override
	public void excluir(int id) throws CursoInexistenteException {
		this.cursoService.excluir(id);
	}
	
	@Override
	public List<Curso> listarTodos() {
		return this.cursoService.listarTodos();
	}
	
	@Override
	public Curso buscarPorId(int id) {
		return this.cursoService.buscarPorId(id);
	}

}

