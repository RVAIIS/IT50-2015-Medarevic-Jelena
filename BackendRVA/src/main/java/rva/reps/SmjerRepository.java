package rva.reps;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import rva.jpa.Smjer;

public interface SmjerRepository  extends JpaRepository<Smjer, Integer>{
	Collection<Smjer> findByNazivContainingIgnoreCase(String naziv);
}
