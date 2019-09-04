package com.zcq.weShould.repository;

import com.zcq.weShould.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
