package cowboy.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cowboy.hello_service_api.model.User;
import cowboy.hello_service_api.service.HelloService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class HelloController4Api implements HelloService{

	@Override
	@ApiOperation(value="say hello", notes="无参调用")
	public String hello() {
		System.out.println("eureka client say hello");
		return "Hello World";
	}

	@ApiOperation(value="获取信息", notes="根据名称获取")
	@ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "String")
	@Override
	public String hello(@RequestParam("name") String name) {
		System.out.println("hello1");
		return "Hello "+name;
	}

	@Override
	public String HelloById(@RequestParam("id") Integer id) {
		System.out.println("hello2");
		return "Hello by Id"+id;
	}

	@ApiOperation(value="获取用户列表", notes="根据请求头部信息获取")
	@ApiImplicitParams({
	@ApiImplicitParam(name = "name", value = "用户名称", required = true, dataType = "User"),
	@ApiImplicitParam(name = "age", value = "用户年龄", required = true, dataType = "User")})
	@Override
	public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
		System.out.println("hello3");
		return new User(name,age);
	}

	@ApiOperation(value="创建用户", notes="根据User对象创建用户")
	@ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
	@Override
	public String hello(User user) {
		System.out.println("hello4");
		return "name="+user.getName()+",age="+user.getAge(); 
	}

	@Override
	public User getUserByName(@PathVariable("name") String name) {
		System.out.println("getByName");
		return new User(name,13);
	}

}
