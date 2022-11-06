package co.mkabir.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	// Get /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {

		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable Integer id) {

		return service.findOne(id);
	}
	
	@DeleteMapping("/users/{id}")
	public  void deleteUser(@PathVariable Integer id) {

		 service.deleteById(id);
	}

	// POST /users
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User saveduser = service.save(user);
		// creating the url for the newly created user
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(saveduser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
