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
import rva.reps.GrupaRepository;
import rva.reps.SmjerRepository;

@RestController
@Api(tags = {"Grupa CRUD operacije"})
public class GrupaRestController {
	
	@Autowired
	private GrupaRepository grupaRepository;
	
	@Autowired
	private SmjerRepository smjerRepository;
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("grupa")
	@ApiOperation(value = "Vraća kolekciju svih grupa iz baze podataka")
	public Collection<Grupa> getGrupe(){
		return grupaRepository.findAll();
	}
	
	@GetMapping("grupa/{id}")
	@ApiOperation(value = "Vraća grupu iz baze podataka ciji je ID vrednost proslijeđena kao path varijabla")
	public Grupa getGrupa(@PathVariable("id") Integer id) {
		return grupaRepository.getOne(id);
	}
	
	
	@DeleteMapping("grupa/{id}")
	@CrossOrigin
	@ApiOperation(value = "Briše grupu iz baze podataka ciji je ID vrednost proslijeđena kao path varijabla")
	public ResponseEntity<Grupa> deleteGrupa(@PathVariable("id") Integer id){
		if(grupaRepository.existsById(id)) {
			grupaRepository.deleteById(id);
			if(id == -100)
				jdbcTemplate.execute("INSERT INTO \"grupa\"(\"id\", \"oznaka\", \"smjer\")\r\n" + 
									 "VALUES(-100, 'TS', 1)");
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("grupa")
	@CrossOrigin
	@ApiOperation(value = "Upisuje novu grupu u bazu podataka")
	public ResponseEntity<Grupa> insertGrupa(@RequestBody Grupa grupa){
		if(grupaRepository.existsById(grupa.getId())){
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		grupaRepository.save(grupa);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

	
	@PutMapping("grupa")
	@CrossOrigin
	@ApiOperation(value = "Modifikuje postojeću grupu u bazi podataka")
	public ResponseEntity<Grupa> updateGrupa(@RequestBody Grupa  grupa){
		if(grupaRepository.existsById(grupa.getId()))
		{
			grupaRepository.save(grupa);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	
	}
	
	

}
