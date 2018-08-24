package com.banditos.hibernateentities.loader;

import com.banditos.hibernateentities.repositories.ChildRepository;
import com.banditos.hibernateentities.repositories.GrandChildRepository;
import com.banditos.hibernateentities.repositories.ParentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kkharitonov
 * @date 24.08.2018
 */
@Service
public class DataLoader {

    ParentRepository parentRepository;
    ChildRepository childRepository;
    GrandChildRepository grandChildRepository;

    private static final Logger logger = LogManager.getLogger(DataLoader.class);

    @Autowired
    public DataLoader(ParentRepository parentRepository, ChildRepository childRepository, GrandChildRepository grandChildRepository) {
        this.parentRepository = parentRepository;
        this.childRepository = childRepository;
        this.grandChildRepository = grandChildRepository;
    }

    private void init() {

    }

}
