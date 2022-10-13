package de.sva.bootcamp.devops.springdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, String> {
    List<User> findAll();
}
