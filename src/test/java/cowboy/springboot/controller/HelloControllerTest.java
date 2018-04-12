package cowboy.springboot.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import cowboy.springboot.EurekaClientApp;


@RunWith(SpringJUnit4ClassRunner.class)//引入Spring 对JUnit4的支持
@SpringBootTest(classes = EurekaClientApp.class)//指定Spring Boot 的启动类
@WebAppConfiguration //开启Web 应用配置，用于模拟ServletContext
public class HelloControllerTest {

	private MockMvc mvc; //用于模拟调用controller 的接口发起请求
	
	/**
	 * 初始化helloController 的模拟器
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}
	/**
	 * 执行测试用例
	 * @throws Exception
	 */
	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello")  //perform 提交请求
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
	}
}
