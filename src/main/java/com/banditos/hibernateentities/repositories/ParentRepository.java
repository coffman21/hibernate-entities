package com.banditos.hibernateentities.repositories;

import com.banditos.hibernateentities.model.Parent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author kkharitonov
 * @date 24.08.2018
 */
@Repository
@RepositoryRestResource
public interface ParentRepository extends CrudRepository<Parent, Long> {

    @Query(value = "from Parent p left join fetch p.children c left join fetch c.grandChildren")
    Set<Parent> findAll();
}
