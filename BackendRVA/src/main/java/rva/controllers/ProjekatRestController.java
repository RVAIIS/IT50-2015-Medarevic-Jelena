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
import rva.jpa.Projekat;
import rva.reps.ProjekatRepository;

@RestController
@Api(tags = {"Projekat CRUD operacije"})
public class ProjekatRestController {
	
	@Autowired
	private ProjekatRepository projekatRepository;
	
	@GetMapping("projekat")
	@ApiOperation(value = "Vraća kolekciju svih projekata iz baze podataka")
	public Collection<Projekat> getProjekat(){
		return projekatRepository.findAll();
	}
	
	@DeleteMapping("projekatId/{id}")
	@ApiOperation(value = "Briše projekat u bazi podataka čiji je id vrednost prosleđena kao path varijabla")
	public ResponseEntity<Projekat> deleteProjekat(@PathVariable ("id") Integer id){
		if(!projekatRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		projekatRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("projekat")
	@ApiOperation(value = "Upisuje novi projekat u bazu podataka")
	public ResponseEntity<Projekat> insertProjekat(@RequestBody Projekat projekat){
		if(!projekatRepository.existsById(projekat.getId())){
			projekatRepository.save(projekat);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("projekat")
	@ApiOperation(value = "Modifikuje postojeći projekat u bazi podataka")
	public ResponseEntity<Projekat> updateProjekat(@RequestBody Projekat  projekat){
		if(!projekatRepository.existsById(projekat.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		projekatRepository.save(projekat);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
