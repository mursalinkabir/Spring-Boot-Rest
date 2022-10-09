package co.mkabir.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//marking it as the controller
@RestController
public class HelloWorldController {

	// mapping the request and http method type
	//@RequestMapping(method = RequestMethod.GET,path = "/hello-world" )
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		
		return "Hello Worlds";
		
	}
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("Hello World");
		
	}
}
