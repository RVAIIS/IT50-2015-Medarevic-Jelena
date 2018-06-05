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
import rva.jpa.Smjer;
import rva.jpa.Student;
import rva.reps.StudentRepository;

@RestController
@Api(tags = {"Student CRUD operacije"})
public class StudentRestController {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("student")
	@ApiOperation(value = "Vraća kolekciju svih studenata iz baze podataka")
	public Collection<Student> getStudent(){
		return studentRepository.findAll();
	}
	
	@GetMapping("student/{id}")
	@ApiOperation(value = "Vraća studenta iz baze podataka ciji je ID vrednost proslijeđena kao path varijabla")
	public Student getStudent(@PathVariable("id") Integer id) {
		return studentRepository.getOne(id);
	}
	
	@DeleteMapping("student/{id}")
	@CrossOrigin
	@ApiOperation(value = "Briše studenta iz baze podataka ciji je ID vrednost proslijeđena kao path varijabla")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer id){
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
			if(id == -100)
				jdbcTemplate.execute("INSERT INTO \"student\"(\"id\", \"ime\", \"prezime\", \"broj_indeksa\", \"grupa\", \"projekat\")\r\n" + 
									 "VALUES(-100, 'TestI', 'TestP', 'IT15', 1, 2)");
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("student")
	@CrossOrigin
	@ApiOperation(value = "Upisuje novog studenta u bazu podataka")
	public ResponseEntity<Student> insertStudent(@RequestBody Student student){
		if(studentRepository.existsById(student.getId())){
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		System.out.println("Broj indeksa:" +student.getBrojIndeksa());
		studentRepository.save(student);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("student")
	@CrossOrigin
	@ApiOperation(value = "Modifikuje postojećeg studenata u bazi podataka")
	public ResponseEntity<Student> updateStudent(@RequestBody Student  student){
		if(studentRepository.existsById(student.getId())) {
			studentRepository.save(student);
			return new ResponseEntity<>(HttpStatus.OK);
		}
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	

} 
