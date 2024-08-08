package P1Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("models") //This tells Spring Boot to look in the model package for DB entities
@ComponentScan({"P1Demo", "models", "DAOs", "services", "Controllers", "resources"}) //This tells Spring Boot to look for beans in the entire com.rev package
@EnableJpaRepositories("DAOs") //This allows us to use JpaRepository in our DAOs
public class P1Application {

    public static void main(String[] args) {
        SpringApplication.run(P1Application.class, args);
    }

}

