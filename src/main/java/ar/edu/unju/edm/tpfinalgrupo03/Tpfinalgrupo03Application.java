package ar.edu.unju.edm.tpfinalgrupo03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.edm.tpfinalgrupo03.models.User;
import ar.edu.unju.edm.tpfinalgrupo03.services.IUserService;

@SpringBootApplication
public class Tpfinalgrupo03Application /*implements CommandLineRunner*/{

	public static void main(String[] args) {
		// System.out.println("a");
		SpringApplication.run(Tpfinalgrupo03Application.class, args);
	}
	
	/*@Autowired
	User user;
	
	@Autowired
	IUserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		user.setId(0);
		user.setIdCard(1234567);
		user.setPassword("test123");
		user.setName("test");
		user.setSurname("123");
		user.setStatus(true);
		userService.saveUser(user);
		System.out.println("save user");
	}*/
	
}
