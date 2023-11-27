package controller.api;

import java.util.List;

import model.entidade.Curso;
import model.exception.CursoInexistenteException;

public interface CursoController {
	
	public void salvar(Curso curso);
	public void excluir(int id) throws CursoInexistenteException; //para mandar a execption pra visão
	public List<Curso> listarTodos();
	public Curso buscarPorId(int id);
	

}