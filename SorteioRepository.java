package com.ibm.br.bluemix.secretsanta.secretsanta;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SorteioRepository extends MongoRepository<Sorteio, String> {

	@Query(value="{ 'participante.email' : ?0 }")
	Sorteio reveal(String participanteEmail);
	
}

