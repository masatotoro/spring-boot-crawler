package jp.gihyo.wdpress.advance.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(
    basePackages = { //
      "jp.gihyo.wdpress.advance.scheduling", //
      "jp.gihyo.wbpress.advance.lib.activemq"
    })
public class SchedulingApplication {

  public static void main(String[] args) {
    SpringApplication.run(SchedulingApplication.class, args);
  }
}
