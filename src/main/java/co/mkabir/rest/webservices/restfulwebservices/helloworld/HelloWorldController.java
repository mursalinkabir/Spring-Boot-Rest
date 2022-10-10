package co.mkabir.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	//path variable 
	
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		
		return new HelloWorldBean(String.format("Hello World, %s", name));
		
	}
	
	
	
}
