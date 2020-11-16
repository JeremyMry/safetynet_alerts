package com.safetynet.alerts.service.crud;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.crud.Firestation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class FirestationService {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DataContainer dataContainer;

    public List<Firestation> add(Firestation firestation) {
        List<Firestation> listFirestations = dataContainer.getFirestations();
        listFirestations.add(firestation);
        logger.info("zzz");
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
        logger.info("zzz");
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
        logger.info("zzz");
        return listFirestations;
    }
}