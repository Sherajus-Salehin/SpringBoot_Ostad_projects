package com.example.Assignment15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Assignment15.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
