package com.banditos.hibernateentities.loader;

import com.banditos.hibernateentities.model.Child;
import com.banditos.hibernateentities.model.GrandChild;
import com.banditos.hibernateentities.model.Parent;
import com.banditos.hibernateentities.repositories.ChildRepository;
import com.banditos.hibernateentities.repositories.GrandChildRepository;
import com.banditos.hibernateentities.repositories.ParentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

/**
 * @author kkharitonov
 * @date 24.08.2018
 */
@Service
public class DataLoader implements ApplicationRunner {

    private ParentRepository parentRepository;
    private ChildRepository childRepository;
    private GrandChildRepository grandChildRepository;

    private static final Logger logger = LogManager.getLogger(DataLoader.class);

    @Autowired
    public DataLoader(ParentRepository parentRepository, ChildRepository childRepository, GrandChildRepository grandChildRepository) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
        this.grandChildRepository = grandChildRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Parent p1 = new Parent();
        p1.setName("parent1");
        Parent p2 = new Parent();
        p2.setName("parent2");

        Child c11 = new Child();
        c11.setName("child11");
        c11.setParent(p1);
        Child c12 = new Child();
        c12.setName("child12");
        c12.setParent(p1);


        GrandChild gc111 = new GrandChild(c11, "gc111");
        GrandChild gc112 = new GrandChild(c11, "gc112");

        parentRepository.save(p1);
        parentRepository.save(p2);
        childRepository.save(c11);
        childRepository.save(c12);
        grandChildRepository.save(gc111);
        grandChildRepository.save(gc112);
    }
}
