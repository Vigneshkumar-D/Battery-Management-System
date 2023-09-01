package com.example.batterymanagementsystem.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "battery_data")
public class BatteryData {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;
        @Column(name = "battery_id")
        private int batteryId;
        @Column(name = "current")
        private Double current;

        @Column(name = "voltage")
        private Double voltage;
        @Column(name = "temperature")
        private Double temperature;
        @Column(name = "timestamp")
        private LocalDateTime timestamp;

    public BatteryData() {
    }

    public BatteryData(int batteryId, Double current, Double voltage, Double temperature, LocalDateTime timestamp) {
        this.batteryId = batteryId;
        this.current = current;
        this.voltage = voltage;
        this.temperature = temperature;
        this.timestamp = timestamp;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBatteryId() {
        return batteryId;
    }

    public void setBatteryId(int batteryId) {
        this.batteryId = batteryId;
    }

    public Double getCurrent() {
        return current;
    }

    public void setCurrent(Double current) {
        this.current = current;
    }

    public Double getVoltage() {
        return voltage;
    }

    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void getTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

