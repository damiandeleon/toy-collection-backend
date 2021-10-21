package com.company.collection.controller;

import com.company.collection.dao.ToyDao;
import com.company.collection.dto.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/toys")
public class toyController {

    @Autowired
    private ToyDao toyDao;


    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Toy createToy(@RequestBody Toy toy){
        System.out.println("CREATING TOY");
        toyDao.save(toy);
        return toy;
    }
}
