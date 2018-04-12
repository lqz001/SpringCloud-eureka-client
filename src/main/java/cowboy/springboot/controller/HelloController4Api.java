package cowboy.springboot.controller;

import org.springframework.web.bind.annotation.RestController;

import cowboy.hello_service_api.model.User;
import cowboy.hello_service_api.service.HelloService;

@RestController
public class HelloController4Api implements HelloService{

	@Override
	public String hello() {
		System.out.println("eureka client say hello");
		return "Hello World";
	}

	@Override
	public String hello(String name) {
		System.out.println("hello1");
		return "Hello "+name;
	}

	@Override
	public String HelloById(Integer id) {
		System.out.println("hello2");
		return "Hello by Id"+id;
	}

	@Override
	public User hello(String name, Integer age) {
		System.out.println("hello3");
		return new User(name,age);
	}

	@Override
	public String hello(User user) {
		System.out.println("hello4");
		return "name="+user.getName()+",age="+user.getAge(); 
	}

	@Override
	public User getUserByName(String name) {
		System.out.println("getByName");
		return new User(name,13);
	}

}
