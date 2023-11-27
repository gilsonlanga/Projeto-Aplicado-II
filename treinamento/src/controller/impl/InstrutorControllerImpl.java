package controller.impl;

import java.util.List;

import controller.api.InstrutorController;
import model.entidade.Instrutor;
import model.exception.InstrutorInexistenteException;
import model.service.api.InstrutorService;
import model.service.impl.InstrutorServiceImpl;

// SE TIVER USANDO NO ANDROID, POR EXEMPLO, É NO CONTROLLER QUE DEVERÃO SER FEITAS AS DEVIDAS CONVERSÕES
// PARA QUE O SOFTWARE FUNCIONE ADEQUADAMENTE.

// O CONTROLADOR É O RESPONSÁVEL POR GARANTIR A COMPATIBILIDADE DA VISÃO COM O MODELO

public class InstrutorControllerImpl implements InstrutorController {
	
	private InstrutorService instrutorService;
	
	public InstrutorControllerImpl() {
		this.instrutorService = new InstrutorServiceImpl();
	}
	
	@Override
	public void salvar(Instrutor instrutor) {
		this.instrutorService.salvar(instrutor);
	}
	
	@Override
	public void excluir(int id) throws InstrutorInexistenteException {
		this.instrutorService.excluir(id);
	}
	
	@Override
	public List<Instrutor> listarTodos() {
		return this.instrutorService.listarTodos();
	}
	
	@Override
	public Instrutor buscarPorId(int id) {
		return this.instrutorService.buscarPorId(id);
	}

}

