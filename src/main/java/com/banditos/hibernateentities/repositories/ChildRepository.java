package com.banditos.hibernateentities.repositories;

import com.banditos.hibernateentities.model.Child;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author kkharitonov
 * @date 24.08.2018
 */
@Repository
@RepositoryRestResource
public interface ChildRepository extends CrudRepository<Child, Long> {
}
