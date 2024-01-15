package com.platzi.pizza.persistence.audit;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

public class AuditPizzaListener {
    private PizzaEntity currentValue;

    @PostLoad
    public void onPostLoadPersist(PizzaEntity entity) {
        System.out.println("Post Load");
        currentValue = SerializationUtils.clone(entity);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(PizzaEntity entity) {
        System.out.println("Post Persist and Post Update");
//        System.out.println("Old Value" + currentValue.toString());
        System.out.println("new value" + entity.toString());
    }

    @PreRemove
    public void onProRemovePersist(PizzaEntity entity) {
        System.out.println(entity.toString());
    }
}
