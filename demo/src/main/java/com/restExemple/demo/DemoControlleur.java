package com.restExemple.demo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoControlleur {
	 private final Logger log = LoggerFactory.getLogger(DemoControlleur.class);
	    private CompagnieDAORepository compagnieRepository;

	    
	    public DemoControlleur(CompagnieDAORepository compagnieRepository) {
	        this.compagnieRepository = compagnieRepository;
	    }

	    @GetMapping("/compagnies")
	    Collection<AirCompagnie> groups() {
	        return compagnieRepository.findAll();
	    }
	    
	    
	    @GetMapping("/compagnie/{id}")
	    ResponseEntity<?> getCompagnie(@PathVariable Long id) {
	        Optional<AirCompagnie> compagnie = compagnieRepository.findById(id);
	        return compagnie.map(response -> ResponseEntity.ok().body(response))
	                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PostMapping("/compagnie")
	    ResponseEntity<AirCompagnie> createAirCompagnie(@Valid @RequestBody AirCompagnie compagnie) throws URISyntaxException {
	        log.info("Request to create group: {}", compagnie);
	        AirCompagnie result = compagnieRepository.save(compagnie);
	        return ResponseEntity.created(new URI("/api/compagnie/" + result.getId()))
	                .body(result);
	    }

	    @PutMapping("/compagnie")
	    ResponseEntity<AirCompagnie> updateGroup(@Valid @RequestBody AirCompagnie compagnie) {
	        log.info("Request to update compagnie: {}", compagnie);
	        AirCompagnie result = compagnieRepository.save(compagnie);
	        return ResponseEntity.ok().body(result);
	    }

	    @DeleteMapping("/compagnie/{id}")
	    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
	        log.info("Request to delete compagnie: {}", id);
	        compagnieRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
}
