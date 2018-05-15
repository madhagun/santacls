package com.ibm.br.bluemix.secretsanta.secretsanta;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteRepository extends MongoRepository<Participante, String> {

}
