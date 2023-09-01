package com.example.batterymanagementsystem.repository;

import com.example.batterymanagementsystem.model.BatteryData;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatteryDataJpaRepository extends JpaRepository<BatteryData, Integer> {
    List<BatteryData> findAllByBatteryId(int batteryId);
}
