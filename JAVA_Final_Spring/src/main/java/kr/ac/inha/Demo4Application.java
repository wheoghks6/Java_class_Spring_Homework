package kr.ac.inha;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"kr.ac.inha.mapper"})
public class Demo4Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo4Application.class, args);
    }

}
