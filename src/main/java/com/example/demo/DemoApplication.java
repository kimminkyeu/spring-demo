package com.example.demo;

import com.example.demo.annotation.MyAnnotationtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@MyAnnotationtest(message = "hello")
@SpringBootApplication
public class DemoApplication {
  public static void main(String[] args) {

    // 1. DemoApplication.class 안에 모든 Class 구현체가 들어있어야 한다.
    //    그래야 Spring 쪽에서 이 정보들을 이용해서 알아서 연결시키니까.

    // NOTE: 아래 objT는 어떤 정보를 받아오는가..?
    Object objT = DemoApplication.class; // 보니까 class의 선언 데이터를 조회할 수 있다.
    //    System.out.println(objT);

    // NOTE: 아래 함수는 어떤 기능이 실행되는가...?
    ConfigurableApplicationContext springContext =
        SpringApplication.run(DemoApplication.class, args);
    //    System.out.println(springContext);

    // NOTE: 아래 코드는 어떤 기능을 하는가?
    Object obj = springContext.getBean("dataSource");
    //    System.out.println(obj);

    // 2. 보면 Run을 실행하고 여기의 코드가 바로 실행 되는거 보니, SpringApplication.run은 별도 쓰레드에서 실행되는 것 같다.
    //    즉 main에서 class의 소스들을 전부 넘겨주고 끝내는 것.
  }
}
