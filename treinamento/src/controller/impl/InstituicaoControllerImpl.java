package controller.impl;

import java.util.List;

import controller.api.InstituicaoController;
import model.entidade.Instituicao;
import model.exception.InstituicaoInexistenteException;
import model.service.api.InstituicaoService;
import model.service.impl.InstituicaoServiceImpl;

// SE TIVER USANDO NO ANDROID, POR EXEMPLO, É NO CONTROLLER QUE DEVERÃO SER FEITAS AS DEVIDAS CONVERSÕES
// PARA QUE O SOFTWARE FUNCIONE ADEQUADAMENTE.

// O CONTROLADOR É O RESPONSÁVEL POR GARANTIR A COMPATIBILIDADE DA VISÃO COM O MODELO

public class InstituicaoControllerImpl implements InstituicaoController {
	
	private InstituicaoService instituicaoService;
	
	public InstituicaoControllerImpl() {
		this.instituicaoService = new InstituicaoServiceImpl();
	}
	
	@Override
	public void salvar(Instituicao instituicao) {
		this.instituicaoService.salvar(instituicao);
	}
	
	@Override
	public void excluir(int id) throws InstituicaoInexistenteException {
		this.instituicaoService.excluir(id);
	}
	
	@Override
	public List<Instituicao> listarTodos() {
		return this.instituicaoService.listarTodos();
	}
	
	@Override
	public Instituicao buscarPorId(int id) {
		return this.instituicaoService.buscarPorId(id);
	}

}

