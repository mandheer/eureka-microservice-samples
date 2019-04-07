package in.pabreja;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


/**
 * TODO this is incomplete
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplicationLbSample {

    private static final Logger log = LoggerFactory.getLogger(EurekaClientApplicationLbSample.class);

    public static void main(String[] args){
        SpringApplication.run(EurekaClientApplicationLbSample.class,args);
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
