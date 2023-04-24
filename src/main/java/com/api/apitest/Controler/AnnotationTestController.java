package com.api.apitest.Controler;

import com.api.apitest.Services.AnnotationTestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AnnotationTestController {

    @Autowired
    AnnotationTestServices annotationTestServices;

    @RequestMapping(value = "/test1/{id}",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    public String test(@PathVariable("id") String id, @RequestBody String r){
        return annotationTestServices.ReadFile(id);
    }

    @RequestMapping(value = "/test1/{id}/{id2}",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    public String test2(@PathVariable("id") String id, @PathVariable("id2") String id2, @RequestBody String r){
        return r;
    }
}
