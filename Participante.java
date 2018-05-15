package com.ibm.br.bluemix.secretsanta.secretsanta;

import org.springframework.data.annotation.Id;

public class Participante {

	@Id
	private String email;
	private String nome;
	private String sugestao;

	public Participante () {
	}

	public Participante ( String temail, String tnome, String tsugestao ) {
		this.email = temail;
		this.nome = tnome;
		this.sugestao = tsugestao;
	}

	public String getEmail () {
		return email;
	}

	public String getNome () {
		return nome;
	}

	public String getSugestao () {
		return sugestao;
	}

	public String setEmail ( String temail) {
		this.email = temail;
		return this.email;
	}

	public String setNome ( String tnome) {
		this.nome = tnome;
		return this.nome;
	}

	public String setSugestao ( String tsugestao) {
		this.sugestao = tsugestao;
		return this.sugestao;
	}
}
