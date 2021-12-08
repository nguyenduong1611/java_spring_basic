package com.example.trainningspring.btvn.repository.database;

import com.example.trainningspring.btvn.model.entity.KhaiBao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KhaiBaoDB extends JpaRepository<KhaiBao, Integer> {
    @Query(value = "select * from khai_bao k where sdt=?1", nativeQuery = true)
    List<KhaiBao> findBySDT(String sdt);
}
