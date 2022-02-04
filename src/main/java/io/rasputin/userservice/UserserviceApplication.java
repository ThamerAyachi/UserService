package io.rasputin.userservice;

import io.rasputin.userservice.model.AppUser;
import io.rasputin.userservice.model.Role;
import io.rasputin.userservice.service.AppUserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(AppUserServiceImpl appUserService){
		return args -> {
			appUserService.saveRole(new Role(null, "ROLE_USER"));
			appUserService.saveRole(new Role(null, "ROLE_MANAGER"));
			appUserService.saveRole(new Role(null, "ROLE_ADMIN"));
			appUserService.saveRole(new Role(null, "ROLE_SUPER_ADMEN"));

			appUserService.saveUser(new AppUser(null, "John Travolta", "john", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Will Smith", "will", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
			appUserService.saveUser(new AppUser(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));

			appUserService.addRoleToUser("john", "ROLE_USER");
			appUserService.addRoleToUser("john", "ROLE_MANAGER");
			appUserService.addRoleToUser("will", "ROLE_MANAGER");
			appUserService.addRoleToUser("jim", "ROLE_ADMIN");
			appUserService.addRoleToUser("arnold", "ROLE_SUPER_ADMEN");
			appUserService.addRoleToUser("arnold", "ROLE_ADMIN");
			appUserService.addRoleToUser("arnold", "ROLE_USER");
		};
	}

}
