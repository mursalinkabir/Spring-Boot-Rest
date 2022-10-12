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
	private static int usersCount =0;

	static {
		users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
	}

	public List<User> findAll() {

		return users;
	}

	public User findUser(Integer id) {

		User userfind = users.stream().filter(usr -> usr.getId() == id).findFirst().orElse(null);
		return userfind;
	}
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}

}
