package com.safetynet.alerts.service;

import com.safetynet.alerts.model.ChildAlert;

import java.util.List;

public interface IChildAlertservice {

    List<ChildAlert> getChildByAddress(String address);
}
