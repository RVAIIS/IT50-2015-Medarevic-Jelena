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
import rva.jpa.Student;
import rva.reps.StudentRepository;

@RestController
@Api(tags = {"Student CRUD operacije"})
public class StudentRestController {
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("student")
	@ApiOperation(value = "Vraća kolekciju svih studenata iz baze podataka")
	public Collection<Student> getStudent(){
		return studentRepository.findAll();
	}
	
	@DeleteMapping("studentId/{id}")
	@ApiOperation(value = "Briše studenata u bazi podataka čiji je id vrednost prosleđena kao path varijabla")
	public ResponseEntity<Student> deleteStudent(@PathVariable ("id") Integer id){
		if(!studentRepository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		studentRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("student")
	@ApiOperation(value = "Upisuje novog studenta u bazu podataka")
	public ResponseEntity<Student> insertStudent(@RequestBody Student student){
		if(!studentRepository.existsById(student.getId())){
			studentRepository.save(student);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PutMapping("student")
	@ApiOperation(value = "Modifikuje postojećeg studenata u bazi podataka")
	public ResponseEntity<Student> updateStudent(@RequestBody Student  student){
		if(!studentRepository.existsById(student.getId()))
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		studentRepository.save(student);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
