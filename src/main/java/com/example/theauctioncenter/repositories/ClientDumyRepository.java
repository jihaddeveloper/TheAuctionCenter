package com.example.theauctioncenter.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.theauctioncenter.entities.ClientDumyEntity;

@Repository
@Transactional
public interface ClientDumyRepository extends JpaRepository<ClientDumyEntity, Long> {
	
	public ClientDumyEntity findByName(String name);
	
	public List<ClientDumyEntity> findAll();

}
