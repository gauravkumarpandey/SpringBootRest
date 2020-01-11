package com.example.restwebservice.helloword;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping(method =  RequestMethod.GET, path = "hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "hello-world-bean")
	public HelloWorld getHelloWorldBean() {
		return new HelloWorld("Hello World");
	}
	
	@GetMapping(path = "hello-world/path-param/{name}")
	public HelloWorld getHelloWorldPathParam(@PathVariable String name) {
		return new HelloWorld(String.format("Hello World %s", name));
	}

}
