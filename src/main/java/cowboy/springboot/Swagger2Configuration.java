package cowboy.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

	@Bean
	public Docket buildHelloApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("HELLO").apiInfo(buildApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("cowboy.springboot.controller"))
				// 要扫描的API(Controller)基础包
				.paths(PathSelectors.any()).build();
	}
	

	private ApiInfo buildApiInfo() {
		return new ApiInfoBuilder().title("Spring Boot中使用Swagger2构建RESTful APIs")
				.description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
				.termsOfServiceUrl("http://blog.didispace.com/").contact("北京中科江南信息技术股份有限公司").version("1.0").build();
	}
}
