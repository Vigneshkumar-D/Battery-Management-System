package com.example.batterymanagementsystem.service;

import com.example.batterymanagementsystem.model.BatteryData;
import com.example.batterymanagementsystem.repository.BatteryDataJpaRepository;
import com.example.batterymanagementsystem.repository.BatteryDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
@Service
public class BatteryDataJpaService implements BatteryDataRepository {
    @Autowired
    private BatteryDataJpaRepository batteryDataJpaRepository;

    @Override
    public ArrayList<BatteryData> getBatteryById(int batteryId) {
        try {
            List<BatteryData> batteryDataList = batteryDataJpaRepository.findAllByBatteryId(batteryId);
            ArrayList<BatteryData> batteryDataArr = new ArrayList<>(batteryDataList);
            return batteryDataArr;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public String getBatterySpecificInfo(int batteryId, String specificData) {
        try {
            BatteryData batteryData = batteryDataJpaRepository.findById(batteryId).orElse(null);
            if (batteryData != null) {
                switch (specificData.toLowerCase()) {
                    case "current":
                        return String.valueOf(batteryData.getCurrent());
                    case "voltage":
                        return String.valueOf(batteryData.getVoltage());
                    case "temperature":
                        return String.valueOf(batteryData.getTemperature());
                    case "time":
                        return batteryData.getTimestamp().toString();
                    default:
                        throw new IllegalArgumentException("Invalid parameter");
                }
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Battery data not found");
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred");
        }
    }

    @Override
    public BatteryData addBatteryData(BatteryData batteryData) {
        try {
            batteryDataJpaRepository.save(batteryData);
        } catch (DataAccessException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to save battery data", e);
        }
        return batteryData;
    }

    @Override
    public ArrayList<String> getBatterySpecificTimeInfo(int batteryId, String specificData, String startTime, String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);

        List<BatteryData> batteryDataList = batteryDataJpaRepository.findAllByBatteryId(batteryId);
        ArrayList<String> specificDataList = new ArrayList<>();

        for (BatteryData batteryData : batteryDataList) {
            LocalDateTime dataTime = batteryData.getTimestamp();
            if (dataTime.isAfter(startDateTime) && dataTime.isBefore(endDateTime)) {
                switch (specificData.toLowerCase()) {
                    case "current":
                        specificDataList.add(String.valueOf(batteryData.getCurrent()));
                        break;
                    case "voltage":
                        specificDataList.add(String.valueOf(batteryData.getVoltage()));
                        break;
                    case "temperature":
                        specificDataList.add(String.valueOf(batteryData.getTemperature()));
                        break;
                    case "time":
                        specificDataList.add(batteryData.getTimestamp().toString());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid parameter");
                }
            }
        }
        return specificDataList;

    }

        public double calculateAverage(int batteryId, String specificData) {
            List<BatteryData> batteryDataList = batteryDataJpaRepository.findAllByBatteryId(batteryId);

            if (batteryDataList.isEmpty()) {
                return 0.0;
            }

            double sum = batteryDataList.stream()
                    .mapToDouble(data -> getValueByParameter(data, specificData))
                    .sum();
            return sum / batteryDataList.size();
        }

        private double getValueByParameter(BatteryData data, String specificData) {
            switch (specificData.toLowerCase()) {
                case "current":
                    return data.getCurrent();
                case "voltage":
                    return data.getVoltage();
                case "temperature":
                    return data.getTemperature();
                default:
                    throw new IllegalArgumentException("Invalid parameter: " + specificData);
            }
    }


}