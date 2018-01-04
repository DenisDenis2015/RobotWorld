package by.rudenko.testproject.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import by.rudenko.testproject.factory.RobotFactory;

/**
 * Project config.
 */
@EnableScheduling
@EnableAutoConfiguration
@ComponentScan(basePackages = {"by.rudenko.testproject"})
@Import({RabbitConfiguration.class, WebSocketConfig.class, RobotFactory.class})
public class SpringBootConfiguration {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootConfiguration.class, args);
    }

    // run embedded server in port 8099.
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            container.setPort(8099);
        });
    }
}
