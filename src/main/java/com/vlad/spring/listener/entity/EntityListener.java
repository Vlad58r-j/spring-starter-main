package com.vlad.spring.listener.entity;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {

    @EventListener(condition = "#p0.accessType.name() == 'READ'")// #root.args = #p
    @Order(10)
    public void acceptEvent(EntityEvent event) {
        System.out.println("Entity: " + event);
    }
}
