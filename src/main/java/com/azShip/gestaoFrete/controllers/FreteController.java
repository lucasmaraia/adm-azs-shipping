package com.azShip.gestaoFrete.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.azShip.gestaoFrete.entities.Frete;
import com.azShip.gestaoFrete.services.FreteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Controller
@RequestMapping(value="/frete", produces = {"application/json"})
@Tag(name="DESAFIO BACKEND AZSHIP")
public class FreteController {
	
	@Autowired
	private FreteService freteService;
	
	@Operation(summary = "Cadastra um frete obs: (não recomendado mandar o campo id)", method = "POST")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Frete> createFrete(@RequestBody Frete frete){
		return ResponseEntity.status(HttpStatus.CREATED).body(freteService.save(frete));
	}
	
	@Operation(summary = "Realiza a busca de todos os fretes cadastrados sem paginação", method = "GET")
	@GetMapping
	public ResponseEntity<List<Frete>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(freteService.findAll());
	
	}
				
	@Operation(summary = "Realiza a busca de fretes cadastrados por paginação", method = "GET")
	@GetMapping("/paged")
	public ResponseEntity<Page<Frete>> findAllPaged(@RequestParam(required=false) Integer page, @RequestParam(required=false) Integer size){
		Page<Frete> fretePage = freteService.findAll(PageRequest.of(page, size));
		return ResponseEntity.status(HttpStatus.OK).body(fretePage);
	
	}
	
	@Operation(summary = "Realiza a busca de fretes cadastrados por ID", method = "GET")
	@GetMapping("/{id}")
	public ResponseEntity<Frete>findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(freteService.findById(id).get());
	
	}
	
	@Operation(summary = "Realiza a atualização de frete por ID", method = "PUT")
	@PutMapping("/{id}")
	public ResponseEntity<Frete> updateFrete(@PathVariable Long id,@RequestBody Frete updateFrete){
		Frete frete = freteService.update(id, updateFrete);
		if(frete != null) {
			return ResponseEntity.status(HttpStatus.OK).body(frete);
		}else {
			return ResponseEntity.notFound().build();
		}
				               
	}
	
	@Operation(summary = "Realiza a deleção de frete por ID", method = "DELETE")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFrete(@PathVariable Long id){
		freteService.delete(id);
		return ResponseEntity.ok("Frete deleted successfully!.");
		
	}

}
