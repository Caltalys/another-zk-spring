package vn.tcx.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringZkDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZkDemoApplication.class, args);
	}

}
