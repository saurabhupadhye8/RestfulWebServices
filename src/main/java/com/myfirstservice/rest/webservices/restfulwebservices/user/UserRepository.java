package com.myfirstservice.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myfirstservice.rest.webservices.restfulwebservices.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
