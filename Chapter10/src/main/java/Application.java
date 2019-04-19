import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SpringBootApplication表示是一个springboot程序入口
 * ComponentScan扫描哪个包内的注解
 */
@SpringBootApplication
@ComponentScan("com.wangwei")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
