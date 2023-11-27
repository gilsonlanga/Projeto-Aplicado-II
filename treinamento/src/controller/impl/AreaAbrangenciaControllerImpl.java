package controller.impl;

import java.util.List;

import controller.api.AreaAbrangenciaController;
import model.entidade.AreaAbrangencia;
import model.exception.AreaAbrangenciaInexistenteException;
import model.service.api.AreaAbrangenciaService;
import model.service.impl.AreaAbrangenciaServiceImpl;

// SE TIVER USANDO NO ANDROID, POR EXEMPLO, É NO CONTROLLER QUE DEVERÃO SER FEITAS AS DEVIDAS CONVERSÕES
// PARA QUE O SOFTWARE FUNCIONE ADEQUADAMENTE.

// O CONTROLADOR É O RESPONSÁVEL POR GARANTIR A COMPATIBILIDADE DA VISÃO COM O MODELO

public class AreaAbrangenciaControllerImpl implements AreaAbrangenciaController {
	
	private AreaAbrangenciaService areaAbrangenciaService;
	
	public AreaAbrangenciaControllerImpl() {
		this.areaAbrangenciaService = new AreaAbrangenciaServiceImpl();
	}
	
	@Override
	public void salvar(AreaAbrangencia areaAbrangencia) {
		this.areaAbrangenciaService.salvar(areaAbrangencia);
	}
	
	@Override
	public void excluir(int id) throws AreaAbrangenciaInexistenteException {
		this.areaAbrangenciaService.excluir(id);
	}
	
	@Override
	public List<AreaAbrangencia> listarTodos() {
		return this.areaAbrangenciaService.listarTodos();
	}
	
	@Override
	public AreaAbrangencia buscarPorId(int id) {
		return this.areaAbrangenciaService.buscarPorId(id);
	}

}
