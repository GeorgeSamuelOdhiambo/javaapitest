package com.api.apitest.Services;

import com.api.apitest.Payload.ActionProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AnnotationTestServices {

    public String ReadFile(String action){
        String url = "Not found";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File jsonFile = new ClassPathResource("urlProperties.json").getFile();
            List<ActionProperties> properties = objectMapper.readValue(jsonFile, new TypeReference<List<ActionProperties>>() {});
            for (ActionProperties property : properties) {
                if(property.getAction().equalsIgnoreCase(action)){
                    url = property.getUrl();
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return url;
    }
}
