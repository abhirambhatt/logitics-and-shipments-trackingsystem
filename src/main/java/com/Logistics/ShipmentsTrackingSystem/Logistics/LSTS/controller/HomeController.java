package com.Logistics.ShipmentsTrackingSystem.Logistics.LSTS.controller;

import lombok.Data;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Logistics & Shipment Tracking API is running successfully";
    }
}
