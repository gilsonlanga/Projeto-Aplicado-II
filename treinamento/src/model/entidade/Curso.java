package model.entidade;

import java.util.Date;

public class Curso {
	
	private int id;
	private String nome;
	private String dataInicio;		// COMO NÃO CONSEGUIA CONVERTER GETTEXT PARA DATE, ALTEREI PARA STRING POR ENQUANTO
	private String dataTermino;		// COMO NÃO CONSEGUIA CONVERTER GETTEXT PARA DATE, ALTEREI PARA STRING POR ENQUANTO
	private String cargaHoraria;
	public int instrutor_id;
	public int instrutor_instituicao_id;
	
	public Curso() {}


	public int getIdCurso() {
		return id;
	}


	public void setIdCurso(int idCurso) {
		this.id = idCurso;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
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

	//###################################


	public int getInstrutor_id() {
		return instrutor_id;
	}


	public void setInstrutor_id(int instrutor_id) {
		this.instrutor_id = instrutor_id;
	}


	public int getInstrutor_instituicao_id() {
		return instrutor_instituicao_id;
	}


	public void setInstrutor_instituicao_id(int instrutor_instituicao_id) {
		this.instrutor_instituicao_id = instrutor_instituicao_id;
	}
	
	
	
	
	

}
