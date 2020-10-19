package com.example.theauctioncenter.repositories;

/*
 * Author: Jihad
 * Date: 31/07/2018
 * About: Role Repository Interface
 * */

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.theauctioncenter.entities.RoleEntity;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<RoleEntity, String> {

}
