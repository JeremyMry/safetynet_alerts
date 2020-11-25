package com.safetynet.alerts.service;

import com.safetynet.alerts.model.PersonInfo;

import java.util.List;

public interface IPersonInfoService {

    List<PersonInfo> getPersonInformation(String firstName, String lastName);
}
