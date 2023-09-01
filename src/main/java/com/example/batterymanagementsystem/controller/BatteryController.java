package com.example.batterymanagementsystem.controller;
import com.example.batterymanagementsystem.model.BatteryData;
import com.example.batterymanagementsystem.service.BatteryDataJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BatteryController {
    @Autowired
    public BatteryDataJpaService batteryDataJpaService;

    //For user to retrieve battery info
    @GetMapping("/batteries")
    public ArrayList<BatteryData> getBatteryById(@RequestParam int batteryId){
        return  batteryDataJpaService.getBatteryById(batteryId);
    }

    //For user to retrieve battery specific info
    @GetMapping("/battery-specific-info")
    public String getBatterySpecificInfo(@RequestParam int batteryId, @RequestParam String specificData){
        return batteryDataJpaService.getBatterySpecificInfo(batteryId, specificData);
    }

    //For batteries to add data every minute
    @PostMapping("/batteries")
    public BatteryData addBatteryData(@RequestBody BatteryData batteryData){
        return batteryDataJpaService.addBatteryData(batteryData);
    }

    //For user to retrieve battery specific time info
    @GetMapping("/battery-specific-time-info")
    public ArrayList<String> getBatterySpecificTimeInfo(
            @RequestParam int batteryId,
            @RequestParam String specificData,
            @RequestParam String startDateTime,
            @RequestParam String endDateTime){
            return batteryDataJpaService.getBatterySpecificTimeInfo(batteryId, specificData, startDateTime, endDateTime);
    }

    //For user to retrieve battery averages
    @GetMapping("/battery-averages")
    public Map<String, Double> getBatteryAverages(@RequestParam int batteryId) {
        Map<String, Double> averages = new HashMap<>();

        double currentAverage = batteryDataJpaService.calculateAverage(batteryId, "current");
        double voltageAverage = batteryDataJpaService.calculateAverage(batteryId, "voltage");
        double temperatureAverage = batteryDataJpaService.calculateAverage(batteryId, "temperature");
        averages.put("currentAverage", currentAverage);
        averages.put("voltageAverage", voltageAverage);
        averages.put("temperatureAverage", temperatureAverage);

        return averages;
    }
}
