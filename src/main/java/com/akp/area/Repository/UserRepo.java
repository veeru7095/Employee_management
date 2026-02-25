package com.akp.area.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akp.area.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
