package cowboy.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cowboy.springboot.bo.User;

@RestController
//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用,可以不再去写 @ResponseBody
public class HelloController {
	
	@RequestMapping("/hello")
	String hello(){
		System.out.println("eureka client say hello");
		return "Hello World";
	}
	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	String hello(@RequestParam String name){
		//注意：@@RequestParam、 @RequestHeader 是指定参数名称的注解，在SpingMVC 中，这些注解会根据参数名作为value 的默认值
		//,但是在Feign 中，绑定参数必须通过value 属性来指定具体的参数名，否则抛出IllegalStateException异常
		System.out.println("hello1");
		return "Hello "+name;
	}
	
	@GetMapping("/hello2")  //等同@RequestMapping 设置method 为GET, @PostMapping,@DeleteMapping,@PatchMapping
	String HelloById(@RequestParam(value="id",required=false) Integer id){
		System.out.println("hello2");
		return "Hello by Id"+id;
	}
	
	/**
	 * @param name
	 * @param age
	 * @return
	 */
	@GetMapping(value="/hello3")   
	User hello(@RequestHeader String name,@RequestHeader Integer age){
		//@RequestHeader:获取浏览器头信息：限制请求头中必须有User-Agent
		System.out.println("hello3");
		return new User(name,age);
	}
	
	@RequestMapping(value="/hello4",method=RequestMethod.POST)
	public String hello(@RequestBody User user){
		//1. @RequestBody  接收前台json 串, 
		//2. @RequestParam 接收json 对象
		System.out.println("hello4");
		return "name="+user.getName()+",age="+user.getAge(); 
	}
	
	@GetMapping(value="/user/getByName/{name}")
	public User getUserByName(@PathVariable("name") String name){
		System.out.println("getByName");
		return new User(name,13);
	}
}
