package wordroot.wr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("wordroot.wr.Mapper")
@EnableSwagger2
public class WrApplication {

	public static void main(String[] args) {
		SpringApplication.run(WrApplication.class, args);
	}

}
