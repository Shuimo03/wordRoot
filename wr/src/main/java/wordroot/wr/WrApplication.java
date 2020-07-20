package wordroot.wr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("wordroot.wr.Mapper")
public class WrApplication {

	public static void main(String[] args) {
		SpringApplication.run(WrApplication.class, args);
	}

}
