package com.restExemple.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompagnieDAORepository  extends JpaRepository<AirCompagnie, Long>{
	public  List<AirCompagnie> findByNomCompagnie(String name);
}
