package galerie.phototheque;

import galerie.phototheque.entity.Role;
import galerie.phototheque.service.RoleServiceImp;
import galerie.phototheque.service.UtilisateurServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhotothequeProjectApplication implements CommandLineRunner {
	@Autowired
	private UtilisateurServiceImp utilisateurServiceImp;

	@Autowired
	private RoleServiceImp roleServiceImp;

	public static void main(String[] args) {
		SpringApplication.run(PhotothequeProjectApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		ajouterRole();
		ajouterUser();
	}
	void ajouterRole(){
		Role role = new Role();
		role.setType_role("ROLE_USER");
		roleServiceImp.addRole(role);
	}
	void ajouterUser(){

	}


}
