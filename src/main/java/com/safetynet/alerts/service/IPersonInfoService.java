package com.safetynet.alerts.service;

import com.safetynet.alerts.model.PersonInfo;

public interface IPersonInfoService {

    PersonInfo getPersonInformation(String firstName, String lastName);
}
