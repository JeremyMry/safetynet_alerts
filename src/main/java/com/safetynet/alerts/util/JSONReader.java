package com.safetynet.alerts.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.model.Model;

import java.io.File;

public class JSONReader {

    public Model readJSON() {

        Model obj = new Model();
        ObjectMapper mapper = new ObjectMapper();
        try {
            obj = mapper.readValue(new File("./src/main/resources/data.json"), Model.class);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
