package com.safetynet.alerts.service;

import com.safetynet.alerts.model.DataContainer;
import com.safetynet.alerts.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private DataContainer dataContainer;

    public MedicalRecordService(DataContainer dc) {
        this.dataContainer = dc;
    }

    public List<MedicalRecord> add(MedicalRecord medicalrecord) {
        List<MedicalRecord> listMedicalrecords = dataContainer.getMedicalrecords();
        listMedicalrecords.add(medicalrecord);
        return listMedicalrecords;

    }

    public List<MedicalRecord> update(MedicalRecord medicalrecord) {
        String firstname = medicalrecord.getFirstName();
        String lastName = medicalrecord.getLastName();

        List<MedicalRecord> listmedicalrecords = dataContainer.getMedicalrecords();

        for (MedicalRecord mr : listmedicalrecords) {
            // suppose that firstname and lastname can not changed
            if (mr.getFirstName().equals(firstname) && mr.getLastName().equals(lastName)) {
                mr.setBirthdate(medicalrecord.getBirthdate());
                mr.setMedications(medicalrecord.getMedications());
                mr.setAllergies(medicalrecord.getAllergies());
            }
        }
        return listmedicalrecords;

    }

    public List<MedicalRecord> delete(String firstName, String lastName) {
        List<MedicalRecord> listmedicalrecords = dataContainer.getMedicalrecords();
        Iterator<MedicalRecord> it = listmedicalrecords.iterator();

        while (it.hasNext()) {
            // use a combinaison of firstname and lastname for id
            MedicalRecord mr = it.next();
            if (mr.getFirstName().equals(firstName) && mr.getLastName().equals(lastName)) {
                it.remove();
            }

        }
        return listmedicalrecords;
    }

}
