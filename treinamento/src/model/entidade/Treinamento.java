package model.entidade;

import java.util.Date;

public class Treinamento {
	
	private int idTreinamento;
	private String nomeCurso;
	private String dataInicio;
	private String dataTermino;
	private String cargaHoraria;
	
	
	private int notaFuncionario;
	private String vigencia;
	private boolean treinamentoConcluido;
	
	private float custo;
	
	
	private int funcionario_id;
	private int areaAbrangencia_id;
	private int curso_id;
	
	
	public Treinamento() {}

	public int getIdTreinamento() {
		return idTreinamento;
	}

	public void setIdTreinamento(int idTreinamento) {
		this.idTreinamento = idTreinamento;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getNotaFuncionario() {
		return notaFuncionario;
	}

	public void setNotaFuncionario(int notaFuncionario) {
		this.notaFuncionario = notaFuncionario;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

	public boolean isTreinamentoConcluido() {
		return treinamentoConcluido;
	}

	public void setTreinamentoConcluido(boolean treinamentoConcluido) {
		this.treinamentoConcluido = treinamentoConcluido;
	}

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		this.custo = custo;
	}
	
	
	//#########################################
	
	

	public int getFuncionario_id() {
		return funcionario_id;
	}

	public void setFuncionario_id(int funcionario_id) {
		this.funcionario_id = funcionario_id;
	}

	public int getAreaAbrangencia_id() {
		return areaAbrangencia_id;
	}

	public void setAreaAbrangencia_id(int areaAbrangencia_id) {
		this.areaAbrangencia_id = areaAbrangencia_id;
	}

	public int getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
	}

	
	

	
}
