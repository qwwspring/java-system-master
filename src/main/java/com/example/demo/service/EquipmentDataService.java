package com.example.demo.service;

import com.example.demo.bean.EquipmentData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipmentDataService {
    void saveEquipmentData(EquipmentData equipmentData);
    List<EquipmentData> getAllEquipmentData();
    List<EquipmentData> getEquipmentDataByEquipCodeSortedByDateDesc(String equipCode);
    List<EquipmentData> findByCustomSql(String customSql);
    List<EquipmentData> findByCustomSql();
    Page<EquipmentData> getEquipmentDataByEquipCodeSortedByDateDesc(String equipCode, Pageable pageable);
    Page<EquipmentData> findByEquipCodeAndValueGreaterThanOrderByDateDesc(String equipCode, Double value, Pageable pageable);

}
