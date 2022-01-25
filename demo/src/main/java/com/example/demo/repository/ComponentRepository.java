package com.example.demo.repository;

import com.example.demo.entity.WineComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends JpaRepository<WineComponent,Integer>{






}
