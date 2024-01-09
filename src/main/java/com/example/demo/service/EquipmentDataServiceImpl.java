package com.example.demo.service;

// EquipmentDataService.java
import com.example.demo.bean.EquipmentData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentDataServiceImpl implements EquipmentDataService {



    private final EquipmentDataRepository equipmentDataRepository;
    private final EntityManager entityManager;

    public void saveEquipmentData(EquipmentData equipmentData) {
        equipmentDataRepository.save(equipmentData);
    }

    public List<EquipmentData> getAllEquipmentData() {
        return equipmentDataRepository.findAll();
    }
    @Override
    public List<EquipmentData> getEquipmentDataByEquipCodeSortedByDateDesc(String equipCode) {
        return equipmentDataRepository.findByEquipCodeOrderByDateDesc(equipCode);
    }

    @Override
    public Page<EquipmentData> getEquipmentDataByEquipCodeSortedByDateDesc(String equipCode, Pageable pageable) {
        return equipmentDataRepository.findByEquipCodeOrderByDateDesc(equipCode, pageable);
    }

    @Override
    public Page<EquipmentData> findByEquipCodeAndValueGreaterThanOrderByDateDesc(String equipCode, Double value, Pageable pageable) {
        return equipmentDataRepository.findByEquipCodeAndValueGreaterThanOrderByDateDesc( equipCode,  value,  pageable);
    }
    @Override
    public List<EquipmentData> findByCustomSql(String customSql) {
        Query query = entityManager.createNativeQuery(customSql, EquipmentData.class);
        return query.getResultList();
    }

    public List<EquipmentData> findByCustomSql() {
        return equipmentDataRepository.findByCustomSql();
    }
}
