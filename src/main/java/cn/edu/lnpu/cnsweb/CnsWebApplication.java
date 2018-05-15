package cn.edu.lnpu.cnsweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:xml/spring-config.xml")
public class CnsWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(CnsWebApplication.class, args);
  }
}