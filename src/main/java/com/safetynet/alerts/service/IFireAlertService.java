package com.safetynet.alerts.service;

import com.safetynet.alerts.model.FireAlert;

import java.util.List;

public interface IFireAlertService {

    List<FireAlert> getPersonsByAddress(String address);
}
