package com.optimuminfo.metadata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.optimuminfo.metadata.entity.Modules;

public interface ModuleRepository extends JpaRepository<Modules,Integer> {

}
