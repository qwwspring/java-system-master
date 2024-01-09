package com.example.demo.service;
import com.example.demo.bean.EquipmentData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentDataRepository extends JpaRepository<EquipmentData, Long> {
    List<EquipmentData> findByEquipCodeOrderByDateDesc(String equipCode);
    Page<EquipmentData> findByEquipCodeOrderByDateDesc(String equipCode, Pageable pageable);

    Page<EquipmentData> findByEquipCodeAndValueGreaterThanOrderByDateDesc(String equipCode, Double value, Pageable pageable);
    @Query(value = "SELECT * FROM new_view", nativeQuery = true)
    List<EquipmentData> findByCustomSql();
}
