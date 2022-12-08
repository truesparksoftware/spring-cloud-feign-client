package com.code;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<Mobile, Integer>{
	public Optional<Mobile> findById(Integer id);
	public List<Mobile> findAll();
}
