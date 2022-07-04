package ar.edu.unju.edm.tpfinalgrupo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.edm.tpfinalgrupo03.models.User;
import ar.edu.unju.edm.tpfinalgrupo03.repositories.UserRepository;
import ar.edu.unju.edm.tpfinalgrupo03.services.IUserService;

@SpringBootApplication
public class Tpfinalgrupo03Application implements CommandLineRunner{

	public static void main(String[] args) {
		// System.out.println("a");
		SpringApplication.run(Tpfinalgrupo03Application.class, args);
	}
	
	@Autowired
	User user;
	
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	IUserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		User changeUser = userRepository.findById(1).get();
		System.out.println("user ID: " + changeUser.getId());
		//changeUser.setRole("CLIENT");
		//changeUser.setRole("ADMIN");
		userRepository.save(changeUser);
		System.out.println("change role user " + changeUser.getName() + " to: " + changeUser.getRole());
		*/
	}
	
}
