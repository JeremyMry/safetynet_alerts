package com.safetynet.alerts.service;

import com.safetynet.alerts.model.PersonInfo;

public interface IPersonInfoService {

    PersonInfo getPersonInformations(String firstName, String lastName);
}
