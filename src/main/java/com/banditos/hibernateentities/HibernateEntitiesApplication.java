package com.banditos.hibernateentities;

import com.banditos.hibernateentities.loader.DataLoader;
import com.banditos.hibernateentities.repositories.ChildRepository;
import com.banditos.hibernateentities.repositories.GrandChildRepository;
import com.banditos.hibernateentities.repositories.ParentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateEntitiesApplication extends DataLoader {

    public HibernateEntitiesApplication(ParentRepository parentRepository, ChildRepository childRepository, GrandChildRepository grandChildRepository) {
        super(parentRepository, childRepository, grandChildRepository);
    }

    public static void main(String[] args) {
        SpringApplication.run(HibernateEntitiesApplication.class, args);
    }

}
