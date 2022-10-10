package co.mkabir.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	// JPA/Hibernate > Database
	// UserDaoService > static list (now)

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(3, "Jim", LocalDate.now().minusYears(20)));
	}

	public List<User> findAll() {

		return users;
	}

	public User findUser(Integer id) {

		User userfind = users.stream().filter(usr -> usr.getId() == id).findFirst().orElse(null);
		return userfind;
	}

}
