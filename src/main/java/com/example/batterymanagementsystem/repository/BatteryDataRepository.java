package com.example.batterymanagementsystem.repository;

import com.example.batterymanagementsystem.model.BatteryData;
import java.util.ArrayList;

public interface BatteryDataRepository {
    ArrayList<BatteryData> getBatteryById(int batteryId);
    String getBatterySpecificInfo(int batteryId, String parameter);
    BatteryData addBatteryData(BatteryData batteryData);
    ArrayList<String> getBatterySpecificTimeInfo(int batteryId, String parameter, String startTime, String endTime);
}
