package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.Firestation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class FirestationService {

    @Autowired
    private DataContainer dataContainer;

    public FirestationService(DataContainer dc) {
        this.dataContainer = dc;
    }


    public List<Firestation> add(Firestation firestation) {
        List<Firestation> listFirestations = dataContainer.getFirestations();
        listFirestations.add(firestation);
        return listFirestations;

    }

    public List<Firestation> update(Firestation firestation) {

        String address = firestation.getAddress();
        String station = firestation.getStation();
        List<Firestation> listFirestations = dataContainer.getFirestations();

        for (Firestation fs : listFirestations) {
            if (fs.getAddress().equals(address)) {
                fs.setStation(station);
            }
        }
        return listFirestations;
    }

    public List<Firestation> delete(Firestation firestation) {
        List<Firestation> listFirestations = dataContainer.getFirestations();
        Iterator<Firestation> it = listFirestations.iterator();

        String address = firestation.getAddress();

        while (it.hasNext()) {
            Firestation fs = it.next();
            if (fs.getAddress().equals(address)) {
                it.remove();
            }
        }
        return listFirestations;
    }
}