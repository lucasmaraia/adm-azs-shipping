package com.azShip.gestaoFrete.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.azShip.gestaoFrete.entities.Frete;

public interface FreteRepository extends JpaRepository<Frete, Long> {
	
	Page<Frete> findAll(Pageable pageable);

}
