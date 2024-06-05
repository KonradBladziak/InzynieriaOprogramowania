package vod.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vod.model.Tanker;

import java.util.List;

public class VodServiceMain {

    public static void main(String[] args) {
        System.out.println("Let's find tankers!");

        ApplicationContext context = new AnnotationConfigApplicationContext("vod");
        TankerService service = context.getBean(TankerService.class);
        TankerService service2 = context.getBean(TankerService.class);

        // service use
        List<Tanker> tankers = service.getAllTankers();
        System.out.println(tankers.size() + " tankers found:");
        tankers.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("foo string: " + foo);
    }
}