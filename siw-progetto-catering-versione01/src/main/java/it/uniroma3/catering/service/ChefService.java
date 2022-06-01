package it.uniroma3.catering.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.catering.model.Chef;
import it.uniroma3.catering.repository.ChefRepository;

@Service
public class ChefService {
	
	@Autowired
	private ChefRepository chefRepository;
	
	@Transactional
	public void save(Chef chef) { 
		// Il save è di tipo transactional
		chefRepository.save(chef);
	}
	
	@Transactional
	public void delete(Chef chef) { 
		// Il save è di tipo transactional
		chefRepository.delete(chef);
	}
	
	@Transactional
	public void deleteById(Long id) {
		chefRepository.deleteById(id);
	}
	
	public Chef findById (Long id) {
		return chefRepository.findById(id).get();
	}
	
	public List<Chef> findAll() {
		List<Chef> chefs = new ArrayList<Chef>();
		for (Chef c : chefRepository.findAll()) {
			chefs.add(c);
		}
		return chefs;
	}
	
	// Metodo che risponde ad una validazione del Validator
	public boolean alreadyExists(Chef chef) {
		return chefRepository.existsByNomeAndCognomeAndNazionalita
				(chef.getNome(), chef.getCognome(), chef.getNazionalita());
	}
}

