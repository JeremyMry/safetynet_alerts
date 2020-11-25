package com.safetynet.alerts.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alerts.model.DataContainer;
import java.io.File;

public class JSONReaderUtil {

    public DataContainer readJSON() {

        DataContainer obj = new DataContainer();
        ObjectMapper mapper = new ObjectMapper();
        try {
            //read the json file stored in resources and parse it into the DataContainer model
            obj = mapper.readValue(new File("./src/main/resources/data.json"), DataContainer.class);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
