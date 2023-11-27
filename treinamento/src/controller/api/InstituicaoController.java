package controller.api;

import java.util.List;


import model.entidade.Instituicao;
import model.exception.InstituicaoInexistenteException;

public interface InstituicaoController {
	
	public void salvar(Instituicao instituicao);
	public void excluir(int id) throws InstituicaoInexistenteException; //para mandar a execption pra visão
	public List<Instituicao> listarTodos();
	public Instituicao buscarPorId(int id);
	

}