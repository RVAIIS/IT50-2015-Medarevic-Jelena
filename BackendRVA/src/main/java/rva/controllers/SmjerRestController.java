package rva.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rva.jpa.Smjer;
import rva.reps.SmjerRepository;

@RestController
@Api(tags = {"Smjer CRUD operacije"})
public class SmjerRestController {
	
	@Autowired
	private SmjerRepository smjerRepository;
	
	@GetMapping("smjer")
	@ApiOperation(value = "Vraća kolekciju svih smjerova iz baze podataka")
	public Collection<Smjer> getSmjer(){
		return smjerRepository.findAll();
	}
	
	@DeleteMapping("smjerId/{id}")
	@ApiOperation(value = "Briše smjer u bazi podataka čiji je id vrednost prosleđena kao path varijabla")
	public ResponseEntity<Smjer> deleteSmjer(@PathVariable ("id") Integer id){
		if(!smjerRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		smjerRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("smjer")
	@ApiOperation(value = "Upisuje novi smjer u bazu podataka")
	public ResponseEntity<Smjer> insertSmjer(@RequestBody Smjer smjer){
		if(!smjerRepository.existsById(smjer.getId())){
			smjerRepository.save(smjer);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("smjer")
	@ApiOperation(value = "Modifikuje postojeći smjer u bazi podataka")
	public ResponseEntity<Smjer> updateSmjer(@RequestBody Smjer  smjer){
		if(!smjerRepository.existsById(smjer.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		smjerRepository.save(smjer);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
