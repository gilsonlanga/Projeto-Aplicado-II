package controller.api;

import java.util.List;

import model.entidade.AreaAbrangencia;
import model.exception.AreaAbrangenciaInexistenteException;

public interface AreaAbrangenciaController {
	
	public void salvar(AreaAbrangencia areaAbrangencia);
	public void excluir(int id) throws AreaAbrangenciaInexistenteException; //para mandar a execption pra visão
	public List<AreaAbrangencia> listarTodos();
	public AreaAbrangencia buscarPorId(int id);
	

}
