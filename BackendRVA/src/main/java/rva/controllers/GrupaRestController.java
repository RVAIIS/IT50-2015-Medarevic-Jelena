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
import rva.jpa.Grupa;
import rva.reps.GrupaRepository;

@RestController
@Api(tags = {"Grupa CRUD operacije"})
public class GrupaRestController {
	
	@Autowired
	private GrupaRepository grupaRepository;
	
	@GetMapping("grupa")
	@ApiOperation(value = "Vraća kolekciju svih grupa iz baze podataka")
	public Collection<Grupa> getGrupe(){
		return grupaRepository.findAll();
	}
	
	@DeleteMapping("grupaId/{id}")
	@ApiOperation(value = "Briše grupu u bazi podataka čiji je id vrednost prosleđena kao path varijabla")
	public ResponseEntity<Grupa> deleteGrupa(@PathVariable ("id") Integer id){
		if(!grupaRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		grupaRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("grupa")
	@ApiOperation(value = "Upisuje novu grupu u bazu podataka")
	public ResponseEntity<Grupa> insertGrupa(@RequestBody Grupa grupa){
		if(!grupaRepository.existsById(grupa.getId())){
			grupaRepository.save(grupa);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	

	@PutMapping("grupa")
	@ApiOperation(value = "Modifikuje postojeću grupu u bazi podataka")
	public ResponseEntity<Grupa> updateGrupa(@RequestBody Grupa  grupa){
		if(!grupaRepository.existsById(grupa.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		grupaRepository.save(grupa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	

}
