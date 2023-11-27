package controller.api;

import java.util.List;

import model.entidade.Funcionario;
import model.exception.FuncionarioInexistenteException;

public interface FuncionarioController {
	
	public void salvar(Funcionario funcionario);
	public void excluir(int id) throws FuncionarioInexistenteException; //para mandar a execption pra visão
	public List<Funcionario> listarTodos();
	public Funcionario buscarPorId(int id);
	

}