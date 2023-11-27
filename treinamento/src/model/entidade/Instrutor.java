package model.entidade;

public class Instrutor {
	
	private int idInstrutor;
	private String nome;
	private String formacao;
	private int instituicao_id;
	
	public Instrutor() {}

	public int getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(int idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public int getInstituicao_id() {
		return instituicao_id;
	}

	public void setInstituicao_id(int instituicao_id) {
		this.instituicao_id = instituicao_id;
	}
	
	

}
