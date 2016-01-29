package webAppProject.persistence.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import webAppProject.domain.Request;
import webAppProject.domain.User;


public interface RequestRepository extends CrudRepository<Request, Integer> {
	
	public Request findById(int id);
	
	public List<Request> findByStatus(String status);
	public List<Request> findByDeveloper(String developer);
	public Request findByProblem(String problem);
	public Request findByreqType(String reqType);
	
}
