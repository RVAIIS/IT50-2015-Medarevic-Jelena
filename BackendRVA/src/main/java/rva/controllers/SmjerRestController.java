package rva.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import rva.jpa.Smjer;
import rva.reps.SmjerRepository;

@RestController
@Api(tags = {"Smjer CRUD operacije"})
public class SmjerRestController {
	
	@Autowired
	private SmjerRepository smjerRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("smjer")
	@ApiOperation(value = "Vraća kolekciju svih smjerova iz baze podataka")
	public Collection<Smjer> getSmjer(){
		return smjerRepository.findAll();
	}
	
	@GetMapping("smjer/{id}")
	@ApiOperation(value = "Vraća smjer iz baze podataka ciji je ID vrednost proslijeđena kao path varijabla")
	public Smjer getSmjer(@PathVariable("id") Integer id) {
		return smjerRepository.getOne(id);
	}
	
	@DeleteMapping("smjer/{id}")
	@CrossOrigin
	@ApiOperation(value = "Briše smjer iz baze podataka ciji je ID vrednost proslijeđena kao path varijabla")
	public ResponseEntity<Smjer> deleteSmjer(@PathVariable("id") Integer id){
		if(smjerRepository.existsById(id)) {
			smjerRepository.deleteById(id);
			if(id == -100)
				jdbcTemplate.execute("INSERT INTO \"smjer\"(\"id\", \"naziv\", \"oznaka\")\r\n" + 
									 "VALUES(-100, 'Test SoapUI smjer', 'TO')");
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("smjer")
	@CrossOrigin
	@ApiOperation(value = "Upisuje novi smjer u bazu podataka")
	public ResponseEntity<Smjer> insertSmjer(@RequestBody Smjer smjer){
		if(smjerRepository.existsById(smjer.getId())){
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		smjerRepository.save(smjer);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	@PutMapping("smjer")
	@CrossOrigin
	@ApiOperation(value = "Modifikuje postojeći smjer u bazi podataka")
	public ResponseEntity<Smjer> updateSmjer(@RequestBody Smjer  smjer){
		if(smjerRepository.existsById(smjer.getId())) {
			smjerRepository.save(smjer);
			return new ResponseEntity<>(HttpStatus.OK);
		}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	

}
