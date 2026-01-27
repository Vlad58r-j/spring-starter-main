package com.vlad.spring.config;

import com.vlad.spring.database.pool.ConnectionPool;
import com.vlad.spring.database.repository.UserRepository;
import com.vlad.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.ComponentScan.*;

//@ImportResource("classpath:application.xml") -> для комбинации
@Import(WebConfiguration.class)
@Configuration// not recommend -> (proxyBeanMethods = false) не создает прокси
//@ComponentScan(basePackages = "com.vlad.spring", -> не обязательно использовать, если есть @SpringBootApplication
//        useDefaultFilters = false,
//        includeFilters = {
//                @Filter(type = FilterType.ANNOTATION, value = Component.class),
//                @Filter(type = FilterType.ASSIGNABLE_TYPE, value = CrudRepository.class),
//                @Filter(type = FilterType.REGEX, pattern = "com\\..+Repository")
//        })
public class ApplicationConfiguration {

    @Bean// or @Bean("pool2")
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        return new ConnectionPool(username, 20);
    }

    @Bean
    public ConnectionPool pool3() {
        return new ConnectionPool("test-pool", 20);
    }
//
//    @Bean
//    @Profile("prod|web")
//    // !  &&  ||
//    public UserRepository userRepository2(ConnectionPool pool2) {
//        return new UserRepository(pool2);
//    }
//
//    @Bean
//    public UserRepository userRepository3() {
//        return new UserRepository(pool3());
//    }
}
