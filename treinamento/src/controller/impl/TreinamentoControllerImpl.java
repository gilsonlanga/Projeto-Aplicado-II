package controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.api.TreinamentoController;
import model.entidade.Treinamento;
import model.exception.TreinamentoInexistenteException;
import model.service.api.TreinamentoService;
import model.service.impl.TreinamentoServiceImpl;

// SE TIVER USANDO NO ANDROID, POR EXEMPLO, É NO CONTROLLER QUE DEVERÃO SER FEITAS AS DEVIDAS CONVERSÕES
// PARA QUE O SOFTWARE FUNCIONE ADEQUADAMENTE.

// O CONTROLADOR É O RESPONSÁVEL POR GARANTIR A COMPATIBILIDADE DA VISÃO COM O MODELO

public class TreinamentoControllerImpl implements TreinamentoController {
	
	private TreinamentoService treinamentoService;
	
	public TreinamentoControllerImpl() {
		this.treinamentoService = new TreinamentoServiceImpl();
	}
	
	@Override
	public void salvar(Treinamento treinamento) {
		this.treinamentoService.salvar(treinamento);
	}
	
	@Override
	public void excluir(int id) throws TreinamentoInexistenteException {
		this.treinamentoService.excluir(id);
	}
	
	@Override
	public List<Treinamento> listarTodos() {
		return this.treinamentoService.listarTodos();
	}
	
	@Override
	public Treinamento buscarPorId(int id) {
		return this.treinamentoService.buscarPorId(id);
	}
	
	@Override
	public List<Treinamento> listarNome(String nomeCurso) {
		return this.treinamentoService.listarNome(nomeCurso);
	}
	
	@Override
	public List<Treinamento> listarVigencia(String dataVigencia) {
		return this.treinamentoService.listarVigencia(dataVigencia);
	}
	
	@Override
	public List<Treinamento> listarFuncionario(String funcionario) {
		return this.treinamentoService.listarFuncionario(funcionario);
	}
	
	@Override
	public List<Treinamento> listarDataTermino(String dataTermino) {
		return this.treinamentoService.listarDataTermino(dataTermino);
	}
	
	
	


}

