package com.api.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.notes.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
