package br.com.ecommerce.accounts.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import br.com.ecommerce.accounts.model.User;
import br.com.ecommerce.accounts.model.UserFactory;
import br.com.ecommerce.accounts.model.UserRole;
import br.com.ecommerce.accounts.repository.UserRepository;

@Service
public class UserAdminCreation {

	@Autowired
	private UserRepository rp;
	@Value("${user.admin.username}")
	private String username;
	@Value("${user.admin.password}")
	private String password;
	
	
	public void createUserAdmin() {
		if(!rp.existsByUsername(username)) {
			User userAdmin = new UserFactory()
					.createUserAdmin(username, password, UserRole.ADMIN)
					.build();

			rp.save(userAdmin);
		}
	}
}