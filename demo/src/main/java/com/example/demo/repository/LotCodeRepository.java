package com.example.demo.repository;

import com.example.demo.model.LotCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotCodeRepository extends JpaRepository<LotCode,String> {



}
