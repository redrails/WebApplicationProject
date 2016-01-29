package webAppProject.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import webAppProject.domain.Version;



public interface VersionRepository extends CrudRepository<Version, Integer> {
	
	public Version findById(int id);
	
	public Version findByVersion(String name);
	
}
