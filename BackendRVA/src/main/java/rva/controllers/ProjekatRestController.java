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
import rva.jpa.Grupa;
import rva.jpa.Projekat;
import rva.reps.ProjekatRepository;

@RestController
@Api(tags = {"Projekat CRUD operacije"})
public class ProjekatRestController {
	
	@Autowired
	private ProjekatRepository projekatRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("projekat")
	@ApiOperation(value = "Vraća kolekciju svih projekata iz baze podataka")
	public Collection<Projekat> getProjekti(){
		return projekatRepository.findAll();
	}
	
	@GetMapping("projekat/{id}")
	@ApiOperation(value = "Vraća projekat iz baze podataka ciji je ID vrednost proslijeđena kao path varijabla")
	public Projekat getProjekat(@PathVariable("id") Integer id) {
		return projekatRepository.getOne(id);
	}
	
	@GetMapping("projekat/{naziv}")
	@ApiOperation(value = "Vraća kolekciju projekata iz baze podataka koji u nazivu sadrže string prosljeđen kao path varijabla")
	public Collection<Projekat> getProjekatByNaziv(@PathVariable ("naziv") String naziv){
		return projekatRepository.findByNazivContainingIgnoreCase(naziv);
	}
	
	@DeleteMapping("projekat/{id}")
	@CrossOrigin
	@ApiOperation(value = "Briše projekat iz baze podataka ciji je ID vrednost proslijeđena kao path varijabla")
	public ResponseEntity<Projekat> deleteProjekat(@PathVariable("id") Integer id){
		if(projekatRepository.existsById(id)) {
			projekatRepository.deleteById(id);
			if(id == -100)
				jdbcTemplate.execute("INSERT INTO \"projekat\"(\"id\", \"naziv\", \"oznaka\", \"opis\")\r\n" + 
									 "VALUES(-100, 'Test SoapUI', 'TO', 'Test opis grupe')");
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("projekat")
	@CrossOrigin
	@ApiOperation(value = "Upisuje novi projekat u bazu podataka")
	public ResponseEntity<Projekat> insertProjekat(@RequestBody Projekat projekat){
		if(projekatRepository.existsById(projekat.getId())){
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		projekatRepository.save(projekat);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@PutMapping("projekat")
	@CrossOrigin
	@ApiOperation(value = "Modifikuje postojeći projekat u bazi podataka")
	public ResponseEntity<Projekat> updateProjekat(@RequestBody Projekat  projekat){
		if(projekatRepository.existsById(projekat.getId())) {
			projekatRepository.save(projekat);
			return new ResponseEntity<>(HttpStatus.OK);
		}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	
}
