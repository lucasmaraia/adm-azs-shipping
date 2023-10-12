package com.azShip.gestaoFrete.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.azShip.gestaoFrete.entities.Frete;
import com.azShip.gestaoFrete.repositories.FreteRepository;

@Service
public class FreteService {
	
	@Autowired
	private FreteRepository freteRepository;
	
	public Frete save(Frete frete) {
		return freteRepository.save(frete);
	}
	
	public List<Frete> findAll (){
		return freteRepository.findAll();
	}
	
	 public Page<Frete> findAll(Pageable pageable) {
	        return freteRepository.findAll(pageable);
	    }
	
	public Optional<Frete> findById(Long id) {
		return freteRepository.findById(id);
	}
	
	public void delete(Long id) {
		Optional<Frete> f = findById(id);
		freteRepository.delete(f.get());
	}
	
	public Frete update(Long id, Frete frete) {
		Optional<Frete> f = findById(id);
		
		if(f.isPresent()) {
			f.get().setNome(frete.getNome());
			f.get().setEndereco(frete.getEndereco());
			f.get().setEmail(frete.getEmail());
			f.get().setTelefone(frete.getTelefone());
			f.get().setPeso(frete.getPeso());
			f.get().setLargura(frete.getLargura());
			f.get().setValor(frete.getValor());
			f.get().setIcms(frete.getIcms());
			
			return save(f.get());
	
		}else {
			return null;
		}
	}
	

}
