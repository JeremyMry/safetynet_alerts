package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.StationCoverage;

import java.util.List;

public interface IFirestationService {

    List<Firestation> add(Firestation firestation);

    List<Firestation> update(Firestation firestation);

    List<Firestation> delete(String address);

    StationCoverage getPersonsCoverageByStationNumber(String stationNumber);

    List<String> getFireStationAddressByStationNumber(String stationNumber);

    List<String> getFireStationStationNumberByAddress(String address);
}
