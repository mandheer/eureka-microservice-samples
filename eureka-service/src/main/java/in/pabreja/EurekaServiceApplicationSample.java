package in.pabreja;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServiceApplicationSample {

    private static final Logger log = LoggerFactory.getLogger(EurekaServiceApplicationSample.class);

    public static void main(String[] args){
        SpringApplication.run(EurekaServiceApplicationSample.class,args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            log.info("Let's inspect the beans provided by spring boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String b:beanNames) {
                log.debug(b);
            }
        };
    }
}
