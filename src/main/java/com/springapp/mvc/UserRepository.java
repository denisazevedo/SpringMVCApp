package com.springapp.mvc;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Define a Spring repository for the user entity.
 *
 * Created by denisazevedo on 09/01/2014.
 */
public interface UserRepository extends JpaRepository<User, Long> {


}
