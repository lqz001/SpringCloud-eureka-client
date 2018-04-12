package cowboy.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApp 
{
    public static void main( String[] args )
    {
        System.out.println( "Eureka client" );
//        SpringApplication.run(App.class, args);
        new SpringApplicationBuilder(EurekaClientApp.class).web(true).run(args);
    }
}
