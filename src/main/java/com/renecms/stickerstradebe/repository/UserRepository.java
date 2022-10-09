package com.renecms.stickerstradebe.repository;

import com.renecms.stickerstradebe.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
}
