package com.example.theauctioncenter.repositories;

import java.util.List;

/*
 * Author: Jihad
 * Date: 31/07/2018
 * About: User Repository Interface
 * */

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.theauctioncenter.entities.UserEntity;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {

	List<UserEntity> findByNameLike(String name);

}
