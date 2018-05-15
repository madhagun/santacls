package com.ibm.br.bluemix.secretsanta.secretsanta;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.Id;


public class Sorteio {

	@Id
	private String Id;

	//@Indexed
	@DBRef
	private Participante participante;
	
	@DBRef
	private Participante amigoSecreto;

	public Sorteio () {
	}

	public Sorteio ( String tid, Participante  tpart, Participante tamigo ) {
		this.Id= tid;
		this.participante = tpart;
		this.amigoSecreto = tamigo;
	}

	public String getId () {
		return Id;
	}

	public String setId( String tid) {
		this.Id= tid;
		return this.Id;
	}

	public void setParticipante ( Participante tpart) {
		this.participante = tpart;
	}

	public void setAmigoSecreto( Participante tpart) {
		this.amigoSecreto = tpart;
	}
}
