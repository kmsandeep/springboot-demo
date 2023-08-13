package com.sandeep.springbootdemo.dao;

import com.sandeep.springbootdemo.annotation.Log;
import com.sandeep.springbootdemo.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Log
    public List<User> findByRole(@Param("role") String role);
}
