package Application;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "Location")
public class Application {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(Application.class, args);

    }

}