package controller.api;

import java.util.List;

import model.entidade.Instrutor;
import model.exception.InstrutorInexistenteException;

public interface InstrutorController {
	
	public void salvar(Instrutor instrutor);
	public void excluir(int id) throws InstrutorInexistenteException; //para mandar a execption pra visão
	public List<Instrutor> listarTodos();
	public Instrutor buscarPorId(int id);
	

}