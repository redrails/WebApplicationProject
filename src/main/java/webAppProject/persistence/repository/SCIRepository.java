package webAppProject.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import webAppProject.domain.SCI;



public interface SCIRepository extends CrudRepository<SCI, Integer> {
	
	public SCI findById(int id);
	public SCI findByName(String name);
	
}
