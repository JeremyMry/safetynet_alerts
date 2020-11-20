package com.safetynet.alerts.service;

import com.safetynet.alerts.model.Firestation;
import com.safetynet.alerts.model.StationCoverage;

import java.util.List;

public interface IFireStationService {

    List<Firestation> add(Firestation firestation);

    List<Firestation> update(Firestation firestation);

    List<Firestation> delete(String address);

    StationCoverage getPeoplesCoverageStation(String stationNumber);

    List<String> getFirestationAddressByStationNumber(String stationNumber);

    List<String> getFirestationStationNumberByAddress(String address);
}
