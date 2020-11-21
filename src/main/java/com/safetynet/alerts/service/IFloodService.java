package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Household;

import java.util.List;

public interface IFloodService {

    List<Household> getHouseholdByStationAddress(String stationNumber);
}
