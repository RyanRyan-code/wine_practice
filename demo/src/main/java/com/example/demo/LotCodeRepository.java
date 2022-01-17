package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotCodeRepository extends JpaRepository<LotCode,Integer> {

    public LotCode findLotCodeByLotCode(String lc);

}
