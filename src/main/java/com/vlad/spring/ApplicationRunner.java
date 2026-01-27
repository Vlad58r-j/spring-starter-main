package com.vlad.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {

    public static void main(String[] args) {
        var context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(context.getBeanDefinitionCount());
        System.out.println(context.getBean("pool1"));
    }
}


// not spring boot ->
//        String value = "hello";
//        System.out.println(String.class.isAssignableFrom(value.getClass()));
//        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
//        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));
//
//        try (var context = new AnnotationConfigApplicationContext()) {
//            context.register(ApplicationConfiguration.class);
//            context.getEnvironment().setActiveProfiles("web", "prod");
//            context.refresh();//активирует жизненный цикл бинов
//
//            var connectionPool = context.getBean("pool1", ConnectionPool.class);//-> correct
//            System.out.println(connectionPool);
//
//            var companyService = context.getBean(CompanyService.class);
//            System.out.println(companyService.findById(1));
//        }
//    }


//        System.out.println(context.getBean(ConnectionPool.class)); -> not correct

//        var container = new Container();
//        var connectionPool = new ConnectionPool();
//        var userRepository = new UserRepository(connectionPool);
//        var companyRepository = new CompanyRepository(connectionPool);
//        var userService = new UserService(userRepository, companyRepository);
//        var userService = container.get(UserService.class);