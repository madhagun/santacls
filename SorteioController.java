package com.ibm.br.bluemix.secretsanta.secretsanta;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SorteioController {

	@Autowired
	ParticipanteRepository partRepo;

	@Autowired
	SorteioRepository sorteioRepo;

	@RequestMapping(value="/sorteio",
            method=RequestMethod.GET
            )

    public void sorteio(HttpServletResponse res) {

        sorteioRepo.deleteAll();

        List<Participante> participants = partRepo.findAll();

        if ( participants == null || participants.size() < 2 ) {
            res.setStatus(HttpStatus.PRECONDITION_FAILED.value());
        }
	List<Participante> sorteio = new ArrayList<Participante>(participants);
        Collections.shuffle(sorteio);

	    for ( Participante p : participants ) {
            Sorteio s = new Sorteio();
            s.setParticipante(p);

            Participante amigo = sorteio.get(0);
            if ( amigo.getEmail().equals(p.getEmail()) ) {
                amigo = sorteio.remove(1);
            } else {
                amigo = sorteio.remove(0);
            }

            s.setAmigoSecreto(amigo);
	        sorteioRepo.save(s);
        }
    }

}


