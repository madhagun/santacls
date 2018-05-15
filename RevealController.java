package com.ibm.br.bluemix.secretsanta.secretsanta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.http.MediaType;



@RestController
@RequestMapping("/reveal")
public class RevealController {

	@Autowired
	ParticipanteRepository partRepo;

	@Autowired
	SorteioRepository sorteioRepo;

@RequestMapping(value="/all",
            method=RequestMethod.GET
            )
    public List<Sorteio> reveal() {

        List<Sorteio> sorteio = sorteioRepo.findAll();
        return sorteio;

    }

@RequestMapping(value="/{email}",
            method=RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE
            )
    public Sorteio reveal(@PathVariable String email) {

        return sorteioRepo.reveal(email);

    }


}

