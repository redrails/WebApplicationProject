package webAppProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import webAppProject.domain.Request;
import webAppProject.domain.Role;
import webAppProject.domain.User;
import webAppProject.domain.Version;
import webAppProject.persistence.repository.RequestRepository;
import webAppProject.persistence.repository.UserRepository;
import webAppProject.persistence.repository.VersionRepository;

@SpringBootApplication
public class webAppProjectApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(webAppProjectApplication.class, args);
    }

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private VersionRepository versionRepository;
    
	public static final int ROLE_PM = 1;
	public static final int ROLE_DEV = 2;
	
    @Override
	public void run(ApplicationArguments args) throws Exception {
		BCryptPasswordEncoder pe = new  BCryptPasswordEncoder();

		User user = new User();
		user.setLogin("alice");
		user.setPassword(pe.encode("password"));
		Role role = new Role();
		role.setId(ROLE_DEV);
		role.setRole("DEV");
		user.setRole(role);
		userRepo.save(user);
		
		user = new User();
		user.setLogin("bob");
		user.setPassword(pe.encode("admin"));
		role = new Role();
		role.setId(ROLE_PM);
		role.setRole("PM");
		user.setRole(role);
		userRepo.save(user);

		
		Version version = new Version();
		version.setVersion("version_1");
		versionRepository.save(version);
		
    }
    
}
