package com.ibm.br.bluemix.secretsanta.secretsanta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;



import java.util.List;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {

	@Autowired
	ParticipanteRepository partRepo;

	@Autowired
	SorteioRepository sorteioRepo;

@RequestMapping(value="/add",
            method=RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE)
    public void addParticipante(@RequestBody Participante p) {

        partRepo.save(p);
        
    }

@RequestMapping(value="/list",
            method=RequestMethod.GET
            )
    public List<Participante> listParticipante() {

        return partRepo.findAll();

    }

@RequestMapping(value="/delete/{email}",
            method=RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE
            )
    public void deleteParticipante(@PathVariable String email) {

        System.out.println("Deleting: " + email);

        sorteioRepo.deleteAll();
       // partRepo.delete(email);

    }
}
